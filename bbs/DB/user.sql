crate database spring_bbs;

create table user
(
    
	user_id varchar(45) NOT NULL,
    user_pwd varchar(45) NOT NULL,
    enabled TINYINT NOT NULL DEFAULT 1 ,
    primary key (user_id)
);


CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  user_id varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_userid_role (role,user_id),
  KEY fk_userid_idx (user_id),
  CONSTRAINT fk_userid FOREIGN KEY (user_id) REFERENCES user (user_id));
  
  
   
INSERT INTO users(username,password,enabled) VALUES ('mkyong','123456', true);
INSERT INTO users(username,password,enabled) VALUES ('alex','123456', true);

INSERT INTO user_roles (username, role) VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles (username, role) VALUES ('mkyong', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role) VALUES ('alex', 'ROLE_USER');
