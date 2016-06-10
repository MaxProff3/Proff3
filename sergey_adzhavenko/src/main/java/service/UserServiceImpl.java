package service;

import java.util.List;

import dao.UserDao;
import domain.User;

public class UserServiceImpl implements UserService{

	private UserDao userDao = null;
	
	public UserServiceImpl(UserDao userDao){
		this.userDao = userDao;
	}
	
	@Override
	public void addNewUser(User user) {
		userDao.create(user);
	}

	@Override
	public void addNewUsers(User[] users) {
		for(User user: users){
			userDao.create(user);
		}
	}

	@Override
	public void deleteUser(User user) {
		userDao.delete(user);
	}

	@Override
	public User read(Long id) {
		return userDao.read(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public void updateUser(User user) {
		userDao.update(user);
	}

}
