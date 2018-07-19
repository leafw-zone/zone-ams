package cn.leafw.zone.ams.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/19 15:33
 */
@Entity
@Data
@Table(name = "consume_config")
public class ConsumeConfig {

    @Id
    private String consumeId;
    private String consumeName;
    private String changeType;
    private String isDeleted;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;
}
