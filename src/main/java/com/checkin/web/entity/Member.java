package com.checkin.web.entity;

import java.util.Date;

public class Member {
	private Integer id;
	private String nickname;
	private String password;
	private String email;
	private String profileImg;
	private Integer positionId;
	private Date regDate;
	
	public Member() {}

	public Member(Integer id, String nickname, String password, String email, String profileImg, Integer positionId,
			Date regDate) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.password = password;
		this.email = email;
		this.profileImg = profileImg;
		this.positionId = positionId;
		this.regDate = regDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileImg() {
		
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", nickname=" + nickname + ", password=" + password + ", email=" + email
				+ ", profileImg=" + profileImg + ", positionId=" + positionId + ", regDate=" + regDate + "]";
	}
	
	
}
