-----------------------------------------------------
-- 수정(update) 
-----------------------------------------------------
-- 이미 존재하는 데이터의 값을 바꾸는 작업
-- 개인 정보 변경, 조회수 증가, 구독/해지, 좋아요, 게시글 수정, ...

-- update 테이블 이름 set 변경 내용 [조건];

-- 모든 상품의 가격을 0으로 변경
update product set price = 0;

-- 과자만 0원으로 변경
update product set price = 0 where type = '과자';
update product set price = 0 where type = '생필품';

update product set price = 0, name='증정품' where type = '과자';

-- (Q) 1번 상품의 가격을 1500원으로 변경
update product set price = 1500 where no = 1;
-- (Q) 스크류바의 가격을 2000원으로 변경
update product set price = 2000 where name = '스크류바';
-- (Q) 멘토스의 가격을 1000원으로 변경하고 분류를 과자로 변경
update product set price = 1000, type = '과자' where name = '멘토스';
-- 오라클에는 누적연산이 없다 
-- (Q) 과자의 가격을 500원 할인
update product set price = price - 500 where type = '과자';
-- (Q) 아이스크림의 가격을 10% 인상
update product set price = price * 1.1 where type = '아이스크림';

-- 지금까지의 작업을 무효화 시키겠다
rollback;

-- 지금까지의 작업을 확정 저장하겠다
commit;

select * from product;
