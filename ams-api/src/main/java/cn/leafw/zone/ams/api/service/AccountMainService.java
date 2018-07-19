package cn.leafw.zone.ams.api.service;

import cn.leafw.zone.ams.api.dto.AccountMainDto;
import cn.leafw.zone.ams.api.dto.AccountMainQueryDto;
import cn.leafw.zone.common.dto.PagerResp;

import java.util.List;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/19 10:49
 */
public interface AccountMainService {

    PagerResp<AccountMainDto> queryAccountMainListByPage(AccountMainQueryDto accountMainQueryDto);

    List<AccountMainDto> queryAccountMainList(AccountMainQueryDto accountMainQueryDto);
}
