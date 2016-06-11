package hwAction12;

import java.util.List;

import dao.ContructorDaoImpl;
import domain.Contructor;
import service.ContructorServiceImpl;

public class MainTestContructor {
	
	public static void main(String[] args) {
		
		
		ContructorDaoImpl contructorDaoImpl = new ContructorDaoImpl(); 
		
		ContructorServiceImpl contructorServiceImpl = new ContructorServiceImpl(contructorDaoImpl);
		
		contructorServiceImpl.addNewContructor(new Contructor(new Long(4),"Terra Food"));
			
		
		List<Contructor> contructor = contructorServiceImpl.getAllContructors();
		
		for (Contructor c:contructor){
			
			System.out.println(c);
			
		}
		
	}

}
