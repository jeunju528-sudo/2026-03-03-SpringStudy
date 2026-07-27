package com.sist.main;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("mem")
public class Member {
	private int mno;
	private String name;
}
