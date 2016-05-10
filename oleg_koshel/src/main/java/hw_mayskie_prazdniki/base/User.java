package base;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class User implements Serializable {
	
	String login;
	String pass;
	
	String name;
	GregorianCalendar dateOfExpire;
	
	User(String login,String pass,String name,GregorianCalendar dateOfExpire){
		
		this.login = login;	
		this.pass = pass;
		this.name = name;
		this.dateOfExpire = dateOfExpire;
	}
	
	User(String login,String pass){
		
		this.login = login;	
		this.pass = pass;

	}
	
	 @Override
	 public int hashCode(){	 
		 return login.hashCode();
	 }
	 
	 @Override
	 public String toString(){
		 
		 SimpleDateFormat formatDate = new SimpleDateFormat("dd-M-yyyy");
		 
		 return "Name:"+name+";DateOfExpire:"+formatDate.format(dateOfExpire.getTime())+";Login:"+getLogin()+";Pass:"+getPass();
		 
	 }
	
//	@Override
//	public boolean equals(String login){
//		
//			if (this.getLogin().equals(login)){
//				return true;
//			} else return false;
//		
//	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
