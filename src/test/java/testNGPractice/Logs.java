package testNGPractice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Logs {

	@Test
	public void test(){
		
		Reporter.log("login to app", true);
	}
}
