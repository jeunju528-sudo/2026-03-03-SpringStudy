package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Controller 예외처리 -> 공통 예외처리

@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("==========================예외 발생(exception)=========================");
		ex.printStackTrace();
	}
	
	@ExceptionHandler(Throwable.class)
	public void throwable(Throwable ex) {
		System.out.println("==========================예외 발생(throwable)=========================");
		ex.printStackTrace();
	}
	
}
