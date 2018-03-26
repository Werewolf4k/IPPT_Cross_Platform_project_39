package edu.lp.ippt.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.lp.ippt.demo.dao.UserDao;
import edu.lp.ippt.demo.domain.User;
import edu.lp.ippt.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	
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
		// check for collisions
		// return new user id
		dao.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		// check if existing user
		// do not overwrite readonly fields if any
		dao.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		// check if existing user
		dao.deleteUser(id);
	}

}
