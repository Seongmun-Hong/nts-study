package kr.or.connect.guestbook.dto;

import java.time.LocalDateTime;

public class Guestbook {
	private long id;
	private String name;
	private String content;
	private LocalDateTime regdate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "GuestBook [id=" + id + ", name=" + name + ", content=" + content + ", regdate=" + regdate + "]";
	}
}
