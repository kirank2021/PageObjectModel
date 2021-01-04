package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class LoginPage extends Page {
	
	public ZohoAppPage doLogin(String username,String password) {
		//driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys(username);
		type("username_XPATH",username);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//*[@class='btn blue' and @id='nextbtn']")).click();
		click("usernamebtn_XPATH");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		type("password_XPATH",password);
		//driver.findElement(By.xpath("//*[@class='btn blue' and @id='nextbtn']")).click();
		click("loginBtn_XPATH");
		return new ZohoAppPage();
	}

}
