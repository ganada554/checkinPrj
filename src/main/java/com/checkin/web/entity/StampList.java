package com.checkin.web.entity;

import java.util.Date;

public class StampList {
	private String nickname;
	private Date regDate;
	private String newRegDate;
	private String name;
	private String guName;
	
	public StampList() {}

	public StampList(String nickname, Date regDate, String newRegDate, String name, String guName) {
		super();
		this.nickname = nickname;
		this.regDate = regDate;
		this.newRegDate = newRegDate;
		this.name = name;
		this.guName = guName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getNewRegDate() {
		return newRegDate;
	}

	public void setNewRegDate(String newRegDate) {
		this.newRegDate = newRegDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGuName() {
		return guName;
	}

	public void setGuName(String guName) {
		this.guName = guName;
	}

	@Override
	public String toString() {
		return "StampList [nickname=" + nickname + ", regDate=" + regDate + ", newRegDate=" + newRegDate + ", name="
				+ name + ", guName=" + guName + "]";
	}

	

	
}
