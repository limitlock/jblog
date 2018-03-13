package com.cafe24.jblog.vo;

public class CommentVo {
	private Long postNo;
	private String id;
	private String content;
	private String curDate;

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCurDate() {
		return curDate;
	}

	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}

	@Override
	public String toString() {
		return "CommentVo [postNo]= " + postNo + ", [id]= " + id + ", [content]= " + content + ", [curDate]= "
				+ curDate;
	}

}
