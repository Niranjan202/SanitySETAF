package com.tptrac.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.generic.FileLib;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.VendorCategoryManagementPage;
import com.tptrac.pom.VendorManagementPage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class UpdateVendorCategory extends BaseClass1{
	
	public static FluentWait<WebDriver> fWait;
	
	@Test(testName="C",priority=1,enabled= true)
	public void UpdateVendorCateory() throws InterruptedException, EncryptedDocumentException, IOException {

	Reporter.log("UpdateVendorCategory",true);
	fWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(2000))
			.ignoring(NoSuchElementException.class, TimeoutException.class);
	
	FileLib f=new FileLib();
	String vendorcategoryname= f.getExcelData("AddVendorCategory",1, 3);
	String vendorcategoryname1 = f.getExcelData("UpdateVendorCategory",1, 3);
	String vendorcategorycode1 = f.getExcelData("UpdateVendorCategory",1, 4);
	HomePage h=new HomePage(driver);
	VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
	UsersListPage u=new UsersListPage(driver);
	Thread.sleep(4000);
    h.setVendorMenu();
    logger.info("Click on vendor menu");
    fWait.until(ExpectedConditions.visibilityOf(vc.clickvcmanagement()));
    Thread.sleep(4000);
    vc.clickvcmanagement().click();
    Thread.sleep(4000);
    vc.CategorySearch().sendKeys(vendorcategoryname);
    Thread.sleep(2000);//added this search code on 19th june 2024
    //vc.vctitle(f.getExcelData("AddVendorCategory",1, 3)).click(); //added parameters (blocked thiscode on 19th june 2024)
    vc.rowselected().click();
    fWait.until(ExpectedConditions.visibilityOf(vc.SectorcName()));
    vc.SectorcName().clear();
    fWait.until(ExpectedConditions.visibilityOf(vc.SectorcName()));
    vc.SectorcName().sendKeys(vendorcategoryname1);
    fWait.until(ExpectedConditions.visibilityOf(vc.Sectorccode()));
    vc.Sectorccode().clear();
    fWait.until(ExpectedConditions.visibilityOf(vc.Sectorccode()));
    vc.Sectorccode().sendKeys(vendorcategorycode1);
    vc.editVSave().click();
    String actualText = vc.GetActualUserUpdated(vendorcategoryname1).getText(); //added parameters
    Assert.assertEquals(actualText,vendorcategoryname1);
    Reporter.log("assertTrue",true);

  }

	@Test(priority=2,testName="C",enabled= true)
	public void searchVendorCategory() throws InterruptedException, EncryptedDocumentException, IOException {
	Reporter.log("SearchVendorCategory",true);
	fWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(2000))
			.ignoring(NoSuchElementException.class, TimeoutException.class);
	
	////To veiw vendor user details
	HomePage h=new HomePage(driver);
	
	VendorManagementPage v=new VendorManagementPage(driver);
	VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
	UsersListPage au=new UsersListPage(driver);
	
	FileLib f=new FileLib();
	String validData = f.getExcelData("UpdateVendorCategory",1, 3);
	String invalidData = f.getExcelData("UpdateVendorCategory",1, 5);
	Thread.sleep(4000);
	h.setVendorMenu();
	Thread.sleep(2000);
	fWait.until(ExpectedConditions.visibilityOf(vc.clickvcmanagement()));
	vc.clickvcmanagement().click();
	Thread.sleep(2000);
	vc.CategorySearch().sendKeys(validData);
	
	if(au.verify_Data().size()>0) {
		Assert.assertTrue(au.verifyUser(validData).isDisplayed());
	}else {
		Assert.fail();
	}
	vc.CategorySearch().clear();
	
	vc.CategorySearch().sendKeys(invalidData);
	
	if(au.verify_Data().size()>0) {
		Assert.fail();
	}else {
		Assert.assertTrue(vc.verify_NoDataText().isDisplayed());
	}
	logger.info("Verfied successfully");
	
		
	}
	
	
}