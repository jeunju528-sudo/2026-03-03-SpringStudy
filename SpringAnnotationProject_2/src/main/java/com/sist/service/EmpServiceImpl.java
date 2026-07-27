package com.sist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.dao.DeptDAO;
import com.sist.dao.EmpDAO;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Service("eService")
public class EmpServiceImpl implements EmpService {

	@Autowired
	private EmpDAO eDao;
	
	@Autowired
	private DeptDAO dDao;
	
	@Override
	public List<EmpVO> empListData() {
		return eDao.empListData();
	}

	@Override
	public List<DeptVO> deptListData() {
		// TODO Auto-generated method stub
		return dDao.deptListData();
	}

}
