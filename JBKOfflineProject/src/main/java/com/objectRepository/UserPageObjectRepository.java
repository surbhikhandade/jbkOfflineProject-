package com.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pages.AddUserPage;
import com.pages.PageBase;

import jxl.Workbook;

public class UserPageObjectRepository extends PageBase{
		
	
	@FindBy(tagName = "th")
	public List<WebElement> header;
	
	@FindBy(xpath = "//h1")
	public WebElement headertext;
	
	@FindBy(xpath ="//td[3]")
	public List<WebElement> gmail;
	
	@FindBy(xpath ="//td[6]")
	public List<WebElement> ale;
	
	@FindBy(xpath ="//td[2]")
	public List<WebElement> uname;
	
	@FindBy(xpath ="//td[1]")
	public List<WebElement> sno;
	
	@FindBy(xpath ="//td[2]")
	public List<WebElement> obtain;
	
	@FindBy(tagName = "tr")
	public List<WebElement> row;
	
	@FindBy(xpath = "//button[text()='Add User']")
	public WebElement adduserBtn;
	
	@FindBy(xpath = "//td[8]//a//span")
	public List<WebElement> deleteBtn;
	
	@FindBy(xpath = "//td[6]")
	public List<WebElement> gendercolum;
	
	@FindBy(xpath = "//td[2]")
	public List<WebElement> usernameColm;
	
	@FindBy(xpath = "//span[@class='label label-danger ss']")
	public WebElement deleteAlert;
	
	@FindBy(xpath = "//span[@class='label label-danger']")
	public WebElement deleteAlertfirst;
	
	@FindBy(xpath = "//td[7]")
	public List<WebElement> stateColumn;
	
	@FindBy(xpath = "//td[5]")
	public List<WebElement> courseColumn;
	
	@FindBy(xpath = "//td[4]")
	public List<WebElement> mobilecolm;

}
