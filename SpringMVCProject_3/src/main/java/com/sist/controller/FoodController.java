package com.sist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class FoodController {
	
	public final FoodService foodService;
	
	@GetMapping("main/main.do")
	public String main_main(String page, Model model) { // request가 사라지고 다 매개변수로 값을 받음
		
		
		// 사용자가 값을 맨 처음에 못 보낼 수도 있는 파라미터의 경우 int로 보내면 에러가 발생할 수 있음
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		int start = (curpage-1)*12;
		List<FoodVO> list = foodService.foodListData(start);
		int totalpage = foodService.foodTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		
		model.addAttribute("main_jsp", "../main/home.jsp");
		return "main/main";
	}
	/*
	 * getMapping : select axios.get()
	 * postMapping : insert axios.post()
	 * putMapping : update axios.put()
	 * deleteMapping : delete axios.delete()
	 * 
	 * */
	@GetMapping("food/detail.do")
	public String food_detail(int no, Model model) {
		
		FoodVO vo = foodService.foodDetailData(no);
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../food/detail.jsp");
		return "main/main";
	}
	
	
	// @Get 과 @Post를 구분하지 않을때
	@RequestMapping("food/find.do")
	public String food_find(String page, String column, String fd, Model model) {
		if(column == null)
			column = "address";
		if(fd == null)
			fd = "마포";
		if(page == null)
			page = "1";
		
		int curpage = Integer.parseInt(page);
		int start = (curpage-1)*12;
		
		Map map = new HashMap();
		map.put("column", column);
		map.put("fd", fd);
		map.put("start", start);
		
		List<FoodVO> list = foodService.foodFindListData(map);
		int totalpage = foodService.foodFindTotalPage(map);
		
		final int BLOCK = 10;
		int startPage = ((curpage-1)/BLOCK*BLOCK)+1;
		int endPage = ((curpage-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("column", column);
		model.addAttribute("fd", fd);
		model.addAttribute("main_jsp", "../food/find.jsp");
		return "main/main";
	}
}
