package com.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsefulLinksPageObjectRepository {
	

	@FindBy(xpath ="//td[2]")
	public List<WebElement> contendscolm;
	
	@FindBy(tagName ="th")
	public List<WebElement> headerlist;
	
	@FindBy(xpath ="//td[3]//a//span")
	public List<WebElement> gobtns;
	

	@FindBy(xpath ="//td[1]")
	public List<WebElement> serialnocom;

}
