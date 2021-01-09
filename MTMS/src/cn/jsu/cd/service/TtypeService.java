package cn.jsu.cd.service;

import java.util.Vector;

import cn.jsu.cd.vo.Ttype;

public interface TtypeService {
void add(Ttype mt);
	
	Vector<Vector> searchById(int id);
	
	Vector<Vector> searchAll(String sql);
}
