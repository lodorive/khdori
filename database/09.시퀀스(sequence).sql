/*
	시퀀스(sequence)
	- 번호를 발행해주는 기계(도구/객체)
	- 데이터베이스 종류에 따라 스퀀스가 테이블과 합쳐져 있는 경우도 있음(ex : mysql)
	- 오라클은 전반적으로 시퀀스를 따로 관리하는 것을 권장
	
	create sequence 이름 [옵션];
	
	drop sequence 이름;
	select * from user_sequence;
*/

drop table item;
create table item(
item_no number primary key,
item_name varchar2(60) not null,
item_price number not null
);

drop sequence item_seq;

-- 기본 옵션으로 생성
create sequence item_seq;

-- 옵션을 지정하여 생성(1001번부터 9999번까지 1씩 증가, 캐시없음)
create sequence item_seq
minvalue 1001
maxvalue 9999
increment by 1
start with 1001
nocache;
--cache 5;

insert into item(item_no, item_name, item_price)
-- values(1,'컴퓨터',1000000);
values(item_seq.nextval,'컴퓨터',1000000);

select * from item;

select * from user_sequences;
