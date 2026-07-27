package com.sist.main3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.sist.*"})
@EnableAspectJAutoProxy
public class DAOConfig {

}
