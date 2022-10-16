
DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `sex` smallint(3) DEFAULT '0' COMMENT '性别',
  `student_no` varchar(20) NOT NULL COMMENT '学号',
  `id_type` smallint(3) DEFAULT '0' COMMENT '证件类型',
  `id_no` varchar(50) NOT NULL COMMENT '证件编号',
  `score` int(10) NOT NULL COMMENT '成绩',
  `create_time` datetime NOT NULL COMMENT '添加时间',
  `update_time` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_student_no` (`student_no`),
  UNIQUE KEY `uniq_student_id` (`id_type`,`id_no`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8 COMMENT='学生信息';