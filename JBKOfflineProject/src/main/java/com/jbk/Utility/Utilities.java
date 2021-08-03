package com.jbk.Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import jxl.Cell;
import jxl.Sheet;
import jxl.read.biff.BiffException;

public class Utilities {
	public static jxl.Workbook wb=null;
	public  static void clearText(WebElement elements) {
		elements.clear();
	}
	
	public static void click(WebElement elements) {
		elements.click();
	}
	
	public static String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static boolean displayedIs(WebElement elements) {
		return elements.isDisplayed();
	}
	
	public static boolean enabledIs(WebElement elements) {
		return elements.isEnabled();
	}
	
	public static void enterText(WebElement elements,String value) {
		elements.sendKeys(value);
	}
	
	public static String getTextData(WebElement elements) {
		return elements.getText();
	}
	
	public static String getTextIndex(List<WebElement> elements,int i) {
		return elements.get(i).getText();
	}
	
	public static String getSubstring(List<WebElement> elements,int i) {
		return elements.get(i).getText().substring(0, 20);
	}
	
	public static int getSize(List<WebElement> elements) {
		return elements.size();		
	}
	
	
	
	
public static ArrayList<String> readDataofColmSort(String fileName,String sheetName,int colNo) throws Exception{
		
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		wb = jxl.Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getRows();
		for(int i=1;i<row-1;i++) {
			String val=sh.getCell(colNo, i).getContents();		
			expList.add(val);
			Collections.sort(expList);
		}
		System.out.println(expList);
		return expList;
		
	}	
	
public static ArrayList<String> readDataofColm0(String fileName,String sheetName,int colNo) throws Exception{
		
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		wb = jxl.Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getRows();
		for(int i=1;i<row-1;i++) {
			String val=sh.getCell(colNo, i).getContents();
			String data="0"+val;
			expList.add(data);
		}
		System.out.println(expList);
		return expList;
		
	}
	
	public static ArrayList<String> readDataofColm(String fileName,String sheetName,int colNo) throws Exception{
		
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		wb = jxl.Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getRows();
		for(int i=0;i<row;i++) {
			expList.add(sh.getCell(colNo, i).getContents());
		}
		System.out.println(expList);
		return expList;
		
	}
	
public static ArrayList<String> readDataofColm2(String fileName,String sheetName,int colNo) throws Exception{
		
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		wb = jxl.Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getRows();
		for(int i=1;i<row-1;i++) {
			expList.add(sh.getCell(colNo, i).getContents());
		}
		System.out.println(expList);
		return expList;
		
	}

public static ArrayList<Double> readDataofColmMaxTime(String fileName,String sheetName,int colNo) throws Exception{
	double maxex=0;
	ArrayList<Double> expList = new ArrayList<Double>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int row = sh.getRows();
	for(int i=1;i<row-1;i++) {
		String data=sh.getCell(colNo, i).getContents();
		double expectedworkTime = ExcelgetWorktime(data);
		if(expectedworkTime > maxex) {
			maxex=expectedworkTime;
			expList.add(maxex);
		 }
	}
	System.out.println(expList);
	return expList;
	
}
	
public static ArrayList<String> readDataofColm1(String fileName,String sheetName,int colNo1,int colNo2) throws Exception{
		
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		wb = jxl.Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getRows();
		for(int i=1;i<row-1;i++) {
			expList.add(sh.getCell(colNo1, i).getContents()+"="+sh.getCell(colNo2, i).getContents());
		
		}
		System.out.println("Expected Data: "+expList);
		return expList;
		
	}


public static HashMap<String, String> readDataofColm22(String fileName,String sheetName,int colNo1,int colNo2) throws Exception{
	
	HashMap<String, String> expList = new HashMap<String, String>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	//int row = sh.getRows();
	for(int i=2;i<=8;i++) {
		String key =sh.getCell(colNo1, i).getContents();
		String value=sh.getCell(colNo2, i).getContents();
		expList.put(key,value);
		System.out.println("Expected Data: "+expList);
	}

	return expList;
	
}

public static ArrayList<String> readDataofColmEquals0(String fileName,String sheetName,String name,int colNo1,int colNo2) throws Exception{
	
	ArrayList<String> expList = new ArrayList<String>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int row = sh.getRows();
	for(int i=1;i<row-1;i++) {
		String key=sh.getCell(colNo1, i).getContents();
		
		if(key.contains(name)) {
			String value=sh.getCell(colNo2, i).getContents();
			String data = "0"+value;
			expList.add(key+"="+data);
		}
			
	}
	System.out.println("Expected Data: "+expList);
	return expList;
	
}

public static ArrayList<String> readDataofColmOnly0(String fileName,String sheetName,int colNo1) throws Exception{
	
	ArrayList<String> expList = new ArrayList<String>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int row = sh.getRows();
	for(int i=2;i<row;i++) {
		String value=sh.getCell(colNo1, i).getContents();
		String data = "0" + value;
		expList.add(data);
	
			
	}
	System.out.println("Expected Data: "+expList);
	return expList;
	
}

public static ArrayList<String> readDataofColmContains(String fileName,String sheetName,String name,int colNo1,int colNo2) throws Exception{
	
	ArrayList<String> expList = new ArrayList<String>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int row = sh.getRows();
	for(int i=1;i<row-1;i++) {
		String key=sh.getCell(colNo2, i).getContents();		
		if(key.contains(name)) {
			String value=sh.getCell(colNo1, i).getContents();
			
			expList.add(value+"="+key);
		}
			
	}
	System.out.println("Expected Data: "+expList);
	return expList;
	
}

public static ArrayList<String> readDataofColmContainsBracket(String fileName,String sheetName,String name,int colNo1,int colNo2) throws Exception{
	
	ArrayList<String> expList = new ArrayList<String>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int row = sh.getRows();
	String  expvalue=null;
	String expkey=null;
	for(int i=1;i<row-1;i++) {
			
		String text=sh.getCell(colNo2, i).getContents();
		if(text.contains(name)) {
			 int firstindex = text.indexOf("(");
			 int lastindex = text.lastIndexOf(")");
			 expvalue = text.substring(firstindex, lastindex+1);
			 	
			 expkey =sh.getCell(colNo1, i).getContents();
				expList.add(expkey+"="+expvalue);
			
		}
					
	}
	System.out.println("Expected Data: "+expList);
	return expList;
	
}


public static ArrayList<String> readDataofColmContainsOR(String fileName,String sheetName,String name1,String name2,int colNo1,int colNo2) throws Exception{
	
	ArrayList<String> expList = new ArrayList<String>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int row = sh.getRows();
	for(int i=1;i<row-1;i++) {
		String key=sh.getCell(colNo2, i).getContents();		
		if(key.contains(name1) || key.contains(name2)) {
		
			expList.add(sh.getCell(colNo1, i).getContents());
		}
			
	}
	System.out.println("Expected Data: "+expList);
	return expList;
	
}


public static ArrayList<String> readDataofColmSubstring(String fileName,String sheetName,int colNo1,int colNo2,int colNo3) throws Exception{
	
	ArrayList<String> expList = new ArrayList<String>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int row = sh.getRows();
	for(int i=1;i<row-1;i++) {
		String key=sh.getCell(colNo1, i).getContents();		
		String contno=sh.getCell(colNo2, i).getContents();	
		String time1=sh.getCell(colNo3, i).getContents().substring(0, 20);
		
		expList.add(key+"="+"["+contno+","+time1+"]");
			
	}
	System.out.println("Expected Data: "+expList);
	return expList;
	
}


public static HashMap<String,List<String>> readDataofColmHshmap(String fileName,String sheetName,int colNo1,int colNo2,int colNo3) throws Exception{
	
	HashMap<String,	List<String>> expList = new HashMap<String,	List<String>>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int row = sh.getRows();
	String version=null;
	String vendor = null;
	for (int i = 0; i < row; i++) {
		String key = sh.getCell(colNo1, i).getContents();	

		 version = sh.getCell(colNo2, i).getContents();
		 vendor = sh.getCell(colNo3, i).getContents();

		List<String> al = new ArrayList<String>();
		al.add(vendor);
		al.add(version);

		expList.put(key, al);
		
	}
	System.out.println("Expected Data: "+expList);
	return expList;
	
}
	
public static ArrayList<String> readDataofColmRow(String fileName,String sheetName,int colno,int rowno) throws Exception{
		
		ArrayList<String> expList = new ArrayList<String>();
		FileInputStream fis = new FileInputStream(fileName);
		wb = jxl.Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet(sheetName);
		int row = sh.getRows();
		int col=sh.getColumns();
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
			expList.add(sh.getCell(col, row).getContents());
		}
	}
		System.out.println(expList);
		return expList;
		
	}

  public static ArrayList<String> readDataofRow1(String fileName,String sheetName,int rowNo) throws Exception{
	
	ArrayList<String> expList = new ArrayList<String>();
	FileInputStream fis = new FileInputStream(fileName);
	wb = jxl.Workbook.getWorkbook(fis);
	Sheet sh = wb.getSheet(sheetName);
	int col = sh.getColumns();
	for(int j=0;j<col;j++) {
		expList.add(sh.getCell(j, rowNo).getContents());
	}
	System.out.println(expList);
	return expList;
	
}
  
  
/*
  public static String getCelldata(String fileName,String sheetName,int row,intcol1) throws BiffException, IOException { 
  FileInputStream fis;
   try { 
  fis = new FileInputStream(fileName); 
  wb = jxl.Workbook.getWorkbook(fis); 
  } catch(FileNotFoundException e) {
  
  e.printStackTrace(); 
  }  
  Sheet sheets = wb.getSheet(sheetName);
   Cell c = sheets.getCell(col1, row);
  
  System.out.println(); 
  return c.getContents(); }
 */

  public static double getWorktime(String text ) {
		 double inTimeint =0;
		  double outTimeint =0;
		 int min=0;
		 double workingTime =0;
		int firstindex = text.indexOf(':');
		int lastindex =text.lastIndexOf(':');
		
	    String inTime =	text.substring(firstindex-2, firstindex+6);
	    String outTime = text.substring(lastindex-2, lastindex+6);
	   System.out.println((inTime+ " "+outTime));
	    
	    if(inTime.contains("PM"))
	    	inTimeint =Integer.parseInt(inTime.substring(0,2))+12;
	    else
	    	inTimeint =Integer.parseInt(inTime.substring(0,2));
	    
	    
	    if(outTime.contains("PM"))
	    	outTimeint = Integer.parseInt(outTime.substring(0,2))+12;
	    else
	    	outTimeint =Integer.parseInt(outTime.substring(0,2));
	    
	    if(!text.substring(firstindex+1, firstindex+3).equals("00")) {
	    	 min = Integer.parseInt(text.substring(firstindex+1,firstindex+3));
	         double m =(double) min/60;
	         inTimeint = inTimeint +m;
	    
	       }   
				if (!text.substring(lastindex + 1, lastindex + 3).equals("00"))	{					
				 min =Integer.parseInt(text.substring(lastindex+1,lastindex+3)); 					
				 outTimeint = outTimeint+ min/60;					
				
			}									
				 workingTime = outTimeint-inTimeint;
				System.out.println("Working Hours : "+workingTime);
				 System.out.println(inTimeint + "  " +outTimeint);
				 
				
				 return workingTime;	
	}	
	public static double ExcelgetWorktime(String data ) {
		 double inTimeint =0;
		  double outTimeint =0;
		 int min=0;
		 double workingTime =0;
		int firstindex = data.indexOf(':');
		int lastindex =data.lastIndexOf(':');
		
	    String inTime =	data.substring(firstindex-2, firstindex+6);
	    String outTime = data.substring(lastindex-2, lastindex+6);
	    System.out.println(inTime+ " "+outTime);
	    
	    if(inTime.contains("PM"))
	    	inTimeint =Integer.parseInt(inTime.substring(0,2))+12;
	    else
	    	inTimeint =Integer.parseInt(inTime.substring(0,2));
	    
	    
	    if(outTime.contains("PM"))
	    	outTimeint = Integer.parseInt(outTime.substring(0,2))+12;
	    else
	    	outTimeint =Integer.parseInt(outTime.substring(0,2));
	    
	    if(!data.substring(firstindex+1, firstindex+3).equals("00")) {
	    	 min = Integer.parseInt(data.substring(firstindex+1,firstindex+3));
	         double m =(double) min/60;
	         inTimeint = inTimeint +m;
	    
	       }   
				if (!data.substring(lastindex + 1, lastindex + 3).equals("00"))	{					
				 min =Integer.parseInt(data.substring(lastindex+1,lastindex+3)); 					
				 outTimeint = outTimeint+ min/60;					
				
			}									
				 workingTime = outTimeint-inTimeint;
				//System.out.println("Working Hours : "+workingTime);
				// System.out.println(inTimeint + "  " +outTimeint);
				 
				 return workingTime;		 	
	}
	

}
