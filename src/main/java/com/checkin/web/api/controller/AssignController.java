package com.checkin.web.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.entity.BookStore;
import com.checkin.web.service.BookStoreService;


@RestController("apiAssignController")
public class AssignController {
	
	@Autowired
	private BookStoreService service;
	
	@RequestMapping("/api/assign/{mid}/{bid}")	
	public String assign(@PathVariable Integer mid, @PathVariable Integer bid ){
		BookStore bookstore = service.get(bid);
		bookstore.setMemberId(mid);		
		service.update(bookstore);
		
		
		return "ok";
		
	}
	
	

}
