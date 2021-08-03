package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import com.jbk.Utility.Utilities;
import com.objectRepository.UserPageObjectRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

@SuppressWarnings("unlikely-arg-type")
public class UserPage extends UserPageObjectRepository {

	public WebDriver driver = null;
	public Workbook wb = null;

	public UserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCelldata(int row,int col) throws BiffException, IOException {
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\Selenium\\TestCase\\xls\\jbk.xls");
			wb = Workbook.getWorkbook(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Sheet sheets = wb.getSheet("user_text");
		Cell c = sheets.getCell(col, row);
		
			System.out.println();
			return c.getContents();
	}

	public boolean verifyUserPage_Title() {

		String title = Utilities.getTitle(driver);
		pageLogs().info("Page Title is : " + title);
		String expected = "JavaByKiran | User";

		if (title.equals(expected)) {
			pageLogs().info("Title is match");
			return true;
		} else {
			pageLogs().info("Title is not match");
			return false;
		}
	}

	public boolean verifyHeader_Text() {

		String text = Utilities.getTextData(headertext);
		pageLogs().info("Page Text is: " + text);
		String expecText = "Users";

		if (text.equals(expecText)) {
			pageLogs().info("Text is Match");
			return true;
		} else {
			pageLogs().info("Text is Not Match");
			return false;
		}

	}

	public boolean verifyHeaders_Spelling() throws Exception {

	
		ArrayList<String> actualheaders = new ArrayList<String>();

		for (WebElement element : header) {
			actualheaders.add(Utilities.getTextData(element));
			pageLogs().info("Actual header is " + actualheaders);

		}

		if (actualheaders.equals(Utilities.readDataofRow1("D:\\Selenium\\TestCase\\xls\\jbk.xls", "user_text", 0))) {
			pageLogs().info("Header is Match");
			return true;
		} else {
			pageLogs().info("Header is Not Match");
			return false;
		}

	}

	public boolean verifygmailcom() {

		for (WebElement element : gmail) {
			String Text = Utilities.getTextData(element);
			if (Text.contains("@gmail.com")) {
				pageLogs().info("@gmail contains is :" + Text);
				return true;
			} else {
				pageLogs().info("@gmail contains is not present: " + Text);
				return false;
			}

		}
		pageLogs().info("Actual Size of Email column..." + gmail.size());
		return false;

	}

	
	public boolean verifygender() {

	
		for (WebElement webElement : ale) {
			String text = Utilities.getTextData(webElement);
			boolean value = text.contains("ale");

		}
		return true;
	}
	
	public boolean verifyMale_Female() {
		ArrayList<String> gender = new ArrayList<String>();
	
		for (int i = 0; i < gendercolum.size(); i++) {

			String str = Utilities.getTextIndex(gendercolum, i);
			String name = Utilities.getTextIndex(usernameColm, i);
			pageLogs().info(name + " is " + str);

			boolean value = str.equals("Male") || str.equals("Female");
			gender.add(str);
		}
		return true;

	}

	public boolean verifyCount_of_username() {

		int actualsize = uname.size();
		pageLogs().info(uname.size());

		pageLogs().info(sno.size());
		int expectedsize = sno.size();
		Assert.assertEquals(actualsize, expectedsize);

		if (actualsize == expectedsize) {
			pageLogs().info("Username Count is match");
			return true;
		} else {
			pageLogs().info("Username Count is not match");
			return false;
		}

	}

	public boolean verifysort_of_username() {

		ArrayList<String> obtainedList = new ArrayList<String>();
		for (WebElement we : obtain) {
			obtainedList.add(Utilities.getTextData(we));
		}
		Collections.sort(obtainedList);

		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);
		}
		Collections.sort(sortedList);
		pageLogs().info(sortedList);
		pageLogs().info(obtainedList);

		if (sortedList.equals(obtainedList)) {
			pageLogs().info("Username is sorted Alphabetically");
			return true;
		} else {
			pageLogs().info("Username is not sorted Alphabetically");
			return false;
		}
	}

	public boolean verifyAddUser_IsEnabled() {

		if (Utilities.enabledIs(adduserBtn)) {
			Utilities.click(adduserBtn);
			pageLogs().info("ADDuser button is enabled");
			return true;
		} else {
			pageLogs().info("Add user button is not enabled");
			return false;

		}
	}

	public boolean verifyDeleteButton_IsEnabled() {

		for (WebElement elements : deleteBtn) {
			boolean bb = Utilities.enabledIs(elements);

		}
		return true;

	}

	public boolean verifyDeleteBtnPopup() throws Exception {

		Utilities.click(deleteAlert);
		String alert1 = driver.switchTo().alert().getText();
		pageLogs().info("Alert PopUp Show Message is : " + alert1);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String actualmsg = driver.switchTo().alert().getText();
		pageLogs().info("Alert Accept : " + actualmsg);
		String expectedmsg = "User deleted successfully.";
		driver.switchTo().alert().accept();

		if (actualmsg.equals(expectedmsg)) {
			pageLogs().info("Second button Delete Message is matech");
			return true;
		} else {
			pageLogs().info("Second button Delete Message is not matech");
			return false;

		}
	}

	public boolean verifyFirstDeleteBtnPopup() throws Exception {

		Utilities.click(deleteAlertfirst);
		String alert1 = driver.switchTo().alert().getText();
		pageLogs().info("Alert PopUp Show Message is : " + alert1);
		Thread.sleep(3000);
		String actualmsg = driver.switchTo().alert().getText();
		pageLogs().info("Alert Accept : " + actualmsg);
		String expectedmsg = "You can not delete Default User";
		driver.switchTo().alert().accept();

		if (actualmsg.equals(expectedmsg)) {
			pageLogs().info("First button Delete Message is matech");
			return true;
		} else {
			pageLogs().info("First button Delete Message is not matech");
			return false;

		}
	}

	public boolean verifyFemale_Male_WithUsername() throws Exception {

		ArrayList<String> actual = new ArrayList<String>();

		for (int i = 0; i < usernameColm.size(); i++) {
			String key = usernameColm.get(i).getText();
			String value = gendercolum.get(i).getText();

			pageLogs().info(key + ":" + value);
			actual.add(key+ "=" +value);
		

		}

		if (actual.equals(Utilities.readDataofColm1("D:\\Selenium\\TestCase\\xls\\jbk.xls", "user_text", 1,5))) {
			pageLogs().info("with username Male & Female are match");
			return true;
		} else {
			pageLogs().info("with username Male & Female are not match ");
			return false;
		}
	}

	public boolean verifyMaharashtraWithUsername() throws Exception {

		ArrayList<String> actual = new ArrayList<String>();
		for (int i = 0; i < usernameColm.size(); i++) {
			
			String st = stateColumn.get(i).getText();
			if (st.contains("Maharashtra")) {
				String un = usernameColm.get(i).getText();
				actual.add(un+"=" +st);
				
			}
		}
		pageLogs().info(actual);
		
		if (actual.equals(Utilities.readDataofColmContains("D:\\Selenium\\TestCase\\xls\\jbk.xls", "user_text","Maharashtra" ,1, 6))) {
			pageLogs().info("with username Maharashtra is match ");
			return true;
		} else {
			pageLogs().info("with username Maharashtra is not match ");
			return false;
		}

	}

	public boolean verifyCoursesWithIndivisualUsername() throws Exception {

		ArrayList<String> actual = new ArrayList<String> ();

		for (int i = 0; i < usernameColm.size(); i++) {
			String key = usernameColm.get(i).getText();
			String value = courseColumn.get(i).getText();

			pageLogs().info(key + " : " + value);
			actual.add(key+"="+value);

		}

	if (actual.equals(Utilities.readDataofColm1("D:\\Selenium\\TestCase\\xls\\jbk.xls", "user_text", 1,4))) {
			pageLogs().info("with username courses are match ");
			return true;
		} else {
			pageLogs().info("with username courses are not match ");
			return false;
		}

	}

	public List<Boolean> mobileLength() {
		boolean flag = false;

		ArrayList<Boolean> al = new ArrayList<Boolean>();
	
		for (WebElement mob : mobilecolm) {
			String text = Utilities.getTextData(mob);
			if (text.length() == 10) {
				pageLogs().info("correct mobile number is :" + text);
				al.add(!flag);
			} else {
				pageLogs().info("Incorrect mobile number is :" + text);
				al.add(flag);
			}
		}

		return al;

	}

}
