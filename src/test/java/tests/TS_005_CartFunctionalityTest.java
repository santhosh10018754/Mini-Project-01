package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import Pages.CartFunctionalityPage;
import Pages.LoginPage;

public class TS_005_CartFunctionalityTest extends ProjectSpecificMethod{

	public TS_005_CartFunctionalityTest() throws IOException {
		super();		
	}
	
	LoginPage loginpg;
	CartFunctionalityPage cartpg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	
	@Test
	public void validateCartFunctionality() throws IOException, InterruptedException {
		
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		Thread.sleep(3000);
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		cartpg=new CartFunctionalityPage(driver);
		Thread.sleep(3000);
		cartpg.clickOncart();
		cartpg.deleteProductsFromCart();
	}	
}