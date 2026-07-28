package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.DataBoardVO;

public interface DataBoardMapper {

	@Select("SELECT no, subject, name, TO_CHAR(regdate,'yyyy-mm-dd') as dbday, hit "
			+ "FROM springdataboard "
			+ "ORDER BY no DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<DataBoardVO> dataBoardListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM springdataboard")
	public int dataBoardTotalPage();
	
	@Insert("INSERT INTO springdataboard(no, name, subject, content, pwd, filename, filesize, filecount) "
			+ "values(sd_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, #{filename}, #{filesize}, #{filecount})")
	public void dataBoardInsert(DataBoardVO vo);
	
}
