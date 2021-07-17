package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.checkin.web.dao.MemberDao;
import com.checkin.web.entity.Member;

@Repository
public class MyBatisMemberDao implements MemberDao{
	private SqlSession sqlSession;
	private MemberDao mapper;
	
	@Autowired
	public MyBatisMemberDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(MemberDao.class);
	}

	@Override
	public boolean loginCheck(Member member) {
		String name = sqlSession.selectOne("com.checkin.web.dao.MemberDao.loginCheck", member);
		return (name == null) ? false : true;
	}
	
	
	@Override
	public Member getByEmail(String email) {
		
		return mapper.getByEmail(email);
	}
	
	@Override
	public Member get(int id) {
		
		return mapper.get(id);
	}

	@Override
	public List<Member> getList(Integer positionId, String query) {
		
		return mapper.getList(positionId, query);
	}

	@Override
	public int getCount(Integer positionId, String query) {
		
		return mapper.getCount(positionId, query);
	}

	@Override
	public int insert(Member member) {
		
		return mapper.insert(member);
	}
	
	

	@Override
	public int update(Member member) {
		
		return mapper.update(member);
	}

	@Override
	public int delete(int id) {
		
		return mapper.delete(id);
	}


	@Override
	public String nickTrue(String nickname) {
		return mapper.nickTrue(nickname);
	}

	@Override
	public String emailValid(String email) {
		
		return mapper.emailValid(email);
	}
}
