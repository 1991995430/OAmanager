package com.offcn.mapper;

import java.util.List;

import com.offcn.pojo.User;

public interface UserMapper {
	public List<User> selectUserList() throws Exception;
	public Integer addUser(User user) throws Exception;
}
