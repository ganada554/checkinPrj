package com.checkin.web.dao;

import java.util.Date;
import java.util.List;

import com.checkin.web.entity.StampList;

public interface StampViewDao {
	Date get(Integer bookstoreId, Integer memberId);
	Integer getStampCount(Integer memberId);
	Integer getStampAdminCount(Integer bookstoreId);
	Integer insert(Integer memberId, Integer bookestoreId);
	List<StampList> getStampList();
}
