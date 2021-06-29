create database ecom_webapp;

use ecom_webapp;

create table eproduct( id bigint primary key auto_increment, name varchar(100), 
price decimal(10,2),description varchar(250), date_added timestamp default now());

create table eorders( id bigint primary key auto_increment, name varchar(100), 
price decimal(10,2),description varchar(250), date_added timestamp default now(),
date_dispatch timestamp default now());

insert into eproduct(name,price) values('Dell Laptop ABC model',827654.23);
insert into eproduct(name,price) values('Lenovo Laptop xyz model',347654.23);
insert into eproduct(name,price) values('Apple Laptop pqr model',999654.23);
