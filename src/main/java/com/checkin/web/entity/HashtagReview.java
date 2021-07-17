package com.checkin.web.entity;

import java.beans.Transient;

public class HashtagReview {

	private Integer hashtagId;
	private String hashtag;
	private Integer reviewId;
	
	public Integer getHashtagId() {
		return hashtagId;
	}
	
	public void setHashtagId(Integer hashtagId) {
		this.hashtagId = hashtagId;
	}
	
	@Transient
	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}
	
	public Integer getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public String toString() {
		return "HashtagReview [hashtagId=" + hashtagId + ", reviewId=" + reviewId + "]";
	}
	
}
