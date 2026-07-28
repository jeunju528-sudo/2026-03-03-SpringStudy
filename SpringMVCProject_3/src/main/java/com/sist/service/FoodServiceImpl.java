package com.sist.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
	
	private final FoodMapper foodMapper;
	
	/*
	private FoodMapper foodMapper;
	public FoodServiceImpl(FoodMapper foodMapper) {
		this.foodMapper = foodMapper;
	}
	*/

	@Override
	public List<FoodVO> foodListData(int start) {
		return foodMapper.foodListData(start);
	}

	@Override
	public int foodTotalPage() {
		return foodMapper.foodTotalPage();
	}

	@Override
	public List<FoodVO> foodFindListData(Map map) {
		return foodMapper.foodFindListData(map);
	}

	@Override
	public int foodFindTotalPage(Map map) {
		return foodMapper.foodFindTotalPage(map);
	}

	@Override
	public FoodVO foodDetailData(int no) {
		return foodMapper.foodDetailData(no);
	}

}
