package com.checkin.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.HashtagReviewDao;
import com.checkin.web.entity.HashtagReview;
@Service
public class HashtagReviewServiceImp implements HashtagReviewService{

	private HashtagReviewDao dao;
	
	@Autowired
	public HashtagReviewServiceImp(HashtagReviewDao dao) {
		this.dao = dao;
	}
	
	
	@Override
	public HashtagReview get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public int insert(int hashtagId, int reviewId) {
		// TODO Auto-generated method stub
		return dao.insert(hashtagId, reviewId);
	}

	@Override
	public int update(int hashtagId) {
		// TODO Auto-generated method stub
		return dao.update(hashtagId);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

}
