package cn.jsu.cd.dao;

import cn.jsu.cd.vo.User;
import java.util.Vector;

public interface UserDao {
	void add(User user);
	
	void delete(String sql);

	int getNewId();
	
	User seachID(int id);
	
}
