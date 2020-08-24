package com.qa.ibibo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ibibo.base.TestBase;

public class PaymentDetailsPage extends TestBase
{
	
	@FindBy(name="cardnumber")
	WebElement carno;
	
	@FindBy(name="ccname")
	WebElement cname;
	
	@FindBy(name="cardExpiry")
	WebElement cardexp;
	
	@FindBy(name="cardCVV")
	WebElement cvv;
	
	@FindBy(xpath="(//button[contains(@class,'button green')])[1]")
	WebElement paynow;
	
	public PaymentDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void fillCardDetails()
	{
		carno.sendKeys("4212345678902345");
		cname.sendKeys("Gaurav Burhade");
		cardexp.sendKeys("11/25");
		cvv.sendKeys("123");
		paynow.click();
	}
	
}
