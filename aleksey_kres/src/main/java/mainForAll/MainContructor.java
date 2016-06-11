package mainForAll;

import dao.ContructorDaoImpl;
import domain.Contructor;


	public class MainContructor {
		public static void main(String[] args) {
		ContructorDaoImpl contImpl = new ContructorDaoImpl();
		Contructor contructor = new Contructor("TOB XXxXX");
//		Contructor contructor = new Contructor(); 
		contructor.setId(4L);
//		contImpl.create(contructor);
//		contImpl.delete(contructor);
//		contImpl.update(contructor);
//		System.out.println(contImpl.read(4L));
//		for(Contructor i : contImpl.findAll()) {
//			System.out.println(i);
//		}
		for(Contructor i : contImpl.findContructorsByBeginString("t")) {
			System.out.println(i);
		}
		
		}
	}


