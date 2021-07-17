package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.Hashtag;

public interface HashtagService {
	Hashtag get(int id);
	Hashtag getIdByName(String name);
	List<Hashtag> getList(); //id매개변수로 받는거 매퍼에서 하나 만들기
	List<Hashtag> getList(String query);
	List<Hashtag> getListById(int id);
	Integer[] getIdArray();
	String getHashName(int id);
	
	int getCount();	//해시태그 총 개수
	int insert(String hashtag); //해시태그 추가
	int delete(int id); //해시태그 삭제
}
