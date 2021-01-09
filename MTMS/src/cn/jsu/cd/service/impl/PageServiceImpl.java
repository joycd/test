package cn.jsu.cd.service.impl;

import java.util.Vector;

import cn.jsu.cd.service.PageService;

public class PageServiceImpl implements PageService {

	
	@Override
	public int getPage(int pageCount, int record) {
		int page;
		if(record%pageCount==0) {
			 page=record/pageCount;
		}else {
			 page=record/pageCount+1;
		} 
		return page;
	}

	@Override
	public int nextPage(int pageNum, int page) {
		if(pageNum<page) {
			pageNum++;
		}else {
			pageNum=1;
		}
		return pageNum;
	}

	@Override
	public int prePage(int pageNum, int page) {
		if(pageNum>1) {
			pageNum--;
		}else {
			pageNum=page;
		}
		return pageNum;//返回上一页的数据
	}

	@Override
	public Vector<Vector> getPaegData(Vector<Vector> bigList, int pageNum, int pagecount) {
		Vector<Vector> smallList=new Vector<Vector>();
		int record = bigList.size();//定义记录数为数据库中表的所有数据
		for (int i = (pageNum - 1) * pagecount; i < pageNum * pagecount && i < record; i++) {//取得当前页数的记录，curentPageIndex当前页数，countPerpage每页显示的记录数
			smallList.add(bigList.get(i));//将记录加入到小集合中
		}
		return smallList;//返回小集合（当前页的数据）
	}


}
