package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.FoodVO;

public interface FoodMapper {
	@Select("SELECT no, name, poster, address "
			+ "FROM food "
			+ "ORDER BY no ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
	public List<FoodVO> foodListData(int start);
	
	@Select("SELECT CEIL(count(*)/12.0) "
			+ "FROM food")
	public int foodTotalPage();
	
	//<select id="foodFindListData" resultType="FoodVO" parameterType="hashmap">
	// 자바 메소드 명 = mapper id
	public List<FoodVO> foodFindListData(Map map);
	
	//<select id="foodFindTotalPage" resultType="int" parameterType="hashmap">
	public int foodFindTotalPage(Map map);
	
	@Select("SELECT no, name, type, phone, address, score, parking, poster, "
			+ "time, content, theme, price "
			+ "FROM food "
			+ "WHERE no = #{no}")
	public FoodVO foodDetailData(int no);
}
