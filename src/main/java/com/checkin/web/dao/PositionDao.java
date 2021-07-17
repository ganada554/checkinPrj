package com.checkin.web.dao;

import java.util.List;

import com.checkin.web.entity.Position;

public interface PositionDao {
	Position get(int id);
	
	int update(Position position);
}
