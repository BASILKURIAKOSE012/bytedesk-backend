package com.bytestrone.bytesdesk;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import com.bytestrone.bytedesk.authentication.AuthenticationRequest;
import com.bytestrone.bytedesk.authentication.AuthenticationResponse;
import com.bytestrone.bytedesk.authentication.AuthenticationService;
import com.bytestrone.bytedesk.config.JwtService;
import com.bytestrone.bytedesk.model.UserModel;
import com.bytestrone.bytedesk.repository.UserRepo;

@SpringBootTest
@ContextConfiguration(classes = AuthenticationService.class)
 class AuthServiceTest {

	@Autowired
	private AuthenticationService authenticationService;
	@MockBean
	private JwtService jwtService;
	@MockBean
	private UserRepo userRepo;

	@Test
	@DisplayName("test authentication success")
	void loginAuthenticateSucces() {

		String userName = "testuser";
		String password = "testpassword";
		UserModel user = new UserModel();
		user.setUserName(userName);
		user.setPassword(password);
		user.setImage("testimage");
		user.setSalutation("Mr.");
		user.setDepartment("testdepartment");
		user.setUserId("tid100");
		user.setJwtToken("itty");

		when(userRepo.findByUserName(userName)).thenReturn(Optional.of(user));
		when(jwtService.generateToken(user)).thenReturn("testtoken");

		AuthenticationRequest request = new AuthenticationRequest();
		request.setUserName(userName);
		request.setPassword(password);
		when(userRepo.findByUserId(user.getUserId())).thenReturn(user);
		AuthenticationResponse response = authenticationService.authenticate(request);

		assertEquals("testtoken", response.getToken());
		assertEquals("testuser", response.getUserName());
		assertEquals("testimage", response.getImage());
		assertEquals("Mr.", response.getSalutation());
		assertEquals("testdepartment", response.getDepartment());
		verify(userRepo, times(1)).findByUserName(userName);
		verify(jwtService, times(1)).generateToken(user);
	}

	@Test
	@DisplayName("test authentication failure")
	void loginAuthenticateFailure() {

		String userName = "testuser";
		String password = "testpassword";
		UserModel user = new UserModel();
		user.setUserName(userName);
		user.setPassword(password);
		user.setImage("testimage");
		user.setSalutation("Mr.");
		user.setDepartment("testdepartment");
		user.setUserId("tid100");
		user.setJwtToken("itty");

		when(userRepo.findByUserName(userName)).thenReturn(Optional.of(user));
		when(jwtService.generateToken(user)).thenReturn("testtoken");

		AuthenticationRequest request = new AuthenticationRequest();
		request.setUserName(userName);
		request.setPassword(password);
//		when(userRepo.findByUserId(user.getUserId())).thenReturn(user);
//		AuthenticationResponse response = authenticationService.authenticate(null);

		verify(userRepo, times(0)).findByUserName(userName);
		verify(jwtService, times(0)).generateToken(user);
	}

}
