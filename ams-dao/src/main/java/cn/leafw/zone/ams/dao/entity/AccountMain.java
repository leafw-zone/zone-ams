package cn.leafw.zone.ams.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/18 16:21
 */
@Entity
@Data
@Table(name = "account_main")
public class AccountMain {

    @Id
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
