package tests;

import java.io.IOException;
import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import org.junit.Assert; 
import Pages.LoginPage;
import Pages.ProductDetailsPage;

public class TS_004_ProductDetailsTest extends ProjectSpecificMethod {

	public TS_004_ProductDetailsTest() throws IOException {
		super();		
	}
	
	LoginPage loginpg;
	ProductDetailsPage productdetailspg;
	String LoginUserName=configProperties.getProperty("LoginUserName");
	String Loginpassword=configProperties.getProperty("Loginpassword");
	String searchProduct=configProperties.getProperty("product-to-be-search");
	String productCount=configProperties.getProperty("product-count");
	int productcount = Integer.parseInt(productCount);
	
	@Test
	public void checkProductDetails() throws IOException, InterruptedException {

		loginpg=new LoginPage(driver);
		loginpg.clickOnLoginTab();
		Thread.sleep(3000);
		loginpg.clickOnLogin(LoginUserName, Loginpassword);
		productdetailspg=new ProductDetailsPage(driver);
		Thread.sleep(6000);
		productdetailspg.selectProduct(searchProduct);
		Thread.sleep(6000);
		int ProductPrice=productdetailspg.AfterProductPrice();
		Thread.sleep(3000);
		System.out.println(ProductPrice);
		String Description=productdetailspg.getAfterProductDescription();
		Thread.sleep(3000);
		Assert.assertTrue(Description.contains(searchProduct));
		Thread.sleep(2000);
		productdetailspg.addProductOnCart(productcount);
		Thread.sleep(2000);
		productdetailspg.clickOnCartTab();
		int productList=productdetailspg.productListCount();
		Assert.assertEquals(productList, productcount);
		
	}
}