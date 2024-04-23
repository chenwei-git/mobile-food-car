CREATE TABLE `applicant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0:初始化，1：通过，2：没通过',
  `version` int(10) NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(60) NOT NULL DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(60) NOT NULL DEFAULT '',
  `is_deleted` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '0：空闲，1：使用中',
  `description` varchar(500) DEFAULT NULL,
  `coordinates` point DEFAULT NULL COMMENT '经纬度',
  `longitude` decimal(10,7) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10,7) DEFAULT NULL COMMENT '纬度',
  `version` int(10) NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(60) NOT NULL DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(60) NOT NULL DEFAULT '',
  `is_deleted` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `location_applicant` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `location_id` bigint(20) NOT NULL DEFAULT '0',
  `location_desc` varchar(500) DEFAULT NULL,
  `applicant_id` bigint(20) NOT NULL DEFAULT '0',
  `facility_type` varchar(50) DEFAULT NULL,
  `cnn` bigint(20) DEFAULT '0',
  `apply_status` int(11) NOT NULL DEFAULT '0' COMMENT '0：申请中，1：通过，2：不通过',
  `open_status` int(11) NOT NULL DEFAULT '0' COMMENT '0：营业中，1：关门',
  `open_time` time DEFAULT NULL COMMENT '开始营业时间',
  `close_time` time DEFAULT NULL COMMENT '结束营业时间',
  `coordinates` point DEFAULT NULL COMMENT '经纬度',
  `longitude` decimal(10,7) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10,7) DEFAULT NULL COMMENT '纬度',
  `version` int(10) NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(60) NOT NULL DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(60) NOT NULL DEFAULT '',
  `is_deleted` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `sku_applicant` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `price` decimal(20,2) NOT NULL DEFAULT '0.00',
  `applicant_id` bigint(20) NOT NULL DEFAULT '0',
  `version` int(10) NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(60) NOT NULL DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(60) NOT NULL DEFAULT '',
  `is_deleted` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `u_c_a` (`code`,`applicant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `stock` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `location_id` bigint(20) NOT NULL DEFAULT '0',
  `sku_id` bigint(20) DEFAULT '0',
  `lot_no` bigint(20) DEFAULT '0',
  `applicant_id` bigint(20) NOT NULL DEFAULT '0',
  `sku_name` varchar(255) DEFAULT NULL,
  `avail_qty` decimal(20,2) NOT NULL DEFAULT '0.00',
  `selled_qty` decimal(20,2) DEFAULT '0.00',
  `destroy_qty` decimal(20,2) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '0: 可售，1：停售',
  `version` int(10) NOT NULL DEFAULT '1',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(60) NOT NULL DEFAULT '',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(60) NOT NULL DEFAULT '',
  `is_deleted` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uq_loc_app_sku_lot` (`location_id`,`applicant_id`,`sku_id`,`lot_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

