-- 회원
-- 회원idx, id(email), 이름, 회원주소, 전화번호, 회원상태(회원/강퇴/탈퇴)

SELECT * FROM project.member;

commit;

INSERT INTO `project`.`member`
(`id`,
`name`,
`addr`,
`phone`,
`type`)
VALUES
('jangsa@gmail.com',
'장사꾼',
'경기도 고양시 일산동구 정발산동 123',
'010-1567-1333',
1);

DELETE FROM `project`.`member`
WHERE midx=10;


