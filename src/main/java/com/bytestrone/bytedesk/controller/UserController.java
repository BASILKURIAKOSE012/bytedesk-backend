package com.bytestrone.bytedesk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bytestrone.bytedesk.model.UserModel;
import com.bytestrone.bytedesk.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	// to check the login credentials

	@PostMapping("/login")
	public ResponseEntity<UserModel> loginUser(@RequestBody UserModel userData) {
		UserModel user = userService.getLoginUser(userData);
		if (user!=null) {
			return new ResponseEntity<>(user,HttpStatus.OK);
		} else {
			return (ResponseEntity<UserModel>) ResponseEntity.internalServerError();
		}
	}
}
