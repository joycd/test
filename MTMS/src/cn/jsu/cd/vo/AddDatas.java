package cn.jsu.cd.vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.jsu.cd.dbc.DatabaseConnection;
import cn.jsu.cd.dbc.DatabaseConnectionSql;

public class AddDatas{
	//定义姓氏
		private static String firstName="赵钱孙李周吴郑王冯陈褚卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闵席季麻强贾路娄危江童颜郭梅盛林刁钟徐邱骆高夏蔡田樊胡凌霍虞万支柯咎管卢莫经房裘缪干解应宗宣丁贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄魏加封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘钭厉戎祖武符刘姜詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲台从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍却璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庚终暨居衡步都耿满弘匡国文寇广禄阙东殴殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后江红游竺权逯盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于仲孙太叔申屠公孙乐正轩辕令狐钟离闾丘长孙慕容鲜于宇文司徒司空亓官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷粱晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟第五言福百家姓续";
		//定义女生的名
		private static String girl="秀娟英华慧巧美娜静淑惠珠翠雅芝玉萍红娥玲芬芳燕彩春菊兰凤洁梅琳素云莲真环雪荣爱妹霞香月莺媛艳瑞凡佳嘉琼勤珍贞莉桂娣叶璧璐娅琦晶妍茜秋珊莎锦黛青倩婷姣婉娴瑾颖露瑶怡婵雁蓓纨仪荷丹蓉眉君琴蕊薇菁梦岚苑婕馨瑗琰韵融园艺咏卿聪澜纯毓悦昭冰爽琬茗羽希宁欣飘育滢馥筠柔竹霭凝晓欢霄枫芸菲寒伊亚宜可姬舒影荔枝思丽 ";
		//定义男生的名
	    private static String boy="伟刚勇毅俊峰强军平保东文辉力明永健世广志义兴良海山仁波宁贵福生龙元全国胜学祥才发武新利清飞彬富顺信子杰涛昌成康星光天达安岩中茂进林有坚和彪博诚先敬震振壮会思群豪心邦承乐绍功松善厚庆磊民友裕河哲江超浩亮政谦亨奇固之轮翰朗伯宏言若鸣朋斌梁栋维启克伦翔旭鹏泽晨辰士以建家致树炎德行时泰盛雄琛钧冠策腾楠榕风航弘";

	    private static String pass="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    
	    public static int getNum(int start,int end) {//随机返回返回指定范围间的整数
	    	//Math.random()随机返回0.0至1.0之间的数
	        return (int)(Math.random()*(end-start+1)+start);
	    }
	    
	    public static String getPass() {
	    	String s ="";
	    	String s1;
	    	for(int i=0;i<9;i++){
	    		int length=pass.length();
	    		int index=getNum(0,length-1);//随机获取名字的位置
		        s1=pass.substring(index, index+1);
		        s+=s1;
	    	}
	        return s;
	    }
	    
	    public static String getSex() {//随机返回返回指定范围间的整数
	    	//Math.random()随机返回0.0至1.0之间的数
	       if((int)(Math.random()*2)==0)
	       return "女";
	       return "男";
	    }
	   
	    //随机返回中文姓名 
	    public static String getChineseName(String xb) {
	        int index=getNum(0, firstName.length()-1);//随机取姓氏字符串中的任意位置
	        String first=firstName.substring(index, index+1);//获取该位置的姓氏
	        String str=boy;//定义名字为男生字符串
	        int length=boy.length();//获取男生字符串的长度
	        if(xb.equals("女")){//如果随机获取为0，则名字改为女生
	            str=girl;
	            length=girl.length();
	        }
	        index=getNum(0,length-1);//随机获取名字的位置
	        String second=str.substring(index, index+1);//获取该位置中的名字
	        int hasThird=getNum(0,1);//随机获取名字是否有第三个字
	        String third="";//默认没有第三个字
	        if(hasThird==1){//如果随机获取为1，则有第三个字
	            index=getNum(0,length-1);
	            third=str.substring(index, index+1);
	        }
	        return first+second+third;//返回姓名
	    }
	    public static void main(String[] args) {
	    	addCJ();
	    }
	    public static void addCJ() {//增加成绩
	    	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//使用1中定义的连接数据库的类
	    	String sql="insert into Userdb(username,xb,password,time) values(?,?,?,?)";//使用占位符定义插入语句
	    	try(Connection conn=dbcs.getConnection();//获取数据库接
	    		PreparedStatement pstmt=conn.prepareStatement(sql);){//实例化PreparedStatement
	        	ArrayList<String> alist=new ArrayList<String>();//定义集合
	    		for(int i=1;i<=10000;) {
	    				String xb=getSex();
	    				String xm=getChineseName(xb);//随机获取姓名
	    				String passWord=getPass();
	    				String time=new NowString().getTime();
//	    				System.out.println(xb+"   "+xm+"   "+passWord+"   "+time);
	    				int cj=getNum(0, 100);//随机获取成绩
	    				pstmt.setString(1, xm);//定义第1个占位符的内容
	    				pstmt.setString(2, xb);//定义第2个占位符的内容
	    				pstmt.setString(3, passWord);//定义第3个占位符的内容
	    	    		pstmt.setString(4,time );//定义第4个占位符的内容
	    	    		pstmt.addBatch();//加入批处理等待执行
	    				i++;//学号唯一，循环继续往下执行
	    		}
	    		pstmt.executeBatch();//批量执行插入操作
	    		JOptionPane.showMessageDialog(null, "sucess");
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    }

}
