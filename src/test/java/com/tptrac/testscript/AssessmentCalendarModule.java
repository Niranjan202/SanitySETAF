package com.tptrac.testscript;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.tptrac.generic.BaseClass1;
import com.tptrac.pom.AssessmentCalendarPage;


@Listeners(com.tptrac.generic.ExtentListener.class)
public class AssessmentCalendarModule extends BaseClass1{
	
	public static FluentWait<WebDriver> fWait;
	
	AssessmentCalendarPage ACP;
	
	@Test(priority=1,enabled = true)
	public void AssessmentCalendarMenuVerification() throws InterruptedException {
		Reporter.log("AssessmentCalendarMenuVerfication",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		   ACP = new AssessmentCalendarPage(driver);
		  
		try {
	        // Click on Assessment
			Thread.sleep(2000);
	        ACP.ClickAssessment().click();

	        // Wait for the Assessment Calendar Menu to be visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement assessmentCalendarMenu = wait.until(ExpectedConditions.visibilityOf(ACP.AssessmentCalendarMenu()));

	        // Wait for the element to be clickable
	        wait.until(ExpectedConditions.elementToBeClickable(assessmentCalendarMenu));
	        Thread.sleep(4000); 
	        // Check if the menu is displayed and click
	        if (assessmentCalendarMenu.isDisplayed()) {
	            System.out.println("Assessment Calendar Menu is displayed.");
	            assessmentCalendarMenu.click();
	            System.out.println("Clicked on Assessment Calendar Menu.");
	        } else {
	            System.out.println("Assessment Calendar Menu is not displayed.");
	        }
	    } catch (Exception e) {
	    	  System.err.println("Error occurred during Assessment Calendar Menu verification: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	
	@Test(priority=2,enabled= true)
	public void VerifyCreateCalendarButton() throws InterruptedException 
	{
	
		Reporter.log("VerifyCreateCalendarButton",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		ACP = new AssessmentCalendarPage(driver);
		Thread.sleep(2000);
		ACP.ClickAssessment().click();
		Thread.sleep(2000);
		 ACP.AssessmentCalendarMenu().click();
		
		 try
		 {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	     WebElement CreateCalendar = wait.until(ExpectedConditions.visibilityOf(ACP.CreateNewAssessment()));
	     wait.until(ExpectedConditions.elementToBeClickable(CreateCalendar));
	     Thread.sleep(4000);
	     if(CreateCalendar.isDisplayed())
	     {
	    	 System.out.println("Create Assessment Calendar Button is displayed");
	    	 Thread.sleep(4000);
	    	 CreateCalendar.click();
	    	 System.out.println("Clicked on Create Assessment calendar button");
	     }
	     else
	     {
	    	 System.out.println("Create Assessment Calendar Button is not displayed");
	     }
		 }
		 catch(Exception e) {
	    	  System.err.println("Error occurred during Create Assessment Calendar button verification: " + e.getMessage());
		        e.printStackTrace(); 
		 }  
	   }
}

