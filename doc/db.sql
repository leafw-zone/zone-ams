CREATE TABLE `account_log` (
  `account_id` varchar(20) NOT NULL COMMENT '账户id',
  `change_type` varchar(2) DEFAULT NULL COMMENT '变化类型:支出1或收入2',
  `change_amount` decimal(10,2) DEFAULT NULL COMMENT '变化金额',
  `change_time` datetime DEFAULT NULL COMMENT '变化时间',
  `is_deleted` varchar(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `account_main` (
  `account_id` varchar(20) NOT NULL COMMENT '账户id',
  `account_name` varchar(30) DEFAULT NULL COMMENT '账户名称',
  `type` varchar(2) DEFAULT NULL COMMENT '账户类型',
  `assets` decimal(10,2) DEFAULT NULL COMMENT '资产',
  `is_deleted` varchar(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_by` varchar(30) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;