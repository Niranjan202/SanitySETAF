package com.tptrac.testscript;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.QuestionaryBasedAssessmentPage;
import com.tptrac.pom.FrameworkBasedAssessmentPage;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.LoginPage;
import com.tptrac.pom.UpdateUser;
import com.tptrac.pom.UsersListPage;


@Listeners(com.tptrac.generic.ExtentListener.class)
public class FrameBasedAssessmentModule extends BaseClass1{
	
	public static FluentWait<WebDriver> fWait;
	
	FrameworkBasedAssessmentPage Fb;
	
	@Test(priority= 1,testName="J", enabled = true)
	
	public void AssessmentFrameworkLibrary() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("AssessmentQuestionnairLibrarby",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		logger.info("Add Framework based Assessment Calender");
		Fb=new FrameworkBasedAssessmentPage(driver);
		HomePage h = new HomePage(driver);
		//Thread.sleep(2000);
		
		FileLib f=new FileLib();
		String vendorCategory = f.getExcelData("AssessmentCalender",1,16);
		String vendorName = f.getExcelData("AssessmentCalender",1,17);
		String type = f.getExcelData("AssessmentCalender",2,19);
		String frameworkName = f.getExcelData("AssessmentCalender",1,20);
		String astatus = f.getExcelData("AssessmentCalender",1,21);
		
		// Click on Assessment
		Fb.ClickAssessment().click();
		Thread.sleep(2000);
		Fb.ClickAssessmentCal().click();
		Thread.sleep(2000);
		Fb.Createnewassessment().click();
		Thread.sleep(2000);
		Fb.clickFrameworkLib().click();
		Thread.sleep(2000);

	    // Framework selection
		Fb.clickFramework().click();
		Thread.sleep(2000);
		Fb.selectFramework(frameworkName).click();
		Thread.sleep(2000);
		Fb.clickFramework().click();
		Thread.sleep(2000);
	   
		Fb.SelectAssessmentType().click();
		Thread.sleep(2000);
		Fb.AssessmentTypedropdown(type).click();
		Thread.sleep(2000);
		Fb.SelectAssessmentType().click();
		Thread.sleep(2000);
		Fb.Clickonvendorcategory().click();
		Thread.sleep(2000);
		Fb.selectvendorcategorydropdown(vendorCategory).click();
		Thread.sleep(2000);
		Fb.Clickonvendorcategory().click(); 
		Thread.sleep(2000);
		Fb.verifyVendor(vendorName);
		Thread.sleep(2000);
		Fb.clickonvendor().click();
		Thread.sleep(2000);
		Fb.selectonetime().click();
		Thread.sleep(2000);
		//Fb.selectAssessmentStartDate();
		
		
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         // Click on the input field to open the date picker
         WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='startDate']")));
         dateInput.click();

         // Wait for the calendar to be visible
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

         // Get today's date dynamically
         LocalDate today = LocalDate.now();
         String day = String.valueOf(today.getDayOfMonth());

         // Attempt to find today's date element
         // Construct XPath for today's date
         String xpathForToday = "//span[normalize-space(text())='" + day + "' and not(contains(@class, 'disabled'))]";

         // Attempt to find today's date element and click
         try {
             WebElement todaysDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForToday)));
             todaysDate.click();
         } catch (TimeoutException e) {
             System.out.println("Today's date element not clickable: " + e.getMessage());
         }
         
		Thread.sleep(2000);
		
         // Click on the input field to open the date picker
         WebElement dateInput1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='endDate']")));
         dateInput1.click();

         // Wait for the calendar to be visible
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

      // Get today's date and calculate the future date
         LocalDate futureDate = LocalDate.now().plusDays(3); // Get the date 5 days from today
         String day1 = String.valueOf(futureDate.getDayOfMonth());

         // Move to the next month if necessary
         LocalDate nextMonth = LocalDate.now().plusMonths(1);
         String monthName = nextMonth.getMonth().toString().toUpperCase();

         // Navigate to the correct month
         WebElement monthSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
         while (!monthSelector.getText().equalsIgnoreCase(monthName)) {
             WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'next')]")));
             nextButton.click();
             monthSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
         }

         // Construct XPath for the future date
         String xpathForFutureDate = "//span[normalize-space(text())='" + day1 + "' and not(contains(@class, 'disabled'))]";

         // Attempt to find the future date element and click
         try {
             WebElement futureDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForFutureDate)));
             Thread.sleep(2000);
             futureDateElement.click();
         } catch (TimeoutException e) {
             System.out.println("Future date element not clickable: " + e.getMessage());
         }
		
         
		
		//Fb.selectAssessmentEndDate();
		Thread.sleep(3000);
		Fb.GeneratecalenderSchedule().click();
		Thread.sleep(2000);
		Fb.planAssessment().click();
		Thread.sleep(2000);

		String status = f.getExcelData("AssessmentCalender",1,3);
		String comments = f.getExcelData("AssessmentCalender",1,4);
		
		Fb.FrameworkSearch().sendKeys(frameworkName);
		
		Thread.sleep(2000);
		Fb.clickAction(type).click();
		Thread.sleep(2000);
		Fb.Actionstatus(status);	
		Thread.sleep(2000);
		Fb.actioncomment().sendKeys(comments);
		Thread.sleep(2000);
		Fb.Actionok().click();
		
		//assert
		Thread.sleep(4000);
		String Assertforschedule = Fb.Assertforschedule(frameworkName,type).getText();
		String scheduled = f.getExcelData("AssertMessage",20,3);
		Assert.assertEquals(Assertforschedule,scheduled);
		Reporter.log("Asserttrue",true);
	    logger.info("Assessment got successfully scheduled");
	    Thread.sleep(2000);
	    Fb.ClickAssessment().click();
		Thread.sleep(2000);
		Fb.ClickAssessmentRev().click();
		Thread.sleep(2000);
		Assert.assertTrue(Fb.vAssessmentStatus(frameworkName,astatus).isDisplayed());
		Thread.sleep(2000);	
		h.setLogout();
		Thread.sleep(4000);
	}
	

	@Test(priority=2,testName="J", enabled = true)
	public void Vendorquestionsubmit() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Vendorquestionsubmit",true);
		logger.info("Add vendor question");
		Fb=new FrameworkBasedAssessmentPage(driver);
    
		//vendor Login
		FileLib f=new FileLib();
		String vendorurl = f.getPropertyData("urlvendor");
		String Vusername = f.getPropertyData("vendorusername");
		String Vpw = f.getPropertyData("vendorpassword");
		
		String frameworkName = f.getExcelData("AssessmentCalender",1,20);
		String astatusforVendor = f.getExcelData("AssessmentCalender",2,22);
		String obsStatus = f.getExcelData("AssessmentCalender",3,23);
		Thread.sleep(2000);
	    driver.get(vendorurl);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
		Thread.sleep(2000);
		Fb.vendorusername().sendKeys(Vusername);
	    Fb.vendorpassword().sendKeys(Vpw);
		Fb.VLogin().click();
	    Thread.sleep(3000);
	    Fb.VClickAssessment().click();
	    Thread.sleep(3000);
	    Fb.Vclickviewicon(frameworkName).click();
	    
	    //question1
	   
	    String Vmaturity = f.getExcelData("AssessmentCalender",3,26);
	    String Vcomment1 = f.getExcelData("AssessmentCalender",1,6);
	    Thread.sleep(3000);
	    Fb.selectVendorMaturity(Vmaturity);
	    Thread.sleep(2000);
	    Fb.enterDescription().sendKeys(Vcomment1);
	    Thread.sleep(2000);
	   
	    //Fb.uploaddocument().click();
		//String path = f.getPropertyData("path7");
		//StringSelection ss = new StringSelection(path);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//Fb.document();
	    Fb.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);
		String fileupload1 = f.getExcelData("AssessmentCalender",1,7);
		Fb.Vdescription().sendKeys(fileupload1);
		Thread.sleep(2000);
		Fb.save_next().click();
		
	//question2
	
	    String Vcomment2 = f.getExcelData("AssessmentCalender",2,6);
	    Thread.sleep(3000);
	    Fb.selectVendorMaturity(Vmaturity);
	    Thread.sleep(2000);
	    Fb.enterDescription().sendKeys(Vcomment2);
	    Thread.sleep(2000);
	   
	    //Fb.uploaddocument().click();
		//String path1 = f.getPropertyData("path7");
		//StringSelection ss1 = new StringSelection(path1);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
		//Fb.document();
	    Fb.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);
		
		String fileupload2 = f.getExcelData("AssessmentCalender",2,7);
		Fb.Vdescription().sendKeys(fileupload2);
		Thread.sleep(2000);
		Fb.save_next().click();
		
	//question3
	
	
		String Vmaturity1 = f.getExcelData("AssessmentCalender",4,26);
		String Vcomment3 = f.getExcelData("AssessmentCalender",3,6);
		Thread.sleep(3000);
		Fb.selectVendorMaturity(Vmaturity1);
		Thread.sleep(2000);
		Fb.enterDescription().sendKeys(Vcomment3);
		Thread.sleep(2000);

		//Fb.uploaddocument().click();
		//String path2 = f.getPropertyData("path7");
		//StringSelection ss2 = new StringSelection(path1);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);
		//Fb.document();
		Fb.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);

		String fileupload3 = f.getExcelData("AssessmentCalender",3,7);
		Fb.Vdescription().sendKeys(fileupload3);
		Thread.sleep(2000);
		Fb.save_next().click();

		//question4

		String Vcomment4 = f.getExcelData("AssessmentCalender",4,6);
		Thread.sleep(3000);
		Fb.selectVendorMaturity(Vmaturity1);
		Thread.sleep(2000);
		Fb.enterDescription().sendKeys(Vcomment4);
		Thread.sleep(2000);

		//Fb.uploaddocument().click();
		//String path3 = f.getPropertyData("path7");
		//StringSelection ss3 = new StringSelection(path1);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss3, null);
		//Fb.document();
		
		Fb.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);

		String fileupload4 = f.getExcelData("AssessmentCalender",4,7);
		Fb.Vdescription().sendKeys(fileupload4);
		Thread.sleep(2000);
		Fb.save_next().click();

		//question5

		String Vcomment5 = f.getExcelData("AssessmentCalender",5,6);
		Thread.sleep(3000);
		Fb.selectVendorMaturity(Vmaturity1);
		Thread.sleep(2000);
		Fb.enterDescription().sendKeys(Vcomment5);
		Thread.sleep(2000);

		//Fb.uploaddocument().click();
		//String path4 = f.getPropertyData("path7");
		//StringSelection ss4 = new StringSelection(path4);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss4, null);
		//Fb.document();
		Fb.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);

		String fileupload5 = f.getExcelData("AssessmentCalender",5,7);
		Fb.Vdescription().sendKeys(fileupload5);
		Thread.sleep(2000);
		Fb.Vsave().click();
		
		//submit
		Thread.sleep(4000);
		if(Fb.vDisableSubmit().size() >=1) {
			Fb.clickNotStartedBtn().click();
			if(Fb.verifyQuestions().size()>=1) {
				for(int i=0;i<=Fb.verifyQuestions().size();i++) {
					String Vcomment = f.getExcelData("AssessmentCalender",6,6);
					
					Fb.verifyQuestions().get(i).click();
					Thread.sleep(3000);
					Fb.selectVendorMaturity(Vmaturity1);
					Thread.sleep(2000);
					Fb.enterDescription().sendKeys(Vcomment);
					Thread.sleep(2000);
					//Fb.uploaddocument().click();
					//String path5 = f.getPropertyData("path7");
					//StringSelection ss5 = new StringSelection(path4);
					//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss5, null);
					//Fb.document();
					Fb.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
				    Thread.sleep(2000);

					String fileupload6 = f.getExcelData("AssessmentCalender",5,7);
					Fb.Vdescription().sendKeys(fileupload6);
					if(Fb.Verifysave().size()>=1) {
					    Fb.Vsave().click();
					    Thread.sleep(4000);
					    Thread.sleep(2000);
					    }else {
					    	Fb.save_next().click();
					    	Thread.sleep(4000);
					    }
				}
				Fb.submit().click();
				Thread.sleep(2000);
				Fb.submityes().click();
			}else {
				Assert.fail("No question exists but submit button is disabled");
			}
		}else {
	    Thread.sleep(2000);
		Fb.submit().click();
		Thread.sleep(2000);
		Fb.submityes().click();
		Thread.sleep(4000);
		}
		//assert
		Fb.Aclickback().click();
		Thread.sleep(4000);
		String vendorsubmit = Fb.verifyObsStatusVendor(frameworkName,astatusforVendor,obsStatus).getText();
		System.out.println(vendorsubmit);
		String noObs = f.getExcelData("AssertMessage",25,3);
		Assert.assertEquals(vendorsubmit,noObs);
		Reporter.log("Asserttrue",true);
	    logger.info("Vendor submitted ssuccessfully");

		HomePage h=new HomePage(driver);
		h.VClicklogout().click();
		Thread.sleep(2000);
		h.VClicklogoutbtn().click();
		Thread.sleep(2000);
		h.VClicklogoutok().click();
		Thread.sleep(4000);
		
		 // Clean session cookies and navigate to login page
	    String url = f.getPropertyData("url");
	    driver.manage().deleteAllCookies();
	    driver.get(url);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Check if login page is present (CRN Code field)
	    List<Object> crnFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	            By.xpath("//body"))) // wait for page body first
	            .stream()
	            .flatMap(body -> driver.findElements(By.xpath("//input[@placeholder='CRN Code']")).stream())
	            .collect(Collectors.toList());

	    if (!crnFields.isEmpty()) {
	        Object crnInput = crnFields.get(0);
	        ((WebElement) crnInput).sendKeys("CAB03");

	        String un = f.getPropertyData("username");
	        String pw = f.getPropertyData("password");
	        LoginPage l = new LoginPage(driver);
	        l.setLogin(un, pw);
	    } else {
	        System.out.println("CRN Code input field not found — user might already be logged in.");
	    }

	    Thread.sleep(3000); // Proceed with rest of the test
		/*String url = f.getPropertyData("url");
	    driver.get(url);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
	    String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);*/
	   
	}
	
	@Test(priority= 3,testName="J",enabled= true)
	public void auditorAssessmentReview() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("auditorAssessmentReview",true);
		logger.info("Add Assessment review");
		Fb=new FrameworkBasedAssessmentPage(driver);
		Thread.sleep(2000);
		HomePage h = new HomePage(driver);
		FileLib f=new FileLib();
		String frameworkName = f.getExcelData("AssessmentCalender",1,20);
		String astatusforAuditor = f.getExcelData("AssessmentCalender",2,21);
		String obsStatus = f.getExcelData("AssessmentCalender",3,23);
		Fb.ClickAssessment().click();
		Thread.sleep(2000);
		Fb.Assessmentreview().click();
		Thread.sleep(4000);
		Fb.clickEyeIcon(frameworkName,astatusforAuditor,obsStatus).click();
		Thread.sleep(2000);
		String auditorcomment = f.getExcelData("AssessmentCalender",1,13);	
		String observationtitle = f.getExcelData("FrameworkQuestionnaire",1,0);
		String obsdescription = f.getExcelData("FrameworkQuestionnaire",1,1);
		String impact = f.getExcelData("FrameworkQuestionnaire",1,2);
		String recommendation = f.getExcelData("FrameworkQuestionnaire",1,3);
		String comments = f.getExcelData("FrameworkQuestionnaire",1,4);
		Thread.sleep(3000);
		Fb.auditorcomment().sendKeys(auditorcomment);
		Thread.sleep(2000);
		Fb.addobservation().click();
		Thread.sleep(2000);
		Fb.obstitle().sendKeys(observationtitle);
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the input field to open the date picker
        WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='obsDate']")));
        dateInput.click();

        // Wait for the calendar to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

        // Get today's date dynamically
        LocalDate today = LocalDate.now();
        String day = String.valueOf(today.getDayOfMonth());

        // Attempt to find today's date element
        // Construct XPath for today's date
        String xpathForToday = "//span[normalize-space(text())='" + day + "' and not(contains(@class, 'disabled'))]";

        // Attempt to find today's date element and click
        try 
        {
            WebElement todaysDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForToday)));
            todaysDate.click();
        } catch (TimeoutException e) {
            System.out.println("Today's date element not clickable: " + e.getMessage());
        }

		
		//Fb.clickObsDate();
		//Fb.selectCurrentDate();
		Thread.sleep(2000);
		Fb.observationtype().click();
		Thread.sleep(2000);
		Fb.observationtypedropdown().click();
		Thread.sleep(2000);
		//Fb.observationtype().click();
		//Thread.sleep(2000);
		Fb.Vulnerabilitycategory().click();
		Thread.sleep(2000);
		Fb.Vulnerabilitycategorydropdown().click();
		Thread.sleep(2000);
		//Fb.Vulnerabilitycategory().click();
		//Thread.sleep(2000);
		Fb.RiskprobabilityCritical().click();
		Thread.sleep(2000);
		Fb.Riskimpactcritical().click();
		Thread.sleep(2000);
		
		Fb.obsdescription().sendKeys(obsdescription);
		Thread.sleep(2000);
		
		Fb.impact().sendKeys(impact);
		Thread.sleep(2000);
		
		Fb.recommendation().sendKeys(recommendation);
		Thread.sleep(2000);
		
		 WebElement dateInput1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='closureDate']")));
         dateInput1.click();

         // Wait for the calendar to be visible
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

      // Calculate the future date (3 days from today)
         LocalDate futureDate = LocalDate.now().plusDays(3);
         String day1 = String.valueOf(futureDate.getDayOfMonth());

         // Construct XPath for the future date (ensure not disabled)
         String futureDateXPath = "//span[normalize-space(text())='" + day1 + "' and not(contains(@class, 'disabled'))]";

         // Attempt to click the future date
         try {
             WebElement futureDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(futureDateXPath)));
             futureDateElement.click();
         } catch (TimeoutException e) {
             System.out.println("Future date element not clickable: " + e.getMessage());
         }
         
		//Fb.clickClosureDate();
		//Fb.selectFutureDate(5);
		Thread.sleep(2000);
		
		WebElement dateInput2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='followUpDate']")));
        dateInput2.click();

        // Wait for the calendar to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));
        // Get today's date and calculate the future date
        LocalDate futureDate1 = LocalDate.now().plusDays(4); // Get the date 5 days from today
        String day2 = String.valueOf(futureDate1.getDayOfMonth());
        // Construct XPath for the future date
        String xpathForFutureDate2 = "//span[normalize-space(text())='" + day2 + "' and not(contains(@class, 'disabled'))]";

        // Attempt to find the future date element and click
        try {
            WebElement futureDateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForFutureDate2)));
            Thread.sleep(2000);
            futureDateElement.click();
        } catch (TimeoutException e) {
            System.out.println("Future date element not clickable: " + e.getMessage());
        }
		//Fb.clickFollowDate();
		//Fb.selectFutureDate(5);
		Thread.sleep(2000);
		
		Fb.comments().sendKeys(comments);
		Thread.sleep(2000);
		
		Fb.assessmentreviewsave().click();
		Thread.sleep(2000);
		Fb.assessmentreview().click();	
		Fb.save_next().click();
		Thread.sleep(2000);
		
		//question2
		String auditorcomment2 = f.getExcelData("AssessmentCalender",2,13);	
		String observationtitle2 = f.getExcelData("FrameworkQuestionnaire",2,0);
		String obsdescription2 = f.getExcelData("FrameworkQuestionnaire",2,1);
		String impact2 = f.getExcelData("FrameworkQuestionnaire",2,2);
		String recommendation2 = f.getExcelData("FrameworkQuestionnaire",2,3);
		String comments2 = f.getExcelData("FrameworkQuestionnaire",2,4);
		
		
		Thread.sleep(2000);
		Fb.auditorcomment().sendKeys(auditorcomment2);
		Fb.addobservation().click();
		Thread.sleep(2000);
		Fb.obstitle().sendKeys(observationtitle2);
		Thread.sleep(2000);
	
		WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on the input field to open the date picker
		WebElement dateInput7 = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='obsDate']")));
		dateInput7.click();

		// Wait for the calendar to be visible
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

		// Get tomorrow's date dynamically
		LocalDate tomorrow = LocalDate.now().plusDays(1); // Calculate tomorrow
		String day7 = String.valueOf(tomorrow.getDayOfMonth()); // Get the day of the month for tomorrow

		// Construct XPath for tomorrow's date
		String xpathForTomorrow = "//span[normalize-space(text())='" + day7 + "' and not(contains(@class, 'disabled'))]";

		// Attempt to find tomorrow's date element and click
		try {
		    WebElement tomorrowsDate = wait7.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForTomorrow)));
		    Thread.sleep(2000);
		    tomorrowsDate.click();
		} catch (TimeoutException e) {
		    System.out.println("Tomorrow's date element not clickable: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("Error clicking tomorrow's date: " + e.getMessage());
		}
		
		//Fb.clickObsDate();
		//Fb.selectCurrentDate();
		Thread.sleep(2000);
		Fb.observationtype().click();
		Thread.sleep(2000);
		Fb.observationtypedropdown().click();
		Thread.sleep(2000);
		//Fb.observationtype().click();
		//Thread.sleep(2000);
		Fb.Vulnerabilitycategory().click();
		Thread.sleep(2000);
		Fb.Vulnerabilitycategorydropdown().click();
		Thread.sleep(2000);
		//Fb.Vulnerabilitycategory().click();
		//Thread.sleep(2000);
		Fb.RiskprobabilityCritical().click();
		Thread.sleep(2000);
		Fb.Riskimpactcritical().click();
		Thread.sleep(2000);
		Fb.obsdescription().sendKeys(obsdescription2);
		Thread.sleep(2000);
		Fb.impact().sendKeys(impact2);
		Thread.sleep(2000);
		Fb.recommendation().sendKeys(recommendation2);
		Thread.sleep(2000);
		

		 WebElement dateInput5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='closureDate']")));
        dateInput5.click();

        // Wait for the calendar to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

     // Get today's date and calculate the future date
        LocalDate futureDate5 = LocalDate.now().plusDays(3); // Get the date 5 days from today
        String day5 = String.valueOf(futureDate5.getDayOfMonth()); 
        // Construct XPath for the future date
        String xpathForFutureDate5 = "//span[normalize-space(text())='" + day5 + "' and not(contains(@class, 'disabled'))]";

        // Attempt to find the future date element and click
        try {
            WebElement futureDateElement5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForFutureDate5)));
            Thread.sleep(2000);
            futureDateElement5.click();
        } catch (TimeoutException e) {
            System.out.println("Future date element not clickable: " + e.getMessage());
        }
		
		
		//Fb.clickClosureDate();
		//Fb.selectFutureDate(5);
		Thread.sleep(2000);
		
		WebElement dateInput4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='followUpDate']")));
       dateInput4.click();

       // Wait for the calendar to be visible
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

    // Get today's date and calculate the future date
       LocalDate futureDate4 = LocalDate.now().plusDays(4); // Get the date 5 days from today
       String day4 = String.valueOf(futureDate4.getDayOfMonth());
       
       // Construct XPath for the future date
       String xpathForFutureDate4 = "//span[normalize-space(text())='" + day4 + "' and not(contains(@class, 'disabled'))]";

       // Attempt to find the future date element and click
       try {
           WebElement futureDateElement4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForFutureDate4)));
           Thread.sleep(2000);
           futureDateElement4.click();
       } catch (TimeoutException e) {
           System.out.println("Future date element not clickable: " + e.getMessage());
       }
		
		/*Fb.clickClosureDate();
		Fb.selectFutureDate(5);
		Thread.sleep(2000);
		
		Fb.clickFollowDate();
		Fb.selectFutureDate(5);
		Thread.sleep(2000);*/
		
		Fb.comments().sendKeys(comments2);
		Thread.sleep(2000);
		Fb.assessmentreviewsave().click();
		Thread.sleep(2000);
		Fb.assessmentreview().click();	
		Fb.save_next().click();
		Thread.sleep(2000);
		
		//question3
		
		String auditorcomment3 = f.getExcelData("AssessmentCalender",3,13);	
		
		Thread.sleep(2000);
        Fb.auditorcomment().sendKeys(auditorcomment3);
		Thread.sleep(2000);
		Fb.assessmentreview().click();
		Thread.sleep(2000);
		Fb.save_next().click();
		Thread.sleep(2000);
		
		//question4
		
		String auditorcomment4 = f.getExcelData("AssessmentCalender",4,13);	
		
		Thread.sleep(2000);
		Fb.auditorcomment().sendKeys(auditorcomment4);
		Thread.sleep(2000);
		Fb.assessmentreview().click();	
		Fb.save_next().click();
		Thread.sleep(2000);
		
		//question5
		
		String auditorcomment5 = f.getExcelData("AssessmentCalender",5,13);		
		Thread.sleep(2000);
		Fb.auditorcomment().sendKeys(auditorcomment5);
		Thread.sleep(2000);
		Fb.assessmentreview().click();	
		Fb.save_next().click();
		
		Thread.sleep(4000);
		if(Fb.vDisableSubmit().size() >=1) {
			Fb.clickReviewPendingBtn().click();
			if(Fb.verifyQuestions().size()>=1) {
				if(Fb.addobservation().isEnabled()) {
				for(int i=0;i<=Fb.verifyQuestions().size();i++) {
					String reenterauditorcomment = f.getExcelData("AssessmentCalender",5,13);	
					String reenterobservationtitle = f.getExcelData("AssessmentCalender",5,8);
					String reenterobsdescription = f.getExcelData("AssessmentCalender",5,9);
					String reenterimpact = f.getExcelData("AssessmentCalender",5,10);
					String reenterrecommendation = f.getExcelData("AssessmentCalender",5,11);
					String reentercomments = f.getExcelData("AssessmentCalender",5,12);
					
					Fb.verifyQuestions().get(i).click();
					Thread.sleep(3000);
					
					Fb.auditorcomment().sendKeys(reenterauditorcomment);
					Fb.addobservation().click();
					Thread.sleep(2000);
					Fb.obstitle().sendKeys(reenterobservationtitle);
					Thread.sleep(2000);
					
					Fb.clickObsDate();
					Fb.selectCurrentDate();
					Thread.sleep(2000);
					
					Fb.observationtype().click();
					Fb.observationtypedropdown().click();
					Fb.observationtype().click();
					Thread.sleep(2000);
					
					Fb.Vulnerabilitycategory().click();
					Fb.Vulnerabilitycategorydropdown().click();
					Fb.Vulnerabilitycategory().click();
					
					
					Fb.RiskprobabilityCritical().click();
					Fb.Riskimpactcritical().click();
					Thread.sleep(2000);
					Fb.obsdescription().sendKeys(reenterobsdescription);
					Thread.sleep(2000);
					Fb.impact().sendKeys("impact");
					Thread.sleep(2000);
					Fb.recommendation().sendKeys(reenterrecommendation);
					Thread.sleep(2000);
					
					Fb.clickClosureDate();
					Fb.selectFutureDate(5);
					Thread.sleep(2000);
		
					Fb.clickFollowDate();
					Fb.selectFutureDate(5);
					Thread.sleep(2000);
					
					Fb.comments().sendKeys(reentercomments);
					Thread.sleep(2000);
					Fb.assessmentreviewsave().click();
					Thread.sleep(2000);
					Fb.assessmentreview().click();	
					Fb.save_next().click();
					
					Thread.sleep(4000);
				}
				Thread.sleep(4000);
				Fb.submit().click();
				Thread.sleep(2000);
				Fb.asubmityes().click();
				Thread.sleep(3000);
				}else {
					for(int i=0;i<=Fb.verifyQuestions().size();i++) {
						String reenterauditorcomment = f.getExcelData("AssessmentCalender",5,13);	
						String reenterobservationtitle = f.getExcelData("FrameworkQuestionnaire",3,0);
						String reenterobsdescription = f.getExcelData("FrameworkQuestionnaire",3,1);
						String reenterimpact = f.getExcelData("FrameworkQuestionnaire",3,2);
						String reenterrecommendation = f.getExcelData("FrameworkQuestionnaire",3,3);
						String reentercomments = f.getExcelData("FrameworkQuestionnaire",3,4);
						
						Fb.verifyQuestions().get(i).click();
						Thread.sleep(3000);
						
						Fb.auditorcomment().sendKeys(reenterauditorcomment);
						Thread.sleep(2000);
						Fb.assessmentreview().click();	
						Fb.save_next().click();
						
						//Thread.sleep(4000);
					}
					Thread.sleep(4000);
					Fb.submit().click();
					Thread.sleep(2000);
					Fb.asubmityes().click();
					Thread.sleep(3000);
				}
			}else {
				Assert.fail("No question exists but submit button is disabled");
			}
		}else {
			Thread.sleep(4000);
			Fb.submit().click();
			Thread.sleep(2000);
			Fb.asubmityes().click();
			Thread.sleep(3000);
		}
		//view icon
		Fb.Aclickback().click();
		Thread.sleep(4000);
		String reviewedStatus = f.getExcelData("AssessmentCalender",3,21);
		String obsStatus1 = f.getExcelData("AssessmentCalender",1,23);
		Fb.clickInfoIconWithObs(frameworkName,reviewedStatus,obsStatus1).click();
		Thread.sleep(4000);
		Fb.ClickonOCPercentage().click();
		Thread.sleep(2000);
		Fb.ClickoncancelAuditor().click();
		Thread.sleep(2000);
		String reviewassert = Fb.verifyStatusWithObs(frameworkName,reviewedStatus,obsStatus1).getText();
		System.out.println(reviewassert);
		String Reviewed = f.getExcelData("AssertMessage",23,3);
		Assert.assertEquals(reviewassert,Reviewed);
		Reporter.log("Asserttrue",true);
	    logger.info("Auditor Reviewed successfully");
	    h.setLogout();
		Thread.sleep(4000);
	}
	
	
	@Test(priority= 4, testName="J", enabled= true)
	public void vendorobservationplanning() throws InterruptedException, EncryptedDocumentException, IOException {
		try{
			Reporter.log("assessmentobservationplanning",true);

		logger.info("Add Assessment review");
		Fb=new FrameworkBasedAssessmentPage(driver);
		Thread.sleep(2000);
		FileLib f=new FileLib();
		String vendorurl = f.getPropertyData("urlvendor");
		String Vusername = f.getPropertyData("vendorusername");
		String Vpw = f.getPropertyData("vendorpassword");
		String frameworkName = f.getExcelData("AssessmentCalender",1,20);
		String assessmentStatus = f.getExcelData("AssessmentCalender",1,22);
		String obsStatus = f.getExcelData("AssessmentCalender",1,23);
		String submittedStatus = f.getExcelData("AssessmentCalender",2,22);
		String obsName1 = f.getExcelData("FrameworkQuestionnaire",2,0);
		Thread.sleep(2000);
	    driver.get(vendorurl);
	    driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
		Thread.sleep(2000);
		Fb.vendorusername().sendKeys(Vusername);
		Thread.sleep(2000);
	    Fb.vendorpassword().sendKeys(Vpw);
	    Fb.VLogin().click();
	    Thread.sleep(2000);
	    Fb.VClickAssessment().click();
	    Thread.sleep(4000);
	    Fb.clickviewiconVendor(frameworkName,assessmentStatus,obsStatus).click();
	    Thread.sleep(4000);
	    Fb.observationplanning().click();
	    Thread.sleep(2000);
	    Fb.clickonResponse().click();
	    
	    //question1
	    String Accepted = f.getExcelData("AssessmentCalender",1,14);	
		String remarks1 = f.getExcelData("AssessmentCalender",1,15);
	
	    Thread.sleep(2000);
	    Fb.observationacceptance(Accepted).click();
	    Thread.sleep(2000);
	    
	    WebDriverWait wait8 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on the input field to open the date picker
		WebElement dateInput8 = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='TargetDate']")));
		dateInput8.click();

		// Wait for the calendar to be visible
		wait8.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

		// Get tomorrow's date dynamically
		LocalDate tomorrow = LocalDate.now().plusDays(5); // Calculate tomorrow
		String day8 = String.valueOf(tomorrow.getDayOfMonth()); // Get the day of the month for tomorrow

		// Construct XPath for tomorrow's date
		String xpathForTomorrow = "//span[normalize-space(text())='" + day8 + "' and not(contains(@class, 'disabled'))]";

		// Attempt to find tomorrow's date element and click
		try {
		    WebElement tomorrowsDate = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForTomorrow)));
		    Thread.sleep(2000);
		    tomorrowsDate.click();
		} catch (TimeoutException e) {
		    System.out.println("Tomorrow's date element not clickable: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("Error clicking tomorrow's date: " + e.getMessage());
		}
		
	    
	    /*Fb.Vtargetdate().click();
	    Thread.sleep(2000);
	    Fb.selectFutureDate(6);*/
	    Thread.sleep(2000);
	    Fb.Vremarks().sendKeys(remarks1);
	    Fb.save_next().click();
	    Thread.sleep(4000);
	    Fb.question(obsName1).click();
	    //question2 
	    String remarks2 = f.getExcelData("AssessmentCalender",2,15);
	    
	    Thread.sleep(2000);
	    Fb.observationacceptance(Accepted).click();
	    Thread.sleep(2000);
	    
	    WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on the input field to open the date picker
		WebElement dateInput9 = wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='TargetDate']")));
		dateInput9.click();

		// Wait for the calendar to be visible
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

		// Get tomorrow's date dynamically
		LocalDate tomorrow1 = LocalDate.now().plusDays(5); // Calculate tomorrow
		String day9 = String.valueOf(tomorrow1.getDayOfMonth()); // Get the day of the month for tomorrow

		// Construct XPath for tomorrow's date
		String xpathForTomorrow1 = "//span[normalize-space(text())='" + day9 + "' and not(contains(@class, 'disabled'))]";

		// Attempt to find tomorrow's date element and click
		try {
		    WebElement tomorrowsDate1 = wait8.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForTomorrow1)));
		    Thread.sleep(2000);
		    tomorrowsDate1.click();
		} catch (TimeoutException e) {
		    System.out.println("Tomorrow's date element not clickable: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("Error clicking tomorrow's date: " + e.getMessage());
		}
		
	    
	    /*Fb.Vtargetdate().click();
	    Thread.sleep(2000);
	    Fb.selectFutureDate(6);*/
	    Thread.sleep(2000);
	    Fb.Vremarks().sendKeys(remarks2);
	    Fb.Vsave().click();
	    Thread.sleep(4000);
	    if(Fb.vDisableSubmit().size() >=1) {
			Fb.clickplanAwaitedBtn().click();
			if(Fb.verifyObservations().size()>=1) {
				for(int i=0;i<=Fb.verifyObservations().size();i++) {
					
					Fb.verifyObservations().get(i).click();
					Thread.sleep(3000);
					String remarks = f.getExcelData("AssessmentCalender",5,15);
				    
				    Fb.observationacceptance("Accepted");
				    Thread.sleep(3000);
				    Fb.Vtargetdate().click();
				    Thread.sleep(2000);
				    Fb.selectFutureDate(6);
				    Thread.sleep(2000);
				    Fb.Vremarks().sendKeys(remarks);
				    if(Fb.Verifysave().size()>=1) {
				    Fb.Vsave().click();
				    Thread.sleep(4000);
				    Thread.sleep(2000);
				    }else {
				    	Fb.save_next().click();
				    	Thread.sleep(4000);
				    }
				}
				Fb.Aclickback().click();
				Thread.sleep(4000);
				Fb.clickviewiconVendor(frameworkName,assessmentStatus,obsStatus).click();
			    Thread.sleep(5000);
			    Fb.observationplanning().click();
			    Thread.sleep(3000);
				Fb.submit().click();
				Thread.sleep(2000);
				Fb.submityes().click();
				Thread.sleep(4000);
			}else {
				Assert.fail("No Observation exists but submit button is disabled");
			}
		}else {
			Thread.sleep(2000);
			Fb.Aclickback().click();
			Thread.sleep(4000);
			Fb.clickviewiconVendor(frameworkName,assessmentStatus,obsStatus).click();
		    Thread.sleep(5000);
		    Fb.observationplanning().click();
		    Thread.sleep(3000);
			Fb.submit().click();
			Thread.sleep(2000);
			Fb.submityes().click();
			Thread.sleep(4000);
		}
	    Thread.sleep(2000);
	    Fb.Aclickback().click();
		Thread.sleep(4000);
	    String vendorsubmit = Fb.verifyObsStatusVendor(frameworkName,submittedStatus,obsStatus).getText();
		System.out.println(vendorsubmit);
		String submitted = f.getExcelData("AssertMessage",23,3);
		Assert.assertEquals(vendorsubmit,submitted);
		Reporter.log("Asserttrue",true);
	    logger.info("Vendor submitted ssuccessfully");
	    HomePage h=new HomePage(driver);
	    h.VClicklogout().click();
	    Thread.sleep(2000);
		h.VClicklogoutbtn().click();
		Thread.sleep(2000);
		h.VClicklogoutok().click();
		Thread.sleep(2000);
		String url = f.getPropertyData("url");
	    driver.get(url);
	    Thread.sleep(3000);
		
		LoginPage l=new LoginPage(driver);
		//l.setLogin(un, pw);
		driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
		 String un = f.getPropertyData("username");
		 String pw = f.getPropertyData("password");
		l.setLogin(un, pw);
		}catch(Exception e) {
			throw e;
		}  
	}
	
	@Test(priority= 5, testName="J",enabled= true)
	public void Auditorobservationplanning() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Assessmentobservationplanning",true);
		logger.info("Add observation planning");
		Fb=new FrameworkBasedAssessmentPage(driver);
		Thread.sleep(2000);
		HomePage h = new HomePage(driver);
		FileLib f=new FileLib();
		String frameworkName = f.getExcelData("AssessmentCalender",1,20);
		String astatusforAuditor = f.getExcelData("AssessmentCalender",2,21);
		String ostatusforAuditor = f.getExcelData("AssessmentCalender",1,23);
		String obsName1 = f.getExcelData("FrameworkQuestionnaire",2,0);
		String astatusforAuditor1 = f.getExcelData("AssessmentCalender",4,21);
		
		Fb.ClickAssessment().click();
		Thread.sleep(2000);
		Fb.Assessmentreview().click();
		Thread.sleep(2000);
		Fb.clickEyeIcon(frameworkName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		Fb.observationplanning().click();
		
	    //question1
		Fb.clickVendorResponse().click();
		Fb.Areviewcomm().sendKeys("Vendor Review");
		Fb.Aapprove().click();
		Thread.sleep(4000);
		System.out.println(obsName1);
		Fb.observationtitle2(obsName1).click();
	
		//question2
		Thread.sleep(2000);
		Fb.clickVendorResponse().click();
		Fb.Areviewcomm().sendKeys("Vendor Review");
		Fb.Aapprove().click();
		
		Thread.sleep(3000);
		if(Fb.vDisableSubmit().size() >=1) {
			Fb.clickReviewPendingBtn().click();
			if(Fb.verifyObservations().size()>=1) {
				for(int i=0;i<=Fb.verifyObservations().size();i++) {
					Fb.verifyObservations().get(i).click();
					
					Thread.sleep(2000);
					Fb.clickVendorResponse().click();
					Fb.Areviewcomm().sendKeys("Vendor Review");
					Fb.Aapprove().click();
				}
				Fb.submit().click();
				Thread.sleep(2000);
			    Fb.AsubmityesObsPlanning().click();
			    Thread.sleep(3000);
			}else {
				Assert.fail("No question exists but submit button is disabled");
			}
		}else {
			Fb.submit().click();
			Thread.sleep(2000);
		    Fb.AsubmityesObsPlanning().click();
		    Thread.sleep(3000);
		}
	    Fb.Aclickback().click();
		Thread.sleep(4000);
	    String vendorsubmit = Fb.verifyObsStatusVendor(frameworkName,astatusforAuditor1,ostatusforAuditor).getText();
		System.out.println(vendorsubmit);
		String inProgress = f.getExcelData("AssertMessage",23,3);
		Assert.assertEquals(vendorsubmit,inProgress);
		Reporter.log("Asserttrue",true);	
		h.setLogout();
		Thread.sleep(4000);
	}
	
	@Test(priority= 6,testName="J",enabled= true)
	public void Vendorobservation() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Vendorobservation",true);
		logger.info("click on vendor observation");
		Fb=new FrameworkBasedAssessmentPage(driver);
		Thread.sleep(2000);

		FileLib f=new FileLib();
		String vendorurl = f.getPropertyData("urlvendor");
		String Vusername = f.getPropertyData("vendorusername");
		String Vpw = f.getPropertyData("vendorpassword");
		Thread.sleep(2000);
	    driver.get(vendorurl);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
		Thread.sleep(2000);
		Fb.vendorusername().sendKeys(Vusername);
		Thread.sleep(2000);
	    Fb.vendorpassword().sendKeys(Vpw);
	    Thread.sleep(2000);
	    Fb.VLogin().click();
	    Thread.sleep(2000);
	    
//	    FileLib f=new FileLib();
	    String obsName1 = f.getExcelData("FrameworkQuestionnaire",2,0);
	    String frameworkName = f.getExcelData("AssessmentCalender",1,20);
	    String assessmentStatus = f.getExcelData("AssessmentCalender",3,22);
	    String obsStatus = f.getExcelData("AssessmentCalender",1,23);
	    String submittedStatus = f.getExcelData("AssessmentCalender",2,22);
	    String vComment = f.getExcelData("AssessmentCalender",1,24);
		
	    Fb.VClickAssessment().click();
	    Thread.sleep(5000);
	    Fb.clickviewiconVendor(frameworkName,assessmentStatus,obsStatus).click();
	    Thread.sleep(2000);
	    Fb.clickonobservation().click();
	    Fb.clickonResponse().click();
	    
	    //question1
	    Thread.sleep(2000);
        Fb.Claimclosed().click();
	    Fb.vendorcomment().sendKeys(vComment);
	    Thread.sleep(2000);
	    Fb.Vsave().click();
	    
	    //question2
	    Thread.sleep(4000);
	    Fb.observationtitle2(obsName1).click();
	    Fb.Claimclosed().click();
	    Fb.vendorcomment().sendKeys(vComment);
	    Thread.sleep(2000);
	    Fb.Vsave().click();
	    
	    Thread.sleep(4000);
	    Fb.Vclaimclosed().click();
	    Thread.sleep(4000);
	    Fb.clickonResponse().click();
	    
	    //question1
	    Fb.Vsave().click();
	    Thread.sleep(4000);
	    Fb.submitobservation().click();
	    Thread.sleep(4000);
	    Fb.submityes().click();
	    Thread.sleep(4000);
	    
	    //question2
	    Thread.sleep(4000);
	    Fb.VQUESTION2().click();
	    Thread.sleep(4000);
	    Fb.submitobservation().click();
	    Thread.sleep(2000);
	    Fb.submityes().click();
	    
	    Thread.sleep(4000);
	    
	    Fb.Aclickback().click();
		Thread.sleep(4000);
	    String vendorsubmit = Fb.verifyObsStatusVendor(frameworkName,assessmentStatus,obsStatus).getText();
		System.out.println(vendorsubmit);
		String inProgress = f.getExcelData("AssertMessage",23,3);
		Assert.assertEquals(vendorsubmit,inProgress);
		Reporter.log("Asserttrue",true);

		HomePage h=new HomePage(driver);
		h.VClicklogout().click();
		Thread.sleep(2000);
		h.VClicklogoutbtn().click();
		Thread.sleep(2000);
		h.VClicklogoutok().click();
		Thread.sleep(4000);
		 // Clean session cookies and navigate to login page
	    String url = f.getPropertyData("url");
	    driver.manage().deleteAllCookies();
	    driver.get(url);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Check if login page is present (CRN Code field)
	    List<Object> crnFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	            By.xpath("//body"))) // wait for page body first
	            .stream()
	            .flatMap(body -> driver.findElements(By.xpath("//input[@placeholder='CRN Code']")).stream())
	            .collect(Collectors.toList());

	    if (!crnFields.isEmpty()) {
	        Object crnInput = crnFields.get(0);
	        ((WebElement) crnInput).sendKeys("CAB03");

	        String un = f.getPropertyData("username");
	        String pw = f.getPropertyData("password");
	        LoginPage l = new LoginPage(driver);
	        l.setLogin(un, pw);
	    } else {
	        System.out.println("CRN Code input field not found — user might already be logged in.");
	    }

	    Thread.sleep(3000); // Proceed with rest of the test
	}
	
	@Test(priority= 7,testName="J",enabled= true)
	public void Auditorobservation() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Auditorobservation",true);
		logger.info("click on auditor observation");
		Fb=new FrameworkBasedAssessmentPage(driver);
		HomePage h = new HomePage(driver);
		Thread.sleep(2000);
		
		FileLib f=new FileLib();
		String frameworkName = f.getExcelData("AssessmentCalender",1,20);
		String astatusforAuditor = f.getExcelData("AssessmentCalender",4,21);
		String ostatusforAuditor = f.getExcelData("AssessmentCalender",1,23);
		String obsName1 = f.getExcelData("FrameworkQuestionnaire",2,0);
		String aComment1 = f.getExcelData("AssessmentCalender",1,25);
		String aComment2 = f.getExcelData("AssessmentCalender",2,25);
		String aComment3 = f.getExcelData("AssessmentCalender",3,25);
		String aComment4 = f.getExcelData("AssessmentCalender",4,25);
		String aComment5 = f.getExcelData("AssessmentCalender",5,25);
		String astatusforAuditor1 = f.getExcelData("AssessmentCalender",5,21);
		String ostatusforAuditor1 = f.getExcelData("AssessmentCalender",2,23);
		
		Fb.ClickAssessment().click();
		Thread.sleep(2000);
		Fb.Assessmentreview().click();
		Thread.sleep(2000);
		
		Fb.clickEyeIcon(frameworkName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		Fb.Aobservation().click();
		Thread.sleep(2000);
		Fb.Aclaim().click();
		Thread.sleep(2000);
		Fb.AResponse().click();
		
		//question1
		Thread.sleep(4000);
		Fb.AuditorComments().sendKeys(aComment1);
		Thread.sleep(4000);
		Fb.Aclickonapprove().click();
		Thread.sleep(4000);
		//Fb.CrossCC().click();
		
		//question2
		//Thread.sleep(4000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		Fb.Aclickback().click();
		Thread.sleep(2000);
		Fb.clickEyeIcon(frameworkName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		Fb.Aobservation().click();
		Thread.sleep(2000);*/
		Fb.Aclaim().click();
		Thread.sleep(2000);
		Fb.AResponse().click();
		Fb.Observationquestion2().click();
		Thread.sleep(4000);
		Fb.AuditorComments().sendKeys(aComment2);
		Thread.sleep(4000);
		Fb.Aclickonapprove().click();
		//Thread.sleep(2000);
		//Fb.CrossCC().click();
		Thread.sleep(4000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		Fb.Aclickback().click();
		Thread.sleep(2000);
		Fb.clickEyeIcon(frameworkName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		Fb.Aobservation().click();
		Thread.sleep(2000);*/
		
		//SUBMIT
		
		Fb.claimclosedapprove().click();
		Thread.sleep(2000);
		Fb.clickVendorResponse().click();
		Thread.sleep(2000);
		
		//question1
		Fb.submit().click();
		Thread.sleep(4000);
		Fb.submityes1().click();
		//Thread.sleep(2000);
		//Fb.CrossSubmit().click();
		Thread.sleep(4000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		Fb.Aclickback().click();
		Thread.sleep(2000);
		Fb.clickEyeIcon(frameworkName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		Fb.Aobservation().click();
		Thread.sleep(2000);*/
		
		//question2
		Fb.claimclosedapprove().click();
		Thread.sleep(2000);
		Fb.clickVendorResponse().click();
		Thread.sleep(2000);
		Fb.clickobserQ().click();
		Thread.sleep(2000);
		Fb.submit().click();
		Thread.sleep(4000);
		Fb.submityes1().click();
		//Thread.sleep(2000);
		//Fb.CrossSubmit().click();
		Thread.sleep(6000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);*/
		Fb.Aclickback().click();
		Thread.sleep(4000);
		
		
		//view
		/*Fb.clickInfoIconWithObs(frameworkName,astatusforAuditor1,ostatusforAuditor1).click();
		Thread.sleep(2000);
		Fb.ClickonOCPercentage().click();
		Thread.sleep(6000);
		Fb.ClickoncancelAuditor().click();
		Thread.sleep(2000);*/
		
		String vendorsubmit = Fb.verifyObsStatusVendor(frameworkName,astatusforAuditor1,ostatusforAuditor1).getText();
		System.out.println(vendorsubmit);
		String completed = f.getExcelData("AssertMessage",24,3);
		Assert.assertEquals(vendorsubmit,completed);
		Reporter.log("Asserttrue",true);
		h.setLogout();
		Thread.sleep(4000);
	}
	
	@Test(priority= 8,testName="J", enabled = true)
	public void Verifyvendorstatus() throws InterruptedException, EncryptedDocumentException, IOException {
		
		Reporter.log("Verifyvendorstatus",true);
	
		Fb=new FrameworkBasedAssessmentPage(driver);
    
		//vendor Login
		FileLib f=new FileLib();
		String vendorurl = f.getPropertyData("urlvendor");
		String Vusername = f.getPropertyData("vendorusername");
		String Vpw = f.getPropertyData("vendorpassword");
		String frameworkName = f.getExcelData("AssessmentCalender",1,20);
		String astatusforVendor = f.getExcelData("AssessmentCalender",3,22);
		String obsStatus = f.getExcelData("AssessmentCalender",2,23);
		Thread.sleep(2000);
	    driver.get(vendorurl);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
		Thread.sleep(2000);
		Fb.vendorusername().sendKeys(Vusername);
		Thread.sleep(2000);
	    Fb.vendorpassword().sendKeys(Vpw);
	    Fb.VLogin().click();
	    Thread.sleep(2000);
	    Fb.VClickAssessment().click();
	    Thread.sleep(3000);
	    
		String vendorsubmit = Fb.verifyObsStatusVendor(frameworkName,astatusforVendor,obsStatus).getText();
		System.out.println(vendorsubmit);
		
		Fb.clkInfoIconVendor(frameworkName,astatusforVendor,obsStatus).click();
		Thread.sleep(2000);
		Fb.ClickoncancelAuditor().click();
		Thread.sleep(2000);

		HomePage h=new HomePage(driver);
		h.VClicklogout().click();
		Thread.sleep(2000);
		h.VClicklogoutbtn().click();
		Thread.sleep(2000);
		h.VClicklogoutok().click();
		Thread.sleep(2000);
		// Clean session cookies and navigate to login page
	    String url = f.getPropertyData("url");
	    driver.manage().deleteAllCookies();
	    driver.get(url);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Check if login page is present (CRN Code field)
	    List<Object> crnFields = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	            By.xpath("//body"))) // wait for page body first
	            .stream()
	            .flatMap(body -> driver.findElements(By.xpath("//input[@placeholder='CRN Code']")).stream())
	            .collect(Collectors.toList());

	    if (!crnFields.isEmpty()) {
	        Object crnInput = crnFields.get(0);
	        ((WebElement) crnInput).sendKeys("CAB03");

	        String un = f.getPropertyData("username");
	        String pw = f.getPropertyData("password");
	        LoginPage l = new LoginPage(driver);
	        l.setLogin(un, pw);
	    } else {
	        System.out.println("CRN Code input field not found — user might already be logged in.");
	    }

	    Thread.sleep(3000); 
		
		
	}
	
	@Test(priority= 9,testName="J",enabled= true)
	public void searchUser() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Reporter.log("searchuser",true);
		logger.info("Start Search User validation");
		HomePage h=new HomePage(driver);
		UsersListPage au=new UsersListPage(driver);
		Fb=new FrameworkBasedAssessmentPage(driver);
		Thread.sleep(2000);
		
		FileLib f=new FileLib();
		String validData = f.getExcelData("AssessmentCalender",1, 20);
		logger.info("Get valid data");
		String invalidData = f.getExcelData("AssessmentCalender",1, 5);
		logger.info("Get invalid data");
		
		Fb.ClickAssessment().click();
		Thread.sleep(2000);
		Fb.ClickAssessmentCal().click();
		Thread.sleep(2000);
		Fb.FrameworkSearch().sendKeys(validData);
		
		//au.searchUser().sendKeys(validData);
		Thread.sleep(2000);
		if(Fb.verify_Data().size()>0) {
			Assert.assertTrue(Fb.verifyFramework(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		Thread.sleep(2000);
		//Fb.FrameworkSearch().clear();
		WebElement input = Fb.FrameworkSearch();
		if (input.isDisplayed() && input.isEnabled()) {
		    Actions actions = new Actions(driver);
		    actions.moveToElement(input).doubleClick().sendKeys(Keys.BACK_SPACE).perform();
		} else {
		    System.out.println("Input field is not interactable.");
		}
		Thread.sleep(2000);
		Fb.FrameworkSearch().sendKeys(invalidData);
		Thread.sleep(2000);
		if(Fb.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(Fb.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully");
		h.setLogout();
		Thread.sleep(4000);
	}
	
}	


