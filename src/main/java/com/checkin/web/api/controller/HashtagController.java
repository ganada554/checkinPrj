package com.checkin.web.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.entity.Hashtag;
import com.checkin.web.service.HashtagService;

@Controller("apiHashtagController")
@RequestMapping("/api/hash/")
public class HashtagController {

	@Autowired
	private HashtagService service;
	//@RequestParam(name:q) String query
	//초기페이지와 검색했을 때의 페이지는 컨트로러 작성을 어떻게?
	
	
//	@RequestMapping("list")
//	public Map<String, Object> list(Model model){
//		
//		List<Hashtag> list = service.getList(null);
//		
//		Map<String, Object> map = new HashMap<>();
//		map.put("list", list);
//		
//		return map;
//	}
	
//	@RequestMapping("error")
//	public int error(int result){
//		
//		//int r = result;
//		//map.put("result", result);
//		int r = result;
//		return r;
//	}
	 
}
