package com.sist.main2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SawonConfig {
	@Bean("sa")
	public Sawon sawon() {
		Sawon s = new Sawon();
		s.setSabun(1);
		s.setName("심청이");
		s.setDept("개발부");
		s.setJob("사원");
		return s;
	}
	
}
