package edu.lp.ippt.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.lp.ippt.demo.dao.impl.UserDaoImpl;
import edu.lp.ippt.demo.domain.User;
import edu.lp.ippt.demo.service.UserService;
import edu.lp.ippt.demo.service.impl.UserServiceImpl;

@Controller
public class UserController {
	
	private UserService service;
	
	@PostConstruct
	public void init() {
		service = new UserServiceImpl(new UserDaoImpl());
	}

	@RequestMapping("/users")
	public @ResponseBody List<User> getUsers(){
		return service.getUsers();
	}
	
	//...
}
