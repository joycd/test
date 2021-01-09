package cn.jsu.cd.dao;

import java.util.Vector;

import cn.jsu.cd.vo.Mechanics;

public interface MechanicsDao {
void add(Mechanics s);
	
	void delete(int id);

	void updata(String sql);
	
	int getNewId();
	
	Vector<Vector> searchById(int id);
	
	Vector<Vector> searchAll(String sql);

}
