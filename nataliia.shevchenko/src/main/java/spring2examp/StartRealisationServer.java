package spring2examp;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StartRealisationServer {
	
	@Pointcut("execution(* spring2examp.Start.start(..))")
    public void starting(){
		System.out.println("Does this message_server appear?");
		//System.out.println(class.getClass().getName() + " start work and ready to get new connection");
	}
	
	@Before("starting()")
	public void open(){
		System.out.println("Before: server tries to start work");
	}
	@After("starting()")
	public void close(){
		System.out.println("After: server close its work");
	}


}
