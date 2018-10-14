package com.java.springaop.pointcut;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class PointCutDefinition {

	@Pointcut("within(com.java.springaop.service..*)")
	  public void serviceLayer() {
	  }
}
