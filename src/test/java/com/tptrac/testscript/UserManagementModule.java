package com.tptrac.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

import com.tptrac.pom.FrameworkandQuestionsUploadPage;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.UpdateUser;
import com.tptrac.pom.UsersListPage;
import com.tptrac.generic.BaseClass;
import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class UserManagementModule extends BaseClass1{

	public static FluentWait<WebDriver> fWait;
	
	@Test(testName="A",priority=1,enabled= true)
	public void VerifyUsersTab() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("VerifyUsersTab",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(40))
				.pollingEvery(Duration.ofMillis(1000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		HomePage h=new HomePage(driver);
		try {
            // Define the tab name you want to verify
            String tabName = "Users"; // Replace with the actual tab name

            // Wait until the tab is present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Users']")));
            //WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-016")));

            // Verify if the tab is displayed and enabled
            if (tab.isDisplayed() && tab.isEnabled()) {
                System.out.println("Tab '" + tabName + "' is displayed and enabled successfully.");
                
             // Add explicit wait for the tab to be clickable
                wait.until(ExpectedConditions.elementToBeClickable(tab));
                // Click on the tab
                tab.click();
                System.out.println("Clicked on the tab '" + tabName + "'.");
            } else {
                System.out.println("Tab '" + tabName + "' is either not displayed or not enabled.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } 
		
	}
	
	
	@Test(testName="A",priority=2, enabled= true)
	public void testAddUserBlankField() throws InterruptedException, EncryptedDocumentException, IOException {
	    Reporter.log("AddUser", true);
	    fWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(10))
	            .pollingEvery(Duration.ofMillis(2000));

	    HomePage h = new HomePage(driver);
	    FileLib f = new FileLib();
	    h.setUserMenu();
	    logger.info("User tab selected");
	    
	    UsersListPage u = new UsersListPage(driver);
	   fWait.until(ExpectedConditions.visibilityOf(u.getAddNew()));
	   Thread.sleep(2000);
		u.getAddNew().click();
		logger.info("Add user button clicked");
		fWait.until(ExpectedConditions.visibilityOf(u.getAddButton()));
		fWait.until(ExpectedConditions.elementToBeClickable(u.getAddButton()));
		u.getAddButton().click();
		logger.info("Clicked on Add Button");

	    String userid = f.getExcelData("AssertMessage", 29, 3);
	    String userid1 = u.useridfield().getText();
	    Assert.assertEquals(userid1, userid);
	    Reporter.log("User ID assertion passed", true);
	    fWait.until(ExpectedConditions.visibilityOf(u.clickCancel()));
	    fWait.until(ExpectedConditions.elementToBeClickable(u.clickCancel()));
	    u.clickCancel().click();
	    Thread.sleep(2000);
	}
	
	@Test(testName="A",priority=3,enabled= true) 
	public void testAddADAuditorUser() throws InterruptedException, EncryptedDocumentException, IOException {
	    Reporter.log("AddAuditorUser", true);
	    fWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(40))
	            .pollingEvery(Duration.ofMillis(1000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);

	    HomePage h = new HomePage(driver);
	    h.setUserMenu();
	    logger.info("User tab selected");

	    UsersListPage u = new UsersListPage(driver);
	    fWait.until(ExpectedConditions.visibilityOf(u.getAddNew()));
	    u.getAddNew().click();
	    logger.info("Add user button clicked");

	    FileLib f = new FileLib();
	    String userName = f.getExcelData("ADAuditorUser", 1, 3);
	    logger.info("Get user name data");

	    String userContactNum = f.getExcelData("ADAuditorUser", 1, 7);
	    logger.info("Get user contact data");

	    String EmailID = f.getExcelData("ADAuditorUser", 1, 6);
	    logger.info("enter email id");

	    String UserRole = f.getExcelData("ADAuditorUser", 1, 8);
	    logger.info("Get user role data");

	    u.getUserName().sendKeys(userName);
	    logger.info("Entered User ID");

	    u.EnterEmailID().sendKeys(EmailID);
	    fWait.until(ExpectedConditions.visibilityOf(u.EnterEmailID()));
	    logger.info("Entered Email ID");

	    String cont = userContactNum.substring(1, 11);
	    fWait.until(ExpectedConditions.visibilityOf(u.getContactNo()));
	    u.getContactNo().sendKeys(cont);
	    logger.info("Entered user contact");
	    Thread.sleep(2000);
	    u.ClickUserRoleField().click();
		Thread.sleep(2000);
		//u.RoleSelected().click();
		WebElement roleElement = u.RoleSelected();
		fWait.until(ExpectedConditions.elementToBeClickable(roleElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roleElement);
		roleElement.click();

		Thread.sleep(2000);
		u.ClickUserRoleField().click();
		//Thread.sleep(2000);
	    logger.info("Role selected");
 
	    fWait.until(ExpectedConditions.visibilityOf(u.getAddButton()));
	    Thread.sleep(2000);
	    u.getAddButton().click();
	    logger.info("Clicked on Add Button");
	    
	 // Searching for the user
	    try {
	        fWait.until(ExpectedConditions.elementToBeClickable(u.searchUser()));
	        logger.info("Search user field is clickable");

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].focus();", u.searchUser());
	        js.executeScript("arguments[0].value='" + userName + "';", u.searchUser());
	        logger.info("Sent keys to search user using JavaScript");
	    } catch (ElementNotInteractableException e) {
	        logger.error("Element not interactable, trying to set value via fallback");
	    }

	    // Verifying the created user
	    verifyUserCreated1(u, userName);
	}

	private void verifyUserCreated1(UsersListPage u, String userName) {
	    WebElement actualUser1;
	    int retries = 3;
	    while (retries > 0) {
	        try {
	            actualUser1 = u.getActualUserCreated(userName);
	            fWait.until(ExpectedConditions.visibilityOf(actualUser1));
	            String actualText = actualUser1.getText();
	            Assert.assertEquals(actualText, userName);
	            logger.info("Verified Actual user successfully");
	            return; // Exit if verification is successful
	        } catch (StaleElementReferenceException e) {
	            logger.warn("StaleElementReferenceException encountered, retrying...");
	            retries--;
	            // Optional: Wait a bit before retrying
	            try {
	                Thread.sleep(1000); // Wait before the next attempt
	            } catch (InterruptedException ie) {
	                Thread.currentThread().interrupt(); // Restore interrupted status
	            }
	        }
	    }
	    Assert.fail("User verification failed after multiple attempts.");
	
	}
	


@Test(priority = 4, testName = "A", enabled = true)
public void testUpdateADAuditorUser() throws InterruptedException, EncryptedDocumentException, IOException {
    Reporter.log("UpdateADauditorUser", true);
    logger.info("Start AD Auditor User Update validation");

    FluentWait<WebDriver> fWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(2000))
            .ignoring(NoSuchElementException.class, TimeoutException.class);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    HomePage homePage = new HomePage(driver);
    UsersListPage usersListPage = new UsersListPage(driver);
    UpdateUser updateUser = new UpdateUser(driver);
    FileLib fileLib = new FileLib();

    String user = fileLib.getExcelData("UpdateADAuditorUser", 1, 3);
    String user1 = fileLib.getExcelData("UpdateADAuditorUser", 1, 6);

    // Navigate to User menu
    homePage.setUserMenu();
    logger.info("User tab selected");

    // Search for user
    WebElement searchInput = fWait.until(ExpectedConditions.visibilityOf(usersListPage.searchUser()));
    searchInput.clear();
    Thread.sleep(2000); // still needed? Consider WebDriverWait instead
    searchInput.sendKeys(user);

    // Wait and select user to update
    WebElement userToSelect = fWait.until(ExpectedConditions.elementToBeClickable(updateUser.ClickUsertoSelect(user)));
    userToSelect.click();
    logger.info("User selected to update the data");
    Thread.sleep(4000);
    // Edit First Name
    WebElement firstNameField = wait.until(ExpectedConditions.visibilityOf(updateUser.editLastName()));
    wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
    firstNameField.clear();
    firstNameField.sendKeys(user1);

    // Edit Phone Number
    WebElement phoneField = fWait.until(ExpectedConditions.visibilityOf(updateUser.phoneNumberUpdate()));
    phoneField.clear();
    logger.info("Phone number cleared");

    String contactNum = fileLib.getExcelData("UpdateADAuditorUser", 1, 4);
    String trimmedContact = contactNum.substring(1, 11);
    phoneField.sendKeys(trimmedContact);
    logger.info("New phone number entered: " + trimmedContact);

    // Save changes
    WebElement saveButton = fWait.until(ExpectedConditions.elementToBeClickable(updateUser.clickonSave()));
    saveButton.click();
    logger.info("Clicked on Save button");

    // Validate updated user
    /*String actualText = usersListPage.getActualUserCreatedForEdit(user1).getText();
    Assert.assertEquals(actualText, user1, "User update validation failed!");
    logger.info("Verified updated user successfully");*/
}

	
	

	@Test(testName="A",priority=3,enabled= false) 
	public void testAddLocalAuditorUser() throws InterruptedException, EncryptedDocumentException, IOException {
	    Reporter.log("AddAuditorUser", true);
	    fWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(40))
	            .pollingEvery(Duration.ofMillis(1000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);

	    HomePage h = new HomePage(driver);
	    h.setUserMenu();
	    logger.info("User tab selected");

	    UsersListPage u = new UsersListPage(driver);
	    fWait.until(ExpectedConditions.visibilityOf(u.getAddNew()));
	    u.getAddNew().click();
	    logger.info("Add user button clicked");

	    FileLib f = new FileLib();
	    String userName = f.getExcelData("AddUser", 1, 3);
	    logger.info("Get user name data");

	    String userContactNum = f.getExcelData("AddUser", 1, 7);
	    logger.info("Get user contact data");

	    String Fname = f.getExcelData("AddUser", 1, 4);
	    logger.info("enter first name");

	    String Lname = f.getExcelData("AddUser", 1, 5);
	    logger.info("enter last name");

	    String EmailID = f.getExcelData("AddUser", 1, 6);
	    logger.info("enter email id");

	    String UserRole = f.getExcelData("AddUser", 1, 8);
	    logger.info("Get user role data");

	    u.getUserName().sendKeys(userName);
	    logger.info("Entered User ID");

	    u.EnterFirstname().sendKeys(Fname);
	    fWait.until(ExpectedConditions.visibilityOf(u.EnterFirstname()));
	    logger.info("Entered First Name");

	    u.EnterLastname().sendKeys(Lname);
	    fWait.until(ExpectedConditions.visibilityOf(u.EnterLastname()));
	    logger.info("Entered Last Name");

	    u.EnterEmailID().sendKeys(EmailID);
	    fWait.until(ExpectedConditions.visibilityOf(u.EnterEmailID()));
	    logger.info("Entered Email ID");
	    
	    u.ClickDepartmentField().click();
		Thread.sleep(2000);
		u.DeptSelected().click();
		Thread.sleep(2000);
		u.ClickDepartmentField().click(); 

	    String cont = userContactNum.substring(1, 11);
	    fWait.until(ExpectedConditions.visibilityOf(u.getContactNo()));
	    u.getContactNo().sendKeys(cont);
	    logger.info("Entered user contact");
	    Thread.sleep(2000);
	    u.ClickUserRoleField().click();
		Thread.sleep(2000);
		//u.RoleSelected().click();
		WebElement roleElement = u.RoleSelected();
		fWait.until(ExpectedConditions.elementToBeClickable(roleElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roleElement);
		roleElement.click();

		Thread.sleep(2000);
		u.ClickUserRoleField().click();
		//Thread.sleep(2000);
	    logger.info("Role selected");
 
	    fWait.until(ExpectedConditions.visibilityOf(u.getAddButton()));
	    Thread.sleep(2000);
	    u.getAddButton().click();
	    logger.info("Clicked on Add Button");
	    
	 // Searching for the user
	    try {
	        fWait.until(ExpectedConditions.elementToBeClickable(u.searchUser()));
	        logger.info("Search user field is clickable");

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].focus();", u.searchUser());
	        js.executeScript("arguments[0].value='" + userName + "';", u.searchUser());
	        logger.info("Sent keys to search user using JavaScript");
	    } catch (ElementNotInteractableException e) {
	        logger.error("Element not interactable, trying to set value via fallback");
	    }

	    // Verifying the created user
	    verifyUserCreated(u, userName);
	}

	private void verifyUserCreated(UsersListPage u, String userName) {
	    WebElement actualUser;
	    int retries = 3;
	    while (retries > 0) {
	        try {
	            actualUser = u.getActualUserCreated(userName);
	            fWait.until(ExpectedConditions.visibilityOf(actualUser));
	            String actualText = actualUser.getText();
	            Assert.assertEquals(actualText, userName);
	            logger.info("Verified Actual user successfully");
	            return; // Exit if verification is successful
	        } catch (StaleElementReferenceException e) {
	            logger.warn("StaleElementReferenceException encountered, retrying...");
	            retries--;
	            // Optional: Wait a bit before retrying
	            try {
	                Thread.sleep(1000); // Wait before the next attempt
	            } catch (InterruptedException ie) {
	                Thread.currentThread().interrupt(); // Restore interrupted status
	            }
	        }
	    }
	    Assert.fail("User verification failed after multiple attempts.");
	
	}
	


@Test(priority = 4, testName = "A", enabled = false)
public void testUpdateLocalAuditorUser() throws InterruptedException, EncryptedDocumentException, IOException {
    Reporter.log("UpdateUser", true);
    logger.info("Start Auditor User Update validation");

    FluentWait<WebDriver> fWait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofMillis(2000))
            .ignoring(NoSuchElementException.class, TimeoutException.class);

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    HomePage homePage = new HomePage(driver);
    UsersListPage usersListPage = new UsersListPage(driver);
    UpdateUser updateUser = new UpdateUser(driver);
    FileLib fileLib = new FileLib();

    String user = fileLib.getExcelData("UpdateUser", 1, 6);
    String user1 = fileLib.getExcelData("UpdateUser", 1, 7);

    // Navigate to User menu
    homePage.setUserMenu();
    logger.info("User tab selected");

    // Search for user
    WebElement searchInput = fWait.until(ExpectedConditions.visibilityOf(usersListPage.searchUser()));
    searchInput.clear();
    Thread.sleep(2000); // still needed? Consider WebDriverWait instead
    searchInput.sendKeys(user);

    // Wait and select user to update
    WebElement userToSelect = fWait.until(ExpectedConditions.elementToBeClickable(updateUser.ClickUsertoSelect(user)));
    userToSelect.click();
    logger.info("User selected to update the data");
    Thread.sleep(4000);
    // Edit First Name
    WebElement firstNameField = wait.until(ExpectedConditions.visibilityOf(updateUser.editFirstName()));
    wait.until(ExpectedConditions.elementToBeClickable(firstNameField));
    firstNameField.clear();
    firstNameField.sendKeys(user);

    // Edit Phone Number
    WebElement phoneField = fWait.until(ExpectedConditions.visibilityOf(updateUser.phoneNumberUpdate()));
    phoneField.clear();
    logger.info("Phone number cleared");

    String contactNum = fileLib.getExcelData("UpdateUser", 1, 4);
    String trimmedContact = contactNum.substring(1, 11);
    phoneField.sendKeys(trimmedContact);
    logger.info("New phone number entered: " + trimmedContact);

    // Save changes
    WebElement saveButton = fWait.until(ExpectedConditions.elementToBeClickable(updateUser.clickonSave()));
    saveButton.click();
    logger.info("Clicked on Save button");

    // Validate updated user
    String actualText = usersListPage.getActualUserCreatedForEdit(user1).getText();
    Assert.assertEquals(actualText, user1, "User update validation failed!");
    logger.info("Verified updated user successfully");
}

	
	@Test(priority= 5,testName="A",enabled= false)
	public void verifyAuditorUserDetails() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Reporter.log("VerifyAuditorUserDetails",true);
		//To view vendor user list details
		HomePage h=new HomePage(driver);
		logger.info("Started user list validation");
		// Setting up FluentWait
	    FluentWait<WebDriver> fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(10))
	            .pollingEvery(Duration.ofMillis(2000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);
	    
	    h.setUserMenu();
	    logger.info("Clicked on user tab");
	    UsersListPage au = new UsersListPage(driver);
	    // Wait for the user details to be visible
	    List<WebElement> list = au.ViewUserDetails();;
	    
	    System.out.println(list.size());
	    for (int i = 0; i < list.size(); i++) 
	    {
	        // Log and print user details
	        String userDetail = list.get(i).getText();
	        System.out.println(userDetail);
	        logger.info("Get the user list details: " + userDetail);
	        
	        logger.info("Clicked on next button");
	          
	    }
	}
	
	
	
	@Test(priority= 5,testName="A",enabled= true)
	public void searchUser() throws InterruptedException, EncryptedDocumentException, IOException 
	{
		Reporter.log("search AD auditor user",true);
		logger.info("Start Search User validation");
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h = new HomePage(driver);
	    UsersListPage au = new UsersListPage(driver);
	    FileLib f = new FileLib();
	    
	    String validData = f.getExcelData("ADAuditorUser", 1, 3);
	    logger.info("Get valid data");
	    String invalidData = f.getExcelData("ADAuditorUser", 1, 6);
	    logger.info("Get invalid data");
	    
	    h.setUserMenu();
	    logger.info("User tab selected");
	    
	    UpdateUser up = new UpdateUser(driver);
	    au.searchUser().clear();
	    // Wait for the search user field to be visible and send valid data
	    fWait.until(ExpectedConditions.visibilityOf(au.searchUser()));
	    au.searchUser().sendKeys(validData);
	    
	    // Check if user is found
	    if(au.verify_Data().size()>0) {
			Assert.assertTrue(au.verifyUser(validData).isDisplayed());
		}else {
			Assert.fail();
		}
	    
	    // Clear the search field and search for invalid data
	    fWait.until(ExpectedConditions.visibilityOf(au.searchUser())).clear();
	    au.searchUser().sendKeys(invalidData);
	    
	    // Check if no data is found
	    if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(au.verify_NoDataText().isDisplayed());
		}

	    logger.info("Verified search user functionality successfully");
	}
	
	
	@Test(testName = "A", priority = 6, enabled = true)
	public void testDisabledADAuditorUser() throws InterruptedException, EncryptedDocumentException, IOException {
	    Reporter.log("AddAuditorUser", true);

	    // Initialize Fluent Wait
	    fWait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(40))
	            .pollingEvery(Duration.ofMillis(1000))
	            .ignoring(NoSuchElementException.class, TimeoutException.class);

	    // Page Object Initialization
	    HomePage h = new HomePage(driver);
	    h.setUserMenu();
	    logger.info("User tab selected");

	    UpdateUser up = new UpdateUser(driver);
	    UsersListPage u = new UsersListPage(driver);

	    // Wait for Add New button and click it
	    fWait.until(ExpectedConditions.elementToBeClickable(u.getAddNew()));
	    u.getAddNew().click();
	    logger.info("Add user button clicked");

	    // Read data from Excel
	    FileLib f = new FileLib();
	    String userName = f.getExcelData("ADAuditorUser", 2, 3);
	    String userContactNum = f.getExcelData("ADAuditorUser", 2, 7);
	    String emailID = f.getExcelData("ADAuditorUser", 2, 6);
	    String userRole = f.getExcelData("ADAuditorUser", 2, 8);

	    logger.info("Fetched test data from Excel");

	    // Fill in user details
	    u.getUserName().sendKeys(userName);
	    logger.info("Entered User ID: " + userName);
	    Thread.sleep(2000);
	    u.EnterEmailID().sendKeys(emailID);
	    fWait.until(ExpectedConditions.visibilityOf(u.EnterEmailID()));
	    logger.info("Entered Email ID: " + emailID);

	    String contact = userContactNum.substring(1, 11); // Trimming country code
	    fWait.until(ExpectedConditions.visibilityOf(u.getContactNo()));
	    u.getContactNo().sendKeys(contact);
	    logger.info("Entered Contact No: " + contact);

	    // Select User Role
	    u.ClickUserRoleField().click();
		Thread.sleep(2000);
		//u.RoleSelected().click();
		WebElement roleElement = u.RoleSelected();
		fWait.until(ExpectedConditions.elementToBeClickable(roleElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roleElement);
		roleElement.click();

		Thread.sleep(2000);
		u.ClickUserRoleField().click();
		//Thread.sleep(2000);
	    logger.info("Role selected");
	  
	    // Click "Add" button
	    Thread.sleep(2000);
	    fWait.until(ExpectedConditions.elementToBeClickable(u.getAddButton()));
	    u.getAddButton().click();
	    logger.info("Clicked on Add Button");

	    // === Search and select newly created user ===
	    WebElement searchInput = u.searchUser();
	    Thread.sleep(2000);
	    fWait.until(ExpectedConditions.elementToBeClickable(searchInput));
	    //searchInput.clear();
	    searchInput.sendKeys(userName);
	    logger.info("Searching for user: " + userName);

	    // Wait until the correct user appears in the table
	   /* By userRowLocator = By.xpath("//td[contains(text(),'" + userName + "')]");
	    fWait.until(ExpectedConditions.visibilityOfElementLocated(userRowLocator));
	    WebElement userRow = driver.findElement(userRowLocator);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", userRow);
	    userRow.click();
	    logger.info("Selected user: " + userName);*/
	    Thread.sleep(4000);
	    fWait.until(ExpectedConditions.elementToBeClickable(up.ClickUsertoSelect(userName)));
		up.ClickUsertoSelect(userName).click();

	    // Deactivate user
	    fWait.until(ExpectedConditions.elementToBeClickable(u.ClickCheckbox()));
	    u.ClickCheckbox().click();
	    Thread.sleep(2000);
	    fWait.until(ExpectedConditions.elementToBeClickable(u.ClickDeactive()));
	    u.ClickDeactive().click();
	    Thread.sleep(2000);
	    // Handle confirmation modal and click "Yes"
	    WebElement yesButton = u.Yes();
	    fWait.until(ExpectedConditions.visibilityOf(yesButton));
	    fWait.until(ExpectedConditions.elementToBeClickable(yesButton));

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yesButton);

	    // Retry click logic for intercept issues
	    boolean clicked = false;
	    int attempts = 0;
	    while (!clicked && attempts < 3) {
	        try {
	            yesButton.click();
	            clicked = true;
	            logger.info("Clicked 'Yes' to confirm deactivation.");
	        } catch (ElementClickInterceptedException e) {
	            logger.warn("Click intercepted, retrying...");
	            Thread.sleep(500);
	            attempts++;
	        }
	    }

	    if (!clicked) {
	        logger.error("Failed to click on the 'Yes' button after multiple attempts.");
	        throw new RuntimeException("Unable to click the Yes button.");
	    }

	    // === Verification: Ensure user is deactivated ===
	    // Search for the user again
	    WebElement searchAgain = u.searchUser();
	    fWait.until(ExpectedConditions.elementToBeClickable(searchAgain));
	    searchAgain.clear();
	    searchAgain.sendKeys(userName);
	    logger.info("Verifying deactivation for user: " + userName);

	    // Wait and assert
	    Thread.sleep(2000); // Optional, to allow UI update (use explicit wait if needed)
	    if (u.verify_Data().size() > 0) {
	        logger.error("User still appears in the list after deactivation.");
	        Assert.fail("User still appears in the list after deactivation.");
	    } else {
	        Assert.assertTrue(u.verify_NoDataText().isDisplayed());
	        logger.info("User successfully deactivated and no longer visible.");
	    }
	}

	
	@Test(priority= 7,testName="A",enabled= true)
	public void ChangeADAuditorUserStatus() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log(" Started Change User Status",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h=new HomePage(driver); 
		h.setUserMenu();
		logger.info("User tab selected");
		UsersListPage u=new UsersListPage(driver);
		UpdateUser up = new UpdateUser(driver);
		FileLib f=new FileLib();
	    String userName = f.getExcelData("ADAuditorUser", 2, 3);
	    logger.info("Get user name data");
	    Thread.sleep(4000);
		fWait.until(ExpectedConditions.elementToBeClickable(u.DRselect())).click();
		Thread.sleep(4000);
		fWait.until(ExpectedConditions.visibilityOf(u.checkbox()));
		fWait.until(ExpectedConditions.elementToBeClickable(u.checkbox()));
		u.checkbox().click();
		fWait.until(ExpectedConditions.visibilityOf(u.DRselect()));
		fWait.until(ExpectedConditions.elementToBeClickable(u.DRselect())).click();
		u.searchUser().clear();
		Thread.sleep(4000);
		u.searchUser().sendKeys(userName);
		Thread.sleep(4000);
		fWait.until(ExpectedConditions.elementToBeClickable(up.ClickUsertoSelect(userName)));
		up.ClickUsertoSelect(userName).click();
		fWait.until(ExpectedConditions.visibilityOf(u.ClickCheckbox()));
		u.ClickCheckbox().click();
		fWait.until(ExpectedConditions.visibilityOf(u.ClickActive()));
		fWait.until(ExpectedConditions.elementToBeClickable(u.ClickActive())).click();
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(u.Yes()));
		u.Yes().click();
		String invalidData = f.getExcelData("ADAuditorUser",2, 3);
		logger.info("Get invalid data");
		Thread.sleep(2000);
		u.searchUser().sendKeys(invalidData);
		if(u.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(u.verify_NoDataText().isDisplayed());
		}
		logger.info("User activate successfully");
		}
	
	

	
	@Test(priority= 6, testName="A",enabled= false) 
	public void DisabledLocalAuditorUser() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log("started Disabled User validation",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h = new HomePage(driver);
	    h.setUserMenu();
	    logger.info("User tab selected");

	    UsersListPage u = new UsersListPage(driver);
	    UpdateUser up = new UpdateUser(driver);

	    fWait.until(ExpectedConditions.visibilityOf(u.getAddNew()));
	    u.getAddNew().click();
	    logger.info("Add user button clicked");

	    FileLib f = new FileLib();
	    String userName = f.getExcelData("AddUser", 2, 3);
	    logger.info("Get user name data");

	    String userContactNum = f.getExcelData("AddUser", 2, 7);
	    logger.info("Get user contact data");

	    String Fname = f.getExcelData("AddUser", 2, 4);
	    logger.info("enter first name");

	    String Lname = f.getExcelData("AddUser", 2, 5);
	    logger.info("enter last name");

	    String EmailID = f.getExcelData("AddUser", 2, 6);
	    logger.info("enter email id");

	    String UserRole = f.getExcelData("AddUser", 2, 8);
	    logger.info("Get user role data");

	    u.getUserName().sendKeys(userName);
	    logger.info("Entered User ID");

	    u.EnterFirstname().sendKeys(Fname);
	    fWait.until(ExpectedConditions.visibilityOf(u.EnterFirstname()));
	    logger.info("Entered First Name");

	    u.EnterLastname().sendKeys(Lname);
	    fWait.until(ExpectedConditions.visibilityOf(u.EnterLastname()));
	    logger.info("Entered Last Name");

	    u.EnterEmailID().sendKeys(EmailID);
	    fWait.until(ExpectedConditions.visibilityOf(u.EnterEmailID()));
	    logger.info("Entered Email ID");
	    
	    u.ClickDepartmentField().click();
		Thread.sleep(2000);
		u.DeptSelected().click();
		Thread.sleep(2000);
		u.ClickDepartmentField().click(); 

	    String cont = userContactNum.substring(2, 11);
	    fWait.until(ExpectedConditions.visibilityOf(u.getContactNo()));
	    u.getContactNo().sendKeys(cont);
	    logger.info("Entered user contact");
	    Thread.sleep(2000);
	    u.ClickUserRoleField().click();
		Thread.sleep(4000);
		//u.RoleSelected().click();
		WebElement roleElement = u.RoleSelected();
		fWait.until(ExpectedConditions.elementToBeClickable(roleElement));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", roleElement);
		roleElement.click();

		Thread.sleep(2000);
		u.ClickUserRoleField().click();
		//Thread.sleep(2000);
	    logger.info("Role selected");
 
	    fWait.until(ExpectedConditions.visibilityOf(u.getAddButton()));
	    Thread.sleep(2000);
	    u.getAddButton().click();
	    logger.info("Clicked on Add Button");
	    Thread.sleep(4000);
		//u.searchUser().sendKeys(userName);
	    WebElement searchBox = u.searchUser();
	    fWait.until(ExpectedConditions.visibilityOf(searchBox));
	    fWait.until(ExpectedConditions.elementToBeClickable(searchBox));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchBox);
	    searchBox.clear();
	    searchBox.sendKeys(userName);

		Thread.sleep(4000);
		fWait.until(ExpectedConditions.elementToBeClickable(up.ClickUsertoSelect(userName)));
		//Thread.sleep(4000);
		up.ClickUsertoSelect(userName).click();
		
		fWait.until(ExpectedConditions.visibilityOf(u.ClickCheckbox()));
		u.ClickCheckbox().click();
		
		fWait.until(ExpectedConditions.visibilityOf(u.ClickDeactive()));
		u.ClickDeactive().click();
		
		// Wait for the "Yes" button to be visible
	    WebElement yesButton = u.Yes();
	    fWait.until(ExpectedConditions.visibilityOf(yesButton));

	    logger.info("Yes button displayed: " + yesButton.isDisplayed());
	    logger.info("Yes button enabled: " + yesButton.isEnabled());

	    // Check for overlays before clicking
	    fWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("css-selector-for-overlay")));

	    // Scroll into view
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yesButton);

	    // Attempt to click with retries
	    boolean clicked = false;
	    int attempts = 0;

	    while (!clicked && attempts < 3) {
	        try {
	            yesButton.click();
	            clicked = true; // Click was successful
	        } catch (ElementClickInterceptedException e) {
	            logger.warn("Click intercepted, retrying...");
	            attempts++;
	            Thread.sleep(500); // Wait before retrying
	        }
	    }

	    if (!clicked) {
	        logger.error("Failed to click on the Yes button after multiple attempts.");
	        throw new RuntimeException("Unable to click the Yes button.");
	    }

	    logger.info("Yes button clicked successfully.");
	    
		/*fWait.until(ExpectedConditions.visibilityOf(u.Yes()));
		u.Yes().click();*/
		//Thread.sleep(2000);
		String invalidData = f.getExcelData("AddUser",2, 3);
		logger.info("Get invalid data");
		u.searchUser().sendKeys(invalidData);
		//Thread.sleep(2000);
		if(u.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(u.verify_NoDataText().isDisplayed());
		}
		logger.info("Verified successfully");
		}

	@Test(priority= 8,testName="A",enabled= false)
	public void ChangeLocalAuditorUserStatus() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Reporter.log(" Started Change User Status",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		HomePage h=new HomePage(driver); 
		h.setUserMenu();
		logger.info("User tab selected");
		UsersListPage u=new UsersListPage(driver);
		UpdateUser up = new UpdateUser(driver);
		FileLib f=new FileLib();
	    String userName = f.getExcelData("AddUser", 2, 3);
	    logger.info("Get user name data");
	    Thread.sleep(4000);
		fWait.until(ExpectedConditions.elementToBeClickable(u.DRselect())).click();
		Thread.sleep(4000);
		fWait.until(ExpectedConditions.visibilityOf(u.checkbox()));
		fWait.until(ExpectedConditions.elementToBeClickable(u.checkbox()));
		u.checkbox().click();
		fWait.until(ExpectedConditions.visibilityOf(u.DRselect()));
		fWait.until(ExpectedConditions.elementToBeClickable(u.DRselect())).click();
		u.searchUser().clear();
		Thread.sleep(2000);
		u.searchUser().sendKeys(userName);
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.elementToBeClickable(up.ClickUsertoSelect(userName)));
		up.ClickUsertoSelect(userName).click();
		fWait.until(ExpectedConditions.visibilityOf(u.ClickCheckbox()));
		u.ClickCheckbox().click();
		fWait.until(ExpectedConditions.visibilityOf(u.ClickActive()));
		fWait.until(ExpectedConditions.elementToBeClickable(u.ClickActive())).click();
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(u.Yes()));
		u.Yes().click();
		String invalidData = f.getExcelData("AddUser",2,3);
		logger.info("Get invalid data");
		u.searchUser().sendKeys(invalidData);
		
		if(u.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(u.verify_NoDataText().isDisplayed());
		}
		logger.info("User activate successfully");
		}
	
	
	@Test(priority= 8,testName="A",enabled= true)
	public void ExportExcel() throws InterruptedException
	{
		Reporter.log("Started Excel export process",true);
		fWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofMillis(2000))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		FrameworkandQuestionsUploadPage qf = new FrameworkandQuestionsUploadPage(driver);
		HomePage h=new HomePage(driver); 
		qf.ClickonUpload().click();
		Thread.sleep(2000);
		h.setUserMenu();
		logger.info("User tab selected");
		UsersListPage u=new UsersListPage(driver);
		Thread.sleep(4000);
		fWait.until(ExpectedConditions.visibilityOf(u.DRselect()));
		u.DRselect().click();
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(u.Allcheckbox()));
		u.Allcheckbox().click();
		Thread.sleep(2000);
		fWait.until(ExpectedConditions.visibilityOf(u.DRselect()));
		u.DRselect().click();
		fWait.until(ExpectedConditions.visibilityOf(u.ClickExportExcel()));
		Thread.sleep(2000);
		u.ClickExportExcel().click();
		
	}	
}



