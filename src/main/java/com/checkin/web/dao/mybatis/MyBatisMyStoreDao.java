package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.MyStoreDao;
import com.checkin.web.entity.MyStore;

@Repository
public class MyBatisMyStoreDao implements MyStoreDao{
	private SqlSession sqlSession;
	private MyStoreDao mapper;
	
	@Autowired
	public MyBatisMyStoreDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(MyStoreDao.class);
	}
	
	@Override
	public Integer[] getList(Integer id) {
		
		return mapper.getList(id);
	}

	@Override
	public Integer getStoreCount(Integer storeId) {
		
		return mapper.getStoreCount(storeId);
	}
	
	@Override
	public Integer getMyCount(Integer MemberId) {
		
		return mapper.getMyCount(MemberId);
	}

	@Override
	public Integer getBookmark(Integer bookstoreId, Integer memberId) {

		return mapper.getBookmark(bookstoreId, memberId);
	}

	@Override
	public Integer insert(MyStore myStore) {
		
		return mapper.insert(myStore);
	}

	@Override
	public Integer delete(Integer bookstoreId, Integer memberId) {
		
		return mapper.delete(bookstoreId, memberId);
	}

}
