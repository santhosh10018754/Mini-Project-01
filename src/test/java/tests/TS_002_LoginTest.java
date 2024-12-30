package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import Pages.LoginPage;


public class TS_002_LoginTest extends ProjectSpecificMethod{

	public TS_002_LoginTest() throws IOException {
		super();
	}
	
	LoginPage loginpg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	
	@Test
	public void LoginToDemoBlaze() throws IOException {
		
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		
	}
}