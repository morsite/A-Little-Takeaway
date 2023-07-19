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

 Date: 19/07/2023 07:45:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for buyer
-- ----------------------------
DROP TABLE IF EXISTS `buyer`;
CREATE TABLE `buyer`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '买家id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '买家名',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '买家电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '买家地址',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '买家密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of buyer
-- ----------------------------
INSERT INTO `buyer` VALUES (1, '1', '1', '1', '1');
INSERT INTO `buyer` VALUES (2, '2', NULL, NULL, '2');
INSERT INTO `buyer` VALUES (3, '3', NULL, NULL, '3');
INSERT INTO `buyer` VALUES (4, '4', NULL, NULL, '4');
INSERT INTO `buyer` VALUES (12, '1', NULL, NULL, '1');
INSERT INTO `buyer` VALUES (55, '5', NULL, NULL, '5');

-- ----------------------------
-- Table structure for meal
-- ----------------------------
DROP TABLE IF EXISTS `meal`;
CREATE TABLE `meal`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `sellerid` int NOT NULL COMMENT '商家id',
  `message` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '描述',
  `support` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '是否支持配送',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '蔡明',
  `price` double(10, 2) NULL DEFAULT NULL COMMENT '价格',
  `kind` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '种类',
  `money` double(255, 2) NULL DEFAULT NULL COMMENT '骑手佣金',
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of meal
-- ----------------------------
INSERT INTO `meal` VALUES (1, 1, '一碗香喷喷的阳春面', '支持配送', '阳春面', 9.99, 'mt', 1.00, '/photo/阳春面.jpg');
INSERT INTO `meal` VALUES (2, 1, '一碗绿油油的菠菜面', '支持配送', '生鲜菠菜面', 12.88, 'mt', 1.00, '/photo/菠菜面.jpg');
INSERT INTO `meal` VALUES (3, 1, '一碗红彤彤的西红柿鸡蛋面', '不支持配送', '甜甜番茄鸡蛋面', 15.96, 'mt', 0.00, '/photo/番茄鸡蛋面.jpg');
INSERT INTO `meal` VALUES (4, 2, '一碗面呼呼的鸡肉咖喱', '支持配送', '软烂入味咖喱饭', 10.96, 'mf', 2.00, '/photo/鸡肉咖喱饭.jpg');
INSERT INTO `meal` VALUES (5, 2, '一万突破创新的鸡蛋咖喱饭', '支持配送', '神奇鸡蛋咖喱饭', 10.96, 'mf', 2.00, '/photo/鸡蛋咖喱饭.jpg');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `message` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '买的什么吃的',
  `buyerTelephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '买家电话',
  `sellerTelephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卖家电话',
  `buyerAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '买家地址',
  `sellerAddress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卖家地址',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '订单状态（0:在购物车 1:刚付款未出餐 2:出餐未配送 3:配送中 4:已送达 ）',
  `orderTime` datetime NULL DEFAULT NULL COMMENT '下单时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 638016 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (637904, '软烂入味咖喱饭,2,2', '2', '13470679307', '2', '北京小咪咪', '1', '2023-07-18 10:43:25');
INSERT INTO `order` VALUES (637936, '软烂入味咖喱饭,1,1', '1', '13470679307', '1', '北京小咪咪', '1', '2023-07-18 11:09:14');
INSERT INTO `order` VALUES (637953, '阳春面,1,爆辣多醋多麻油', '1509808533', '15909808533', '中软国际', '北京中关村', '1', '2023-07-18 11:04:07');
INSERT INTO `order` VALUES (638014, '软烂入味咖喱饭,3,3', '3', '13470679307', '3', '北京小咪咪', '1', '2023-07-18 11:00:21');
INSERT INTO `order` VALUES (638015, '软烂入味咖喱饭,1,1', '1', '13470679307', '1', '北京小咪咪', '1', '2023-07-18 10:31:00');
INSERT INTO `order` VALUES (638028, '软烂入味咖喱饭,2,1234', '12', '13470679307', '122', '北京小咪咪', '1', '2023-07-18 10:47:55');

-- ----------------------------
-- Table structure for rider
-- ----------------------------
DROP TABLE IF EXISTS `rider`;
CREATE TABLE `rider`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '骑手id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '骑手姓名',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '骑手电话',
  `commission` int NULL DEFAULT NULL COMMENT '佣金',
  `state` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '状态（0未接单，1正在送餐）',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rider
-- ----------------------------

-- ----------------------------
-- Table structure for seller
-- ----------------------------
DROP TABLE IF EXISTS `seller`;
CREATE TABLE `seller`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '卖家id',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '卖家名',
  `telephone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '卖家电话',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '卖家地址',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sellerstate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of seller
-- ----------------------------
INSERT INTO `seller` VALUES (1, '孙达明方便面', '15909808533', '北京中关村', '999666', '1');
INSERT INTO `seller` VALUES (2, '李亮炒饭', '13470679307', '北京小咪咪', '888888', '1');

-- ----------------------------
-- Table structure for shoppingcar
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcar`;
CREATE TABLE `shoppingcar`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '购物车id',
  `orideId` int NULL DEFAULT NULL COMMENT '商品id',
  `orderMessage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '商品信息',
  `orderTime` datetime NULL DEFAULT NULL COMMENT '商品下单时间',
  `buyerId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '该订单对应购物车的车主id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shoppingcar
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
