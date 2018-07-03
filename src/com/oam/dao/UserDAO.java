package com.oam.dao;

import com.oam.models.UserModel;

public interface UserDAO {
	public Integer addUser(UserModel userModel);
	public Integer updateUser(UserModel userModel);
	public Integer deleteUser(UserModel userModel);
	public UserModel getUserById(Integer userId);
	public UserModel getLoggedIn(UserModel userModel);
	public Integer validateEmail(String emailAddress);
}
