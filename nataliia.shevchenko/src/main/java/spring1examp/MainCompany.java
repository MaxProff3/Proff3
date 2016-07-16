package spring1examp;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainCompany {
	public static void main(String[] args) {
		
//		Scanner scan = new Scanner(System.in);
//		if(scan.hasNext()){
//			scan.nextLine();
//		}
		ApplicationContext context = new ClassPathXmlApplicationContext("spring1examp/cofig1.xml");

		Company comapany = (Company) context.getBean("idCompany");//указываем id нашего bean-а
        System.out.println(comapany);
        
        Human human = (Human) context.getBean("idHumanName");
        System.out.println(human);
                
        Car car = (Car) context.getBean("idCarModel");
        System.out.println(car);
	}

}
