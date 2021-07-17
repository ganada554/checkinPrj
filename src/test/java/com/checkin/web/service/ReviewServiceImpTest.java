package com.checkin.web.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.checkin.web.dao.ReviewDao;
import com.checkin.web.entity.ReviewView2;

class ReviewServiceImpTest {
	
	@Autowired
	ReviewDao dao;
	
	@Test
	void test() {
		
		List<ReviewView2> list = dao.getViewList();
		assertTrue(list.size() == 9);
	}

}
