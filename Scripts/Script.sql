grant all 
      to web_gradle_erp.*
    on 'user_web_gradle_erp'.'localhost'
identified by 'rootroot'

show tables;
select * from department;
select * from title;
select * from employee;
select empno, empname, title, manager, salary, dept from employee;

select empno, empname, title, manager, salary, dept from employee where empno = 1003;

insert into employee(empno, empname, title, manager, salary, dept) values
(2001, '김상건', 5, 2106, 2000000, 3  );

delete from employee where empno  = 2001;

update employee 
set title = 4, manager =  3427,  salary = 3000000, dept = 2
where empno = 2001;

create or replace view vw_full_employee
as
select e.empno,
	   e.empname,
       t.titleno as title_no, 
       t.titleName as title_name, 
       e.manager as	manager_no,
       m.empname as manager_name,
       e.salary,
       d.deptNo,
       d.deptName,
       d.floor
from employee e join title t on e.title=t.titleno
left join employee m on e.manager =m.empno 
join department d on e.dept = d.deptNo;

select empno,empname,title_no,title_name,manager_no,
manager_name,salary,deptNo,deptName,floor 
from vw_full_employee ;
select  * from vw_full_employee; 

select 
		empno, empname,
		title_no, title_name,
		manager_no, manager_name,
		salary, 
		deptno, deptname
from vw_full_employee ;

