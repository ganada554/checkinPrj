package com.checkin.web.service;

import java.util.List;

import com.checkin.web.entity.Position;

public interface PositionService {
	Position get(int id);
	
	int update(Position position);
}
