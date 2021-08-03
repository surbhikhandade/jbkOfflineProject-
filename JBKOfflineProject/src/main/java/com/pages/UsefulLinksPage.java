package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbk.Utility.Utilities;
import com.objectRepository.UsefulLinksPageObjectRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class UsefulLinksPage extends UsefulLinksPageObjectRepository {
	public WebDriver driver;
	public Workbook wb=null;
	
	
	public UsefulLinksPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//getCellData method for ExcelSheet Data read
	public String getCelldata(int row,int col) throws BiffException, IOException {
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\Selenium\\TestCase\\xls\\useful_links.xls");
			wb = Workbook.getWorkbook(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Sheet sheets = wb.getSheet("useful");
		Cell c = sheets.getCell(col, row);
		
			System.out.println();
			return c.getContents();
	}
	
	
	public boolean ContentSortedAlphabeticallywithExcel() throws Exception {

		ArrayList<String> obtainedList = new ArrayList<String>();
		
		for (WebElement we : contendscolm) {
			obtainedList.add(Utilities.getTextData(we));
		}
		Collections.sort(obtainedList);		
		System.out.println(obtainedList);
	
		if(obtainedList.equals(Utilities.readDataofColmSort("D:\\Selenium\\JBKOfflineProject\\xls\\useful_links.xls", "useful", 1))) {
			System.out.println("Alphabetically Sorted is match");
			return true;
		}else {
			System.out.println("Alphabetically Sorted is not match");
			return false;
		}
	}
	
	
	public boolean verifyHeaders_Of_UseFulLinks() throws Exception {
		
		ArrayList<String> actualheaders = new ArrayList<String>();
		for (WebElement element : headerlist)
			actualheaders.add(Utilities.getTextData(element));

		System.out.println("Actual header is " + actualheaders);
		
		if(actualheaders.equals(Utilities.readDataofRow1("D:\\Selenium\\JBKOfflineProject\\xls\\useful_links.xls", "useful", 0))) {
			System.out.println("Header is match");
			return true;
		}else {
			System.out.println("Header is not match");
			return false;
		}

	}
	
     public boolean verifyGoBtn_isEnabled() {

		for(WebElement elements : gobtns) {
			
			boolean btn = Utilities.displayedIs(elements);
		}
		return true;
		
	}
	
     public boolean verifySerialNo_WithExcel() throws Exception {

 		ArrayList<String> actualsrn = new ArrayList<String>();

 		for (WebElement element : serialnocom)
 			actualsrn.add(Utilities.getTextData(element));

 		System.out.println("Actual Serialno is " + actualsrn);
 		
		 if(actualsrn.equals(Utilities.readDataofColm0("D:\\Selenium\\JBKOfflineProject\\xls\\useful_links.xls", "useful", 0))) {
 			 System.out.println("serial no is match");
 			 return true;
 		 }else {
 			 System.out.println("serial no is not match");
 			 return false;
 		 } 		 
 	}
     
     
     public boolean verifyInterviewQuestionWord_WithSerialNo() throws Exception {

    	  ArrayList<String> al = new ArrayList<String>();
 		
 		String key = null;
 		String value = null;
 		for (int i = 0; i < contendscolm.size(); i++) {
 			key = contendscolm.get(i).getText();
 			if (key.contains("Interview Questions")) {
 				value = serialnocom.get(i).getText();

 				al.add(key+"="+value);
 			}

 			System.out.println(al);
 		}

 

 		 if(al.equals(Utilities.readDataofColmEquals0("D:\\Selenium\\JBKOfflineProject\\xls\\useful_links.xls", "useful","Interview Questions", 1, 0))) {
 			 System.out.println("Interview Question word is match");
 			 return true;
 		 }else {
 			 System.out.println("Interview Question word is not match");
 			 return false;
 		 } 		 
		
 	}
     
     
}
