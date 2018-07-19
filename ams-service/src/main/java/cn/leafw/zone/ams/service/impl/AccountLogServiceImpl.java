package cn.leafw.zone.ams.service.impl;

import cn.leafw.zone.ams.api.dto.*;
import cn.leafw.zone.ams.api.service.AccountLogService;
import cn.leafw.zone.ams.api.service.AccountMainService;
import cn.leafw.zone.ams.api.service.ConsumeConfigService;
import cn.leafw.zone.ams.dao.entity.AccountLog;
import cn.leafw.zone.ams.dao.repository.AccountLogRepository;
import cn.leafw.zone.common.dto.PagerResp;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:47
 */
@Service
public class AccountLogServiceImpl implements AccountLogService {

    @Autowired
    private AccountLogRepository accountLogRepository;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private AccountMainService accountMainService;
    @Autowired
    private ConsumeConfigService consumeConfigService;

    @Override
    public PagerResp<AccountLogDto> queryAccountLogList(AccountLogQueryDto accountLogQueryDto){
        Pageable pageable = PageRequest.of(accountLogQueryDto.getPageNumber() - 1,accountLogQueryDto.getPageSize());
        Page<AccountLog> accountLogPage = accountLogRepository.findAll(new Specification<AccountLog>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<AccountLog> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if(null != accountLogQueryDto){
                    if(StringUtils.isNotEmpty(accountLogQueryDto.getChangeType())){
                        predicateList.add(criteriaBuilder.equal(root.get("change_type").as(String.class),accountLogQueryDto.getChangeType()));
                    }
                }
                Predicate[] p = new Predicate[predicateList.size()];
                return criteriaBuilder.and(predicateList.toArray(p));
            }
        },pageable);

        List<AccountLogDto> accountLogDtoList = new ArrayList<>();
        if(null != accountLogPage){
            for (AccountLog accountLog : accountLogPage.getContent()) {
                AccountLogDto accountLogDto = new AccountLogDto();
                BeanUtils.copyProperties(accountLog,accountLogDto);
                AccountMainQueryDto accountMainQueryDto = new AccountMainQueryDto();
                List<AccountMainDto> accountMainDtoList =  accountMainService.queryAccountMainList(accountMainQueryDto);
                List<String> accountNames = accountMainDtoList.stream().filter(e -> e.getAccountId().equals(accountLog.getAccountId())).map(account -> account.getAccountName()).collect(Collectors.toList());
                if(null != accountNames){
                    accountLogDto.setAccountName(accountNames.get(0));
                }
                if("1".equals(accountLog.getChangeType())){
                    accountLogDto.setChangeTypeName("收入");
                }
                if("2".equals(accountLog.getChangeType())){
                    accountLogDto.setChangeTypeName("支出");
                }
                List<ConsumeConfigDto> consumeConfigDtoList = consumeConfigService.queryConsumeConfigListByType(new ConsumeConfigQueryDto());
                List<String> consumes = consumeConfigDtoList.stream().filter(e -> e.getConsumeId().equals(accountLog.getConsumeType())).map(consume -> consume.getConsumeName()).collect(Collectors.toList());
                if(null != consumes){
                    accountLogDto.setConsumeTypeName(consumes.get(0));
                }
                accountLogDtoList.add(accountLogDto);
            }
        }
        return new PagerResp<>(accountLogPage.getTotalPages(),accountLogQueryDto.getPageNumber(),accountLogQueryDto.getPageSize(),accountLogDtoList);
    }

    @Override
    public void saveAccountLog(AccountLogDto accountLogDto){
        if(null == accountLogDto){
            throw new RuntimeException("账单信息为空");
        }
        AccountLog accountLog = new AccountLog();
        BeanUtils.copyProperties(accountLogDto,accountLog);
        Long id = redisTemplate.opsForValue().increment("accountLog",1L);
        String logId = "ZAMS"+String.format("%09d", id);
        accountLog.setLogId(logId);
        accountLog.setIsDeleted("0");
        accountLog.setCreateTime(new Date());
        accountLog.setUpdateTime(new Date());
        accountLogRepository.save(accountLog);
    }
}
