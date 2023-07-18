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
DROP TABLE score;
CREATE TABLE score(
school_year NUMBER,
half NUMBER,
name varchar2(21),
korean NUMBER(3),
english number(3),
math number(3)
);

INSERT INTO score(school_year, half, name, korean, english, math)
values(1,1,'마리오',50,60,50);
INSERT INTO score(school_year, half, name, korean, english, math)
values(1,1,'루이지',60,90,50);
INSERT INTO score(school_year, half, name, korean, english, math)
values(1,2,'쿠파',70,70,80);
INSERT INTO score(school_year, half, name, korean, english, math)
values(1,2,'요시',80,85,35);

SELECT * FROM score;

DROP TABLE ACCOUNT;
CREATE TABLE account(
name varchar2(21),
days number,
round number,
month_pay number,
total number
);

INSERT INTO account(name, days, round, month_pay, total) 
VALUES ('유재석',3,15,100,1500);
INSERT INTO account(name, days, round, month_pay, total) 
VALUES ('강호동',2,5,50,250);
INSERT INTO account(name, days, round, month_pay, total) 
VALUES ('신동엽',2,8,80,100);

SELECT * FROM account;
