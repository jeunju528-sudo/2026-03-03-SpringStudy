package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.service.EmpService;
import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

public class MainClass2 {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		EmpService service = (EmpService)app.getBean("eService");
		List<EmpVO> list = service.empListData();
		List<DeptVO> dList = service.deptListData();
		/*
		for(EmpVO vo : list) {
			System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getDbday());
		}
		
		for(DeptVO vo : dList) {
			System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
		}
		*/
		
		
	}

}
