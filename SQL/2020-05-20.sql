--2020.05.20

----------------------------------------
--숫자함수

select mod(10,2)
from dual
;
select mod(sal,10)
from emp
;


select abs(-10)
from dual
;
-- 특정 컬럼의 데이터를 함수로 처리
select abs(sal)
from emp
;

select trunc(3.14159292929, 5)
--select trunc(3.1415920303030,-1)
from dual
;
select trunc(sal,-3)
from emp
;

select round(182883.141592929292, 3)
from dual
;
select round(sal, -2)
from emp
;

-- SYSDATE
select sysdate
from dual
;

-- TO_CHAR
-- date → varchar2
select sysdate, to_char(sysdate, 'yyyy.MM.DD') 
from dual
;
select ename, to_char(hiredate, 'yyyy.mm.dd.dy') as Hiredate
from emp
;

select sysdate, to_char(sysdate, 'HH24:mi:ss')
from emp
;

--2020.05.20. 11:26
--2020.05.20. 11:39
select to_char(sysdate, 'yyyy.mm.dd. hh24:mi')
from dual
;

-- to_char
-- number → varchar2
select to_char(12500,'L000,000')
from dual
;
select to_char(12500,'L999,999')
from dual
;
--자리 수 안 맞으면 오류
select to_char(12500,'0,000')
from dual
;
select to_char(12500,'9,999')
from dual
;

select to_char(3.141592191919,'000,000.000')
from dual
;
select to_char(3.141592191919,'999,999.9')
from dual
;

select ename, sal, to_char(sal*1000, 'L999,999,999'), 
to_char(sal*1000*12+nvl(comm,0),'L999,999,999') as income
from emp
order by income desc
;

-- TO_DATE
-- TO_DATE(원본, 패턴)
-- str → date
select to_date('19810220', 'yyyymmdd')
from dual
;
select to_date('1981/02/20', 'yyyy/mm/dd')
from dual
;

select ename, hiredate
from emp
where hiredate=to_date('1981/02/20', 'yyyy/mm/dd')
;

select sysdate, to_date('20201225', 'yyyymmdd'),
trunc(to_date('20201225', 'yyyymmdd')-sysdate)
from dual
;
select sysdate, trunc(sysdate-to_date('1992-02-21', 'yyyy-mm-dd'))
from dual
;

--TO_NUMBER
--TO_NUMBER(원본, '패턴')
-- str → number : 산술, 관계연산을 목적으로 변환
select to_number('20,000','999,999')-to_number('9,000','999,999') 
from dual
;
--연산이 필요하다면 TO_NUMBER로 저장
--연산이 필요하지 않다면 TO_CHAR로..

-- DECODE함수 : if나 switch구문과 유사
select ename, deptno, 
decode(deptno, 10, 'Accounting',
                20, 'RESEARCH',
                30, 'SALES',
                40, 'OPERATION') as deptname
                
from emp
order by deptno
;


--8. 직급에 따라 급여를 인상하도록 하자. 
--직급이 'ANALYST'인 사원은 5%, 
--'SALESMAN'인 사원은 10%, 
--'MANAGER'인 사원은 15%, 
--'CLERK'인사원은 20%인 인상한다.
select ename,job, sal, 
decode(job,'ANALYST', sal+sal*0.05, --sal*1.05(ok)
            'SALESMAN', sal*1.1,
            'MANAGER', sal*1.15,
            'CLERK', sal*1.2) as upsal
from emp
;

select ename, deptno, 
case
    when deptno=10 then 'ACCOUNTING'
    when deptno=20 then 'RESEARCH'
    when deptno=30 then 'SALES'
    when deptno=40 then 'OPERATION'
    else 'no name'
end as deptname
from emp
;

----------------------------
-- 그룹함수 (   집합함수    )
----------------------------
-- sum, avg, count(많이 사용), max, min

-- sum(컬럼이름) : 해당 컬럼의 데이터들의 합 반환
-- 매월 지급되는 급여의 총합
select sum(sal) as totalSal
from emp
;
select to_char(sum(sal)*1000, 'L999,999,999') as totalSal
from emp
;
select sum(comm)
from emp
;

-- avg(컬럼명) : 해당 컬럼의 데이터들의 평균값 반환
select round(avg(sal))
from emp
;
-- null은 연산의 대상에서 제외한 후 연산한다.
select trunc(avg(comm))
from emp
;


-- MAX, MIN : 해당 컬럼의 데이터 중에서 최대값, 최소값을 반환
select max(sal), min(sal), max(comm), min(comm)
from emp
;


-- count(컬럼명 또는 * ) : 행 (row)의 개수를 반환 (*은 입력된 모든 row의 개수)
select count(*)
from emp
;
select count(comm)  --null을 포함하는 행은 개수로 세지 않는다.
from emp
;
select distinct job from emp order by job;
select count(distinct job) from emp order by job;
select count(distinct job) --distinct 중복을 제거하는 키워드
from emp
;


-- GROUP BY 절 : 특정 컬럼으로 그룹핑을 해준다.
select deptno
from emp
group by deptno
;
select job
from emp
group by job
;

-- 소속 부서별 평균 급여 구하는 예제
select deptno, round(avg(sal),0)
from emp
group by deptno
;
select deptno, to_char(round(avg(sal*1000),2), 'L999,999,999') as salAVG
from emp
group by deptno
;

--소속 부서별 최대, 최소 급여를 구하는 예제
select deptno, max(sal), min(sal)
from emp
group by deptno
;
--부서별로 사원 수와 커미션을 받는 사원들의 수 구하는 예제
select deptno, count(*), count(comm)
from emp
group by deptno
;
select deptno, count(*), count(comm)
from emp
where comm <> 0
group by deptno
;

-- HAVING절
-- 부서별 평균 급여 2000이상인(HAVING) 
-- 부서번호와 부서별 평균 급여 출력
select deptno, avg(sal), count(*), count(comm), sum(comm)
from emp
group by deptno
having avg(sal)<=2000
;

--직급별, 지표 출력
select job, count(*) as "직급별 인원"    --한글 별칭은 큰 따옴표
            ,sum(sal) as "직급별 월 총 급여"
            ,trunc(avg(sal)) as "직급별 월 평균 급여"
            ,nvl(sum(comm),0) as "직급별 수령 커미션의 총 합"
            ,max(sal) as "직급별 최고 급여 금액"
from emp
group by job
--having count(*)>=2   --직급의 인원이 2명 이상인 직급
having avg(sal)>=2000 and count(*)>1
;

select deptno, job
from emp
group by deptno, job
order by job
;