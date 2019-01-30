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


insert into course(id, name, last_updatetime, creation_time) values(11001,'Angular', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11002,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11003,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11004,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11005,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11006,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11007,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11008,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11009,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11010,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11011,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11012,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11013,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11014,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11015,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11016,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11017,'React', sysdate(), sysdate());
insert into course(id, name, last_updatetime, creation_time ) values(11018,'React', sysdate(), sysdate());

insert into passport(id, number) values(40001, 'E123456');
insert into passport(id, number) values(40002, 'N123457');
insert into passport(id, number) values(40003, 'L123458');

insert into student(id, name, passport_id) values(20001, 'bhoopendra', '40001');
insert into student(id, name, passport_id) values(20002, 'Adam', '40002');
insert into student(id, name, passport_id) values(20003, 'Jane', '40003');

insert into review(id, rating, description, course_id) values(50001, '4.2', 'Great Course', 11001);
insert into review(id, rating, description, course_id) values(50002, '4.3', 'Wonderful Course', 11001);
insert into review(id, rating, description, course_id) values(50003, '4.4', 'Awesome Course', 11001);
insert into review(id, rating, description, course_id) values(50004, '4.5', 'Great Course', 11002);
insert into review(id, rating, description, course_id) values(50005, '4.6', 'Great Course', 11002);
insert into review(id, rating, description, course_id) values(50006, '4.7', 'Great Course', 11002);
insert into review(id, rating, description, course_id) values(50007, '4.8', 'Great Course', 11002);

insert into course_student(COURSE_ID, STUDENT_ID) values(11001,20001);
insert into course_student(COURSE_ID, STUDENT_ID) values(11001,20002);
insert into course_student(COURSE_ID, STUDENT_ID) values(11001,20003);
insert into course_student(COURSE_ID, STUDENT_ID) values(11002,20002);
