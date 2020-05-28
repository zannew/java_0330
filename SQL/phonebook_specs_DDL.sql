-- phonebook_DDL_ specification 2020.05.27


-- ★★외래키 설정 시 부모의 행이 삭제될 때 설정★★
-- REFERENCES phoneinfo_basic(idx) ON DELETE 설정옵션
-- no action : 모두 삭제 불가
-- cascade : 참조하고 있는 자식 테이블의 모든 행도 삭제
-- set null : 참조하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 null로 변경
-- set default : 참조하고 있는 자식 테이블의 모든 행의 외래키 컬럼의 값을 기본값으로 변경

-----------------------------
--  생성
-----------------------------

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

--  테이블 레벨 : 언더바 사용 지양..(자바와 연동 시..)

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


-----------------------------
--  입력
-----------------------------



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



-----------------------------
--  수정
-----------------------------

--1. 회사 친구의 정보 변경
-- 기본 정보 + 회사 정보 수정

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



-----------------------------
--  삭제
-----------------------------
--1. 회사 친구 정보를 삭제
--★★참고코드
--회사
delete from phoneinfo_com where fr_ref=2;
delete from phoneinfo_univ where fr_ref=2;
delete from phoneinfo_basic where pidx=2;   --on delete cascade : 참조하고 있는 자식 테이블의 모든 행도 삭제
--학교
delete from phoneinfo_com where fr_ref=1;
delete from phoneinfo_univ where fr_ref=1;
delete from phoneinfo_basic where pidx=1;
--★★끝

--phoneinfo_com 테이블
delete from phoneinfo_com
where fr_ref=(select pidx from phoneinfo_basic where name='오랑')
;
--phoneinfo_baisc 테이블
delete from phoneinfo_basic
where name='오랑'
;


--2. 학교 친구 정보를 삭제

--phoneinfo_univ테이블
delete from phoneinfo_univ
where fr_ref=(select pidx from phoneinfo_basic where name='비버')

;
--phoneinfo_baisc 테이블
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
        com.job 
from phoneinfo_basic basic, phoneinfo_univ univ, phoneinfo_com com
where basic.pidx=univ.fr_ref(+) and basic.pidx=com.fr_ref(+)
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

----------------------------------------------------------------
-- SEQUENCE 생성
----------------------------------------------------------------
--1. basic 테이블 seq
create sequence pb_basic_idx_seq
start with 0
minvalue 0
;


--2. com 테이블 seq
create sequence pb_com_idx_seq
start with 0
minvalue 0
;



--3. univ 테이블 seq
create sequence pb_univ_idx_seq
start with 0
minvalue 0
;


--4. cafe 테이블 seq
create sequence pb_cafe_idx_seq
start with 0
minvalue 0
;





