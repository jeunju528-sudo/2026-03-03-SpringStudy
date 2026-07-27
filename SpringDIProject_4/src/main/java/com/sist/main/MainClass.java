package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.FoodDAO;
import com.sist.dao.GoodsDAO;
import com.sist.dao.SeoulDAO;
import com.sist.vo.FoodVO;
import com.sist.vo.GoodsVO;
import com.sist.vo.SeoulVO;

public class MainClass {

	public static void main(String[] args) {
//		String[] xml = {"application-context.xml", "application-datasource.xml"};
		ApplicationContext app = new ClassPathXmlApplicationContext("application-*.xml");
		FoodDAO fdao = app.getBean("fdao",FoodDAO.class); // = FoodDAO fdao = (FoodDAO)app.getBean("fdao");
		List<FoodVO> flist = fdao.foodListData(1);
		
		GoodsDAO gdao = (GoodsDAO)app.getBean("gdao");
		List<GoodsVO> glist = gdao.goodsListData(1);
		
		SeoulDAO sdao = app.getBean("sdao",SeoulDAO.class);
		List<SeoulVO> slist = sdao.seoulListData(1);
		
		System.out.println(flist);
		System.out.println(glist);
		System.out.println(slist);
		
	}

}
