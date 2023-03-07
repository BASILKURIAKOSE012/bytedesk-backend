package com.bytestrone.bytedesk.service;

import org.springframework.stereotype.Service;


import com.bytestrone.bytedesk.model.UserModel;

@Service
public interface UserService {

	UserModel getLoginUser(UserModel userData);


}
