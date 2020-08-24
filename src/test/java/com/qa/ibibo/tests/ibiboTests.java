package com.qa.ibibo.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ibibo.base.TestBase;
import com.qa.ibibo.pages.BookingDetails;
import com.qa.ibibo.pages.HomePage;
import com.qa.ibibo.pages.HotelBookingPage;
import com.qa.ibibo.pages.HotelDetailsPage;
import com.qa.ibibo.pages.PaymentDetailsPage;

public class ibiboTests extends TestBase
{
	HomePage homePage;
	HotelBookingPage bookpage;
	HotelDetailsPage  hdp;
	BookingDetails bdet;
	PaymentDetailsPage pymntdetpg; 
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialisation();
		homePage = new HomePage();
		bookpage = new HotelBookingPage();
		hdp = new HotelDetailsPage();
		bdet = new BookingDetails();
		pymntdetpg = new PaymentDetailsPage();
	}
	
  @Test
  public void availableHotelDetails() throws InterruptedException 
  {
	  homePage.clickonHotelsMenu();
	  String title = bookpage.ValidatePageTitle();
	  Assert.assertEquals(title, "Online Hotel Booking | Book Cheap, Budget and Luxury Hotels -Goibibo");
	  int totcount = bookpage.bookingDetails("Pune");
	  System.out.println(totcount);
  }
  
  @Test
  public void bookHotel() throws InterruptedException
  {
	  homePage.clickonHotelsMenu();
	  String title = bookpage.ValidatePageTitle();
	  Assert.assertEquals(title, "Online Hotel Booking | Book Cheap, Budget and Luxury Hotels -Goibibo");
	  int totcount = bookpage.bookingDetails("Ooty");
	  System.out.println(totcount);
	  String hottitle = bookpage.VerifyHotelTitle();
	  Assert.assertEquals(hottitle, "OYO 19684 Aishwariyaa Gardens");
	  hdp.SelectRoom();
	  bdet.FillDetails();
	  pymntdetpg.fillCardDetails();
  }
  
  @Test
  public void HotelSections() throws InterruptedException
  {
	  homePage.clickonHotelsMenu();
	  String title = bookpage.ValidatePageTitle();
	  Assert.assertEquals(title, "Online Hotel Booking | Book Cheap, Budget and Luxury Hotels -Goibibo");
	  int totcount = bookpage.bookingDetails("Ooty");
	  System.out.println(totcount);
	  String hottitle = bookpage.VerifyHotelTitle();
	  Assert.assertEquals(hottitle, "OYO 19684 Aishwariyaa Gardens");
	  boolean val = hdp.clickonRoomsMenu();
	  Assert.assertTrue(val);
	  boolean locval = hdp.clickonLocation();
	  Assert.assertTrue(locval);
	  boolean grloc = hdp.clickonGuestReview();
	  Assert.assertTrue(grloc);
	  boolean qaloc = hdp.clickonQuestionAnswer();
	  Assert.assertTrue(qaloc);
	  boolean hploc = hdp.clickonHotelPolicy();
	  Assert.assertTrue(hploc);
  }
  
  @Test
  public void applyFilter() throws InterruptedException
  {
	  homePage.clickonHotelsMenu();
	  String title = bookpage.ValidatePageTitle();
	  Assert.assertEquals(title, "Online Hotel Booking | Book Cheap, Budget and Luxury Hotels -Goibibo");
	  int totcount = bookpage.bookingDetails("Ooty");
	  System.out.println(totcount);
	  bookpage.filterPayAtHotel();
	  bookpage.filterByRating();
	  bookpage.filterByPriceRange();
  }
  
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
  
}
