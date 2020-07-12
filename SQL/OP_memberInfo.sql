-- OpenProject 회원가입 테이블

create table memberInfo (
    uid varchar2(30) primary key,
    upw varchar2(30) not null,
    uname varchar2(20) not null,
    uphoto varchar2(100) not null
);

create table memberinfo(
    mid varchar2(20) primary key,
    mpw varchar2(30) not null,
    mname varchar2(20) not null,
    mphoto varchar2(100) not null  -- 파일이름과 경로까지 모두 저장
);

select * from memberinfo;

insert into memberinfo values ('test','test','손흥민','흥미니.jpg');


commit;