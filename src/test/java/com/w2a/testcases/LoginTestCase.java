package com.w2a.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;

public class LoginTestCase extends BaseTest {
	
	@Test
	public void loginTest() {

		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();
		//Assert.fail("login not successfull"); 

		ZohoAppPage zoho= login.doLogin("aquaman162018@gmail.com", "Kiran@789");
		
	}

}
