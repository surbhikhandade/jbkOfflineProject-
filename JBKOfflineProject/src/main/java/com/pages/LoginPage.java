package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.jbk.Utility.Utilities;
import com.objectRepository.LoginPageObjectRepository;


public class LoginPage extends LoginPageObjectRepository{

	public	WebDriver driver = null;
	 public ExtentTest extTest;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public DashboardPage navigateToDashboardPage(WebDriver driver) {

		Utilities.enterText(uname, "kiran@gmail.com");
		Utilities.enterText(pass, "123456");
	    Utilities.click(clickBtn);
		
		return new DashboardPage(driver);
	}
	
	

	// To Verify Page Title on Login page
	public boolean verifyLoginPage_title(ExtentTest test) {

		String title = Utilities.getTitle(driver);
	    pageLogs().info("Verify title of login page"+title);
	    test.info("Title of Login Page :" +title);
		String expectedtitle = "JavaByKiran | Log in";
		
		if (title.equals(expectedtitle)) {
			pageLogs().info("LoginPage Title is Matched");
			  test.info("LoginPage Title is Matched");
			return true;
		} else {
			pageLogs().info("LoginPage Title is not Matched");
			  test.info("LoginPage Title is not Matched");
			return false;

		}
	}

	// To Verify Page logo of jbk
	public boolean verifyJbk_Logo(ExtentTest test) {

		boolean flag = Utilities.displayedIs(Logo);
		test.info("Logo of Login Page");
		if(flag==true) {
			System.out.println("Logo of jbk is match");
			return true;
		}else {
			System.out.println("Logo of jbk is not match");
			return false;
		}

	}

	// Verify Login Page Text
	public boolean verifyText_loginPage1(ExtentTest test)  {
		test.info("verify Heading on Login Page");
		String text = Utilities.getTextData(loginPage1);
		pageLogs().info("Login Page Text is: " + text);
		test.info("Login Page Text is: " + text);
		String expectedText = "JAVA | SELENIUM | PYTHON";

		if (text.equals(expectedText)) {
			pageLogs().info("Text is Matched.");
			return true;
		} else {

			pageLogs().info("Text is not Matched. ");
			return false;
		}
	}

	public boolean verifyText_loginPage2(ExtentTest test) {
		test.info("verify heading on login page");
		String text = Utilities.getTextData(loginPage2);
		pageLogs().info("Login Page Text is: " + text);
		test.info("Login Page Text is: " + text);
		String expectedText = "Java By ";

		if (text.equals(expectedText)) {
			pageLogs().info("Text is Matched.");
			return true;
		} else {

			pageLogs().info("Text is not Matched. ");
			return false;
		}

	}

	
	public boolean verifyText_loginPage3(ExtentTest test) {
		test.info("verify heading on login page");
		String actualtext = Utilities.getTextData(loginPage3);
		pageLogs().info("Login Page Text is: " + actualtext);
		test.info("Login Page Text is: " + actualtext);

		String expectedtext = "Sign in to start your session";

		if (actualtext.equals(expectedtext)) {
			pageLogs().info("Text is Matched.");
			return true;
		} else {

			pageLogs().info("Text is not Matched. ");
			return false;
		}
	}

	
	public boolean verifyBlank_emailpass() {
		
		Utilities.enterText(Blankemail, " ");
		Utilities.clearText(Blankpass);
		Utilities.enterText(pass, " ");
		Utilities.click(clickBtn);

		String actual_error = Utilities.getTextData(emailerror);
		pageLogs().info("Email error is: " + actual_error);
		String actual_error1 = "Please enter email as kiran@gmail.com";

		String expect_error =Utilities.getTextData (passerror);
		pageLogs().info("Password error is: " + expect_error);
		String expect_error1 = "Please enter password 123456";

		if (actual_error.equals(actual_error1)) {
			pageLogs().info("Email Error is matched");
			return true;
		} else if (expect_error.equals(expect_error1)) {
			pageLogs().info("Password eroor is Matched");
			return true;

		} else {
			pageLogs().info("Email and password is not matched");
			return false;
		}

	}

	// Verify if a user cannot login with a valid EmailId and an without password
	// then Show Error Message

	public boolean verifyPassword() {

		Utilities.clearText(Blankemail);
		Utilities.enterText(Blankemail,"kiran@gmail.com");
		Utilities.click(clickBtn); ;
		String actual_error = Utilities.getTextData(passworderror);
		String expected_error = "Please enter password.";

		if (actual_error.equals(expected_error)) {
			pageLogs().info("Password Error is Matched.");
			return true;
		} else {

			pageLogs().info("Password Error is not Matched. ");
			return false;
		}
	}

	// Verify if a user cannot login without EmailId and an valid password then Show
	// Error Message

	public boolean verifyEmail() {

		Utilities.clearText(Blankpass);
		Utilities.enterText(pass, "123456");
		Utilities.click(clickBtn);
		String actual_error = Utilities.getTextData(emailerror);
		String expected_error = "Please enter email";

		if (actual_error.equals(expected_error)) {
			pageLogs().info("Email Error is Matched.");
			return true;
		} else {

			pageLogs().info("Email Error is not Matched. ");
			return false;
		}
	}

	// Verify if a user cannot login with a valid EmailId and an invalid password
	// then Show Error Message
	
	public boolean verifyInvalid_password() {

		Utilities.clearText(Blankemail);
		Utilities.enterText(Blankemail,"kiran@gmail.com");
		Utilities.clearText(Blankpass);
		Utilities.enterText(pass,"1234894");
		Utilities.click(clickBtn);
		String actual_error = Utilities.getTextData (passerror);
		pageLogs().info("Password error is: " + actual_error);
		String expected_error = "Please enter password 123456";

		if (actual_error.equals(expected_error)) {
			pageLogs().info("Valid Email and Invalid Password is Matched.");
			return true;
		} else {

			pageLogs().info("Valid Email and Invalid Password is not Matched. ");
			return false;
		}

	}

	// Verify if a user cannot login with invalid EmailId and an valid password then
	// Show Error Message

	public boolean verifyInvalid_email() {

		Utilities.clearText(Blankemail);
		Utilities.enterText(Blankemail,"kiran");
		Utilities.clearText(Blankpass);
		Utilities.enterText(pass,"123456");
		Utilities.click(clickBtn);
		String actual_error = Utilities.getTextData(emailerror);
		String expected_error = "Please enter email as kiran@gmail.com";

		if (actual_error.equals(expected_error)) {
			pageLogs().info("Valid Password and Invalid Email is Matched.");
			return true;
		} else {

			pageLogs().info("Valid Password  and Invalid Email is not Matched. ");
			return false;
		}

	}

	// Verify if a user can login with a valid EmailId and an valid password then
	// next page open properly

	public boolean verifyLogin() {

		Utilities.clearText(Blankemail);
		Utilities.enterText(Blankemail,"kiran@gmail.com");
		Utilities.clearText(Blankpass);
		Utilities.enterText(pass,"123456");
		Utilities.click(clickBtn);
		if (driver.getTitle().equals("JavaByKiran | Dashboard")) {

			pageLogs().info("Dashborad pageTitle is Match");
			return true;
		} else {

			pageLogs().info("Dashborad pageTitle is not Match");
			return false;
		}

	}

	public RegisterPage navigateToRegisterPage(WebDriver driver) {
		registerPageNavigate.click();
		return new RegisterPage(driver);
	}

	

	

	
}
