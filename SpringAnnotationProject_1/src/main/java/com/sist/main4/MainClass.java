package com.sist.main4;

public class MainClass {
	public static void main(String[] args) {
		MyDAO dao = new MyDAO();
		dao.select();
		
		Proxy p = new Proxy(dao);
		p.select();
	}
}
