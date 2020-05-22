--2020.05.21
--------------------------
--JOIN  :   스키마의 결합
--------------------------
select *
from emp
;
select *
from dept
;
-- CROSS JOIN   :   단순 결합
-- emp.row(14)*dept.row(4)=row(56), column(11)
select *
from emp, dept
;
-- ANSI CROSS JOIN
select *
from emp cross join dept
;


--EQUI JOIN :   동일컬럼 기준 (테이블을 객체로 사용)
select e.ename, d.dname --컬럼명 중복되지 않는다면 e나 d 쓰지 않아도 ok
from emp e, dept d
where e.deptno = d.deptno
;

-- book, customer, orders
select * from book;
select *from orders;
select * from customer;

-- CROSS JOIN
select *
from orders o, book b, customer c
where o.bookid=b.bookid and o.custid=c.custid and name='박지성'
;

--NON EQUI JOIN
--SALGRADE
select * from emp;
select * from salgrade;

select s.losal, e.sal, s.hisal
from emp e, salgrade s
where e.sal>= s.losal and e.sal<=s.hisal
;
--포인트 멤버십 등급
select ename, sal, s.grade
from emp e, salgrade s
--where e.sal>= s.losal and e.sal<=s.hisal
where sal between losal and hisal
;

--★★SELF JOIN, OUTER JOIN
--관리자의 이름을 알아보자
select  *
from emp e, emp m       -- 같은 테이블..별칭 반드시..!
where e.mgr = m.empno(+)  -- null 제외된 후 출력 → (+)하면 null도 출력 → OUTER JOIN
;
select  e.ename || '의 상사는 '|| m.ename ||'입니다.'
from emp e, emp m
WHERE e.mgr = m.empno(+)
;
select  e.ename,e.empno, e.sal, e.comm, nvl(m.ename, '관리자 없음')
from emp e, emp m
WHERE e.mgr = m.empno(+)
;

select ename, dname
from emp e inner join dept d
on e.deptno=d.deptno
;

--ANSI INNER JOIN
--USING
select *
from emp cross join dept;
select ename, dname
from emp e inner join dept d
using (deptno)
;

--NATURAL JOIN
select ename, dname
from emp natural join dept
;

--ANSI OUTER JOI
select *
from emp e left outer join emp m
on e.mgr=m.empno
;