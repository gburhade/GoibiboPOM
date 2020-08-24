package com.qa.ibibo.pages;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ibibo.base.TestBase;

public class HotelBookingPage extends TestBase
{
	@FindBy(xpath="//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")
	WebElement srchplace;
	
	@FindBy(xpath="//div[text()='Check-in']")
	WebElement checkindt;
	
	@FindBy(xpath="//div[text()='Check-out']")
	WebElement checkoutdt;
	
	@FindBy(xpath="//input[@value='2 Guests in 1 Room ']")
	WebElement guestroom;
	
	@FindBy(xpath="(//span[text()='-'])[2]")
	WebElement person;
	
	@FindBy(xpath="//button[text()='Done']")
	WebElement done;
	
	@FindBy(xpath="//button[text()='Search Hotels']")
	WebElement SearchHotels;
	
	@FindBy(xpath="//h4[text()='OYO 19684 Aishwariyaa Gardens']")
	WebElement hoteltitle;
	
	@FindBy(xpath="(//span[text()='Pay At Hotel'])[2]")
	WebElement payathot;
	
	@FindBy(xpath="(//div[contains(@class,'CheckBoxList__TextCenteredDiv-sc-5k7440-1 SMyDr')])[9]")
	WebElement rating;
	
	@FindBy(xpath="//span[text()='₹2001 - ₹4000']")
	WebElement pricerange;
	
	
	public HotelBookingPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	public String ValidatePageTitle()
	{
		return driver.getTitle();
	}
	
	public int bookingDetails(String place) throws InterruptedException
	{	
		int count = 1;
		 Thread.sleep(10000);
	     driver.findElement(By.xpath("//input[@placeholder='e.g. - Area, Landmark or Hotel Name']")).sendKeys(place);
		//srchplace.sendKeys(place);
		List<WebElement> findElements = driver.findElements(By.xpath("//li[@role='option']"));
		for(WebElement e : findElements)
		{
			e.click();
			break;
		}
		
		
		//selecting check in date
	    checkindt.click();
	    driver.findElement(By.xpath("//li/span[text()='21']")).click();
	    driver.findElement(By.xpath("//li/span[text()='22']")).click();
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//		List<WebElement> columns = checkindt.findElements(By.tagName("td"));
//		for(WebElement cell : columns)
//		{
//			if(cell.getText().equals("23"))
//			{
//				cell.findElement(By.linkText("23")).click();
//				break;
//			}
//		}
		
		//selecting checkout date
//		List<WebElement> columns2 = checkoutdt.findElements(By.tagName("td"));
//		for(WebElement cell : columns2)
//		{
//			if(cell.getText().equals("24"))
//			{
//				cell.findElement(By.linkText("24")).click();
//				break;
//			}
//		}
		
		guestroom.click();	
		person.click();
		done.click();
		SearchHotels.click();
//		Thread.sleep(3000);
//		int contentHeight = ((Number) js.executeScript("return window.innerHeight")).intValue();
//		//scrolling 
//		
//		while(true)
//		{
//			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
//			int height = ((Number)js.executeScript("return document.body.scrollHeight")).intValue();
//			if(contentHeight==height)
//				break;
//		}
		
		List<WebElement> hotels = driver.findElements(By.xpath("//h4[contains(@class,'dwebCommonstyles__SmallSectionHeader-sc-112ty3f-6 dmXrA')]"));
		for(WebElement e : hotels)
		{
			String str = e.getText();
			System.out.println(str);
			count++;
		}
		
		return count;
		
	}
	
	public String VerifyHotelTitle()
	{
		hoteltitle.click();
		//parent window handle id
		String mainWindowHandle = driver.getWindowHandle();
		//switching to child window 
		for(String childwindowHandle : driver.getWindowHandles())
		{
			if(!childwindowHandle.equals(mainWindowHandle))
			{
				driver.switchTo().window(childwindowHandle);
				break;
			}
		}
        String text = driver.findElement(By.xpath("//h3[text()='OYO 19684 Aishwariyaa Gardens']")).getText();
        return text;
	}
	
	public void filterPayAtHotel()
	{
		payathot.click();
	}
	
	public void filterByRating()
	{
		rating.click();
	}
	
	public void filterByPriceRange()
	{
		pricerange.click();
	}
	
	
	
}
