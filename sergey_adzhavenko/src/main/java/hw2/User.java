package hw2;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class User implements Serializable{

	private String login;
	private String pass;
	private String name;
	private GregorianCalendar dateOfExpire;
	
	public User(String login, String pass, String name, GregorianCalendar dateOfExpire) {
		this.setLogin(login);
		this.setPass(pass);
		this.setName(name);
		this.setDateOfExpire(dateOfExpire);
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateOfExpire() {
		return dateOfExpire.get(Calendar.DAY_OF_MONTH) + "," + dateOfExpire.get(Calendar.MONTH) + "," + dateOfExpire.get(Calendar.YEAR);
	}

	public void setDateOfExpire(GregorianCalendar dateOfExpire) {
		this.dateOfExpire = dateOfExpire;
	}
    @Override
    public String toString(){
        return this.login+" "+this.pass+" "+this.name+" " + getDateOfExpire();
    }

}
