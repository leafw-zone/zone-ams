package cn.leafw.zone.ams.api.dto;

import cn.leafw.zone.common.dto.BaseQueryDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:21
 */
@Data
public class AccountMainQueryDto extends BaseQueryDto{

    private String accountId;

    private String accountName;

    private String type;

    private BigDecimal assets;

    private String isDeleted;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;

}
