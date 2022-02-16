package com.jslhrd.sample.model.boardreply;

public class BoardReplyVO {
	private int idx;		// 고유번호
	private String name;	//작성자
	private String email;	//이메일
	private String subject;	//제목
	private String contents;//내용
	private String pass;	//비번
	private int parent; 	//최상의 글번호
	private int realparent; //바로 한수준 위의 글번호
	private int depth; //글깊이
	private int indent; //들여쓰기
	private String regdate; //등록일자
	private int readcnt; //조회수
	private String ip; //글 등록자 ip
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getRealparent() {
		return realparent;
	}
	public void setRealparent(int realparent) {
		this.realparent = realparent;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getIndent() {
		return indent;
	}
	public void setIndent(int indent) {
		this.indent = indent;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
