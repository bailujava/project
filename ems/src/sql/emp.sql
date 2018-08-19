
create sequence emp_sequence;
create table emp(
id number(3) primary key,
name varchar2(6) not null,
salary number(5,2),
hireDate varchar2(10),
did number(3) references dept(id)
);
create table dept(
id number(3) primary key,
name varchar2(4) not null
);