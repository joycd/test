package cn.jsu.cd.service.impl;

import java.util.Vector;

import cn.jsu.cd.dao.MechanicsDao;
import cn.jsu.cd.dao.TransportDao;
import cn.jsu.cd.dao.impl.MechanicsDaoImpl;
import cn.jsu.cd.dao.impl.TransportDaoImpl;
import cn.jsu.cd.service.TransportService;
import cn.jsu.cd.vo.Mechanics;
import cn.jsu.cd.vo.Transport;

public class TransportServiceImpl implements TransportService{
	TransportDao dao=new TransportDaoImpl();

	@Override
	public void add(Transport m) {
		dao.add(m);
	}
	
	@Override
	public Vector<Vector> searchById(int id) {
		
		return dao.searchById(id);
	}


	@Override
	public int getNewId() {
		
		return dao.getNewId();
	}

	@Override
	public Vector<Vector> searchAll(String sql) {
		
		return dao.searchAll(sql);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
		
	}

	@Override
	public void updata(String sql) {
		dao.updata(sql);
		
	}

}
