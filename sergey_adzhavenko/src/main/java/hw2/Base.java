package hw2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class Base implements Serializable{

	Set<User> set = new HashSet<>();
	
	public Base() {
		set.add(new User("user1","1111", "Nick", new GregorianCalendar(2018,11,22)));
		set.add(new User("user2","22222","Tom", new GregorianCalendar(2017,04,18)));
		set.add(new User("user3","233434","Bob", new GregorianCalendar(2018,11,16)));
		set.add(new User("user4","sdfvg43","Charly", new GregorianCalendar(2018,11,16)));
		set.add(new User("user5","99090","Rocky", new GregorianCalendar(2018,01,17)));
	}


	public boolean auth(String login, String pass){
		Iterator<User> iter = set.iterator();
		User hasUser = null;
		while(iter.hasNext()){
			hasUser = iter.next();
			if(hasUser.getLogin().equals(login)){
				if(hasUser.getPass().equals(pass)){
					System.out.println("�� �����!");
					return true;}
				break;
			}
		}
		System.out.println("�������� ����� ��� ������!");
		return false;
	}
	
	public void usersSerializeToFile(String fileName) throws Exception{
		
		FileOutputStream fileLocation = new FileOutputStream(fileName);
		ObjectOutputStream send = new ObjectOutputStream(fileLocation);
		try{
			send.writeObject(set);
		}catch(Exception e){e.printStackTrace();}
		finally {
		    send.close();
		   }
	}
	@SuppressWarnings("unchecked")
	public User[] usersDeSerializeFromFile(String fileName) throws Exception{
		Set<User> gotenSet=null;
		FileInputStream fileLocation = new FileInputStream(fileName);
		ObjectInputStream recive = new ObjectInputStream(fileLocation);
		
		try{
			gotenSet=(Set<User>)recive.readObject();
		}catch(Exception e){e.printStackTrace();}
		finally {
		    recive.close();
		   }
		Iterator<User> iter = gotenSet.iterator();
		User[] users = new User[gotenSet.size()];
		int index=0;
		while(iter.hasNext()){
			users[index]=iter.next();
			index++;
			}
		return users;
	}
	
	public void usersToFile(String fileName) throws Exception{
		FileWriter wr = new FileWriter(fileName);
		Iterator<User> iter = set.iterator();
		while(iter.hasNext()){	
			wr.write(iter.next().toString() + "\n");
			}
		wr.close();
	}
	public User[] usersFromFile(String fileName) throws Exception{
		ArrayList<User> list = new ArrayList<>();
		FileReader reader = new FileReader(fileName);
		Scanner sc = new Scanner(reader);
		String login = null,pass = null,name = null,date=null;
		int index=1;
		while(sc.hasNext()){
			String day = "";
			String month = "";
			String year = "";
			switch(index){
			case(1): login = sc.next();
				break;
			case(2): pass = sc.next();
				break;
			case(3): name = sc.next();
				break;
			case(4): date = sc.next();
			int turn = 0;
			for(int k =0; k < date.length(); k++){
				if(turn==0){
					if(date.charAt(k)!=','){
						day=day+date.charAt(k);
					}
					else{
						turn=1;
					}
				}
				else if(turn==1){
					if(date.charAt(k)!=','){
						month=month+date.charAt(k);
					}
					else{
						turn=2;
					}
				}
				else{
					year=year+date.charAt(k);
				}
				
			}
				break;
			}
			index++;
			if(index==5){
			index=1;
			list.add(new User(login,pass,name,new GregorianCalendar(Integer.parseInt(year),Integer.parseInt(month),Integer.parseInt(day))));
			}
		}
		reader.close();
		User[] users = list.toArray(new User[list.size()]);
		return users;
	}
}
