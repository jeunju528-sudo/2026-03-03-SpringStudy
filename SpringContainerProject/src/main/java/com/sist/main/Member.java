package com.sist.main;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/*
 * @AllArgsConstructor >> 모든 변수가 들어간 생성자를 만들어줘라
 * public class Member {
 * 
 * 	public Sawon(int mno, String name, String address, String phone){} 
 * }
 * */

public class Member {
	private int mno;
	private String name;
	private String address;
	private String phone;
	public void init() {
		System.out.println("회원 목록");
	}
	public void destory() {
		System.out.println("=====================");
	}
	public void print() {
		System.out.println("mno :: " + mno);
		System.out.println("name :: " + name);
	}
}
