-- 데이터 저장
-- 테이블에 데이터를 저장하는 구문을 작성
-- (주의) 문자열이 외따옴표를 사용(쌍따옴표는 별칭을 붙일때 사용)

-- INSERT INTO 테이블이름(항목) VALUES(값);
INSERT INTO POCKETMON(NO, name, type)
VALUES(1, '이상해씨', '풀');
INSERT INTO POCKETMON(NO, name, type)
VALUES(4, '파이리', '불꽃');
INSERT INTO POCKETMON(NO, name, type)
VALUES(12, '버터플', '벌레');
INSERT INTO POCKETMON(NO, name, type)
VALUES(23, '아보', '독');
INSERT INTO POCKETMON(NO, name, type)
VALUES(25, '피카츄', '전기');

-- 조회 명령
SELECT * FROM POCKETMON;
