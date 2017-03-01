package testNGPractice;

import org.testng.annotations.Test;

public class Groupts {
	
	@Test(groups="Smoke")
	public void smokeTesting1(){
		System.out.println("Smoke Testing 1");
	}
	
	@Test(groups="Smoke")
	public void smokeTesting2(){
		System.out.println("Smoke Testing 2");
	}

	@Test(groups="Regression")
	public void regressionTesting1(){
		System.out.println("Regression Testing 1");
	}
	
	@Test(groups="Regression")
	public void regressionTesting2(){
		System.out.println("Regression Testing 2");
	}
}
