package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.RegisterPage;

public class RegisterPageTest extends TestBase{
	WebDriver driver = null;
	public RegisterPage rp =null;
	 @BeforeMethod
		public void Setup() throws Throwable {
		 	/*
			System.setProperty("webdriver.chrome.driver","D/chromedriver.exe");
			System.out.println("Open Chrome Driver");
			driver = new ChromeDriver();*/
		 	driver= OpenBrower();
		 	rp=loadLoginPage().navigateToRegisterPage(driver);
			rp = new RegisterPage(driver);
			
		}
	 
	  @Test(priority=1)
	  public void verifyTitleOnRegisterPage() {
		  Assert.assertTrue(rp.verifyPage_title());
	  }
	  
	  @Test(priority=2)
	  public void verifyText1OnRegisterPage() {
		  Assert.assertTrue(rp.verifyText_registerPage());
	  }
	  
	  @Test(priority=3)
	  public void verifyText2_RegisterPage() {
		  Assert.assertTrue(rp.verifyText());
	  }
	  
	  @Test(priority=4)
	  public void verify_RegisterForm() {
		  Assert.assertTrue(rp.verifyRegister());
	  }
	  
	  @Test(priority=5)
	  public void verifyNameOnRegisterPage() {
		  Assert.assertTrue(rp.verifyName());
	  }
	  
	  @Test(priority=6)
	  public void verifyMobile() {
		  Assert.assertTrue(rp.verifyMobileError());
	  }
	  
	  @Test(priority=7)
	  public void verifyEmailOnRegisterPage() {
		  Assert.assertTrue(rp.verifyPassword());
	  }
	  
	  @Test(priority = 8)
	  public void verifyPasswordOnRegisterPage() {
		  Assert.assertTrue(rp.verifyPassword());
	  }
	  
	  @Test(priority = 9)
	  public void verifyClickTo_I_Have_Register_Already() {
		  Assert.assertTrue(rp.verifyTitle());
	  }

}
