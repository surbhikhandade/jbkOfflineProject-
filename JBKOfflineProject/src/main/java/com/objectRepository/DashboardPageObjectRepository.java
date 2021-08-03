package com.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pages.AddUserPage;
import com.pages.DashboardPage;
import com.pages.DownloadsPage;
import com.pages.LoginPage;
import com.pages.OperatorsPage;
import com.pages.PageBase;
import com.pages.RegisterPage;
import com.pages.UsefulLinksPage;
import com.pages.UserPage;

public class DashboardPageObjectRepository extends PageBase {
	
	@FindBy(xpath ="//a[text()='Register a new membership']" )
	public static WebElement registerPageNavigate;
	
	@FindBy(xpath = "//span[text()='Users']")
	public static WebElement usersPageNavigate;
	
	@FindBy(xpath = "//button[text()='Add User']")
	public static WebElement addUsersPageNavigate;
	
	
	@FindBy(xpath = "//span[text()='Operators']")
	public static WebElement operatorsPageNavigate;
	
	@FindBy(xpath="//span[text()='     Useful Links']")
	public static WebElement usefulLinksPageNavigate;
	
	@FindBy(xpath = "//span[text()='Downloads']")
	public static WebElement downloadsPageNavigate;
	
	@FindBy(xpath = "//img[@src='../../dist/img/user2-160x160.jpg']")
	public WebElement logo;
	
	@FindBy(xpath = "//li//span")
	public List<WebElement> sidemenu;
	
	@FindBy(tagName ="h3")
	public List<WebElement> actcourse; 
	
	@FindBy(xpath = "//div[1]/p")
	public List<WebElement> subcourse;
	
	@FindBy(xpath = "//b[text()='Design for Selenium Automation Test']")
	public WebElement footer;
	
	@FindBy(xpath = "//strong[contains(text(),'Copyright © 2005-2019')]")
	public WebElement footertext;
	
	@FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
	public WebElement header;
	
	@FindBy(xpath = "//p[contains(text(),'Logout successfully')]")
	public WebElement logoutbtn;
	
	@FindBy(linkText = "LOGOUT")
	public WebElement logout;
	
	@FindBy(xpath = "//i[@class='ion ion-bag']")
	public WebElement selenium;
	
	@FindBy(xpath = "//i[@class='ion ion-stats-bars']")
	public WebElement java;
	
	@FindBy(xpath = "//i[@class='ion ion-person-add']")
	public WebElement python;
	
	@FindBy(xpath = "//i[@class='ion ion-pie-graph']")
	public WebElement php;
	
	
	public RegisterPage navigatetToRegisterPage(WebDriver driver) {
		registerPageNavigate.click();
 		return new RegisterPage(driver);
 		
 	}
	
	 public UserPage navigatetToUserPage(WebDriver driver) {
	 		usersPageNavigate.click();
	 		return new UserPage(driver);
	 		
	 	}
	 
	 public AddUserPage navigateToAddUserPage(WebDriver driver) {
		    usersPageNavigate.click();
	 		addUsersPageNavigate.click();
	 		return new AddUserPage(driver);
	 		
	 	}
	     
	     public OperatorsPage navigatetToOperatorsPage(WebDriver driver) {
	  		operatorsPageNavigate.click();
	  		return new OperatorsPage(driver);
	  		
	  	}
	     
	     public UsefulLinksPage navigatetToUsefulLinksPage(WebDriver driver) {
	    	 usefulLinksPageNavigate.click();
		  		return new UsefulLinksPage(driver);
		  		
		  	}

	     public DownloadsPage navigatetToDownloadsPage(WebDriver driver) {
	    	 downloadsPageNavigate.click();
		  		return new DownloadsPage(driver);
		  		
		  	}
    
}
