 package Demo1;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class BasicConfiguratorDemo {

	static Logger logger =   Logger.getLogger(BasicConfiguratorDemo.class);
			
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BasicConfigurator.configure();
		
		logger.debug("This is debug msg");
		logger.info("This is info msg");
		logger.warn("This is warn msg");		
		logger.error("This is error msg");
		logger.fatal("This is fatel msg");
		
	}

}
