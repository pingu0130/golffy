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
foreign key(user_pid) references user(user_pid)
)ENGINE=InnoDB;

create table if not exists comment (
comment_id int auto_increment primary key,
board_id int not null,
user_pid int not null,
comment varchar(100) not null,
foreign key(board_id) references board(board_id),
foreign key(user_pid) references user(user_pid)
)ENGINE=InnoDB;

create table if not exists user_board (
user_pid int primary key,
board_id int not null,
foreign key(user_pid) references user(user_pid),
foreign key(board_id) references board(board_id)
)ENGINE=InnoDB;

create table if not exists user_like (
user_pid int primary key,
board_id int not null,
foreign key(user_pid) references user(user_pid),
foreign key(board_id) references board(board_id)
)ENGINE=InnoDB;

create table if not exists user_comment (
user_pid int primary key,
comment_id int not null,
foreign key(user_pid) references user(user_pid),
foreign key(comment_id) references comment(comment_id)
)ENGINE=InnoDB;

create table if not exists follow (
user_pid int primary key,
target int not null,
foreign key(user_pid) references user(user_pid)
)ENGINE=InnoDB;