package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.BookStore;

public interface HashtagBookstoreService {

	List<BookStore> getList(String query); //해시태그 또는 이름으로 서점 검색
	int insert(int hashtagId, int bookstoreId);
	int delete(Integer bookstoreId);
}
