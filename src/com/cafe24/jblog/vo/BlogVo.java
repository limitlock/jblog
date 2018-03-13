package com.cafe24.jblog.vo;

public class BlogVo {

	private Long no;
	private String title;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "BlogVo [no]= " + no + ", [title]= " + title;
	}

}
