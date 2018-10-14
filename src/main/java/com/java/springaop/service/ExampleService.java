package com.java.springaop.service;

import org.springframework.stereotype.Service;

import com.java.springaop.aspects.Account;

//This class contains all the services which used by some other application

@Service
public class ExampleService {
	public void simpleMethod() {
	    System.out.println("Inside simpleMethod");
	  }
	
	public void simpleMethodAnother() {
	    System.out.println("Inside simpleMethodAnother");
	  }

	  public Object methodReturnsValue() {
	    System.out.println("Inside methodReturnsValue");
	    return new String("Hello from methodReturnsValue");
	  }

	  public void methodThrowsException() {
	    System.out.println("Inside methodThrowsException");
	    throw new RuntimeException("Exception from methodThrowsException");
	  }

	  public Object testAroundReturningResult() {
	    System.out.println("Inside testAroundReturningResult");
	    return new String("Hello from aroundReturningResult");
	  }

	  public void testAroundThrowingException() throws Exception {
	    System.out.println("Inside testAroundThrowingException");
	    throw new RuntimeException("Exception from testAroundThrowingException");
	  }
	  
	  public void showData(String name) {
		    System.out.println("Showing Data For:"+name);
		    
		  }
	  
	  public void updateAccountBalance(Account account, int amount) {
		    System.out.println("Inside updateAccountBalance(). Account: "
		      + account.getAccountNumber() + ", amount: " + amount);
		  }
}
