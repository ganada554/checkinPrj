package com.checkin.web.entity;

public class MyStore {
	private Integer memberId;
	private Integer bookstoreId;
	
	public MyStore(){}

	public MyStore(int memberId, int bookstoreId) {
		super();
		this.memberId = memberId;
		this.bookstoreId = bookstoreId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getBookstoreId() {
		return bookstoreId;
	}

	public void setBookstoreId(int bookstoreId) {
		this.bookstoreId = bookstoreId;
	}

	@Override
	public String toString() {
		return "BookmarkStore [memberId=" + memberId + ", bookstoreId=" + bookstoreId + "]";
	}
	
	
	
}
