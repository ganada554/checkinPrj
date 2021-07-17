package com.checkin.web.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.HashtagService;
import com.checkin.web.service.RecService;

@RestController("apiRecController")
@RequestMapping("/api/recommend/")
public class RecController {

	@Autowired
	private RecService service;
	//@RequestParam(name:q) String query
	//초기페이지와 검색했을 때의 페이지는 컨트로러 작성을 어떻게?
	
	@RequestMapping("list")
	public Map<String, Object> list(
			Model model,	
			@RequestParam(name="q", required = false) String query, 
			@RequestParam(name="f", required = false) String field) {
		
			List<Hashtag> hlist = service.getList();
			model.addAttribute("hlist",hlist);
		
			Map<String, Object> map = new HashMap<>();
			
			
			
		if(field.equals("1")||query.equals("")) {
			//서점 검색
			System.out.println(query);
			System.out.println(field);
			
			List<BookStoreView> list = service.getListBooktStore(query);
			
			System.out.println(list);
			System.out.println(list.isEmpty());
			
			map.put("list",list);
			
		}else {
			//해시태그 검색
			System.out.println(query);
			System.out.println(field);
			List<BookStoreView> list = service.getListHashtagBookstore(query);
			
			map.put("list",list);
		}
		
		
			
		
		return map;
	}
	
//	@RequestMapping("error")
//	public int error(int result){
//		
//		//int r = result;
//		//map.put("result", result);
//		int r = result;
//		return r;
//	}
	 
}
