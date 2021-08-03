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
import com.jbk.Utility.commonCode;
import com.objectRepository.DownloadsPageObjectRepository;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DownloadsPage extends DownloadsPageObjectRepository {
	WebDriver driver = null; 
	Workbook wb = null;

	
	public DownloadsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCelldata(int row, int col) throws BiffException, IOException {
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\Selenium\\JbkOfflineProject\\xls\\Downloads.xls");
			wb = Workbook.getWorkbook(fis);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Sheet sheets = wb.getSheet("downloads");
		Cell c = sheets.getCell(col, row);

		System.out.println();
		return c.getContents();
	}
/*
	public boolean verifyHeaderOf_DownloadsPage() throws BiffException, IOException {

		ArrayList<String> actualhead = new ArrayList<String>();

		for (WebElement element : headercolm)
			actualhead.add(Utilities.getTextData(element));

           pageLogs().info("Actual header is " + actualhead);

		// Expected data
		ArrayList<String> expectedhead = new ArrayList<String>();

		for (int i = 0; i < 2; i++) {
			// String data = getCelldata(i,7);
			// System.out.println(data);
			for (int j = 1; j <= 7; j++) {
				String val = getCelldata(i, j);
				pageLogs().info(val);
				expectedhead.add(val + "");
			}
		}
		pageLogs().info("Expected header is " + expectedhead);
		if (actualhead.equals(expectedhead)) {
			pageLogs().info("Header is match");
			return true;
		} else {
			pageLogs().info("Header is not match");
			return false;
		}

	}
*/
	public boolean verifyVendorOfGoogleChrome_withVersion() throws Exception {

		ArrayList<String> actualhm = new ArrayList<String>();

		String key = null;
		String value = null;
		for (int i = 0; i < vendorColm.size(); i++) {
			value = Utilities.getTextIndex(vendorColm, i);
			if (value.contains("Google Chrome")) {
				key = Utilities.getTextIndex(versionColm, i);
				actualhm.add(key+"="+value);
			}
			System.out.println(actualhm);;
		}
		

		if (actualhm.equals(Utilities.readDataofColmContains("D:\\Selenium\\JbkOfflineProject\\xls\\Downloads.xls", "downloads", "Google Chrome", 3, 2))) {
			pageLogs().info("Vender of Goolechrome is match");
			return true;
		} else {
			pageLogs().info("Vender of Goolechrome is not match");
			return false;
		}
	}

	public boolean verify_VendorOfSeleniumjar_withVersion() throws Exception {

		ArrayList<String> actualhm = new ArrayList<String>();

		String key = null;
		String value = null;
		for (int i = 0; i < vendorColm.size(); i++) {
			value = vendorColm.get(i).getText();
			if (value.contains("Selenium Server ")) {
				key = versionColm.get(i).getText();

				actualhm.add(key+"="+value);
			}

			pageLogs().info(actualhm);
		}

		if (actualhm.equals(Utilities.readDataofColmContains("D:\\Selenium\\JbkOfflineProject\\xls\\Downloads.xls", "downloads", "Selenium Server", 3, 2))) {
			pageLogs().info("Vender of Selenium Jar with version is match");
			return true;
		} else {
			pageLogs().info("Vender of Selenium Jar with version is not match");
			return false;
		}
	}

	public boolean verifyVendorAndVersionOf_32bit() throws Exception {

		HashMap<String,	List<String>> actualhm = new HashMap<String, List<String>>();

		
		String version=null;
		String vendor = null;
		for (int i = 0; i < vendorColm.size(); i++) {
			String key = Utilities.getTextIndex(bitTColm, i);
	
			 version = Utilities.getTextIndex(versionColm, i);
			 vendor = Utilities.getTextIndex(vendorColm, i);
	
			List<String> al = new ArrayList<String>();
			al.add(vendor);
			al.add(version);

			actualhm.put(key, al);
			System.out.println(actualhm);
		}
		
		
		if (actualhm.equals(Utilities.readDataofColmHshmap("D:\\Selenium\\JbkOfflineProject\\xls\\Downloads.xls", "downloads",4, 3, 2))) {
			pageLogs().info("Vender & Version of 32 bit is match");
			return true;
		} else {
			pageLogs().info("Vender & Version of 32 bit is not match");
			return false;
		}
	}

	public boolean verifyVendorAndVersionOf_64bit() throws Exception {

		HashMap<String, List<String>> actualhm = new HashMap<String, List<String>>();

		String version = null;
		String vendor = null;
		for (int i = 0; i < vendorColm.size(); i++) {
			String key =  Utilities.getTextIndex(bitSColm, i);

			version = Utilities.getTextIndex(versionColm, i);
			vendor = Utilities.getTextIndex(vendorColm, i);

			List<String> al = new ArrayList<String>();
			al.add(vendor);
			al.add(version);

			actualhm.put(key, al);
			pageLogs().info(actualhm);
		}


		if (actualhm.equals(Utilities.readDataofColmHshmap("D:\\Selenium\\JbkOfflineProject\\xls\\Downloads.xls", "downloads", 5, 3, 2))) {
			pageLogs().info("Vender & Version of 64 bit is match");
			return true;
		} else {
			pageLogs().info("Vender & Version of 64 bit is not match");
			return false;
		}
	}

	public boolean verifySerialNo_WithExcel() throws Exception {

		ArrayList<String> actualsrn = new ArrayList<String>();

		for (WebElement element : srnColm) {
			actualsrn.add(Utilities.getTextData(element));

		pageLogs().info("Actual Serialno is " + actualsrn);

		}
		
		if (actualsrn.equals(Utilities.readDataofColmOnly0("D:\\Selenium\\JbkOfflineProject\\xls\\Downloads.xls", "downloads", 0))) {
			pageLogs().info("SerialNo with Excel is match");
			return true;
		} else {
			pageLogs().info("SerialNo with Excel is not match");
			return false;
		}
	}

	public boolean verifyVendorsFor_32bitAnd64bit() throws Exception {

		HashMap<String, List<String>> actualhm = new HashMap<String, List<String>>();
		for (int i = 0; i < vendorColm.size(); i++) {
			String key = vendorColm.get(i).getText();

			String bitT = bitTColm.get(i).getText();
			String bitS = bitSColm.get(i).getText();

			List<String> al = new ArrayList<String>();
			al.add(bitT);
			al.add(bitS);

			actualhm.put(key, al);

		}
		pageLogs().info(actualhm);


		if (actualhm.equals(Utilities.readDataofColmHshmap("D:\\Selenium\\JbkOfflineProject\\xls\\Downloads.xls", "downloads", 2, 5, 4))) {
			pageLogs().info("Vender of 32bit & 64bit is match");
			return true;
		} else {
			pageLogs().info("Vender 32bit & 64bi is not match");
			return false;
		}
	}

	public boolean verifyCommonVendors() throws Exception {


		HashMap<String, String> actualhm = new HashMap<String, String>();
		String key = null;
		String value = null;
		for (int i = 0; i < vendorColm.size(); i++) {
			value = vendorColm.get(i).getText();

			key = commonlist.get(i).getText();
			actualhm.put(key, value);
			pageLogs().info(actualhm);
		}

		if (actualhm.equals(Utilities.readDataofColm22("D:\\Selenium\\JbkOfflineProject\\xls\\Downloads.xls", "downloads", 6, 2))) {
			pageLogs().info("Common Vender is match");
			return true;
		} else {
			pageLogs().info("Common Vender not match");
			return false;
		}
	}

}
