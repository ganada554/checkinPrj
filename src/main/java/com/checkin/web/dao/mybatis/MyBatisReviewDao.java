package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.checkin.web.dao.ReviewDao;
import com.checkin.web.entity.HashtagReview;
import com.checkin.web.entity.MyReviewView;
import com.checkin.web.entity.RatingReview;
import com.checkin.web.entity.Review;
import com.checkin.web.entity.ReviewView;
import com.checkin.web.entity.ReviewView2;

@Repository
public class MyBatisReviewDao implements ReviewDao {
	
	private SqlSession sqlSession; 
	private ReviewDao mapper;
	
	@Autowired
	public MyBatisReviewDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(ReviewDao.class);
	}

	@Override
	public List<ReviewView2> getViewList() {
		return getViewList(null);
	}

	@Override
	public List<ReviewView2> getViewList(String gu) {
		return mapper.getViewList(gu);
	}
	
	@Override
	public List<ReviewView2> getBookStoreList(Integer bookstoreId) {

		return mapper.getBookStoreList(bookstoreId);
	}
	
	@Override
	public List<MyReviewView> getMyReviewList(String gu, int memberId) {

		return mapper.getMyReviewList(gu, memberId);
	}
	
	@Override
	public ReviewView2 get(int id) {
		return mapper.get(id);
	}
	
	@Override
	public int insert(Review review) {
		
		return mapper.insert(review);
	}
	
	@Override
	public int insertHashtag(HashtagReview hreview) {

		return mapper.insertHashtag(hreview);
	}

	@Override
	public int insertRating(RatingReview rreview) {

		return mapper.insertRating(rreview);
	}

	@Override
	public int update(
			@Param("review") Review review, 
			@Param("hreview") HashtagReview hreview, 
			@Param("rreview") RatingReview rreview) {
		return mapper.update(review, hreview, rreview);
	}
	
	@Override
	public int delete(int id) {
		return mapper.delete(id);
	}

}
