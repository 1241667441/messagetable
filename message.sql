/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : message

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2017-12-28 11:13:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `denglutable`
-- ----------------------------
DROP TABLE IF EXISTS `denglutable`;
CREATE TABLE `denglutable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of denglutable
-- ----------------------------
INSERT INTO `denglutable` VALUES ('1', '123456', '123456', '0');
INSERT INTO `denglutable` VALUES ('2', '3', '3', '0');
INSERT INTO `denglutable` VALUES ('3', '4', '4', '0');
INSERT INTO `denglutable` VALUES ('4', '1', '1', '1');
INSERT INTO `denglutable` VALUES ('5', '2', '2', '0');

-- ----------------------------
-- Table structure for `messagetable`
-- ----------------------------
DROP TABLE IF EXISTS `messagetable`;
CREATE TABLE `messagetable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `respond` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of messagetable
-- ----------------------------
INSERT INTO `messagetable` VALUES ('2', '匿名', '123123', '2017-12-27 16:46:58', '1');
INSERT INTO `messagetable` VALUES ('4', '1', '1', '2017-12-27 16:47:31', '1');
INSERT INTO `messagetable` VALUES ('7', '匿名', '1231123106', '2017-12-27 18:18:03', '1');
INSERT INTO `messagetable` VALUES ('8', '匿名', '4646', '2017-12-27 18:18:27', '0');
INSERT INTO `messagetable` VALUES ('9', '匿名', '4646', '2017-12-27 18:18:30', '1');
INSERT INTO `messagetable` VALUES ('11', '匿名', 'LIYISEHNG', '2017-12-27 18:18:45', '1');
INSERT INTO `messagetable` VALUES ('14', '1', '123', '2017-12-27 18:19:13', '1');
INSERT INTO `messagetable` VALUES ('15', '1', '9994', '2017-12-27 18:19:21', '1');
INSERT INTO `messagetable` VALUES ('16', '1', 'rtewrt', '2017-12-27 18:28:22', '1');
INSERT INTO `messagetable` VALUES ('18', '匿名', 'sgfdg', '2017-12-27 22:07:02', '0');
INSERT INTO `messagetable` VALUES ('19', '匿名', 'fsdgfsdg', '2017-12-27 22:07:08', '0');
INSERT INTO `messagetable` VALUES ('20', '匿名', 'fgsdfgdsfg', '2017-12-27 22:07:13', '0');
INSERT INTO `messagetable` VALUES ('21', '123456', '你好啊', '2017-12-27 22:07:45', '0');
INSERT INTO `messagetable` VALUES ('22', '匿名', '阿斯蒂芬骄傲的复合', '2017-12-27 22:57:38', '0');
INSERT INTO `messagetable` VALUES ('23', '匿名', '法警队佛ad结束符', '2017-12-27 22:57:47', '0');
INSERT INTO `messagetable` VALUES ('24', '匿名', 'fasdfadsfasf', '2017-12-27 22:57:55', '0');
INSERT INTO `messagetable` VALUES ('25', '2', '阿斯蒂芬第三方', '2017-12-27 22:58:42', '0');
INSERT INTO `messagetable` VALUES ('26', '2', '法师打发斯蒂芬', '2017-12-27 22:58:48', '1');
INSERT INTO `messagetable` VALUES ('27', '匿名', '帅气的老师', '2017-12-28 01:01:15', '1');
INSERT INTO `messagetable` VALUES ('29', '匿名', '你好啊', '2017-12-28 09:45:36', '0');
INSERT INTO `messagetable` VALUES ('30', '匿名', '你好', '2017-12-28 10:26:06', '0');
INSERT INTO `messagetable` VALUES ('31', '匿名', '打算发生的发', '2017-12-28 10:26:24', '0');
