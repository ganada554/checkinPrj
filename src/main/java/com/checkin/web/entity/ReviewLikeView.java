package com.checkin.web.entity;

import java.util.Date;

public class ReviewLikeView {

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
	private Integer likeMember;
	
	public ReviewLikeView() {
		// TODO Auto-generated constructor stub
	}

	public ReviewLikeView(Integer id, String content, String img, Date regDate, Integer bookstoreId, String profileImg,
			Integer memberId, String nickName, String bookstoreName, String bookstoreGu, int hashtagId,
			String hashtagName, int ratingId, String ratingName, Integer likeMember) {
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
		this.likeMember = likeMember;
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

	public Integer getLikeMember() {
		return likeMember;
	}

	public void setLikeMember(Integer likeMember) {
		this.likeMember = likeMember;
	}

	@Override
	public String toString() {
		return "ReviewLikeView [id=" + id + ", content=" + content + ", img=" + img + ", regDate=" + regDate
				+ ", bookstoreId=" + bookstoreId + ", profileImg=" + profileImg + ", memberId=" + memberId
				+ ", nickName=" + nickName + ", bookstoreName=" + bookstoreName + ", bookstoreGu=" + bookstoreGu
				+ ", hashtagId=" + hashtagId + ", hashtagName=" + hashtagName + ", ratingId=" + ratingId
				+ ", ratingName=" + ratingName + ", likeMember=" + likeMember + "]";
	}
	
	
	
}
