package com.tptrac.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
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

@Listeners(com.tptrac.generic.ExtentListener.class)
public class DeleteVendorCategory extends BaseClass1{
	
	public static FluentWait<WebDriver> fWait;
	
	@Test(testName="D")
	public void deleteVendorCategory() throws InterruptedException, EncryptedDocumentException, IOException {

	Reporter.log("DeleteVendorCategory",true);
	fWait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofMillis(2000))
			.ignoring(NoSuchElementException.class, TimeoutException.class);
	
	FileLib f=new FileLib();
	String vendorcategoryname= f.getExcelData("UpdateVendorCategory",1, 3);
	String vendorcategorycode= f.getExcelData("UpdateVendorCategory",1, 4);
	HomePage h=new HomePage(driver);
	VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
	UsersListPage u=new UsersListPage(driver);
	Thread.sleep(4000);
    h.setVendorMenu();
    logger.info("Click on vendor menu");
    Thread.sleep(4000);
    fWait.until(ExpectedConditions.visibilityOf(vc.clickvcmanagement()));
    vc.clickvcmanagement().click();
    Thread.sleep(2000);
    logger.info("Click on vendor category management ");
    vc.CategorySearch().sendKeys(vendorcategoryname);
    Thread.sleep(2000);
    //vc.rowselected1().click();
    //vc.Vdelete(vendorcategoryname).click(); //added parameters
    vc.selectdelete().click();
    Thread.sleep(2000);
   // fWait.until(ExpectedConditions.visibilityOf(vc.cdelete()));
    vc.cdelete().click();
    Thread.sleep(2000);
    vc.verifyCategory(vendorcategorycode);
}
}