create sequence xulie; 
create table employee(id number(2) primary key, name varchar2(10),salary number(7,2),hire_date date);
select * from employee;
insert into employee values(xulie.nextval,'白露',2000.50,to_date('2018-05-01','yyyy-MM-dd'));
insert into employee values(xulie.nextval,'赵文理',8000.50,to_date('2018-03-01','yyyy-MM-dd'));
insert into employee values(xulie.nextval,'张三',5000.50,to_date('2016-03-01','yyyy-MM-dd'));
commit;
update employee set name='李四' where id=2;