package com.qa.ibibo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ibibo.base.TestBase;

public class BookingDetails extends TestBase 
{
    @FindBy(xpath="//input[@placeholder='Enter First Name']")
    WebElement firstname;
    
    @FindBy(xpath="//input[@placeholder='Enter Last Name']")
    WebElement lastname;
    
    @FindBy(xpath="//input[@placeholder='Enter Email Address']")
    WebElement emailaddr;
    
   @FindBy(xpath="//input[@placeholder='Enter Phone Number']")
   WebElement phone_no;
   
   @FindBy(xpath="//input[@type='checkbox']")
   WebElement checkbox;
   
   @FindBy(xpath="//button[text()='Proceed To Payment Options']")
   WebElement procpaymnt;
   
   public BookingDetails()
   {
	   PageFactory.initElements(driver, this);
   }
   
   public void FillDetails()
   {
	   firstname.sendKeys("Gaurav");
	   lastname.sendKeys("Burhade");
	   emailaddr.sendKeys("gaurav.burhade77@gmail.com");
	   phone_no.sendKeys("9087979809");
	   //checkbox.click();
	   procpaymnt.click();
   }
   
}
