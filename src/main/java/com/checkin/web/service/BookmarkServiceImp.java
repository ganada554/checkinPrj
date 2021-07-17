package com.checkin.web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.MyStoreDao;
import com.checkin.web.dao.StampViewDao;
import com.checkin.web.entity.MyStore;
import com.checkin.web.entity.StampList;

@Service
public class BookmarkServiceImp implements BookmarkService{
	private MyStoreDao dao;
	private StampViewDao viewDao;
	
	@Autowired
	public BookmarkServiceImp(MyStoreDao dao, StampViewDao viewDao) {
		this.dao = dao;
		this.viewDao = viewDao;
	}

	/*--store--*/
	@Override
	public Integer[] getStoreList(Integer id) {
		
		return dao.getList(id);
	}
	@Override
	public Integer getMyCount(Integer memberId) {
		
		return dao.getMyCount(memberId);
	}
	@Override
	public Integer getStoreCount(Integer storeId) {
		
		return dao.getStoreCount(storeId);
	}

	@Override
	public Integer getBookmark(Integer bookstoreId, Integer memberId) {

		return dao.getBookmark(bookstoreId, memberId);
	}
	
	@Override
	public Integer addStore(MyStore myStore) {
		
		return dao.insert(myStore);
	}
	@Override
	public Integer delStore(Integer bookstoreId, Integer memberId) {
		
		return dao.delete(bookstoreId, memberId);
	}
	
	
	
	/*--stamp--*/
	
	@Override
	public String get(Integer bookstoreId, Integer memberId) {
		Date date = viewDao.get(bookstoreId, memberId);
		String format = null;
		if(date !=null) {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			format = formatter.format(date);
		}
		
		return format;
	}


	@Override
	public Integer getStampCount(Integer memberId) {
		
		return viewDao.getStampCount(memberId);
	}

	@Override
	public Integer getStampAdminCount(Integer bookstoreId) {

		return viewDao.getStampAdminCount(bookstoreId);
	}

	@Override
	public Integer insert(Integer bookestoreId, Integer memberId) {

		return viewDao.insert(bookestoreId, memberId);
	}

	@Override
	public List<StampList> getStampList(){
		List<StampList> list = viewDao.getStampList();
		String format = null;
		for(StampList i : list) {
			Date regDate = i.getRegDate();
	
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			format = formatter.format(regDate);
			i.setNewRegDate(format);
		}	
		
		return list;
	}

}
