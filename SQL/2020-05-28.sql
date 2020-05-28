--2020.05.28

-------------------------------------------------
-- INDEX
-------------------------------------------------

-- 검색을 빠르게 하기 위해 사용(+)
-- DML작업 시, 성능 저하가 올 수 있다.(-)

desc user_ind_columns;
select index_name,table_name,column_name
from user_ind_columns
where table_name='emp01'
;



-- 테스트 테이블 생성
drop table emp01;

create table emp01
as
select * from emp
;

insert into emp01
select * from emp01;

select count(*)
from emp01
;

insert into emp01(empno, ename)
values(2222, 'PARK');

select *
from emp01
where ename='PARK'
;
select *
from emp01
where ename='SON'
;
select * from emp where empno=1111;

-- INDEX 생성
-- CREATE INDEX 인덱스명 ON 테이블명 (컬럼명);

create index emp01_ename_idx on emp01(ename);

