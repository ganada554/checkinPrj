package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.ReviewLike;
import com.checkin.web.entity.ReviewLikeView;

public interface ReviewLikeDao {

	List<Integer> getMemberLike(Integer memberId);
	Integer getLike(Integer reviewId, Integer memberId);
	Integer insert(ReviewLike reviewLike);
	Integer delete(Integer reviewId, Integer memberId);
}
