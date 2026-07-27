package com.sist.auto;

import org.springframework.stereotype.Repository;

@Repository
public class MySQLDB implements Oracle{

	@Override
	public void connection() {
		System.out.println("MySQL 연결");
		
	}

	@Override
	public void disConnection() {
		System.out.println("MySQL 해제");
		
	}

}
