package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.dao.HashtagBookstoreDao;
import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.HashtagBookstore;

@Repository
public class MybatisHashtagBookstoreDao implements HashtagBookstoreDao {

	
	private SqlSession sqlSesstion;
	private HashtagBookstoreDao mapper;
	
	
	@Autowired
	public MybatisHashtagBookstoreDao(SqlSession sqlSession) {
		this.sqlSesstion = sqlSession;
		mapper = sqlSession.getMapper(HashtagBookstoreDao.class);
	}
	

	@Override
	public int insert(int hashtagId, int bookstoreId) {
		// TODO Auto-generated method stub
		return mapper.insert(hashtagId, bookstoreId);
	}

	@Override
	public int delete(Integer bookstoreId) {
		// TODO Auto-generated method stub
		return mapper.delete(bookstoreId);
	}


	@Override
	public List<BookStore> getList(String query) {
	
		return mapper.getList(query);
	}


	@Override
	public List<BookStoreView> getListByView(String query) {
		// TODO Auto-generated method stub
		return mapper.getListByView(query);
	}




}
