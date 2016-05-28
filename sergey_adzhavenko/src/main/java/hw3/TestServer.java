package hw3;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestServer {

	@Test
	public void test() {
		
		Set<Server> set = new HashSet<>();
		for(int i=0;i<1000;i++)set.add(Server.getInstancer());
		if(set.size()!=1)fail("set.size()!=1!");
		
		Server s = Server.getInstancer();
		Server s1 = Server.getInstancer();
		Server s2 = Server.getInstancer();
		
		if(s!=s1)fail("s!=s1!");
		if(!s.equals(s1))fail("!s.equals(s1)!");
		if(s!=s2)fail("s!=s2!");
		if(!s.equals(s2))fail("!s.equals(s2)!");
		if(s1!=s2)fail("s1!=s2!");
		if(!s1.equals(s2))fail("!s1.equals(s2)!");	
	}
}
