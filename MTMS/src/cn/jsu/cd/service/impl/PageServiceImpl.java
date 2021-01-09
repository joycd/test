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
		return pageNum;//������һҳ������
	}

	@Override
	public Vector<Vector> getPaegData(Vector<Vector> bigList, int pageNum, int pagecount) {
		Vector<Vector> smallList=new Vector<Vector>();
		int record = bigList.size();//�����¼��Ϊ���ݿ��б����������
		for (int i = (pageNum - 1) * pagecount; i < pageNum * pagecount && i < record; i++) {//ȡ�õ�ǰҳ���ļ�¼��curentPageIndex��ǰҳ����countPerpageÿҳ��ʾ�ļ�¼��
			smallList.add(bigList.get(i));//����¼���뵽С������
		}
		return smallList;//����С���ϣ���ǰҳ�����ݣ�
	}


}
