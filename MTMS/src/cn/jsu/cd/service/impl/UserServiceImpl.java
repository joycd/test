package cn.jsu.cd.service.impl;

import java.io.File;
import java.io.FileOutputStream;

import cn.jsu.cd.dao.UserDao;
import cn.jsu.cd.dao.impl.UserDaoImpl;
import cn.jsu.cd.service.UserService;
import cn.jsu.cd.vo.User;

public class UserServiceImpl implements UserService {
	private UserDao dao = new UserDaoImpl();
	@Override
	public void addUser(User user) {
	 dao.add(user);
		
	}
	@Override
	public int getNewId() {
		return dao.getNewId();
	}
	@Override
	public User serchId(int id) {
		
		return dao.seachID(id);
	}
	@Override
	public void delete(String sql) {
		dao.delete(sql);
		
	}
	@Override
	public void In(String idname, String username, String time) {
		File file =new File("./src/logs.txt");
		FileOutputStream fo;
		try {
			fo = new FileOutputStream(file,true);
			
			String ans="ID为"+idname+"的用户:"+username+"于"+time+"成功登陆\r\n";
			fo.write(ans.getBytes());
			fo.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
