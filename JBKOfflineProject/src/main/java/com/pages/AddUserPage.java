package com.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.objectRepository.AddUserPageObjectRepository;

public class AddUserPage extends AddUserPageObjectRepository {

	public WebDriver driver = null;

	public AddUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyWithout_Fill_Info_ErrorShow() {

		// driver.findElement(By.xpath("//button[text()='Add User']")).click();
		String actualmsg = uname.getAttribute("validationMessage");
		System.out.println("Validation popup alert is :" + actualmsg);
		String expectedmsg = "Please fill out this field.";

		if (actualmsg.equals(expectedmsg)) {
			System.out.println("Error Message is show");
			return true;
		} else {
			System.out.println("Error Message is not show");
			return false;

		}
	}

	@Test(priority = 2)
	public boolean verifyEmail_Error() {

		// driver.findElement(By.xpath("//button[text()='Add User']")).click();
		username.sendKeys("surbhi");
		mobileno.sendKeys("23042021");
		email.sendKeys("surbhigmail.com");
		course.sendKeys("java/selenium");
		WebElement radio = gender;
		radio.click();
		WebElement dropdown = select;
		Select ss = new Select(dropdown);
		ss.selectByVisibleText("Maharashtra");
		pass.sendKeys("12345678");
		clickbtn.click();
		
		String actualmsg = driver.findElement(By.id("email")).getAttribute("validationMessage");
		String expectedmsg = "Please include an '@' in the email address. 'surbhigmail.com' is missing an '@'.";
		System.out.println("Validation popup alert is :" + actualmsg);

		if (actualmsg.equals(expectedmsg)) {
			System.out.println("Email Error Message is show");
			return true;
		} else {
			System.out.println("Email Error Message is not show");
			return false;

		}
	}

	@Test(priority = 3)
	public boolean verifyDroupdown_SelectError() {

		// driver.findElement(By.xpath("//button[text()='Add User']")).click();
		username.sendKeys("surbhi");
		mobileno.sendKeys("23042021");
		email.sendKeys("surbhi@gmail.com");
		course.sendKeys("java/selenium");
		WebElement radio = gender;
		radio.click();
		pass.sendKeys("12345678");
		clickbtn.click();
		;

		String actualmsg = driver.findElement(By.tagName("select")).getAttribute("validationMessage");
		String expectedmsg = "Please select an item in the list.";
		System.out.println("Validation popup alert is :" + actualmsg);

		if (actualmsg.equals(expectedmsg)) {
			System.out.println("Droupdown Error Message is show");
			return true;
		} else {
			System.out.println("Droupdown Error Message is not show");
			return false;

		}
	}

	public boolean verifyAdduser() {
		if (driver.getTitle().contains("User"))

		username.sendKeys("surbhi");
		mobileno.sendKeys("23042021");
		email.sendKeys("surbhi@gmail.com");
		course.sendKeys("java/selenium");
		WebElement radio = gender;
		radio.click();
		WebElement dropdown = select;
		Select ss = new Select(dropdown);
		ss.selectByVisibleText("Maharashtra");
		pass.sendKeys("12345678");
		clickbtn.click();


		Alert al = driver.switchTo().alert();
		String msg = al.getText();
		al.accept();
		String expected = "User Added Successfully. You can not see added user.";

		if (msg.equals(expected)) {
			System.out.println("Alert is handled");
			return true;
		} else {
			System.out.println("Alert is not handled");
			return false;

		}
	}
	
}
