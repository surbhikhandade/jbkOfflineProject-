package com.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPageObjectRepository {
	
	@FindBy(id = "username")
	public WebElement uname;

	@FindBy(xpath = "//input[@type='text' and @class='form-control' and @id='username']")
	public WebElement username;

	@FindBy(xpath = "//input[contains(@type,'number')]")
	public WebElement mobileno;

	@FindBy(xpath = "//input[@type='email']")
	public WebElement email;

	@FindBy(xpath = "//input[contains(@placeholder,'Java/J2EE')]")
	public WebElement course;

	@FindBy(xpath = "//input[@value='Female']")
	public WebElement gender;

	@FindBy(xpath = "//select[@class='form-control']")
	public WebElement select;

	@FindBy(xpath = "//input[@type='password']")
	public WebElement pass;

	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement clickbtn;

}
