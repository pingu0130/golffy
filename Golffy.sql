drop database if exists golffy;

create database golffy character set utf8mb4 collate utf8mb4_general_ci;

use golffy;

create table if not exists user (
user_pid int auto_increment primary key,
user_id varchar(20) not null,
user_pw varchar(20) not null,
user_nick varchar(20) not null
)ENGINE=InnoDB;

create table if not exists board (
board_id int auto_increment primary key,
user_pid int not null,
board_title varchar(50) not null,
board_content varchar(200) not null,
board_viewcnt int default 0,
board_like int default 0,
board_deleted tinyint default 0,
foreign key(user_pid) references user(user_pid)
)ENGINE=InnoDB;

create table if not exists cmt (
cmt_id int auto_increment primary key,
board_id int not null,
user_pid int not null,
cmt varchar(100) not null,
cmt_deleted tinyint default 0,
foreign key(board_id) references board(board_id),
foreign key(user_pid) references user(user_pid)
)ENGINE=InnoDB;

create table if not exists subcmt (
subcmt_id int auto_increment primary key,
cmt_id int not null,
user_pid int not null,
cmt varchar(100) not null,
subcmt_deleted tinyint default 0,
foreign key(cmt_id) references cmt(cmt_id),
foreign key(user_pid) references user(user_pid)
)ENGINE=InnoDB;

-- create table if not exists files (
-- file_id int auto_increment primary key,
-- board_id int not null,
-- save_folder varchar(50) not null,
-- origin_file varchar(50) not null,
-- save_file varchar(50) not null,
-- foreign key(board_id) references board(board_id),
-- foreign key(user_pid) references user(user_pid)
-- )ENGINE=InnoDB;

-- create table if not exists user_like (
-- user_pid int primary key,
-- board_id int not null,
-- foreign key(user_pid) references user(user_pid),
-- foreign key(board_id) references board(board_id)
-- )ENGINE=InnoDB;

-- create table if not exists follow (
-- user_pid int primary key,
-- target int not null,
-- foreign key(user_pid) references user(user_pid)
-- )ENGINE=InnoDB;

-- 샘플

use golffy;

insert into user (user_id,user_pw,user_nick)
values("김","김","김소진");
insert into user (user_id,user_pw,user_nick)
values("조","조","조원희");
insert into user (user_id,user_pw,user_nick)
values("박","박","박근혜");

INSERT INTO board (User_pid, board_title, board_content) 
        VALUES("1","1번", "1번글입니다");

INSERT INTO board (User_pid, board_title, board_content) 
        VALUES("2","2번", "2번글입니다");

INSERT INTO board (User_pid, board_title, board_content) 
        VALUES("3","3번", "3번글입니다");

UPDATE board
SET board_deleted=0
WHERE board_id=3;

-- UPDATE board
--         SET board_title = "바뀐 가" , board_content="바뀐 가가가가"
--         WHERE board_id = 3;
 
insert into cmt (board_id , user_pid, cmt)
value(1,1,"1번사용자 김소진 1번글의댓글"); 

insert into cmt (board_id , user_pid, cmt)
value(2,1,"1번사용자 김소진 2번글의댓글"); 
 
insert into cmt (board_id , user_pid, cmt)
value(2,2,"2번사용자 조원희 2번의댓글"); 
 
UPDATE cmt
SET cmt_deleted=0
WHERE comment_id=1;

select * from cmt;