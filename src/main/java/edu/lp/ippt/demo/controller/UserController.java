package edu.lp.ippt.demo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.lp.ippt.demo.domain.User;
import edu.lp.ippt.demo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostConstruct
	public void init() {
		// you can run some initialization logic here
	}

	@RequestMapping("/users")
	public @ResponseBody List<User> getUsers(){
		return userService.getUsers();
	}
	
	@RequestMapping("/users/{id}")
	public @ResponseBody User getUser(@PathVariable Integer id){
		// check if id is valid
		// check if user exists
		// transform errors/warnings if required
		
		return userService.getUser(id);
	}
	
	@RequestMapping(value = "/users/", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
		
		//return new user id / or user object
	}
	
	@RequestMapping(value = "/users/", method = RequestMethod.PUT)
	public void updateUser(@RequestBody User user) {
		//validate input 
		//check if existing user
		
		userService.updateUser(user);
				
		//send success/error response
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Integer id) {
		//validate input 
		userService.deleteUser(id);
		
		//send success/error response
	}
	
	
}
