package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		Member m = (Member)app.getBean("mem");
		System.out.println(m);
		Student s = (Student)app.getBean("student"); //@Component에서 이름을 안주면 클래스명의 첫글자를 소문자로 만든게 이름이 됨
		System.out.println(s);
		Sawon sa = (Sawon)app.getBean("sawon");
		System.out.println(sa);
		
		Food f = new Food();

	}

}
