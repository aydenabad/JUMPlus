
create database dollarsbank;

use dollarsbank;

create table customer (
	name varchar(255),
    address varchar(255),
    number varchar(255),
    id varchar(255),
    password varchar(255),
    initialDeposit float,
    primary key (id)
);

describe customer;

create table transaction (
	transactionId int,
    transaction varchar(255),
    customerId varchar(255)
);

describe transaction;

create table account (
	balance float,
    customerId varchar(255),
    primary key (customerId)
);

SELECT * FROM customer WHERE id = "ayden";

describe account;

select * from account;
select * from customer;
select * from transaction;

truncate transaction;
truncate account;
truncate customer;
