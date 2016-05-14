package FirstWeek;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Base {
	Set<User> set = new HashSet<User>();
	ArrayList<User>list = new ArrayList<User>();
	
	Base (){
		set.add(new User("yurash","yura"));
		set.add(new User("alex","222"));
		set.add(new User("Step","yura"));
		set.add(new User("Andy","222"));
	}
	

	public boolean auth(String login, String pass){
		for(User user:set){
			if(user.equals(new User(login,pass))) {
				System.out.println("Такой пользователь имеется");
				return true;
			}
			}
		System.out.println("Пользователь отсутствует");
		return false;
	}
	
	public void userToFile(String fileName){
		File file = new File(fileName);
		if(file.exists()){
			System.out.println("Файл существует");
		}
		if(!file.exists()){
			System.out.println("Файл не  существует");
			try{
				file.createNewFile();
				System.out.println("Создан новый файл : "+file.getName());
			}
			 catch(IOException e) {
				 System.err.println(e);
				 }
		}
		try{
		FileWriter fw =new FileWriter(file);
		for (User user : set){
			fw.write(user.toString()+"\r\n");
			//\r\n - это специально принято для Windows перенос строки;
		}
		fw.close();
		}catch(IOException e){
			System.err.println("ошибка файла: " + e);
		}
		
	
	}
	/*
	public User[] userFromFile(String fileName) throws FileNotFoundException{
		File f=new File(fileName);
		User u=null;
		if(f.exists()){
			FileInputStream fis=new FileInputStream(f);
			Scanner sc=new Scanner(fis);
			while(true){
				
				
			}
			
			
		
	}
	}
	*/
	public void usersSerializeToFile(String fileName){
		File f=new File(fileName);
		if(f.exists()){
			try{
			ObjectOutputStream ostream =
					new ObjectOutputStream(
					new FileOutputStream(f));
			for(User u: set){
			ostream.writeObject(u);
		
			}
			ostream.flush();
			ostream.close();
			}catch(IOException e){
				System.err.println("ошибка файла: " + e);
			}
		}if(!f.exists()){
			System.out.println("Файл не  существует");
			try{
				f.createNewFile();
				System.out.println("Создан новый файл : "+f.getName());
			}
			 catch(IOException e) {
				 System.err.println(e);
				 }
		}
	}
	
	public Set<User> usersDeSerializeFromFileHash(String fileName) throws ClassNotFoundException, IOException{
		File f=new File(fileName);
		User u=null;
		if(f.exists()){
			FileInputStream fis=new FileInputStream(f);
			ObjectInputStream is=new ObjectInputStream(fis);
	
			while(true){
				try{
				 u=(User) is.readObject();
				 set.add(u);
				 
				}catch(EOFException e){
					break;
				}
				is.close();
				
			}
		}
	
		for(User u1:set){
			System.out.println(u1);
		}
		
		
		return set;
	}
	
	
	public User[] usersDeSerializeFromFileArray(String fileName) throws ClassNotFoundException, IOException{
		File f=new File(fileName);
		User u=null;
		if(f.exists()){
			FileInputStream fis=new FileInputStream(f);
			ObjectInputStream is=new ObjectInputStream(fis);
	
			while(true){
				try{
				 u=(User) is.readObject();
				 set.add(u);
				 
				}catch(EOFException e){
					break;
				}
				
			}
			is.close();
		}
	
	User[] us= new User[set.size()];
	Iterator<User> it=set.iterator();
	for(int k=0;k<us.length;k++){
		us[k]=it.next();
	}
		for(int j=0;j<us.length;j++){
			System.out.println(us[j]);
		}
		
		return us;
	}
	

}
