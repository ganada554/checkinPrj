package com.checkin.web.entity;

public class HashtagBookstore {

	private Integer hashtagId;
	private Integer bookstoreId;
	
	public HashtagBookstore() {
		// TODO Auto-generated constructor stub
	}

	public Integer getHashtagId() {
		return hashtagId;
	}

	public HashtagBookstore(Integer hashtagId, Integer bookstoreId) {
		super();
		this.hashtagId = hashtagId;
		this.bookstoreId = bookstoreId;
	}

	public void setHashtagId(Integer hashtagId) {
		this.hashtagId = hashtagId;
	}

	public Integer getBookstoreId() {
		return bookstoreId;
	}

	public void setBookstoreId(Integer bookstoreId) {
		this.bookstoreId = bookstoreId;
	}

	@Override
	public String toString() {
		return "HashtagBookstore [hashtagId=" + hashtagId + ", bookstoreId=" + bookstoreId + "]";
	}
	
	
}
