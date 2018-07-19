package cn.leafw.zone.ams.api.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author CareyWYR
 * @description
 * @date 2018/7/19 15:33
 */
@Data
public class ConsumeConfigQueryDto {

    private String consumeId;
    private String consumeName;
    private String changeType;
    private String isDeleted;

    private String createBy;

    private String updateBy;

    private Date createTime;

    private Date updateTime;
}
