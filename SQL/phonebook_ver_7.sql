-- phonebook ver_7

-- 시퀀스 만들기
drop sequence phonebook7_seq;

create sequence phonebook7_seq
start with 0
minvalue 0
;






-------------------------------------------------
--테이블 생성, 확인, 삭제
-------------------------------------------------
drop table phonebook;

select * from phonebook;
select pbidx from phonebook where pbname='박지성';
commit;
===========================================================
--입력예시



desc phonebook;

-- 기본정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype)
values 
(PHONEBOOK7_SEQ.nextval, 'scott', '010-9999-1234', 'SEOUL', 'scott@gmail.com', 'univ')
;

-- default 입력 처리 pbaddr, pbemail
insert into phonebook 
(pbidx, pbname, pbnumber, pbtype)
values 
(PHONEBOOK7_SEQ.nextval, 'king', '010-7777-3333', 'univ')
;

-- 학교 친구 정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbmajor, pbgrade)
values 
(PHONEBOOK7_SEQ.nextval, 'son', '010-3333-1111', '서울', 'son@gmail.com', 'univ', 'computer', 1)
;

-- 회사 친구 정보 입력 
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcomname, pbcomdept, pbcomjob)
values 
(PHONEBOOK7_SEQ.nextval, '박지성', '010-1234-0000', '런던', 'ji@gmail.com', 'com', 'NAVER', 'SEARCH', 'PROGRAMER')
;

-- 모임 친구 정보 입력
insert into phonebook 
(pbidx, pbname, pbnumber, pbaddr, pbmail, pbtype, pbcafename, pbcafenickname)
values 
(PHONEBOOK7_SEQ.nextval, 'Rain', '010-1111-2222', 'SEOUL', 'rain@gmail.com', 'cafe', 'Campping', 'FirstCamp')
;

desc phonebook;

select * from phonebook;




===========================================================