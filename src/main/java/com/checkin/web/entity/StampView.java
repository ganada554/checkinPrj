package com.checkin.web.entity;

public class StampView {
	Integer BookstoreId;
	private Integer memberId;
	private String regDate;
	
	public StampView() {}

	public StampView(Integer bookstoreId, Integer memberId, String regDate) {
		super();
		BookstoreId = bookstoreId;
		this.memberId = memberId;
		this.regDate = regDate;
	}

	public Integer getBookstoreId() {
		return BookstoreId;
	}

	public void setBookstoreId(Integer bookstoreId) {
		BookstoreId = bookstoreId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "StampView [BookstoreId=" + BookstoreId + ", memberId=" + memberId + ", regDate=" + regDate + "]";
	}
	
	
	
}

