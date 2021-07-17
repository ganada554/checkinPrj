package com.checkin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.checkin.web.entity.Gu;
import com.checkin.web.service.GuService;

@Controller
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	private GuService guService;
	
	@GetMapping("")
	public String main(Model model) {
		
		List<Gu> gu = guService.getList();
		model.addAttribute("gu", gu);
		
		return "map/main";
	}
}
