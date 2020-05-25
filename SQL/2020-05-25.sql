--2020.05.25

---------------------------------------------------------------------
-- DDL : commit없이 바로 물리적 반영되기 때문에 조심! 특정시점에 자동 백업된 데이터만 복구 가능
--(DML은 transation으로 복구 가능)
---------------------------------------------------------------------

--테이블 생성
--create table 테이블이름 (
-- 컬럼명1 타입(사이즈), 컬럼명2 타입 (사이즈), ... );← 괄호 안에 컬럼을 정의

-- ddl_test라는 이름의 테이블을 생성
-- 컬럼1 : no, 숫자타입, 사이즈는 3
-- 컬럼2 : name, 가변문자열 타입, 사이즈는 10
-- 컬럼3 : birth, 날짜타입, 기본값은 현재 시간

create table ddl_test(
    no number(3),
    name varchar2(10),
    birth date default sysdate
);

desc ddl_test;
select *
from ddl_test;

insert into ddl_test(no, name)
values(1,'SCOTT')
;
select * from ddl_test
;


--emp테이블 참조
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된 emp01 테이블을 생성해보자.
desc emp;

create table emp01(
    empno number(4),
    ename varchar2(10),
    sal number(7,2)    
);

select * from emp01;
select * from tab;
desc emp01;

--테이블의 복사 : SUBQUERY이용 → 스키마 복사, ROW 복사 (단, 제약조건은 복사되지 않는다.)
--백업용 사용 多
create table emp02
as 
select * from emp
;

select * from tab;
select * from emp02;
desc emp02;

--지정한 컬럼만 복사 : emp 테이블의 empno와 ename 컬럼만 복사해서 새로운 테이블 emp03을 생성하자.

create table emp03
as
select empno, ename from emp
;

select * from emp03;
desc emp03;

--emp 테이블의 10번 부서의 데이터만 복사해서 새로운 테이블을 emp04를 생성하자.

create table emp04
as select * from emp where deptno=10
;

select * from emp04;

--emp 테이블의 스키마 구조만 복사해서 새로운 테이블 emp05를 생성하자.

create table emp05
as select * from emp where 1<0;

select * from emp05;

--테이블에 컬럼 추가
--alter table 테이블명 add (컬럼이름 컬럼타입 컬럼제약..)

--emp01테이블에 직급(job)컬럼을 추가하자.

desc emp01;

alter table emp01 add (job varchar2(10));

desc emp01;

--컬럼의 변경
--  alter table 테이블명 modify(기존컬럼이름 타입 제약..)
--직급(JOB) 칼럼을 최대 30글자까지 저장할 수 있게 변경해 보도록 하자.
--※컬럼타입을 제외하고 제약을 선언할 수는 없다.
alter table emp01 modify(job varchar(30) not null);

desc emp01;

--컬럼의 삭제
--alter table 테이블명 drop column 컬럼명
alter table emp01 drop column sal;

desc emp01;

--테이블 객체 삭제
--drop table 테이블명;
drop table emp01;

select * from tab;

desc emp01;

--테이블 모든 ROW 삭제
-- TRUNCATE
truncate table emp02;

select * from emp02;

--테이블 이름 변경
-- rename 현재 테이블명 to 새로운 테이블명

rename emp02 to test_emp;

select * from tab;

desc dept;
--모든 컬럼에 저장한다면 (컬럼명)생략 가능 ↓
insert into dept values (10, 'test', 'SEOUL');

-- 컬럼의 제약 정의는 컬럼정의를 하면서 컬럼 옆에 정의
-- 컬럼의 타입을 모두 정의하고, 아래에 제약을 정의하는 방법
--방법1
--create table emp01(
--    empno number(4) not null
--);
--방법2
--create table emp01(
--    empno number(4),
--    primary key(empno)
);
--NOT NULL제약 : 컬럼의 값에 null값을 허용하지 않는다.
--컬럼레벨에서만 정의 가능

--사원 테이블(EMP02)을 
--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성하되 
--이번에는 사원번호와 사원명에 NOT NULL 조건을 지정하도록 합시다.

drop table emp02;

create table emp02(
    empno number(4) not null,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);

desc emp02;

insert into emp02 values(null,null,'MANAGER',10);

insert into emp02 values(1111,null,'MANAGER',10);

insert into emp02 values(1111,'WONI','MANAGER',10);

select * from emp02;

drop table emp03;

select * from tab;

create table emp03 (
    empno number(4) unique,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);
--unique와 not null을 primary key로 제약 줄 수 있지만 따로 제약 주는 경우도 있음 → 주민번호
create table emp03 (
    empno number(4) unique not null,
    ename varchar2(10) not null,
    job varchar2(10),
    deptno number(2)
);
desc emp03;

insert into emp03 values (1111,'TEST','MANAGER',10);
insert into emp03 values (1111,'TEST123','MANAGER',20);
insert into emp03 values (null,'TEST123','MANAGER',20);


select * from emp03;
