package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.Gu;


public interface GuService {
	
	List<Gu> getList();
	String getGuById(Integer id);
	
	
	
}
