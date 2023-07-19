/*
	날짜 데이터 다루기
	- date 형태를 사용하며 연/월/일/시/분/초 까지 저장
	- 날짜만 쓰거나 시간만 써야 되는 경우는 문자열로 하는 경우도 많음	
	- 날짜는 형식이 지정되어 있어 따로 설정할 것이 없음
*/

drop table emp;
create table emp(
emp_no number primary key,
emp_name varchar2(21) not null check(regexp_like(emp_name, '^[가-힣]{2,7}$')),
emp_salary number not null check(emp_salary >=0),
emp_join date default sysdate not null
);

-- 시간은 문자열 처럼도 넣을 수 있다(단, 국가별로 형식이 다름)
insert into emp(emp_no, emp_name, emp_salary, emp_join)
values(1,'김사장',100000000, '2001-01-01');

-- 문자열을 변환 명령을 써서 넣을 수 도 있다
insert into emp(emp_no, emp_name, emp_salary, emp_join)
values(2,'최상무',80000000, to_date('2001-02-01', 'yyyy-mm-dd'));

-- 현재 시간을 구해서 넣어야 할 때는 sysdate라는 항목을 사용
insert into emp(emp_no, emp_name, emp_salary, emp_join)
values(3,'박전무',75000000, sysdate);

insert into emp(emp_no, emp_name, emp_salary)
values(4,'이부장',50000000);

select * from emp;
