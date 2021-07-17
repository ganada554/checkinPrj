package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagReview;

public interface HashtagReviewDao {
	HashtagReview get(int id);
//	List<Hashtag> getList();
//	List<Hashtag> getList(String field, String query);
//	
	//int getCount(String field, String query);	
	int insert(int hashtagId, int reviewId);
	int update(int hashtagId);
	int delete(int id);
}
