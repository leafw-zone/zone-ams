package cn.leafw.zone.ams.api.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:23
 */
@Data
public class AccountLogDto {

    private String accountId;

    private String changeType;

    private BigDecimal changeAmount;

    private Date changeTime;

    private String isDeleted;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;
}
