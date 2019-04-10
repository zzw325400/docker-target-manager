create database `dbtarget` default character set utf8 collate utf8_general_ci;

use `dbtarget`

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


DROP TABLE IF EXISTS `indi_basic_category`;

CREATE TABLE `indi_basic_category` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `classify` int(12) DEFAULT NULL COMMENT '级别',
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `code` varchar(30) DEFAULT NULL COMMENT '代码',
  `pid` int(16) DEFAULT '0' COMMENT '上级节点id',
  `status` tinyint(1) DEFAULT '0' COMMENT '0表示正常使用1表示删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `indi_basic_category` WRITE;
/*!40000 ALTER TABLE `indi_basic_category` DISABLE KEYS */;

INSERT INTO `indi_basic_category` (`id`, `classify`, `name`, `code`, `pid`, `status`)
VALUES
	(1,1,'存款','10',0,0),
	(2,1,'贷款','20',0,0),
	(12,1,'风险','30',0,0),
	(13,1,'渠道','40',0,0),
	(14,2,'全部','00',1,0),
	(15,2,'对公','20',1,0),
	(16,2,'全部','00',2,0),
	(17,2,'一般贷款','10',2,0),
	(18,2,'信用卡透支','20',2,0),
	(19,2,'贴现','30',2,0),
	(20,2,'融资','40',2,0),
	(21,2,'垫款','50',2,0),
	(23,2,'渠道子节点','00',13,0),
	(24,2,'渠道子节点1','10',13,0),
	(29,3,'全部','00',15,0),
	(31,4,'余额','01',29,0),
	(34,2,'全部','00',25,0),
	(35,3,'全部','00',23,0),
	(36,1,'测试','1',0,0),
	(53,4,'贷款全部','09',29,0),
	(54,2,'对私','30',1,0),
	(55,3,'全部','00',54,0),
	(56,4,'余额','10',55,0),
	(57,3,'个人','10',17,0),
	(58,4,'期限','10',57,0);

/*!40000 ALTER TABLE `indi_basic_category` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `indi_data`;

CREATE TABLE `indi_data` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `data_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '数据时间',
  `indi_id` int(12) DEFAULT NULL COMMENT '指标Id',
  `org_id` int(12) DEFAULT NULL COMMENT '组织Id',
  `curr_cd` varchar(30) DEFAULT NULL COMMENT '币种',
  `data_value` decimal(22,4) DEFAULT NULL COMMENT '数值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `indi_data` WRITE;
/*!40000 ALTER TABLE `indi_data` DISABLE KEYS */;

INSERT INTO `indi_data` (`id`, `data_dt`, `indi_id`, `org_id`, `curr_cd`, `data_value`)
VALUES
	(1,'2018-11-13 16:09:19',15,2,'人民币',10000000.0000),
	(2,'2018-11-13 16:09:20',15,2,'人民币',10020000.0008);

/*!40000 ALTER TABLE `indi_data` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `indi_deploy_cfg`;

CREATE TABLE `indi_deploy_cfg` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `indi_id` int(12) DEFAULT NULL COMMENT '指标id',
  `process_inst` varchar(500) DEFAULT NULL COMMENT '处理指令',
  `inst_type` int(12) DEFAULT '1' COMMENT '指令类别 1、存储过程2 、sql语句',
  `created_by` int(12) DEFAULT NULL COMMENT '创建者',
  `create_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建的时间',
  `last_edit_by` int(12) DEFAULT NULL COMMENT '最后修改者',
  `last_edit_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `edit_times` int(12) DEFAULT '0' COMMENT '调整次数',
  `status` int(10) DEFAULT '0' COMMENT '0表示正常使用1表示删除',
  `is_valid` int(10) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `indi_deploy_cfg` WRITE;
/*!40000 ALTER TABLE `indi_deploy_cfg` DISABLE KEYS */;

INSERT INTO `indi_deploy_cfg` (`id`, `indi_id`, `process_inst`, `inst_type`, `created_by`, `create_dt`, `last_edit_by`, `last_edit_dt`, `edit_times`, `status`, `is_valid`)
VALUES
	(1,15,'CALL P_DM_INDI_BOND(\'#etl_date#\',\'3010003\',\'FOUD_BUSI_001\',?,?)',2,2,'2018-11-13 15:46:54',2,'2018-11-14 20:45:32',5,0,0),
	(3,16,'abc',1,NULL,'2018-11-14 20:19:52',NULL,'2018-11-14 21:08:25',2,1,1),
	(4,17,'mkdkfnd',2,NULL,'2019-03-26 16:25:12',NULL,'2019-03-26 16:25:12',0,0,0);

/*!40000 ALTER TABLE `indi_deploy_cfg` ENABLE KEYS */;
UNLOCK TABLES;



DROP TABLE IF EXISTS `indi_item`;

CREATE TABLE `indi_item` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `classify1` int(20) DEFAULT NULL COMMENT '一级指标类别',
  `classify2` int(20) DEFAULT NULL COMMENT '二级指标类别',
  `classify3` int(20) DEFAULT NULL COMMENT '三级指标类别',
  `indi_model` int(20) DEFAULT NULL COMMENT '指标项',
  `indi_code` varchar(100) DEFAULT NULL COMMENT '指标代码',
  `indi_name` varchar(100) DEFAULT NULL COMMENT '指标名称',
  `indi_type` int(12) DEFAULT NULL COMMENT '指标分类',
  `rule` varchar(500) DEFAULT NULL COMMENT '计算规则',
  `created_by` int(12) DEFAULT NULL COMMENT '创建者',
  `create_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建的时间',
  `last_edit_by` int(12) DEFAULT NULL COMMENT '最后修改者',
  `last_edit_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `inst_id` int(12) DEFAULT NULL COMMENT '所属机构',
  `status` int(10) DEFAULT '0' COMMENT '0表示正常使用1表示删除',
  `type` int(12) DEFAULT NULL COMMENT '分类，0表示基础指标，1表示衍生指标',
  `version` varchar(50) DEFAULT NULL COMMENT '版本',
  `comment` varchar(100) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `indi_item` WRITE;
/*!40000 ALTER TABLE `indi_item` DISABLE KEYS */;

INSERT INTO `indi_item` (`id`, `classify1`, `classify2`, `classify3`, `indi_model`, `indi_code`, `indi_name`, `indi_type`, `rule`, `created_by`, `create_dt`, `last_edit_by`, `last_edit_dt`, `inst_id`, `status`, `type`, `version`, `comment`)
VALUES
	(15,1,15,29,31,'10200001002','测试基础指标X',1,'(A+B+C+D)',NULL,'2018-11-14 13:33:37',NULL,'2019-03-26 16:14:32',2,0,0,'1.2','测试专用'),
	(16,1,15,29,31,'10200001002','测试基础指标',1,'abdcd',NULL,'2018-11-14 13:33:37',NULL,'2018-11-14 18:04:39',2,0,0,'',''),
	(17,1,15,29,31,'10200001003','测试基础指标2',2,'计算规则',NULL,'2018-11-14 17:59:59',NULL,'2018-11-15 11:38:52',2,0,1,'v1.0','备注'),
	(18,1,15,29,31,'10200001004','测试基础指标11',1,'1+？=2',NULL,'2018-11-14 18:05:47',NULL,'2018-11-15 09:48:45',2,0,1,'v1.1','备注11122'),
	(22,1,15,29,31,'10200001005','衍生指标测试',2,'',NULL,'2018-11-15 11:06:59',NULL,'2018-11-15 11:33:33',1,0,1,'',''),
	(23,1,15,29,31,'10200001006','衍生指标2',1,'',NULL,'2018-11-15 11:23:21',NULL,'2018-11-15 11:36:39',1,0,1,'',''),
	(24,1,15,29,31,'10200001007','分析指标',2,'',NULL,'2019-03-26 16:21:55',NULL,'2019-03-26 16:21:55',1,0,0,'',''),
	(25,2,17,57,58,'20101010001','贷款个人',1,'',NULL,'2019-03-26 17:02:56',NULL,'2019-03-26 17:02:56',1,0,0,'',''),
	(26,1,54,55,56,'10300010001','存款对私',1,'',NULL,'2019-03-26 17:04:03',NULL,'2019-03-26 17:04:03',1,0,0,'',''),
	(27,1,15,29,31,'10200001008','分析指标',2,'',NULL,'2019-03-26 17:35:44',NULL,'2019-03-26 17:35:44',1,0,0,'',''),
	(28,1,15,29,53,'10200009001','测试基础指标',2,'',NULL,'2019-03-26 17:36:38',NULL,'2019-03-26 17:36:38',1,0,0,'',''),
	(29,1,15,29,53,'10200009002','测试基础指标',1,'',NULL,'2019-03-26 17:49:54',NULL,'2019-03-26 17:49:54',1,0,0,'',''),
	(30,1,15,29,53,'10200009003','测试基础指标',1,'',NULL,'2019-03-26 17:50:00',NULL,'2019-03-26 17:50:00',1,0,0,'',''),
	(31,1,15,29,53,'10200009004','测试基础指标',1,'',NULL,'2019-03-26 17:50:15',NULL,'2019-03-26 17:50:15',1,0,0,'',''),
	(32,1,15,29,31,'10200001009','测试基础指标',1,'',NULL,'2019-03-26 18:49:59',NULL,'2019-03-26 18:49:59',1,0,0,'',''),
	(33,1,15,29,31,'10200001010','测试基础指标',1,'',NULL,'2019-03-26 18:50:04',NULL,'2019-03-26 18:50:04',1,0,0,'',''),
	(34,1,15,29,31,'10200001011','测试基础指标',1,'',NULL,'2019-03-26 18:50:10',NULL,'2019-03-26 18:50:10',1,0,0,'',''),
	(35,1,15,29,31,'10200001012','测试基础指标',1,'',NULL,'2019-03-26 18:50:24',NULL,'2019-03-26 18:50:24',1,0,0,'','');

/*!40000 ALTER TABLE `indi_item` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `indi_org_dimension`;

CREATE TABLE `indi_org_dimension` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `name` varchar(16) DEFAULT NULL COMMENT '机构名字',
  `code` varchar(20) DEFAULT NULL COMMENT '机构代码',
  `status` int(10) DEFAULT '0' COMMENT '0表示正常使用1表示删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `indi_org_dimension` WRITE;
/*!40000 ALTER TABLE `indi_org_dimension` DISABLE KEYS */;

INSERT INTO `indi_org_dimension` (`id`, `name`, `code`, `status`)
VALUES
	(1,'杭州高新支行','00',0),
	(2,'杭州西溪支行','01',0);

/*!40000 ALTER TABLE `indi_org_dimension` ENABLE KEYS */;
UNLOCK TABLES;



DROP TABLE IF EXISTS `indi_type`;

CREATE TABLE `indi_type` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '分类名',
  `status` int(10) DEFAULT '0' COMMENT '“0” 正常，“1‘禁用',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `inst_derive_basic`;

CREATE TABLE `inst_derive_basic` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `derive_id` int(12) DEFAULT NULL COMMENT '衍生指标ID',
  `basic_id` int(12) DEFAULT NULL COMMENT '基础指标id',
  `status` int(10) DEFAULT '0' COMMENT '0表示正常使用1表示删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `inst_derive_basic` WRITE;
/*!40000 ALTER TABLE `inst_derive_basic` DISABLE KEYS */;

INSERT INTO `inst_derive_basic` (`id`, `derive_id`, `basic_id`, `status`)
VALUES
	(1,17,15,1),
	(2,17,16,1),
	(3,18,15,0),
	(27,21,20,0),
	(63,17,15,1),
	(64,23,16,1),
	(65,22,16,0),
	(66,22,15,0),
	(67,23,15,1),
	(68,23,16,1),
	(69,23,15,0),
	(70,17,16,0);

/*!40000 ALTER TABLE `inst_derive_basic` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
