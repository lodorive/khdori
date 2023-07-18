-- 문제1 : 월드컵 선수 정보
DROP TABLE worldcup;
create table worldcup(
rank number,
name varchar2(30),
nation varchar2(30),
goal number
);

-- 문제2 : 메달리스트 정보
DROP TABLE medalist;
create table medalist(
name varchar2(21),
event varchar2(12),
type varchar2(30),
gold number,
silver number,
bronze number
);

-- 문제3 : 통신사 요금제 정보
-- 통신사가 무조건 2자리라면 고정문자열 처리
-- (장점) 빠른 처리 속도
-- (단점) 글자 수가 다를 수 없음
DROP TABLE plan;
CREATE TABLE plan(
telecom char(2),
name varchar2(60),
month_price number,
DATA number,
CALL number,
sms number
);

-- 메뉴 정보 테이블
-- (참고) 테이블 자료형에는 논리가 없다
-- Y/N으로 처리하거나 1/0으로 처리
DROP TABLE menu;
CREATE TABLE menu(
name varchar2(60),
TYPE varchar2(9),
price number,
event char(1)
);
