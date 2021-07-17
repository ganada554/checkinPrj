package com.checkin.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

 
import com.checkin.web.dao.StampRouteDao;
import com.checkin.web.entity.StampRoute;

@Repository
public class MybatisStampRouteDao implements StampRouteDao {

	private SqlSession sqlSession;
	private StampRouteDao mapper;
	
	@Autowired
	 public MybatisStampRouteDao(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		mapper = sqlSession.getMapper(StampRouteDao.class);
	}
	
	@Override
	public StampRoute get(int id) {
		
		return mapper.get(id);
	}

	@Override
	public List<StampRoute> getList() {
		
		return getList();
	}

	@Override
	public List<StampRoute> getList(String query) {
		// 
		return mapper.getList(query);
	}


}
