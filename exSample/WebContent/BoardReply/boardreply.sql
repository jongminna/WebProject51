-- 답변형 게시판 테이블
-- 테이블 구조 `tbl_boardreply`

CREATE TABLE tbl_boardreply(
  idx number NOT NULL ,				--  고유번호
  pass varchar2(20) NOT NULL ,			--  비밀번호
  name varchar2(20) NOT NULL ,			--  작성자 이름
  email varchar2(50),				--  작성자 이메일
  regdate date default sysdate,			--  작성일자
  subject varchar2(100) NOT NULL,		--  제목
  contents varchar2(2000) NOT NULL,		--  내용
  parent number(2) not null,			--  최상위 부모글번호
  realparent number(2) not null,		--  바로 한수준 위의 글번호
  indent number(2) not null,			--  들여쓰기 기준
  depth number(2) not null,			--  답변글의 넘버를 저장하는 필드로 
						--  첫번째 답변글은 1, 두 번째 답변글은 2,
						--  n번째 답변글은 n의 값이 저장
  readcnt number default 0 ,			--  조회수
  ip varchar2(20) not null,			--  작성자 ip주소
  PRIMARY KEY  (idx)
);
create sequence tbl_boardreply_seq_idx;
