-- 아이템 출력 (판매완료(표시안함) : 0-1 / 모집완료 : 0-1 / 모집중 : 0 or null-null / 출력 : 추천-일반)


SELECT * FROM project.myitem;

SELECT count(*) FROM project.myitem where istate=0;