package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.StampRoute;



public interface StampRouteDao {
	
	StampRoute get(int id);
	List<StampRoute> getList();
	List<StampRoute> getList(String query);
	
	

}
