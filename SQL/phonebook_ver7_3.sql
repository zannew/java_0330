-- phonebook ver_7_3 분리된 버전

create table phonebook_basic(
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



create table phonebook_univ(
    pIdx number(6),
    major varchar2(20) default ' - ',
    grade number(1) default 1 ,
    fr_ref number(6) ,
    constraint phoneinfo_univ_pIdx_pk primary key (pIdx),
    constraint phoneinfo_univ_grade_ck check(year between 1 and 4),
    constraint phoneinfo_univ_fr_ref_fk foreign key(fr_ref) references phoneinfo_basic(pIdx) on delete cascade
  
);

create table phonebook_com(
    pIdx number(6),
    comName varchar2(20) default ' - ' constraint phoneinfo_com_comName_nn not null,  
    dName varchar2(20) default ' - ',
    comjob varchar2(20) default ' - ',
    fr_ref number(6),
    constraint phoneinfo_com_pIdx_pk primary key(pIdx),
    constraint phoneinfo_com_fr_ref_fk foreign key(fr_ref) references phoneinfo_basic(pIdx) on delete cascade
   
);

------------------------------
--테이블 삭제

drop table phonebook_basic;
drop table phonebook_univ;
drop table phonebook_com;

------------------------------
--시퀀스 삭제

drop sequence phonebook7_3_seq;



----------------------------------------

--시퀀스 생성
create sequence phonebook7_3_seq
start with 0
minvalue 0
;