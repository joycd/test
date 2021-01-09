package cn.jsu.cd.vo;
import cn.jsu.cd.service.MechanicsService;
import cn.jsu.cd.service.impl.MechanicsServiceImpl;
import junit.framework.TestCase;

public class Test extends TestCase{
	
		 public void testfind() {
			 MechanicsService mec=new MechanicsServiceImpl();
			 int m_id=1;
			 boolean bl=mec.searchId(m_id);
			 assertTrue(bl);
		 }

	
}
