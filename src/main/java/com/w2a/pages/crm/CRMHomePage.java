package com.w2a.pages.crm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.w2a.base.Page;

public class CRMHomePage extends Page{
	//driver.findElement(By.xpath(" "));
	public Boolean verifyTitle() {
		String title=driver.getTitle();
		Assert.assertEquals(title,"Home Page - Zoho CRM");
		return true;
		
	

	}


}
