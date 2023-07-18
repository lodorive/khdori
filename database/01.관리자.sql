--사용자 생성
CREATE USER c##test IDENTIFIED BY test;

--사용자에게 기본 권한 부여
GRANT CONNECT, resource, unlimited TABLESPACE TO c##test;

--사용자 제거
DROP USER c##test;
