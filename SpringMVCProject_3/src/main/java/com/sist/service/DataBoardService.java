package com.sist.service;

import java.util.List;

import com.sist.vo.DataBoardVO;

public interface DataBoardService {
	public List<DataBoardVO> dataBoardListData(int start);

	public int dataBoardTotalPage();

	public void dataBoardInsert(DataBoardVO vo);
}
