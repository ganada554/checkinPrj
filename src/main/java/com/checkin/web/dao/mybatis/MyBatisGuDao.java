package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.GuDao;
import com.checkin.web.entity.Gu;

@Repository
public class MyBatisGuDao implements GuDao {

	private SqlSession sqlSession;
	private GuDao mapper;
	
	@Autowired
	public MyBatisGuDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(GuDao.class);
	}
	
	@Override
	public List<Gu> getList() {
		return mapper.getList();
	}

	@Override
	public String getGuById(Integer id) {
		return mapper.getGuById(id);
	}

}
