package hw_mayskie_prazdniki.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

//������� ������ Base, User,MainBase
//- Base(Set<User>) 
//- User(String login, String pass)
//� ������������ Base �������� ��������� �������������.
//� ����� Base �������� ����� 
//boolean auth(String login, String pass)
//� ������� ������ MainBase ������� ������ ������ Base � ������� ������� ����� � ������, ���������� ���� �� ����� ������������.

import java.util.Set;

public class Base {
	
	private static Set<User> base = new HashSet<User>();
	
	public static void add(User user){
		
		if (!auth(user.getLogin(),user.getPass())) 
			
			base.add(user);
		
	}
	
	
	public static boolean auth(String login,String pass){
		
		
		  Iterator<User> iter = base.iterator();
		  
		  while(iter.hasNext()){	    
			  
			 if (iter.next().getLogin().equals(login)) return true;
			 else return false;
			  
		  }
		
		  return false;	

	}
	
	public static void usersToFile(String fileName) throws IOException{
		
		
		FileWriter fw = new FileWriter(fileName);
		
		for (User user:base){
			
			fw.write(""+user+"\n");
			
		}	
		
		fw.close();
	}
	
	public static User[] usersFromFile(String fileName) throws FileNotFoundException, ParseException{	
		
		  FileReader fr = new FileReader(fileName);
		  Scanner scan = new Scanner(fr);
		  ArrayList<User> arrUser = new ArrayList<User>(); 
		  
		  while (scan.hasNextLine()){
		  	  
			  String name="";
			  String login="";
			  String pass="";
			  GregorianCalendar dateOfExpire = new GregorianCalendar();
			  
			  String str = scan.nextLine();
			  
			  String[] mass = str.split(";");
			  
			  for (int i=0;i<mass.length;i++){
				  
				  String[] massLower = mass[i].split(":");
				  
				  for (int j=0;j<massLower.length;j++){
					  
					  if (i==0 && j==1) {name=massLower[j];}
					  
					  if (i==1 && j==1) {
						  	
					 SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy"); 
					 Date date = format.parse(massLower[j]);
					 dateOfExpire = new GregorianCalendar();
					 dateOfExpire.setTime(date);
					 
					 }
					  
					  
					  if (i==2 && j==1) {login=massLower[j];}
					  if (i==3 && j==1) {pass=massLower[j];}
					  
					  
				  }
				  
				  
				  
			  }
			  
			  
			  User user = new User(name,pass,login,dateOfExpire); 
			  Base.add(user);
			  
			  arrUser.add(user);
			  
		  }
		
		  
		User[] users = new User[arrUser.size()];
		
		for (int l=0;l<users.length;l++){
			
			users[l] = arrUser.get(l);
		}
		  
		return users;
		
	}
	
	public static void usersSerializeToFile(String fileName) throws IOException{
		
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        
        for (User user:base){
        	
        	try {
              oos.writeObject(user);}
        	
            catch (IOException e){};      	
        	
        }
        
        try
        {oos.close();}
        catch (IOException e){};
		
	}
	
	public static User[] usersDeSerializeFromFile(String fileName) throws IOException, ClassNotFoundException{
		
		
		FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream oin = new ObjectInputStream(fis);
        
        ArrayList<User> users = new ArrayList<User>(); 
		
        User user;
        
        while (fis.available()>0){
        	
        	  user = (User) oin.readObject();
        	
        	  users.add(user);
        	  
        }
        
        User[] arrUsers = new User[users.size()]; 
        
        for (int i=0;i<arrUsers.length;i++){
        	
        	arrUsers[i] = users.get(i);
        	
        }
		
        return arrUsers;
	}

}
