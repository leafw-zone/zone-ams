package cn.leafw.zone.ams.api.service;

import cn.leafw.zone.ams.api.dto.AccountLogDto;
import cn.leafw.zone.ams.api.dto.AccountLogQueryDto;
import cn.leafw.zone.common.dto.PagerResp;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:47
 */
public interface AccountService {

    /**
     * 查询账单历史
     * @param accountLogQueryDto
     * @return
     */
    PagerResp<AccountLogDto> queryAccountLogList(AccountLogQueryDto accountLogQueryDto);
}
