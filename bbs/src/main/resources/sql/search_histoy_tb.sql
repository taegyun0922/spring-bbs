create table search_history_tb (
    search_index int NOT NULL AUTO_INCREMENT ,
    search_word VARCHAR(300) NOT NULL , 
    search_time datetime() NOT NULL ,
    user_id VARCHAR(100) NOT NULL, 
    PRIPARY_KEY (search_index),
    FOREIGN_KEY (user_id) PEFERENCES user_basic_tb(user_id);

rename table user to user_basic_tb ;

