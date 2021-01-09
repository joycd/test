package cn.jsu.cd.dao;

import java.util.Vector;

import cn.jsu.cd.vo.Mechanics;
import cn.jsu.cd.vo.Mtype;
import cn.jsu.cd.vo.Ttype;

public interface TtypeDao {
	
	void add(Ttype t);

	Vector<Vector> searchById(int id);

	Vector<Vector> searchAll(String sql);
}
