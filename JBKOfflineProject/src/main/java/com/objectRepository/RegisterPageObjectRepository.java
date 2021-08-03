package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObjectRepository {
	
	@FindBy(xpath ="//a[text()='Register a new membership']" )
	public WebElement textreg;
	
	@FindBy(xpath ="//b[text()='Java By Kiran']" )
	public WebElement textrg;
	
	@FindBy(xpath ="//*[text()='Register a new membership']" )
	public WebElement clickRegMember;
	
	@FindBy(xpath ="//input[@id='name']" )
	public WebElement name;
	
	@FindBy(xpath ="//input[@name='mobile']" )
	public WebElement mobile;
	
	@FindBy(xpath ="//input[@id='email']" )
	public WebElement email;
	
	@FindBy(xpath ="//input[@type='password']" )
	public WebElement password;
	
	@FindBy(xpath ="//button[@type='submit']" )
	public WebElement submitbtn;
	
	@FindBy(partialLinkText = "I already" )
	public WebElement clickialready;
	

}
