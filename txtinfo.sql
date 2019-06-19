/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-06-18 14:16:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for txtinfo
-- ----------------------------
DROP TABLE IF EXISTS `txtinfo`;
CREATE TABLE `txtinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `txtname` varchar(50) DEFAULT NULL,
  `readtime` varchar(16) DEFAULT NULL,
  `totalmoney` varchar(15) NOT NULL,
  `totaltax` varchar(15) NOT NULL,
  `totaltm` varchar(15) NOT NULL,
  `sellername` varchar(50) NOT NULL,
  `billtime` varchar(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of txtinfo
-- ----------------------------
INSERT INTO `txtinfo` VALUES ('1', '3', '3', '3.2', '3', '3', '3', '3');
INSERT INTO `txtinfo` VALUES ('2', '3', '3', '3', '3', '3', '3', '3');
