package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import Pages.LoginPage;
import Pages.LogoutPage;

public class TS_007_LogoutTest extends ProjectSpecificMethod{

	public TS_007_LogoutTest() throws IOException {
		super();
	}
	
	LoginPage loginpg;
	LogoutPage logoutpg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	
	@Test
	public void validateLogoutFunctionality() throws IOException, InterruptedException {
		
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		Thread.sleep(3000);
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		logoutpg=new LogoutPage(driver);
		Thread.sleep(3000);
		logoutpg.logout();
		Thread.sleep(1000);
		logoutpg.seeLoginMsg();
	}
}