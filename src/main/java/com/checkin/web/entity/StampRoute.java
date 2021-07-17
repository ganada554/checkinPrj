package com.checkin.web.entity;

public class StampRoute {
	
	private Integer id;
	private String guName;
	private Integer order;
	private Integer bookstoreId;
	
	public StampRoute(Integer id, String guName, Integer order, Integer bookstoreId) {
		
		this.id = id;
		this.guName = guName;
		this.order = order;
		this.bookstoreId = bookstoreId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGuName() {
		return guName;
	}

	public void setGuName(String guName) {
		this.guName = guName;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getBookstoreId() {
		return bookstoreId;
	}

	public void setBookstoreId(Integer bookstoreId) {
		this.bookstoreId = bookstoreId;
	}

	@Override
	public String toString() {
		return "StampRoute [id=" + id + ", guName=" + guName + ", order=" + order + ", bookstoreId=" + bookstoreId
				+ "]";
	}
	
	

}
