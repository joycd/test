package cn.jsu.cd.service.impl;

import java.util.Vector;

import cn.jsu.cd.dao.MtypeDao;
import cn.jsu.cd.dao.impl.MtypeDaoImpl;
import cn.jsu.cd.service.MtypeService;
import cn.jsu.cd.vo.Mtype;

public class MtypeserviceImpl implements MtypeService{
	MtypeDao dao=new MtypeDaoImpl();
	@Override
	public void add(Mtype mt) {
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
