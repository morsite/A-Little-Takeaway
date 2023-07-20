/*
 Navicat Premium Data Transfer

 Source Server         : localhost-mysql
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : takeaway

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 20/07/2023 09:06:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
  `notes` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `mealid` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, NULL, '151', '323', '渤大北门', '聚汇网咖', '4', NULL, NULL, 1);
INSERT INTO `order` VALUES (2, NULL, '123', '432', '黄埔南路道边', '山西刀削面', '0', NULL, NULL, 2);
INSERT INTO `order` VALUES (3, NULL, '141', '645', '新华街12号', '海王府', '4', NULL, NULL, 3);
INSERT INTO `order` VALUES (4, NULL, '156', '753', '中旺一层', '杨国福', '1', NULL, NULL, 4);
INSERT INTO `order` VALUES (5, NULL, '171', '890', '清华园b区', '华莱士', '3', NULL, NULL, 5);
INSERT INTO `order` VALUES (6, NULL, '186', '3976', '清华园a区', '串串香', '3', NULL, NULL, 6);
INSERT INTO `order` VALUES (7, NULL, '197', '436', '清华园c区', '王记凉皮', '2', NULL, NULL, 7);
INSERT INTO `order` VALUES (8, NULL, '133', '457', '聚鑫小区', '马姐早餐', '4', NULL, NULL, 8);

SET FOREIGN_KEY_CHECKS = 1;
