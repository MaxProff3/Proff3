package homework06;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.HibernateException;
import org.junit.Before;
import org.junit.Test;

import dao.test.ContructorDao;
import dao.test.ContructorDaoImpl;
import domain.Contructor;
import services.test.ContructorServImpl;
import services.test.ContructorServ;

public class ContructorTest {
		
	private ContructorDao dao =null;
	private ContructorServ serv = null;
	
	@Before
	public void init(){
		dao=new ContructorDaoImpl();
		serv=new ContructorServImpl(dao);
		
	}
	
	@Test
	public void test_insert() {
		int i=serv.getCount();
		serv.addNewContr(new Contructor("Yunga"));
		int k=serv.getCount();
		assertEquals(6, k);
		
	}
	
	
	@Test
	public void test_read(){
		assertEquals("Forsag", serv.read(4l).toString());	
	}
	
	@Test
	public void test_update(){
		Contructor con = serv.read(4l);
		con.setName("Forsag-4");
		serv.updateContr(con);
		assertEquals("Forsag-4", serv.read(4l).toString());
	}
	@Test(expected=IllegalArgumentException.class)
	public void test_delete(){
		Contructor c=serv.read(4l);
		serv.deleteContr(c);
		serv.read(4l);
	}
	@Test
	public void test_find_All(){
		serv.addNewContr(new Contructor("Forsage-1"));
		serv.addNewContr(new Contructor("Forsage-2"));
		serv.addNewContr(new Contructor("Forsage-3"));
		serv.addNewContr(new Contructor("Forsage-4"));
		serv.addNewContr(new Contructor("Forsage-5"));
		
		List<Contructor> list = serv.getAllProducts();
		
		assertEquals(serv.read(7l).toString(), list.get(5).toString());
		assertEquals(serv.read(8l).toString(), list.get(6).toString());
		assertEquals(serv.read(9l).toString(), list.get(7).toString());
		assertEquals(serv.read(10l).toString(), list.get(8).toString());
		assertEquals(serv.read(11l).toString(), list.get(9).toString());
	}

}
