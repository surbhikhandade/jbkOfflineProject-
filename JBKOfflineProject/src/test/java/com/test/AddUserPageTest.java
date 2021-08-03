package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.AddUserPage;
import com.pages.UserPage;

public class AddUserPageTest extends TestBase{
	
public WebDriver driver=null;
	
	public AddUserPage aup = null;
	
	@BeforeMethod
	public void Setup() throws Throwable {
		/*
		System.setProperty("webdriver.chrome.driver", "D/chromedriver.exe");
		System.out.println("Open Chrome Driver");
		driver = new ChromeDriver();
		driver.get("file:///D:/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/add_user.html");
		*/
		  
		 driver=OpenBrower();
		 aup=loadLoginPage().navigateToDashboardPage(driver).navigateToAddUserPage(driver);		 
		 aup= new AddUserPage(driver);
	
		//driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Open JBK Website");
	}
	
	  @Test(priority=1)
	  public void verifyWithFillErrorShow() {
		  Assert.assertTrue(aup.verifyWithout_Fill_Info_ErrorShow());
	  }
	  
	  @Test(priority=2)
	  public void verifyEmailError(){
		  Assert.assertTrue(aup.verifyEmail_Error());
	  }
	  
	  @Test(priority=3)
	  public void verifyDropdownError() {
		  Assert.assertTrue(aup.verifyDroupdown_SelectError());
	  }
	  
	  @Test(priority=4)
	  public void verifyAdd_user() {
		  Assert.assertTrue(aup.verifyDroupdown_SelectError());
	  }

}
