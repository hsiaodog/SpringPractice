create database company;
use company;

create table Departments (
	Department_id int auto_increment primary key,
    Department_name varchar(20)
);

create table Employees (
	Employee_id int auto_increment primary key,
    first_name varchar(20),
    last_name varchar(10),
    age int(10) not null,
    department_id int,
    foreign key(department_id)
    references Departments(Department_id)
    ON UPDATE CASCADE ON DELETE RESTRICT
);

select * from Departments;
select * from Employees;
drop table Employees;