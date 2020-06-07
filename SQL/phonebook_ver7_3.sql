-- phonebook ver_7_3 분리된 버전

create table phonebook_basic(
    pIdx number(6),
    name varchar2(20) constraint phonebook_basic_name_nn not null,
    phonenum varchar2(30) constraint phonebook_basic_phonenum_nn not null,
    addr varchar2(20) default ' - ',
    email varchar2(20) default ' - ',
    fr_type varchar2(10),
    regdate date default sysdate,  
    constraint phonebook_basic_pIdx_pk primary key(pIdx),
    constraint phonebook_basic_fr_type_ck check (fr_type in ('basic', 'univ', 'com'))
);



create table phonebook_univ(
    pIdx number(6),
    major varchar2(20) default ' - ',
    grade number(1) default 5 ,
    fr_ref number(6) ,
    constraint phonebook_univ_pIdx_pk primary key (pIdx),
    constraint phonebook_univ_grade_ck check(grade between 1 and 5),
    constraint phonebook_univ_fr_ref_fk foreign key(fr_ref) references phonebook_basic(pIdx) on delete cascade
  
);

create table phonebook_com(
    pIdx number(6),
    comName varchar2(20) default ' - ' constraint phonebook_com_comName_nn not null,  
    dName varchar2(20) default ' - ',
    comjob varchar2(20) default ' - ',
    fr_ref number(6),
    constraint phonebook_com_pIdx_pk primary key(pIdx),
    constraint phonebook_com_fr_ref_fk foreign key(fr_ref) references phonebook_basic(pIdx) on delete cascade
   
);
------------------------------
--테이블 확인
select * from phonebook_basic;
select * from phonebook_univ;
select * from phonebook_com;

--basic, univ
select * from phonebook_basic b, phonebook_univ u
where b.pidx=u.fr_ref(+);


--basic, univ, com
select * from phonebook_basic b, phonebook_univ u, phonebook_com c
where b.pidx=u.fr_ref(+) and b.pidx=c.fr_ref(+);

select * from phonebook_basic b join phonebook_univ u join phonebook_com c
on b.pidx=u.fr_ref and b.pidx=c.fr_ref


------------------------------
-- 값 입력
insert into phonebook_basic
values (phonebook7_3_seq.nextval, '짱구', '01052255225', '판교', 'zzang9@gmail.com', 'basic', '20/05/30');

insert into phonebook_basic (pidx, name, phonenum, addr, email, fr_type)
values(phonebook7_3_seq.nextval, '비버', '01031313131', '서울', 'bieber@naver.com','univ');

insert into phonebook_univ(pidx, major, grade, fr_ref)
values(phonebook7_3_univ_seq.nextval, 'ACCOUNTING', 3, phonebook7_3_seq.currval);
-------------------------------------------------------------------------------------------------
insert into phonebook_basic (pidx, name, phonenum, addr, email, fr_type)
values(phonebook7_3_seq.nextval, '오랑', '01029292929', '전주', 'orang@naver.com','com');

insert into phonebook_com(pidx, comname, dname, fr_ref)
values(phonebook7_3_com_seq.nextval, '다음카카오', 'DEVELOPMENT',phonebook7_3_seq.currval);

------------------------------
--데이터 삭제 (test)
delete from phonebook_basic
where name='오랑';

commit;
rollback;
------------------------------
--데이터 수정 (test)
update phonebook_basic
set phonenum='01052525252', addr='여의도', email='orang@gmail.com'
where name='오랑';

update phonebook_com
set dname='네이버'
where fr_ref=(select pidx from phonebook_basic where name='오랑');

--서치 카운트

select count(*) 
from phonebook_basic b, phonebook_univ u, phonebook_com c 
where b.pidx=u.fr_ref(+) and b.pidx=c.fr_ref(+) and name='비버';



------------------------------
--테이블 삭제

drop table phonebook_basic;
drop table phonebook_univ;
drop table phonebook_com;

------------------------------
--시퀀스 삭제
drop sequence phonebook7_3_seq;
drop sequence phonebook7_3_univ_seq;
drop sequence phonebook7_3_com_seq;

----------------------------------------

--시퀀스 생성
create sequence phonebook7_3_seq
start with 0
minvalue 0
;
create sequence phonebook7_3_univ_seq
start with 0
minvalue 0
;
create sequence phonebook7_3_com_seq
start with 0
minvalue 0
;
