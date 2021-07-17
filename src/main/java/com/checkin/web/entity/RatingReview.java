package com.checkin.web.entity;

import java.beans.Transient;

public class RatingReview {
	
	private Integer ratingId;
	private String rating;
	private Integer reviewId;
	
	public RatingReview() {
		
	}

	public Integer getRatingId() {
		return ratingId;
	}

	public void setRatingId(Integer ratingId) {
		this.ratingId = ratingId;
	}
	
	@Transient
	public void setRating(String rating) {
		this.rating = rating;
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	@Override
	public String toString() {
		return "RatingReview [ratingId=" + ratingId + ", reviewId=" + reviewId + "]";
	}

}
