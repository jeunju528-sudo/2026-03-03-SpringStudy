package com.sist.dao;

import java.util.List;

import com.sist.mapper.SeoulMapper;
import com.sist.vo.SeoulVO;

public class SeoulDAO{
	private SeoulMapper mapper;
	
	public void setMapper(SeoulMapper mapper) {
		this.mapper = mapper;
	}

	public List<SeoulVO> seoulListData(int start) {
		return mapper.seoulListData(start);
	}
	
}
