package base;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import utils.Utility;

	public class ProjectSpecificMethod  extends Utility{

		public ProjectSpecificMethod() throws IOException {
		super();
	}
		
		@BeforeTest
		public  WebDriver openbrowser() {
			
			LaunchBrowser();	
			String URI=configProperties.getProperty("home-page-url");
			driver.get(URI);
			return driver;
		}
		
		
}
