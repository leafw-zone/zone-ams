package cn.leafw.zone.ams.service.impl;

import cn.leafw.zone.ams.api.dto.AccountMainDto;
import cn.leafw.zone.ams.api.dto.AccountMainQueryDto;
import cn.leafw.zone.ams.api.service.AccountMainService;
import cn.leafw.zone.ams.dao.entity.AccountMain;
import cn.leafw.zone.ams.dao.repository.AccountMainRepository;
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
 * @date 2018/7/19 10:50
 */
@Service
public class AccountMainServiceImpl implements AccountMainService{

    @Autowired
    private AccountMainRepository accountMainRepository;

    @Override
    public PagerResp<AccountMainDto> queryAccountMainListByPage(AccountMainQueryDto accountMainQueryDto) {
        Pageable pageable = PageRequest.of(accountMainQueryDto.getPageNumber() - 1, accountMainQueryDto.getPageSize());
        Page<AccountMain> accountMainPage = accountMainRepository.findAll(new Specification<AccountMain>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<AccountMain> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if(null != accountMainQueryDto){
                    if(StringUtils.isNotEmpty(accountMainQueryDto.getAccountName())){
                        list.add(criteriaBuilder.equal(root.get("account_name").as(String.class),accountMainQueryDto.getAccountName()));
                    }
                }
                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        },pageable);

        List<AccountMainDto> accountMainDtoList = new ArrayList<>();
        if(null != accountMainPage){
            for (AccountMain accountMain : accountMainPage.getContent()) {
                AccountMainDto accountMainDto = new AccountMainDto();
                BeanUtils.copyProperties(accountMain,accountMainDto);
                accountMainDtoList.add(accountMainDto);
            }
        }
        return new PagerResp<>(accountMainPage.getTotalPages(),accountMainQueryDto.getPageNumber(),accountMainQueryDto.getPageSize(),accountMainDtoList);
    }

    public List<AccountMainDto> queryAccountMainList(AccountMainQueryDto accountMainQueryDto){
        List<AccountMain> list =  accountMainRepository.findAll();
        List<AccountMainDto> accountMainDtoList = new ArrayList<>();
        for (AccountMain accountMain : list) {
            AccountMainDto accountMainDto = new AccountMainDto();
            BeanUtils.copyProperties(accountMain,accountMainDto);
            accountMainDtoList.add(accountMainDto);
        }
        return  accountMainDtoList;
    }

}
