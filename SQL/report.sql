-- report

create sequence report_seq;


create table report(
    idx number(4) primary key,
    sname varchar2(20) not null,
    sno varchar2(10) not null,
    reportFile  varchar2(100) not null  -- 파일이름과 경로까지 모두 저장
);

insert into report values (report_seq.nextval, '길동','1234','/file/123123123_report.ppt');

select * from report;


drop table report;
drop sequence report_seq;

delete from report;

commit;