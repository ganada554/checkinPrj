package com.checkin.web.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.Gu;
import com.checkin.web.entity.ReviewView2;
import com.checkin.web.service.ReviewService;

@Controller("adminReviewController")
@RequestMapping("/admin/")
public class ReviewController {

	@Autowired
	private ReviewService service;
	
	@GetMapping("review")
	public String list(String gu, Model model) {
		
		List<ReviewView2> list = service.getViewList(gu);
		model.addAttribute("list", list);
		model.addAttribute("selectedGu", gu);
		
		List<Gu> guList = service.getGu();
		model.addAttribute("guList", guList);
		
		return "admin/review";
	}
	
	@RequestMapping("del/{id}")
	public String del(
			@PathVariable int id) {
		
		service.delete(id);
		
		return "redirect:/admin/review";
	}
}
