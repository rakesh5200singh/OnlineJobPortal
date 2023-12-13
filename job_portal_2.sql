create table newtable
(
id int ,
name varchar(30),
email varchar,
password varchar(40),
qualification varchar(21),
role varchar(35)
);

create table jobs
(
id int not null auto_increment ,
title varchar(500),
description varchar(3500),
category varchar(45),
status varchar(45),
location varchar(45),
pdate timestamp null default now()
);
