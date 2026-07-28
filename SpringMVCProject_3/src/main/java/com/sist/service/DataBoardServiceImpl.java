package com.sist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.mapper.DataBoardMapper;
import com.sist.vo.DataBoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataBoardServiceImpl implements DataBoardService {

	private final DataBoardMapper mapper;
	@Override
	public List<DataBoardVO> dataBoardListData(int start) {
		return mapper.dataBoardListData(start);
	}

	@Override
	public int dataBoardTotalPage() {
		return mapper.dataBoardTotalPage();
	}

	@Override
	public void dataBoardInsert(DataBoardVO vo) {
		mapper.dataBoardInsert(vo);
	}

}
