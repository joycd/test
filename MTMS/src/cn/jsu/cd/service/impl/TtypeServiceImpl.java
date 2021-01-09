package cn.jsu.cd.service.impl;

import java.util.Vector;

import cn.jsu.cd.dao.TtypeDao;
import cn.jsu.cd.dao.impl.TtypeDaoImpl;
import cn.jsu.cd.service.TtypeService;
import cn.jsu.cd.vo.Mtype;
import cn.jsu.cd.vo.Ttype;

public class TtypeServiceImpl implements TtypeService {
	TtypeDao dao=new TtypeDaoImpl();
	@Override
	public void add(Ttype mt) {
		dao.add(mt);
	}

	@Override
	public Vector<Vector> searchById(int id) {
		return dao.searchById(id);
	}

	@Override
	public Vector<Vector> searchAll(String sql) {
		return dao.searchAll(sql);
	}
}
