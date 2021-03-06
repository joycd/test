package cn.jsu.cd.dao;

import java.util.Vector;

import cn.jsu.cd.vo.Mechanics;
import cn.jsu.cd.vo.Mtype;

public interface MtypeDao {
	void add(Mtype mt);
	
	Vector<Vector> searchById(int id);
	
	Vector<Vector> searchAll(String sql);
}
