package com.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.UsefulLinksPage;

import jxl.read.biff.BiffException;

public class UsefulLinksPageTest extends TestBase{
	
	public WebDriver driver = null;
	public UsefulLinksPage ulp=null;	
	
		  @BeforeMethod
			public void Setup() throws Throwable {
			   driver=TestBase.OpenBrower();			   
				ulp = new UsefulLinksPage(driver);
				ulp=loadLoginPage().navigateToDashboardPage(driver).navigatetToUsefulLinksPage(driver);
			}
		  
		  @Test(priority=1)
		  public void verifyContentSortedAlphabetically_withExcel() {
			  try {
				Assert.assertTrue(ulp.ContentSortedAlphabeticallywithExcel());
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
		  
		  @Test(priority=2)
		  public void verifyUsefulLinkHeader() {
			  try {
				Assert.assertTrue(ulp.verifyHeaders_Of_UseFulLinks());
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
		  
		  @Test(priority=3)
		  public void verifyGoBtnIsEnabled() {
			  {
				Assert.assertTrue(ulp.verifyGoBtn_isEnabled());
			  } 
		  }
		  
		  @Test(priority=4)
			public void verifySerialNo() {
				{

					try {
						Assert.assertTrue(ulp.verifySerialNo_WithExcel());
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		  
		  @Test(priority=5)
		  public void verifyInterviewQustionWord() {
			  {
				try {
					Assert.assertTrue(ulp.verifyInterviewQuestionWord_WithSerialNo());
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			  } 
		  }
}
