package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.checkin.web.dao.BookStoreDao;
import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.HashtagBookstore;

@Service
public class BookStoreServiceImp implements BookStoreService {
   
   @Autowired
   private BookStoreDao dao;
   
   @Override
   public BookStore get(int id) {
       
      return dao.get(id);
   }
   
   @Override
   public BookStoreView getView(int id) {
       
      return dao.getView(id);
   }
   
   
   @Override
   public BookStore getBookstore(String name) {

      return dao.getBookstore(name);
   }

   @Override
   public List<BookStore> getList() {
       
      return dao.getList();
   }

   @Override
   public List<BookStore> getList(String query, String gu) {
       
      return dao.getList(query, gu);
   }

   @Override
   public int getCount() {
       
      return dao.getCount();
   }
   @Transactional
	@Override
	public int insert(BookStore bookStore, HashtagBookstore hashBookstore) {
		dao.insert(bookStore);
		System.out.println(bookStore);
		Integer id = bookStore.getId();
		System.out.println(id);
		
		hashBookstore.setBookstoreId(id);
		dao.inserthash(hashBookstore);
		return 0;
	}

   @Override
   public int update(BookStore bookStore) {
       
      return dao.update(bookStore);
   }

   @Override
   public int delete(int id) {
       
      return dao.delete(id);
   }

   @Override
   public List<BookStore> getGu(String gu) {
      
      return dao.getGu(gu);
   }

@Override
public Integer[] getBookstoreIdArray() {

	return dao.getBookstoreIdArray();
}

@Override
public int inserthash(HashtagBookstore hashBookstore) {
	return dao.inserthash(hashBookstore);
}
}
