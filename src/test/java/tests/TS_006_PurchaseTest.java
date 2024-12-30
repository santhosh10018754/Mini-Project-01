package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import Pages.CartFunctionalityPage;
import Pages.LoginPage;
import Pages.PurchasePage;

public class TS_006_PurchaseTest extends ProjectSpecificMethod{

	public TS_006_PurchaseTest() throws IOException {
		super();		
	}
	
	LoginPage loginpg;
	CartFunctionalityPage cartpg;
	PurchasePage purchasepg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	
	String name=configProperties.getProperty("name");
	String country=configProperties.getProperty("country");
	String city=configProperties.getProperty("city");
	String card=configProperties.getProperty("card");
	String month=configProperties.getProperty("month");
	String year=configProperties.getProperty("year");
	
	@Test
	public void purchaseFunctionality() throws IOException, InterruptedException {
		
		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		Thread.sleep(3000);
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		cartpg=new CartFunctionalityPage(driver);
		Thread.sleep(3000);
		cartpg.clickOncart();
		purchasepg=new PurchasePage(driver);
		Thread.sleep(3000);
		purchasepg.placeOrderButton();
		Thread.sleep(1000);
		purchasepg.enterName(name);
		Thread.sleep(1000);
		purchasepg.enterCountry(country);
		Thread.sleep(1000);
		purchasepg.enterCity(city);
		Thread.sleep(1000);
		purchasepg.enterCard(card);
		Thread.sleep(1000);
		purchasepg.enterMonth(month);
		Thread.sleep(1000);
		purchasepg.enterYear(year);
		Thread.sleep(1000);
		purchasepg.purchaseButton();
		Thread.sleep(1000);
		String msg=purchasepg.seeSuccessMsg();
		Assert.assertTrue(msg.contains("Thank you for your purchase"));
		
	}
}
