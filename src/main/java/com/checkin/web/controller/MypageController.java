package com.checkin.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.checkin.web.entity.Member;
import com.checkin.web.service.BookmarkService;
import com.checkin.web.service.MemberService;

@Controller("mypage")
public class MypageController {
	private MemberService service;
	private BookmarkService markService;
	
	@Autowired
	public MypageController(MemberService service, BookmarkService markService) {
		this.service = service;
		this.markService = markService;
	}
	
	@RequestMapping("/mypage")
	public String mypage(final HttpSession session, Model model){
		  Member member = (Member) session.getAttribute("member");
		  System.out.println(member);
		  
		  if(member == null)
				return "mypage/indexLogin";
		  
		  int id = member.getId();
			
		  int sc = markService.getStampCount(id);
		  int bc = markService.getMyCount(id);
		  
		  model.addAttribute("member", member);
		  model.addAttribute("stampCount", sc);
		  model.addAttribute("bookCount", bc);
				
		  
			if(member.getPositionId() == 2) {
				
				return "mypage/indexBook";
				
			} else if(member.getPositionId() == 1) {
				
				return "mypage/indexAdmin";
				
			} else {
			
				return "mypage/index";
			}
	}
	
	@RequestMapping("/mypage/info")
	public String myInfo(HttpSession session, Model model) {
		Member member = (Member)session.getAttribute("member");
		model.addAttribute("member", member);
		
		return "mypage/info";
		
	}
	
	@PostMapping("/mypage/info/update")
	public String myInfo(HttpServletRequest request, 
						@RequestParam(name="file", required=false) MultipartFile profileImg, 
						Member member, 
						HttpSession session) {

		String path ="/images/profile";
		String fileName = profileImg.getOriginalFilename(); // 파일 이름
		System.out.println(fileName);
		

			ServletContext application = request.getServletContext();
			String uploadPath = application.getRealPath(path);
	
			try {
				
				String filePath = uploadPath + File.separator + fileName;
				System.out.println(filePath);
				File saveFile = new File(filePath);
				profileImg.transferTo(saveFile);
				member.setProfileImg(path + '/' + fileName);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		service.update(member);
		
		member = service.get(member.getId());
		session.setAttribute("member", member);
		
		return "redirect:/mypage";
	}
	
	
	@RequestMapping("/bye")
	public String delete(@RequestParam Integer id, HttpSession session) {

		service.delete(id);
		session.invalidate();
		
		
		return "redirect:/index";
	}
	
}
