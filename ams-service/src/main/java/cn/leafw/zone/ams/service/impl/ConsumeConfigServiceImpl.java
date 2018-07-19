package cn.leafw.zone.ams.service.impl;

import cn.leafw.zone.ams.api.dto.ConsumeConfigDto;
import cn.leafw.zone.ams.api.dto.ConsumeConfigQueryDto;
import cn.leafw.zone.ams.api.service.ConsumeConfigService;
import cn.leafw.zone.ams.dao.entity.ConsumeConfig;
import cn.leafw.zone.ams.dao.repository.ConsumeConfigRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/19 15:37
 */
@Service
public class ConsumeConfigServiceImpl implements ConsumeConfigService{

    @Autowired
    private ConsumeConfigRepository consumeConfigRepository;

    @Override
    public List<ConsumeConfigDto> queryConsumeConfigListByType(ConsumeConfigQueryDto consumeConfigQueryDto){
        List<ConsumeConfig> consumeConfigs = new ArrayList<>();
        if(null != consumeConfigQueryDto && StringUtils.isNotBlank(consumeConfigQueryDto.getChangeType())){
            consumeConfigs = consumeConfigRepository.findByChangeType(consumeConfigQueryDto.getChangeType());
        }else{
            consumeConfigs = consumeConfigRepository.findAll();
        }
        List<ConsumeConfigDto> consumeConfigDtoList = new ArrayList<>();
        for (ConsumeConfig consumeConfig : consumeConfigs) {
            ConsumeConfigDto consumeConfigDto = new ConsumeConfigDto();
            BeanUtils.copyProperties(consumeConfig,consumeConfigDto);
            consumeConfigDtoList.add(consumeConfigDto);
        }
        return consumeConfigDtoList;
    }
}
