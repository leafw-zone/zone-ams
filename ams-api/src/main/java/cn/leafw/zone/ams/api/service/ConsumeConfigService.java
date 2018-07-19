package cn.leafw.zone.ams.api.service;

import cn.leafw.zone.ams.api.dto.ConsumeConfigDto;
import cn.leafw.zone.ams.api.dto.ConsumeConfigQueryDto;

import java.util.List;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/19 15:38
 */
public interface ConsumeConfigService {

    List<ConsumeConfigDto> queryConsumeConfigListByType(ConsumeConfigQueryDto consumeConfigQueryDto);
}
