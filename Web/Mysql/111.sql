
CREATE DATABASE zzz; 
use zzz;

create table user(
	id INT UNSIGNED auto_increment,
	username varchar(20) not null,
	password varchar(30) not null,
	age INT not null,
	primary key(id)
)charset=utf8;
INSERT INTO `user` VALUES ('9527','张三',1235456,22);
INSERT INTO `user` VALUES ('3','李四',1235456,22);
INSERT INTO `user` VALUES ('2','王五',1235456,22);
INSERT INTO `user` VALUES ('1','2',3,4);

show table status;
ALTER TABLE user CHANGE Description des varchar(30) not null;
select * from user;
update user set username='赵四',id=100 where id=3;