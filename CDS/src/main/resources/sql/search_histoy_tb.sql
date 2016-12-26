create table search_history_tbl (
    search_index int NOT NULL AUTO_INCREMENT,
    search_word VARCHAR(300) NOT NULL,
    search_time datetime NOT NULL,
    user_id VARCHAR(100) NOT NULL, 
    PRIMARY KEY (search_index),
    FOREIGN KEY (user_id) REFERENCES user_basic_tbl(user_id));

insert into search_history_tbl (search_word, search_time, user_id) values 
('검색어1', '2016-11-23 23:59:59','chansung18') ,
('게임1', '2016-12-24 23:59:59','rogankim') , 
('두번째', '2016-12-25 23:59:59','rogankim') , 
('세번째', '2016-12-26 23:59:59','rogankim') ,
('네번째', '2016-12-27 23:59:59','ksh') ;
