-- JDBC Test


select * from emp e, dept d
where e.deptno=d.deptno;

update emp
set sal=1000 where ename='scott';

rollback;