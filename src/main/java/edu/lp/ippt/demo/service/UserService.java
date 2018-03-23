package edu.lp.ippt.demo.service;

import java.util.List;

import edu.lp.ippt.demo.domain.User;

public interface UserService {
	User getUser(int id);
	List<User> getUsers();
	void createUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
}
