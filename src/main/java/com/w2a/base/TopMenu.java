package com.w2a.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.pages.crm.accounts.AccountsPage;

public class TopMenu {
	public WebDriver driver;
	public TopMenu(WebDriver driver) {
		this.driver=driver;
	}

	public void goToCRMHome() {
		//driver.findElement(By.xpath("//a[@href='/crm/org60006948457/tab/Home']")).click();
		// $x("//a[@href='/crm/org60006948457/tab/Accounts']")
		Page.click("CRMHome_XPATH");

	}

	public void goToLeads() {
		//driver.findElement(By.xpath("//a[@href='/crm/org60006948457/tab/Leads']")).click();
		// $x("//a[@href='/crm/org60006948457/tab/Leads']")
		Page.click("LeadsBtn_XPATH");

	}

	public void goToContacts() {
		//driver.findElement(By.xpath("//a[@href='/crm/org60006948457/tab/Contacts']")).click();
		// $x("//a[@href='/crm/org60006948457/tab/Contacts']")
		Page.click("ContactsBtn_XPATH");

	}

	public AccountsPage goToAccounts() {
		// driver.findElement(By.xpath("//*[@id='mainMenuTabDiv']/crm-menu/div[1]/crm-tab/div[2]/div[4]/a")).click();
		Page.click("AccountsBtn_XPATH");
		return new AccountsPage();
	}

	public void goToDeals() {
		//driver.findElement(By.xpath("//a[@href='/crm/org60006948457/tab/Potentials']")).click();
		Page.click("DealsBtn_XPATH");

	}

	public void goToActivities() {
		//driver.findElement(By.xpath("//a[@href='/crm/org60006948457/tab/Activities']")).click();
		Page.click("ActivitiesBtn_XPATH");
	}

	public void goToReports() {
		//driver.findElement(By.xpath("//a[@href='/crm/org60006948457/tab/Reports']")).click();

		Page.click("ReportsBtn_XPATH");
	}

}
