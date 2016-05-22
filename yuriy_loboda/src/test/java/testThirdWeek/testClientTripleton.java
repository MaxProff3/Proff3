package testThirdWeek;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FirstWeek.MyHashSet;
import ThirdWeek.Client;

public class testClientTripleton {
static Client cl1;
static Client cl2;
static Client cl3;
static Client cl4;
static Client cl5;
MyHashSet<Client> set;

static{
	cl1=Client.getInstance();
	cl2=Client.getInstance();
	cl3=Client.getInstance();
	cl4=Client.getInstance();
	cl5=Client.getInstance();
	
}

public MyHashSet getSet(){
	set = new MyHashSet<Client>();
	set.add(cl1);
	set.add(cl2);
	set.add(cl3);
	set.add(cl4);
	set.add(cl5);
	return set;
	
}

@Test
public void testIdentity(){
	assertFalse(cl1==cl2);
	assertFalse(cl2==cl3);
	assertTrue(cl3==cl4);
	assertTrue(cl4==cl5);
}

@Test
public void testCountOfObjects(){
	getSet();
	assertEquals(3, set.size());
//	System.out.println("CountofObjects");
}



}
