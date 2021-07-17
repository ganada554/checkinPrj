package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;

public interface HashtagBookstoreDao {
	List<BookStore> getList(String query);
	int insert(int hashtagId, int bookstoreId);
	int delete(Integer bookstoreId);
	List<BookStoreView> getListByView(String query);
}
