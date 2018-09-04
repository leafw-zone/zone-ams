package cn.leafw.zone.ams.api.service;

import cn.leafw.zone.ams.api.dto.AccountLogDto;
import cn.leafw.zone.ams.api.dto.AccountLogQueryDto;
import cn.leafw.zone.ams.api.dto.AccountLogSumDto;
import cn.leafw.zone.common.dto.PagerResp;

import java.util.List;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:47
 */
public interface AccountLogService {

    /**
     * 查询账单历史
     * @param accountLogQueryDto
     * @return
     */
    PagerResp<AccountLogDto> queryAccountLogList(AccountLogQueryDto accountLogQueryDto);

    void saveAccountLog(AccountLogDto accountLogDto);

    List<AccountLogSumDto> sumAccountLog(AccountLogQueryDto accountLogQueryDto);
}
