package com.Airbus.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Airbus.Dao.UserDao;
import com.Airbus.entity.User;


@Service
@Transactional
public class UserService {
	
	@Autowired
	UserDao userdao;
	
	public User addUser(User user) {
	    
	    	return userdao.save(user);
	}


	public List<User> findAllUsers() {
	    return userdao.findAll();
	}

	public User updateUser(User user) {
		Optional<User> prevuser=userdao.findById(user.getUserId());
		User usr=prevuser.get();
		user.setUsername(usr.getUsername());
		user.setUserpassword(usr.getUserpassword());
		user.setUserphonenumber(usr.getUserphonenumber());
	    return userdao.save(user);
	}

}
