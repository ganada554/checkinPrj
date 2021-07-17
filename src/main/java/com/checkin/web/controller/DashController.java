package com.checkin.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.Member;
import com.checkin.web.service.BookStoreService;
import com.checkin.web.service.BookmarkService;
import com.checkin.web.service.HashtagMemberService;
import com.checkin.web.service.HashtagService;
import com.checkin.web.service.ReviewService;

@Controller("Dash")
public class DashController {
	private BookStoreService storeService;
	private BookmarkService service;
	private ReviewService reviewService;
	private HashtagMemberService hashmemService;
	private HashtagService hashService;
	
	@Autowired
	public DashController(BookStoreService storeService, BookmarkService service, ReviewService reviewService, 
							HashtagService hashService, HashtagMemberService hashmemService) {
		this.storeService = storeService;
		this.service = service;
		this.reviewService = reviewService;
		this.hashmemService = hashmemService;
		this.hashService = hashService;
	}
	
	
	@RequestMapping("/mypage/dashboard")
	public String dashboard(final HttpSession session, Model model){
		  Member member = (Member) session.getAttribute("member");
		  Integer memberId = member.getId();
		  model.addAttribute("member", member);
			
		  
		  List<Map<String, Integer>> mylovehash = hashmemService.mylovehashtag(memberId);
				
		  System.out.println(mylovehash);
		  model.addAttribute("mylovehash", mylovehash);
			// --- Hash, 나의 Hash, Hash count ---
			Integer[] hashId = hashmemService.getList(memberId);
			List<Hashtag> list= hashService.getList(); // 전체 목록
			List<Hashtag> hashList = new ArrayList<>(); // 내 거 목록
			Map<String, Integer> selected = new HashMap<String, Integer>(); // 셀렉트 클래스 추가 목록
			for (int eachId : hashId) {
				Hashtag eachHash = hashService.get(eachId);
				hashList.add(eachHash);
			
				for (Hashtag eachList : hashList) {
					String eachListName = eachList.getName();
					Integer eachListId = eachList.getId();
					
					if(eachListId == eachId) {
						selected.put(eachListName, eachListId);
					}
				}
			}
			Integer hashCount = hashService.getCount();
			Integer myHashCount = hashmemService.getCount(memberId);

			model.addAttribute("hashList", list);
			model.addAttribute("hashCount", hashCount);
			model.addAttribute("myHashCount", myHashCount);
			model.addAttribute("myHashList", hashList);
			model.addAttribute("selected", selected);
			
			return "mypage/dashmember";
			
	}
	

	

	
}
