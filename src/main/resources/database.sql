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

CREATE TABLE taglib (
  tag_id varchar(20) NOT NULL,
  tag_name varchar(50) NOT NULL,
  tag_logo varchar(50) NOT NULL,
  description varchar(200),
  creator varchar(20) NOT NULL,
  create_time datetime NOT NULL, PRIMARY KEY (tag_id), CONSTRAINT taglib_ix1 UNIQUE (tag_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE votelib (
  vote_id varchar(50) NOT NULL,
  vote_oid varchar(50),
  vote_type int,
  vote_value int
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
