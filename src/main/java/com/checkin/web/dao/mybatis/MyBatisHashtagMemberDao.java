package com.checkin.web.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.HashtagMemberDao;

@Repository
public class MyBatisHashtagMemberDao implements HashtagMemberDao{
	private SqlSession sqlSession;
	private HashtagMemberDao mapper;
	
	@Autowired
	public MyBatisHashtagMemberDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(HashtagMemberDao.class);
	}
	
	
	@Override
	public Integer hashCheck(Integer hashtagId, Integer memberId) {
		
		return mapper.hashCheck(hashtagId, memberId);
	}

	@Override
	public Integer getCount(Integer memberId) {
		
		return mapper.getCount(memberId);
	}

	@Override
	public Integer[] getList(Integer memberId) {
		
		return mapper.getList(memberId);
	}

	@Override
	public Integer insert(Integer hasgtagId, Integer memberId) {
		
		return mapper.insert(hasgtagId, memberId);
	}

	@Override
	public Integer delete(Integer hashtagId, Integer memberId) {
		
		return mapper.delete(hashtagId, memberId);
	}


	@Override
	public List<Map<String, Integer>> mylovehashtag(Integer memberId) {
		
		return mapper.mylovehashtag(memberId);
	}

}
