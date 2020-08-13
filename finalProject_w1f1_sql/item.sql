-- 공구 item
-- 공구idx, 
-- 제목, 
-- 가격, 
-- 공구인원, 
-- 대기인원(공구2배수), 
-- 등록일, 
-- 마감날짜, 
-- 판매처주소, 
-- 위치좌표, 
-- 내용, 
-- 사진, 
-- 공구현황(진행중/마감..), 
-- 조회수, 
-- 공구타입(추천공구/일반공구), 
-- 게시자midx

SELECT * FROM project.item order by regdate desc;

rollback;

INSERT INTO `project`.`item`
(`title`,
`price`,
`count_m`,
`count_w`,
`receive`,
`addr`,
`location`,
`content`,
`photo`,
`state`,
`view_count`,
`group`,
`midx`)
VALUES
('메론 가치사요 선착순 10명 8282 모이세여',
10000,
10,
`count_m`*2,
'2020-08-19 18-30-00',
'서울시 종로구 종로1가 53',
'좌아표',
'냉무',
'default.jpg',
0,
0,
0,
1);

update project.item
set 

