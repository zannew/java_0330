--2020.05.26

-----------------------------------------------------------------------------------
-- DML
-----------------------------------------------------------------------------------

drop table dept01;

--dept테이블 컬럼만 복사
create table dept01
as select * from dept where 1<0;

desc dept01;
select * from dept01;

--새로운 부서 정보를 입력 : 행단위 입력
--insert into 테이블명 (입력하고자 하는 컬럼들 ,로 구분) values (데이터들 ,로 구분)
--입력 컬럼의 순서와 입력데이터의 순서는 같아야 한다.

insert into dept01 (deptno, dname, loc) values (10, 'MARKETING','SEOUL'); 
insert into dept01 (dname, deptno, loc) values ('MARKETING', 10, 'AMSTERDAM');
insert into dept01 (deptno, dname) values (40, 'DEV');

insert into dept01 values(20, 'DESIGN','BUSAN');
insert into dept01 values ('MARKETING', 10, 'AMSTERDAM');   -- 컬럼 지정하지 않을 경우 기본 컬럼 순으로..

create table dept02(
    deptno number(2) not null,
    dname varchar2(20) not null,
    loc varchar2(20) default 'SEOUL'
);


insert into dept02 (deptno, dname, loc) values (10, 'MARKETING','SEOUL'); 
--null값의 입력
insert into dept02 (deptno, dname, loc) values (20, 'MARKETING', null);     -- 명시적으로 null값을 입력하면 null값이 저장
insert into dept02 (deptno, dname, loc) values (30, 'MARKETING', '');

insert into dept02 (deptno, dname) values (40, 'DEV');
--오류
insert into dept02(deptno, dname) values (40,'DEV', 'BUSAN');
insert into dept02(deptno, dname, loc) values (40,'DEV','');
insert into dept02 values (40,'DEV','AMSTERDAM');
insert into dept02 values (50,'DEV','');

desc dept02;
select * from dept02;

insert into dept02 (deptno, dname, loc) values (60, 'test', 'locTest');

