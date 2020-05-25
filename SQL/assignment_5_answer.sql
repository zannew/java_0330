--assingment_5_answer : JOIN & SUBQUERY
--2020-05-25
select * from book;
select * from customer;
select * from orders;

--1 마당서점의고객이요구하는다음질문에대해SQL 문을작성하시오.
--(5) 박지성이구매한도서의출판사수
--answer(why distinct? 같은 출판사에서 구매했을 가능성)
select count(distinct publisher)
from customer c,orders o, book b
where c.custid=o.custid and o.bookid=b.bookid
and c.name='박지성'
;
--박지성이 구매한 도서id
select distinct bookid from orders o, customer c where o.custid=c.custid and c.name='박지성';

select count(distinct publisher)
from book
where bookid in (select distinct bookid from orders o, customer c where o.custid=c.custid and c.name='박지성')
;

--my answer
--1번
select count(b.publisher) as "출판사 수"
from orders o, book b, customer c
where o.bookid=b.bookid and c.custid=o.custid
and c.custid = (select custid from customer where name='박지성')
;

--2번
select count(publisher) as "출판사 수"
from book
where bookid in (select bookid from orders inner join customer using(custid) where name='박지성')
;


--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
-- answer
--(ONLY JOIN)
select b.bookname, b.price, b.price-o.saleprice as pricegap
from orders o, customer c, book b
where o.custid=c.custid and b.bookid=o.bookid
and c.name='박지성'
;
--(SUBQUERY)
select b.bookname, b.price, b.price-o.saleprice as pricegap
from orders o, book b
where o.bookid=b.bookid
and custid=(select custid from customer where name='박지성')
;
--박지성 custid
select custid from customer where name='박지성';

--my answer
select b.bookname, b.price,(b.price-o.saleprice) as "정가-판매가"
from orders o, book b, customer c
where o.bookid=b.bookid and c.custid=o.custid
and c.custid = (select custid from customer where name='박지성')
;

--(7) 박지성이구매하지않은도서의이름
--answer
select bookname, bookid
from book
where bookid not in (select o.bookid
from orders o, customer c
where o.custid=c.custid and c.name='박지성')
;
--박지성이 구매한 도서
select *
from orders o, customer c
where o.custid=c.custid and c.name='박지성'
;
--my answer
select bookname
from book
where bookid not in(select bookid from orders join customer using(custid) where name='박지성')
;

--2 마당서점의운영자와경영자가요구하는다음질문에대해SQL 문을작성하시오.
--(8) 주문하지않은고객의이름(부속질의사용)
--answer
--OUTER JOIN(없는 쪽에 (+) : orders에 포함되지 않은 고객이 있음)
select name
from orders o, customer c
where o.custid(+)=c.custid
and o.orderid is null
;
--SUBQUERY
select name
from customer
where custid not in (select distinct custid from orders)
;

--my answer
select name
from customer
where custid not in (select custid from orders)
;

--(9) 주문금액의총액과주문의평균금액
--answer
select sum(saleprice), avg(saleprice)
from orders
;
--my answer
select sum(saleprice), avg(saleprice)
from orders
;

--(10) 고객의이름과고객별구매액
--answer
select c.name, sum(saleprice)
from orders o, customer c
where o.custid=c.custid
group by c.name
;

--my answer
select name, sum(saleprice) as "총 구매액"
from orders o, customer c
where o.custid=c.custid
group by name
;

--(11) 고객의이름과고객이구매한도서목록
--answer
select c.name, b.bookname
from orders o, book b, customer c
where o.bookid=b.bookid and c.custid=o.custid
;


--my answer
select name, bookname
from orders o, book b, customer c
where o.bookid=b.bookid and c.custid=o.custid;



--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
--answer
--MAX값
select max(b.price-o.saleprice)
from orders o, book b
where o.bookid=b.bookid
;
--차 구하기
select b.bookname, b.price-o.saleprice
from orders o, book b
where o.bookid=b.bookid
and price-saleprice=(select max(b.price-o.saleprice)
from orders o, book b
where o.bookid=b.bookid)
;

--my answer
select *
from book b, orders o
where b.bookid=o.bookid 
and price-saleprice >= all(select price-saleprice from book b, orders o
where b.bookid=o.bookid )
;

--(13) 도서의 판매액 평균보다 
--자신의 구매액 평균이 더 높은 고객의 이름
--answer
--자신의 구매액 평균
--complete
select c.name, avg(saleprice)
from orders o, customer c
where o.custid=c.custid
group by c.name
having avg(saleprice) > (select avg(saleprice) from orders)--전체 구매액 평균
;
--전체 구매액 평균
select avg(saleprice)
from orders
;


--my answer
--1번
select name
from orders o, customer c
where o.custid = c.custid 
group by name
having avg(saleprice) > (select avg(saleprice) from orders)
;
--2번
select name
from orders inner join customer 
using(custid)
group by name
having avg(saleprice) > (select avg(saleprice) from orders inner join customer using(custid))
;

--3. 마당서점에서 다음의 심화된 질문에 대해 SQL 문을 작성하시오.
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
--answer
select c.name
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
and b.publisher in (select distinct b.publisher
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
and c.name='박지성')--박지성이 구매한 도서의 출판사
and c.name!='박지성'
;
--박지성이 구매한 도서의 출판사
select distinct b.publisher
from orders o, customer c, book b
where o.custid=c.custid and o.bookid=b.bookid
and c.name='박지성'
;

--my answer
select name
from orders o, book b, customer c
where o.bookid=b.bookid and c.custid=o.custid and name !='박지성'
and publisher in (select publisher
from orders o, book b, customer c
where o.bookid=b.bookid and c.custid=o.custid  
and c.custid = (select custid from customer where name='박지성'))
;

--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
--answer


--my answer
select name
from orders o, book b, customer c
where o.bookid=b.bookid and c.custid=o.custid 
group by name
having count(distinct publisher) >= 2
;

