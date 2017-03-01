package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOn {
	
	
	@Test()
	public void login(){
		Assert.assertEquals(10, 20);
		System.out.println("Login TC");
	}
	
	
	@Test(dependsOnMethods="login")
	public void logout(){
		System.out.println("Login TC");
	}
}
