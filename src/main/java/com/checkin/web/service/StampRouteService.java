package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.StampRoute;

public interface StampRouteService {

	StampRoute get(int id);
	List<StampRoute> getList();
	List<StampRoute> getList(String query);
	
	
	

}
