package com.cafe24.jblog.vo;

public class PostVo {

	private Long no;
	private String title;
	private String content;
	private Long blogNo;
	private String blogTitle;
	private Long categoryNo;
	private String categoryName;
	private String curDate;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getBlogNo() {
		return blogNo;
	}

	public void setBlogNo(Long blogNo) {
		this.blogNo = blogNo;
	}

	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCurDate() {
		return curDate;
	}

	public void setCurDate(String curDate) {
		this.curDate = curDate;
	}

	@Override
	public String toString() {
		return "PostVo [no]= " + no + ", [postTitle]= " + title + ", [content]= " + content + ", [blogTitle]= "
				+ blogTitle + ", [categoryName]= " + categoryName + ", [curDate]= " + curDate;
	}

}
