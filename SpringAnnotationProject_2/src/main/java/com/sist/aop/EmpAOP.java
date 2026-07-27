package com.sist.aop;

import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.sist.vo.DeptVO;
import com.sist.vo.EmpVO;

@Aspect
@Component
/*
 * JoinPoint
 * 	@Before
 * 	@After
 *  @After-returning
 *  @Around
 *  @After-Throwing
 * PointCut
 * 
 * 
 * public void display(){
 * 	@Before
 * 	try {
 * 		@Around => before
 * 		setAutoCommit(false)
 * 		
 * 		@Around => after
 * 		commit()
 * 	}
 * 	catch(){
 * 		@After-throwing
 * 	}
 * 	finally {
 * 		@After
 * 	}
 * 	return ""; @After-Returning
 * 
 * }
 * 
 *     *      com.sist.service.EmpServiceImpl.  *       (..))
 *   ------   -------------------------------  ------  ----
 *    리턴형         클래스                        메소드    매개변수
 *   *:모든리턴형                               *:모든메소드  모든매개변수(있거나/없거나 상관x)
 * */
public class EmpAOP {
	@Before("execution(* com.sist.service.EmpServiceImpl.*(..))")
	public void before() {
		System.out.println("메소드 진입 전");
	}
	@After("execution(* com.sist.service.EmpServiceImpl.*(..))")
	public void after() {
		System.out.println("메소드 종료 전");
	}
	@Around("execution(* com.sist.service.EmpServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Object obj = null;
		long start = System.currentTimeMillis();
		System.out.println("호출된 메서드 : "+jp.getSignature().getName());
		obj=jp.proceed(); // 메서드 호출
		long end = System.currentTimeMillis();
		System.out.println("걸린 시간 : "+(end-start)+"ms");
		return obj;
	}
	@AfterReturning(value="execution(* com.sist.service.EmpServiceImpl.*(..))",returning="obj")
	public void afterReturning(Object obj) {
		
		if(obj instanceof List) {
			List<?> list = (List<?>)obj;
			for(Object item : list) {
				if(item instanceof EmpVO) {
					EmpVO vo = (EmpVO)item;
					System.out.println(vo.getEmpno()+" "+vo.getEname()+" "+vo.getJob()+" "+vo.getDbday());
				}
				if(item instanceof DeptVO) {
					DeptVO vo = (DeptVO)item;
					System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
				}
			}
		}
		
		
	}
	@AfterThrowing(value="execution(* com.sist.service.EmpServiceImpl.*(..))", throwing="ex")
	public void afterThrowing(Throwable ex) {
		ex.printStackTrace();
	}
	
}
