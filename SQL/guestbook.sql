-- 방명록 테이블 

create table guestbook_message (
    message_id  number(4) primary key,
    guest_name varchar2(50) not null,
    password varchar2(10) not null,
    message varchar2(2000) not null
);

create table guestbook_message02 (
    message_id  number(4) primary key,
    guest_name varchar2(50) not null,
    password varchar2(10) not null,
    message varchar2(2000) not null
);

create sequence message_id_seq increment by 1 start with 1;

insert into guestbook_message values (message_id_seq.nextval, 'tester', '123123', 'testmsg');

insert into guestbook_message02 values (message_id_seq.nextval, 'tester', '123123', 'testmsg');


select * from guestbook_message;

select * from guestbook_message02;

delete from guestbook_message;

rollback;