package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.HashtagBookstore;

public interface BookStoreService {
	Integer[] getBookstoreIdArray();
	BookStore get(int id);
	BookStoreView getView(int id);
	BookStore getBookstore(String name);
	List<BookStore> getList();
	List<BookStore> getList(String query, String gu);
	
	List<BookStore> getGu(String gu);
	
//	int MasterReg(int id);
	int getCount();	
	int insert(BookStore bookStore, HashtagBookstore hashBookstore);
	int update(BookStore bookStore);
	int delete(int id);
	
	int inserthash(HashtagBookstore hashBookstore);
}
