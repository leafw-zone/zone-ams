package cn.leafw.zone.ams.service.impl;

import cn.leafw.zone.ams.api.dto.AccountLogDto;
import cn.leafw.zone.ams.api.dto.AccountLogQueryDto;
import cn.leafw.zone.ams.api.service.AccountService;
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
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:47
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountLogRepository accountLogRepository;

    @Override
    public PagerResp<AccountLogDto> queryAccountLogList(AccountLogQueryDto accountLogQueryDto){
        Pageable pageable = PageRequest.of(accountLogQueryDto.getPageNumber(),accountLogQueryDto.getPageSize());
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
                accountLogDtoList.add(accountLogDto);
            }
        }
        return new PagerResp<>(accountLogPage.getTotalPages(),accountLogQueryDto.getPageNumber(),accountLogQueryDto.getPageSize(),accountLogDtoList);
    }

    public void addAccountLog(AccountLogDto accountLogDto){

    }
}
