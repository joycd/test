package cn.jsu.cd.service;

import java.util.Vector;

import cn.jsu.cd.vo.Mtype;

public interface MtypeService {
	void add(Mtype mt);
	
	Vector<Vector> searchById(int id);
	
	Vector<Vector> searchAll(String sql);
}
