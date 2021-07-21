package com.checkin.web.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Gu;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.GuService;


@Controller 
@RequestMapping("")
public class BookStampController {
	
	@Autowired
	private BookStoreService service;
	@Autowired
	private GuService guService;
	
	@GetMapping("/bookstamp")	
	public String main(Model model) {
		List<Gu> gu = guService.getList();
		model.addAttribute("gu", gu);
		
		List<BookStore> bookstore = service.getList();
		model.addAttribute("bookstore", bookstore);
		
		return "bookstamp/main";
		 
	}
	
	@GetMapping("/bookstamp/detail")
	public String detail(Model model, @RequestParam Integer id) {
		List<Gu> guList = guService.getList();
		model.addAttribute("gu", guList);		
		model.addAttribute("selectedGu", id);

		String gu = guService.getGuById(id);
		List<BookStore> bookstore = service.getGu(gu);
		model.addAttribute("guName", gu);
		model.addAttribute("bookstore", bookstore);
		
		return "bookstamp/detail";
		
	}

}
