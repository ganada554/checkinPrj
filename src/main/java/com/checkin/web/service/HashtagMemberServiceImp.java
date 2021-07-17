package com.checkin.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.HashtagMemberDao;

@Service
public class HashtagMemberServiceImp implements HashtagMemberService{
	private HashtagMemberDao dao;
	
	@Autowired
	public HashtagMemberServiceImp(HashtagMemberDao dao) {
		this.dao = dao;
	}
	
	@Override
	public boolean hashCheck(Integer hashtagId, Integer memberId) {
		Integer hashtrue = dao.hashCheck(hashtagId, memberId);
		return (hashtrue != null)? true : false;
	}

	@Override
	public Integer getCount(Integer memberId) {
		return dao.getCount(memberId);
	}

	@Override
	public Integer[] getList(Integer memberId) {
		
		return dao.getList(memberId);
	}

	@Override
	public Integer insert(Integer hasgtagId, Integer memberId) {
		
		return dao.insert(hasgtagId, memberId);
	}

	@Override
	public Integer delete(Integer hashtagId, Integer memberId) {
		
		return dao.delete(hashtagId, memberId);
	}

	@Override
	public List<Map<String, Integer>> mylovehashtag(Integer memberId) {

		return dao.mylovehashtag(memberId);
	}

}
