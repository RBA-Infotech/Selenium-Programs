package Demo1;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PropertyConfiguratorDemo {

	Logger log = Logger.getLogger(PropertyConfiguratorDemo.class);

	@BeforeClass
	public void setUp() {
		PropertyConfigurator.configure("src\\main\\java\\Config\\log4j.properties");
	}

	@Test
	public void test1() {
		log.debug("This is debug msg");
	}

	@Test
	public void test2() {
		log.info("This is info msg");
	}

	@Test
	public void test3() {
		log.warn("This is warn msg");
	}

	@Test
	public void test4() {
		log.error("This is error msg");
	}

	@Test
	public void test5() {
		log.fatal("This is fatal msg");
	}

}
