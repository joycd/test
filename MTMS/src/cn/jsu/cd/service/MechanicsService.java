package cn.jsu.cd.service;

import java.io.File;
import java.util.Vector;

import cn.jsu.cd.vo.Mechanics;

public interface MechanicsService {
	void add(Mechanics m);
	
	void delete(int id);
	
	void updata(String sql);
	
	boolean searchId(int id);
	
	int getNewId();
	
	void excleIn(Vector<Vector>  vec,File file);
	
	Vector<Vector> searchById(int id);
	
	Vector<Vector> searchAll(String sql);
}
