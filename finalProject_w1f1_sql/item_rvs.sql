-- 판매자를 평점줌
-- 평점idx, 판매자가 받은 평점, 평가자midx, 공구idx

SELECT * FROM project.item_rvs;

insert into project.item_rvs 
(score_s, midx, iidx) 
values (4, 3, 1);

delete from project.item_rvs where irsidx=2;