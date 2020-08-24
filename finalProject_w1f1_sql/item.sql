SELECT * FROM project.item;

update project.item set category=2 where iidx=17;
update project.item set category=0 where title like concat('%수박%');


select * from project.item where title like concat('%%');
  
SELECT @@global.time_zone, @@session.time_zone;

SELECT @@GLOBAL.time_zone, @@SESSION.time_zone, @@system_time_zone;

-- 예상 쿼리문 작성 0818_1800

-- 추천공구글 리스트
-- 추천공구글 리스트 1 : state가 추천공구(1)와 일반공구(0)인 글을 select
-- 추천공구글 리스트 2 : receive와 현재 시점 비교 (판매실패가 아닌 경우)
select * from project.item where state=1 and date(receive)>=date(current_timestamp());
select * from project.item where state=0 and date(receive)>=date(current_timestamp());

-- iidx가 order에 있는 경우
SELECT * FROM project.item AS i JOIN project.order AS o ON i.iIdx = o.iIdx;

select * from project.item as i, project.order as o, project.purchase as p where i.iIdx=o.iIdx or o.oidx=p.oidx;

-- oidx가 purchase에 있는 지 
-- purchase에 o.iidx추가
select p.pidx, p.qr, p.state, p.paydate, p.oidx, o.iidx from project.purchase as p, project.order as o where o.oidx=p.oidx;

--------------------------------------------------------------------------------------------------------------------------------------------------------
-- 판매실패
-- receive가 오늘날짜 이전
select * from project.item where date(receive)<date(current_timestamp());

-- 모집완료(리스트에 보여줄 이름) / 구매자선정(구매현황에서 보여줄 이름)
select * from project.item where date(receive)>=date(current_timestamp());
select p.pidx, p.qr, p.state, p.paydate, p.oidx, o.iidx from project.purchase as p, project.order as o where o.oidx=p.oidx and p.state=0;

	

	SELECT * FROM project.purchase;


	-- 모집완료(리스트에 보여줄 이름) / 구매자선정(구매현황에서 보여줄 이름) : 조합 (모집완료-purchase에 등록된 order이면서 종료날짜가 지나지 않음)
	select p.pidx, p.qr, p.state, p.paydate, p.oidx, o.iidx, i.receive 
    from project.purchase as p, 
    project.order as o, 
    project.item as i 
    where o.oidx=p.oidx 
    and p.state=0 
    and i.iidx=o.iidx 
    and date(i.receive)>=date(current_timestamp());


	-- 판매완료/공구완료 
	select p.pidx, p.qr, p.state, p.paydate, p.oidx, o.iidx, i.receive 
    from project.purchase as p, 
    project.order as o, project.item as i 
    where o.oidx=p.oidx 
    and p.state=1 
    and i.iidx=o.iidx 
    and date(i.receive)>=date(current_timestamp());

--------------------------------------------------------------------------------------------------------------------------------------------------------

	-- 다음기회에 : order에서 state가 거절(1)
	SELECT * FROM project.item AS i, project.order AS o where i.iIdx = o.iIdx and o.state=1;

	-- 참여진행중 : order에서 state가 참여진행중(0)
	SELECT * FROM project.item AS i, project.order AS o where i.iIdx = o.iIdx and o.state=0;
    
    SELECT * FROM project.order;

--------------------------------------------------------------------------------------------------------------------------------------------------------

-- 추천공구글
	select * from project.item where state=1 and date(receive)>=date(current_timestamp());
-- 공구글
	select * from project.item where state=0 and date(receive)>=date(current_timestamp());
-- 참여현황(구매현황)
	select * from project.order as o, project.item as i where o.midx=4 and o.iidx=i.iidx and date(i.receive)>=date(current_timestamp());
-- 판매현황 (판매실패 포함되어있음)
	select * from project.item where midx=1;



	-- 판매실패 : receive가 오늘날짜 이전
	select * from project.item where date(receive)<date(current_timestamp());

	-- 모집완료(리스트에 보여줄 이름) / 구매자선정(구매현황에서 보여줄 이름) : 조합 (모집완료-purchase에 등록된 order이면서 종료날짜가 지나지 않음)
	select p.pidx, p.qr, p.state, p.paydate, p.oidx, o.iidx, i.receive 
    from project.purchase as p, 
    project.order as o, 
    project.item as i 
    where o.oidx=p.oidx 
    and p.state=0 
    and i.iidx=o.iidx 
    and date(i.receive)>=date(current_timestamp());


	-- 판매완료/공구완료 
	select p.pidx, p.qr, p.state, p.paydate, p.oidx, o.iidx, i.receive from project.purchase as p, project.order as o, project.item as i 
    where o.oidx=p.oidx and p.state=1 and i.iidx=o.iidx and date(i.receive)>=date(current_timestamp());


	-- 다음기회에 : order에서 state가 거절(1)
	SELECT * FROM project.item AS i, project.order AS o where i.iIdx = o.iIdx and o.state=1;

	-- 참여진행중 : order에서 state가 참여진행중(0)
	SELECT * FROM project.item AS i, project.order AS o where i.iIdx = o.iIdx and o.state=0;


--------------------------------------------------------------------------------------------------------------------------------------------------------

-- 더미테이터 생성, 테스트

--------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM project.item;
SELECT * FROM project.order;
SELECT * FROM project.purchase;
 SELECT 
        `o`.`midx` AS `midx`,
        `i`.`iidx` AS `iidx`, 
        `o`.`oidx` AS `oidx`,
        `p`.`pidx` AS `pidx`,
        `i`.`title` AS `title`,
         `i`.`state` AS `istate`,
         `o`.`state` AS `ostate`,
        `p`.`state` AS `pstate`
        
        
    FROM
        (
		`project`.`item` `i` 
        LEFT JOIN 
        (`project`.`order` `o` JOIN `project`.`purchase` `p` ON ((`o`.`oidx` = `p`.`oidx`)))
        
        ON ((`o`.`iidx` = `i`.`iidx`)))
        where date(i.receive)>=date(current_timestamp()) and i.state=0
        order by i.iidx;
        
        
--------------------------------------------------------------------------------------------------------------------------------------------------------


 SELECT 
        `i`.`midx` AS `midx`,
        `i`.`iidx` AS `iidx`, 
        `o`.`oidx` AS `oidx`,
        `p`.`pidx` AS `pidx`,
        `i`.`title` AS `title`,
         `i`.`state` AS `istate`,
         `o`.`state` AS `ostate`,
        `p`.`state` AS `pstate`,
         `i`.`receive` AS `ireceive`
        
        
    FROM
        (
		`project`.`item` `i` 
        LEFT JOIN 
        (`project`.`order` `o` JOIN `project`.`purchase` `p` ON ((`o`.`oidx` = `p`.`oidx`)))
        
        ON ((`o`.`iidx` = `i`.`iidx`)))
        where i.midx=1
        order by i.iidx;
















--------------------------------------------------------------------------------------------------------------------------------------------------------
SET @@global.time_zone=SYSTEM;
SET @@session.time_zone='+09:00';

  SELECT 
        `o`.`midx` AS `midx`,
        `o`.`iidx` AS `iidx`,
        `o`.`state` AS `ostate`,
        `i`.`title` AS `title`,
        `p`.`state` AS `pstate`
    FROM
        ((`wifi`.`order` `o`
        JOIN `wifi`.`item` `i` ON ((`o`.`iidx` = `i`.`iidx`)))
        LEFT JOIN `wifi`.`purchase` `p` ON ((`o`.`oidx` = `p`.`oidx`)));


--------------------------------------------------------------------------------------------------------------------------------------------------------

	 SELECT 
        `i`.`iidx` AS `iidx`,
        `o`.`iidx` AS `iidx`,
        `o`.`state` AS `ostate`,
        `i`.`title` AS `title`,
        `p`.`state` AS `pstate`
    FROM
        ((`project`.`order` `o`
        JOIN `project`.`item` `i` ON ((`o`.`iidx` = `i`.`iidx`)))
        LEFT JOIN `project`.`item_rvb` `rvb` ON ((`o`.`oidx` = `rvb`.`oidx`)));






rollback;
commit;

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
set state=1
where iidx=8;