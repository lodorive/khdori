-----------------------------------------------------
-- 함수(Function) 
-----------------------------------------------------
-- 입력과 출력으로 이루어진 기능 집합
-- 부르면 무언가 작업해주는 도구

-- <단일행 함수> - 입력과 출력이 1대1인 함수
select book_title from book;
select upper(book_title) from book;
select lower(book_title) from book;
select length(book_title) from book;

select * from book where lower(book_title) like 'harr11y%';
-- <집계 함수> - 데이터를 모아서 하나의 결과를 만드는 함수
select max(book_price) from book;
select min(book_price) from book;
select sum(book_price) from book;
select avg(book_price) from book;
--  count는 해당 항목이 null 이면 카운트 하지 않는다
select count(book_price) from book;
-- null 여부와 관계없이 카운트 하고 싶다면 다음과 같이 사용
select count(*) from book;

-- (주의) 집계함수는 정해진 자리에만 사용할 수 있다
-- select * from book where book_price  max(book_price);

-- <분석 함수>
