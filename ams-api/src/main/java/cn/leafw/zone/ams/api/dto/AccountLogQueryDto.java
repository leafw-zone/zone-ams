package cn.leafw.zone.ams.api.dto;

import cn.leafw.zone.common.dto.BaseQueryDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:23
 */
@Data
public class AccountLogQueryDto extends BaseQueryDto{

    private String logId;

    private String accountId;

    private String changeType;

    private BigDecimal changeAmount;

    private Date changeTime;

    private String isDeleted;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

    private String consumeType;
}
