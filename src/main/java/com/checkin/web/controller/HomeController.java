package com.checkin.web.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.BookStoreView;
import com.checkin.web.entity.Member;
import com.checkin.web.entity.ReviewView2;
import com.checkin.web.entity.StampList;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.BookmarkService;
import com.checkin.web.service.ReviewService;

@Controller
public class HomeController {
	private BookStoreService service;
	private BookmarkService stampService;
	private ReviewService reviewService;
	
	@Autowired
	public HomeController(BookStoreService service, BookmarkService stampService, ReviewService reviewService) {
		this.service = service;
		this.stampService = stampService;
		this.reviewService = reviewService;
	}
	
	@RequestMapping("/index")
	public String index(Model model) {
		// 이 서점은 어떠세요?
		Integer[] bookStoreArray = service.getBookstoreIdArray();
		System.out.println(bookStoreArray);
		Integer[] ids = shuffle(bookStoreArray);
		System.out.println(ids);
		BookStoreView bookstore= service.getView(ids[0]);
		System.out.println(bookstore);
		model.addAttribute("b", bookstore);
		
		// 사람들이 스탬프를 찍고 있어요
		List<StampList> stampList = stampService.getStampList();
		model.addAttribute("stamp", stampList);
		
		// 최근 리뷰
		List<ReviewView2> review = reviewService.getViewList();
		model.addAttribute("review", review);
		
		return "index";
	}
	
	
	@RequestMapping("/header")
	public String header(HttpSession session, Model model) {

			Member member = (Member)session.getAttribute("member");
			if(member != null) {
				model.addAttribute("member", member);
			} else {
				model.addAttribute("member", null);
			}
		return "inc/header";
	}
	

	
	public static Integer[] shuffle(Integer[] arr){
	    for(int x=0 ; x<arr.length; x++){
	      int i = (int)(Math.random()*arr.length);
	      int j = (int)(Math.random()*arr.length);
	            
	      int tmp = arr[i];
	      arr[i] = arr[j];
	      arr[j] = tmp;
	    }
	        
	    return arr;
	  }


}
