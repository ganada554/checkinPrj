package com.checkin.web.api.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.checkin.web.entity.Member;
import com.checkin.web.service.MemberService;

@RestController("apiMemberController")
public class MemberController {

	@Autowired
	private MemberService service;
	
	@RequestMapping("/api/member/{nickname}")
	public boolean nickTrue(@PathVariable("nickname") String nickname){
		boolean nicktrue = service.nickTrue(nickname);

		return nicktrue;
	}
	
	@RequestMapping("/api/login/kakao")
	public String kakaoLogin(@RequestBody Member member, HttpSession session, HttpServletRequest request){
		
		
		String email = member.getEmail();
		boolean valid = service.emailValid(email);
		if(valid) {
			member.setProfileImg(member.getProfileImg());
			member.setPassword("kakao");
			service.insert(member);
			session.setAttribute("member", member);
		} else {
			member = service.getByEmail(email);
			session.setAttribute("member", member);
		}
		String result = "ok";
		return result;
	}
}
