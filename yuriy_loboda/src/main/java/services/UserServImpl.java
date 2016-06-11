package services;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;

public class UserServImpl implements UserServ {
	private UserDao dao = new UserDaoImpl(); 
	
	public UserServImpl(UserDao dao) {
		this.dao=dao;
	}
	@Override
	public void addNewUser(User user) {
		dao.create(user);
		
	}

	@Override
	public void updateUser(User user) {
		dao.update(user);
		
	}

	@Override
	public void deleteUser(User user) {
		dao.delete(user);
		
	}

	@Override
	public User read(Long id) {
		return dao.read(id);
	}
	@Override
	public boolean getUser(String login, String pass) {
		return dao.findUserByLoginAndPass(login, pass);
	}
	
}
