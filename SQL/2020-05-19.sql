--2020.05.19

-- 특정 데이터를 추출하기 : where절을 이용
-- select 컬럼명 from 테이블명 where 조건(true or false)

-- 전체 사원 중 월 급여가 3000이상인 사원의 dlfma 리스트

select empno, ename, sal from emp where sal>=3000;

-- 전체 사원 중 10번 부서의 소속 사원의 이름과 직급을 출력해주세요.
select ename, job
from emp where deptno=10
;

-- 컬럼의 값과 일치 여부 확인 : = 사용
select *
from emp
where deptno=10
;

-- 문자열 표현 : '' 작은 따옴표로 묶는다. 여기선 대소문자 구분함
select *
from emp
where job='MANAGER'
;

select *
from emp
where ename='SCOTT';

-- 날짜를 비교할 때 → '작은 따옴표' 이용한다.
select *
from emp
where hiredate='80/12/17'
;

-- 논리연산자 : AND (둘 다 참일 때, 여러 조건이 모두 만족할 때)
-- 10번 부서 소속인 사원들 '중에서(AND)' 직급이 MANAGER인 사람을 검색하여 
-- 사원명, 부서번호, 직급을 출력하려고 한다면 두 가지 조건을 제시해야 합니다.
-- 조건1 : 10번 부서 소속 → deptno=10
-- 조건2 : job='MANAGER'

select ename, deptno, job
from emp
where deptno=10 and job='MANAGER';

-- 논리연산자 : OR (좌변이든 우변이든 하나라도 true면 true)
-- 10번 부서에 소속된 사원'이거나(OR)' 직급이 MANAGER인 사람을 검색하여 사원명, 부서번호, 직급을 출력합시다.
-- 조건 1 : 10번 부서 소속 → deptno=10
-- 조건 2 : job='MANAGER' 

select ename, deptno, job
from emp
where deptno=10 or job='MANAGER';

-- 논리연산자 : NOT
-- 부서번호가 10번이 아닌 사원의
-- 사원이름, 부서번호, 직급을 출력

select ename, deptno, job
from emp
where deptno!=10;
--where deptno<>10;
--where not deptno=10;

-- 범위 연산 :  논리연산자 사용 AND
-- 2000에서 3000 사이의 급여를 받는 사원

select *
from emp
where sal >=2000 and sal <=3000;


-- 범위 연산자 : 컬럼명 between A and B → A 이상 B 이하
-- 2000에서 3000 사이의 급여를 받는 사원
select *
from emp
where sal between 2000 and 3000;

-- 2000을 초과하고 3000미만의 급여를 받는 사원
-- sal > 2000 and sal<3000
-- sal between 2001 and 2999 

select *
from emp
--where sal>2000 and sal<3000;
where sal between 2001 and 2999;

-- 1987년 입사자 리스트 출력
select * 
from emp
--where hiredate >= '1982/01/01' --1987년 이후
--where hiredate>='1981/01/01' and hiredate<='1981/12/31'
where hiredate between '1981-01-01' and '1981/12/31'
;

-- OR 연산을 간소화 시키는 : IN
-- 서브쿼리, 질의, SQL결과..?
-- 컬럼명 IN (데이터1, 데이터2, 데이터3..)
-- 컬럼=데이터1 or 컬럼=데이터2 or 컬럼=데이터3 or ...


-- 검색하기위해 IN연산자 사용
select * 
from emp
--where comm=300 or comm=500 or comm=1400
-- where comm in (300, 500, 1400)
-- NULL값을 가진 경우를 제외하고 추출
where comm not in (300, 500, 1400)
;

-- 패턴 검색 : LIKE연산자
-- 컬럼명 like 패턴
-- 패턴 : %, _
-- % → 0개 이상 문자열이 가능
-- 'S%' : S로 시작하는 문자열
-- '%S' : S로 끝나는 문자열
-- '%S%': S를 포함하는 문자열

--이름이 'F' 로 시작하는 사원
select *
from emp
-- where ename like 'S' → ename='S' 동등비교
-- where ename like 'A%'
-- where ename like '%IN'
-- where ename like '%AR%'
where ename not like '%A%'
;


-- _ → 1개의 자리 수에 어떠한 문자가 와도 가능
select * from emp
-- where ename like '_A%'
-- where ename like '__A%'
where ename like '%L__'
;

-- null값 확인을 위한 연산자 : is null, is not null
-- 컬럼명 is null : 해당 컬럼의 값이 null인 경우 → true
-- 컬럼명 is not null : 해당 컬럼의 값이 null이 아닌 경우 → true 
select ename, comm
from emp
-- where comm is null
where comm is not null
;

-- row의 정렬
-- 오름차순 : 작은 쪽에서 큰 쪽, ASC(생략 가능 → 기본값)
-- 내림차순 : 큰 쪽에서 작은 쪽, DESC(명시적 사용 필요)
select ename, sal, hiredate, comm
from emp
where empno>0   -- where절 생략가능
--order by ename asc    --문자의 오름차순
--order by ename desc   -- 문자의 내림차순
--order by sal asc    -- 숫자의 오름차순
--order by sal desc    -- 숫자의 내림차순
--order by hiredate asc    -- 날짜의 오름차순
--order by hiredate desc    -- 날짜의 내림차순
--order by comm asc   --null의 오름차순
order by comm desc  --null의 내림차순
;

select ename, sal
from emp
order by sal desc, ename
;

select ename, deptno, sal
from emp
order by deptno, ename
;

select * from TAB;

desc book;
desc customer;
desc orders;

select * from book;
select * from customer;
select * from orders;


--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.

--(1) 도서번호가1인도서의이름
select bookname
from book
where bookid=1;

--(2) 가격이20,000원이상인도서의이름
select bookName
from book
where price>=20000
;

--(3) 박지성의총구매액(박지성의고객번호는1번으로놓고작성)
-- 아직

--(4) 박지성이구매한도서의수(박지성의고객번호는1번으로놓고작성)
-- 아직


--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.

--(1) 마당서점도서의총개수
-- 아직

--(2) 마당서점에도서를출고하는출판사의총개수
-- 아직

--(3) 모든고객의이름, 주소
select name, address
from customer
;

--(4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
select orderid
from orders
where orderdate between '14/07/04' and '14/07/07'
;

--(5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호
select orderid
from orders
where orderdate not between '14/07/04' and '14/07/07'
;

--(6) 성이‘김’씨인고객의이름과주소
select name, address
from customer
where name like '김%'
;

--(7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
select name, address
from customer
where name like '김%' and name like '%아'
;



















