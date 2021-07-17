package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.ReviewLikeDao;
import com.checkin.web.entity.ReviewLike;
import com.checkin.web.entity.ReviewLikeView;

@Repository
public class MyBatisReviewLikeDao implements ReviewLikeDao {
	
	private SqlSession sqlSession; 
	private ReviewLikeDao mapper;
	
	@Autowired
	public MyBatisReviewLikeDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(ReviewLikeDao.class);
	}
	
	@Override
	public Integer getLike(Integer reviewId, Integer memberId) {
		// TODO Auto-generated method stub
		return mapper.getLike(reviewId, memberId);
	}

	@Override
	public List<Integer> getMemberLike(Integer memberId) {
		// TODO Auto-generated method stub
		return mapper.getMemberLike(memberId);
	}
	
	@Override
	public Integer insert(ReviewLike reviewLike) {
		// TODO Auto-generated method stub
		return mapper.insert(reviewLike);
	}

	@Override
	public Integer delete(Integer reviewId, Integer memberId) {
		// TODO Auto-generated method stub
		return mapper.delete(reviewId, memberId);
	}

}
