package comjava.springaop.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.springaop.service.ExampleService;
import com.java.sringaop.aspects.Account;
import com.java.sringaop.config.AppConfig;

public class TestClient {
	
	public static void main(String[] args) {
		
		ApplicationContext cntx=new AnnotationConfigApplicationContext(AppConfig.class);
		ExampleService srvc=cntx.getBean(ExampleService.class);
		
		System.out.println("........Start Calling Service...................");
		srvc.simpleMethod();
		System.out.println("...........................");
		srvc.methodReturnsValue();
		System.out.println("...........................");
		//srvc.methodThrowsException();
		System.out.println("...........................");
		srvc.simpleMethodAnother();
		
		System.out.println("...........................");
		srvc.showData("Rahat Ali");
		
		System.out.println("...........................");
		Account account=new Account();
		srvc.updateAccountBalance(account, 10000);
		
	}

}
