/*
Navicat PGSQL Data Transfer

Source Server         : postgres
Source Server Version : 90412
Source Host           : localhost:5432
Source Database       : yikangbao
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90412
File Encoding         : 65001

Date: 2018-02-21 15:48:11
*/


-- ----------------------------
-- Table structure for ykb_hospital
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_hospital";
CREATE TABLE "public"."ykb_hospital" (
"id" varchar(100) COLLATE "default",
"name" varchar(100) COLLATE "default",
"address" varchar(255) COLLATE "default",
"phone_number" varchar(230) COLLATE "default",
"type" varchar(10) COLLATE "default",
"technique" text COLLATE "default",
"level" varchar(255) COLLATE "default",
"created_date" timestamp(6),
"created_by" varchar(50) COLLATE "default",
"updated_date" timestamp(6),
"updated_by" varchar(50) COLLATE "default",
"province_name" varchar(255) COLLATE "default",
"province_id" varchar(255) COLLATE "default",
"status" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ykb_hospital
-- ----------------------------
INSERT INTO "public"."ykb_hospital" VALUES ('0072aed3-e2ea-4057-be83-91183178ac1c', '郑州大学第二附属医院', '河南省郑州市金水区经八路2号', '本部:0371-63934118;北院:0371-63585996;投诉:0371-63974572', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('01021c6a-5955-4aaa-b836-8a70945c2765', '中山大学附属第六医院', '广东省广州市天河区瘦狗岭路17号', '总机:020-38254000;投诉:020-38254011', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THRID', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('01f3b77c-471b-4d49-9f92-4692804ff60f', '广西壮族自治区卫生计生委生殖中心', '南宁市青秀区河堤路73号', '7715343250', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('02046cd1-6fa6-4b4d-b754-bb835a5e1321', '上海市第十人民医院', '上海市延长中路301号', '021-66300588', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('023f2d10-b7a9-4016-ba99-c7dd092e2347', '南阳市第一人民医院', '河南省南阳市宛城区人民路12号', '总机:0377-63310089;咨询:0377-63310163', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('02dec6c1-72d8-4ec0-88ab-f2a713c2d501', '沈阳九州家圆医院', '辽宁省沈阳市沈河区惠工南三路5号', '024-22836666', 'PRIVATE_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0490230c-fe2f-47b2-9161-b98832680984', '邯郸市妇幼保健院', '邯郸市邯山区黎明街6号', '0310-2116069', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('049ba115-3234-4114-b981-27fc0408b07d', '南华大学附属第一医院', '湖南省衡阳市石鼓区船山大道船山路69', '总机:0734-8279008;门诊:0734-8279074;急救:0734-8299120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0669215f-9a70-48c5-82fa-ddc76d393e08', '绍兴市妇幼保健院', '绍兴市东街305号', '总机 : 0575-85138222 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('07fbb367-b702-446a-9715-9cd1ef9d6e73', '临沂市妇女儿童医院', '山东省临沂市清河南路1号', '健康咨询热线：400-6090-776', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('08b9bdf0-0748-46d2-96c6-8542b007c38d', '原南京军区福州总医院', '福州市西二环北路156号', '总机 : 00591-83727698', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0919eda7-6f35-41d0-84e8-84f3b38408f3', '北京大学深圳医院', '广东省深圳市福田区莲花路1120号', '总机:0755-83923333', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('09c5eb90-70eb-4c83-ad2c-f2fede4b47a4', '淄博市妇幼保健院', '山东省淄博市张店区杏园东路11号', '总机:00533-6218989', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0a341a6a-3ebf-4e09-87fc-cf7215981c29', '揭阳爱维艾夫医院', '广东省揭阳市榕城区仙桥头', '6638611513', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0bb21ed0-45ca-4fe8-a18a-9f59e86c7d4c', '宜昌市中心人民医院', '宜昌市夷陵大道183号', '0717-6486947', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0be5d75c-40ee-4124-b7fc-a1c32fd9952d', '青海省人民医院', '青海省西宁市城东区共和路2号', '总机:0971-8177911;预约:0971-8066777', 'PUBLIC_H', '常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '青海省', '5d3d3cd7-2259-4c1e-9883-914b4eae7771', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0c478fb2-c8af-45b5-9917-5cf192c17f54', '上海交通大学医学院附属仁济医院', '上海市浦东新区灵山路845号', '总机 : 021-58752345', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0ca61d19-fe4e-439c-9d2a-5a1646eafbef', '镇江市妇幼保健院', '镇江市正东路20号', '0511-84425601（总值班）；0511-84448272（服务台）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0d1a8a93-647a-40db-a3b3-2e0d14b1bf72', '岳阳市妇幼保健院', '湖南省岳阳市岳阳楼区巴陵中路693号', '0730-8217334', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('0e667e0f-e166-4b1e-ac82-529cbf6f5fdb', '东莞市第三人民医院', '广东省东莞市石龙黄州祥龙路1号', '急救热线：120 （0769）81368333 86620120 咨询总机：（0769）81368666 86612151 预约电话：（0769）81368222 体检热线：（0769）81368070 86629877', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('10d133ef-c5f1-41aa-942b-ec690145dcfa', '深圳市人民医院', '广东省深圳市罗湖区东门北路1017号', '总机:0755-25533018', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('10eb45c4-5e19-43a9-b07b-e90cd93da894', '泉州市妇幼保健院', '福建省泉州市丰泽区丰泽街700号', '总机 : 0595-22130158', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND_A', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('11932859-7356-48bd-8dc0-77e7aa372138', '郴州市第一人民医院', '湖南省郴州市北湖区环城南路', '本部:0735-2343605;南院:0735-2379888;北院:0735-8882627', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('11bb8237-a9fe-40bc-8f8c-abd6989e9d8e', '琼海市中医院', '海南省琼海市加积镇跃华路', '0898-62822767 急症抢救科 - (0898)62816222', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '海南省', '3ab5c96a-3f40-4aa5-8861-ec70ca3d8f34', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('13bf3dad-251a-4a7c-9afd-58f6518858b3', '厦门大学附属第一医院（厦门市第一医院）', '厦门市思明区上古街10号', '总机 : 0592-2130789', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('15696021-c078-4f21-bb14-bcda3d2fa34f', '山西省煤炭中心医院', '太原市小店区学府街101号', '0351-4119317', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THRID', null, null, null, null, '山西省', '6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('19fa6cc9-0069-4b5c-bf9a-8a03f486c07e', '广东省妇幼保健院', '广东省广州市番禺区兴南大道521、523号', '越秀院区:020-61118777;番禺院区:020-39151777', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('19fc54f1-f6b0-45ee-be03-e9540225cf03', '原南京军区南京总医院', '江苏省南京市玄武区中山东路305号', '总机 : 025-80860114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('1a0079da-0fd7-4209-83f5-adfd2aad5e64', '北京大学第一医院', '北京市西安门大街1号', '010-83572211', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('1a662f3e-1841-404e-bc83-a8bbac6dd42b', '济宁市第一人民医院', '山东省济宁市任城区健康路6号', '总机:0537-2253431', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('1b51dbb7-f9e8-40e5-88c1-cf6cd1342a5d', '海军总医院', '北京市海淀区阜成路6号', '010-66958114（总机），010-66958294（服务台）', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('1cb6fd36-905c-4a8c-99a8-5e4933b9082d', '宁波市妇女儿童医院', '宁波市海曙区柳汀街339号', '总机 : 0574-87083300', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('1e692074-1d4f-456d-9a70-53d0878fefe3', '金华市人民医院', '浙江金华市婺城区新华街228号', '总机 : 0579-82324824', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('1eda5b57-82a0-4776-9a64-c4352fd3ec6a', '长沙生殖医学医院', '湖南省长沙市岳麓区枫林三路179号', '客服:0731－88817088', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('1ee5bfcd-6bf1-4e0d-9432-3a09bc3eba71', '邵阳市中心医院', '邵阳市大祥区红旗路乾元巷36号', '总机:0739-5328175;咨询:0739-5320728;投诉:0739-5328350', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('20893b86-4d94-4cf7-9a13-1cf6961e23e6', '贵州省人民医院', '贵州省贵阳市南明区中山东路83号', '0851-5922979', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '贵州省', 'd6074bf7-d1c3-4bbe-a2c4-707c31205edf', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('21341bcd-f0aa-43d2-aaa3-9e699b8b3571', '北京家恩德运医院', '北京市海淀区知春路29号11栋', ' 010-82351133（总机）', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('22347ab2-4733-42f8-a0b4-020acadd868d', '枣庄市妇幼保健院', '山东省枣庄市市中区文化东路25号', '0632-3314584', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'FIRST_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('2241d138-a376-4a52-b5b8-2889e48ac5f8', '福建医科大学附属第一医院', '福建省福州市台江区茶中路20号', '0591-87983333', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('22c6a9f6-c906-48be-96af-d757e2606ff8', '贵阳市妇幼保健院', '贵阳市瑞金南路63号', '0851-5965786', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '贵州省', 'd6074bf7-d1c3-4bbe-a2c4-707c31205edf', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('23787f76-781b-4a2a-a265-62719f1acbcb', '海南医学院第一附属医院', '海口市龙华路31号', '预约挂号：118114、预约门诊：66711900', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '海南省', '3ab5c96a-3f40-4aa5-8861-ec70ca3d8f34', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('238e6fe8-2135-43a2-9697-6aa78a713960', '北京大学第三医院', '北京市海淀区花园北路49号', '010-82266699（总机）', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('24190b46-8339-49c7-a6e3-a93b9ffffe02', '第四军医大学附属唐都医院', '陕西省西安市灞桥区新寺路1号', '总机 : 029-84777777', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '陕西省', '6ad3c9a7-82bc-45ee-9a5f-e5ecde46a893', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('26c184be-e747-4ae8-9c64-e6ddac1212c0', '漯河市第一人民医院', '河南省漯河市召陵区人民东路54号', '0395-3330015', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('27b664d6-3456-4716-b0d9-e85a91921b13', '南昌大学第一附属医院', '江西省南昌市东湖区永外正街17号', '总机 : 0791-88692748', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江西省', 'e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('281402f9-c8e8-4a3a-a896-58757dc682c8', '哈尔滨医科大学附属第一医院', '哈尔滨市南岗区邮政街23号', '总机 : 0451-85556000', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '黑龙江省', '22752702-e2d4-4a7a-bc61-8771ec6eb6e3', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('282a7263-60c1-432a-9fa3-2a98737346f6', '济宁医学院附属医院', '山东省济宁市任城区古槐路79号', '总机:0537-2903399', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('29b8f0e8-ad7d-45a0-a3cd-8edaea8cea10', '中国医科大学附属盛京医院', '沈阳市铁西区滑翔路39号', '总机 : 024-96615', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('2ab92c29-4670-414e-974c-5c25226b598a', '上海市第一人民医院', '上海市松江区新松江路650号', '总机 : 021-63240090', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('2acdeb41-f138-4899-80e3-4d966f010e47', '潍坊市妇幼保健院', '山东省潍坊市潍城区青年路407号', '总机:0536-8089001', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('2afa7f11-de62-46ea-a3ae-437cf1a95e40', '梅州市人民医院', '广东省梅州市梅江区黄塘路63号', '总机:0753-2354244', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('2d675b97-6f04-4059-a4f2-dcebab2e0e4f', '柳州市妇幼保健院', '广西壮族自治区柳州市映山50号', '产科电话 2827333，儿科电2800999
投诉热线：0772-2820611         非上班时间投诉：1397727006', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('2d7f2f12-c22a-4df8-80ab-4c22ef9221f7', '第三军医大学附属西南医院', '重庆市沙坪坝高滩岩正街30号', '总机：（023）65318301 68754000
传真：（023）65317511 68754007
门诊部：68754095
急救部：65343528', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '重庆市', 'dd3b2c8a-5b48-449f-9604-099a2d160c68', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('2f1b0b5f-4ae3-4035-bc96-99c26e8e30b9', '中信湘雅生殖与遗传专科医院', '湖南省长沙市开福区湘雅路84号', '0731-82355100', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'FIRST_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('2fdaa131-4ac4-429c-8489-f52944730863', '沈阳二〇四医院', '沈阳市大东区和睦北二路2号', '024-88435378；88414345', 'PRIVATE_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND_A', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('30c31374-9d5d-489f-9d0c-8e9eeaaafcf3', '郑州大学第三附属医院', '河南省郑州市二七区康复前街7号', '0371-66903131', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('31a5e81f-32cb-41cb-b444-971df5151975', '玉林市妇幼保健院', '玉林市清宁路290号', '咨询:0775-2095103', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3282684b-63be-4450-b9a1-ad7047355e51', '天津和睦家医院', '天津市河西区潭江道天潇园22号', '400-8919191', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '天津市', '9d082c80-03ac-4d12-9d83-e9300012d90f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('32ee5244-6065-422e-bf5d-e141f4d1297b', '深圳市妇幼保健院', '广东省深圳市福强路3012号', '总机:0755-82889999', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3319e7ba-6586-415c-b0ae-b2116f710a10', '汕头大学医学院第一附属医院', '广东省汕头市长平路57号', '0754-88258290/0754-88905000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3406645c-2137-41c3-9ae5-cc8e85e51011', '皖南医学院弋矶山医院', '安徽省芜湖市镜湖区赭山西路92号', '总机 : 0553-5739999', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '安徽省', 'b12dfc5b-d6de-4e3d-803e-1f8bac9e8241', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('34524082-5522-4625-a591-9420d06a480b', '柳州市工人医院', '柳州市柳石路1号', '总机:0772-3815284', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('34f8c57e-55bb-478b-8543-acd2dbfb51e8', '吉林大学第二医院', '长春市南关区自强街218号', '总机 : 0431-88796114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '吉林省', '9514efa1-287b-4afa-b630-e62cfdfd988d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('35c11fd1-b712-4253-aadf-f5e531ec6dca', '中山市博爱医院', '广东省中山市城桂路6号', '总机:0760-88306123', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('36b512c9-c731-4290-bd70-ec8a4722638e', '娄底市中心医院', '湖南省娄底市娄星区长青中街51号', '0738-8527197', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('37603cd9-56c9-4923-8200-5c652cfab8f6', '徐州市中心医院', '徐州市泉山区解放南路199号', '总机 : 0516-83956400', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3793cb35-885a-4479-a6c4-da3709d753f1', '临沂市人民医院', '山东省临沂市解放路东段27号', '总机:0539-8078000;急诊:0539-8216277', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('37c3373d-8c88-4d08-a917-2183277c0b30', '湖南省计划生育研究所', '湖南省长沙市芙蓉区远大一路1292号', '研究与试验发展黄页', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3805afdf-a8ad-40f1-9cf2-1e8ff307ba8a', '首都医科大学附属北京朝阳医院', '北京朝阳区工人体育场南路8号', '010-85231000（总机）', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('393cbe4b-f301-4bd4-923c-2e00c173adc5', '潍坊医学院附属医院', '山东省潍坊市奎文区胜利东街288号', '总机:0536-8652150;预约:0536-8068903', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('39ccaafd-f57a-4d46-acda-713c06b035a8', '河北省人民医院', '河北省石家庄市和平西路348号', '总机 : 0311-85989696', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3a3339aa-0657-41fd-a0d0-d1f84f682465', '湛江久和医院', '广东省湛江市麻章区瑞平路1号', '总机:400-600-5333', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3abadf4b-c41d-4e65-8a45-ddf0dda68aaa', '衡阳南华星辉生殖健康专科医院', '湖南省衡阳市石鼓区解放路30号', '18107346669', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3ae9fa89-b50c-4b39-b861-20c0184613ca', '原北京军区白求恩国际和平医院', '石家庄市中山西路398号', '0311-87998114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3aeceb90-d984-41ff-9019-85f7f1ddb3da', '上海市第一妇婴保健院', '上海市高科西路2699号', '东院 : 021-20261000 ； 西院 : 021-54035206 ； 南院 : 021-58838888', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3bb508ac-2294-487d-b65e-220faec19f45', '清远市人民医院', '广东省清远市清城区新城银泉南路', '0763-3312032', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3bc34385-c2a2-4808-9471-3a850f90fc8f', '四川省人民医院', '四川省成都市龙泉驿区洪河北路585号', ' 急救中心：028-87769262
 医院总机：028-87393999
 门诊热线：028-87393927（工作日）
 投诉电话：028-87393404　028-87713625（工作日）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3c359175-5b7e-4a87-be5a-ebd183ea8ff7', '上海市东方医院', '上海浦东新区即墨路150号 ', '总机 : 021-38804518', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3e61a296-1c84-430b-b27f-f92d7c1cb3ee', '西南医科大学附属医院', '四川省泸州市江阳区太平街25号', '医院咨询电话：(0830)8889120/0830-3165200
医院门诊办公室电话:(0830)3165200
医院急救中心联系电:(0830)3165120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3e810c13-2551-4e2d-851e-dd94e311bf4a', '十堰市人民医院', '湖北省十堰市茅箭区朝阳中路39号', '总机:0719-8637100;急救:0719-8637999', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('3f38620d-29dc-4331-8734-376280047f2c', '广东省人民医院', '广东省广州市中山二路106号', '总机:020-83827812', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('400c0b3e-79df-4443-a872-2fef01dc6d97', '钦州市妇幼保健院', '广西壮族自治区钦州市钦南区安州大道1号', '总机:0777-2398303;急诊:0777-2391552;预约:0777-2397313', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('401f2c70-0518-4473-a008-9c0d92db496d', '南昌康健生殖医院', '江西省南昌市东湖区福州路183号', '79188512512', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '江西省', 'e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4114e012-1227-4cd6-bdb2-e69bc20d6d32', '北京市海淀区妇幼保健院', '北京市海淀区苏州街53号', '总机: 010-62538899', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('428c787e-b61f-4a74-8e7b-73e0278c7f15', '柳州市人民医院', '广西壮族自治区柳州市城中区文昌路8号', '总机:0772-2662000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('42a20726-d972-4403-ba27-58d53ca45579', '福建医科大学附属第二医院', '福建省泉州市丰泽区东海大街', '总机 : 0595-22791140', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('42d230b3-50bc-4a64-8426-224c1f5748ff', '内蒙古自治区人民医院', '呼和浩特市新城区昭乌达路20号', '总机 : 0471-6620000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '内蒙古自治区', 'ab81f864-433c-4fee-bce0-6b780dd9f1a1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4459a722-e3df-4c29-8f5d-e232ac3ab48e', '徐州市妇幼保健院', '徐州市和平路46号', '总机 : 0516-83907016', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4461ed96-00c3-4d4c-b885-f72ffed17fe7', '广西壮族自治区人民医院', '广西壮族自治区南宁市青秀区桃源路6号', '总机:0771-2635268;急救:0771-2186300', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('447fd261-a4c2-4385-ad8f-1269505412e4', '九江市妇幼保健院', '江西省九江市浔阳区甘棠南路61号', '总机 : 0792-8222051', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '江西省', 'e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4557ac65-fabb-4cf4-bcf5-6ab1e6bca4e6', '山东中医药大学附属医院', '山东省济南市历下区文化西路42号', '总机:0534-2637114;急诊:0534-2637120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('46ce9eb2-f6b4-476e-b867-4e1e03fef3e2', '东莞市人民医院', '广东省东莞市万江区新谷涌万道路南3号', '总机:0769-28637333', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('46d62abf-691f-481a-b2ff-96efbfbdd05f', '浙江大学医学院附属邵逸夫医院', '杭州市江干区庆春东路3号', '总机 : 0571-86090073', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('46ecfdcb-544a-482b-bbcb-eb3da6ce2020', '安徽省立医院', '安徽省合肥市庐阳区庐江路9号', '总机 : 0551-62283114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '安徽省', 'b12dfc5b-d6de-4e3d-803e-1f8bac9e8241', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('48386dcb-8874-4bcf-a50c-39acf221600b', '第二军医大学附属长征医院', '上海市凤阳路415号', '总机 : 021-81886999', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('48965e4b-7dc3-44c2-8e9c-9ba47d297495', '哈尔滨红十字中心医院', '哈尔滨市道里区新阳路415号', '总机 : 0451-84886666', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '黑龙江省', '22752702-e2d4-4a7a-bc61-8771ec6eb6e3', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4a06e11d-0f44-4af9-8aee-4ae8d65ef2dd', '重庆市妇幼保健院', '重庆市渝中区金汤街64号', '咨询:023-63702844;投诉:63700223', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '重庆市', 'dd3b2c8a-5b48-449f-9604-099a2d160c68', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4a6e5b82-5b6f-4c7b-a03d-73c72a571e93', '解放军总医院', '北京市海淀区复兴路28号', '010-68182255/66887329(总机)', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4a7c448c-56ca-4b54-8f51-139693a659f5', '河南省人民医院', '河南省郑州市金水区纬五路7号', '总机:0371-65580014;预约挂号电话:0371-65580070;急救中心电话:0371-65580120', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4b467174-7fae-4e0d-8ef2-73b556f7311d', '长沙市妇幼保健院', '长沙市雨花区城南东路416号', '0731-84812190', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4bf5ef5e-8953-4623-9a3e-2d8ca6a579d5', '昆明中英安琪儿妇产医院', '云南省昆明市五华区西站16号', '0871-67379999 /4006-819-222 ', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4c20ccda-92cd-4af0-a9de-7ee3628ae7be', '四川大学华西第二医院', '四川省成都市武侯区人民南路三段20号', '028-85503960', 'PUBLIC_H', '
夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4d001ded-eaff-40ed-b7a0-7d35e2a6a2cc', '山东大学齐鲁医院', '山东济南市历下区文化西路107号', '总机:0531-82169114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4de52145-ff73-48eb-987c-7b7a30fed097', '华中科技大学同济医学院附属协和医院', '湖北省武汉市江汉区解放大道1277号', '027-85726114', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4ed39d3d-f366-42f6-8001-b1aca7af19b8', '空军总医院', '北京市海淀区阜成路30号', '总机 : 010-68410099', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('4f0ba04d-54dc-41eb-8b87-619937157327', '威海市妇幼保健院', '山东省威海市环翠区光明路51号', '5271700/5273700', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RECTIFY');
INSERT INTO "public"."ykb_hospital" VALUES ('4f199252-c3d1-4ffb-b296-ef2bf8cfbf14', '兰州大学第一医院', '兰州市东岗西路11号', '总机:0931-8625200;预约:0931-8625222', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '甘肃省', '27373c18-ecf1-40fc-85b4-6651796acd3e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5168d70b-1627-401f-be59-3e24b9960ba7', '肇庆西江医院', '广东省肇庆市端州区西江北路37号', '0758-2899999', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('53105c56-9e2d-43c2-a288-217d39350efc', '保定市妇幼保健院', '保定市天威中路1号', '总机 : 0312-2022127', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('53d8f406-1118-49a6-95e2-e721f9c71011', '江门市中心医院', '广东省江门市蓬江区海傍街23号', '总机:0750-3165500;急诊:0750-3373123', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('542c6838-fb3e-4dc2-b885-a60e6f2881c5', '原兰州军区兰州总医院', '兰州市七里河区南滨河路333号', ' 0931-8994114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '甘肃省', '27373c18-ecf1-40fc-85b4-6651796acd3e', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('54458154-af9d-4385-aa67-79870c402059', '萍乡市妇幼保健院', '江西省萍乡市安源区跃进南路145号', '0799-6833768（院办公室）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江西省', 'e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('54518abd-c5e7-4765-bcc4-9212c8fe863b', '成都市锦江区妇幼保健院', '四川省成都市锦江区新光华街三官堂街3号', '028-84520828 ，028-86657639    ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_B', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('54675eea-ef55-46ce-9c21-ccfe36eb35d2', '安徽省妇幼保健院', '安徽省合肥市庐阳区益民街15号', '本部 : 0551-62649714', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '安徽省', 'b12dfc5b-d6de-4e3d-803e-1f8bac9e8241', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('553428d6-b129-47f2-84ef-c77652b4dc9f', '荆州市中心医院', '荆州市荆中路60号', '总机:0716-8881888;急救:0716-8496417', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('55391296-21e8-4eff-bb16-70df794cd6f4', '河南中医学院第三附属医院', '河南省郑州市金水区东明路63号', '0371-65575586', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THRID', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('56cd145e-0e8f-44a7-888a-22f2873d0413', '十堰市太和医院', '湖北省十堰市茅箭区人民中路人民南路32号', '总机:0719-8801114;咨询:0719-8801880;预约:0719-8801668;急诊:0719-8881999;投诉:0719-8801555', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('578363cb-fe9c-40f2-97e7-21714d91ae4a', '内蒙古医科大学附属医院', '内蒙古呼和浩特市通道北街1号', '咨询 : 0471-6636126', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '内蒙古自治区', 'ab81f864-433c-4fee-bce0-6b780dd9f1a1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('581296f1-5b08-4b40-9a04-68eb9d5a5ec6', '东莞市妇幼保健院', '广东省东莞市振兴路99号', '总机:0769-22238375', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5838f04c-5add-4cd6-a421-3f223b0f7b7c', '吉林省人民医院', '吉林省长春市朝阳区工农大路1183号', '总机 : 0431-85595114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '吉林省', '9514efa1-287b-4afa-b630-e62cfdfd988d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('59244b3c-c801-45dc-af79-f7c61fe74421', '原广州军区广州总医院', '广东省广州市流花路111号', '020-88653111 020-29055511', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('59b9d7d1-e2ba-464b-b690-da6bafcda05b', '广州市妇女儿童医疗中心', '广东省广州市金穗路9号', '总机:020-81886332;儿童院区:020-81330713;妇婴院区:020-81886910;珠江新城院:020-38076461', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5a153ce1-6e71-4b78-9b68-10dd5b9fd2ed', '无锡市妇幼保健院', '无锡市槐树巷48号', '总机 : 0510-82713324 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5b76a05e-24f4-484c-8d49-55cebdd66257', '运城市中心医院', '运城市河东东街3690号', '总机 : 0359-6399114 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山西省', '6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5bf35e90-dad6-4f8d-a64e-e9a0bee67d2a', '苏北人民医院', '扬州市南通西路98号', '总机 : 0514-87330446', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5ce08a76-09b4-427d-9d93-3dd7f85f87f0', '南京鼓楼医院', '南京市中山北路53号', '总机 : 025-83304616', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5d3fe76a-f430-4e20-9494-90875db178e2', '大连市妇女儿童医疗中心', '辽宁省大连市甘井子区体育新城规划一号路1号、3号', '0411-66861111', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5d709bf6-55ad-4344-ba98-5eaf39a9822f', '深圳市罗湖区人民医院', '广东省深圳市罗湖区友谊路47号', '0755-25650005', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5db6ab8a-5bc1-4b6d-a492-ad567c346366', '河北医科大学第二医院', '石家庄市新华区和平西路215号', '0311-87046901（总机）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5eeed4d5-f983-4271-9204-1a7d7582a23c', '江苏省人民医院（江苏省妇幼保健院）', '南京市江东北路368号', '总机 : 025-86211033', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术

', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5f2e08fc-5bf4-4b1b-bc53-1edf23bdd2c8', '中山大学附属第三医院', '广东省广州市天河路600号', '020-85253333', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5f6b5f40-f881-4b9d-970a-3c291a890eba', '海南医学院第二附属医院', '海口市白水塘路48号', ' 0898-66822678', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '海南省', '3ab5c96a-3f40-4aa5-8861-ec70ca3d8f34', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('5f6baeb0-c2d5-4b48-af7e-180699265655', '原济南军区总医院', '山东省济南市天桥区师范路25号', '0531-51666114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('601ddae2-6164-47f2-b272-736e9d58f18a', '湖州市妇幼保健院', '湖州市吴兴区东街2号', '总机 : 0572-2210114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('60a98f8d-2b50-4d18-ba5e-dacb22ea0cd5', '天津医科大学总医院', '天津市和平区鞍山道154号', '总机 : 022-60362288', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '天津市', '9d082c80-03ac-4d12-9d83-e9300012d90f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('60c4595b-1e4d-40cb-b54e-bb72bac0c4da', '宁夏医科大学总医院', '宁夏回族自治区银川市兴庆区胜利街804号', '总机:0951-6744200;投诉:0951-6744560', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '宁夏回族自治区', 'f4552e32-231e-41c3-827e-25b19d685790', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6344c342-9b17-4630-91e0-f2b81385e04e', '贵州医科大学附属医院', '贵阳市云岩区北京路', '0851-6855119', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '贵州省', 'd6074bf7-d1c3-4bbe-a2c4-707c31205edf', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('637f08da-6edf-4a05-ab5d-b7bcff33de58', '广东省中医院大学城医院', '广东省广州市番禺区大学城内环西路55号', '总机:020-39318100;急诊:020-39318101', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('64793df3-a40e-4508-b901-ef905fa9ea04', '华中科技大学同济医学院附属同济医院', '武汉市硚口区解放大道1095号', '027-83662688', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('648306fa-62dd-446d-87dc-714fb1bfdc38', '长治医学院附属和平医院', '长治市延安南路110号', '总机 : 0355-3033613', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山西省', '6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('656056e6-ea9d-4ab6-a358-0562a4e0b9f6', '沧州市妇幼保健院', '沧州市浮阳北大道92号', '总机 : 0317-2208120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THRID', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6570231a-9699-465b-b914-be1cc1025b76', '岳阳市第一人民医院', '岳阳市岳阳楼区东茅岭路39号', '0730-8246724', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('657a83ff-af36-44ff-bc95-45e6c5bccf52', '武汉康健妇婴医院', '湖北省武汉市汉阳区汉阳大道505号', '联系电话:02784512512', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('664e195d-75fe-4fa7-ab59-f50317555fac', '韶关市妇幼保健计划生育服务中心', '广东省韶关市武江区惠民北路12号', '0751 8618280
8618280', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('666c945b-1e91-4ede-97e9-053443d15a45', '北华大学附属医院', '吉林市解放中路12号', '总机 : 0432-62166000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '吉林省', '9514efa1-287b-4afa-b630-e62cfdfd988d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6822f5a1-a04d-4da9-afb4-92b8fd36ade3', '东南大学附属中大医院', '南京市新模范马路3号', '总机 : 025-83272111', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('68719fc6-1b37-4299-b3ac-399e78489764', '第二军医大学附属长海医院', '上海市杨浦区长海路168号', '总机 : 021-31166666', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6878651b-d63e-4028-9fa2-fb2cf216ef8d', '云南省人口和计划生育科学技术研究所', '云南省昆明市五华区青年路146号', '电话：0871-65155674 办公室电话：0871-65155674', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('69c6b850-8969-40c0-9b4d-5fa998a9b796', '湖北省妇幼保健院', '湖北省武汉市洪山区武珞路745号', '总机:027-87169200;徐东:027-86709165;预约:027-82770438;投诉:027-87648922', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6ae987f1-67ae-4b2b-bd88-260f71db21bb', '南宁市第二人民医院', '广西壮族自治区南宁市江南区淡村路13号', '总机:0771-2246258', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6b71e4cb-ee8a-49e1-87b5-c9a43b16416b', '原北京军区第254医院', '天津市河北区黄纬路60号', '022-26220266', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '天津市', '9d082c80-03ac-4d12-9d83-e9300012d90f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6e645b2c-273c-4d1b-a28f-f38ec4e52dd4', '上海交通大学医学院附属新华医院', '上海市控江路1665号', '总机 : 021-25078999', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6e8b2092-8ebd-470b-90b7-643d25a83117', '常德市第一人民医院', '湖南省常德市武陵区人民东路818号', '总机:0736-7788113;门诊:0736-7788131;咨询:0736-7788175', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6eab7b53-cea1-412f-801c-ada97d9a81bb', '赣州市人民医院', '江西省赣州市章贡区红旗大道17号', '总机 : 0797-8122311', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江西省', 'e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('6f1f65da-b441-4c6b-b96d-9fb65f35471e', '佛山市妇幼保健院', '广东省佛山市人民西路11号', '总机:0757-82969789;急救:0757-82969993;投诉:0757-82969789', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('70451442-f60c-484d-99a4-2654cc34d857', '郑州大学第一附属医院', '河南省郑州市大学路43号', '总机:0371-66913114;预约:0371-66913177', 'PUBLIC_H', '
夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('70a66d03-4af8-47fc-9ce1-f16697915f50', '山东大学附属生殖医院', '山东省济南市市中区经六路157号', ' 0531-87909000(咨询),0531-55557060', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'OTHER', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('70eeaf53-ada9-4200-8a3a-af63e3f59822', '武警广东总队医院', '广州市天河区燕岭路268号', '020-61627499', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('71ed0326-dc76-4004-83d2-df34d844ae76', '武汉市中西医结合医院（武汉市第一医院）', '武汉市中山大道215号', '027-85860666', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('73a380ca-fe5a-419c-8d0a-64b47575a505', '淮安市妇幼保健院', '淮安市人民南路104号', '总机 : 0517-83964729', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('748f4d30-e65f-453c-b28c-ec0a4be19e43', '嘉兴市妇幼保健院', '浙江省嘉兴市南湖区中环东路2468号', '总机 : 0573-82066132', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('74e0932e-1b7d-4431-98be-c06ca9710bd6', '汕头市中心医院', '广东省汕头市外马路114号', '总机:0754-88550450;预约:0754-88908890;投诉:0754-88523231', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('755d7334-4438-4139-97bd-6f6d03088378', '广东省计划生育专科医院', '广东省广州市越秀区梅东路17号', '人工授精咨询电话：020-87651527  精子库电话：020-37652806', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('75954d3e-ee81-43cb-870e-b37c064a6218', '邯郸市中心医院', '河北省邯郸市丛台北路59号', '总机 : 0310-2118000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('763641e4-a64d-4458-816c-adaae91dbba0', '上海市同济医院', '上海市新村路389号', '总机 : 021-56051080', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7797edd4-30ac-495e-8cac-290f944c67da', '唐山市妇幼保健院', '河北省唐山市路南区建设南路14号', '0315-3726688（院办公室），0315-2824751', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7951918e-6d81-404e-a9e1-fd0df490a325', '桂林市妇幼保健院', '广西壮族自治区桂林市叠彩区凤北路20号', '0773-2836100 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THRID', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7952642e-15aa-42a6-85a1-de7675cecadf', '上海永远幸妇科医院', '中国（上海）自由贸易试验区富特西一路477号四层A58', '021-50181111；021-50180680', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('79dd49b7-2280-4002-bfc3-de11a745fd2d', '天津市中心妇产科医院', '天津市南开三马路156号', '022-58287388', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '天津市', '9d082c80-03ac-4d12-9d83-e9300012d90f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7a5d9a00-bbf9-44da-8a95-883d88314121', '南京医科大学附属第二医院', '南京市鼓楼区姜家园121号', '025-58509900', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7a8bea02-9207-4b36-b449-68b199ca39e5', '中山大学孙逸仙纪念医院', '广东省广州市沿江西路107号', '020-81332199/81332372', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7ada5aba-7976-4e75-bda6-67d57fa7733e', '盐城市妇幼保健院', '盐城市毓龙西路34号', '0515-88322751', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7b4c1816-05b9-4a50-a69d-38ba18916127', '香港大学深圳医院', '广东省深圳市海园一路1号', '0755-86913333 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THRID', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7c4d368b-205d-4f2c-b5a7-241f3596b1d0', '泰州市人民医院', '泰州市海陵南路399号', '南院 : 0523-86361510 ； 北院 : 0523-86606342 ； 门诊部 : 0523-86361511', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7dd6217c-758e-4083-8fed-0e9fbf2611bb', '湖南省妇幼保健院', '湖南省长沙市开福区湘春路53号', '总机:0731-84332201;投诉:0731-84332127', 'PUBLIC_H', '常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('7f7f0835-eeeb-442b-ab3f-b879cca5284e', '原南京军区第174医院', '厦门市文园路94-96号', '0592-6335500/6335600/6335700', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('80dc65cd-1540-4c60-aa09-44d9b375c878', '南昌市医科所附属医院', '江西省南昌市青云谱区井冈山大道198号', '总机 : 0791-87553777', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THRID', null, null, null, null, '江西省', 'e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('821c0199-c199-4672-b26f-a4e6bed8ae74', '成都市妇女儿童中心医院', '成都市青羊区日月大道1617号', '028-87467888
028-61866186', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('84641ab7-b3b3-498c-990d-b9d36807d2ba', '河北医科大学第四医院', '石家庄市长安区健康路12号', '0311－86095588', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('84b95dd8-acbd-4410-9558-e44c0e72462b', '北京家圆医院', '北京市西城区富国街2号及附楼', ' 总机 : 010-66117776', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8559118b-f533-4063-8e1d-27bad4613062', '潍坊市人民医院', '山东省潍坊市奎文区广文街151号', '总机:0536-8192599;急诊:0536-8192120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('856c7737-a776-4fc3-9225-2669c2be0522', '山西省人口计生委科学研究所附属不孕不育专科医院', '太原市小店区平阳路北园街11号', '0351-7242195', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'FIRST_A', null, null, null, null, '山西省', '6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('879737a0-bd44-4304-81af-a657fb21d441', '赤峰生殖健康专科医院', '红山区长青街中段', '0476-8331539 0476-8333171', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '内蒙古自治区', 'ab81f864-433c-4fee-bce0-6b780dd9f1a1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('883cf7a9-260e-4d81-bc1f-966beaefbdc8', '遵义医学院附属医院', '贵州省遵义市汇川区大连路149号', '0852-8623430;急诊:0852-8648999;门诊:0852-8609213;预约:0852-8609214', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '贵州省', 'd6074bf7-d1c3-4bbe-a2c4-707c31205edf', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('887ef550-63dc-4c76-afa4-6707cfc3d9c2', '广州市第一人民医院', '广东省广州市越秀区盘福路1号', '020-81048888/81048000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8a0b991f-07ec-4d3d-8bbc-7f07ce1a8b9c', '三峡大学仁和医院', '湖北省宜昌市伍家岗区夷陵大道410号', '总机:0717-6551228;预约:0717-6553992', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THRID', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8a65e012-4a3b-47b2-a39c-11952a012aab', '重庆医科大学附属第二医院', '重庆市渝中区临江路76号', '总机:023-63693000;咨询电话:023-63693138;门诊电话:023-63693164;急救电话:023-63693003', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '重庆市', 'dd3b2c8a-5b48-449f-9604-099a2d160c68', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8ac2a183-53e2-4d44-8f10-76a54dd253fd', '昆明医科大学第二附属医院', '昆明市五华区滇缅大道374号', '0871-65351281', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8bb35d8c-66a4-4b37-874e-bafbc3cdf400', '原南京军区第455医院', '上海市长宁区淮海西路338号', '021-81815122', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8bb6490e-24cd-4be5-9d32-7b9caa0d6ae2', '上海交通大学医学院附属瑞金医院', '上海市瑞金二路197号', '总机 : 021-64370045', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8c49f934-299c-4906-8048-4fae20f79854', '荆州市第一人民医院', '荆州市沙市区航空路8号', '咨询:0716-8111888;急救:0716-8111999', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8d362ebb-857e-49b9-b8c9-1acac5536a0c', '中山大学附属第一医院', '广东省广州市中山二路58号', '020-82377155', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8d6bbd0e-d272-45f4-a35f-37bdf97e49e0', '衡水卫生学校附属医院', '衡水市红旗大街职业教育园区卫校院内', '0318-2115154', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术

', 'SECOND_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8fe4eb2b-9bc4-4093-ae02-d0fd932230f1', '南京市妇幼保健院', '南京市莫愁路天妃巷123号', '总机 : 025-52226777', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('8fecbd80-60c1-4825-bbe0-e0897b12ff16', '南通大学附属医院', '南通市西寺路20号', '总机 : 0513-85052504 ； 咨询 : 0513-85052222', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('90258a47-9aa2-49fb-b44e-1e0e0511f43d', '南方医科大学南方医院', '广东省广州市广州大道北1838号', '总机:020-61641114;预约:020-61641888', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('9026652d-5fab-407b-9114-8fda3b516ca4', '赣州市妇幼保健院', '江西省赣州市章贡区大公路106号', '0797-8282022（医务科），0797-8222258（院办）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江西省', 'e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('9167205a-d285-463a-9a81-953615a439bc', '天津美津宜和妇儿医院', '天津市南开区水上公园东路阳光公寓6号楼', '022-58982012', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '天津市', '9d082c80-03ac-4d12-9d83-e9300012d90f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('927d6b88-da1c-4adb-a73e-682bb03f51b5', '中国医学科学院北京协和医院', '北京市东城区王府井帅府园1号', '010-69156114（总机）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('930a853a-28f0-4e76-801a-6112399ee2c1', '广西医科大学第一附属医院', '广西壮族自治区南宁市青秀区双拥路6号', '东院:0771-5356566;西院:0771-3277068', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('93f939ba-d13e-45f0-a137-c717f10d85c0', '安徽医科大学第一附属医院', '合肥市蜀山区绩溪路218号', '总机 : 0551-62922114', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '安徽省', 'b12dfc5b-d6de-4e3d-803e-1f8bac9e8241', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('962f7e0d-8195-4562-ab0c-3897fe5ccedd', '衡水市人民医院', '衡水市人民东路180号', '总机 : 0318-2181234', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('96522803-19eb-4b87-a85c-90b6ff3d13bd', '广州市番禺区何贤纪念医院', '广东省广州市番禺市桥清河东路2号', '总机:020-84622450', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('99488d7e-aacd-4c3e-a1ce-84fe5bd66a81', '沈阳东方医疗集团菁华医院', '辽宁省沈阳市和平区南京南街156号', '024-23383522 ；024-23399369', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'FIRST_A', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('9abb0483-b98a-4616-8958-ce732b6246ce', '聊城市人民医院', '山东省聊城市东昌西路67号', '总机:0635-8276110;急诊:0635-8276120;投诉:0635-8276227', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('9ae90794-3fae-4bfd-bc72-d7a0d73b8068', '原广州军区第181医院', '桂林市新桥园路1号', '0773—2081181', 'PUBLIC_H', '
夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('9b6c6b3e-c28b-4653-a086-b72c6b596a27', '华中科技大学同济医学院生殖医学中心', '武汉市江岸区三阳路128号三阳广场1-4层', '(027)82742288', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'FIRST_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('9b8527b8-b8eb-4093-8d5a-a999a7d863d5', '舟山市妇幼保健院', '浙江省舟山市定海区人民南路30号', ' 总机 : 0580-2065007', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('9e36f903-88b5-4298-9892-538d53d05347', '陆军总医院', '北京市东城区东四十条南门仓5号', '总机 : 010-66721629', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a04a2d60-5a2a-4e08-b1cf-4bcd5e5e2311', '珠海市妇幼保健院', '广东省珠海市香洲区柠溪路543号', '总机:0756-2313115', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a0b9c46c-b81f-463c-be4e-d2d019068d9d', '邵阳汇恩生殖健康专科医院', '邵阳市大祥区火车南站站前区金泉.绿景苑', '13807396611', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a169254d-18f7-493f-9e84-48208a038167', '南通市妇幼保健院', '南通市世纪大道399号', '总机:0513-59008000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a16faf66-6dc1-4ab0-aa8d-e72a9639da90', '原济南军区第91医院', '河南省焦作市工业路239号', '0391-3597988/0391-3934160', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a2abbc7f-a04e-49b0-8a08-5621a99797f3', '重庆医科大学附属第一医院', '重庆市袁家岗友谊路1号', '023-68811360', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '重庆市', 'dd3b2c8a-5b48-449f-9604-099a2d160c68', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a3f404c6-6e8c-4890-b293-ba628f5d2f00', '天津市第一中心医院', '天津市南开区复康路24号', '总机 : 022-23626600', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '天津市', '9d082c80-03ac-4d12-9d83-e9300012d90f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a4105149-7889-437b-a3a8-6aca3967da8a', '上海市第六人民医院', '上海市宜山路600号', '总机 : 021-64369181', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a4857d0a-119e-4acb-8b35-688328e7f88a', '山西医科大学第一医院', '太原市解放南路85号', '总机 : 0351-4639114', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山西省', '6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a6004295-0341-4464-9802-65d8f5479812', '成都西囡妇科医院', '四川省成都市成华区光明滨河路', '客服:028-84331933;高新区:028-65106666', 'PRIVATE_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a706a244-d0f1-4a43-b6e4-50e5c3ac9259', '青岛市妇女儿童医院', '山东省青岛市市北区辽阳西路217号', '总机:0532-68661155', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a8e1f874-048b-458c-a2ee-60b9dd0fe3a3', '广东省第二人民医院', '广东省广州市海珠区赤岗石榴岗路1号', '总机:020-89168114;咨询:020-89168888;急救:020-89168120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a961c2fb-3b83-4fe7-acca-346785b4774f', '沧州中西医结合医院', '河北省沧州市黄河西路31号', '总机 : 0317-2078625', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('a9e19e03-012d-4b44-b81d-7cf6fc9ea4da', '江西省妇幼保健院', '江西省南昌市东湖区八一大道318号', '总机 : 0791-86224432', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '江西省', 'e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('aabb9d9f-5ebd-436e-bafb-b607e5743b05', '邢台不孕不育专科医院', '河北省邢台市东关街41号', '0319-3021530', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ab4febb1-e8e4-4fac-8f2c-12f33689a59b', '广州医科大学附属第三医院', '广东省广州市荔湾区多宝路63号', '020-95169', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('acb5dd64-67e7-4e4c-9b55-ab93c00b4fd9', '吉林大学第一医院', '长春市朝阳区新民大街71号', '总机 : 0431-88782222', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '吉林省', '9514efa1-287b-4afa-b630-e62cfdfd988d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ad17cd38-c75a-4053-8e7a-e421ad7811ab', '北京宝岛妇产医院', '北京市海淀区新街口外大街1号', '4006131760；010-62006666', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ad4f82f7-1ebd-4c78-91fe-732ce14b84f7', '昆明市第一人民医院（甘美国际医院）', '昆明市北京路1228号', '0871-67390506', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ad5aacef-dee6-48eb-adcd-22c2ea3b1681', '北京大学人民医院', '北京市西城区西直门南大街11号', '010-88326666（新院总机），010-66583666（老院总机）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ad6d9ec4-af9b-4b55-9376-da545de3fe57', '新乡医学院第三附属医院', '河南省新乡市新延路', '0373-3029611/3029600', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ae574c42-a372-428e-908d-a3086ccf5bcc', '锦州市妇婴医院', '辽宁省锦州市古塔区解放路3段2号', '总机 : 0416-3856199', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_A', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ae96bf7b-aa7d-45f1-be80-1432af6f128c', '浙江大学医学院附属第一医院', '浙江省杭州市上城区庆春路79号', '总机 : 0571-87236114', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('af398e25-51cc-4ab8-ac96-ee6001b98408', '河北省计划生育科学技术研究院', '石家庄市新华区和平西路480号', '0311-87046543；0311-87066098', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'FIRST_B', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('af46bc03-9077-42f8-8f57-f5e06be325e8', '鞍山市妇儿医院', '辽宁省鞍山市铁西区三道街115号', '总机 : 0412-8522734', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THRID', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b0a9a4de-13c6-4eba-97fd-d8ee801b61ba', '佛山市第一人民医院', '广东省佛山市禅城区岭南大道北81号', '0757-83833633', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b1c414ae-cfd0-4c61-92bf-713efb8e8fb0', '中国福利会国际和平妇幼保健院', '上海市衡山路910号', '总机 : 021-64070434', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b2026e13-d513-418b-ac98-9a2fca6657e5', '丽水市人民医院', '浙江省丽水市莲都区万丰东路58号', '总机 : 0578-2780222', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b3fbe216-a15e-431b-97aa-ae0cc527964f', '深圳中山泌尿外科医院', '广东省深圳市福田区福强路1001号', '总机:0755-82175393', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b4b16408-7481-4c12-9253-e76e05b8549b', '连云港市妇幼保健院', '连云港市海州区苍梧路10号', '总机 : 0518-85833426 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b5df0547-9b07-4fe0-a96e-467597633c60', '海南和京生殖医院', '海南省海口市龙华区海秀中路119号', '089868921905/0898-68961120', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_B', null, null, null, null, '海南省', '3ab5c96a-3f40-4aa5-8861-ec70ca3d8f34', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b65cb209-8107-432a-84bc-3ab5636f8cbf', '云南九洲医院', '云南省昆明市盘龙区联盟街道白云路229号', '400-664-5550', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b69128af-c6ee-4305-a417-353aa34a8f2c', '中南大学湘雅二医院', '湖南省长沙市芙蓉区人民中路139号', '0731-84812190', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b77b8aee-d655-4175-8fed-95dc2db999cb', '昆明医科大学第一附属医院', '云南省昆明市五华区西昌路295号', '0871-5324888', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b873677d-1446-4f64-8cb9-b0e57d115538', '上海集爱遗传与不育诊疗中心', '上海市方斜路588号', '021-65138116', 'PRIVATE_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'OTHER', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('b8c2b104-0145-4e4c-8790-0a8cd95a6ffe', '洛阳市妇女儿童医疗保健中心', '河南省洛阳市西工区玻璃厂路12号', '总机:0379-63258363;急诊:0379-63232120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('bb7d38fb-d555-490e-a044-18c1d033880d', '厦门市妇幼保健院', '福建省厦门市思明区镇海路10号', '总机 : 0592-2662020', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('bc8fa9fa-ccc2-4c57-92b3-7b6acaec428f', '武警后勤学院附属医院', '天津市东丽区成林道220号', '022-60578778', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '天津市', '9d082c80-03ac-4d12-9d83-e9300012d90f', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('bcb9da1f-fb7d-4f61-9a1e-0cdf45f04ce5', '东莞广济医院', '广东省东莞市凤岗镇雁田镇田北路', '总机:0769-27227518', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('bce29245-23d7-4699-852b-e3091642d94b', '佛山市顺德区妇幼保健院', '广东省佛山市顺德区保健路3号', '0757-22636983', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('bd524ed6-3949-409e-8f4b-c803a38eac18', '江苏省中医院', '南京市汉中路155号', '总机 : 025-86618472', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('bdf17d65-03f1-4c90-9f62-e45e023f4a27', '常州市妇幼保健院', '常州市博爱路16号', '总机 : 0519-88108181', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('bec388d5-d1a8-4463-9703-4ddec23e6cc9', '天津爱维医院', '天津市河东区华龙道12号', '400-022-8987', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND', null, null, null, null, '天津市', '9d082c80-03ac-4d12-9d83-e9300012d90f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c15410e4-a658-48d4-a5c8-4a94ff8d2cd0', '长春市妇产医院', '长春市南关区西五马路555号', '总机 : 0431-82943333 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '吉林省', '9514efa1-287b-4afa-b630-e62cfdfd988d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c1e012c5-84dc-49dc-94ef-65d9a7f263d5', '东莞康华医院', '广东省东莞市东莞大道1000号', '总机:800-900-3333', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c2ad11fa-37d2-46cd-b418-314040c0ede0', '西藏阜康妇产儿童医院', '拉萨市城关区罗布林卡路18号', '18089908183/400-6151-120', 'PRIVATE_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '西藏自治区', '065a80fc-75c3-4540-b5f3-99506ec65bce', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c32cd07c-2aea-4084-8e2b-5ed85cbbf9a4', '温州医科大学附属第一医院', '温州市鹿城区府学巷2号', '总机 : 0577-55578166', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c365d7cf-6dc4-401a-805f-6dc25f07f019', '惠州市中心人民医院', '广东省惠州市横江四路8号', '总机:0752-2288288;急救:0752-2288120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c41bbb40-7489-44f0-850f-cf3f9a4b3968', '浙江省人民医院', '浙江省杭州市下城区上塘路158号', '本部 : 0571-85239988 ； 望江山院区 : 0571-85892308', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c4eec078-74f5-428f-a8e8-62a9a590495e', '齐齐哈尔市第一医院', '齐齐哈尔市龙沙区公园路20号', '总机 : 0452-2425981', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '黑龙江省', '22752702-e2d4-4a7a-bc61-8771ec6eb6e3', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c4f0ccf2-27f9-49fb-bbe7-03bc525090ac', '云南省第二人民医院', '云南省昆明市五华区青年路176号', '0871-65156650', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c56f8938-f051-4f89-9cc2-ba0207982a0f', '成都中医药大学第二附属医院', '四川省成都市武侯区人民南路四段17号', '028-85229280', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_A', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c6b29a28-8f17-4f3e-b07b-4b4af67f6de7', '中南大学湘雅医院', '湖南省长沙市开福区湘雅路87号', '0731-84327198', 'PUBLIC_H', '
夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c71b7215-6791-40ca-b4b0-1501ee7e4135', '西北妇女儿童医院(陕西省妇幼保健院)', '陕西省西安市新城区后宰门73号', '029-87234916', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '陕西省', '6ad3c9a7-82bc-45ee-9a5f-e5ecde46a893', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c84c755e-fd90-4373-a25f-a810a66dee49', '桂平市人民医院', '广西壮族自治区市桂平市西山镇人民西路7号', '(0775)3382376/400 617 3599 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('c9dba753-4f9e-48b4-b259-acca38584516', '厦门安宝医院', '厦门市思明区湖滨南路117-119号', '400-617-3599（电话错）', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'OTHER', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('cb435222-eeb7-4796-9dc7-ac1ec42ec837', '新疆佳音医院', '新疆乌鲁木齐市水磨沟区南湖北路48号友好花园三期13号楼佳音医院', '0991-5167788', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '新疆维吾尔自治区', '076dd97c-46ae-43c4-90c1-260238c6a24a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('cb6ba4a3-631e-4d04-8c79-92e0c58b3dde', '德州市人民医院', '山东省德州市新湖大街1751号', '总机:0534-2637114;急诊:0534-2637120', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('cc157620-8d54-4773-a8e5-0e58855998ad', '银川市妇幼保健院', '宁夏回族自治区银川市兴庆区文化西街56号', ' 0951-6882061', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '宁夏回族自治区', 'f4552e32-231e-41c3-827e-25b19d685790', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('cec62cf9-c5af-45ab-8738-24c1c792cd2a', '海南省妇幼保健院', '海口市龙昆南路15号', '咨询:0898-36689119', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THRID', null, null, null, null, '海南省', '3ab5c96a-3f40-4aa5-8861-ec70ca3d8f34', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ceffba5a-0a5f-46e2-beba-ee5c5fb6f141', '昆明市妇幼保健院', '昆明市丹霞路2号银宏大厦一、二、三楼', '0871-63624024;保健中心:0871-63626610', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('cf00c0d6-4198-49f3-b91b-3e0047136806', '株洲市中心医院', '湖南省株洲市天元区长江南路116号', '总机:0731-28561122;预约:0731-28561108', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('cfbb7b4b-e5ed-4040-bb0e-816466ffaef8', '襄阳市中心医院', '湖北省襄阳市襄城区荆州街39号', '0710-352349', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d12841a1-db74-479c-950e-050151850196', '河北医科大学第一医院', '河北省石家庄市裕华区东岗路89号', '总机 : 0311-85917000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d1b165a8-5a83-43de-b2a2-a49c3fd4bd99', '广西壮族自治区妇幼保健院', '广西壮族自治区南宁市西乡塘区新阳路225号', '总机:0771-5802205;投诉:0771-5802014;新阳院区:0771-3152428；厢竹院区:0771-2860500', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d1b430a8-0358-4846-a3d6-ea763a78ee4c', '武汉大学人民医院', '湖北省武汉市武昌区解放路238号', '027-88041911', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d3a8213d-c0e1-4140-849f-8ce2e727cdcd', '西安市第四医院', '陕西省西安市新城区解放路21号', '总机:029-87420006', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '陕西省', '6ad3c9a7-82bc-45ee-9a5f-e5ecde46a893', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d4d80440-348e-48cb-9ad3-20d4b55b9383', '台州医院恩泽妇产医院', '浙江省台州椒江区椒江东环大道353号', '0576-81837999', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d570476f-9aa9-4ae4-9b3c-59637b77265f', '东莞东华医院', '广东省东莞市东城东路一号', '总机:0769-22333333', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d5a92e52-a698-4bd4-8d64-f39c1c4dc4f6', '青岛大学附属医院', '山东省青岛市崂山区海尔路59号', '本部:0532-82911847;黄岛分院:0532-82918181;东部分院:0532-82913225;市北院区:0532-82912729;预约:0532-82911219', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d6aca716-b6d2-458a-82a4-19b1acef41a1', '云南省第一人民医院', '云南省昆明市西山区金碧路157号', '总机:0871-3639921', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d6d2e59c-9c72-4437-8c44-a2b331fbaf3b', '太原市中心医院', '太原市解放南路东三道巷5号', '总机 : 0351-5656000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山西省', '6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d7117b4b-6290-4c9c-8a30-9ae86b2f8d93', '武汉大学中南医院', '武汉市武昌区东湖路169号', '总机:027-67812888;咨询:027-67812999;预约:027-67812924', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d742a7fb-0435-4073-95c7-253d91957df6', '温州医科大学附属第二医院', '温州划龙桥路306号', '总机 : 0577-88816381', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d8556dc1-f1e9-4fa6-b643-804f4703f5d8', '上海交通大学医学院附属第九人民医院', '上海市制造局路639号', '总机 : 021-23271699', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d8ae08e3-8c7a-4d88-bf33-9e6347da1900', '皖北煤电集团总医院', '宿州市埇桥区淮河西路125号', '0557-3972555', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '安徽省', 'b12dfc5b-d6de-4e3d-803e-1f8bac9e8241', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('d968c76d-1682-481e-8824-94eee3290e80', '石家庄市妇产医院', '石家庄市长安区中山东路206号', '本部 : 0311-85281699 ； 东院 : 0311-89911788', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('dad317cc-8313-4118-a80c-500cf9de876b', '原广州军区武汉总医院', '湖北省武汉市武珞路627号', '027-87383955', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '湖北省', 'db4de7f3-98cf-4760-8949-c7d6f7874436', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('dc5ffe2d-a00e-4bb6-ac3c-6db5136e4f49', '甘肃省妇幼保健院', '甘肃省兰州市七里河区七里河北街143号', '总机:0931-2338611', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'SECOND_A', null, null, null, null, '甘肃省', '27373c18-ecf1-40fc-85b4-6651796acd3e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('de2b6305-7d27-4246-8a32-47938c2008b0', '福建省妇幼保健院', '福建省福州市鼓楼区道山路18号', '总机 : 0591-87557800', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '福建省', 'e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('df5f3ce4-35b6-44c8-b994-3ae78174aa7f', '苏州大学附属第一医院', '苏州市十梓街188号', '总机 : 0512-65223637', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e02ce8db-1349-42ff-a395-6b5cde2427cc', '烟台毓璜顶医院', '山东省烟台市芝罘区毓璜顶东路20号', '总机:0535-6691999', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e17af8b0-d858-4091-96f1-cc0faac3e9a5', '复旦大学附属中山医院', '上海市斜土路1609号', '总机 : 021-64041990', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e20cbe6a-8790-4931-b177-49391aac53ac', '四川省妇幼保健院', '成都市沙堰西二街290号', '晋阳:028-65978133;抚琴:028-87738249', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e213f12a-cafd-42c4-be06-01d9f61674db', '山东中医药大学第二附属医院', '山东省济南市市中区经八路1号', '总机:0531-82436327;咨询:0531-82436337', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e22665bc-735b-49b2-940d-2266108fa6a9', '烟台市烟台山医院', '山东省烟台市解放路91号', '总机:0535-6602001', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e3881936-a8de-4833-8323-c9c7d623ede2', '洛阳市中心医院', '河南省洛阳市西工区中州中路288号', '0379-63892008', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e3cb2325-7c3d-421d-975e-f0f82708c8c1', '沈阳市妇婴医院', '辽宁省沈阳市沈河区大南街87号', '总机 : 024-22853725 ； 咨询 : 024-22761001', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e47bec0b-1232-4554-881c-cf0aa6f84a6a', '焦作市妇幼保健院', '河南焦作市民主中路158号', '0391-2310616/2922037', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '河南省', '674d44da-3e93-4211-a28b-5899e8436752', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e49f397f-cefa-4d60-b482-182abfd14f03', '桂林医学院附属医院', '广西壮族自治区桂林市乐群路15号', '总机:0773-2833086', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广西壮族自治区', '20054872-0cf4-4baa-b049-df7f762684fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e647d9e1-8d0c-44ba-b572-ae8e1ad2ee1c', '第四军医大学附属西京医院', '陕西省西安市新城区长乐西路127号', '总机 : 029-84774114 ; 预约 : 029-83215321', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '陕西省', '6ad3c9a7-82bc-45ee-9a5f-e5ecde46a893', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e6914e77-b955-4d93-87df-3020e21d931f', '泰安市中心医院', '山东省泰安市龙潭路29号', '总机:0538-8224161', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e8e98906-8009-4aef-85e0-a01b24239f91', '海口玛丽医院', '海南省海口市蓝天路7号', '(0898)66517788', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '海南省', '3ab5c96a-3f40-4aa5-8861-ec70ca3d8f34', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('e90ae338-85dc-4825-8509-dde363f64a72', '原南京军区第105医院', '合肥市长江西路424号', '0551-2163510 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '安徽省', 'b12dfc5b-d6de-4e3d-803e-1f8bac9e8241', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('eca4c394-2e0a-4478-bb42-15a4338c62cc', '辽宁省计划生育科学研究院附属医院', '辽宁省沈阳市皇姑区蒲河街10号', '024-86806104', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'SECOND_A', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ecb877e3-7df6-4500-80c1-6a15c0bb0fda', '北京妇产医院', '北京市朝阳区姚家园路251号', '总机 : 010-52276666', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ed153074-b3ee-4358-839f-db87a0d45628', '深圳恒生医院', '广东省深圳市宝安区西乡银田路20号', '总机:0755-27791111,0755-27791848', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('edf25795-8e19-41af-a42b-9a99af622a56', '苏州市立医院', '苏州市道前街26号', '总机 : 0512-69009090', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THRID', null, null, null, null, '江苏省', '414b84d5-0bd6-4958-a2dc-7dee554f714d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('eedc68d2-8e85-4518-ab70-8cd8ba9e7ff4', '浙江大学医学院附属妇产科医院', '杭州市上城区学士路1号', '总机 : 0571-87061501', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ef9d6d31-2a7e-4d20-8a41-7a95912cca63', '大理学院附属医院', '云南省大理白族自治州大理市嘉士伯大道32号', '0872-2201062', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('efb1c87f-7e71-4db7-abc9-4e13b8967205', '湘潭市中心医院', '湖南省湘潭市雨湖区和平路120号', '0731-58214965(总值班室),8214787(宣传科)', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '湖南省', '04ed9cfe-7076-4145-9f44-0586eb048a20', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f01058c0-5c51-4fc3-a49d-e32ee42f77ce', '茂名市人民医院', '广东省茂名市茂南区为民路101号', '总机:0668-2922577', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f063c5dc-6971-4869-9b4d-f28978b62896', '乌海市妇幼保健院', '内蒙古自治区乌海市海勃湾区滨河新区神华东街1号', '0473-3891824 ', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_A', null, null, null, null, '内蒙古自治区', 'ab81f864-433c-4fee-bce0-6b780dd9f1a1', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f1026382-4774-4694-869f-d3ccf36f03ef', '战支第306医院（中国人民解放军第306医院）', '北京市朝阳区安翔北里9号', '010-66356729(总机)', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '北京市', '6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', 'TEST_RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f268759d-9be2-42cd-ad1a-ffa982f4ccff', '杭州市妇产科医院（杭州市妇幼保健院）', '上城区鲲鹏路369号', '0571-56005000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THRID', null, null, null, null, '浙江省', 'd1d39563-167e-4ee8-a0a9-e40810f7019a', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f33a0129-f722-4ab0-b026-1f7674a6c8c7', '原沈阳军区第202医院', '沈阳市和平区马路湾光荣街5号', '024-28853511；024-28853551', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术', 'THIRD_A', null, null, null, null, '辽宁省', '078831ec-5840-41e6-a6a6-d5d5e789131d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f3c6b3b8-25ef-4905-a5ef-5a91867da7b9', '昆明爱维艾夫医院', '云南省昆明市经济开发区云景路园博园内', '0871-67429513、4006005333转5', 'PRIVATE_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'OTHER', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f502e8e9-4335-4fd6-b29f-85ca6897a7d9', '上海中医药大学附属曙光医院', '上海市张衡路528号', '021-20256666', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '上海市', '4fc0d292-2532-47f8-90cd-8852d15963fd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f5b5537a-bc74-487b-a06f-24c5e7f6f513', '秦皇岛市妇幼保健院', '秦皇岛市海港区红旗路452号', '0335-3852999（咨询台），0335-3852188（院办）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f64161d2-9384-4ce5-82c7-e01fc5763b8e', '滨州医学院附属医院', '山东省滨州市黄河二路661号', '总机:0543-3399999;预约:0543-3256969', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山东省', 'e3edf03e-126a-490a-bacd-5856e623ef95', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f7206a62-779b-4e3f-949b-17cc25e8ac50', '沧州市人民医院', '河北省沧州市新华区清池大道7号', '总机 : 0317-3521000', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f7b740cd-9ca5-48c5-864e-fa77bc1f39ba', '山西省妇幼保健院', '太原市新民北街13号', '总机 : 0351-3360320', 'PUBLIC_H', '夫精人工授精技术
供精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
植入前胚胎遗传学诊断技术
', 'THIRD_A', null, null, null, null, '山西省', '6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f8093773-4794-4381-959b-3ff32a6325e3', '楚雄彝族自治州人民医院', '云南省楚雄彝族自治州楚雄市鹿城南路317号', '(0878)3123818', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_B', null, null, null, null, '云南省', '0f27505c-361d-45d0-933b-b6021462395f', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('f8262fff-9a22-4417-8421-9737fce3baa6', '广东医学院附属医院', '广东省湛江市人民大道南57号', '总机:0759-2387612;咨询:0759-2387613', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '广东省', 'fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('faa43c37-12b6-4e09-87c4-98d2dd2d9f6a', '绵阳市中心医院', '四川省绵阳市涪城区常家巷12号', '总机:0816-2237381;咨询:0816-2222566;急救:0816-2229955', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'THIRD_A', null, null, null, null, '四川省', 'fc805c5c-580a-4578-8686-0e319199c2bd', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('fbf9762d-ab43-493d-b31e-75bbf6e067a9', '山西省人民医院', '太原市双塔寺街29号', '咨询 : 0351-4960130', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术', 'THIRD_A', null, null, null, null, '山西省', '6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', 'RUNNING');
INSERT INTO "public"."ykb_hospital" VALUES ('ff72b90b-073a-4560-8dcf-7f5a8392e0de', '承德市妇幼保健院', '承德市双桥区马市街1号', '0314-2022136（办公室）', 'PUBLIC_H', '夫精人工授精技术
常规体外受精-胚胎移植技术
卵胞浆内单精子显微注射技术
', 'SECOND_A', null, null, null, null, '河北省', '9f56c669-6fa9-49b6-a466-0a2659563909', 'RUNNING');

-- ----------------------------
-- Table structure for ykb_order
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_order";
CREATE TABLE "public"."ykb_order" (
"id" varchar(255) COLLATE "default" NOT NULL,
"created_date" timestamp(0),
"created_by" varchar(100) COLLATE "default",
"updated_date" timestamp(0),
"updated_by" varchar(100) COLLATE "default",
"proposer_name" varchar(50) COLLATE "default",
"proposer_credentials_type" varchar(50) COLLATE "default",
"proposer_credentials_num" varchar(100) COLLATE "default",
"proposer_phone" varchar(50) COLLATE "default",
"insured_name" varchar(50) COLLATE "default",
"insured_credentials_type" varchar(50) COLLATE "default",
"insured_credentials_num" varchar(100) COLLATE "default",
"insured_phone" varchar(50) COLLATE "default",
"relation" varchar(20) COLLATE "default",
"hospital_id" varchar(100) COLLATE "default",
"hospital_name" varchar(100) COLLATE "default",
"insurance_amount" int8,
"order_amount" int8,
"order_number" varchar(100) COLLATE "default",
"user_id" varchar(100) COLLATE "default",
"status" varchar(50) COLLATE "default",
"insurance_start_date" timestamp(6),
"channel" varchar(50) COLLATE "default",
"insurance_end_date" timestamp(6),
"policy_effective_date" timestamp(6),
"policy_number" varchar(100) COLLATE "default",
"reason" varchar(255) COLLATE "default",
"order_date" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ykb_order
-- ----------------------------

-- ----------------------------
-- Table structure for ykb_province
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_province";
CREATE TABLE "public"."ykb_province" (
"id" varchar(100) COLLATE "default" NOT NULL,
"name" varchar(100) COLLATE "default",
"created_date" timestamp(6),
"created_by" varchar(50) COLLATE "default",
"updated_date" timestamp(6),
"updated_by" varchar(50) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ykb_province
-- ----------------------------
INSERT INTO "public"."ykb_province" VALUES ('04ed9cfe-7076-4145-9f44-0586eb048a20', '湖南省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('065a80fc-75c3-4540-b5f3-99506ec65bce', '西藏自治区', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('076dd97c-46ae-43c4-90c1-260238c6a24a', '新疆维吾尔自治区', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('078831ec-5840-41e6-a6a6-d5d5e789131d', '辽宁省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('0f27505c-361d-45d0-933b-b6021462395f', '云南省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('20054872-0cf4-4baa-b049-df7f762684fd', '广西壮族自治区', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('22752702-e2d4-4a7a-bc61-8771ec6eb6e3', '黑龙江省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('27373c18-ecf1-40fc-85b4-6651796acd3e', '甘肃省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('3ab5c96a-3f40-4aa5-8861-ec70ca3d8f34', '海南省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('414b84d5-0bd6-4958-a2dc-7dee554f714d', '江苏省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('4fc0d292-2532-47f8-90cd-8852d15963fd', '上海市', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('5d3d3cd7-2259-4c1e-9883-914b4eae7771', '青海省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('674d44da-3e93-4211-a28b-5899e8436752', '河南省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('6ad3c9a7-82bc-45ee-9a5f-e5ecde46a893', '陕西省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('6edb6fe1-46f0-4dba-baa2-ef46cf4db49c', '北京市', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('6f05f47a-a1c9-4252-82ca-2ce525e0dd6d', '山西省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('9514efa1-287b-4afa-b630-e62cfdfd988d', '吉林省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('9d082c80-03ac-4d12-9d83-e9300012d90f', '天津市
', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('9f56c669-6fa9-49b6-a466-0a2659563909', '河北省
', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('ab81f864-433c-4fee-bce0-6b780dd9f1a1', '内蒙古自治区', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('b12dfc5b-d6de-4e3d-803e-1f8bac9e8241', '安徽省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('d1d39563-167e-4ee8-a0a9-e40810f7019a', '浙江省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('d6074bf7-d1c3-4bbe-a2c4-707c31205edf', '贵州省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('db4de7f3-98cf-4760-8949-c7d6f7874436', '湖北省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('dd3b2c8a-5b48-449f-9604-099a2d160c68', '重庆市', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('e0b46e3a-dc1d-4aaa-8cfd-1b4bc9a8033e', '福建省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('e3edf03e-126a-490a-bacd-5856e623ef95', '山东省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('e4d0e0dc-f8a0-4d49-a0a6-5d812a35660a', '江西省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('f4552e32-231e-41c3-827e-25b19d685790', '宁夏回族自治区', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('fb5edc24-9cbe-4bfa-8a3c-9d854c8afcf1', '广东省', null, null, null, null);
INSERT INTO "public"."ykb_province" VALUES ('fc805c5c-580a-4578-8686-0e319199c2bd', '四川省', null, null, null, null);

-- ----------------------------
-- Table structure for ykb_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_resource";
CREATE TABLE "public"."ykb_resource" (
"id" varchar(255) COLLATE "default" NOT NULL,
"name" varchar(100) COLLATE "default",
"created_date" timestamp(0),
"created_by" varchar(100) COLLATE "default",
"updated_date" timestamp(0),
"updated_by" varchar(100) COLLATE "default",
"description" varchar(255) COLLATE "default",
"type" varchar(255) COLLATE "default",
"resource" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ykb_resource
-- ----------------------------
INSERT INTO "public"."ykb_resource" VALUES ('4444', 'ASDAS', null, null, null, null, '的放水电费', 'menu', 'asdsads');

-- ----------------------------
-- Table structure for ykb_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_role";
CREATE TABLE "public"."ykb_role" (
"id" varchar(255) COLLATE "default" NOT NULL,
"name" varchar(100) COLLATE "default",
"created_date" timestamp(0),
"created_by" varchar(100) COLLATE "default",
"updated_date" timestamp(0),
"updated_by" varchar(100) COLLATE "default",
"code" varchar(255) COLLATE "default",
"description" varchar(255) COLLATE "default",
"is_active" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ykb_role
-- ----------------------------
INSERT INTO "public"."ykb_role" VALUES ('123', '系统管理员', null, null, null, null, 'ROLE_ADMIN', null, 't');

-- ----------------------------
-- Table structure for ykb_role_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_role_resource";
CREATE TABLE "public"."ykb_role_resource" (
"role_id" varchar(255) COLLATE "default" NOT NULL,
"resource_id" varchar(255) COLLATE "default" NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ykb_role_resource
-- ----------------------------
INSERT INTO "public"."ykb_role_resource" VALUES ('123', '4444');

-- ----------------------------
-- Table structure for ykb_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_user";
CREATE TABLE "public"."ykb_user" (
"id" varchar(255) COLLATE "default" NOT NULL,
"name" varchar(255) COLLATE "default",
"created_date" timestamp(0),
"created_by" varchar(100) COLLATE "default",
"updated_date" timestamp(0),
"updated_by" varchar(100) COLLATE "default",
"password" varchar(255) COLLATE "default",
"is_active" bool,
"type" varchar(10) COLLATE "default",
"expire_date" timestamp(6),
"enabled" bool
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ykb_user
-- ----------------------------
INSERT INTO "public"."ykb_user" VALUES ('32b35a78-dc61-4aa7-a946-e134a69876aa', 'admin', '2018-01-17 14:09:48', null, null, null, 'cfcd208495d565ef66e7dff9f98764da', null, 'admin', '2020-04-01 17:11:22', 't');

-- ----------------------------
-- Table structure for ykb_user_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_user_role";
CREATE TABLE "public"."ykb_user_role" (
"role_id" varchar(255) COLLATE "default" NOT NULL,
"user_id" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of ykb_user_role
-- ----------------------------
INSERT INTO "public"."ykb_user_role" VALUES ('123', '32b35a78-dc61-4aa7-a946-e134a69876aa');

-- ----------------------------
-- Table structure for ykb_wechat_menu
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_wechat_menu";
CREATE TABLE "public"."ykb_wechat_menu" (
"id" varchar(100) COLLATE "default" NOT NULL,
"name" varchar(50) COLLATE "default",
"created_date" timestamp(6),
"created_by" varchar(50) COLLATE "default",
"updated_date" timestamp(6),
"updated_by" varchar COLLATE "default",
"type" varchar(20) COLLATE "default",
"level" int4,
"sequence" int4,
"title" varchar(255) COLLATE "default",
"content" varchar(255) COLLATE "default",
"img_url" varchar(255) COLLATE "default",
"parent_id" varchar(100) COLLATE "default",
"key" varchar(100) COLLATE "default",
"url" varchar(255) COLLATE "default",
"parent_name" varchar(20) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Table structure for ykb_wechat_qr_code
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_wechat_qr_code";
CREATE TABLE "public"."ykb_wechat_qr_code" (
"id" varchar(100) COLLATE "default" NOT NULL,
"created_date" timestamp(6),
"created_by" varchar(100) COLLATE "default",
"updated_date" timestamp(6),
"updated_by" varchar(100) COLLATE "default",
"channels" varchar(255) COLLATE "default",
"qr_code_url" varchar(255) COLLATE "default",
"scene" varchar(100) COLLATE "default",
"scan_time" int4,
"ticket" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;


-- ----------------------------
-- Table structure for ykb_wechat_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."ykb_wechat_user";
CREATE TABLE "public"."ykb_wechat_user" (
"id" varchar(100) COLLATE "default" NOT NULL,
"name" varchar(100) COLLATE "default",
"open_id" varchar(255) COLLATE "default" NOT NULL,
"created_by" varchar(100) COLLATE "default",
"created_date" timestamp(6),
"updated_by" varchar(100) COLLATE "default",
"updated_date" timestamp(6),
"qr_code_scene" varchar(255) COLLATE "default",
"nick_name" varchar(255) COLLATE "default",
"subscribe" int8,
"gender" varchar(10) COLLATE "default",
"city" varchar(20) COLLATE "default",
"province" varchar(50) COLLATE "default",
"country" varchar(30) COLLATE "default",
"head_img_url" varchar(255) COLLATE "default",
"union_id" varchar(200) COLLATE "default",
"remark" varchar(255) COLLATE "default",
"subscribe_time" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Alter Sequences Owned By
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table ykb_order
-- ----------------------------
ALTER TABLE "public"."ykb_order" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ykb_province
-- ----------------------------
ALTER TABLE "public"."ykb_province" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ykb_resource
-- ----------------------------
ALTER TABLE "public"."ykb_resource" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ykb_role
-- ----------------------------
ALTER TABLE "public"."ykb_role" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ykb_user
-- ----------------------------
ALTER TABLE "public"."ykb_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ykb_user_role
-- ----------------------------
ALTER TABLE "public"."ykb_user_role" ADD PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table ykb_wechat_menu
-- ----------------------------
ALTER TABLE "public"."ykb_wechat_menu" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ykb_wechat_qr_code
-- ----------------------------
ALTER TABLE "public"."ykb_wechat_qr_code" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table ykb_wechat_user
-- ----------------------------
ALTER TABLE "public"."ykb_wechat_user" ADD PRIMARY KEY ("id");
