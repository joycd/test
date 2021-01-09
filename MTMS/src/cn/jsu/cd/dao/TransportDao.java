package cn.jsu.cd.dao;

import java.util.Vector;

import cn.jsu.cd.vo.Mechanics;
import cn.jsu.cd.vo.Transport;

public interface TransportDao {
	void add(Transport s);
	
	void delete(int id);

	void updata(String sql);
	
	int getNewId();
	
	Vector<Vector> searchById(int id);
	
	Vector<Vector> searchAll(String sql);
}
