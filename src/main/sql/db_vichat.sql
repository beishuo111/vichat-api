/*
 Navicat Premium Data Transfer

 Source Server         : localcon
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : db_vichat

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 23/03/2024 22:29:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户邮箱作为用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码采用MD5加密',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `age` int NULL DEFAULT NULL COMMENT '用户年龄',
  `gender` int NULL DEFAULT NULL COMMENT '用户性别1为男0为女',
  `avator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像路径',
  `isAdmin` int NOT NULL DEFAULT 1 COMMENT '0为管理员1为用户',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '2624924574@qq.com', '123456', '北朔', 23, 1, NULL, 0);
INSERT INTO `user` VALUES (2, '3241238596@qq.com', '123456', '孤影', 22, 1, '', 1);
INSERT INTO `user` VALUES (3, '3241238597@qq.com', '123456', '孤影', 22, 1, '', 1);
INSERT INTO `user` VALUES (4, '3241238599@qq.com', '123456', '孤影', 22, 1, '', 1);

SET FOREIGN_KEY_CHECKS = 1;
