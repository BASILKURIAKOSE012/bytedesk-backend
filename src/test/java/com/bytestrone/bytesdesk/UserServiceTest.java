package com.bytestrone.bytesdesk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.bytestrone.bytedesk.model.UserModel;
import com.bytestrone.bytedesk.repository.UserRepo;
import com.bytestrone.bytedesk.service.UserService;
import com.bytestrone.bytedesk.serviceimpl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = UserServiceImpl.class)
 class UserServiceTest {
	@Autowired
	private UserService userService;
	@MockBean
	private UserRepo userRepo;

	

	@Test
	@DisplayName("test login user")
	void userLoginTestSuccess() {
		UserModel newUser = new UserModel();
		newUser.setUserId("TID1000");
		newUser.setPassword("12345");
		when(userRepo.findByUserId("TID1000")).thenReturn(newUser);
		UserModel login = userService.getLoginUser(newUser);
		assertEquals(login.getUserId(),newUser.getUserId());
		verify(userRepo, times(1)).findByUserId("TID1000");

	}
	
	
	
}
