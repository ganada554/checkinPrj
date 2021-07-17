package com.checkin.web.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.StampRouteDao;

import com.checkin.web.entity.StampRoute;

@Service
public class StampRouteServiceImp implements StampRouteService  {
	
	@Autowired
	private StampRouteDao dao;

	@Override
	public StampRoute get(int id) {
		 
		return dao.get(id);
	}

	@Override
	public List<StampRoute> getList() {
		 
		return dao.getList();
	}

	@Override
	public List<StampRoute> getList(String query) {
		 
		return dao.getList(query);
	}




}
