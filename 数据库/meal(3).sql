/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80033
 Source Host           : localhost:3306
 Source Schema         : takeaway

 Target Server Type    : MySQL
 Target Server Version : 80033
 File Encoding         : 65001

 Date: 18/07/2023 11:18:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for meal
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sellerid` int NOT NULL COMMENT '商家id',
  `message` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '菜品描述',
  `support` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否支持配送',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '菜名',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `kind` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '种类',
  `money` double(50, 2) NULL DEFAULT NULL COMMENT '佣金',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of meal
-- ----------------------------
INSERT INTO `meal` VALUES (1, 1, '是一种非常古老的菜饭合一的烹饪做法', 'T', '蛋炒饭', 10.00, '米饭', 3.00, NULL);
INSERT INTO `meal` VALUES (2, 1, '又名扬州蛋炒饭，是江苏扬州经典的小吃。', 'T', '扬州炒饭', 13.00, '米饭', 3.00, NULL);
INSERT INTO `meal` VALUES (3, 5, '是一个味道丰富的炒面', 'T', '鸡蛋炒面', 14.00, '面条', 5.00, NULL);
INSERT INTO `meal` VALUES (4, 5, '一碗好吃的炒面', 'T', '肉丝炒面', 16.00, '面条', 5.00, NULL);
INSERT INTO `meal` VALUES (5, 2, '标准的午餐搭配', 'T', '一荤两素', 15.00, '快餐', 5.00, NULL);
INSERT INTO `meal` VALUES (6, 2, '午餐的首选，满足你对午餐的幻想', 'T', '两荤一素', 18.00, '快餐', 5.00, NULL);
INSERT INTO `meal` VALUES (7, 3, '让你品尝到一口好吃的牛排', 'T', '牛排套餐', 50.00, '西餐', 15.00, NULL);
INSERT INTO `meal` VALUES (8, 3, '丰富你的膳食纤维表', 'T', '蔬菜沙拉', 30.00, '西餐', 10.00, NULL);
INSERT INTO `meal` VALUES (9, 4, '一口一个草莓的快感', 'T', '草莓冰点', 20.00, '冰点', 10.00, NULL);
INSERT INTO `meal` VALUES (10, 4, '满足你对芒果冰点的所有幻想', 'T', '芒果冰点', 25.00, '冰点', 10.00, NULL);
INSERT INTO `meal` VALUES (11, 6, '尝遍两种口味', 'F', '鸳鸯锅', 60.00, '火锅', NULL, NULL);
INSERT INTO `meal` VALUES (12, 6, '感受一下麻辣风味', 'F', '清油辣锅', 50.00, '火锅', NULL, NULL);
INSERT INTO `meal` VALUES (14, 1, '一盘朴实无华的炒饭', 'T', '火腿炒饭', 15.00, '米饭', 0.00, NULL);
INSERT INTO `meal` VALUES (15, 1, '一流炒饭', 'T', '蔬菜炒饭', 10.00, '米饭', 3.00, NULL);

SET FOREIGN_KEY_CHECKS = 1;
