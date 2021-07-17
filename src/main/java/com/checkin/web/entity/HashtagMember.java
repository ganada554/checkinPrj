package com.checkin.web.entity;

public class HashtagMember {
	
	private Integer hashtagId;
	private Integer memberId;
	
	public HashtagMember() {
		// TODO Auto-generated constructor stub
	}

	public Integer getHashtagId() {
		return hashtagId;
	}

	public void setHashtagId(Integer hastagId) {
		this.hashtagId = hastagId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "HashtagMember [hashtagId=" + hashtagId + ", memberId=" + memberId + "]";
	}
	
	

}
