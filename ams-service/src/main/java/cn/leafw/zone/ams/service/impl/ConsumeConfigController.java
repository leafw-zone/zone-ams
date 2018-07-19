package cn.leafw.zone.ams.service.impl;

import cn.leafw.zone.ams.api.dto.ConsumeConfigQueryDto;
import cn.leafw.zone.ams.api.service.ConsumeConfigService;
import cn.leafw.zone.common.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/19 15:47
 */
@RestController
@RequestMapping("consumeconfig")
public class ConsumeConfigController {

    @Autowired
    private ConsumeConfigService consumeConfigService;

    @RequestMapping(value = "/queryConsumeConfigList",method = RequestMethod.POST)
    public ResponseDto queryConsumeConfigList(@RequestBody ConsumeConfigQueryDto consumeConfigQueryDto){
        return ResponseDto.instance(consumeConfigService.queryConsumeConfigListByType(consumeConfigQueryDto));
    }
}
