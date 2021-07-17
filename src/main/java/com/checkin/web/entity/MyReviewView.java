package com.checkin.web.entity;

import java.beans.Transient;
import java.util.Date;

public class MyReviewView {
	
	private Integer id;
	private String content;
	private String img;
	private Date regDate;
	private Integer bookstoreId;
	private String profileImg;
	private Integer memberId;
	private String nickName;
	private String bookstoreName;
	private String bookstoreGu;
	private int hashtagId;
	private String hashtagName;
	private int ratingId;
	private String ratingName;
	
	public MyReviewView() {

	}

	public MyReviewView(Integer id, String content, String img, Date regDate, Integer bookstoreId, String profileImg,
			Integer memberId, String nickName, String bookstoreName, String bookstoreGu, int hashtagId,
			String hashtagName, int ratingId, String ratingName) {
		super();
		this.id = id;
		this.content = content;
		this.img = img;
		this.regDate = regDate;
		this.bookstoreId = bookstoreId;
		this.profileImg = profileImg;
		this.memberId = memberId;
		this.nickName = nickName;
		this.bookstoreName = bookstoreName;
		this.bookstoreGu = bookstoreGu;
		this.hashtagId = hashtagId;
		this.hashtagName = hashtagName;
		this.ratingId = ratingId;
		this.ratingName = ratingName;
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

	@Transient
	public String getImagePath() {
		if(img == null)
			return null;
		
		return "/upload/review/" + img;
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

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public int getHashtagId() {
		return hashtagId;
	}

	public void setHashtagId(int hashtagId) {
		this.hashtagId = hashtagId;
	}

	public String getHashtagName() {
		return hashtagName;
	}

	public void setHashtagName(String hashtagName) {
		this.hashtagName = hashtagName;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public String getRatingName() {
		return ratingName;
	}

	public void setRatingName(String ratingName) {
		this.ratingName = ratingName;
	}

	@Override
	public String toString() {
		return "MyReviewView [id=" + id + ", content=" + content + ", img=" + img + ", regDate=" + regDate
				+ ", bookstoreId=" + bookstoreId + ", profileImg=" + profileImg + ", memberId=" + memberId
				+ ", nickName=" + nickName + ", bookstoreName=" + bookstoreName + ", bookstoreGu=" + bookstoreGu
				+ ", hashtagId=" + hashtagId + ", hashtagName=" + hashtagName + ", ratingId=" + ratingId
				+ ", ratingName=" + ratingName + "]";
	}

}
