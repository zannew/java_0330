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

insert into guestbook_message values (message_id_seq.nextval, 'tester10', '123123', 'testmsg');

insert into guestbook_message02 values (message_id_seq.nextval, 'tester', '123123', 'testmsg');


select rownum, message_id, message from guestbook_message;
-- 인라인뷰
select rownum, message_id, message 
from (select * from guestbook_message order by message_id desc);

select * from guestbook_message;
select * from guestbook_message02;

delete from guestbook_message;

commit;

rollback;

-- 서브쿼리로 사용
select rownum, message_id, guest_name, password, message 
from guestbook_message order by message_id desc;

select rownum, message_id, guest_name, password, message 
from (
    select * from guestbook_message order by guestbook_message.message_id desc
);

-- 2 page : 4~6
select rownum, message_id, guest_name, password, message 
from (
    select * from guestbook_message order by guestbook_message.message_id desc
) where rownum <=6;

-- DAO로..
select message_id, guest_name, password, message 
from (
    select rownum rnum, message_id, guest_name, password, message 
    from (
        select * from guestbook_message order by guestbook_message.message_id desc
    ) where rownum<=6
) where rnum>=4
;

select count(*) from guestbook_message;

select * from guestbook_message where message_id = 39;













