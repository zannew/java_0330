--2020.05.25
--2020.05.27 insert 정보 추가 시, 시퀀스 추가
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

--테이블의 복사 : SUBQUERY이용( as 서브쿼리 ) → 스키마 복사, ROW 복사 (단, 제약조건은 복사되지 않는다.)
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

--테이블에 컬럼을 추가
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
--모든 컬럼에 저장한다면? (컬럼명)생략 가능 ↓
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
--);
--NOT NULL제약 : 컬럼의 값에 null값을 허용하지 않는다.
--(중요)컬럼레벨에서만 정의 가능

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

--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 
--EMP04 테이블을 생성하되 
--사원번호에는 유일키로 사원명은 NOT NULL 제약조건을 설정해 봅시다.

drop table emp04;

create table emp04(
    empno number(4) constraint emp04_empno_uk unique constraint emp04_empno_nn not null,
    ename varchar2(10) constraint emp04_ename_nn not null,
    job varchar2(10),
    deptno number(2)
);
desc emp04;

insert into emp04 values (1111,'TEST','MANAGER',10);
insert into emp04 values (1111,'TEST123','MANAGER',20);
insert into emp04 values (null,'TEST123','MANAGER',20);
select * from emp04;

--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 테이블을 생성하되 
--사원번호에 기본 키 제약 조건을 설정해 봅시다.
drop table emp05;

create table emp05 (
    empno number(4) constraint emp05_empno_pk primary key,
    ename varchar2(10) constraint emp05_ename_nn not null,
    job varchar2(10),
    deptno number(2)
);
desc emp05;

insert into emp05 values (1111,'TEST','MANAGER',10);
insert into emp05 values (1111,'TEST123','MANAGER',20);
insert into emp05 values (null,'TEST123','MANAGER',20);
select * from emp05;

--외래키 제약조건 설정
--사원번호, 사원명, 직급, 부서번호 4개의 칼럼으로 구성된 테이블을 생성하되 
--사원번호에 기본 키 제약 조건을 설정해 봅시다.
--'deptno' 외래키로 제약조건을 설정
--밑에서 따로 정의하게 되면 어떤 컬럼인지 알 수 없음..(컬럼레벨에서 정의)
drop table emp06;

create table emp06 (
    empno number(4) constraint emp06_empno_pk primary key,
    ename varchar2(10) constraint emp06_ename_nn not null,
    job varchar2(10),
    deptno number(2) constraint emp06_deptno_fk references dept(deptno)
);
desc emp06;

insert into emp06 values (1111,'TEST','MANAGER',10);
insert into emp06 values (1111,'TEST123','MANAGER',20);
insert into emp06 values (null,'TEST123','MANAGER',20);
insert into emp06 values (2222,'TEST123','MANAGER',50);
select * from emp06;

--사원번호, 사원명, 직급, 부서번호, 급여, 성별, 생일 7개의 칼럼으로 구성된 테이블을 생성하되 
--기본 키 제약 조건, 외래키 제약 조건은 물론 
--CHECK 제약 조건도 설정해 봅시다.
--DEFAULT 제약 조건으로 BIRTHDAY는 SYSDATE로 입력되도록 처리하자.

create table emp07 (
    empno number(4) constraint emp07_empno_pk primary key,
    ename varchar2(10) constraint emp07_ename_nn not null,
    job varchar2(10) default 'MANAGER',
    deptno number(2) constraint emp07_deptno_fk references dept(deptno),
    gender char(1) constraint emp07_gender_ck check(gender = 'M' or gender= 'F'),
    sal number(7,2) constraint emp07_sal_ck check(sal between 500 and 5000),
    birthday date default sysdate
);
--이렇게 하면 default값 저장 안됨
insert into emp07 values (1111,'TEST',null,10, 'K',6000,null);
insert into emp07 values (1111,'TEST',null,10, 'K',4000,null);
insert into emp07 values (1111,'TEST',null,10, 'M',4000,null);
insert into emp07 values (2222,'TEST',null ,10, 'F',3000,null );
--컬럼을 지정하고 해당 값들만 넣으면 나머지 설정해뒀던 컬럼은 default값이 저장
insert into emp07 (empno, ename, deptno, gender, sal)
values (3333, 'TEST', 10, 'F', 2500);

select * from emp07;

--2020.05.26

--테이블 레벨에서의 제약 조건 정의

--create table emp07 (
--    empno number(4) ,
--    ename varchar2(10) not null,    --not null은 컬럼 레벨에서만..
    --제약의 정의
--);

drop table emp02;

create table emp02 (
    empno number(4),
    ename varchar2(10) constraint emp02_ename_nn not null,
    job varchar2(10) not null,
    deptno number(2),
    constraint emp02_empno_pk primary key(empno),
    constraint emp02_ename_uk unique(ename),
    constraint emp02_deptno_fk foreign key(deptno) references dept(deptno) --해당 pk(dept의 deptno)로 정의
);

--===== 전화번호부( Contact )
-- 대리키 : 일련번호 -> pbIdx →기본키가 마땅하지 않을 때..
-- 이름, 전화번호, 주소, 이메일 <- 기본정보
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임


--  컬럼 레벨
create table phoneinfo_basic(
    pIdx number(6) constraint phoneinfo_basic_pIdx_pk primary key,
    name varchar2(20) constraint phoneinfo_basic_name_nn not null,
    phonenum varchar2(30) constraint phoneinfo_basic_phonenum_nn not null,
    addr varchar2(20) default ' - ',
    email varchar2(20) default ' - ',
    regdate date default sysdate,   --not null제약 안걸림, null값 들어올 경우 자동으로 default값 저장
    fr_type varchar2(10) constraint phoneinfo_basic_fr_type_ck check (fr_type in ('univ', 'com', 'cafe'))
);

create table phoneinfo_univ(
    pIdx number(6) constraint phoneinfo_univ_pIdx_pk primary key,
    major varchar2(20) default ' - ',
    year number(1) default 1 constraint phoneinfo_univ_year_ck check(year between 1 and 4),
    fr_ref number(6) constraint phoneinfo_univ_fr_ref_fk references phoneinfo_basic(pIdx) on delete cascade
);

create table phoneinfo_com(
    pIdx number(6) constraint phoneinfo_com_pIdx_pk primary key,
    companyName varchar2(20) default ' - ' constraint phoneinfo_com_companyName_nn not null,    --null제약 걸림, 컬럼 지정하지 않을 경우 default값 저장
    dName varchar2(20) default ' - ',   --null제약 안 걸림, null값이 들어올 경우 자동으로 default값 저장
    job varchar2(20) default ' - ',
    fr_ref number(6) constraint phoneinfo_com_fr_ref_fk references phoneinfo_basic(pIdx) on delete cascade
);

create table phoneinfo_cafe(

    pIdx number(6) constraint phoneinfo_cafe_pIdx_pk primary key,
    cafeName varchar2(20) default '-' constraint phoneinfo_cafe_cafeName_nn not null,
    nickName varchar2(10) default '-' constraint phoneinfo_cafe_nickname_nn not null,
    fr_ref number(6) constraint phoneinfo_cafe_fr_ref_fk references phoneinfo_basic(pIdx)on delete cascade
);

drop table phoneinfo_univ;
drop table phoneinfo_com;
drop table phoneinfo_cafe;
drop table phoneinfo_basic;

select * from tab;
purge recyclebin;

--테이블 레벨 : 언더바 사용 지양..(자바와 연동 시..)

create table phoneinfo_basic(
    pIdx number(6),
    name varchar2(20) constraint phoneinfo_basic_name_nn not null,
    phonenum varchar2(30) constraint phoneinfo_basic_phonenum_nn not null,
    addr varchar2(20) default ' - ',
    email varchar2(20) default ' - ',
    fr_type varchar2(10),
    regdate date default sysdate,  
    constraint phoneinfo_basic_pIdx_pk primary key(pIdx),
    constraint phoneinfo_basic_fr_type_ck check (fr_type in ('univ', 'com', 'cafe'))
);

create table phoneinfo_univ(
    pIdx number(6),
    major varchar2(20) default ' - ',
    year number(1) default 1 ,
    fr_ref number(6) ,
    constraint phoneinfo_univ_pIdx_pk primary key (pIdx),
    constraint phoneinfo_univ_year_ck check(year between 1 and 4),
    constraint phoneinfo_univ_fr_ref_fk foreign key(fr_ref) references phoneinfo_basic(pIdx)
  
);

create table phoneinfo_com(
    pIdx number(6),
    companyName varchar2(20) default ' - ' constraint phoneinfo_com_companyName_nn not null,  
    dName varchar2(20) default ' - ',
    job varchar2(20) default ' - ',
    fr_ref number(6),
    constraint phoneinfo_com_pIdx_pk primary key(pIdx),
    constraint phoneinfo_com_fr_ref_fk foreign key(fr_ref) references phoneinfo_basic(pIdx)
   
);

create table phoneinfo_cafe(
    pIdx number(6),
    cafeName varchar2(20) default '-' constraint phoneinfo_cafe_cafeName_nn not null,
    nickName varchar2(10) default '-' constraint phoneinfo_cafe_nickname_nn not null,
    fr_ref number(6),
    constraint phoneinfo_cafe_pIdx_pk primary key(pIdx),
    constraint phoneinfo_cafe_fr_ref_fk foreign key(fr_ref) references phoneinfo_basic(pIdx)
);

desc user_constraints;

select * from user_constraints where table_name='PHONEINFO_BASIC';

--===== 전화번호 부( Contact )

-- 대리키 : 일련번호 -> pIdx

-- 이름, 전화번호, 주소, 이메일 <- 기본정보

-- 주소값과 이메일은 입력이 없을 때 기본값 입력

-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능

------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임

create table contact(
    pIdx number(4) primary key,
    name varchar2(10) not null,
    phonenum number(15) not null,
    address varchar2(30) default '입력없음',
    email varchar2(30) default '입력없음',
    fr_type varchar2(10),

    major varchar2(20),
    year number(1),
    companyname varchar(20),
    dname varchar2(20),
    job varchar2(20),
    cafeName varchar2(30),
    nickName varchar2(20),
    
    constraint contact_pIdx_pk primary key(pIdx),
    constraint contact_fr_type_ck check (fr_type in ('univ','com','cafe'))
    
);


--1)basic정보 먼저 입력하고 대학 정보 입력

desc phoneinfo_basic;
desc phoneinfo_univ;
desc phoneinfo_com;
desc phoneinfo_cafe;
select * from phoneinfo_basic;
select * from phoneinfo_univ;
select * from phoneinfo_com;
select * from phoneinfo_cafe;
truncate table phoneinfo_basic;
truncate table phoneinfo_univ;
truncate table phoneinfo_com;
truncate table phoneinfo_cafe;

purge recyclebin;

--★★ pidx의 값과 fr_ref의 값이 일치해야 세부정보 저장 가능 
insert into phoneinfo_basic (pidx, name, phonenum, addr, email, fr_type, regdate)
values(PB_BASIC_IDX_SEQ.nextval, '비버', '01031313131', '서울', 'bieber@naver.com','univ', '2020-01-01');

insert into phoneinfo_univ(pidx, major, year, fr_ref)
values(PB_UNIV_IDX_SEQ.nextval, 'ACCOUNTING', 3, pb_basic_idx_seq.currval);
---------------------------------------------------------------------------------------------
insert into phoneinfo_basic (pidx, name, phonenum, addr, email, fr_type)
values(PB_BASIC_IDX_SEQ.nextval, '오랑', '01029292929', '전주', 'orang@naver.com','com');

insert into phoneinfo_com(pidx, companyname, dname, fr_ref)
values(PB_COM_IDX_SEQ.nextval, '다음카카오', 'DEVELOPMENT',pb_basic_idx_seq.currval);
---------------------------------------------------------------------------------------------
insert into phoneinfo_basic (pidx, name, phonenum, email, fr_type)
values(PB_BASIC_IDX_SEQ.nextval, '함미', '01079797979', 'harmony@gmail.com','cafe');

insert into phoneinfo_cafe(pidx, cafename, nickname, fr_ref)
values(PB_cafe_IDX_SEQ.nextval, '왕초보개발자모임', 'HARMOOI',PB_BASIC_IDX_SEQ.currval);

---------------------------------------------------------------------------------------------


--1.학교 친구 목록 출력
select * from phoneinfo_basic basic, phoneinfo_univ univ
where basic.pidx=univ.fr_ref;

--2.회사 친구 목록 출력
select * from phoneinfo_basic basic, phoneinfo_com com
where basic.pidx=com.fr_ref;

--3.카페 친구 목록 출력
select * from phoneinfo_basic basic, phoneinfo_cafe cafe
where basic.pidx=cafe.fr_ref;


--전체 친구 목록 출력
--OUTER JOIN(+)
select * from phoneinfo_basic basic, phoneinfo_univ univ, phoneinfo_com com,phoneinfo_cafe cafe
where basic.pidx=univ.fr_ref(+) and basic.pidx=com.fr_ref(+) and basic.pidx=cafe.fr_ref(+)
order by basic.pidx;

--LEFT OUTER JOIN
select * 
from phoneinfo_basic basic 
left outer join phoneinfo_univ univ on basic.pidx=univ.fr_ref 
left outer join phoneinfo_com com on basic.pidx=com.fr_ref 
left outer join phoneinfo_cafe cafe on basic.pidx=cafe.fr_ref
order by basic.pidx
;
rollback;
