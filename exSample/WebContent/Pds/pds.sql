CREATE TABLE tbl_pds (
  idx number NOT NULL ,				--  고유번호
  name varchar2(20) NOT NULL ,		--  작성자 이름
  pass varchar2(20) NOT NULL ,		--  비밀번호
  subject varchar2(100) NOT NULL,	--  제목
  contents varchar2(2000) NOT NULL,	--  내용
  regdate date default sysdate ,			--  작성일자
  readcnt number(2) default 0,				--  조회수
  filename varchar2(255) null,		--  파일이름
  PRIMARY KEY  (idx)
);
create sequence tbl_pds_seq_idx;
