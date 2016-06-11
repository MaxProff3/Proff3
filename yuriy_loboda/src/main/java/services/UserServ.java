package services;

import domain.User;

public interface UserServ {
	void addNewUser( User user);
	void updateUser( User user);
	void deleteUser( User user);
	User read(Long id);
	boolean getUser(String login,String pass);

}
