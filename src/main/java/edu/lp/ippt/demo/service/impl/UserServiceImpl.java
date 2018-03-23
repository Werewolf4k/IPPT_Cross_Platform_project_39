package edu.lp.ippt.demo.service.impl;

import java.util.List;

import edu.lp.ippt.demo.dao.UserDao;
import edu.lp.ippt.demo.domain.User;
import edu.lp.ippt.demo.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao dao;
	
	public UserServiceImpl(UserDao dao) {
		this.dao = dao;
	}

	@Override
	public User getUser(int id) {
		return dao.getUser(id);
	}

	@Override
	public List<User> getUsers() {
		return dao.getUsers();
	}

	@Override
	public void createUser(User user) {
		dao.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		dao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);
	}

}
