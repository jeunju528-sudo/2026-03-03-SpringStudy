package com.sist.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class FoodRestController {
	private final FoodService foodService;
	
	@GetMapping("food/list_vue.do")
	public Map food_list_vue(int page){
		Map map = new HashMap();
		
		int start = (page-1)*12;
		List<FoodVO> list = foodService.foodListData(start);
		int totalpage = foodService.foodTotalPage();
		
		final int BLOCK = 10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage > totalpage) {
			endPage = totalpage;
		}
		
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);
		
		return map;
	}
	
	@GetMapping("food/detail_vue.do")
	public FoodVO food_detail_vue(int no) {
		FoodVO vo = foodService.foodDetailData(no);
		return vo;
	}
	
	@RequestMapping("food/find_vue.do")
	public Map food_find(int page, String column, String fd){
		
		int curpage = page;
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
		
		map = new HashMap();
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("list", list);
		
		return map;
		
		
	}

}
