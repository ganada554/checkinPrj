package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 
import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.HashtagBookstore;

@Repository
public class MyBatisBookStoreDao implements BookStoreDao {
	
	private SqlSession sqlSession;
	private BookStoreDao mapper;
	
	
	@Autowired
	 public MyBatisBookStoreDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(BookStoreDao.class);
	}
	

	@Override
	public BookStore get(int id) {
		 
		return mapper.get(id);
	}
	
	@Override
	public BookStoreView getView(int id) {
		 
		return mapper.getView(id);
	}
	
	@Override
	public BookStore getBookstore(String name) {

		return mapper.getBookstore(name);
	}
	
	//기본페이지를 불러옴
	@Override
	public List<BookStore> getList() {
		 
		return getList(null, null);
		 
	}
	@Override
	public List<BookStore> getGu(String gu) {
		 
		return mapper.getGu(gu);
		 
	}

	@Override
	public List<BookStore> getList(String query, String gu) {
		 
		return mapper.getList(query, gu);
	}
	
	@Override
	public List<BookStore> getNameList() {

		return mapper.getNameList();
	}

	@Override
	public int getCount() {
		 
		return mapper.getCount();
	}

//	@Override
//	public int insert(@Param("bookStore") BookStore bookStore,
//					  @Param("hashBookstore") HashtagBookstore hashBookstore) {
//		 
//		return mapper.insert(bookStore, hashBookstore);
//	}

	@Override
	public int update(BookStore bookStore) {
		 
		return mapper.update(bookStore);
	}

	@Override
	public int delete(int id) {
		 
		return mapper.delete(id);
	}

	@Override
	public int insert(BookStore bookStore) {
		
		return mapper.insert(bookStore);
	}

	@Override
	public int inserthash(HashtagBookstore hashBookstore) {
		
		return mapper.inserthash(hashBookstore);
	}


	@Override
	public Integer[] getBookstoreIdArray() {
	
		return mapper.getBookstoreIdArray();
	}


	@Override
	public List<BookStoreView> getBookstoreByQuery(String query) {
		return mapper.getBookstoreByQuery(query);
	}

}
