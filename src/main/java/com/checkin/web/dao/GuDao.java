package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.Gu;

public interface GuDao {
	
	List<Gu> getList();
	String getGuById(Integer id);
}
