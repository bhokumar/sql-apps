/*
create table Person(
	id integer not null,
	name varchar(255),
	location varchar(255),
	birth_date timestamp,
	primary key(id)
);
*/
insert into person(id, name, location, birth_date) values(10001, 'Bhoopendra', 'Noida', sysdate());
insert into person(id, name, location, birth_date) values(10002, 'James', 'Newyork', sysdate());
insert into person(id, name, location, birth_date) values(10003, 'Jack', 'London', sysdate());


insert into course(id, name) values(11001,'Angular');
insert into course(id, name) values(11002,'React');