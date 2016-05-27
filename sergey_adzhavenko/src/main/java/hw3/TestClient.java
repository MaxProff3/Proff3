package hw3;

import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class TestClient {

	@Test
	public void test() {
		Set<Client> set = new HashSet<>();
		for(int i=0;i<1000;i++)set.add(Client.getInstancer());
		if(set.size()!=3)fail("set.size()!=3!!!");
	}
}
