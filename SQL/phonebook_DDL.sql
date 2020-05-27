-- phonebook DDL
-- ===== 전화번호 부( Contact )

-- 대리키 : 일련번호 -> pbIdx ==> PK 기본키로 만들기 위한 목적

-- 이름, 전화번호, 주소, 이메일 <- 기본정보
-- 주소값과 이메일은 입력이 없을 때 기본값 입력
-- 친구의 타입 (카테고리) : univ, com, cafe 세가지 값만 저장 가능
------ 선택 정보
-- 전공, 학년
-- 회사이름, 부서이름, 직급
-- 모임이름, 닉네임
drop table phonebook;

--2020.05.27 삭제 방법 내용 추가
-- ★★외래키 설정 시 부모의 행이 삭제될 때 설정★★
-- REFERENCES phoneinfo_basic(idx) ON DELETE 설정옵션
-- no action : 모두 삭제 불가
-- cascade : 참조하고 있는 자식 테이블의 모든 행도 삭제
-- set null : 참조하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 null로 변경
-- set default : 참조하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 기본값으로 변경


-- 테이블 레벨 제약 정의
create table phonebook(
    pbidx number(4),                -- 기본키, 대리키
    pbname varchar2(10) not null,   -- 이름
    pbnumber varchar(13) not null,  -- 전화번호
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일
    pbtype varchar2(10) not null,   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1),              -- 학년
    pbcomName varchar2(50),         -- 회사이름    
    pbcomDept varchar2(50),         -- 부서이름
    pbcomJob varchar2(20),          -- 직급
    pbcafeName varchar2(50),        -- 동호회이름
    pbcafeNickname varchar2(50),    -- 닉네임
    
    constraint pb_pbidx_pk PRIMARY KEY (pbidx),
    CONSTRAINT pb_type_ck check (pbtype in ('univ', 'com', 'cafe') ),
    constraint pb_grade_ck check (pbgrade between 1 and 4)
);

-- 컬럼 레벨 제약 정의
create table phonebook(
    pbidx number(4) constraint pb_pbidx_pk PRIMARY KEY,                -- 기본키
    pbname varchar2(10) not null,   -- 이름
    pbnumber varchar(13) not null,  -- 전화번호
    pbaddr varchar(50) default '입력 없음'  not null,    -- 주소
    pbmail varchar2(50) default '입력 없음' not null,   -- 이메일
    pbtype varchar2(10) not null 
    CONSTRAINT pb_type_ck 
        check (pbtype in ('univ', 'com', 'cafe') ),   -- 친구 타입
    pbmajor varchar2(20),           -- 전공
    pbgrade number(1) 
    constraint pb_grade_ck 
    check (pbgrade between 1 and 4),              -- 학년
    pbcomName varchar2(50),         -- 회사이름    
    pbcomDept varchar2(50),         -- 부서이름
    pbcomJob varchar2(20),          -- 직급
    pbcafeName varchar2(50),        -- 동호회이름
    pbcafeNickname varchar2(50)    -- 닉네임    
    
);

-----------------------------------------------------------------

-- 사용자 정의 제약조건을 저장하는 딕셔너리 테이블
desc user_constraints;
select CONSTRAINT_NAME from user_constraints;

select * from user_constraints where table_name='PHONEBOOK';
-----------------------------------------------------------------

--입력 SQL 작성
desc phonebook;

select * from phonebook;

truncate table phonebook;

--기본정보 입력
--학교 친구 정보 입력
--회사 친구 정보 입력
--모임 친구 정보 입력


insert into phonebook (pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype)
values(1, '짱구', '01044444444', 'SEOUL', 'zzang9@naver.com','univ');

insert into phonebook (pbidx, pbname, pbnumber, pbmajor, pbtype, pbgrade)
values(2, '짱아', '01055555555', '영문과','univ', 2);

insert into phonebook(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcomname, pbcomdept, pbcomjob)
values (3, '장윤원', '01052255225', 'SEOUL', 'woni@naver.com', 'com', '네이버', 'MANAGEMENT', null);

insert into phonebook(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcafename, pbcafenickname)
values(4, '왜가리', '01022222222', 'NEWYORK', 'gari@gmail.com', 'cafe', '개발자카페', '가리가리');

insert into phonebook 
values (5, '할미', '01077777777', 'PARIS', 'harmony@gmail.com', 'cafe', '','','','','','스터디카페','MANNHAKDO');

insert into phonebook (pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbmajor, pbgrade)
values(6, '오랑탄', '01024242424', 'SEOUL', 'orang@naver.com', 'univ', '피아노과', '' );

insert into phonebook (pbidx, pbname, pbnumber, pbtype, pbmajor)
values(7, '비버', '01031313131', 'univ', '피아노과');

--------------------------------------------------------------------------------------------------------------
--** 참고코드
-----------------------------------------------------------------
-- 정보 입력 SQL 작성
-----------------------------------------------------------------

desc phonebook;

-- 기본정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype)
values 
(1, 'scott', '010-9999-1234', 'SEOUL', 'scott@gmail.com', 'univ')
;

-- default 입력 처리 pbaddr, pbemail
insert into phonebook 
(pbidx, pbname, pbnumber, pbtype)
values 
(2, 'king', '010-7777-3333', 'univ')
;

-- 학교 친구 정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbmajor, pbgrade)
values 
(3, 'son', '010-3333-1111', '서울', 'son@gmail.com', 'univ', 'computer', 1)
;

-- 회사 친구 정보 입력 
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcomname, pbcomdept, pbcomjob)
values 
(4, '박지성', '010-1234-0000', '런던', 'ji@gmail.com', 'com', 'NAVER', 'SEARCH', 'PROGRAMER')
;

-- 모임 친구 정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcafename, pbcafenickname)
values 
(5, 'Rain', '010-1111-2222', 'SEOUL', 'rain@gmail.com', 'cafe', 'Campping', 'FirstCamp')
;

desc phonebook;

select * from phonebook;


--------------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------
-- 정보 출력 질의 
------------------------------------------------------------------------

-- 1. 기본 정보 출력 질의

select pbidx, pbname, pbnumber from phonebook;

-- 2. 대학 친구 정보 출력 질의

select pbname, pbnumber, pbmajor, pbgrade from phonebook where pbtype='univ';

-- 3. 회사 친구 정보 출력 질의

select pbname, pbnumber, pbcomname, pbcomdept, pbcomjob from phonebook where pbtype='com';

-- 4. 모임 친구 정보 출력 질의

select pbname, pbnumber, pbcafename, pbcafenickname from phonebook where pbtype='cafe';


select * from phonebook;

---------------------------------------------------------------------------------
-- 친구 정보 출력 질의
---------------------------------------------------------------------------------
-- 1. 전체 친구 목록 출력 : 테이블 3개 JOIN
select * 
from phoneinfo_basic pb, phoneinfo_univ pu, phoneinfo_com pc
--where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
where pb.idx=pu.fr_ref(+) and pb.idx=pc.fr_ref(+)
;
-- 2. 학교 친구 목록 출력
select * from phoneinfo_basic pb, phoneinfo_univ pu
where pb.idx=pu.fr_ref
;

select * from phoneinfo_univ;

-- 3. 회사 친구 목록 출력
select * from phoneinfo_basic pb, phoneinfo_com pc
where pb.idx=pc.fr_ref
;

---------------------------------------------------------------------------------
-- 친구 정보 출력 질의
---------------------------------------------------------------------------------

-- 1. 전체 친구 목록 출력 : 테이블 3개 JOIN
select * from phoneinfo_basic basic, phoneinfo_univ univ, phoneinfo_com com
where basic.pidx=univ.fr_ref(+) and basic.pidx=com.fr_ref(+)
order by basic.pidx;
-- 2. 학교 친구 목록 출력
select * from phoneinfo_univ;
-- 3. 회사 친구 목록 출력
select * from phoneinfo_com;

---------------------------------------------------
-- 수정을 위한 SQL
---------------------------------------------------
--1. 회사 친구의 정보 변경
-- 기본 정보 + 회사 정보 수정



--OUTER JOIN(+)
select * from phoneinfo_basic basic, phoneinfo_univ univ, phoneinfo_com com,phoneinfo_cafe cafe
where basic.pidx=univ.fr_ref(+) and basic.pidx=com.fr_ref(+) and basic.pidx=cafe.fr_ref(+)
order by basic.pidx;


rollback;


--★★참고 코드
-- 기본 정보 : phoneinof_basic 테이블
update phoneinfo_basic
set name='SCOTT', phonenum='01011111111', addr='서울', email='scott@gmail.com'
where pidx=2
;
--회사 정보 : phoneinfo_com 테이블
update phoneinfo_com
set companyname='네이버'
where fr_ref=2
;
--★★참고 코드 끝

-- 기본 정보 : phoneinof_basic 테이블
update phoneinfo_basic
set name='우탄', phonenum='01099999999', addr='여의도', email='oooorang@naver.com'
where name='오랑'
;

--회사 정보 : phoneinfo_com 테이블
update phoneinfo_com
set companyname='네이버', dname='MARKETING'
where fr_ref=(select pidx from phoneinfo_basic where fr_type='com' and name='우탄')
;


------------------------------------------------------------------------------

--2. 학교 친구의 정보 변경 
-- 기본 정보 + 학교 정보 수정

--기본 정보 : phoneinfo_basic 테이블

update phoneinfo_basic
set phonenum='0108888888', addr='강남구', email='bb@naver.com'
where name='비버'
;

--학교 정보 : phoneinfo_univ 테이블
update phoneinfo_univ
set major='경영학과' , year=4
where fr_ref=(select pidx from phoneinfo_basic where fr_type='univ' and name='비버')
;

---------------------------------------------------
-- 삭제를 위한 SQL
---------------------------------------------------
--1. 회사 친구 정보를 삭제
--★★참고코드
--회사
delete from phoneinfo_com where fr_ref=2;
delete from phoneinfo_univ where fr_ref=2;
delete from phoneinfo_cafe where fr_ref=2;
delete from phoneinfo_basic where pidx=2;   --on delete cascade : 참조하고 있는 자식 테이블의 모든 행도 삭제
--학교
delete from phoneinfo_com where fr_ref=1;
delete from phoneinfo_univ where fr_ref=1;
delete from phoneinfo_cafe where fr_ref=1;
delete from phoneinfo_basic where pidx=1;

delete from phoneinfo_cafe where fr_ref=3;
delete from phoneinfo_com where fr_ref=3;
delete from phoneinfo_univ where fr_ref=3;
delete from phoneinfo_basic where pidx=3;
--★★끝

--phoneinfo_com 테이블
delete from phoneinfo_com
where fr_ref=(select pidx from phoneinfo_basic where name='오랑')
;

delete from phoneinfo_basic
where name='오랑'
;


--2. 학교 친구 정보를 삭제

--phoneinfo_univ테이블
delete from phoneinfo_univ
where fr_ref=(select pidx from phoneinfo_basic where name='비버')
;

delete from phoneinfo_basic
where name='비버'
;


---------------------------------------------------------------------------------
-- VIEW 생성
---------------------------------------------------------------------------------
-- VIEW : pb_all_view

create view pb_all_view
as
select basic.pidx, 
        name, 
        phonenum, 
        addr, 
        email, 
        fr_type, 
        univ.major, 
        univ.year, 
        com.companyname, 
        com.dname, 
        com.job,
        cafe.cafename,
        cafe.nickname
from phoneinfo_basic basic, phoneinfo_univ univ, phoneinfo_com com, phoneinfo_cafe cafe
where basic.pidx=univ.fr_ref(+) and basic.pidx=com.fr_ref(+) and basic.pidx=cafe.fr_ref(+)
order by pidx
;

--view : pb_com_view
create view pb_com_view
as
select basic.name,
        basic.phonenum,
        basic.addr,
        basic.email,
        basic.fr_type,
        com.companyname,
        com.dname,
        com.job
from phoneinfo_basic basic, phoneinfo_com com
where basic.pidx=com.fr_ref;

drop view pb_univ_view;
drop view pb_com_view;
drop view pb_cafe_view;
drop view pb_all_view;

select * from pb_univ_view;
select * from pb_com_view;
select * from pb_cafe_view;
select * from pb_all_view;


--view : pb_univ_view
create view pb_univ_view
as
select  basic.name,
        basic.phonenum,
        basic.addr,
        basic.email,
        basic.fr_type,
        univ.major,
        univ.year
from phoneinfo_basic basic, phoneinfo_univ univ
where basic.pidx=univ.fr_ref
;
-- view : pb_cafe_view
create view pb_cafe_view
as
select basic.name,
        basic.phonenum,
        basic.addr,
        basic.email,
        basic.fr_type,
        cafe.cafename,
        cafe.nickname
from phoneinfo_basic basic, phoneinfo_cafe cafe
where basic.pidx=cafe.fr_ref
;

rollback;

----------------------------------------------------------------
-- SEQUENCE 생성
----------------------------------------------------------------
--1. basic 테이블 seq
create sequence pb_basic_idx_seq
start with 0
minvalue 0
;
drop sequence pb_basic_idx_seq;

--2. com 테이블 seq
create sequence pb_com_idx_seq
start with 0
minvalue 0
;
drop sequence pb_com_idx_seq;


--3. univ 테이블 seq
create sequence pb_univ_idx_seq
start with 0
minvalue 0
;
drop sequence pb_univ_idx_seq;

--4. cafe 테이블 seq
create sequence pb_cafe_idx_seq
start with 0
minvalue 0
;
drop sequence pb_cafe_idx_seq;