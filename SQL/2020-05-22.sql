--2020.05.22
--------------------------------
--SUB QUERY
-- 
-- main과 sub query를 따로 작성하는 연습
--------------------------------

--평균 급여를 구하는 쿼리문을 서브 쿼리로 사용하여 
--평균 급여보다 더많은 급여를 받는 사원을 검색하는 문장은 다음과 같습니다.
--sub
select avg(Sal)from emp;
--complete
select *
from emp
where sal > (select avg(sal) from emp)
;
--sal 숫자형 단일 값 가진 컬럼이기때문에 서브쿼리의 결과도 동일해야함

--SCOTT과 같은 부서에서 일하는 사람들 리스트
--sub
select deptno
from emp 
where ename='SCOTT';
--complete
select *
from emp
where deptno=(select deptno from emp where ename='SCOTT')
;


--IN
--주어진 문제가 3000 이상 받는 사원이 소속된 부서(10번, 20번)와 
--동일한 부서에서 근무하는 사원이기에 서브 쿼리의 결과 중에서 하나라도 일치하면 참인 결과를 구하는 
--IN 연산자와 함께 사용되어야 합니다.
--sub
select distinct deptno
from emp
where sal>=3000
;
--complete
select *
from emp
where deptno in (select distinct deptno from emp where sal>=3000)
;
--ANY,SOME

--ALL
--complete_1
select ename, sal
from emp
where sal > (select max(sal) from emp where deptno=30)
;
--complete_2
select ename, sal
from emp
where sal > all(select sal from emp where deptno=30)
;

--EXIST
