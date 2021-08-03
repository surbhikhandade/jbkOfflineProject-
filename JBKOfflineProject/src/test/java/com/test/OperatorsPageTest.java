package com.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.OperatorsPage;
import com.pages.UserPage;

import jxl.read.biff.BiffException;

public class OperatorsPageTest extends TestBase {
	public WebDriver driver = null;
	public OperatorsPage op = null;

	@BeforeMethod
	public void Setup() throws Throwable {
		
		driver = OpenBrower();
		op = loadLoginPage().navigateToDashboardPage(driver).navigatetToOperatorsPage(driver);
		op = new OperatorsPage(driver);
		driver.manage().window().maximize();
		System.out.println("Open JBK Website");
	}

	@AfterMethod
	public void close() {
		driver.close();
	}

	@Test(priority = 1)
	public void verifyPersonCount() {
		testLogs().info("verify count of person on operator page");
		Assert.assertTrue(op.verifyCount_of_Person());
		
	}

	@Test(priority = 2)
	public void verifyMobileNoLimit() {
		testLogs().info("verify Mobile number limit on operator page");
		Assert.assertTrue(op.verifyMobile_NoLimit());
		
	}

	@Test(priority = 3)
	public void verifyPerson_WithWhatsAppOnly() {
		testLogs().info("verify person with Whatsapp Only on operator page");
		try {
			Assert.assertTrue(op.verifyPersonWithWhatsappOnly());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test(priority = 4)
	public void verifyOperatorsHeader() throws Exception {
		testLogs().info("verify Table Header on operator page");
		try {
			Assert.assertTrue(op.verifyTableHead_WithExcel());
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Test(priority = 5)
	public void verifyAllModesWithPerson() {
		testLogs().info("verify All modes with person on operator page");
		try {
			Assert.assertTrue(op.verifyPhoneSMSWhapsAppEmail_WithPerson());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Test(priority = 6)
	public void verifypersonForJob() {
		testLogs().info("verify person for job on operator page");
		try {
			Assert.assertTrue(op.verifyPersonForJobs());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test(priority = 7)
	public void verifyTechnicalWord() {
		testLogs().info("verify Technical Word on operator page");
		try {
			Assert.assertTrue(op.verifyTechnicalWord_WithPerson());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test(priority = 8)
	public void verifyEnquiryWord() {
		testLogs().info("verify Enquiry word on operator page");
		try {
			Assert.assertTrue(op.verifyEnquiryWord_WithPerson());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test(priority = 9)
	public void verifyPersonAvailableOnAlldays_WeekDays() {
		testLogs().info("verify Person Available on All days and weekdays on operator page");
		try {
			Assert.assertTrue(op.verifyPersonAvailableOn_AllDays_WeekDays());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test(priority = 10)
	public void verifySerialNo() {
		testLogs().info("verify serial no. on operator page");
		try {
			Assert.assertTrue(op.verifySerialNo_WithExcel());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test(priority = 11)
	public void verifyDetailDescriptionOfcontact() {
		testLogs().info("verify Detail Description of contact on operator page");
		try {
			Assert.assertTrue(op.verifyDetail_Description_Of_Contact());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Test(priority = 12)
	public void verifyPersonAvailable_For_MaxTime() {
		testLogs().info("verify Person Available fpr maximum time on operator page");
		try {
			Assert.assertTrue(op.verifyPersonAvailableForMaximumTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test(priority = 13)
	public void verifyContactnoTimeWithPerson() {
		testLogs().info("verify contact number and time with person on operator page");
		try {
			Assert.assertTrue(op.verifyPerson_ContactnoWithTiming());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
