package com.qa.ibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.ibibo.base.TestBase;

public class HomePage extends TestBase
{
	
	@FindBy(xpath="(//span[text()='Hotels'])[1]")
	WebElement hotels;
	
	
	public HomePage() throws Exception
	 {
		 PageFactory.initElements(driver, this);
	 }
	
	public void clickonHotelsMenu()
	{
		driver.findElement(By.xpath("(//span[text()='Hotels'])[1]")).click();
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Where']")));
	}
	

}
