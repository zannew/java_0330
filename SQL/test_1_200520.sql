-- test_1 2020.05.20

select *
from orders
;
select *
from customer
;

-- 고객별, 주문수량, 배송지(주소), 가격까지
 select distinct custid as "무료배송 대상 아이디", sum(saleprice) as "총 주문가격"
 from orders
 group by custid
 having sum(saleprice)>=30000
 ;
 select *
 from orders
 ;

-- 부서의 최대값과 최소값을 구하되 최대 급여가 2900이상인 부서만 출력 
select deptno, max(sal), min(sal)
from emp
group by deptno
having max(sal)>=2900
;

