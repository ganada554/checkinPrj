package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.GuDao;
import com.checkin.web.entity.Gu;

@Service
public class GuServiceImp implements GuService {

	@Autowired
	private GuDao dao;
	
	@Override
	public List<Gu> getList() {
		List<Gu> list = dao.getList();
		return list;
	}

	@Override
	public String getGuById(Integer id) {
		return dao.getGuById(id);
	}
 
}
