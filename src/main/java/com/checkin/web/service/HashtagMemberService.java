package com.checkin.web.service;

import java.util.List;
import java.util.Map;

public interface HashtagMemberService {
	boolean hashCheck(Integer hashtagId, Integer memberId);
	Integer getCount(Integer memberId);
	Integer[] getList(Integer memberId);
	Integer insert(Integer hasgtagId, Integer memberId);
	Integer delete(Integer hashtagId, Integer memberId);
	
	List<Map<String, Integer>> mylovehashtag(Integer memberId);
}
