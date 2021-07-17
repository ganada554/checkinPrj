package com.checkin.web.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.entity.BookStore;
import com.checkin.web.service.BookStoreService;


@RestController("apiBookstoreController")
@RequestMapping("/api/bookstore/")
public class BookstoreController {

	@Autowired
	private BookStoreService service;
	
	@RequestMapping("list")
	public Map<String, Object> list(Model model) {
		
		List<BookStore> list = service.getList();
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		
		return map;
	}
	
	@RequestMapping("search/{b}")
	public Map<String, Object> bookstore(
		@PathVariable(name="b", required=false) String name,
			Model model) {
		
		BookStore bookstore = service.getBookstore(name);
		
		Map<String, Object> map = new HashMap<>(); 
		map.put("bookstore", bookstore);
		
		return map;
	}
	
	@RequestMapping("searchgu/{id}")
	public Map<String, Object> guBookstore(
		@PathVariable(name="id", required=false) String name,
			Model model) {
		
		List<BookStore> bookstore = service.getGu(name);
		
		Map<String, Object> map = new HashMap<>(); 
		map.put("bookstore", bookstore);
		
		return map;
	}
	
}
