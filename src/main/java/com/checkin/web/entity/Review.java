package com.checkin.web.entity;

import java.beans.Transient;
import java.util.Date;

public class Review {
	
	private Integer id;
	private String content;
	private String img;
	private Date regDate;
	private Integer bookstoreId;
	private String bookstore;
	private Integer memberId;
	
	public Review() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public Integer getBookstoreId() {
		return bookstoreId;
	}

	public void setBookstoreId(Integer bookstoreId) {
		this.bookstoreId = bookstoreId;
	}
	
	@Transient
	public String getBookstore() {
		return bookstore;
	}

	@Transient
	public void setBookstore(String bookstore) {
		this.bookstore = bookstore;
	}
	
	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}


	@Override
	public String toString() {
		return "Review [id=" + id + ", content=" + content + ", img=" + img + ", regDate=" + regDate + ", bookstoreId="
				+ bookstoreId + ", memberId=" + memberId + "]";
	}

}
