/*
 Navicat Premium Data Transfer

 Source Server         : 腾讯云服务器
 Source Server Type    : MySQL
 Source Server Version : 50642
 Source Host           : 123.207.171.15:3306
 Source Schema         : aper

 Target Server Type    : MySQL
 Target Server Version : 50642
 File Encoding         : 65001

 Date: 10/12/2019 23:17:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `ADMIN_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `ADMIN_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员名字',
  `ADMIN_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  PRIMARY KEY (`ADMIN_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for advice
-- ----------------------------
DROP TABLE IF EXISTS `advice`;
CREATE TABLE `advice`  (
  `ADVICE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈ID',
  `ADVICE_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈标题',
  `ADVICE_CONTENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈内容',
  `ADVICE_TIME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈时间',
  `ADVICE_REPLY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '反馈回复',
  `ADVICE_REPLY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '反馈回复时间',
  `USER_ID` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`ADVICE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `DOCTOR_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '医生ID',
  `DOCTOR_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生名字',
  `DOCTOR_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生密码',
  `DOCTOR_REALNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生真实名字',
  `DOCTOR_SEX` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生性别',
  `DOCTOR_PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生电话',
  `DOCTOR_WECHAT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生微信',
  `DOCTOR_OFFICEID` int(11) NULL DEFAULT NULL COMMENT '医生科室ID',
  PRIMARY KEY (`DOCTOR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, 'doctor', 'doctor', NULL, NULL, NULL, NULL, 1);

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office`  (
  `OFFICE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '科室ID',
  `OFFICE_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '科室名',
  PRIMARY KEY (`OFFICE_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of office
-- ----------------------------
INSERT INTO `office` VALUES (1, '心脑血管');
INSERT INTO `office` VALUES (2, '内科');
INSERT INTO `office` VALUES (3, '皮肤外科');

-- ----------------------------
-- Table structure for property
-- ----------------------------
DROP TABLE IF EXISTS `property`;
CREATE TABLE `property`  (
  `PROPERTY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '属性ID',
  `PROPERTY_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性名',
  `PROPERTY_VALUE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '属性值',
  PRIMARY KEY (`PROPERTY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `REPLY_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '回复ID',
  `REPLY_REPOTFORMID` int(11) NULL DEFAULT NULL COMMENT '回复的咨询单ID',
  `REPLY_DOCTORID` int(11) NULL DEFAULT NULL COMMENT '回复的医生ID',
  `REPLY_CONTENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `REPLY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '回复时间',
  `REPLY_IMG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复附加图片',
  `REPLY_STATE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复状态',
  PRIMARY KEY (`REPLY_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for report_form
-- ----------------------------
DROP TABLE IF EXISTS `report_form`;
CREATE TABLE `report_form`  (
  `REPORTFORM_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '咨询单ID',
  `REPORTFORM_USERID` int(11) NULL DEFAULT NULL COMMENT '咨询单发起者ID',
  `REPORTFORM_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '咨询单标题',
  `REPORTFORM_CONTENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '咨询内容',
  `REPORTFORM_TIME` datetime(0) NULL DEFAULT NULL COMMENT '咨询时间',
  `REPORTFORM_OFFICEID` int(11) NULL DEFAULT NULL COMMENT '咨询单咨询的科室',
  `REPORTFORM_STATE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '咨询单状态',
  `REPORTFORM_IMG` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '咨询单附加照片',
  PRIMARY KEY (`REPORTFORM_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of report_form
-- ----------------------------
INSERT INTO `report_form` VALUES (1, 1, '123', '1231111111', '2019-12-10 22:50:22', 1, '0', '20191210225022110.jpg;20191210225022111.jpg');
INSERT INTO `report_form` VALUES (2, 1, '问诊标题', '问诊内容', '2019-12-10 22:57:37', 1, '0', '20191210225737220.jpg;20191210225737221.jpg');
INSERT INTO `report_form` VALUES (3, 1, '123', '123', '2019-12-10 22:58:47', 1, '0', '20191210225847400.jpg;20191210225847401.jpg');
INSERT INTO `report_form` VALUES (4, 1, '123123', '12312312', '2019-12-10 23:00:01', 1, '0', '20191210230001720.jpg;20191210230001721.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USER_NAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名字',
  `USER_PASSWORD` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `USER_PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `USER_SEX` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户性别',
  `USER_REALNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户真实名字',
  `USER_WECHAT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户微信',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'user', 'user', NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
