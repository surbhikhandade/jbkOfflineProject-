package com.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.pages.PageBase;

public class DownloadsPageObjectRepository extends PageBase{
	
	@FindBy(tagName = "th")
	public List<WebElement> headercolm;
	
	@FindBy(xpath = "//td[3]")
	public List<WebElement> vendorColm;
	
	@FindBy(xpath = "//td[4]")
	public List<WebElement> versionColm;
	
	@FindBy(xpath = "//td[5]")
	public List<WebElement> bitTColm;
	
	@FindBy(xpath = "//td[6]")
	public List<WebElement> bitSColm;
	
	@FindBy(xpath = "//td[1]")
	public List<WebElement> srnColm;
	
	@FindBy(xpath = "//td[7]")
	public List<WebElement> commonlist;
	


}
