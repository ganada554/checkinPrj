package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.HashtagBookstoreDao;
import com.checkin.web.entity.BookStore;

@Service
public class HashtagBookstoreServiceImp implements HashtagBookstoreService{
	@Autowired
	private HashtagBookstoreDao dao;
	
	@Override
	public List<BookStore> getList(String query) {
		// TODO Auto-generated method stub
		return dao.getList(query);
	}

	@Override
	public int insert(int hashtagId, int bookstoreId) {
		// TODO Auto-generated method stub
		return dao.insert(hashtagId, bookstoreId);
	}

	@Override
	public int delete(Integer bookstoreId) {
		// TODO Auto-generated method stub
		return dao.delete(bookstoreId);
	}

}
