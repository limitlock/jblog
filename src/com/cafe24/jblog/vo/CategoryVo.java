package com.cafe24.jblog.vo;

public class CategoryVo {
	private Long no;
	private String name;
	private String content;
	private Long amount;
	private boolean isDelete = false;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "CategotyVo [no]= " + no + ", [name]= " + name + ", [content]= " + content + ", [amount]= " + amount + ", [isDelete]= "
				+ isDelete;
	}

}
