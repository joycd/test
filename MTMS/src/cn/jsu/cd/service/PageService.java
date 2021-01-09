package cn.jsu.cd.service;

import java.util.Vector;

public interface PageService {
	int getPage (int pageCount,int record);
	int nextPage(int pageNum,int page);
	int prePage(int pageNum,int page);
	Vector<Vector> getPaegData(Vector<Vector> bigList, int pageNum,int pagecount);
}
