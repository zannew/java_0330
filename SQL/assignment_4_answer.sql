--assignment_4_answer
--2020-05-25

--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
--answer
select ename, job
from emp
where job =(select job from emp where empno=7788); --7788 사원의 업무

--my answer
select e.ename, e.job
from emp e
where e.job=(select m.job from emp m where m.empno=7788)
;

--44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
--answer
select ename, job
from emp
where sal>(select sal from emp where empno=7499);

--my answer
select ename, job
from emp
where sal > (select sal from emp where empno=7499)
;

--45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
--complete
--answer_1
select ename, job, sal
from emp
where sal = (select min(sal) from emp);
--answer_2 (비추천) → 데이터 양 변화에 따른 성능 차이 고려..
select ename, job, sal
from emp
where sal <=all(select sal from emp);

--my answer
select min(sal) from emp;
select ename,job, sal
from emp
where sal <= (select min(sal) from emp) 
;

--46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
--answer_1
select job, avg(sal)
from emp
group by job
having avg(sal) <=all(select avg(sal) from emp group by job)
;
--answer_2
select job, avg(sal)
from emp
group by job
having avg(sal) =(select min(avgsal)
from (select avg(sal) avgsal
from emp
group by job))
;

--부서별 평균의 최소 평균값
select job,avg(sal)
from emp
group by job
;
--complete
select min(avgsal)
from (select avg(sal) avgsal
from emp
group by job)
;

--my answer
--ROWNUM
select rownum, job, avgsal
from (select job, avg(sal) avgsal from emp group by job order by avg(sal))
where rownum=1
;
--HAVING
select e.job, avg(e.sal) 
from emp e
group by e.job
having avg(e.sal) <= all(select avg(m.sal) from emp m group by m.job)
;

--47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
--answer
select deptno, min(sal)
from emp
group by deptno
;
--complete
select deptno, sal, e1.ename
from emp e1
where sal in (select min(sal)
from emp e2
where e1.deptno=e2.deptno
group by deptno)
;

--my answer
select ename, sal, deptno
from emp
where sal<=(select min(sal) from emp);

--48. 담당업무가 ANALYST 인 사원보다 
--급여가 적으면서 
--업무가 ANALYST가 아닌 
--사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
--answer
select distinct sal 
from emp
where job='ANALYST'
;
--complete
select empno, ename, job, sal
from emp
where sal < all(select distinct sal from emp where job='ANALYST')
and job != 'ANALYST';

--my answer
select empno, ename, job, sal
from emp
where job not like 'ANALYST' and sal <= all(select e.sal from emp e where job='ANALYST')
;

--49. 부하직원이 없는 사원의 이름을 표시하시오.
--answer
select distinct mgr from emp where mgr is not null;
--complete
select ename, mgr
from emp
where empno not in (select distinct mgr from emp where mgr is not null)
;

--my answer
select e.ename
from emp e
where e.empno not in (select m.empno from emp e, emp m where e.mgr=m.empno)
;

--50. 부하직원이 있는 사원의 이름을 표시하시오.
--answer
--complete
select ename, mgr
from emp
where empno in (select distinct mgr from emp where mgr is not null)
;

-- my answer
select e.ename
from emp e
where e.empno in (
select m.empno 
from emp e, emp m 
where e.deptno = m.deptno and e.mgr=m.empno)
;


--51. BLAKE와 동일한 부서에 속한 사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )

select e.ename, e.hiredate, e.deptno
from emp e
where e.ename != 'BLAKE' and e.deptno = (select deptno from emp where ename = 'BLAKE');

--52. 급여가 평균 급여보다 많은 
--사원들의 사원 번호와 이름을 표시하되 
--결과를 급여에 대해서 오름차순으로 정렬하시오.
--answer
select avg(sal) from emp;
--complete
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal asc
;

-- my answer
select empno, ename, sal
from emp
where sal > (select avg(sal)from emp)
order by sal 
;

--53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
--answer
select distinct deptno
from emp
where ename like '%K%'
;
--complete
select empno, ename, deptno
from emp
where deptno in (select distinct deptno
from emp
where ename like '%K%')
;


--my answer
select e.empno, e.ename, e.deptno
from emp e
where e.deptno in (select m.deptno from emp m where m.ename like '%K%');

--54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
--answer
select deptno 
from dept 
where loc='DALLAS'
;
--complete
select ename, deptno, job
from emp
where deptno in (select deptno 
from dept 
where loc='DALLAS')
;


--my answer(★★다시체크)
select e.ename, e.deptno, e.job
from emp e, dept d
where e.deptno = d.deptno and d.loc='DALLAS'
;

--55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
--answer
--king찾기
select empno
from emp
where ename='KING'
;
--complete
select ename, sal
from emp
where mgr=(select empno
from emp
where ename='KING')
;

-- my answer
select e.ename, e.sal
from emp e
where e.mgr = (select m.empno from emp m where m.ename='KING')
;


--56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
--answer
--research부서 번호 찾기
select deptno
from dept
where dname='RESEARCH'
;
--complete
select deptno, ename, job
from emp
where deptno=(select deptno
from dept
where dname='RESEARCH')
;
--complete(JOIN)
select e.deptno, ename, job
from emp e, dept d
where e.deptno=d.deptno and dname='RESEARCH'
;

--my answer
select e.deptno, ename, job
from emp e
where e.deptno=(select deptno from dept where dname='RESEARCH' )
;

--57. 평균 월급보다 많은 급여를 받고 
--이름에 M이 포함된 사원과 같은 부서에서 
--근무하는 사원의 사원 번호, 이름, 급여를 표시하시오.
--answer
--평균급여
select avg(sal) from emp;
select distinct deptno from emp where ename like '%M%';
--complete
select *
from emp
where sal > (select avg(sal) from emp)
and deptno in (select distinct deptno from emp where ename like '%M%');

--my answer
select e.empno, e.ename, e.sal
from emp e
where sal > (select avg(sal) from emp) 
            and exists (select m.deptno from emp m where m.ename like '%M%');

--58. 평균급여가 가장 적은 업무를 찾으시오.
--answer(ALL)
select avg(sal)from emp group by job;
--complete
select job, avg(sal)
from emp
group by job
having avg(sal) <= all(
    select avg(sal) from emp group by job
);

--my answer
--ROWNUM
select rownum, job
from (select job, avg(sal) from emp group by job order by avg(sal))
where rownum=1
;

--HAVING
select e.job, avg(e.sal) 
from emp e
group by e.job
having avg(e.sal) <= all(select avg(m.sal) from emp m group by m.job)
;

--59. 담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
--answer(why in? : 직급이 manager인 사람이 여러명이라서, why distinct? : 자바와 달리 모두 연산한다.)
select distinct deptno from emp where job='MANAGER';
--complete
select ename
from emp
where deptno in (select distinct deptno from emp where job='MANAGER')
;

--my answer
select ename
from emp
where deptno in (select deptno from emp where job='MANAGER')
;




