package com.tptrac.testscript;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.QuestionaryBasedAssessmentPage;
import com.tptrac.pom.FrameworkBasedAssessmentPage;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.LoginPage;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.VendorCategoryManagementPage;
import com.tptrac.pom.VendorManagementPage;


@Listeners(com.tptrac.generic.ExtentListener.class)
public class QuestionaryBasedAssessmentModule extends BaseClass1
{
	public static FluentWait<WebDriver> fWait;
	QuestionaryBasedAssessmentPage ac;
	
	@Test(priority=1,testName="K",enabled= true)
	public void AssessmentQuestionnairLibrarby() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("AssessmentQuestionnairLibrarby",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		logger.info("Add Assessment Calender");
		ac=new QuestionaryBasedAssessmentPage(driver);
		HomePage h = new HomePage(driver);
		FileLib f=new FileLib();
		String vendorCategory = f.getExcelData("AssessmentCalender",1,16);
		String vendorName = f.getExcelData("AssessmentCalender",1,17);
		String templateName = f.getExcelData("AssessmentCalender",1,18);
		String type = f.getExcelData("AssessmentCalender",1,19);
		String astatus = f.getExcelData("AssessmentCalender",1,21);
		Thread.sleep(2000);
		ac.ClickAssessment().click();
		Thread.sleep(2000);
		ac.ClickAssessmentCal().click();
		Thread.sleep(2000);
		ac.Createnewassessment().click();
		Thread.sleep(2000);
		ac.clickQuestionnairLib().click();
		Thread.sleep(2000);
		
		ac.SelectAssessmentType().click();
		Thread.sleep(2000);
		ac.AssessmentTypedropdown(type).click();
		Thread.sleep(2000);
		ac.SelectAssessmentType().click();
		Thread.sleep(4000);
		ac.Clickonvendorcategory().click();
		Thread.sleep(2000);
		ac.selectvendorcategorydropdown(vendorCategory).click();
		Thread.sleep(2000);
		ac.Clickonvendorcategory().click();
		Thread.sleep(4000);
		
//		ac.selectonboardingstatus().click();
	
//		ac.clickonvendorstatus().click();
//		ac.selectBeingAssessed().click();
//		ac.clickonvendorstatus().click();
//		
//		ac.clickonvendor().click();
//		ac.selectVendordropdown().click();
//		ac.clickonvendor().click();
		
		ac.verifyVendor(vendorName);
		Thread.sleep(2000);
		ac.clickonvendor().click();
		Thread.sleep(2000);
		ac.clickonquestionnire().click();
		Thread.sleep(2000);
		ac.selectquestionniredropdown(templateName).click();
		Thread.sleep(2000);
		ac.clickonquestionnire().click();
		Thread.sleep(2000);
		ac.selectonetime().click();
		Thread.sleep(2000);

		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

         // Click on the input field to open the date picker
         WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='pills-profile']//input[@id='startDate']")));
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
         WebElement dateInput1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='pills-profile']//input[@id='endDate']")));
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
		
         
		/*ac.selectAssessmentStartDate();
		Thread.sleep(2000);
		ac.selectAssessmentEndDate();*/
         Thread.sleep(3000);
		ac.GeneratecalenderSchedule().click();
		Thread.sleep(4000);
		ac.planAssessment().click();
		Thread.sleep(4000);
		
		//approve
//	    FileLib f=new FileLib();
		String status = f.getExcelData("AssessmentCalender",1,3);
		String comments = f.getExcelData("AssessmentCalender",1,4);
		
		ac.FrameworkSearch().sendKeys(templateName);
		Thread.sleep(2000);
		ac.clickAction(type).click();
		Thread.sleep(2000);
		ac.Actionstatus(status);	
		Thread.sleep(2000);
		ac.actioncomment().sendKeys(comments);
		Thread.sleep(2000);
		ac.Actionok().click();
		
		//assert
		Thread.sleep(4000);
		String Assertforschedule = ac.Assertforschedule(templateName,type).getText();
		String scheduled = f.getExcelData("AssertMessage",20,3);
		Assert.assertEquals(Assertforschedule,scheduled);
		Reporter.log("Asserttrue",true);
	    logger.info("Assessment got successfully scheduled");
	    Thread.sleep(2000);
	    ac.ClickAssessment().click();
		Thread.sleep(2000);
		ac.ClickAssessmentRev().click();
		Thread.sleep(2000);
		Assert.assertTrue(ac.vAssessmentStatus(templateName,astatus).isDisplayed());
		Thread.sleep(2000);	
		h.setLogout();
		Thread.sleep(4000);
	}
	
	@Test(priority= 2,testName="K",enabled= true)
	public void Vendorquestionsubmit() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Vendorquestionsubmit",true);
		logger.info("Add vendor question");
		ac=new QuestionaryBasedAssessmentPage(driver);
    
		//vendor Login
		FileLib f=new FileLib();
		String vendorurl = f.getPropertyData("urlvendor");
		String Vusername = f.getPropertyData("vendorusername");
		String Vpw = f.getPropertyData("vendorpassword");
		String templateName = f.getExcelData("AssessmentCalender",1,18);
		String astatusforVendor = f.getExcelData("AssessmentCalender",2,22);
		Thread.sleep(2000);
	    driver.get(vendorurl);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
	    Thread.sleep(2000);
		ac.vendorusername().sendKeys(Vusername);
	    ac.vendorpassword().sendKeys(Vpw);
		 Thread.sleep(2000);
	    ac.VLogin().click();
	    Thread.sleep(3000);
	    ac.VClickAssessment().click();
	    Thread.sleep(3000);
	    ac.Vclickviewicon(templateName).click();
	    
	    //question1
	   
	    String Vresponse1 = f.getExcelData("AssessmentCalender",1,5);
	    String Vcomment1 = f.getExcelData("AssessmentCalender",1,6);
	    Thread.sleep(3000);
	    ac.vendorresponse().sendKeys(Vresponse1);
	    Thread.sleep(2000);
	    ac.vendorcomments().sendKeys(Vcomment1);
	    Thread.sleep(2000);
	   
	    //ac.uploaddocument().click();
		//String path = f.getPropertyData("path7");
		//StringSelection ss = new StringSelection(path);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		//ac.document();
	    ac.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);
		String fileupload1 = f.getExcelData("AssessmentCalender",1,7);
		ac.Vdescription().sendKeys(fileupload1);
		Thread.sleep(2000);
		ac.save_next().click();
		
	//question2
	
	    String Vresponse2 = f.getExcelData("AssessmentCalender",2,5);
	    String Vcomment2 = f.getExcelData("AssessmentCalender",2,6);
	    Thread.sleep(3000);
	    ac.vendorresponse().sendKeys(Vresponse2);
	    Thread.sleep(2000);
	    ac.vendorcomments().sendKeys(Vcomment2);
	    Thread.sleep(2000);
	   
	    //ac.uploaddocument().click();
		//String path1 = f.getPropertyData("path7");
		//StringSelection ss1 = new StringSelection(path1);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss1, null);
		//ac.document();
	    ac.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);
		
		String fileupload2 = f.getExcelData("AssessmentCalender",2,7);
		ac.Vdescription().sendKeys(fileupload2);
		Thread.sleep(2000);
		ac.save_next().click();
		
	//question3
	
	
		String Vresponse3 = f.getExcelData("AssessmentCalender",3,5);
		String Vcomment3 = f.getExcelData("AssessmentCalender",3,6);
		Thread.sleep(3000);
		ac.vendorresponse().sendKeys(Vresponse3);
		Thread.sleep(2000);
		ac.vendorcomments().sendKeys(Vcomment3);
		Thread.sleep(2000);

		//ac.uploaddocument().click();
		//String path2 = f.getPropertyData("path7");
		//StringSelection ss2 = new StringSelection(path1);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss2, null);
		//ac.document();
		
		ac.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);

		String fileupload3 = f.getExcelData("AssessmentCalender",3,7);
		ac.Vdescription().sendKeys(fileupload3);
		Thread.sleep(2000);
		ac.save_next().click();

		//question4

		String Vresponse4 = f.getExcelData("AssessmentCalender",4,5);
		String Vcomment4 = f.getExcelData("AssessmentCalender",4,6);
		Thread.sleep(3000);
		ac.vendorresponse().sendKeys(Vresponse4);
		Thread.sleep(2000);
		ac.vendorcomments().sendKeys(Vcomment4);
		Thread.sleep(2000);

		//ac.uploaddocument().click();
		//String path3 = f.getPropertyData("path7");
		//StringSelection ss3 = new StringSelection(path1);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss3, null);
		//ac.document();
		ac.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);

		String fileupload4 = f.getExcelData("AssessmentCalender",4,7);
		ac.Vdescription().sendKeys(fileupload4);
		Thread.sleep(2000);
		ac.save_next().click();

		//question5

		String Vresponse5 = f.getExcelData("AssessmentCalender",5,5);
		String Vcomment5 = f.getExcelData("AssessmentCalender",5,6);
		Thread.sleep(3000);
		ac.vendorresponse().sendKeys(Vresponse5);
		Thread.sleep(2000);
		ac.vendorcomments().sendKeys(Vcomment5);
		Thread.sleep(2000);

		//ac.uploaddocument().click();
		//String path4 = f.getPropertyData("path7");
		//StringSelection ss4 = new StringSelection(path4);
		//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss4, null);
		//ac.document();
		ac.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
	    Thread.sleep(2000);

		String fileupload5 = f.getExcelData("AssessmentCalender",5,7);
		ac.Vdescription().sendKeys(fileupload5);
		Thread.sleep(2000);
		ac.save_next().click();
		
		//submit
		Thread.sleep(4000);
		if(ac.vDisableSubmit().size() >=1) {
			ac.clickNotStartedBtn().click();
			if(ac.verifyQuestions().size()>=1) {
				for(int i=0;i<=ac.verifyQuestions().size();i++) {
					String Vresponse = f.getExcelData("AssessmentCalender",6,5);
					String Vcomment = f.getExcelData("AssessmentCalender",6,6);
					
					ac.verifyQuestions().get(i).click();
					Thread.sleep(3000);
					ac.vendorresponse().sendKeys(Vresponse);
					Thread.sleep(2000);
					ac.vendorcomments().sendKeys(Vcomment);
					Thread.sleep(2000);
					//ac.uploaddocument().click();
					//String path5 = f.getPropertyData("path7");
					//StringSelection ss5 = new StringSelection(path4);
					//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss5, null);
					//ac.document();
					ac.FileSelect().sendKeys("C:\\Users\\Niranjan Srichandan\\eclipse-workspace\\SanitySETAF\\src\\test\\resources\\data\\TestScript.xlsx");
				    Thread.sleep(2000);

					String fileupload6 = f.getExcelData("AssessmentCalender",5,7);
					ac.Vdescription().sendKeys(fileupload6);
					Thread.sleep(2000);
					ac.save_next().click();
					Thread.sleep(2000);
				}
				ac.submit().click();
				Thread.sleep(2000);
				ac.submityes().click();
			}else {
				Assert.fail("No question exists but submit button is disabled");
			}
		}else {
		Thread.sleep(2000);
		ac.submit().click();
		Thread.sleep(2000);
		ac.submityes().click();
		Thread.sleep(4000);
		}
		//assert
		ac.Aclickback().click();
		Thread.sleep(4000);
		String vendorsubmit = ac.vAssessmentStatusForVendor(templateName,astatusforVendor).getText();
		System.out.println(vendorsubmit);
		String submitted = f.getExcelData("AssertMessage",21,3);
		Assert.assertEquals(vendorsubmit,submitted);
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

	    Thread.sleep(3000); 
		}
	
	@Test(priority= 3,testName="K",enabled= true)
	public void AuditorQuestionAssessmentReview() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("auditorAssessmentReview",true);
		logger.info("Add Assessment review");
		ac=new QuestionaryBasedAssessmentPage(driver);
		HomePage h = new HomePage(driver);
		FileLib f=new FileLib();
		String templateName = f.getExcelData("AssessmentCalender",1,18);
		String astatusforAuditor = f.getExcelData("AssessmentCalender",2,21);
		Thread.sleep(2000);
		ac.ClickAssessment().click();
		Thread.sleep(2000);
		ac.Assessmentreview().click();
		Thread.sleep(4000);
		ac.clickEyeIcon(templateName,astatusforAuditor).click();
		Thread.sleep(2000);
		String auditorcomment = f.getExcelData("AssessmentCalender",1,13);	
		String observationtitle = f.getExcelData("AssessmentCalender",1,8);
		String obsdescription = f.getExcelData("AssessmentCalender",1,9);
		String impact = f.getExcelData("AssessmentCalender",1,10);
		String recommendation = f.getExcelData("AssessmentCalender",1,11);
		String comments = f.getExcelData("AssessmentCalender",1,12);
		Thread.sleep(3000);
		ac.auditorcomment().sendKeys(auditorcomment);
		Thread.sleep(2000);
		ac.addobservation().click();
		Thread.sleep(2000);
		ac.obstitle().sendKeys(observationtitle);
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
        // Construct XPath for today's date
        String xpathForToday = "//span[normalize-space(text())='" + day + "' and not(contains(@class, 'disabled'))]";

        // Attempt to find today's date element and click
        try {
            WebElement todaysDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathForToday)));
            todaysDate.click();
        } catch (TimeoutException e) {
            System.out.println("Today's date element not clickable: " + e.getMessage());
        }
        
		//ac.clickObsDate();
		//ac.selectCurrentDate();
		Thread.sleep(2000);
		ac.observationtype().click();
		Thread.sleep(2000);
		ac.observationtypedropdown().click();
		Thread.sleep(2000);
		//ac.observationtype().click();
		//Thread.sleep(2000);
		ac.Vulnerabilitycategory().click();
		Thread.sleep(2000);
		ac.Vulnerabilitycategorydropdown().click();
		Thread.sleep(2000);
		//ac.Vulnerabilitycategory().click();
		//Thread.sleep(2000);
		ac.RiskprobabilityCritical().click();
		Thread.sleep(2000);
		ac.Riskimpactcritical().click();
		Thread.sleep(2000);
		ac.obsdescription().sendKeys(obsdescription);
		Thread.sleep(2000);
		ac.impact().sendKeys(impact);
		Thread.sleep(2000);
		ac.recommendation().sendKeys(recommendation);
		Thread.sleep(2000);
		
		 WebElement dateInput1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='closureDate']")));
         dateInput1.click();

         // Wait for the calendar to be visible
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

      // Get today's date and calculate the future date
         LocalDate futureDate = LocalDate.now().plusDays(3); // Get the date 5 days from today
         String day1 = String.valueOf(futureDate.getDayOfMonth());

         // Move to the next month if necessary
        /* LocalDate nextMonth = LocalDate.now().plusMonths(1);
         String monthName = nextMonth.getMonth().toString().toUpperCase();*/

         // Navigate to the correct month
        /* WebElement monthSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
         while (!monthSelector.getText().equalsIgnoreCase(monthName)) {
             WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'next')]")));
             nextButton.click();
             monthSelector = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
         }*/

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
		

		//ac.clickClosureDate();
		//ac.selectFutureDate(5);
		Thread.sleep(2000);
		
		WebElement dateInput2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='followUpDate']")));
        dateInput2.click();

        // Wait for the calendar to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

     // Get today's date and calculate the future date
        LocalDate futureDate1 = LocalDate.now().plusDays(4); // Get the date 5 days from today
        String day2 = String.valueOf(futureDate1.getDayOfMonth());

        // Move to the next month if necessary
       /* LocalDate nextMonth1 = LocalDate.now().plusMonths(1);
        String monthName1 = nextMonth1.getMonth().toString().toUpperCase();*/

        // Navigate to the correct month
       /* WebElement monthSelector1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
        while (!monthSelector1.getText().equalsIgnoreCase(monthName1)) {
            WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'next')]")));
            nextButton.click();
            monthSelector1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
        }*/

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
		
				
		//ac.clickFollowDate();
		//ac.selectFutureDate(5);
		Thread.sleep(2000);
		ac.comments().sendKeys(comments);
		Thread.sleep(2000);
		ac.assessmentreviewsave().click();
		Thread.sleep(2000);
		ac.assessmentreview().click();	
		Thread.sleep(2000);
		ac.save_next().click();
		Thread.sleep(2000);
		
		//question2
		String auditorcomment2 = f.getExcelData("AssessmentCalender",2,13);	
		String observationtitle2 = f.getExcelData("AssessmentCalender",2,8);
		String obsdescription2 = f.getExcelData("AssessmentCalender",2,9);
		String impact2 = f.getExcelData("AssessmentCalender",2,10);
		String recommendation2 = f.getExcelData("AssessmentCalender",2,11);
		String comments2 = f.getExcelData("AssessmentCalender",2,12);
		
		
		Thread.sleep(2000);
		ac.auditorcomment().sendKeys(auditorcomment2);
		ac.addobservation().click();
		Thread.sleep(2000);
		ac.obstitle().sendKeys(observationtitle2);
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
		
		
		//ac.clickObsDate();
		//ac.selectCurrentDate();
		Thread.sleep(2000);
		ac.observationtype().click();
		Thread.sleep(2000);
		ac.observationtypedropdown().click();
		Thread.sleep(2000);
		//ac.observationtype().click();
		//Thread.sleep(2000);
		ac.Vulnerabilitycategory().click();
		Thread.sleep(2000);
		ac.Vulnerabilitycategorydropdown().click();
		Thread.sleep(2000);
		//ac.Vulnerabilitycategory().click();
		//Thread.sleep(2000);
		ac.RiskprobabilityCritical().click();
		Thread.sleep(2000);
		ac.Riskimpactcritical().click();
		Thread.sleep(2000);
		ac.obsdescription().sendKeys(obsdescription2);
		Thread.sleep(2000);
		ac.impact().sendKeys(impact2);
		Thread.sleep(2000);
		ac.recommendation().sendKeys(recommendation2);
		Thread.sleep(2000);
		
		 WebElement dateInput5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='closureDate']")));
	        dateInput5.click();

	        // Wait for the calendar to be visible
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

	     // Get today's date and calculate the future date
	        LocalDate futureDate5 = LocalDate.now().plusDays(4); // Get the date 5 days from today
	        String day5 = String.valueOf(futureDate5.getDayOfMonth());

	        // Move to the next month if necessary
	        //LocalDate nextMonth5 = LocalDate.now().plusMonths(1);
	        //String monthName5 = nextMonth5.getMonth().toString().toUpperCase();

	        // Navigate to the correct month
	       /* WebElement monthSelector5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
	        while (!monthSelector5.getText().equalsIgnoreCase(monthName5)) {
	            WebElement nextButton5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'next')]")));
	            nextButton5.click();
	            monthSelector5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
	        }*/

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
					
		//ac.clickClosureDate();
		//ac.selectFutureDate(5);
		Thread.sleep(2000);
		
		WebElement dateInput4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='followUpDate']")));
	       dateInput4.click();

	       // Wait for the calendar to be visible
	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//bs-datepicker-container")));

	    // Get today's date and calculate the future date
	       LocalDate futureDate4 = LocalDate.now().plusDays(4); // Get the date 5 days from today
	       String day4 = String.valueOf(futureDate4.getDayOfMonth());

	       // Move to the next month if necessary
	       //LocalDate nextMonth4 = LocalDate.now().plusMonths(1);
	       //String monthName4 = nextMonth4.getMonth().toString().toUpperCase();

	       // Navigate to the correct month
	       /*WebElement monthSelector4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
	       while (!monthSelector4.getText().equalsIgnoreCase(monthName4)) {
	           WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'next')]")));
	           nextButton.click();
	           monthSelector4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'current')]")));
	       }*/

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
		
		//ac.clickFollowDate();
		//ac.selectFutureDate(5);
		Thread.sleep(2000);
		ac.comments().sendKeys(comments2);
		Thread.sleep(2000);
		ac.assessmentreviewsave().click();
		Thread.sleep(2000);
		ac.assessmentreview().click();	
		Thread.sleep(2000);
		ac.save_next().click();
		Thread.sleep(2000);
		
		//question3
		
		String auditorcomment3 = f.getExcelData("AssessmentCalender",3,13);	
		String observationtitle3 = f.getExcelData("AssessmentCalender",3,8);
		String obsdescription3 = f.getExcelData("AssessmentCalender",3,9);
		String impact3 = f.getExcelData("AssessmentCalender",3,10);
		String recommendation3 = f.getExcelData("AssessmentCalender",3,11);
		String comments3 = f.getExcelData("AssessmentCalender",3,12);
		
		
		Thread.sleep(2000);
        ac.auditorcomment().sendKeys(auditorcomment3);
		Thread.sleep(2000);
		ac.assessmentreview().click();
		Thread.sleep(2000);
		ac.save_next().click();
		Thread.sleep(2000);
		
		/*ac.addobservation().click();
		Thread.sleep(2000);
		ac.obstitle().sendKeys(observationtitle3);
		Thread.sleep(2000);
		
		ac.clickObsDate();
		ac.selectCurrentDate();
		Thread.sleep(2000);
		
		ac.observationtype().click();
		ac.observationtypedropdown().click();
		ac.observationtype().click();
		Thread.sleep(2000);
		
		ac.Vulnerabilitycategory().click();
		ac.Vulnerabilitycategorydropdown().click();
		ac.Vulnerabilitycategory().click();
		
		
		ac.RiskprobabilityCritical().click();
		ac.Riskimpactcritical().click();
		Thread.sleep(2000);
		ac.obsdescription().sendKeys(obsdescription3);
		Thread.sleep(2000);
		ac.impact().sendKeys("impact");
		Thread.sleep(2000);
		ac.recommendation().sendKeys(recommendation3);
		Thread.sleep(2000);
		
		
		ac.clickClosureDate();
		ac.selectFutureDate(5);
		Thread.sleep(2000);
		
		
		ac.clickFollowDate();
		ac.selectFutureDate(5);
		Thread.sleep(2000);
		
		ac.comments().sendKeys(comments3);
		Thread.sleep(2000);
		ac.assessmentreviewsave().click();
		Thread.sleep(2000);
		ac.assessmentreview().click();	
		ac.save_next().click();
		Thread.sleep(2000);*/
		
		//question4
		
		String auditorcomment4 = f.getExcelData("AssessmentCalender",4,13);	
		String observationtitle4 = f.getExcelData("AssessmentCalender",4,8);
		String obsdescription4 = f.getExcelData("AssessmentCalender",4,9);
		String impact4 = f.getExcelData("AssessmentCalender",4,10);
		String recommendation4 = f.getExcelData("AssessmentCalender",4,11);
		String comments4 = f.getExcelData("AssessmentCalender",4,12);
		
		Thread.sleep(2000);
		ac.auditorcomment().sendKeys(auditorcomment4);
		Thread.sleep(2000);
		ac.assessmentreview().click();	
		Thread.sleep(2000);
		ac.save_next().click();
		Thread.sleep(2000);
		
		/*ac.addobservation().click();
		Thread.sleep(2000);
		ac.obstitle().sendKeys(observationtitle4);
		Thread.sleep(2000);
		
	
		ac.clickObsDate();
		ac.selectCurrentDate();
		
		ac.observationtype().click();
		ac.observationtypedropdown().click();
		ac.observationtype().click();
		Thread.sleep(2000);
		Thread.sleep(2000);
		
		ac.Vulnerabilitycategory().click();
		ac.Vulnerabilitycategorydropdown().click();
		ac.Vulnerabilitycategory().click();
		
		
		ac.RiskprobabilityCritical().click();
		ac.Riskimpactcritical().click();
		Thread.sleep(2000);
		ac.obsdescription().sendKeys(obsdescription4);
		Thread.sleep(2000);
		ac.impact().sendKeys(impact4);
		Thread.sleep(2000);
		ac.recommendation().sendKeys(recommendation4);
		Thread.sleep(2000);
		
		
		ac.clickClosureDate();
		ac.selectFutureDate(5);
		Thread.sleep(2000);
		

		ac.clickFollowDate();
		ac.selectFutureDate(5);
		Thread.sleep(2000);
		
		ac.comments().sendKeys(comments4);
		Thread.sleep(2000);
		ac.assessmentreviewsave().click();
		Thread.sleep(2000);
		ac.assessmentreview().click();	
		ac.save_next().click();
		Thread.sleep(2000);*/
		
		//question5
		
		
		String auditorcomment5 = f.getExcelData("AssessmentCalender",5,13);	
		String observationtitle5 = f.getExcelData("AssessmentCalender",5,8);
		String obsdescription5 = f.getExcelData("AssessmentCalender",5,9);
		String impact5 = f.getExcelData("AssessmentCalender",5,10);
		String recommendation5 = f.getExcelData("AssessmentCalender",5,11);
		String comments5 = f.getExcelData("AssessmentCalender",5,12);
		
		
		Thread.sleep(2000);
		ac.auditorcomment().sendKeys(auditorcomment5);
		Thread.sleep(2000);
		ac.assessmentreview().click();	
		Thread.sleep(2000);
		ac.save_next().click();
		Thread.sleep(4000);
		
		/*ac.addobservation().click();
		Thread.sleep(2000);
		ac.obstitle().sendKeys(observationtitle5);
		Thread.sleep(2000);
		

		ac.clickObsDate();
		ac.selectCurrentDate();
		Thread.sleep(2000);
		
		ac.observationtype().click();
		ac.observationtypedropdown().click();
		ac.observationtype().click();
		Thread.sleep(2000);
		
		ac.Vulnerabilitycategory().click();
		ac.Vulnerabilitycategorydropdown().click();
		ac.Vulnerabilitycategory().click();
		
		
		ac.RiskprobabilityCritical().click();
		ac.Riskimpactcritical().click();
		Thread.sleep(2000);
		ac.obsdescription().sendKeys(obsdescription5);
		Thread.sleep(2000);
		ac.impact().sendKeys("impact");
		Thread.sleep(2000);
		ac.recommendation().sendKeys(recommendation5);
		Thread.sleep(2000);
		
		
		ac.clickClosureDate();
		ac.selectFutureDate(5);
		Thread.sleep(2000);
		
		
		ac.clickFollowDate();
		ac.selectFutureDate(5);
		Thread.sleep(2000);
		
		ac.comments().sendKeys(comments5);
		Thread.sleep(2000);
		ac.assessmentreviewsave().click();
		Thread.sleep(2000);
		ac.assessmentreview().click();	
		ac.save_next().click();
		
		Thread.sleep(4000);*/
		if(ac.vDisableSubmit().size() >=1) {
			ac.clickReviewPendingBtn().click();
			if(ac.verifyQuestions().size()>=1) {
				for(int i=0;i<=ac.verifyQuestions().size();i++) {
					String reenterauditorcomment = f.getExcelData("AssessmentCalender",5,13);	
					String reenterobservationtitle = f.getExcelData("AssessmentCalender",5,8);
					String reenterobsdescription = f.getExcelData("AssessmentCalender",5,9);
					String reenterimpact = f.getExcelData("AssessmentCalender",5,10);
					String reenterrecommendation = f.getExcelData("AssessmentCalender",5,11);
					String reentercomments = f.getExcelData("AssessmentCalender",5,12);
					ac.verifyQuestions().get(i).click();
					Thread.sleep(3000);
					ac.auditorcomment().sendKeys(reenterauditorcomment);
					ac.addobservation().click();
					Thread.sleep(2000);
					ac.obstitle().sendKeys(reenterobservationtitle);
					Thread.sleep(2000);
					ac.clickObsDate();
					ac.selectCurrentDate();
					Thread.sleep(2000);
					ac.observationtype().click();
					ac.observationtypedropdown().click();
					ac.observationtype().click();
					Thread.sleep(2000);
					ac.Vulnerabilitycategory().click();
					ac.Vulnerabilitycategorydropdown().click();
					ac.Vulnerabilitycategory().click();
					ac.RiskprobabilityCritical().click();
					ac.Riskimpactcritical().click();
					Thread.sleep(2000);
					ac.obsdescription().sendKeys(reenterobsdescription);
					Thread.sleep(2000);
					ac.impact().sendKeys("impact");
					Thread.sleep(2000);
					ac.recommendation().sendKeys(reenterrecommendation);
					Thread.sleep(2000);
					
					ac.clickClosureDate();
					ac.selectFutureDate(5);
					Thread.sleep(2000);
		
					ac.clickFollowDate();
					ac.selectFutureDate(5);
					Thread.sleep(2000);
					
					ac.comments().sendKeys(reentercomments);
					Thread.sleep(2000);
					ac.assessmentreviewsave().click();
					Thread.sleep(2000);
					ac.assessmentreview().click();	
					ac.save_next().click();
					
					Thread.sleep(4000);
				}
				Thread.sleep(4000);
				ac.submit().click();
				Thread.sleep(2000);
				ac.asubmityes().click();
				Thread.sleep(3000);
			}else {
				Assert.fail("No question exists but submit button is disabled");
			}
		}else {
			Thread.sleep(4000);
			ac.submit().click();
			Thread.sleep(2000);
			ac.asubmityes().click();
			Thread.sleep(3000);
		}
		//view icon
		ac.Aclickback().click();
		Thread.sleep(4000);
		String reviewedStatus = f.getExcelData("AssessmentCalender",3,21);
		ac.clickInfoIcon(templateName,reviewedStatus).click();
		Thread.sleep(4000);
		ac.ClickonOCPercentage().click();
		Thread.sleep(2000);
		ac.ClickoncancelAuditor().click();
		Thread.sleep(2000);
		String reviewassert = ac.vAssessmentStatus(templateName,reviewedStatus).getText();
		System.out.println(reviewassert);
		String Reviewed = f.getExcelData("AssertMessage",22,3);
		Assert.assertEquals(reviewassert,Reviewed);
		Reporter.log("Asserttrue",true);
	    logger.info("Auditor Reviewed ssuccessfully");
	    h.setLogout();
		Thread.sleep(4000);
		
	}
	
	@Test(priority= 4,testName="K",enabled= true)
	public void vendorobservationplanning() throws InterruptedException, EncryptedDocumentException, IOException {
		try{
			Reporter.log("assessmentobservationplanning",true);

		logger.info("Add Assessment review");
		ac=new QuestionaryBasedAssessmentPage(driver);
		Thread.sleep(2000);
		FrameworkBasedAssessmentPage Fb = new FrameworkBasedAssessmentPage(driver);

		FileLib f=new FileLib();
		String vendorurl = f.getPropertyData("urlvendor");
		String Vusername = f.getPropertyData("vendorusername");
		String Vpw = f.getPropertyData("vendorpassword");
		String templateName = f.getExcelData("AssessmentCalender",1,18);
		String assessmentStatus = f.getExcelData("AssessmentCalender",1,22);
		String obsStatus = f.getExcelData("AssessmentCalender",1,23);
		String submittedStatus = f.getExcelData("AssessmentCalender",2,22);
		String obsName1 = f.getExcelData("AssessmentCalender",2,8);
		String obsName2 = f.getExcelData("AssessmentCalender",3,8);
		String obsName3 = f.getExcelData("AssessmentCalender",4,8);
		String obsName4 = f.getExcelData("AssessmentCalender",5,8);
		
		Thread.sleep(2000);
	    driver.get(vendorurl);
	    driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
		ac.vendorusername().sendKeys(Vusername);
		Thread.sleep(2000);
	    ac.vendorpassword().sendKeys(Vpw);
	    Thread.sleep(2000);
	    ac.VLogin().click();
	    Thread.sleep(2000);
	    ac.VClickAssessment().click();
	    Thread.sleep(4000);
	    ac.clickviewiconVendor(templateName,assessmentStatus,obsStatus).click();
	    Thread.sleep(4000);
	    ac.observationplanning().click();
	    Thread.sleep(2000);
	    ac.clickonResponse().click();
	    
	    //question1
	    String Accepted = f.getExcelData("AssessmentCalender",1,14);	
		String remarks1 = f.getExcelData("AssessmentCalender",1,15);
	
	    Thread.sleep(2000);
	    ac.observationacceptance(Accepted).click();
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
	    
//	    ac.Vtargetdate().sendKeys("08-07-2023");
	    /*ac.Vtargetdate().click();
	    Thread.sleep(2000);
	    //ac.selectFutureDate(6);
	    Fb.selectFutureDate(5);*/
	    Thread.sleep(4000);
	    ac.Vremarks().sendKeys(remarks1);
	    Thread.sleep(2000);
	    ac.save_next().click();
	    Thread.sleep(4000);
	    ac.question2(obsName1).click();
	    
	    //question2 
	    String remarks2 = f.getExcelData("AssessmentCalender",2,15);
	    Thread.sleep(2000);
	    ac.observationacceptance(Accepted).click();
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

	    /*ac.Vtargetdate().click();
	    Fb.selectFutureDate(5);*/
	    Thread.sleep(4000);
	    ac.Vremarks().sendKeys(remarks2);
	    //ac.save_next().click();
	    ac.Vsave().click();
	    Thread.sleep(4000);
	 
	   /* ac.question3(obsName2).click();
	  //question3
	    
	    String remarks3 = f.getExcelData("AssessmentCalender",3,15);
	    
	    Thread.sleep(2000);
	    ac.observationacceptance("Accepted").click();
	    Thread.sleep(2000);
//	    ac.Vtargetdate().sendKeys("10-30-2023");
	    ac.Vtargetdate().click();
	    //ac.selectFutureDate(6);
	    Fb.selectFutureDate(5);
	    Thread.sleep(4000);
	    ac.Vremarks().sendKeys(remarks3);
	    ac.save_next().click();
	    Thread.sleep(4000);
	    
	    ac.question4(obsName3).click();
	  //question4 
	    
	    String remarks4 = f.getExcelData("AssessmentCalender",4,15);
	    
	    Thread.sleep(2000);
	    ac.observationacceptance("Accepted").click();
	    Thread.sleep(2000);
//	    ac.Vtargetdate().sendKeys("10-30-2023");
	    ac.Vtargetdate().click();
	    //ac.selectFutureDate(6);
	    Fb.selectFutureDate(5);
	    Thread.sleep(4000);
	    ac.Vremarks().sendKeys(remarks4);
	    ac.save_next().click();
	    Thread.sleep(4000);
	    
	  //question5
	    ac.question5(obsName4).click();
	    Thread.sleep(2000);
	    
	    String remarks5 = f.getExcelData("AssessmentCalender",5,15);
	    
	    ac.observationacceptance("Accepted").click();
	    Thread.sleep(2000);
//	    ac.Vtargetdate().sendKeys("10-30-2023");
	    ac.Vtargetdate().click();
	    //ac.selectFutureDate(6);
	    Fb.selectFutureDate(5);
	    Thread.sleep(4000);
	    ac.Vremarks().sendKeys(remarks5);
	    ac.Vsave().click();
	    Thread.sleep(4000);*/
	    if(ac.vDisableSubmit().size() >=1) {
			ac.clickplanAwaitedBtn().click();
			if(ac.verifyObservations().size()>=1) {
				for(int i=0;i<=ac.verifyObservations().size();i++) {
					
					ac.verifyObservations().get(i).click();
					Thread.sleep(3000);
					String remarks = f.getExcelData("AssessmentCalender",5,15);
				    
				    ac.observationacceptance("Accepted");
				    Thread.sleep(2000);
				    ac.Vtargetdate().click();
				    Thread.sleep(4000);
				    ac.selectFutureDate(6);
				    Thread.sleep(4000);
				    ac.Vremarks().sendKeys(remarks);
				    if(ac.Verifysave().size()>=1) {
				    ac.Vsave().click();
				    Thread.sleep(4000);
				    Thread.sleep(2000);
				    }else {
				    	ac.save_next().click();
				    	Thread.sleep(4000);
				    }
				}
				ac.Aclickback().click();
				Thread.sleep(4000);
				ac.clickviewiconVendor(templateName,assessmentStatus,obsStatus).click();
			    Thread.sleep(5000);
			    ac.observationplanning().click();
			    Thread.sleep(3000);
				ac.submit().click();
				Thread.sleep(2000);
				ac.submityes().click();
				Thread.sleep(4000);
			}else {
				Assert.fail("No Observation exists but submit button is disabled");
			}
		}else {
			ac.Aclickback().click();
			Thread.sleep(4000);
			ac.clickviewiconVendor(templateName,assessmentStatus,obsStatus).click();
		    Thread.sleep(5000);
		    ac.observationplanning().click();
		    Thread.sleep(3000);
			ac.submit().click();
			Thread.sleep(2000);
			ac.submityes().click();
			Thread.sleep(4000);
		}
	    Thread.sleep(2000);
	    ac.Aclickback().click();
		Thread.sleep(4000);
	    String vendorsubmit = ac.verifyObsStatusVendor(templateName,submittedStatus,obsStatus).getText();
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
		driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
		 String un = f.getPropertyData("username");
		 String pw = f.getPropertyData("password");
		l.setLogin(un, pw);
		}catch(Exception e) {
			throw e;
		} 
	}
	
	@Test(priority= 5,testName="K",enabled= true)
	public void Auditorobservationplanning() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Assessmentobservationplanning",true);
		logger.info("Add observation planning");
		ac=new QuestionaryBasedAssessmentPage(driver);
		HomePage h = new HomePage(driver);
		Thread.sleep(2000);
		FileLib f=new FileLib();
		String templateName = f.getExcelData("AssessmentCalender",1,18);
		String astatusforAuditor = f.getExcelData("AssessmentCalender",2,21);
		String ostatusforAuditor = f.getExcelData("AssessmentCalender",1,23);
		String obsName1 = f.getExcelData("AssessmentCalender",2,8);
		String obsName2 = f.getExcelData("AssessmentCalender",3,8);
		String obsName3 = f.getExcelData("AssessmentCalender",4,8);
		String obsName4 = f.getExcelData("AssessmentCalender",5,8);
		String astatusforAuditor1 = f.getExcelData("AssessmentCalender",4,21);
		
		ac.ClickAssessment().click();
		Thread.sleep(2000);
		ac.Assessmentreview().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.observationplanning().click();
		
	    //question1
		ac.clickVendorResponse().click();
		ac.Areviewcomm().sendKeys("Vendor Review");
		ac.Aapprove().click();
		Thread.sleep(4000);
		ac.observationtitle2(obsName1).click();
	
		//question2
		Thread.sleep(2000);
		ac.clickVendorResponse().click();
		ac.Areviewcomm().sendKeys("Vendor Review");
		ac.Aapprove().click();
		/*Thread.sleep(2000);
		ac.observationtitle3(obsName2).click();
		
		//question3
		Thread.sleep(2000);
		ac.clickVendorResponse().click();
		ac.Areviewcomm().sendKeys("Vendor Review");
		ac.Aapprove().click();
		Thread.sleep(2000);
		ac.observationtitle4(obsName3).click();
		
	    //question4
		Thread.sleep(2000);
		ac.clickVendorResponse().click();
		ac.Areviewcomm().sendKeys("Vendor Review");
		ac.Aapprove().click();
		Thread.sleep(2000);
		ac.observationtitle5(obsName4).click();
		
		//question5
		Thread.sleep(2000);
		ac.clickVendorResponse().click();
		ac.Areviewcomm().sendKeys("Vendor Review");
		ac.Aapprove().click();*/
		
		Thread.sleep(4000);
		if(ac.vDisableSubmit().size() >=1) {
			ac.clickReviewPendingBtn().click();
			if(ac.verifyObservations().size()>=1) {
				for(int i=0;i<=ac.verifyObservations().size();i++) {
					ac.verifyObservations().get(i).click();
					
					Thread.sleep(2000);
					ac.clickVendorResponse().click();
					ac.Areviewcomm().sendKeys("Vendor Review");
					ac.Aapprove().click();
				}
				ac.submit().click();
				Thread.sleep(2000);
			    ac.AsubmityesObsPlanning().click();
			    Thread.sleep(3000);
			}else {
				Assert.fail("No question exists but submit button is disabled");
			}
		}else {
			ac.submit().click();
			Thread.sleep(2000);
		    ac.AsubmityesObsPlanning().click();
		    Thread.sleep(3000);
		}
	    ac.Aclickback().click();
		Thread.sleep(4000);
	    String vendorsubmit = ac.verifyObsStatusVendor(templateName,astatusforAuditor1,ostatusforAuditor).getText();
		System.out.println(vendorsubmit);
		String inProgress = f.getExcelData("AssertMessage",23,3);
		Assert.assertEquals(vendorsubmit,inProgress);
		Reporter.log("Asserttrue",true);
		h.setLogout();
		Thread.sleep(4000);
				
	}
	
	@Test(priority= 6,testName="K",enabled= true)
	public void VendorObservationLifeCycleSubmit() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Vendorobservation",true);
		logger.info("click on vendor observation");
		ac=new QuestionaryBasedAssessmentPage(driver);
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
		ac.vendorusername().sendKeys(Vusername);
		Thread.sleep(2000);
	    ac.vendorpassword().sendKeys(Vpw);
	    Thread.sleep(2000);
	    ac.VLogin().click();
	    
//	    FileLib f=new FileLib();
	    String obsName1 = f.getExcelData("AssessmentCalender",2,8);
		String obsName2 = f.getExcelData("AssessmentCalender",3,8);
		String obsName3 = f.getExcelData("AssessmentCalender",4,8);
		String obsName4 = f.getExcelData("AssessmentCalender",5,8);
		String templateName = f.getExcelData("AssessmentCalender",1,18);
		String assessmentStatus = f.getExcelData("AssessmentCalender",3,22);
		String obsStatus = f.getExcelData("AssessmentCalender",1,23);
		String submittedStatus = f.getExcelData("AssessmentCalender",2,22);
		String vComment = f.getExcelData("AssessmentCalender",1,24);
		Thread.sleep(2000);
	    ac.VClickAssessment().click();
	    Thread.sleep(5000);
	    ac.clickviewiconVendor(templateName,assessmentStatus,obsStatus).click();
	    Thread.sleep(2000);
	    ac.clickonobservation().click();
	    ac.clickonResponse().click();
	    
	    //question1
	    Thread.sleep(2000);
        ac.Claimclosed().click();
	    ac.vendorcomment().sendKeys(vComment);
	    Thread.sleep(2000);
	    ac.Vsave().click();
	    
	    //question2
	    Thread.sleep(4000);
	    ac.observationtitle2(obsName1).click();
	    ac.Claimclosed().click();
	    ac.vendorcomment().sendKeys(vComment);
	    Thread.sleep(2000);
	    ac.Vsave().click();
	    
	    Thread.sleep(4000);
	    ac.Vclaimclosed().click();
	    Thread.sleep(4000);
	    ac.clickonResponse().click();
	    
	    //question3
	   /* Thread.sleep(4000);
	    ac.observationtitle3(obsName2).click();
	    ac.Claimclosed().click();
	    ac.vendorcomment().sendKeys(vComment);
	    Thread.sleep(2000);
	    ac.Vsave().click();
	    
	    //question4
	    Thread.sleep(4000);
	    ac.observationtitle4(obsName3).click();
	    ac.Claimclosed().click();
	    ac.vendorcomment().sendKeys(vComment);
	    Thread.sleep(2000);
	    ac.Vsave().click();
	    
	    //question5
	    Thread.sleep(4000);
	    ac.observationtitle5(obsName4).click();
	    ac.Claimclosed().click();
	    ac.vendorcomment().sendKeys(vComment);
	    Thread.sleep(2000);
	    ac.Vsave().click();
	    
	    Thread.sleep(4000);
	    ac.Vclaimclosed().click();
	    Thread.sleep(4000);
	    ac.clickonResponse().click();*/
	    
	    //question1
	    ac.Vsave().click();
	    Thread.sleep(4000);
	    ac.submitobservation().click();
	    Thread.sleep(4000);
	    ac.submityes().click();
	    Thread.sleep(4000);
	    
	    //question2
	    Thread.sleep(2000);
	    ac.VQUESTION2().click();
	    Thread.sleep(4000);
	    ac.submitobservation().click();
	    Thread.sleep(2000);
	    ac.submityes().click();
	    
	    //question3
	   /* Thread.sleep(8000);
	    ac.VQUESTION3().click();
	    Thread.sleep(4000);
	    ac.submitobservation().click();
	    Thread.sleep(2000);
	    ac.submityes().click();
	    
	    //question4
	    Thread.sleep(8000);
	    ac.VQUESTION4().click();
	    Thread.sleep(4000);
	    ac.submitobservation().click();
	    Thread.sleep(2000);
	    ac.submityes().click();
	    
	  //question5
	    Thread.sleep(8000);
	    ac.VQUESTION5().click();
	    Thread.sleep(4000);
	    ac.submitobservation().click();
	    Thread.sleep(2000);
	    ac.submityes().click();*/
	    Thread.sleep(4000);
	    
	    ac.Aclickback().click();
		Thread.sleep(4000);
	    String vendorsubmit = ac.verifyObsStatusVendor(templateName,assessmentStatus,obsStatus).getText();
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
	
	@Test(priority= 7,testName="K",enabled= true)
	public void AuditorObservationReviewSumbit() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Auditorobservation",true);
		logger.info("click on auditor observation");
		ac=new QuestionaryBasedAssessmentPage(driver);
		HomePage h = new HomePage(driver);
		Thread.sleep(2000);
		
		FileLib f=new FileLib();
		String templateName = f.getExcelData("AssessmentCalender",1,18);
		String astatusforAuditor = f.getExcelData("AssessmentCalender",4,21);
		String ostatusforAuditor = f.getExcelData("AssessmentCalender",1,23);
		String obsName1 = f.getExcelData("AssessmentCalender",2,8);
		String obsName2 = f.getExcelData("AssessmentCalender",3,8);
		String obsName3 = f.getExcelData("AssessmentCalender",4,8);
		String obsName4 = f.getExcelData("AssessmentCalender",5,8);
		String aComment1 = f.getExcelData("AssessmentCalender",1,25);
		String aComment2 = f.getExcelData("AssessmentCalender",2,25);
		String aComment3 = f.getExcelData("AssessmentCalender",3,25);
		String aComment4 = f.getExcelData("AssessmentCalender",4,25);
		String aComment5 = f.getExcelData("AssessmentCalender",5,25);
		String astatusforAuditor1 = f.getExcelData("AssessmentCalender",5,21);
		String ostatusforAuditor1 = f.getExcelData("AssessmentCalender",2,23);
		
		ac.ClickAssessment().click();
		Thread.sleep(2000);
		ac.Assessmentreview().click();
		Thread.sleep(2000);
		
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);
		ac.Aclaim().click();
		Thread.sleep(2000);
		ac.AResponse().click();
		
		//question1
		Thread.sleep(4000);
		ac.AuditorComments().sendKeys(aComment1);
		Thread.sleep(4000);
		ac.Aclickonapprove().click();
		Thread.sleep(4000);
		//ac.CrossCC().click();
		
		//question2
		/*Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();*/
		//Thread.sleep(4000);
		ac.Aclaim().click();
		Thread.sleep(2000);
		ac.AResponse().click();	
		ac.Observationquestion2().click();
		Thread.sleep(4000);
		ac.AuditorComments().sendKeys(aComment2);
		Thread.sleep(4000);
		ac.Aclickonapprove().click();
		//Thread.sleep(2000);
		//ac.CrossCC().click();
		Thread.sleep(4000);
		//question3
		//Thread.sleep(10000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);*/
		/*ac.Aclaim().click();
		Thread.sleep(2000);
		ac.AResponse().click();	
		ac.Observationquestion3().click();
		Thread.sleep(2000);
		ac.AuditorComments().sendKeys(aComment3);
		Thread.sleep(2000);
		ac.Aclickonapprove().click();
		
		//question4
		Thread.sleep(10000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);*/
		/*ac.Aclaim().click();
		Thread.sleep(2000);
		ac.AResponse().click();	
		ac.Observationquestion4().click();
		Thread.sleep(2000);
		ac.AuditorComments().sendKeys(aComment4);
		Thread.sleep(2000);
		ac.Aclickonapprove().click();
		
		//question5
		Thread.sleep(10000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);*/
		/*ac.Aclaim().click();
		Thread.sleep(2000);
		ac.AResponse().click();	
		ac.Observationquestion5().click();
		Thread.sleep(2000);
		ac.AuditorComments().sendKeys(aComment5);
		Thread.sleep(2000);
		ac.Aclickonapprove().click();
		Thread.sleep(10000);*/
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);*/
		
		//SUBMIT
		
		ac.claimclosedapprove().click();
		Thread.sleep(2000);
		ac.clickVendorResponse().click();
		Thread.sleep(2000);
		
		//question1
		ac.submit().click();
		Thread.sleep(4000);
		ac.submityes1().click();
		Thread.sleep(4000);
		//ac.CrossSubmit().click();
		//Thread.sleep(4000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);*/
		ac.claimclosedapprove().click();
		Thread.sleep(2000);
		ac.clickVendorResponse().click();
		Thread.sleep(2000);
		
		//question2
		ac.clickobserQ().click();
		Thread.sleep(2000);
		ac.submit().click();
		Thread.sleep(2000);
		ac.submityes1().click();
		Thread.sleep(6000);
		//ac.CrossSubmit().click();
		//Thread.sleep(10000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);*/
		/*ac.claimclosedapprove().click();
		Thread.sleep(2000);
		ac.clickVendorResponse().click();
		Thread.sleep(2000);*/
		
		//question3
		/*ac.clickobserQ().click();
		Thread.sleep(2000);
		ac.submit().click();
		Thread.sleep(2000);
		ac.submityes1().click();
		Thread.sleep(10000);*/
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);*/
		/*ac.claimclosedapprove().click();
		Thread.sleep(2000);
		ac.clickVendorResponse().click();
		Thread.sleep(2000);*/
		
		//question4
		/*ac.clickobserQ().click();
		Thread.sleep(2000);
		ac.submit().click();
		Thread.sleep(2000);
		ac.submityes1().click();
		Thread.sleep(10000);*/
		/*driver.navigate().refresh();
		Thread.sleep(2000);
		ac.Aclickback().click();
		Thread.sleep(2000);
		ac.clickInfoIconWithObs(templateName,astatusforAuditor,ostatusforAuditor).click();
		Thread.sleep(2000);
		ac.Aobservation().click();
		Thread.sleep(2000);*/
		//ac.claimclosedapprove().click();
		//Thread.sleep(2000);
		//ac.clickVendorResponse().click();
		//Thread.sleep(2000);
		
		//question5
		//ac.clickobserQ().click();
		//Thread.sleep(2000);
		//ac.submit().click();
		//Thread.sleep(2000);
		//ac.submityes1().click();
		//Thread.sleep(10000);
		/*driver.navigate().refresh();
		Thread.sleep(2000);*/
		ac.Aclickback().click();
		Thread.sleep(2000);
		
		
		//view
		//ac.clickInfoIcon(templateName,astatusforAuditor1).click();
		//Thread.sleep(4000);
		/*ac.ClickonOCPercentage().click();
		Thread.sleep(6000);
		ac.ClickoncancelAuditor().click();
		Thread.sleep(2000);*/
		
		String vendorsubmit = ac.verifyObsStatusVendor(templateName,astatusforAuditor1,ostatusforAuditor1).getText();
		System.out.println(vendorsubmit);
		String completed = f.getExcelData("AssertMessage",24,3);
		Assert.assertEquals(vendorsubmit,completed);
		Reporter.log("Asserttrue",true);
		h.setLogout();
		Thread.sleep(4000);
	}
	
	@Test(priority= 8,testName="K",enabled= true)
	public void VerifyVendorQuestionaryAssessStatus() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("Vendorquestionsubmit",true);
		logger.info("Add vendor question");
		ac=new QuestionaryBasedAssessmentPage(driver);
    
		//vendor Login
		FileLib f=new FileLib();
		String vendorurl = f.getPropertyData("urlvendor");
		String Vusername = f.getPropertyData("vendorusername");
		String Vpw = f.getPropertyData("vendorpassword");
		
		String templateName = f.getExcelData("AssessmentCalender",1,18);
		String astatusforVendor = f.getExcelData("AssessmentCalender",3,22);
		String obsStatus = f.getExcelData("AssessmentCalender",2,23);
		
		Thread.sleep(2000);
	    driver.get(vendorurl);
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
		Thread.sleep(2000);
		ac.vendorusername().sendKeys(Vusername);
		Thread.sleep(2000);
	    ac.vendorpassword().sendKeys(Vpw);
	    ac.VLogin().click();
	    Thread.sleep(2000);
	    ac.VClickAssessment().click();
	    Thread.sleep(3000);
	    
		String vendorsubmit = ac.verifyObsStatusVendor(templateName,astatusforVendor,obsStatus).getText();
		System.out.println(vendorsubmit);
		
		ac.clkInfoIconVendor(templateName,astatusforVendor,obsStatus).click();
		Thread.sleep(2000);
		ac.Clickoncancelvendoror().click();
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
	
	@Test(priority=9,testName="K",enabled= true)
	public void VerifySearchQuestionaryAssessment() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("AssessmentQuestionnairLibrarby",true);
		logger.info("Add Assessment Calender");
		ac=new QuestionaryBasedAssessmentPage(driver);
		VendorManagementPage v=new VendorManagementPage(driver);
		UsersListPage au=new UsersListPage(driver);
		VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
		Thread.sleep(2000);
		
		FileLib f=new FileLib();
		String validData = f.getExcelData("AssessmentCalender",1,18);
		String invalidData = f.getExcelData("AssessmentCalender",1, 5);
		
		ac.ClickAssessment().click();
		Thread.sleep(2000);
		ac.ClickAssessmentCal().click();
		Thread.sleep(2000);
		
		ac.FrameworkSearch().sendKeys(validData);
		Thread.sleep(2000);
		if(ac.verify_AData().size()>0) {
			Assert.assertTrue(v.verifyUser(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		/*Thread.sleep(2000);
		ac.FrameworkSearch().clear();
		Thread.sleep(2000);
		ac.FrameworkSearch().sendKeys(invalidData);
		Thread.sleep(2000);
		if(ac.verify_AData().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(vc.verify_NoDataText().isDisplayed());
		}*/
		logger.info("Verfied successfully");
		
	}
}
