package hw6;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import dao.ContructorDAO;
import dao.ContructorDaoImpl;
import domain.Contructor;
import service.ContructorServiceImpl;
import util.HibernateUtil;

public class TestAdd5Contructors {

	private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Session session = null;
	
	@Test
	public void test() {
		Locale.setDefault(Locale.ENGLISH);
		ContructorDAO cDAO = null;
		ContructorServiceImpl cService = null;
		ArrayList<Contructor> list = new ArrayList<>();
		List<Contructor> listDB;
	try{
		session = sessionFactory.openSession();
		cDAO = new ContructorDaoImpl(sessionFactory);
		cService = new ContructorServiceImpl(cDAO);
		
		for(int i = 1; i < 6; i++){
			list.add(new Contructor("name"+i));
			cService.addNewContructor(new Contructor("name"+i));
		}
		
		listDB = cService.getAllContructors();
		if(listDB.size() < 5)fail("List size < 5!");
		
		int count = 0;
		for(int i = 0; i < listDB.size();i++){
			for(int j = 0; j < list.size();j++){
				if(listDB.get(i).getConstructorName().equals(list.get(j).getConstructorName())){
					count++;
					System.out.println(count +". "+listDB.get(i));
					break;
				}
			}
		}
		if(count!=5)fail("Count != 5");
	}catch (HibernateException e) {
		fail("Error in catch!");
		e.printStackTrace();
	}finally {
		if (session != null) session.close();
		if (sessionFactory != null) sessionFactory.close();
		System.out.println("Session is closed!");
	}
	}

}
