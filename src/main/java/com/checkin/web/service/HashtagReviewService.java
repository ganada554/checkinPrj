package com.checkin.web.service;

import com.checkin.web.entity.HashtagReview;

public interface HashtagReviewService {

	HashtagReview get(int id);
	int insert(int hashtagId, int reviewId);
	int update(int hashtagId);
	int delete(int id);
}
