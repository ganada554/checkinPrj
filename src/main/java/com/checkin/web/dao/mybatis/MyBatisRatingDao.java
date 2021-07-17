package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.RatingDao;
import com.checkin.web.entity.Rating;

@Repository
public class MyBatisRatingDao implements RatingDao {
	
	private SqlSession sqlSession; 
	private RatingDao mapper;
	
	@Autowired
	public MyBatisRatingDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(RatingDao.class);
	}

	@Override
	public List<Rating> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

}
