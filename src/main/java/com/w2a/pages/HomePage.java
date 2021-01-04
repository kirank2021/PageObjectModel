package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class HomePage extends Page{

	public void goToCustomers() {
		//driver.findElement(By.cssSelector("body > div.main-container-wrapper > div.zh-header-wrap > div > a.zh-customers"));
		//driver.findElement(By.xpath("//a[@class='zh-customers']")).click();
		/// $x("//*[@class='zh-customers']")
		click("CustomerBtn_XPATH");

	}

	public void goToSupport() {
		//driver.findElement(By.cssSelector("body > div.main-container-wrapper > div.zh-header-wrap > div > a.zh-support"));
		// $x("//a[@class='zh-support']")
		//driver.findElement(By.xpath("//a[@class='zh-support']")).click();
		click("SupportBtn_XPATH");

	}

	public void goToContactSales() {
		//driver.findElement(By.cssSelector("body > div.main-container-wrapper > div.zh-header-wrap > div > a.zh-contact"));
		//driver.findElement(By.xpath("//a[@class='zh-contact']")).click();
		click("ContactsalesBtn_XPATH");
	}
	public LoginPage goToLogin() {
		//driver.findElement(By.cssSelector("body > div.main-container-wrapper > div.zh-header-wrap > div > a.zh-login"));
		//driver.findElement(By.xpath("//a[@class='zh-login']")).click();
		click("homepageLogin_XPATH");
		return new LoginPage();
	}

	public void goToFreeSignUp() {
		//driver.findElement(By.cssSelector("body > div.main-container-wrapper > div.zh-header-wrap > div > a.zh-signup"));
		//driver.findElement(By.xpath("//a[@class='zh-signup']")).click();
		click("SignupBtn_XPATH");

	}

}
