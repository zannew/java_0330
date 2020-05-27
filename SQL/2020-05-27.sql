-- 2020.05.27

-----------------------------------------------------------------------------------
-- DML : UPDATE SET
-----------------------------------------------------------------------------------

drop table emp01;

create table emp01
as 
select * from emp;

select *
from emp01;

--컬럼의 데이터 변경(수정)
--UPDATE 테이블명 SET 컬럼명1=값, 컬럼명2=값, ... WHERE ROW찾는 조건식
--WHERE절이 없는 경우 테이블의 모든 행이 영향을 받음

--  1. 모든 사원의 부서번호를 30번으로 수정하자.
update emp01
set deptno=30;

--  2. 모든 사원의 급여를 10% 인상시키는 UPDATE문을 보자.
update emp01
--set sal=sal+sal*0.1;
set sal=sal*1.1
;

--  3. 모든 사원의 입사일을 오늘로 수정해보자.
update emp01
set hiredate=sysdate
;

--최근까지 작업이 문제없는지 판단해본 후,
commit;

--**마지막으로 물리적 저장 상태로 돌린다.
--COMMIT을 하지 않았다면.. emp01까지 바뀜
rollback;


-------------------------------
-- WHERE조건으로 특정 컬럼만 수정
-------------------------------
-- 1. 부서번호가 10번인 사원의 (WHERE)
--부서번호를 30번으로 수정하자. (UPDATE-SET)
SELECT * FROM emp01;

update emp01
set deptno=30
where deptno=10
;

--  2. 급여가 3000 이상인 사원만 (WHERE)
-- 급여를 10% 인상하자.    (UPDATE-SET)
update emp01
set sal=sal*1.1
where sal>=3000;

-- 3.1987년에 입사한 사원의 (WHERE)
--입사일을 오늘로 수정하자.    (UPDATE-SET)
--사원의 입사일을 오늘로 수정한 후에 테이블 내용을 살펴봅시다.
select * from emp
--where hiredate between '1987/01/01' and '1987/12/31';
where substr(hiredate, 1, 2)='87';
--(완성해)where to_char(hiredate, 'YY')='87';

update emp01
set hiredate=sysdate
where substr(hiredate, 1, 2)='87'
;

-------------------------------
-- 2개 이상의 컬럼 수정
-------------------------------
-- 1. SCOTT 사원의 (WHERE)
--부서번호는 10번으로, 직급은 MANAGER로 한꺼번에 수정하자. (UPDATE-SET)

update emp01
set deptno=10, job='MANAGER'
where ename='SCOTT'
;

select * from emp01 where ename='SCOTT';

-- 2. SCOTT 사원의 
--입사일자는 오늘로, 
--급여를 50 으로 커미션을 4000 으로 수정하자.

select * from emp01 where ename='SCOTT';

update emp01
set hiredate=sysdate, sal=50, comm=4000
where ename='SCOTT'
;


-------------------------------
-- 서브쿼리 사용하여 컬럼 수정
-------------------------------


-- 1. 20번 부서의 지역명을 
--    40번 부서의 지역명으로 변경하기 위해서 서브 쿼리문을 사용해 봅시다.

update dept01
set loc=(
    select loc from dept01 where deptno=40
)
where deptno=20
;

rollback;


drop table dept01;
create table dept01
as
select * from dept
;
select * from dept01;




-- 서브 쿼리를 이용해서 부서번호가 20인 부서의 
-- 부서명과 지역명을 
-- 부서 번호가 40번인 부서와 동일하게 변경하도록 해 봅시다.
update dept01
set dname=(select dname from dept01 where deptno=40),
    loc=(select loc from dept01 where deptno=40)
where deptno=20
;
update dept01
set  (dname, loc)=(select dname, loc from dept01 where deptno=40)
where deptno=20
;


--------------------------------------------------------
-- DML : DELETE
--------------------------------------------------------

-- DELETE  FROM 테이블명 WHERE 행을 찾을 조건식
-- WHERE 절이 없으면 모든행에 영향을 준다.

-- 부서 테이블의 모든 행을 삭제합시다.
delete from dept01;
select * from dept01;

-- 부서 테이블에서 30번 부서만 삭제합시다.
ROLLBACK;

delete from dept01 where deptno=30;

-- 사원 테이블에서 
-- 부서명이 SALES인 사원을 모두 삭제해봅시다.

select deptno from dept where dname='SALES' ;

select * from emp01;

delete from emp01 where deptno=(
    select deptno from dept where dname='SALES'
)
;


















