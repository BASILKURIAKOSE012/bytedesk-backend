package com.bytestrone.bytedesk.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.bytestrone.bytedesk.model.UserModel;
import com.bytestrone.bytedesk.repository.UserRepo;
import com.bytestrone.bytedesk.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepo userRepo;


	// to check the login

	@Override
	public UserModel getLoginUser(UserModel userData) {
		UserModel user = userRepo.findByUserId(userData.getUserId());
		if (user.getPassword().equals(userData.getPassword())) {
			return user;
		}
		return null;
	}


	

}
