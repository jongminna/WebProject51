-- 게시판 테이블
-- 테이블 구조 `board`

CREATE TABLE tbl_boardcomment (
  idx number NOT NULL ,				--  고유번호, 자동증가
  pass varchar2(20) NOT NULL ,			--  비밀번호
  name varchar2(20) NOT NULL ,			--  작성자 이름
  email varchar2(50) ,				--  작성자 이메일
  regdate date default sysdate,			--  작성일자
  subject varchar2(100) NOT NULL,		--  제목
  contents varchar2(2000) NOT NULL,		--  내용
  readcnt number default 0,			--  조회수
  ip varchar2(20) null,				--  작성자 ip주소
  comments number(3) null,			--  댓글 수
  PRIMARY KEY  (idx)
);
create sequence tbl_boardcomment_seq_idx;

- 댓글 테이블 -
create table tbl_commentboard(
   idx number(5) primary key,			-- 고유번호, 자동증가
   parent number(5) not null,			-- 부모글번호
   name varchar2(50) not null,			-- 작성자
   pass varchar2(50) not null,			-- 비번
   comments varchar2(2000) not null,		-- 댓글
   regdate date default sysdate			-- 등록일자
);
create sequence tbl_commantboard_seq_idx;