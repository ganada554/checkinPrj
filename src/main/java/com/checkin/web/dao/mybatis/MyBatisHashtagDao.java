package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.HashtagDao;
import com.checkin.web.entity.Hashtag;

@Repository
public class MyBatisHashtagDao implements HashtagDao{

	private SqlSession sqlSession;
	private HashtagDao mapper;

	@Autowired
	public MyBatisHashtagDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(HashtagDao.class);
	}
	
	@Override
	public Hashtag get(int id) {
		// TODO Auto-generated method stub
		return mapper.get(id);
	}

	@Override
	public List<Hashtag> getList() {
		// TODO Auto-generated method stub
		return getList(null);
	}

	@Override
	public List<Hashtag> getList(String query) {
		// TODO Auto-generated method stub
		return mapper.getList(query);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mapper.getCount();
	}
	
	@Override
	public Hashtag getIdByName(String name) {
		return mapper.getIdByName(name);
	}

	@Override
	public int insert(String hashtag) {

		return mapper.insert(hashtag);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return mapper.delete(id);
	}

	@Override
	public List<Hashtag> getListById(int id) {
		return mapper.getListById(id);
	}

	@Override
	public Integer[] getIdArray() {
		// TODO Auto-generated method stub
		return mapper.getIdArray();
	}

	@Override
	public String getHashName(int id) {
		// TODO Auto-generated method stub
		return mapper.getHashName(id);
	}


}
