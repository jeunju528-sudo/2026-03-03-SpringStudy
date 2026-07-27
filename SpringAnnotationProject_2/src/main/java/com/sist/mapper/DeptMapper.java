package com.sist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.DeptVO;

public interface DeptMapper {
	@Select("SELECT deptno, dname, loc "
			+"FROM dept")
	public List<DeptVO> deptListData();
	
	//display(@Param("cno") int cno, @Param("no") int no)
	/*
	 * @Select : 단순한 문장
	 * <select> : 복잡한 sql
	 * */
}
