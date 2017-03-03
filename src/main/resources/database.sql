CREATE DATABASE pentatonic;

CREATE TABLE messagelib (
  message_id varchar(50) NOT NULL,
  tag_lib varchar(20) NOT NULL,
  content varchar(500) NOT NULL,
  creator varchar(20) NOT NULL,
  update_time datetime,
  create_time datetime NOT NULL,
  PRIMARY KEY (message_id),
  CONSTRAINT messagelib_ix1 UNIQUE (message_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `taglib` (
  `tag_id` varchar(20) NOT NULL,
  `tag_code` varchar(2) NOT NULL,
  `tag_name` varchar(50) NOT NULL,
  `tag_logo` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `creator` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`tag_id`),
  UNIQUE KEY `taglib_ix1` (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE votelib (
  vote_id varchar(50) NOT NULL,
  vote_oid varchar(50),
  vote_type int,
  vote_value int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE
  pentatoniclib
(
  penta_id VARCHAR(20) NOT NULL,
  tag_id VARCHAR(20) NOT NULL,
  description VARCHAR(200),
  message_list VARCHAR(1000),
  creator VARCHAR(20) NOT NULL,
  update_time DATETIME,
  create_time DATETIME NOT NULL,
  PRIMARY KEY (penta_id),
  CONSTRAINT pentatoniclib_ix1 UNIQUE (penta_id)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE
  commentlib
(
  comment_id VARCHAR(50) NOT NULL,
  comment_oid VARCHAR(50) NOT NULL,
  comment_type INT NOT NULL,
  content VARCHAR(500) NOT NULL,
  commenter VARCHAR(20) NOT NULL,
  create_time DATETIME NOT NULL,
  PRIMARY KEY (comment_id),
  CONSTRAINT commentlib_ix1 UNIQUE (comment_id)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8;

//条件表
CREATE TABLE `conditionLib` (
  `condition_id` varchar(20) NOT NULL,
  `type_tag_1` varchar(20),
  `type_tag_2` varchar(20),
  `type_tag_3` varchar(20),
  `type_tag_4` varchar(20),
  `type_tag_5` varchar(20),
  `create_time` datetime
  PRIMARY KEY (`condition_id`),
  UNIQUE KEY `conditionlib_ix1` (`condition_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#临时用来测试
CREATE TABLE
  userlib
(
  user_id VARCHAR(20),
  user_name VARCHAR(50)
)
  ENGINE=InnoDB DEFAULT CHARSET=utf8;
