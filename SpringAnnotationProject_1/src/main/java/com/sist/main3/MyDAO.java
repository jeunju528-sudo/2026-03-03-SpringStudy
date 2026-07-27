package com.sist.main3;

import org.springframework.stereotype.Repository;

@Repository
public class MyDAO {
	public void getConnection() {
		System.out.println("오라클 연결");
	}
	public void disConnection() {
		System.out.println("오라클 해제");
	}
	public void dbselect() {
		//getConnection();
		System.out.println("데이터 조회");
		//disConnection();
	}
	public void dbinsert() {
		//getConnection();
		System.out.println("데이터 저장");
		//disConnection();
	}
	public void dbupdate() {
		//getConnection();
		System.out.println("데이터 수정");
		//disConnection();
	}
	public void dbdelete() {
		//getConnection();
		System.out.println("데이터 삭제");
		//disConnection();
	}
}
