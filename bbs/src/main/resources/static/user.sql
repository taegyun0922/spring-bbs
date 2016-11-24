CREATE DATABASE bbs
 CHARACTER SET utf8
 DEFAULT CHARACTER SET utf8
 COLLATE utf8_general_ci
 DEFAULT COLLATE utf8_general_ci
 ;

CREATE TABLE user (
user_id VARCHAR(100) NOT NULL,
user_pwd VARCHAR(100) NOT NULL,
user_name VARCHAR(100) NOT NULL,
user_pic_sm VARCHAR(100) NOT NULL,
PRIMARY KEY(user_id),
UNIQUE(user_pic_sm))
;

INSERT into user (user_id, user_pwd, user_name, user_pic_sm)  values 
( 'chansung18',    '123456',    '박찬성',    '/img/user_pic/chansung18_user_pic_sm.png'),
( 'enkyoseo',    '123456',    '서은교',    '/img/user_pic/enkyoseo_user_pic_sm.png'),
( 'ksh',    '123456',    '김성흥',    '/img/user_pic/ksh_user_pic_sm.png'),
( 'rogankim',    '123456',    '김태균',    '/img/user_pic/rogankim_user_pic_sm.png');


ALTER TABLE user
 DEFAULT CHARACTER SET utf8
 COLLATE utf8_general_ci
 ;