-----------------------------------------------------
-- 삭제(delete) 
-----------------------------------------------------
-- 데이터베이스에 저장된 값을 영구적으로 제거하는 것
-- commit / rollback의 영향을 받음

-- delete [from] 테이블 이름 [조건];

-- 전부 다 삭제(비추천)
delete product;

-- (Q) 1번 상품 정보 삭제
delete product where no = 1;

-- (Q) 과자와 아이스크림 상품 정보 삭제
delete product where type in('과자','아이스크림');

-- (Q) 2020년 상반기에 생산한 상품 정보 삭제
delete product where extract(year from made) = 2020 and extract(month from made) between 1 and 6;

rollback;

select * from product;
