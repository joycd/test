package cn.jsu.cd.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowString {
	  public String getTime() { 
          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
          System.out.println(df.format(new Date()));
          return df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
    }
}
