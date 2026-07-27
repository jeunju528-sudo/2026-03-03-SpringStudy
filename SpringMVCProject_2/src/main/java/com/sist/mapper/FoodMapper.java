package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("select no, name, poster, address, poster "
			+"from food "
			+"order by no "
			+"offset #{start} rows fetch next 10 rows only ")
	public List<FoodVO> foodListData(int start);
	
	@Select("select ceil(count(*)/12.0) "
			+ "from food ")
	public int foodTotalPage();
	
	
}
