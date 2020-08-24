-- 판매현황 (날짜비교 : 판매실패 / 모집중)

SELECT * FROM project.mysell;




SELECT count(*) FROM project.mysell;
SELECT count(*) FROM project.mysell where ireceive<current_timestamp();