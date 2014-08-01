drop table emp_dep;
drop table department;
drop table manager;
drop table employee;
drop table request;
create table employee
     (
     emp_id int not null primary key,
     emp_name varchar(255) not null,
     salary float(2),
     phone int,
     email varchar(255),
     password varchar(255)
     );
create table request
     (
     emp_id int not null primary key,
     emp_name varchar(255) not null ,
     salary float(2),
     phone int,
     email varchar(255),
     departments varchar(255)
     );
insert into request values(10002,'Knuth',2100.99,201800102,'knuth@yahoo.com','21111,31111,');
insert into employee values (10001,'Bloom',2000.99,201800101,'bloom@yahoo.com','123456');
insert into employee values (10002,'Knuth',2000.99,201800102,'knuth@yahoo.com','123456');
insert into employee values (10003,'Emily',2000.99,201800103,'emily@yahoo.com','123456');
insert into employee values (10004,'Helen',2300.99,201800104,'helen@yahoo.com','123456');
insert into employee values (10005,'Sam',2400.99,201800105,'sam@yahoo.com','123456');
insert into employee values (10006,'James',2500.99,201800106,'james@yahoo.com','123456');
insert into employee values (10007,'Jane',2600.99,201800107,'jane@yahoo.com','123456');
insert into employee values (10008,'Reus',2800.99,201800108,'reus@yahoo.com','123456');
insert into employee values (10009,'Hudson',2800.99,201800109,'hudson@yahoo.com','123456');
insert into employee values (10010,'Daniel',2800.99,201800110,'daniel@yahoo.com','123456');

insert into employee values (20001,'Hansen',2100.99,301800101,'hansen@yahoo.com','123456');
insert into employee values (20002,'John',2200.99,301800102,'john@yahoo.com','123456');
insert into employee values (20003,'Pettersen',2300.99,301800103,'pettersen@yahoo.com','123456');
insert into employee values (20004,'Svendson',2400.99,301800104,'svendson@yahoo.com','123456');
insert into employee values (20005,'Smith',2500.99,301800105,'smith@yahoo.com','123456');
insert into employee values (20006,'Mary',2600.99,301800106,'mary@yahoo.com','123456');
insert into employee values (20007,'Harry',2700.99,301800107,'harry@yahoo.com','123456');
insert into employee values (20008,'Tiffany',2800.99,301800108,'tiffany@yahoo.com','123456');
insert into employee values (20009,'Kelly',2900.99,301800109,'kelly@yahoo.com','123456');
insert into employee values (20010,'Tom',3000.99,301800110,'tom@yahoo.com','123456');

insert into employee values (70001,'Laura',5700.99,701800101,'laura@yahoo.com','123456');
insert into employee values (70002,'Anne',5800.99,701800102,'anne@yahoo.com','123456');
insert into employee values (70003,'Cassie',5500.99,701800103,'cassie@yahoo.com','123456');
insert into employee values (70004,'Charlotte',6000.99,701800104,'charlotte@yahoo.com','123456');   

create table manager
     (
     man_id int,
     emp_id int,
     foreign key(emp_id) references employee(emp_id)
     )
     ;


insert into manager values (70001, 10001);
insert into manager values (70001, 10002);
insert into manager values (70001, 10003);
insert into manager values (70001, 10004);
insert into manager values (70001, 10005);

insert into manager values (70002, 10006);
insert into manager values (70002, 10007);
insert into manager values (70002, 10008);
insert into manager values (70002, 10009);
insert into manager values (70002, 10010);
insert into manager values (70002, 20001);

insert into manager values (70003, 20002);
insert into manager values (70003, 20003);
insert into manager values (70003, 20004);
insert into manager values (70003, 20005);
insert into manager values (70003, 20006);
insert into manager values (70003, 20007);
insert into manager values (70003, 20008);

insert into manager values (70004, 20009);
insert into manager values (70004, 20010);


create table department
     (
     dep_id int not null,
     dep_name varchar(255),
     man_id int,
     primary key(dep_id),
     foreign key(man_id) references employee(emp_id)
     );
insert into department values (11111, 'Human Resources', 70001);
insert into department values (21111, 'Technology', 70002);
insert into department values (31111, 'Marketing', 70003);
insert into department values (41111, 'Finance', 70004);


 create table emp_dep
     (
     emp_id int,
     dep_id int,
     foreign key(emp_id) references employee(emp_id),
     foreign key(dep_id) references department(dep_id)
     ); 

insert into emp_dep values (10001, 11111);
insert into emp_dep values (10002, 11111);
insert into emp_dep values (10003, 11111);
insert into emp_dep values (10004, 11111);
insert into emp_dep values (10005, 11111);
insert into emp_dep values (10006, 21111);
insert into emp_dep values (10007, 21111);
insert into emp_dep values (10008, 21111);
insert into emp_dep values (10009, 21111);
insert into emp_dep values (10010, 21111);

insert into emp_dep values (20001, 21111);
insert into emp_dep values (20002, 31111);
insert into emp_dep values (20003, 31111);
insert into emp_dep values (20004, 31111);
insert into emp_dep values (20005, 31111);
insert into emp_dep values (20006, 31111);
insert into emp_dep values (20007, 31111);
insert into emp_dep values (20008, 31111);
insert into emp_dep values (20009, 41111);
insert into emp_dep values (20010, 41111);

insert into emp_dep values (70001, 11111);
insert into emp_dep values (70002, 21111);
insert into emp_dep values (70003, 31111);
insert into emp_dep values (70004, 41111);





