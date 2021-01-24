/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.6.31-log : Database - crmpro1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`crmpro1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `crmpro1`;

/*Table structure for table `analysis` */

DROP TABLE IF EXISTS `analysis`;

CREATE TABLE `analysis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(64) DEFAULT NULL,
  `title` varchar(64) DEFAULT NULL,
  `simpledis` text,
  `detaileddis` text,
  `addtime` date DEFAULT NULL,
  `updatetime` date DEFAULT NULL,
  `remark` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `analysis` */

insert  into `analysis`(`id`,`proname`,`title`,`simpledis`,`detaileddis`,`addtime`,`updatetime`,`remark`) values (2,'新的项目','aaaa',NULL,NULL,NULL,NULL,NULL),(3,'新的项目','aaa',NULL,NULL,NULL,NULL,NULL),(4,'11','加速度快 ',NULL,NULL,NULL,NULL,'特务'),(5,'11','谁看见啊哈啊','也乳液','二姨太㛑',NULL,NULL,'额亅'),(6,'大 三个输入 rss','社人员好吧','认识特色个e','投入投入',NULL,NULL,'投入火热问题'),(7,'是g','今天是个好日子','的手法让','认识给他',NULL,NULL,'同人歌他'),(8,'大 三个输入 rss','社人员好吧','人给他rwh','浩特哈任务号',NULL,NULL,'同任何人环绕'),(9,'新的项目','办公室让他','而我却','他',NULL,NULL,'弍'),(10,'dasd','毅然决然哭','u7','46j',NULL,NULL,'u64 4'),(11,'dasd','就UR居然UR','jy','亅',NULL,NULL,'就二级'),(12,'新的项目','都就偶尔未确认','我问他t','我投入w',NULL,NULL,'我'),(13,'dasd','reg e','gtew','t wtw e',NULL,NULL,'wtt'),(14,'1111','ssssssss','','sssss',NULL,NULL,'sssss'),(15,NULL,'333','333','333',NULL,NULL,'3333'),(16,NULL,'222','222','222',NULL,NULL,'222');

/*Table structure for table `archives` */

DROP TABLE IF EXISTS `archives`;

CREATE TABLE `archives` (
  `dnum` varchar(64) NOT NULL,
  `landline` varchar(32) DEFAULT NULL COMMENT '固话',
  `school` varchar(32) DEFAULT NULL COMMENT '毕业院校',
  `zhuanye` varchar(32) DEFAULT NULL COMMENT '专业',
  `sosperson` varchar(32) DEFAULT NULL COMMENT '紧急联系人',
  `biyedate` date DEFAULT NULL COMMENT '毕业时间',
  `zzmm` varchar(32) DEFAULT NULL COMMENT '政治面貌',
  `minzu` varchar(32) DEFAULT NULL COMMENT '民族',
  `xueli` varchar(32) DEFAULT NULL COMMENT '学历',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `emp_fk` int(11) DEFAULT NULL COMMENT '员工外键',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `hirdate` date DEFAULT NULL COMMENT '入职日期',
  PRIMARY KEY (`dnum`),
  KEY `emp_fk` (`emp_fk`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `archives` */

insert  into `archives`(`dnum`,`landline`,`school`,`zhuanye`,`sosperson`,`biyedate`,`zzmm`,`minzu`,`xueli`,`email`,`emp_fk`,`remark`,`hirdate`) values ('1','010-110','联合大学','生物科学','仲琪','2018-05-15','群众','汉族','大专','12455@123.com',2,'比较年轻不沉稳需要历练','2019-01-01'),('2','0531-120','北京大学','电子工程','李程','2018-09-11','党员','回族','本科','567@165.com',5,'学习能力强,重点培养','2019-01-03'),('3','0531-110','北京大学','软件工程','张三','2018-09-09','群众','维吾尔族','本科','1991995430@qq.com',1,'学习能力强,重点培养','2019-01-01'),('4','0531-110','北京大学','软件工程','张三','2018-09-09','群众','维吾尔族','本科','1991995430@qq.com',3,'学习能力强,重点培养','2019-01-01'),('5','0531-119','北京大学','航天技术','马亮','2018-09-10','团员','满族','本科','345@164.com',4,'啥也不会，找个机会开走','2019-01-02');

/*Table structure for table `attachment` */

DROP TABLE IF EXISTS `attachment`;

CREATE TABLE `attachment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pro_fk` int(11) DEFAULT NULL,
  `attname` varchar(32) DEFAULT NULL,
  `attdis` varchar(128) DEFAULT NULL,
  `remark` text,
  `path` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhdq50yhhjhdiyfm03xjohqlki` (`pro_fk`),
  CONSTRAINT `FKhdq50yhhjhdiyfm03xjohqlki` FOREIGN KEY (`pro_fk`) REFERENCES `project` (`pid`),
  CONSTRAINT `attachment_ibfk_1` FOREIGN KEY (`pro_fk`) REFERENCES `project` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `attachment` */

insert  into `attachment`(`id`,`pro_fk`,`attname`,`attdis`,`remark`,`path`) values (11,2,'投标文书','aaaa','备注','notemanager.sql'),(12,12,'好的图片','没啥','而我给他人','80T9`T3VC9JNS[)CP1]ANEK.png'),(13,3,'好的民资','额热人','投入投入','80T9`T3VC9JNS[)CP1]ANEK.png'),(14,4,'明天会更好','额热人','热无花果热火也 有','112.png'),(15,2,'11111','1111','1111','666.jpg'),(16,2,'11111','1111','','666.jpg');

/*Table structure for table `baoxiao` */

DROP TABLE IF EXISTS `baoxiao`;

CREATE TABLE `baoxiao` (
  `bxid` varchar(64) NOT NULL,
  `paymode` varchar(32) DEFAULT NULL COMMENT '类型',
  `totalmoney` double DEFAULT NULL COMMENT '总金额',
  `bxtime` date DEFAULT NULL COMMENT '报销时间',
  `bxremark` varchar(100) DEFAULT NULL COMMENT '报销备注',
  `bxstatus` int(11) DEFAULT '0' COMMENT '报销状态',
  `emp_fk` int(11) DEFAULT NULL COMMENT '发起报销人',
  `result` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`bxid`),
  KEY `emp_fk` (`emp_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `baoxiao` */

insert  into `baoxiao`(`bxid`,`paymode`,`totalmoney`,`bxtime`,`bxremark`,`bxstatus`,`emp_fk`,`result`) values ('35573fb9-43aa-4271-90e6-200144344db7','办公采购',2222,'2019-06-25','而非个人各位w',NULL,NULL,NULL),('5fa64b67-0864-4a45-b3bf-ca617300dd13','办公采购',456634,'2019-08-08','呃呃呃呃呃反反复复',1,2,'44444'),('929a4ee0-c374-4067-beae-3e7e8a56e7f7','出差票据',9999,'2019-06-07','额鹅鹅鹅饿改革',NULL,NULL,NULL),('c13e844c-3a13-480e-b8e9-9839c08d695a','办公采购',3455,'2019-09-10','出差去岘港吃饭喝酒',2,2,'反反复复'),('e71a0c55-044f-4d56-855f-bd931fd43a36','办公采购',123,'2019-01-01','发发发发发发付付深V许昌县后天发货',2,2,'555555'),('null0','办公采购',2000,'2019-06-05','清关费问过',NULL,NULL,NULL);

/*Table structure for table `baseproperties` */

DROP TABLE IF EXISTS `baseproperties`;

CREATE TABLE `baseproperties` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(50) DEFAULT NULL,
  `bmodelCode` int(11) DEFAULT NULL,
  `bmodelName` varchar(50) DEFAULT NULL,
  `pbid` int(11) DEFAULT NULL,
  `addtime` date DEFAULT NULL,
  `adduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `baseproperties` */

insert  into `baseproperties`(`bid`,`bname`,`bmodelCode`,`bmodelName`,`pbid`,`addtime`,`adduser`) values (1,'紧急',100,'项目管理_基本信息_级别',0,'2019-03-29',1),(2,'一般',100,'项目管理_基本信息_级别',0,'2019-03-29',1),(3,'暂缓',100,'项目管理_基本信息_级别',0,'2019-03-29',1);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comname` varchar(128) DEFAULT NULL,
  `companyperson` varchar(32) DEFAULT NULL,
  `comaddress` varchar(128) DEFAULT NULL,
  `comphone` varchar(32) DEFAULT NULL,
  `camera` varchar(128) DEFAULT NULL,
  `present` varchar(128) DEFAULT NULL,
  `remark` varchar(128) DEFAULT NULL,
  `addtime` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

/*Data for the table `customer` */

insert  into `customer`(`id`,`comname`,`companyperson`,`comaddress`,`comphone`,`camera`,`present`,`remark`,`addtime`) values (1,'广州天河科技有限公司','张无忌','广州市高新区001号011','011','010-0000111','天河公司是广州最大的软件外包公司，目前很牛逼，在职员工200人左右0','目前正在高速扩张阶段0',NULL),(28,'北京中公教育','李总','7 额agte','8 合同t','9 额 额 t','78 儿童 t','564 特',NULL),(29,'南京某某有限公司','王总','45','45','45','45','45',NULL),(30,'安徽某某有限公司','张总','76','67','67','67','67',NULL),(31,'111','111','12','12','12','热我','111111111111111111111111111111111',NULL),(32,'111','we','we','we f','r ew','trw','wr  t',NULL),(33,'111','111','11','11','12','wean','让我',NULL),(34,'9999','999999','99999','9999','999999','9999','999999',NULL);

/*Table structure for table `datacollect` */

DROP TABLE IF EXISTS `datacollect`;

CREATE TABLE `datacollect` (
  `daid` int(11) NOT NULL AUTO_INCREMENT,
  `dacname` varchar(32) DEFAULT NULL COMMENT '目标公司名称',
  `daturnover` double DEFAULT NULL COMMENT '营业额',
  `datime` date DEFAULT NULL COMMENT '年度',
  `dabusiness` varchar(128) DEFAULT NULL COMMENT '主要业务',
  `dasuperiority` varchar(128) DEFAULT NULL COMMENT '优势',
  `dainforiority` varchar(128) DEFAULT NULL COMMENT '劣势',
  `dasort` int(11) DEFAULT NULL COMMENT '行业排名',
  `empcount` int(11) DEFAULT NULL COMMENT '员工数量',
  `buildtime` date DEFAULT NULL COMMENT '企业创建时间',
  `remark` varchar(256) DEFAULT NULL COMMENT '简单描述',
  `daother` varchar(128) DEFAULT NULL COMMENT '其他',
  PRIMARY KEY (`daid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `datacollect` */

insert  into `datacollect`(`daid`,`dacname`,`daturnover`,`datime`,`dabusiness`,`dasuperiority`,`dainforiority`,`dasort`,`empcount`,`buildtime`,`remark`,`daother`) values (1,'浪潮集团',10,'2015-01-01','软件研发','国家扶持','自主能力较差',1,3000,'1980-09-09','创建时间较长，市场比较稳定','2015年-浪潮集团详细调研说明书.doc'),(2,'浪潮集团',20,'2016-01-01','软件研发,服务器研发','国家扶持','自主能力较差',1,3001,'1980-09-10','创建时间较长，市场比较稳定','2016年-浪潮集团详细调研说明书.doc'),(3,'浪潮集团',50,'2017-01-01','软件研发，软件销售','国家扶持','自主能力较差',1,3002,'1980-09-11','创建时间较长，市场比较稳定','2017年-浪潮集团详细调研说明书.doc'),(4,'浪潮集团',70,'2018-01-01','软件研发','国家扶持','自主能力较差',1,3003,'1980-09-12','创建时间较长，市场比较稳定','2018年-浪潮集团详细调研说明书.doc'),(5,'浪潮集团',8,'2014-01-01','软件研发','国家扶持','自主能力较差',1,3004,'1980-09-13','创建时间较长，市场比较稳定','2014年-浪潮集团详细调研说明书.doc'),(6,'中科软',30,'1018-01-01','软件外包服务','技术人员充沛',NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `deptno` int(11) NOT NULL,
  `dname` varchar(32) DEFAULT NULL,
  `dlocation` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `dept` */

insert  into `dept`(`deptno`,`dname`,`dlocation`) values (10,'开发部','北京'),(20,'市场部','广州'),(30,'总裁办','上海');

/*Table structure for table `email` */

DROP TABLE IF EXISTS `email`;

CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(32) DEFAULT NULL,
  `ename` varchar(32) DEFAULT NULL,
  `sendtime` date DEFAULT NULL,
  `content` varchar(128) DEFAULT NULL,
  `emp_fk` int(11) DEFAULT NULL,
  `path` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbwdib3s3ugq70b5h2ocn0rfvb` (`emp_fk`),
  CONSTRAINT `FKbwdib3s3ugq70b5h2ocn0rfvb` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`),
  CONSTRAINT `email_ibfk_1` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `email` */

/*Table structure for table `emp_role` */

DROP TABLE IF EXISTS `emp_role`;

CREATE TABLE `emp_role` (
  `erid` int(11) NOT NULL AUTO_INCREMENT,
  `role_fk` int(11) DEFAULT NULL,
  `emp_fk` int(11) DEFAULT NULL,
  `erdis` varchar(32) DEFAULT NULL COMMENT '员工和角色的描述',
  PRIMARY KEY (`erid`),
  KEY `emp_fk` (`emp_fk`),
  KEY `role_fk` (`role_fk`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `emp_role` */

insert  into `emp_role`(`erid`,`role_fk`,`emp_fk`,`erdis`) values (1,6,6,'小孙子的角色'),(2,5,7,'444的角色'),(3,5,8,'55的角色');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `eid` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(32) DEFAULT NULL,
  `esex` varchar(32) DEFAULT NULL,
  `eage` int(11) DEFAULT NULL,
  `telephone` varchar(32) DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `pnum` varchar(32) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `remark` text,
  `p_fk` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `FKt4aodqf7acjpmo7iejdmg3k78` (`p_fk`),
  CONSTRAINT `FKt4aodqf7acjpmo7iejdmg3k78` FOREIGN KEY (`p_fk`) REFERENCES `position` (`id`),
  CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`p_fk`) REFERENCES `position` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `employee` */

insert  into `employee`(`eid`,`ename`,`esex`,`eage`,`telephone`,`hiredate`,`pnum`,`username`,`password`,`remark`,`p_fk`) values (1,'侯小','male',32,'23423','2019-06-20',NULL,'zs','123',NULL,5),(2,'王五',NULL,25,'123456','2019-06-05',NULL,'ls','123',NULL,4),(3,'李四',NULL,23,'23456','2019-06-15',NULL,NULL,NULL,NULL,5),(4,'张三',NULL,23,'1885534535','2019-06-26',NULL,NULL,NULL,NULL,4),(5,'李宁',NULL,34,'223456','2019-06-14',NULL,NULL,NULL,NULL,4);

/*Table structure for table `evaluate` */

DROP TABLE IF EXISTS `evaluate`;

CREATE TABLE `evaluate` (
  `evaid` int(11) NOT NULL AUTO_INCREMENT COMMENT '评价id',
  `forum_fk` int(11) DEFAULT NULL COMMENT '帖子外键',
  `emp_fk4` int(11) DEFAULT NULL COMMENT '评价人外键',
  `evaid_fk` int(11) DEFAULT NULL COMMENT '回复外键',
  `evacontent` varchar(256) DEFAULT NULL COMMENT '评价内容',
  `updatetime` datetime DEFAULT NULL COMMENT '更新时间',
  `evatime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `evastatus` int(11) DEFAULT '0' COMMENT '评价状态',
  PRIMARY KEY (`evaid`),
  KEY `emp_fk4` (`emp_fk4`),
  KEY `forum_fk` (`forum_fk`),
  KEY `evaid_fk` (`evaid_fk`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `evaluate` */

insert  into `evaluate`(`evaid`,`forum_fk`,`emp_fk4`,`evaid_fk`,`evacontent`,`updatetime`,`evatime`,`evastatus`) values (1,2,5,NULL,'<p>发发发发发发付</p>',NULL,'2019-01-07 11:08:33',NULL),(2,2,2,1,'<p>发发发发发发付</p>',NULL,'2019-01-07 11:08:27',NULL),(3,2,3,1,'<p>发发发发发发付</p>',NULL,'2019-01-07 11:08:25',NULL),(6,2,4,NULL,'<p>发发发发发发付</p>',NULL,'2019-01-07 11:08:24',0),(7,2,1,6,'<p>发发发发发发付</p>',NULL,'2019-01-07 11:08:23',0),(8,2,2,NULL,'<p>发发发发发发付</p>',NULL,'2019-01-07 11:05:34',0),(9,2,2,NULL,'<p>反反复复</p><p>反反复复</p>',NULL,'2019-01-07 11:10:07',0),(10,3,2,NULL,'<p>反反复复付付</p>',NULL,'2019-01-07 11:14:50',0),(11,14,6,NULL,'<p>呃呃呃呃呃</p>',NULL,'2019-01-09 10:05:20',0);

/*Table structure for table `forumpost` */

DROP TABLE IF EXISTS `forumpost`;

CREATE TABLE `forumpost` (
  `forumid` int(11) NOT NULL AUTO_INCREMENT COMMENT '帖子id',
  `forumtitle` varchar(32) NOT NULL COMMENT '帖子的标题',
  `forumcontent` varchar(256) NOT NULL COMMENT '帖子的内容',
  `emp_fk3` int(11) NOT NULL COMMENT '发帖人',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int(11) DEFAULT '0' COMMENT '帖子状态',
  PRIMARY KEY (`forumid`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `forumpost` */

insert  into `forumpost`(`forumid`,`forumtitle`,`forumcontent`,`emp_fk3`,`createtime`,`status`) values (2,'投入让人','<p>发发发发发发付多岁的爽肤水</p>',2,'2019-01-04 15:54:23',0),(3,'反反复复','<p>反反复复</p>',2,'2019-01-04 16:01:28',0),(4,'附近反复讲','<p>发的顺丰科技的史莱克</p><p>第三方就离开的说法</p><p>是的房间里看电视</p>',2,'2019-01-04 16:16:18',0),(6,'333333','<p>333333333<br/></p>',2,'2019-01-04 16:50:10',0),(7,'444','<p>4444</p>',2,'2019-01-04 17:48:12',0),(8,'444','<p>44444</p>',2,'2019-01-04 17:48:18',0),(9,'444','<p>5555</p>',2,'2019-01-04 17:50:03',0),(10,'666','<p>666666</p>',2,'2019-01-04 17:53:49',0),(11,'555','<p>55555</p>',2,'2019-01-04 18:22:04',0),(12,'333333','<p>ttttttttttt</p>',2,'2019-01-04 18:32:31',0),(13,'杯子出售','<p>杯子在呢么名史莱克的减肥的流口水</p>',2,'2019-01-07 09:01:37',0),(14,'3333','<p>33333</p>',6,'2019-01-09 10:05:11',0);

/*Table structure for table `function` */

DROP TABLE IF EXISTS `function`;

CREATE TABLE `function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(32) DEFAULT NULL,
  `analysisname` varchar(32) DEFAULT NULL,
  `modele_fk` int(11) DEFAULT NULL,
  `functionname` varchar(32) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `simpledis` text,
  `detaileddis` text,
  `remark` text,
  PRIMARY KEY (`id`),
  KEY `FKjonpxsiii6o3xv16nttvg500w` (`modele_fk`),
  CONSTRAINT `FKjonpxsiii6o3xv16nttvg500w` FOREIGN KEY (`modele_fk`) REFERENCES `module` (`id`),
  CONSTRAINT `function_ibfk_1` FOREIGN KEY (`modele_fk`) REFERENCES `module` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `function` */

insert  into `function`(`id`,`proname`,`analysisname`,`modele_fk`,`functionname`,`level`,`simpledis`,`detaileddis`,`remark`) values (1,'3','11',5,'第一功能','中','按时rg','额人eg','啊'),(2,'3','11',5,'第三个功能','低','艾弗森er','然而个热','爱人然而各色让'),(3,'3','11',5,'第五个功能','中','艾尔无法r','而我让国人','人'),(4,'12','2',1,'第五个功能','高','ersgt rew th re','hter he','hehey h');

/*Table structure for table `indexvalue` */

DROP TABLE IF EXISTS `indexvalue`;

CREATE TABLE `indexvalue` (
  `in_id` int(11) NOT NULL AUTO_INCREMENT,
  `in_turnover` double DEFAULT NULL COMMENT '目标营业额',
  `in_business` varchar(128) DEFAULT NULL COMMENT '主要业务方向',
  `comname_fk` int(11) DEFAULT NULL COMMENT '对比企业名称',
  `in_remark` varchar(256) DEFAULT NULL COMMENT '简单说明',
  `in_file` varchar(128) DEFAULT NULL COMMENT '附件',
  `emp_fk5` int(11) DEFAULT NULL COMMENT '指标制定人',
  `in_starttime` date DEFAULT NULL COMMENT '开始时间',
  `in_endtime` date DEFAULT NULL COMMENT '截止时间',
  `in_updatetime` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`in_id`),
  KEY `comname_fk` (`comname_fk`),
  KEY `emp_fk5` (`emp_fk5`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `indexvalue` */

insert  into `indexvalue`(`in_id`,`in_turnover`,`in_business`,`comname_fk`,`in_remark`,`in_file`,`emp_fk5`,`in_starttime`,`in_endtime`,`in_updatetime`) values (4,75,'软件开发服务器销售',4,'扩展业务为服务器销售','a1e97cf3-ded9-4f53-860f-5e95b4fafa00_abc.xls',2,'2019-01-01','2019-06-30',NULL);

/*Table structure for table `level` */

DROP TABLE IF EXISTS `level`;

CREATE TABLE `level` (
  `jid` int(11) NOT NULL AUTO_INCREMENT,
  `jname` varchar(32) DEFAULT NULL,
  `jdis` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`jid`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `level` */

insert  into `level`(`jid`,`jname`,`jdis`) values (1,'p1','实习生'),(2,'p2','初级程序员'),(3,'m1','项目组长'),(4,'m2','项目负责人');

/*Table structure for table `module` */

DROP TABLE IF EXISTS `module`;

CREATE TABLE `module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(32) DEFAULT NULL,
  `analysis_fk` int(11) DEFAULT NULL,
  `modname` varchar(32) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `simpledis` text,
  `detaileddis` text,
  `remark` text,
  PRIMARY KEY (`id`),
  KEY `FK986a0ufpo55087x7uc0ous7nb` (`analysis_fk`),
  CONSTRAINT `FK986a0ufpo55087x7uc0ous7nb` FOREIGN KEY (`analysis_fk`) REFERENCES `analysis` (`id`),
  CONSTRAINT `module_ibfk_1` FOREIGN KEY (`analysis_fk`) REFERENCES `analysis` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `module` */

insert  into `module`(`id`,`proname`,`analysis_fk`,`modname`,`level`,`simpledis`,`detaileddis`,`remark`) values (1,'12',2,'新的模块1','高','也je','就j','额'),(2,'3',10,'are我','高','热w','人','人'),(3,'3',10,'新的模块1','高','拆东补西吧','热er','弍'),(4,'3',11,'时候是是是','高','哇et','给他人w','他让我'),(5,'3',11,'今天是个好日子','中','家后悔滴哈 a','人热w','为');

/*Table structure for table `msg` */

DROP TABLE IF EXISTS `msg`;

CREATE TABLE `msg` (
  `msgid` int(11) NOT NULL AUTO_INCREMENT,
  `sendp` int(32) DEFAULT NULL,
  `recvp` int(32) DEFAULT NULL,
  `mark` int(11) DEFAULT '0',
  `msgcontent` varchar(32) DEFAULT NULL,
  `msgtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`msgid`),
  KEY `sendp` (`sendp`),
  KEY `recvp` (`recvp`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `msg` */

insert  into `msg`(`msgid`,`sendp`,`recvp`,`mark`,`msgcontent`,`msgtime`) values (1,2,1,0,'反反复复','2019-01-04 00:00:00'),(2,2,3,0,'qqqqqqqqqqqqqqqqqqqq','2019-06-27 00:00:00');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `nid` int(11) NOT NULL AUTO_INCREMENT,
  `ntitle` varchar(32) DEFAULT NULL,
  `remark` varchar(320) DEFAULT NULL,
  `ndate` date DEFAULT NULL,
  PRIMARY KEY (`nid`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`nid`,`ntitle`,`remark`,`ndate`) values (1,'提升张三为副总裁','张三的接口丽枫酒店\r\n的实例会计法独立思考\r\n的借款方\r\n冻死了空间发的是\r\n独立思考解放东路开始','2019-01-03'),(2,'降薪公告','关于集团为了缩减开始，特发出降薪通告\r\n1:10年员工降薪30%\r\n2：新员工降薪45%','2019-01-01'),(3,'税务改革','2019-01-01 新的纳税制度\r\n大家及时申报免税的信息','2019-01-01'),(4,'年终考核','总结大家一年中工作内容，成绩。突出贡献','2018-12-31'),(5,'集团考勤通告','张三今天迟到了5分钟，本次事故纳入年终考核，罚款500元','2019-01-03'),(6,'节约使用办公用品倡议','为了迎接互联网寒冬，我们要扎进裤腰带，共同度过','2019-01-03'),(9,'今天的所有人不允许迟到','咖啡螯合物符合啊合肥和爱护秀恩爱胡哈科技风科技然后空间规划界人士哈','2019-06-25'),(10,'rwe','wet w','2019-06-26'),(11,'333','3333','2019-07-02');

/*Table structure for table `position` */

DROP TABLE IF EXISTS `position`;

CREATE TABLE `position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `position` */

insert  into `position`(`id`,`name`) values (1,'初级开发工程师'),(2,'中级开发工程师'),(3,'高级开发工程师'),(4,'项目经理'),(5,'项目总监'),(6,' 其他');

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(128) DEFAULT NULL,
  `comname` int(11) DEFAULT NULL,
  `comper` varchar(64) DEFAULT NULL,
  `emp_fk1` int(11) NOT NULL,
  `empcount` int(11) DEFAULT NULL,
  `starttime` date DEFAULT NULL,
  `buildtime` date DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `remark` text,
  `emp_fk` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `emp_fk1` (`emp_fk1`),
  KEY `FKtirudsu3khj865hrqeamn153y` (`comname`),
  KEY `FKj4vtyyp6ew24vggobfcmav1be` (`emp_fk`),
  CONSTRAINT `FKj4vtyyp6ew24vggobfcmav1be` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`),
  CONSTRAINT `FKtirudsu3khj865hrqeamn153y` FOREIGN KEY (`comname`) REFERENCES `customer` (`id`),
  CONSTRAINT `project_ibfk_2` FOREIGN KEY (`comname`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `project` */

insert  into `project`(`pid`,`pname`,`comname`,`comper`,`emp_fk1`,`empcount`,`starttime`,`buildtime`,`cost`,`level`,`endtime`,`remark`,`emp_fk`,`state`) values (2,'1111',1,'张无忌',1,20,'2019-03-14','2019-03-08',100,'2','2019-03-21','sfdsf',2,1),(3,'dasd',1,'张无忌',1,20,'2019-03-14','2019-03-22',100,'1','2019-03-31','备注',4,2),(4,'dasdwere',1,'张无忌',1,23,'2019-03-14','2019-03-19',100,'1','2019-03-27','wefwef',4,1),(5,'是g',28,'李总',1,20,'2019-06-13','2019-06-09',23,'1','2019-06-19','二哥',2,3),(6,'是g',29,'王总',1,23,'2019-06-05','2019-06-13',23,'1','2019-06-13','让他行业额',4,5),(10,'是g',1,'张无忌',2,20,'2019-06-05','2019-06-07',23,'2','2019-06-27','非负数',NULL,2),(11,'大 三个输入 rss',28,'李总',2,30,'2019-06-05','2019-06-07',23,'2','2019-06-13','撒而非儿啊个个',NULL,4),(12,'新的项目',28,'李总',4,10,'2019-06-04','2019-06-23',10,'2','2019-06-19','在我的厚爱的hid很快就啊回到家哈哈发OA和if',NULL,1),(13,'新的项目',28,'李总',4,10,'2019-06-04','2019-06-23',10,'2','2019-06-19','在我的厚爱的hid很快就啊回到家哈哈发OA和if',NULL,2),(14,'新的项目333',29,'王总',4,10,'2019-06-05','2019-06-20',23,'2','2019-06-13','玩儿钢铁网',NULL,5),(15,'新的项目333',28,'李总',5,20,'2019-06-05','2019-06-07',10,'3','2019-06-19','方式他让他',NULL,NULL),(16,'我的第一个项目',28,'李总',5,10,'2019-06-02','2019-06-08',23,'2','2019-06-13','这是很重要的项目',NULL,NULL),(17,'大 三个输入 rss',28,'李总',2,10,NULL,NULL,23,'1',NULL,'re gtr',NULL,NULL),(18,'大 三个输入 rss',1,'张无忌',4,20,NULL,NULL,23,'1',NULL,'贪玩儿t',NULL,NULL),(19,'买椟还珠',29,'王总',2,10,NULL,NULL,23,'2',NULL,'ervewvwevewvv',NULL,NULL),(20,'三生三世',29,'王总',2,20,NULL,NULL,10,'1',NULL,'是发的',NULL,NULL);

/*Table structure for table `propeteis` */

DROP TABLE IF EXISTS `propeteis`;

CREATE TABLE `propeteis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proname` varchar(32) DEFAULT NULL,
  `key` varchar(32) DEFAULT NULL,
  `value` int(11) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `commons` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `propeteis` */

insert  into `propeteis`(`id`,`proname`,`key`,`value`,`pid`,`commons`) values (1,'project_state',NULL,0,0,'项目表中的字段'),(2,'','进行中',1,1,NULL),(3,NULL,'需求分析',2,1,NULL),(4,NULL,'模块设计',3,1,NULL),(5,NULL,'开发阶段',4,1,NULL),(6,NULL,'验收',5,1,NULL),(7,NULL,'完成',6,1,NULL),(8,'task_state',NULL,0,0,'任务表中的字段'),(9,NULL,'高',1,8,NULL),(10,NULL,'中',2,8,NULL),(11,NULL,'低',3,8,NULL),(12,NULL,'暂缓',4,8,NULL);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `rolename` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `roledis` varchar(32) DEFAULT NULL COMMENT '角色描述',
  `status` int(11) DEFAULT '0' COMMENT '是否启用',
  PRIMARY KEY (`roleid`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`roleid`,`rolename`,`roledis`,`status`) values (5,'5555','反反复复付付',1),(6,'vip会员','vip权限普通用户多一些',1);

/*Table structure for table `role_sources` */

DROP TABLE IF EXISTS `role_sources`;

CREATE TABLE `role_sources` (
  `rsid` int(11) NOT NULL AUTO_INCREMENT,
  `rsdis` varchar(32) DEFAULT NULL COMMENT '角色和资源的描述',
  `sid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rsid`),
  KEY `roleid` (`roleid`),
  KEY `sid` (`sid`)
) ENGINE=MyISAM AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `role_sources` */

insert  into `role_sources`(`rsid`,`rsdis`,`sid`,`roleid`) values (17,'资源和我们的角色描述',1,5),(18,'资源和我们的角色描述',2,5),(19,'资源和我们的角色描述',9,5),(20,'资源和我们的角色描述',10,5),(21,'资源和我们的角色描述',11,5),(22,'资源和我们的角色描述',12,5),(23,'资源和我们的角色描述',13,5),(24,'资源和我们的角色描述',3,5),(25,'资源和我们的角色描述',14,5),(26,'资源和我们的角色描述',15,5),(27,'资源和我们的角色描述',16,5),(28,'资源和我们的角色描述',17,5),(29,'资源和我们的角色描述',18,5),(30,'资源和我们的角色描述',19,5),(31,'资源和我们的角色描述',20,5),(32,'资源和我们的角色描述',21,5),(33,'资源和我们的角色描述',1,6),(34,'资源和我们的角色描述',2,6),(35,'资源和我们的角色描述',9,6),(36,'资源和我们的角色描述',10,6),(37,'资源和我们的角色描述',11,6),(38,'资源和我们的角色描述',12,6),(39,'资源和我们的角色描述',13,6),(40,'资源和我们的角色描述',3,6),(41,'资源和我们的角色描述',14,6),(42,'资源和我们的角色描述',15,6),(43,'资源和我们的角色描述',16,6),(44,'资源和我们的角色描述',17,6),(45,'资源和我们的角色描述',18,6),(46,'资源和我们的角色描述',19,6),(47,'资源和我们的角色描述',20,6),(48,'资源和我们的角色描述',21,6),(49,'资源和我们的角色描述',4,6),(50,'资源和我们的角色描述',27,6);

/*Table structure for table `sources` */

DROP TABLE IF EXISTS `sources`;

CREATE TABLE `sources` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(128) DEFAULT NULL COMMENT '资源路径',
  `remark` varchar(32) DEFAULT NULL COMMENT '资源备注',
  `pid` int(11) DEFAULT NULL COMMENT '父菜单id',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `sources` */

insert  into `sources`(`id`,`name`,`url`,`remark`,`pid`,`icon`) values (1,'oa办公协同系统',NULL,'系统名称',0,NULL),(2,'项目管理',NULL,'项目管理',1,NULL),(3,'日常办公',NULL,'日常办公',1,NULL),(4,'消息管理',NULL,'信息箱',1,NULL),(9,'基本信息管理','project-base.jsp','项目基本信息',2,NULL),(10,'需求信息管理','project-need.jsp','项目需求分析',2,NULL),(11,'模块管理','project-model.jsp','模块管理',2,NULL),(12,'功能管理','project-function.jsp','功能管理',2,NULL),(13,'附件管理','attachment/showAtts','附件管理',2,NULL),(14,'创建任务','task-add.jsp','创建任务',3,NULL),(15,'已发布任务','task.jsp','已发布任务',3,NULL),(16,'我的任务','task-my.jsp','我的任务',3,NULL),(17,'通知公告','notice.jsp','通知公告',3,NULL),(18,'档案管理','archives.jsp','档案管理',3,NULL),(19,'我的档案','myarchives.jsp','我的档案',3,NULL),(20,'报销审批','baoxiao/udobaoxiao','报销审批',3,NULL),(21,'我的报销','baoxiao/show','我的报销',3,NULL),(27,'发送邮件','email-send.jsp','仅仅使用javamail发送邮件就ok啦',4,NULL);

/*Table structure for table `task` */

DROP TABLE IF EXISTS `task`;

CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `starttime` date DEFAULT NULL,
  `endtime` date DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `define` text,
  `fun_fk` int(11) DEFAULT NULL,
  `emp_fk2` int(11) DEFAULT NULL,
  `emp_fk` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_fk2` (`emp_fk2`),
  KEY `FK8pqhf0pdn5r478vp69g6sip3` (`fun_fk`),
  KEY `FKcpxt4jxiaoqj5nwny5ai74drj` (`emp_fk`),
  CONSTRAINT `FK8pqhf0pdn5r478vp69g6sip3` FOREIGN KEY (`fun_fk`) REFERENCES `function` (`id`),
  CONSTRAINT `FKcpxt4jxiaoqj5nwny5ai74drj` FOREIGN KEY (`emp_fk`) REFERENCES `employee` (`eid`),
  CONSTRAINT `task_ibfk_1` FOREIGN KEY (`fun_fk`) REFERENCES `function` (`id`),
  CONSTRAINT `task_ibfk_3` FOREIGN KEY (`emp_fk2`) REFERENCES `employee` (`eid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `task` */

insert  into `task`(`id`,`starttime`,`endtime`,`level`,`define`,`fun_fk`,`emp_fk2`,`emp_fk`) values (2,'2019-06-05','2019-06-13','2',NULL,2,NULL,2),(4,'2019-06-05','2019-06-13','2',NULL,2,NULL,5),(5,'2019-06-05','2019-06-13','2','贪玩让他',2,NULL,2),(6,'2019-06-01','2019-06-13','4','娃娃房',2,NULL,3),(7,'2019-06-06','2019-06-27','2','热给我而我认为',3,NULL,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
