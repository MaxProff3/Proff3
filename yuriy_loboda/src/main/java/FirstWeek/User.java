package FirstWeek;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

public class User implements Serializable{
	private String name;
	private String login;
	private String pass;
	private Calendar dateOfExpire;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getDateOfExpire() {
		return dateOfExpire;
	}

	public void setDateOfExpire(Calendar dateOfExpire) {
		this.dateOfExpire = dateOfExpire;
	}

	public User(String login, String pass) {
		this.login = login;
		this.pass = pass;
	}

	public User() {
	
	}

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
	
	@Override
	public boolean equals(Object obj){
		if(obj==this)//провер€ютс€ ссылки;
		return true;
		if (obj == null)
		return false;
		if(this.getClass()!=obj.getClass())
		return false;
		User user=(User)obj;
		if (this.login.equals(user.login) && this.pass.equals(user.pass))
		return true;
		return false;
	}
	
	
	

	
	

	@Override
	public String toString() {
		return "User [name=" + name + ", login=" + login + ", pass=" + pass + ", dateOfExpire=" + dateOfExpire + "]";
	}

	@Override
	public int hashCode(){
		return Objects.hash(name,login,pass,dateOfExpire);
	}
	
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}
	*/

}
