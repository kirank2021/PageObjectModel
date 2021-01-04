package com.w2a.pages;

import org.openqa.selenium.By;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {
	public void goToBooks() {
		//driver.findElement(By.xpath("//*[@class='_logo-books _logo-x96 zod-app-logo']")).click();
		click("BooksBtn_XPATH");
	}

	public CRMHomePage goToCRM() {
		//driver.findElement(By.xpath("//span[@class='_logo-crm _logo-x96 zod-app-logo']")).click();
		click("ZHOCRMBtn_XPATH");
		return new CRMHomePage();


	}

	public void goToMails() {
		
		//driver.findElement(By.xpath("//*[@class='_logo-mail _logo-x96 zod-app-logo']")).click();
		click("MailsBtn_XPATH");

	}
}
