package cn.leafw.zone.ams.api.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/20 10:47
 */
@Data
public class AccountLogSumDto {

    private BigDecimal sumAmount;

    private BigDecimal detailSumAmount;

    private String consumeType;

    private String consumeTypeName;

    private String month;
}
