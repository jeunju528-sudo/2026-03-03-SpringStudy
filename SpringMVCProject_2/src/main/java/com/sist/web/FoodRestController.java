package com.sist.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.service.FoodService;
import com.sist.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FoodRestController {
	
	private final FoodService foodService;
	
	@GetMapping("food/list.do")
	public Map food_list(String page) {
		Map map = new HashMap();
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		final int ROW_SIZE = 12;
		int start = (curpage - 1)*ROW_SIZE;
		List<FoodVO> list = foodService.foodListData(start);
		int totalpage = foodService.foodTotalPage();
		
		map.put("list", list);
		map.put("curpage", curpage);
		map.put("totalpage", totalpage);
		
		return map;
	}
	
}
