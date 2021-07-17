package com.checkin.web.controller.admin;

import java.util.List;

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

	@Controller("member")
	public class MemberController {
		private MemberService service;
		
		@Autowired
		public MemberController(MemberService service){
			this.service = service;
		}
		
		@GetMapping("/admin/member")
		public String adminMemberList(Model model,
					@RequestParam(name="p", required = false) Integer positionId,
					@RequestParam(name="q", required = false) String query) {
			
			List<Member> member = service.getList(positionId, query);
			int count = service.getCount(positionId, query);
			int entireCount = service.getCount(null, null);
			
			model.addAttribute("member", member);
			model.addAttribute("count", count);
			model.addAttribute("entireCount", entireCount);
			
			return "admin/member";
		}
		
		@RequestMapping("/admin/member/delete")
		public String delete(@RequestParam Integer id) {
			service.delete(id);
			
			return "redirect:/admin/member";
		}
		
		@RequestMapping("/admin/member/1")
		public String level1(@RequestParam Integer id) {
			Member member = service.get(id);
			service.level1(member);
			return "redirect:/admin/member";
		}
		
		@RequestMapping("/admin/member/2")
		public String level2(@RequestParam Integer id) {
			Member member = service.get(id);
			service.level2(member);
			return "redirect:/admin/member";
		}
		
		@RequestMapping("/admin/member/3")
		public String level3(@RequestParam Integer id) {
			Member member = service.get(id);
			service.level3(member);
			return "redirect:/admin/member";
		}
	


}
