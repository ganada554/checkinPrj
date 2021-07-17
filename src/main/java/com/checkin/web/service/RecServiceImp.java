package com.checkin.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.dao.HashtagBookstoreDao;
import com.checkin.web.dao.HashtagDao;
import com.checkin.web.dao.HashtagMemberDao;
import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagBookstore;

@Service
public class RecServiceImp implements RecService{

	private HashtagDao dao;
	private BookStoreDao bookstoredao;
	private HashtagBookstoreDao hashtagbookstoredao;
	private HashtagMemberDao hashtagMemberdao;
	
	
	@Autowired
	public RecServiceImp(HashtagDao dao, BookStoreDao bookstoredao,
			HashtagBookstoreDao hashtagbookstoredao, HashtagMemberDao hashtagMemberdao) {
		this.dao = dao;
		this.bookstoredao = bookstoredao;
		this.hashtagbookstoredao = hashtagbookstoredao;
		this.hashtagMemberdao = hashtagMemberdao;
	}
	
	@Override
	public List<Hashtag> getList() {
		List<Hashtag> list = getList(null);
		return list;
	}

	@Override
	public List<Hashtag> getList(String query) {
		return dao.getList(query);
	}

	

	@Override
	public List<Hashtag> getHashNamegByMemberId(int id) {
		Integer[] hIdList = hashtagMemberdao.getList(id);
		System.out.println(hIdList);
		
		List<Hashtag> hNameList =  new ArrayList();
		
		for(int i=0; i<hIdList.length; i++) {
			hNameList.add(dao.get(hIdList[i]));
		}
		System.out.println(hNameList);
		
		return hNameList;
	}

	@Override
	public List<BookStoreView> getListBooktStore(String query) {
		// TODO Auto-generated method stub
		return bookstoredao.getBookstoreByQuery(query);
	}

	@Override
	public List<BookStoreView> getListHashtagBookstore(String query) {
		// TODO Auto-generated method stub
		return hashtagbookstoredao.getListByView(query);
	}

	@Override
	public Integer[] getIdArray() {
		// TODO Auto-generated method stub
		return dao.getIdArray();
	}

	@Override
	public String getHashName(Integer integer) {
		// TODO Auto-generated method stub
		return null;
	}


}
