package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.ProjectSpecificMethod;
import Pages.SignUpPage;

public class TS_001_SignUpTest extends ProjectSpecificMethod {
	
	public TS_001_SignUpTest() throws IOException {
		super();
	}

	SignUpPage signup;
	String userName=configProperties.getProperty("userName");
	String password=configProperties.getProperty("password");
	
	@Test
	public void SignUpToDemoblaze() throws IOException, InterruptedException {
		
		signup=new SignUpPage(driver);
		signup.signUp(userName, password);		
	}
}