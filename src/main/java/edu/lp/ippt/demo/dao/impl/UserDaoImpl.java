package edu.lp.ippt.demo.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.Document;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;

import edu.lp.ippt.demo.dao.UserDao;
import edu.lp.ippt.demo.domain.User;

public class UserDaoImpl implements UserDao{
	
	private MongoClient client;
	
	private ObjectMapper parser;
	
	public UserDaoImpl() {
		parser = new ObjectMapper();
		parser.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		client = new MongoClient("127.0.0.1:27017");
	}

	@Override
	public User getUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		List<Document> result = new ArrayList<>();
		client.getDatabase("ippt").getCollection("user").find().into(result);
		return result.stream().map(this::parse).collect(Collectors.toList());
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
	
	private User parse(Document document) {
		try {
			return parser.readValue(document.toJson(), User.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
