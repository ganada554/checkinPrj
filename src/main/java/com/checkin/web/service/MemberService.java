package com.checkin.web.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.checkin.web.entity.Member;


public interface MemberService {
	public boolean loginCheck(Member member);
	Member get(int id);
	Member getByEmail(String email);
	List<Member> getList();
	List<Member> getList(Integer positionId, String query);
	
	int getCount(Integer positionId, String query);	
	int insert(Member member);
	
	int update(Member member);
	int level1(Member member);
	int level2(Member member);
	int level3(Member member);
	
	boolean nickTrue(String nickname);
	
	int delete(int id);
	boolean emailValid(String email);
}