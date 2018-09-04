package cn.leafw.zone.ams.dao.entity;

import lombok.Data;

import javax.persistence.Column;
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
@Entity
@Data
@Table(name = "account_log")
public class AccountLog {

    @Id
    private String logId;

    @Column(name = "account_id")
    private String accountId;
    @Column(name = "change_type")
    private String changeType;
    @Column(name = "change_amount")
    private BigDecimal changeAmount;
    @Column(name = "change_time")
    private Date changeTime;
    @Column(name = "is_deleted")
    private String isDeleted;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "update_by")
    private String updateBy;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "consume_type")
    private String consumeType;
}
