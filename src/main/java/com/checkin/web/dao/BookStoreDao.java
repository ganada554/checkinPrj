package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.HashtagBookstore;

public interface BookStoreDao {
	
	Integer[] getBookstoreIdArray();
	BookStore get(int id);
	BookStoreView getView(int id);
	List<BookStoreView> getBookstoreByQuery(String query);
	BookStore getBookstore(String name);
	List<BookStore> getList();
	List<BookStore> getList(String query, String gu);
	List<BookStore> getNameList();
	public List<BookStore> getGu(String gu);
	
	int getCount();	
	int insert(BookStore bookStore);
	int inserthash(HashtagBookstore hashBookstore);
	int update(BookStore bookStore);
	int delete(int id);
	

}
