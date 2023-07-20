-----------------------------------------------------
-- Top N Query
-----------------------------------------------------
-- 서브쿼리를 사용하여 데이터를 원하는 구간만큼 끊어내는 구문
-- 오라클은 rownum이라는 값을 조회 시 사용할 수 있다
-- rownum은 조회 결과에 순서를 부여한다

/*
select * from (
	select rownum rn, TMP.* from (
		원하는 순서로 정렬하는 구문
	)TMP
) where rn between 시작 and 종료;
 */

-- (Q) 상품을 번호순으로 3개만 조회
-- select * from product where no <=3 order by no asc;

-- (Q) 상품을 가격이 저렴한 순으로 3개만 조회

select * from product order by price asc;
select * from product order by price desc;
select * from product order by no asc;

select rownum, product.* from product order by price asc;
select rownum, product.* from product order by price desc;
select rownum, product.* from product order by no asc;

-- 정렬을 먼저하도록 구조 개선
select rownum, TMP.* 
from(
		select * from product order by price asc
)TMP 
where rownum <=3;

-- 문제점 : 중간부터는 조회가 안됨
select rownum, TMP.* 
from(
		select * from product order by price asc
)TMP 
where rownum between 3 and 5;

-- 해결책 : rownum을 모두 붙인 다음 조회하도록 서브쿼리를 추가
-- rownum은 select마다 생긴다
select * 
from(
	select rownum rn, TMP.* from(
			select * from product order by price asc
	)TMP 
) where rownum between 3 and 5;

-- 해결책 : 두번 째 select에서 발생한 rownum에 별칭을 부여
select * 
from(
	select rownum rn, TMP.* from(
			select * from product order by price asc
	)TMP 
) where rn between 3 and 5;

-- (Q) 가격이 가장 비싼 책 Top 5 조회
select *
from(
	select rownum rn, TMP.* from(
		select * from book order by book_price desc
	)TMP
) where rn between 1 and 5;

-- (Q) 제목이 가장 짧은 책 Top3 조회
select *
from(
	select rownum rn, TMP.* from(
			select  * from book order by length(book_title) asc
	)TMP
)where rn between 1 and 3;

select * from book;

-- (Q) 출간한지 가장 오래된 책 6등~10등 조회
select *
from(
	select rownum rn, TMP.* from(
		select * from book order by book_publication_date asc
	)TMP
)where rn between 6 and 10;
