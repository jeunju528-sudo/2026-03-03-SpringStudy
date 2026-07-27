package com.sist.main2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new AnnotationConfigApplicationContext(SawonConfig.class);
		Sawon s = (Sawon)app.getBean("sa");
		System.out.println(s.getSabun());
		System.out.println(s.getDept());
	}

}
