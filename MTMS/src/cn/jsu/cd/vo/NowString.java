package cn.jsu.cd.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowString {
	  public String getTime() { 
          SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
          System.out.println(df.format(new Date()));
          return df.format(new Date());// new Date()为获取当前系统时间
    }
}
