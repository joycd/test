package cn.jsu.cd.service;

import cn.jsu.cd.vo.User;

public interface UserService {

	void addUser(User user);
	
	int getNewId();
	
	User serchId(int id);
	
	void delete(String sql);
	
	void In(String idname,String username,String time);
}
