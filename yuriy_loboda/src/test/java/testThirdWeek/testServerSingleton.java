package testThirdWeek;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ThirdWeek.Server;

public class testServerSingleton {

	Server srv1;
	Server srv2;
	@Before
	public void init(){
		srv1=Server.getInstance();
		srv2=Server.getInstance();
	}
	@Test
	public void testIdentity(){
		assertTrue(srv1==srv2);
	}
	@Test
	public void testPasswordForServer(){
		srv1.setPass("0000");
		srv2.setPass("1111");
		assertEquals(srv1.getPass(), srv2.getPass());
		assertEquals(srv1.getPass(),"1111");
	}
	@Test
	public void testPasswordForServer_2(){
		srv1.setPass("0000");
		assertEquals("0000",srv2.getPass() );
	}
	
	

}
