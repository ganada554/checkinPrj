package com.checkin.web.entity;

import java.beans.Transient;
import java.util.Date;

public class ReviewView {
	
	private Integer id;
	private String content;
	private String img;
	private Date regDate;
	private Integer bookstoreId;
	private String profileImg;
	private String nickName;
	private String bookstoreName;
	private String bookstoreGu;
	private String hashtagName;
	
	public ReviewView() {
		
	}

	public ReviewView(Integer id, String content, String img, Date regDate, Integer bookstoreId, String profileImg,
			String nickName, String bookstoreName, String bookstoreGu, String hashtagName) {
		this.id = id;
		this.content = content;
		this.img = img;
		this.regDate = regDate;
		this.bookstoreId = bookstoreId;
		this.profileImg = profileImg;
		this.nickName = nickName;
		this.bookstoreName = bookstoreName;
		this.bookstoreGu = bookstoreGu;
		this.hashtagName = hashtagName;
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

//	@Transient
//	public String getImagePath() {
//		if(img == null)
//			return null;
//		
//		return "/upload/review/" + img;
//	}
	
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

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getBookstoreName() {
		return bookstoreName;
	}

	public void setBookstoreName(String bookstoreName) {
		this.bookstoreName = bookstoreName;
	}

	public String getBookstoreGu() {
		return bookstoreGu;
	}

	public void setBookstoreGu(String bookstoreGu) {
		this.bookstoreGu = bookstoreGu;
	}

	public String getHashtagName() {
		return hashtagName;
	}

	public void setHashtagName(String hashtagName) {
		this.hashtagName = hashtagName;
	}

	@Override
	public String toString() {
		return "ReviewView [id=" + id + ", content=" + content + ", img=" + img + ", regDate=" + regDate
				+ ", bookstoreId=" + bookstoreId + ", profileImg=" + profileImg + ", nickName=" + nickName
				+ ", bookstoreName=" + bookstoreName + ", bookstoreGu=" + bookstoreGu + ", hashtagName=" + hashtagName
				+ "]";
	}
	
}
