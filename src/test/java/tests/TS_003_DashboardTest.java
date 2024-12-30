package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import Pages.DashboardPage;
import Pages.LoginPage;

public class TS_003_DashboardTest extends ProjectSpecificMethod {

	public TS_003_DashboardTest() throws IOException {
		super();
	}
	
	LoginPage loginpg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	DashboardPage dashboardpg;
	
	@Test
	public void seeWelcomeUserMessage() throws IOException, InterruptedException {
		
		Thread.sleep(3000);
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		Thread.sleep(1000);
		dashboardpg=new DashboardPage(driver);
		Thread.sleep(1000);
		dashboardpg.welcomeMessage(LoginUserName);	
		Thread.sleep(1000);
		dashboardpg.allMenuesList();
		Thread.sleep(1000);
		dashboardpg.allCategoriesList();	
	}
}