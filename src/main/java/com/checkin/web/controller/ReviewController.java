package com.checkin.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.checkin.web.entity.BookStore;
import com.checkin.web.entity.Gu;
import com.checkin.web.entity.Hashtag;
import com.checkin.web.entity.HashtagReview;
import com.checkin.web.entity.Member;
import com.checkin.web.entity.Rating;
import com.checkin.web.entity.RatingReview;
import com.checkin.web.entity.Review;
import com.checkin.web.entity.ReviewLike;
import com.checkin.web.entity.ReviewLikeView;
import com.checkin.web.entity.ReviewView;
import com.checkin.web.entity.ReviewView2;
import com.checkin.web.service.ReviewService;

@Controller
@RequestMapping("/review/")
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	
	@GetMapping("list")
	public String list(String gu, 
					Model model,
					HttpSession session) {
		
		List<ReviewView2> list = service.getViewList(gu);
		model.addAttribute("list", list);
		model.addAttribute("selectedGu", gu);
		
		List<Gu> guList = service.getGu();
		model.addAttribute("guList", guList);
		
		Map<Integer, String> map = new HashMap<>();
		
		Member member = (Member)session.getAttribute("member");
		if(member != null) {
			int memberId = member.getId();

			List<Integer> likeReview = service.getMemberLike(memberId);
			
			// 리뷰 아이디 반복
			for(ReviewView2 review : list) {
				int entireReviewId = review.getId();
				
				// 내가 좋아요 한 리뷰 아이디 반복
				for(Integer like : likeReview) {
					
					// 두 아이디에서 같은 아이디가 있으면 map에 리뷰 아이디 넣어주기
					if(entireReviewId == like) 
						map.put(like, "ok");					
				}			
			}
			
		} else {
			Integer like = null;
			map.put(like, null);
		}
				
		model.addAttribute("map", map);
		
		return "review/list";
	}
	
	@GetMapping("reg")
	public String reg(Model model) {
		
		List<BookStore> bookstoreList = service.getBookstore();
		model.addAttribute("bList", bookstoreList);
		
		List<Hashtag> hashtagList = service.getHashtag();
		model.addAttribute("hList", hashtagList);
		
		List<Rating> ratingList = service.getRating();
		model.addAttribute("rList", ratingList);
		
		return "review/reg";
	}
	
	@PostMapping("reg")
	public String reg(
			Integer bookstore,
			String content, 
			Integer hashtag,
			Integer rating,
			HttpSession session,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		Member member = (Member)session.getAttribute("member");
		int memberId = member.getId();
		
		Review review = new Review();
		
		// 이미지 업로드
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String uploadDir = "./upload/review/";
		Path uploadPath = Paths.get(uploadDir);
        
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        
		if(fileName != null && !fileName.equals("")) {
			try (InputStream inputStream = multipartFile.getInputStream()) {
				Path filePath = uploadPath.resolve(fileName);
				
				Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException ioe) {        
				throw new IOException("이미지를 저장할 수 없습니다: " + fileName, ioe);
			}      		
			
			review.setImg(fileName);
		}
         
        HashtagReview hreview = new HashtagReview();
        RatingReview rreview = new RatingReview();
        
        review.setBookstoreId(bookstore);
        review.setContent(content);
        review.setMemberId(memberId);
        hreview.setHashtagId(hashtag);
		rreview.setRatingId(rating);

		service.insert(review, hreview, rreview);
		
		return "redirect:list";
	}
	
	@GetMapping("edit")
	public String edit(Model model, int id) {
		
		ReviewView2 review = service.get(id);
		model.addAttribute("review", review);
		
		List<BookStore> bookstoreList = service.getBookstore();
		model.addAttribute("bList", bookstoreList);
		
		List<Hashtag> hashtagList = service.getHashtag();
		model.addAttribute("hList", hashtagList);
		
		List<Rating> ratingList = service.getRating();
		model.addAttribute("rList", ratingList);
		
		return "review/edit";
	}
	
	@PostMapping("edit")
	public String edit(Review review, 
						HashtagReview hreview,
						RatingReview rreview,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		
		// 이미지 업로드
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
				
		String uploadDir = "./upload/review/";
		
		Path uploadPath = Paths.get(uploadDir);
        
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         

        if(fileName != null && !fileName.equals("")) {
        	try (InputStream inputStream = multipartFile.getInputStream()) {
        		Path filePath = uploadPath.resolve(fileName);
        		System.out.println(filePath.toFile().getAbsolutePath());
        		
        		Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        	} catch (IOException ioe) {        
        		throw new IOException("이미지를 저장할 수 없습니다: " + fileName, ioe);
        	}    
        	
        	review.setImg(fileName);
        }
        
		
		service.update(review, hreview, rreview);
		
		return "redirect:list";
	}
	
	@RequestMapping("del")
	public String del(int id) {
		
		service.delete(id);
		
		return "redirect:list";
	}
	
	// 좋아요
	@PostMapping("like")
	public String like(HttpSession session, 
			Integer reviewId,
			Model model) {
		
		Member member = (Member)session.getAttribute("member");
		int memberId = member.getId();
		
		ReviewLike reviewLike = new ReviewLike();
		reviewLike.setReviewId(reviewId);
		reviewLike.setMemberId(memberId);
		
		service.like(reviewLike);
			
		return "redirect:/review/list";
	}
	
	
	// 좋아요 취소
	@PostMapping("like/del")
	public String likeDel(
			HttpSession session, 
			Integer reviewId) {
		
		Member member = (Member)session.getAttribute("member");
		int memberId = member.getId();
		
		service.dontLike(reviewId, memberId);
					
		return "redirect:/review/list";
	}
}
