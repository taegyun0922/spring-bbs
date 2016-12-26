create table game_list_tbl (
    game_index int NOT NULL AUTO_INCREMENT, 
    game_name VARCHAR(200),
    PRIMARY KEY(game_index)
);


insert into game_list_tbl (game_name) values 
    ('Hello Hero'),
    ('Finger Knights'),
    ('COOK1'),
    ('COOK2')
;