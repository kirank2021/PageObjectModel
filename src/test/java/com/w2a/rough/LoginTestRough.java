package com.w2a.rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.CRMHomePage;
import com.w2a.pages.crm.accounts.AccountsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestRough{
	public static void main(String args[]) throws InterruptedException {
		/*
		 * HomePage home = new HomePage(); 
		 * LoginPage login = home.goToLogin();
		 *  
		 * 
		 * login.doLogin("aquaman162018@gmail.com",
		 * "Kiran@789"); 
		 * Thread.sleep(3000); 
		 * ZohoAppPage zoho= new ZohoAppPage();
		 * zoho.goToCRM(); 
		 * Page.menu.goToDeals();
		 */

		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();
		ZohoAppPage zoho= login.doLogin("aquaman162018@gmail.com", "Kiran@789");
		CRMHomePage CRMHome = zoho.goToCRM();
		AccountsPage AccountsHome =Page.menu.goToAccounts();
		System.out.println(System.getProperty("user.dir"));
	}

}
