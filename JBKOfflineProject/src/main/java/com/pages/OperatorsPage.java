package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.jbk.Utility.Utilities;
import com.objectRepository.OperatorsPageObjectRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class OperatorsPage extends OperatorsPageObjectRepository{
	
	
	//getcellData method for ExcelSheet data 
	public OperatorsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCelldata(int row,int col) throws BiffException, IOException {
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls");
			wb = Workbook.getWorkbook(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Sheet sheets = wb.getSheet("Sheet1");
		Cell c = sheets.getCell(col, row);
		
			System.out.println();
			return c.getContents();
	}
	
	public boolean verifyCount_of_Person() {

		int actualsize = Utilities.getSize(personcolm);
		pageLogs().info(personcolm.size());

		pageLogs().info(serialno.size());
		int expectedsize = Utilities.getSize(serialno);
		
		if(actualsize==expectedsize) {
			pageLogs().info("Person counting is match");
			return true;
		}else {
			pageLogs().info("Person counting is not match");
			return false;
		}
	}
	
	public boolean verifyMobile_NoLimit() {
		
		int expectlength = 10;
		int actuallength = 0;
		for (WebElement elements : mobileno) {
			String str = Utilities.getTextData(elements);
			pageLogs().info("Mobile no is : " + str);
			actuallength = str.length();
			pageLogs().info("Length of mobile No is :" + actuallength);
			pageLogs().info("Length of mobile No is :" + expectlength);
							
		}
	
		if(actuallength==expectlength) {
			pageLogs().info(" Mobile number limit is match");
			return true;
		}else {
			pageLogs().info("Mobile number limit is not match");
			return false;
		}	
	}
	
	public boolean verifyPersonWithWhatsappOnly() throws Exception {
		
    ArrayList<String> actualhm = new ArrayList<String>();
		for(int i=0;i<personcolm.size();i++) {
					
			String wa = Utilities.getTextIndex(preferdWays, i);
			if(wa.contains("Whats App Only")) {
				String un = Utilities.getTextIndex(personcolm, i);
				actualhm.add(un+"="+wa);
			}			
			pageLogs().info(actualhm);
		}
		    
		if(actualhm.equals(Utilities.readDataofColmContains("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", "Whats App Only", 1, 3))) {
			pageLogs().info("Whatsapp Only is match with person");
			return true;
		}else {
			pageLogs().info("Whatsapp Only is not match");
			return false;
		}		

	}
	
	public boolean verifyTableHead_WithExcel() throws Exception {
		
	ArrayList<String> actualhead = new ArrayList<String>();

		for (WebElement element : headercolm)
			actualhead.add(Utilities.getTextData(element));

		pageLogs().info("Actual header is " + actualhead);

		if(actualhead.equals(Utilities.readDataofRow1("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", 0))) {
			pageLogs().info("Header is match");
			return true;
		}else {
			pageLogs().info("Header is not match");
			return false;
		}	

	}
	
	public boolean verifyPhoneSMSWhapsAppEmail_WithPerson() throws Exception {

		ArrayList<String> actual = new ArrayList<String>();

		for (int i = 0; i < personcolm.size(); i++) {
		
			String st = preferdWays.get(i).getText();
			if (st.contains("Whats App Phone Call SMS eMail")) {
				String un = personcolm.get(i).getText();
				actual.add(un+"="+st);
				pageLogs().info(actual);
			}
		}

		
		if(actual.equals(Utilities.readDataofColmContains("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", "Whats App Phone Call SMS eMail", 1, 3))) {
			pageLogs().info("whatsapp phone calls email sms is match");
			return true;
		}else {
			pageLogs().info("whatsapp phone calls email sms is not match");
			return false;
		}	
		
	}
	
	
	public boolean verifyPersonForJobs() throws Exception {

		ArrayList<String> actual = new ArrayList<String>();
		for (int i = 0; i < personcolm.size(); i++) {
			String key = personcolm.get(i).getText();
			String value = forjobcolm.get(i).getText();
				
				actual.add(key+"="+value);
		}

		if(actual.equals(Utilities.readDataofColm1("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", 1, 2))) {
			pageLogs().info("Person with job is match");
			return true;
		}else {
			pageLogs().info("Person with job is not match");
			return false;
		}			
	}
	
	public boolean verifyTechnicalWord_WithPerson() throws Exception {

		ArrayList<String>  actualhm = new ArrayList<String>();

		String key = null;
		String value = null;
		for (int i = 0; i < personcolm.size(); i++) {
			value = forjobcolm.get(i).getText();
			if (value.contains("Technical")) {
				key = personcolm.get(i).getText();

				actualhm.add(key+"="+value);
			}
			pageLogs().info(actualhm);
		}
		
		if(actualhm.equals(Utilities.readDataofColmContains("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", "Technical", 1, 2))) {
			System.out.println("Technical word with Person is match");
			return true;
		}else {
			pageLogs().info("Technical word with Person is not match");
			return false;
		}	
	}
	
		
	public boolean verifyEnquiryWord_WithPerson() throws Exception {

		ArrayList<String> actualhm = new ArrayList<String>();
		for (int i = 0; i < personcolm.size(); i++) {
			String key =null;
			String value=null;
			 value = Utilities.getTextIndex(forjobcolm, i);			
			if (value.contains("Enquiry")) {
				 key = Utilities.getTextIndex(personcolm, i);
				 actualhm.add(key+"="+value);
			}
			
			pageLogs().info(actualhm);
		}
		if(actualhm.equals(Utilities.readDataofColmContains("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", "Enquiry", 1, 2))) {
			pageLogs().info("Enquiry word with Person is match");
			return true;
		}else {
			pageLogs().info("Enquiry word with Person is not match");
			return false;
		}	
	
	}
	
	
	public boolean verifyPersonAvailableOn_AllDays_WeekDays() throws Exception {

		ArrayList<String> actual = new ArrayList<String>();

		for(int i=0;i<timingcolm.size();i++) {
			String days = Utilities.getTextIndex(timingcolm, i);
			if(days.contains("Monday-Sunday") || days.contains("Saturday-Sunday")) {
				actual.add(personcolm.get(i).getText());
			}
		}
		pageLogs().info(actual);
		
		if(actual.equals(Utilities.readDataofColmContainsOR("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", "Monday-Sunday", "Saturday-Sunday", 1, 5))) {
			pageLogs().info("Technical word with Person is match");
			return true;
		}else {
			pageLogs().info("Technical word with Person is not match");
			return false;
		}	
		 
	}
	
	public boolean verifySerialNo_WithExcel() throws Exception {

		ArrayList<String> actualsrn = new ArrayList<String>();
		
		for (WebElement element : serialno)
			actualsrn.add(Utilities.getTextData(element));

		pageLogs().info("Actual Serialno is " + actualsrn);

		if(actualsrn.equals(Utilities.readDataofColm0("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", 0))) {
			pageLogs().info("Serial no is match");
			return true;
		}else {
			pageLogs().info("Serial no is not match");
			return false;
		}
	}
	
	public boolean verifyDetail_Description_Of_Contact() throws Exception {
		
		ArrayList<String> actualhm = new ArrayList<String>();			 
		for (int i=0;i<forjobcolm.size();i++) {			
			
			String value=null;
			 String key = null;
			 String str = Utilities.getTextIndex(forjobcolm, i);
			 if(str.contains("(")) {
				 int firstindex = str.indexOf("(");
			    int lastindex = str.lastIndexOf(")");
			    
			  value  = str.substring(firstindex, lastindex+1);
			  key  = Utilities.getTextIndex(personcolm, i);
			  actualhm.add(key+"="+value);
			 } 
						 	
		}
		pageLogs().info(actualhm);
		
		
		if(actualhm.equals(Utilities.readDataofColmContainsBracket("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", "(", 1, 2))) {
			pageLogs().info("InBracket filed is match");
			return true;
		}else {
			pageLogs().info("Inbracket filed is not match");
			return false;
		}
	
	}
	
		

	public boolean verifyPersonAvailableForMaximumTime() throws Exception {
		
		  ArrayList<Double> al = new ArrayList<Double>();
		  double max=0;
		  
		for(WebElement time : timingcolm) {
			String text = Utilities.getTextData(time);
			double workTime =Utilities.getWorktime(text);
			
			if(workTime > max) {
				 max=workTime;
				 al.add(max);
			 }
		
	 }		 
		 System.out.println("MXIMUM working hours is :" +max);
	
		if(al.equals(Utilities.readDataofColmMaxTime("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", 5))) {
			pageLogs().info("Maximum time is match");
			return true;
		}else {
			pageLogs().info("Maximum time is not match");
			return false;
		}
	}
	
	
	public boolean verifyPerson_ContactnoWithTiming() throws Exception {
		
		  // HashMap<String, List<String>> ActualData=new HashMap<String, List<String>>();
		   ArrayList<String> ActualData=new ArrayList<String>();
		   for(int i=0;i<mobileno.size();i++)
		   {
			
			  String key= Utilities.getTextIndex(personcolm, i);
			 String contno= Utilities.getTextIndex(mobileno, i);
			 String time1= Utilities.getSubstring(timingcolm, i);
			
			 ActualData.add(key+"="+"["+contno+","+time1+"]");
		   }
		   pageLogs().info(ActualData);
		   
			if(ActualData.equals(Utilities.readDataofColmSubstring("D:\\Selenium\\JBKOfflineProject\\xls\\operators.xls", "Sheet1", 1, 4, 5))) {
				pageLogs().info("Person with contact no and time is match");
				return true;
			}else {
				pageLogs().info("Person with contact no and time is not match");
				return false;
			}
				   
		}

	

}
