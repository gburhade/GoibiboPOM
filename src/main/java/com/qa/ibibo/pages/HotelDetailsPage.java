package com.qa.ibibo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ibibo.base.TestBase;

public class HotelDetailsPage extends TestBase 
{

	@FindBy(xpath="(//button[contains(@class,'ButtonBase-sc-112ty3f-9 RoomFlavorstyles')])[1]")
	WebElement selroom;
	
	@FindBy(linkText="Room Options")
	WebElement roomopt;
	
	@FindBy(linkText="Location")
	WebElement location;
	
	@FindBy(linkText="Guest Reviews")
	WebElement guestrev;
	
	@FindBy(linkText="Questions & Answers")
	WebElement Quesans;
	
	@FindBy(linkText="Hotel Policies")
	WebElement hotpolicy;
	
	public HotelDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void SelectRoom()
	{
		selroom.click();
	}
	
	public boolean clickonRoomsMenu()
	{
		roomopt.click();
		boolean value = driver.findElement(By.xpath("//p[text()='Room Options']")).isDisplayed();
		return value;
	}
	
	public boolean clickonLocation()
	{
		location.click();
		boolean value = driver.findElement(By.xpath("//div[@title='Show street map']")).isDisplayed();
		return value;
	}
	
	public boolean clickonGuestReview()
	{
		guestrev.click();
		boolean value = driver.findElement(By.xpath("//div/p[text()='goRating']")).isDisplayed();
		return value;
	}
	
	public boolean clickonQuestionAnswer()
	{
		Quesans.click();
		boolean value = driver.findElement(By.xpath("//div/p[text()='Search Question']")).isDisplayed();
		return value;
	}
	
	public boolean clickonHotelPolicy()
	{
		hotpolicy.click();
		boolean value = driver.findElement(By.id("hotel-policies")).isDisplayed();
		return value;
	}
	
	
}
