package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.EmpDAO;
import com.sist.vo.EmpVO;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao = (EmpDAO)app.getBean("dao");
		
		List<EmpVO> list = dao.empListData();
		for(EmpVO vo : list) {
			System.out.println(vo.getEmpno() + " " 
							+ vo.getEname() + " ");
		}
		System.out.println("=============================");
		
		List<EmpVO> list2 = dao.empAllData();
		for(EmpVO vo : list2) {
			System.out.println(vo.getEmpno() + " " 
							+ vo.getEname() + " ");
		}
	}

}
