package com.in28mins.rest.webservices.restfulwebservices.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.in28mins.rest.webservices.restfulwebservices.bean.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<User>();
	private static Integer usercount = 4;
	
	static {
		users.add(new User(1,"John", new Date()));
		users.add(new User(2,"Avinash", new Date()));
		users.add(new User(3,"Kiran", new Date()));
		users.add(new User(4,"Neha", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) {
			user.setId(++usercount);
		}
		users.add(user);
		return user;
	}
	
	public User findone(int id) {
		for(User user:users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
