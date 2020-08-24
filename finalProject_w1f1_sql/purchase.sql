-- pidx, qr값, 수령여부, 오더idx : p.state=판매완료(1) 모집완료,미수령(0)

SELECT * FROM project.purchase order by oidx;


insert into project.purchase (qr, state, oidx) values ('defaultQrValue', 1, 13);