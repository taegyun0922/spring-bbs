CREATE TABLE user_basic_tbl (
user_id VARCHAR(100) NOT NULL,
user_pwd VARCHAR(100) NOT NULL,
user_name VARCHAR(100) NOT NULL,
user_pic_sm VARCHAR(100) NOT NULL,
enabled tinyInt(1) NOT NULL,
PRIMARY KEY(user_id),
UNIQUE(user_pic_sm))
;

# dummy data
INSERT into user_basic_tbl (user_id, user_pwd, user_name, user_pic_sm)  values 
( 'chansung18',    '123456',    'tom',    '/img/user_pic/chansung18_user_pic_sm.png'),
( 'enkyoseo',    '123456',    '빵떡이',    '/img/user_pic/enkyoseo_user_pic_sm.png'),
( 'ksh',    '123456',    'ゼリ',    '/img/user_pic/ksh_user_pic_sm.png'),
( 'rogankim',    '123456',    'rogan',    '/img/user_pic/rogankim_user_pic_sm.png')
;

ALTER TABLE user_basic_tbl
 DEFAULT CHARACTER SET utf8
 COLLATE utf8_general_ci
 ;