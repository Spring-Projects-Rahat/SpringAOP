package com.java.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/*By annotating a class with @Aspect we are defining that class as an Aspect. An Aspect usually groups related 
  advices. In our example our aspect will define all advices related with logging.
  The method we just defined inside our aspect - beforeExecution() - is annotated with @Before. This annotation contains 
  a pointcut that determines the advice to be executed before simpleMethod from the Spring service we defined earlier gets
  called. The JoinPoint parameter passed into the advice contains all the information about the Service method being intercepted.*/

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {
	@Before("execution(* com.java.springaop.service.ExampleService.simpleMethod(..))")
	   public void beforeExecution(JoinPoint jp) {
			    System.out.println("Before method: " + jp.getSignature().getName()
			        + ". Class: " + jp.getTarget().getClass().getSimpleName());
        }
	 @AfterReturning(
			   pointcut = "execution(* com.java.springaop.service.ExampleService.methodReturnsValue(..))",
			   returning = "result"
			  )
			  public void afterReturningExecution(JoinPoint jp, Object result) {
			    System.out.println("After returning method: "
			      + jp.getSignature().getName() + ". Class: "
			      + jp.getTarget().getClass().getSimpleName());
			      System.out.println("Result returned: " + result);
			  }		
	 @AfterThrowing(
			   pointcut = "execution(* com.java.springaop.service.ExampleService.methodThrowsException(..))",
			   throwing = "ex"
			  )
			  public void afterThrowingExecution(JoinPoint jp, Exception ex) {
			    System.out.println("After throwing method: "
			        + jp.getSignature().getName() + ". Class: "
			        + jp.getTarget().getClass().getSimpleName());
			    System.out.println("Exception: " + ex.getMessage());
			  }
	 @After(
			  "execution(* com.java.springaop.service.ExampleService.simpleMethodAnother(..))"
			  )
			  public void afterExecution(JoinPoint jp) {
			    System.out.println("After method: " + jp.getSignature().getName()
			        + ". Class: " + jp.getTarget().getClass().getSimpleName());
			  }
	 @After("execution(* com.java.springaop.service.ExampleService.showData(..)) && args(String,..)")
	   public void showDataExecution(JoinPoint jp) {
			    System.out.println("After Method: " + jp.getSignature().getName()
			        + ". Class: " + jp.getTarget().getClass().getSimpleName());
      }
	 
	 @Before(value = "com.java.springaop.pointcut.PointCutDefinition.serviceLayer() && "
			    + "args(account,..)")
			  public void beforeAccountMethodExecution(Account account) {
			    System.out.println("Logging account access. Account: "
			      + account.getAccountNumber());
			  }
	 
}
