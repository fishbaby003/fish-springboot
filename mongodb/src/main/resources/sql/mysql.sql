CREATE TABLE `cn_area` (
  `id` int(7) unsigned NOT NULL AUTO_INCREMENT,
  `level` int(1) unsigned NOT NULL COMMENT '层级',
  `parent_code` varchar(14) NOT NULL DEFAULT '0' COMMENT '父级行政代码',
  `area_code` varchar(14) NOT NULL DEFAULT '0' COMMENT '行政代码',
  `zip_code` int(6) unsigned zerofill NOT NULL DEFAULT '000000' COMMENT '邮政编码',
  `city_code` varchar(6) NOT NULL DEFAULT '' COMMENT '区号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '名称',
  `short_name` varchar(50) NOT NULL DEFAULT '' COMMENT '简称',
  `merger_name` varchar(50) NOT NULL DEFAULT '' COMMENT '组合名',
  `pinyin` varchar(30) NOT NULL DEFAULT '' COMMENT '拼音',
  `lng` varchar(10) NOT NULL DEFAULT '0.000000' COMMENT '经度',
  `lat` varchar(10) NOT NULL DEFAULT '0.000000' COMMENT '纬度',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_code` (`area_code`) USING BTREE,
  KEY `idx_parent_code` (`parent_code`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=758050 DEFAULT CHARSET=utf8 COMMENT='中国行政地区表';

