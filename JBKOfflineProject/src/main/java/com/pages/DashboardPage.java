package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jbk.Utility.Utilities;
import com.objectRepository.DashboardPageObjectRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DashboardPage extends DashboardPageObjectRepository {

	WebDriver driver = null;
	Workbook wb = null;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyLogo() {

		boolean flag = Utilities.displayedIs(logo);
		pageLogs().info("TestCase 1 is :" + flag);

		return flag;
	}

	public boolean verifySideMenu() throws Exception {
		ArrayList<String> expectedmenus = new ArrayList<String>();
		ArrayList<String> actualmenus = new ArrayList<String>();
		for (WebElement element : sidemenu)
			actualmenus.add(element.getText());
	
		pageLogs().info(actualmenus);
		
		if (actualmenus.equals(	Utilities.readDataofRow1("D:\\Selenium\\JBKOfflineProject\\xls\\dashboard.xls", "dash", 0))) {
			pageLogs().info("Side Menus is Matech");
			return true;
		} else {
			pageLogs().info("Side Menus is Not Matech");
			return false;
		}
		
	}

	public boolean verifyCourses_Excel() throws Exception {

		

		ArrayList<String> actualcourse = new ArrayList<String>();
		
		for (WebElement course : actcourse) {
			actualcourse.add(course.getText());
		}
		System.out.println("Actaul course is : " + actualcourse);

		if (actualcourse.equals(Utilities.readDataofColm("D:\\Selenium\\JBKOfflineProject\\xls\\course.xls", "dashboard", 0))) {
			pageLogs().info("Courses are Match with Excelsheet");
			return true;
		} else {
			pageLogs().info("Courses are not Match with Excelsheet");
			return false;
		}

		
	}

	public boolean verifySubCourse() throws Exception {

		ArrayList<String> actualsub = new ArrayList<String>();
		
	    for (WebElement element : subcourse)
			actualsub.add(element.getText());

	    pageLogs().info("Actual course is : " + actualsub);
		
		if (actualsub.equals(Utilities.readDataofRow1("D:\\Selenium\\TestCase\\xls\\sub_course.xls", "test2", 0))) {
			pageLogs().info("SubCourses are Match with Excelsheet");
			return true;
		} else {
			pageLogs().info("SubCourses are not Match with Excelsheet");
			return false;
	 }
		
	}


	// Verify Footer Text

	public String VerifyFooterText() {

		String text = footer.getText();
		pageLogs().info("Footer text is : " + text);

		return text;

	}

	// Verify Footer Text

	public boolean verifyFooter() {

		String text = Utilities.getTextData(footertext);
		pageLogs().info("Footer text is : " + text);
		String expected = "Copyright © 2005-2019 JavaByKiran.";

		if (text.equals(expected)) {
			pageLogs().info("Text is Match.");
			return true;
		} else {
			pageLogs().info("Text is not Match.");
			return false;
		}

	}

	// Verify Header Text

	public boolean verifyHeader() {

		String text = Utilities.getTextData(header);
		pageLogs().info("Dashboard Page Text is: " + text);
		String expected = "Dashboard Courses Offered";

		if (text.equals(expected)) {
			pageLogs().info("Header Text is Match.");
			return true;
		} else {
			pageLogs().info("Header Text is not Match.");
			return false;
		}

	}

	public boolean verifyLogout_Button() {

		Utilities.click(logout);
		String text = Utilities.getTextData(logoutbtn);
		pageLogs().info("Page text is : " + text);
		String expected = "Logout successfully";

		if (text.equals(expected)) {
			pageLogs().info("Logout successfully");
			return true;
		} else {
			pageLogs().info("Logout is not Properly Working");
			return false;
		}

	}
	
	


}

