/*
 	테이블 제약조건(table constraint)
 	- 보관할 데이터의 유효성을 검사하기 위하여 컬럼에 설정하는 조건
 	- and 라는 키워드로 && 처리를 한다
 	- or이라는 키워드로 ||를 처리를 한다
 	- not이라는 키워드로 !처리를 한다
 	- between은 ~이상 ~이하 처리를 한다(구간 설정)
 	- 오라클에서 같다는 = 이다
 	- in (a, b, c)는 a, b, c중 하나여야 한다는 의미
 	
 	조건의 종류
 	- check : 추가할 데이터의 형식 검사를 설정(null 제외)
 	- not null : 해당 항목에 null을 허용하지 않겠다는 설정(즉, 필수항목)
 	- unique : 특정 항목에 중복을 허용하지 않겠다는 설정
 		(여러 항목을 묶어도 가능 - 복합키 설정이라고 부름)
 */

drop table score;
create table score(
grade number check(grade >= 1),
room number check(room >= 1),
name varchar2(21) check(regexp_like(name,'^[가-힣]{2,7}$')),
--korean number(3) check(korean >= 0 and korean <=100),
korean number(3) check(korean between 0 and 100),
english number(3) check(english between 0 and 100),
math number(3) check(math between 0 and 100)
);

drop table account;
create table account(
account_owner varchar2(21) check(regexp_like(account_owner,'^[가-힣]{2,7}$')),
account_period number check(account_period in (1, 2, 3, 5, 10)),
account_count number check(account_count >= 1),
account_payment number check(account_payment > 0 and mod(account_payment, 10000) = 0),
account_balance number check(account_balance >= 0)
);

insert into account(account_owner, account_period, account_count, account_payment, account_balance)
values(null, null, null, null, null);

-- not null 추가
drop table score;
create table score(
grade number not null check(grade >= 1),
room number not null check(room >= 1),
name varchar2(21) not null check(regexp_like(name,'^[가-힣]{2,7}$')),
--korean number(3) check(korean >= 0 and korean <=100),
korean number(3) check(korean between 0 and 100),
english number(3) check(english between 0 and 100),
math number(3) check(math between 0 and 100)
);

insert into score(grade, room, name, korean, english, math)
values(null, null, null, null, null, null);

insert into score(grade, room, name, korean, english, math)
values(1, 1, '테스트', 10, 20, 30);

select * from score;

-- unique 추가
drop table score;
create table score(
grade number not null check(grade >= 1),
room number not null check(room >= 1),
name varchar2(21) not null check(regexp_like(name,'^[가-힣]{2,7}$')),
--korean number(3) check(korean >= 0 and korean <=100),
korean number(3) check(korean between 0 and 100),
english number(3) check(english between 0 and 100),
math number(3) check(math between 0 and 100),
unique(grade, room, name)
);

insert into score(grade, room, name, korean, english, math)
values(1, 2, '테스트', 10, 20, 30);
