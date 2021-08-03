package com.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pages.PageBase;

import jxl.Workbook;

public class OperatorsPageObjectRepository extends PageBase{
	
	
	public WebDriver driver=null;
	public Workbook wb=null;
	
	@FindBy(xpath = "//td[1]")
	public List<WebElement> serialno;
	
	@FindBy(xpath = "//td[2]")
	public List<WebElement> personcolm;
	
	@FindBy(xpath = "//td[3]")
	public List<WebElement> forjobcolm;
	
	@FindBy(xpath = "//td[4]")
	public List<WebElement> preferdWays;
	
	@FindBy(xpath = "//td[5]")
	public List<WebElement> mobileno;
	
	@FindBy(xpath = "//td[6]")
	public List<WebElement> timingcolm;
	
	@FindBy(tagName = "th")
	public List<WebElement> headercolm;	
	

}
