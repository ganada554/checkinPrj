package com.checkin.web.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Gu;
import com.checkin.web.entity.Member;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.GuService;
import com.checkin.web.service.MemberService;

@Controller("adminBookstoreController")
@RequestMapping("/admin/bookstore")
public class BookStoreController {
	@Autowired
	private BookStoreService service;
	@Autowired
	private GuService guService;
	@Autowired MemberService memberService;
	
	
	@RequestMapping("") 
	public String list(Model model, 
			@RequestParam(required=false) String query,
			@RequestParam(required=false)String gu) {
		List<BookStore> list = service.getList(query, gu);
		List<Gu> guList =guService.getList();
		List<Member> memberList = memberService.getList(2, null);
		Map<Integer, String> memberName = new HashMap<>();
		for(BookStore b : list) {
			if(b.getMemberId() != null) {
				Integer bmid = b.getMemberId();
				Member member = memberService.get(bmid);
				memberName.put(b.getId(), member.getNickname());
			}
		}
		System.out.println(memberName);
		model.addAttribute("nameNotNumber", memberName);
		model.addAttribute("bookstore", list);
		model.addAttribute("gu", guList);
		model.addAttribute("member", memberList);
		return "admin/bookstore";
	}
	
	@PostMapping("/update")
	public String update(
			@RequestParam(name="memberId") Integer id,
			@RequestParam(name="bookstoreId") Integer bookstoreId) {
		BookStore bookstore = service.get(bookstoreId);//bookstoreId로 bookstore정보를 다 불러옴
		bookstore.setMemberId(id);//서점지기 임명
		service.update(bookstore);
				
		return "admin/bookstore";
	}
	

}
	