package spring2examp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainServerClient {
	public static void main(String[] args) {
		
			ApplicationContext context = new ClassPathXmlApplicationContext("spring2examp/config.xml");
			
			Start server = (Start)context.getBean("server");// normal
			server.start();
			
			Start client = (Start)context.getBean("client");// normal
			client.start();
			
			Start client2 = (Start)context.getBean("client");// normal
			client2.start();
		}
	

}
