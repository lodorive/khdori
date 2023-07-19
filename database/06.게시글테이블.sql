/*게시판 테이블(table board)
--게시글 번호(board_no)
	-필수 항목이며 중복이 불가한 숫자
--게시글 제목(board_title)
	-한글 100자 이내로 설정 가능하며 필수 항목
--게시글 내용(board_content)
	-가능한 최대의 문자열 크기로 설정하여 필수 항목
--게시글 작성자(board_writer)
	-게시글 작성한 사람의 아이디(영문 숫자 8~20)
	-작성자가 탈퇴한 경우 null로 설정됨
--게시글 조회수(board_readcount)
	-0이상의 숫자로 설정되는 항목
*/

drop table board;

create table board(
board_no number not null check(board_no >0),
board_title varchar2(300) not null,
board_content varchar2(4000) not null,
board_writer varchar2(20) check(regexp_like(board_writer, '^[A-Za-z0-9]{8,20}$')),
board_readcount number not null check(board_readcount >= 0),
unique(board_no)
);

insert into board(board_no, board_title, board_content, board_writer, board_readcount)
values(2,'테스트제목','테스트내용','testuser1',5);

select * from board;

-- (TIP) 항목 한개만 중복이 안된다면 항목에 작성 가능
create table board(
board_no number not null unique check(board_no >0),
board_title varchar2(300) not null,
board_content varchar2(4000) not null,
board_writer varchar2(20) check(regexp_like(board_writer, '^[A-Za-z0-9]{8,20}$')),
board_readcount number default 0 not null check(board_readcount >= 0)
);

-- 등록 시 항목을 제외시키면 null이 들어간다
-- null이 아니라 다른 값을 초기값으로 넣고 싶다면 default 키워드사용
insert into board(board_no, board_title, board_content, board_writer)
values(2,'테스트제목','테스트내용','testuser1');

-- 번호의 경우 목적이 '식별'을 위한 값
-- [1] 번호가 변경될 수 있으면 NOT NULL UNIQUE로 본다
-- [2] 번호가 영원히 변경될 수 없다면 PRIMARY KEY로 본다 

/*
 	결론적으로 사용하는 조건은 앞으로 5가지
 	- not null - null 금지 조건
 	- unique - 중복 금지 조건(null 가능)
 	- primary key - not null + unique + 불변 (테이블 대표항목)
	- check - 데이터 형식 검사 조건
	- default - 미 지정시 자동 설정될 값 조건
 */
