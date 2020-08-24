-- 오더 테이블
-- 오더idx, 회원idx, 공구idx : o.state=모집완료(0)

SELECT * FROM project.order order by oidx;

insert into project.order (midx, iidx) values (6, 6);