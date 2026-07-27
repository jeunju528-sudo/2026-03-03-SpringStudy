package com.sist.main;

public class MainClass {
	public static void main(String[] args) {
		
		String path = "C:\\springDev\\SpringDIProject_3\\src\\main\\java\\com\\sist\\main\\app.xml";
		ApplicationContext app = new ClassPathXmlApplicationContext(path);
		
		Sawon s = (Sawon)app.getBean("sa");
		System.out.println("사번 : " + s.getSabun());
		System.out.println("이름 : " + s.getName());
		System.out.println("부서 : " + s.getDept());
		System.out.println("직위 : " + s.getJob());
		
	}
}
