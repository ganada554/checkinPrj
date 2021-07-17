package com.checkin.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.checkin.web.dao.MemberDao;
import com.checkin.web.entity.Member;

@Service
public class MemberServiceImp implements MemberService{
	
	private MemberDao dao;
	
	@Autowired
	public MemberServiceImp(MemberDao dao) {
		this.dao = dao;
	}
	
	@Override
	public boolean loginCheck(Member member) {
		
		return dao.loginCheck(member);
	}
	
	
	@Override
	public Member getByEmail(String email) {
		
		return dao.getByEmail(email);
	}
	
	@Override
	public Member get(int id) {
		
		return dao.get(id);
	}

	@Override
	public List<Member> getList() {
		
		return dao.getList(null, null);
	}

	@Override
	public List<Member> getList(Integer positionId, String query) {
		
		return dao.getList(positionId, query);
	}

	@Override
	public int getCount(Integer positionId, String query) {
		
		return dao.getCount(positionId, query);
	}

	@Override
	public int insert(Member member) {
		
		return dao.insert(member);
	}

	@Override
	public int update(Member member) {
		
		return dao.update(member);
	}
	
	@Override
	public int level1(Member member) {
		member.setPositionId(1);
		
		return dao.update(member);
	}
	

	@Override
	public int level2(Member member) {
		member.setPositionId(2);
		
		return dao.update(member);
	}
	
	@Override
	public int level3(Member member) {
		member.setPositionId(3);
		
		return dao.update(member);
	}
	
	@Override
	public int delete(int id) {
		
		return dao.delete(id);
	}

	@Override
	public boolean nickTrue(String nickname) {
		String nick = dao.nickTrue(nickname);
		
		return (nick == null) ? true : false;
	}

	@Override
	public boolean emailValid(String email) {
		String emailTrue = dao.emailValid(email);
		
		return (emailTrue == null) ? true : false;
	}



}
