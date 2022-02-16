-- 게시판 테이블
-- 테이블 구조 `tbl_board`

CREATE TABLE tbl_board (
  idx number NOT NULL ,				--  고유번호, 자동증가
  pass varchar2(20) NOT NULL ,			--  비밀번호
  name varchar2(20) NOT NULL ,			--  작성자 이름
  email varchar2(50) ,					--  작성자 이메일
  subject varchar2(100) NOT NULL,		--  제목
  contents varchar2(2000) NOT NULL,		--  내용
  regdate date default sysdate,			--  작성일자
  readcnt number default 0,				--  조회수
  ip varchar2(20) null,					--  작성자 ip주소
  PRIMARY KEY  (idx)
);
create sequence tbl_board_seq_idx;
