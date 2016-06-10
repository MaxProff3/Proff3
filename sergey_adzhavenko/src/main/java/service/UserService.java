package service;

import java.util.List;

import domain.User;

public interface UserService {

	void addNewUser(User user);
	void addNewUsers(User[] users);
	void updateUser(User user);
	void deleteUser(User user);
	User read(Long id);
	List<User> getAllUsers();
}
