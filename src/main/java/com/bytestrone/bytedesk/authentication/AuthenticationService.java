package com.bytestrone.bytedesk.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bytestrone.bytedesk.config.JwtService;
import com.bytestrone.bytedesk.model.UserModel;
import com.bytestrone.bytedesk.repository.UserRepo;

@Service
public class AuthenticationService {
	@Autowired
	private UserRepo userRepo;


	@Autowired
	private JwtService jwtService;

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		UserModel user = userRepo.findByUserName(request.getUserName()).orElseThrow();
		if (user.getPassword().equals(request.getPassword())) {
			var jwtToken = jwtService.generateToken(user);
			var userName = user.getUserName();
			var imageUrl = user.getImage();
			var salutation = user.getSalutation();
			var userId = user.getUserId();
			var department = user.getDepartment();
			UserModel loginUser = new UserModel();	
			loginUser = userRepo.findByUserId(userId);
			loginUser.setJwtToken(jwtToken);
			userRepo.save(loginUser);

			AuthenticationResponse response1 = new AuthenticationResponse();
			response1.setToken(jwtToken);
			response1.setImage(imageUrl);
			response1.setUserName(userName);
			response1.setSalutation(salutation);
			response1.setUserId(userId);
			response1.setDepartment(department);
			return response1;
		} else {
			return null;
		}

	}


}
