package cn.jsu.cd.service.impl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.jsu.cd.dao.MechanicsDao;
import cn.jsu.cd.dao.impl.MechanicsDaoImpl;
import cn.jsu.cd.service.MechanicsService;
import cn.jsu.cd.vo.Mechanics;

public class MechanicsServiceImpl implements MechanicsService{
	MechanicsDao dao=new MechanicsDaoImpl();

	@Override
	public void add(Mechanics m) {
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

	@Override
	public void excleIn(Vector<Vector> vec,File file) {
		
		  Workbook workbook=new XSSFWorkbook();//��������������
		  Sheet sheet = workbook.createSheet("test1");//�������������
		  for(int i=0;i<vec.size();i++){
			  Row row = sheet.createRow(i);// �����ж����±��0��ʼ
			  for(int j=0;j<vec.get(i).size();j++){
				    Cell cell = row.createCell(j);//������Ԫ�񣬴�0��ʼ
				    cell.setCellValue(vec.get(i).get(j)+"");//��Ԫ����������
			  }
		  }
		  
		 FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);//������д�뵽ָ����excel�ĵ�
		  fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�������������
		  
	}

	@Override
	public boolean searchId(int id) {
		Vector<Vector> vec=searchById(id);
		if(vec.size()==0)
		return false;
		else 
			return true;
	}

	
}
