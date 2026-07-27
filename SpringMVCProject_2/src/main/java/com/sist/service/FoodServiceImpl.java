package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.FoodDAO;
import com.sist.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // 생성자 안에서 @Autowired 를 수행
public class FoodServiceImpl implements FoodService{
	
	private final FoodDAO dao;
	

	@Override
	public List<FoodVO> foodListData(int start) {
		return dao.foodListData(start);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return dao.foodTotalPage();
	}

}
