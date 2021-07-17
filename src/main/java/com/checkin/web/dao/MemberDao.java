package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.Member;


public interface MemberDao {
	public boolean loginCheck(Member member);
	Member get(int id);
	List<Member> getList(Integer positionId, String query);
	
	int getCount(Integer positionId, String query);	
	int insert(Member member);
	int update(Member member);
	int delete(int id);
	Member getByEmail(String email);
	
	String nickTrue(String nickname);
	String emailValid(String email);
}