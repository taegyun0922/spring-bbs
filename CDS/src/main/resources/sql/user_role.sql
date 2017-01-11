CREATE TABLE user_role (
  user_id VARCHAR(100),
  role VARCHAR(100) ,
  KEY (user_id,role)
);

insert into user_role (user_id,role) values 
    ('chansung18','ROLE_USER'),
    ('enkyoo','ROLE_USER'),
    ('ksh','ROLE_USER'),
    ('rogankim','ROLE_USER')
;