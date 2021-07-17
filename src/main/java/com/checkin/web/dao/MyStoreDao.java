package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.MyStore;


public interface MyStoreDao {
	Integer[] getList(Integer id);
	
	Integer getStoreCount(Integer storeId);
	Integer getMyCount(Integer memberId);	
	Integer getBookmark(Integer bookstoreId, Integer memberId);
	
	Integer insert(MyStore myStore);
	Integer delete(Integer bookstoreId, Integer memberId);
}