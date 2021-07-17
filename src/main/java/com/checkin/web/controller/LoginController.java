package com.checkin.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.checkin.web.entity.Member;
import com.checkin.web.service.MemberService;

@Controller("login")
public class LoginController {
	private MemberService service;
	
	@Autowired
	public LoginController(MemberService service){
		this.service = service;
	}
	

	@GetMapping("/signup")
	public String signup() {
		
		return "login/signup";
	}

	@PostMapping("/signup")
	public String signup(Member member, HttpSession session, HttpServletRequest request) {
		session = request.getSession();
		
		service.insert(member);
		
		member = service.getByEmail(member.getEmail());
		session.setAttribute("member", member);
		
		return "redirect:/index";
	}
	
	
	@GetMapping("/login")
	public String login(HttpServletRequest request, Model model) {

		
		return "login/index";
	}
	@PostMapping("/login")
	public String login(HttpSession session, HttpServletRequest request, Member member) {
		session = request.getSession();
		// 로그인 상태라면
		if(session.getAttribute("member") != null)
			return "redirect:/mypage";
		
		// 유효성 검사
		System.out.println(member);
		boolean result = service.loginCheck(member);
		System.out.println(result);

		// 유효하면 세션에 넣기
		if(result) {
			member = service.getByEmail(member.getEmail());
			session.setAttribute("member", member);
			
			System.out.println(member);
			
			return "redirect:/index";
		} else {
			return "redirect:/login?error=1";
		}
	}
	
	

    
    
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		System.out.println(session);
		
		return "redirect:/index";
	}
	


}
