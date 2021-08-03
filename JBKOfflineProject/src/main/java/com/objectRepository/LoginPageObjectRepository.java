package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pages.PageBase;

public class LoginPageObjectRepository extends PageBase{
	
	@FindBy(id="email")
	public WebElement uname;
	
	@FindBy(id="password")
	public WebElement pass;

	@FindBy(xpath = "//img[@src='pages/images/jbk.png']")
	public WebElement Logo;
	
	@FindBy(xpath="//h4[text()='JAVA | SELENIUM | PYTHON']")
	public WebElement loginPage1;
	
	@FindBy(xpath="//b[text()='Java By Kiran']")
	public WebElement loginPage2;
	
	@FindBy(xpath="//p[contains(text(),'Sign in to start your session')]")
	public WebElement loginPage3;
	
	@FindBy(id="email")
	public WebElement Blankemail;
	
	@FindBy(id="password")
	public WebElement Blankpass;
	
	@FindBy(xpath="//button")
	public WebElement clickBtn;
	
	@FindBy(id="email_error")
	public WebElement emailerror;
	
	@FindBy(id="password_error")
	public WebElement passerror;
	
	@FindBy(id="password_error")
	public WebElement passworderror;
	
	@FindBy(id="email_error")
	public WebElement emailError;
	
	@FindBy(xpath ="//p[text()='Register a new membership']" )
	public static WebElement registerPageNavigate;

}
