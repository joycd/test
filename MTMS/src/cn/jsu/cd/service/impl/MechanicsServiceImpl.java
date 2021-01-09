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
		
		  Workbook workbook=new XSSFWorkbook();//创建工作簿对象
		  Sheet sheet = workbook.createSheet("test1");//创建工作表对象
		  for(int i=0;i<vec.size();i++){
			  Row row = sheet.createRow(i);// 创建行对象，下标从0开始
			  for(int j=0;j<vec.get(i).size();j++){
				    Cell cell = row.createCell(j);//创建单元格，从0开始
				    cell.setCellValue(vec.get(i).get(j)+"");//单元格设置内容
			  }
		  }
		  
		 FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);//将内容写入到指定的excel文档
		  fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//创建输出流对象
		  
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
