package edu.lp.ippt.demo.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import edu.lp.ippt.demo.dao.UserDao;
import edu.lp.ippt.demo.domain.User;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User getUser(int id) {
		return jdbcTemplate.queryForObject("select * from user where id = " + id, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> getUsers() {
		// add roles for each user using subquery or joined query
		return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public void createUser(User user) {
		// TODO Auto-generated method stub
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}
	

}
