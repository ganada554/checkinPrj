package com.checkin.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.checkin.web.entity.HashtagReview;
import com.checkin.web.entity.MyReviewView;
import com.checkin.web.entity.RatingReview;
import com.checkin.web.entity.Review;
import com.checkin.web.entity.ReviewView;
import com.checkin.web.entity.ReviewView2;

public interface ReviewDao {
	List<ReviewView2> getViewList();
	List<ReviewView2> getViewList(String gu); 
	List<ReviewView2> getBookStoreList(Integer bookstoreId);
	List<MyReviewView> getMyReviewList(String gu, int memberId);
	ReviewView2 get(int id);

	int insert(Review review);
	int insertHashtag(HashtagReview hreview);
	int insertRating(RatingReview rreview);
	
	int update(
			@Param("review") Review review, 
			@Param("hreview") HashtagReview hreview, 
			@Param("rreview") RatingReview rreview);
	int delete(int id);
}
