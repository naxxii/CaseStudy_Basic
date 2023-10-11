package com.flipkart;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseClass;
import ObjectsFlipkart.FlipkartObjects;

public class flipkartSearch extends BaseClass {
		
	@Test(priority=1,enabled=true)
	public void logoTest() throws InterruptedException {
		FlipkartObjects Objects1 = new FlipkartObjects(driver);
		//open URL
		driver.get(baseURLFlipkart);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		boolean lightBox = Objects1.lightBoxMethod().isDisplayed();
		//If light box found close that
		if(lightBox)
		{
			Objects1.lightBoxMethod().click();
		}
		
		System.out.println("Is Flipkart logo is diaplaying on top left ? "+Objects1.flipkartLogoMethod().isDisplayed());
		
	}
	@Test(priority=2,enabled=true)
	public void openSearchResults() throws InterruptedException {
		FlipkartObjects Objects = new FlipkartObjects(driver);		
		//search iphone 14
		Objects.searchTextMethod("iphone 14");
		Thread.sleep(1000);
		//click on search button
		Objects.searchBtnMethod().click();

		Thread.sleep(5000);
		//storing search results in to SResults
		List<WebElement> SResults =  (List<WebElement>) Objects.searchResultsMethod() ;
		
		//displaying number of items present in page 1
		System.out.println(" number of Items in Page 1 is: "+SResults.size());	
		
		//selecting first link in search results
		String selectedMobile = SResults.get(0).getText();
		SResults.get(0).click();
		
		//Storing window handles in to handles
		Set<String> handles = driver.getWindowHandles();
		
		//getting parent and child window IDs
		Iterator itr = handles.iterator();
		String ParentWindowId = (String) itr.next();
		System.out.println("Parent window ID is: "+ParentWindowId);		
		String childWindowID = (String) itr.next();
		System.out.println("Child window ID is: "+childWindowID);
		
		//switching to new window after selecting a link from search results
		driver.switchTo().window(childWindowID);
		
		String OpenedMobile = Objects.OpenedMobileMethod().getText();
		//comparing selected link and opened page are related to selected phone or not
		if(selectedMobile.equals(OpenedMobile))
		{
			System.out.println("Opened Page is related to selected Mobile only");
		}else
		{
			System.out.println("Opened Page is not related to selected Mobile");
		}
		String pageExpectedTitle = driver.getTitle();
		String pageActualTitle = "APPLE iPhone 14 ( 128 GB Storage ) Online at Best Price On Flipkart.com";
		// Comparing selected and opened mobile page are same
		if(pageExpectedTitle.equals(pageActualTitle))
		{
			System.out.println("Verifying page Title after click on specified mobile link Title Matched");
		}else
		{
			System.out.println("Title didn't Matched");
		}

	}

}
