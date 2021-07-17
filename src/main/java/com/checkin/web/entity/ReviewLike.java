package com.checkin.web.entity;

public class ReviewLike {
	
	private Integer memberId;
	private Integer reviewId;
	
	public ReviewLike() {
		
	}

	public ReviewLike(Integer memberId, Integer reviewId) {
		super();
		this.memberId = memberId;
		this.reviewId = reviewId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public String toString() {
		return "ReviewLike [memberId=" + memberId + ", reviewId=" + reviewId + "]";
	}

}
