package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.objectRepository.RegisterPageObjectRepository;


public class RegisterPage extends RegisterPageObjectRepository {

	public WebDriver driver=null;		
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Click Register New Member and print page title
	public boolean verifyPage_title() {
		String title = driver.getTitle();
		System.out.println("The page title is; " + title);
				
		if(title.equals("JavaByKiran | Registration Page")) {
			System.out.println("Title is match");
			return true;
		}else {
			System.out.println("Title is not match");
			return false;
		}
	
	}
	
	// To Verify Text on Register New Member Page
	
		public boolean verifyText_registerPage() {
		
			String actual_text = textreg.getText();
			System.out.println("Login Page Text is: " + actual_text);
			String expected_text = "Register a new membership";
			
			if(actual_text.equals(expected_text)) {
				System.out.println("Text is match");
				return true;
			}else {
				System.out.println("Text is not match");
				return false;
			}
			
		}
		
		// To Verify Text on Register New Member Page
	
		public boolean verifyText() {
			
			String text = textrg.getText();
			System.out.println("Login Page Text is: " + text);
						
			
		if(text.equals("Java By Kiran")) {
			System.out.println("Text is match");
			return true;
		}else {
			System.out.println("Text is not match");
			return false;
		}
				
	}
		
		// Verify Without fill information direct click submit button in new member register then Error show
		
		public boolean verifyRegister() {

			if (driver.getTitle().contains("Log in"))
				clickRegMember.click();
			name.clear();
			name.sendKeys("surbhi");
			mobile.clear();
			mobile.sendKeys("78945621");
			email.clear();
			email.sendKeys("surbhi@gmail.com");
			password.clear();
			password.sendKeys("124578");
			submitbtn.click();
			Alert al = driver.switchTo().alert();
			String msg = al.getText();
			al.accept();
						
			if(msg.equals("User registered successfully.")) {
				System.out.println("Alert is match");
				return true;
			}else {
				System.out.println("Alert is not match");
				return false;
			}			
		}
		
		
		// Verify Without fill Name and click submit button in new member register then Error show
	
		public boolean verifyName() {
			
			mobile.sendKeys("78945621");
			email.sendKeys("surbhi@gmail.com");
			password.sendKeys("124578");
			submitbtn.click();

			String error = driver.findElement(By.id("name_error")).getText();
			System.out.println("Name error is: " + error);
			
			if(error.equals("Please enter Name.")) {
				System.out.println("Error is match");
				return true;
			}else {
				System.out.println("Error is not match");
				return false;
			}				
		}
		
		
		// Verify Without fill mobile and click submit button in new member register then Error show

		public boolean verifyMobileError() {
			
			name.sendKeys("surbhi");
			email.sendKeys("surbhi@gmail.com");
			password.sendKeys("124578");
			submitbtn.click();

			String error1 = driver.findElement(By.id("mobile_error")).getText();
			System.out.println("Mobile no. error is: " + error1);
			
			if(error1.equals("Please enter Mobile.")) {
				System.out.println("Error is match");
				return true;
			}else {
				System.out.println("Error is not match");
				return false;
			}
		    
		}

		// Verify Without fill Email and click submit button in new member register then Error show
	
		public boolean verifyEmail() {

			name.sendKeys("surbhi");
			mobile.sendKeys("7448945621");
			password.sendKeys("124578");
			submitbtn.click();
		    
		    String error2 = driver.findElement(By.id("email_error")).getText();
			System.out.println("Email error is: " + error2);
		
			if(error2.equals("Please enter Email.")) {
				System.out.println("Error is match");
				return true;
			}else {
				System.out.println("Error is not match");
				return false;
			}
		
		}

		// Verify Without fill password and click submit button in new member register then Error show
		
		public boolean verifyPassword() {

			name.sendKeys("surbhi");
			mobile.sendKeys("78945621");
			email.sendKeys("surbhi@gmail.com");
			submitbtn.click();

			String error3 = driver.findElement(By.id("password_error")).getText();
			System.out.println("Password error is: " + error3);			
		   
		    if(error3.equals("Please enter Password.")) {
				System.out.println("Error is match");
				return true;
			}else {
				System.out.println("Error is not match");
				return false;
			}
			
		}

		// Click 'I already have a membership' and print page title
		public boolean verifyTitle() {
			
			clickialready.click();
			String title = driver.getTitle();
			System.out.println("The page title is; " + title);
			
			if(title.equals("JavaByKiran | Log in")) {
				System.out.println("Error is match");
				return true;
			}else {
				System.out.println("Error is not match");
				return false;
			}

		}

		


}
