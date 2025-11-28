package com.tptrac.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
public class UpdateVendorManagement extends BaseClass1 {
	@Test(testName="F",enabled= true)
	public void testUpdateVendor() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("UpdateVendor",true);
		FileLib f=new FileLib();
		//String vendorcode= f.getExcelData("UpdateVendor",1, 3);
		String vendorname1= f.getExcelData("AddVendor",1, 4);
		String vendorname= f.getExcelData("UpdateVendor",3, 4);
		String VendorCategory= f.getExcelData("UpdateVendor",3, 5);
		String VendorType=f.getExcelData("UpdateVendor", 1, 6);
		String VendorAssociationType=f.getExcelData("UpdateVendor", 1, 7);
		String VendorRiskRating=f.getExcelData("UpdateVendor", 1, 8);
		String VendorCriticalityRating=f.getExcelData("UpdateVendor", 1, 9);
		String pname= f.getExcelData("UpdateVendor", 1, 14);
		String pemail = f.getExcelData("UpdateVendor", 1, 15);
		String pcont = f.getExcelData("UpdateVendor", 1, 16);
		String sname = f.getExcelData("UpdateVendor", 1, 17);
		String semail = f.getExcelData("UpdateVendor", 1, 18);
		String scont = f.getExcelData("UpdateVendor", 1, 19);
		HomePage h=new HomePage(driver);
		VendorManagementPage v=new VendorManagementPage(driver);
		Thread.sleep(4000);
	    h.setVendorMenu();
	    Thread.sleep(4000);
	    v.searchUser1().sendKeys(vendorname1);
	   // v.clicknextbutton().click();
	    //Thread.sleep(6000);
	    v.vendoruseredit(f.getExcelData("AddVendor", 1, 4)).click(); //added parameters
	    Thread.sleep(4000);
	    v.vendorcategory(VendorCategory).click();
	    Thread.sleep(4000);
	    
	    v.clickvendorname().clear();
	    v.clickvendorname().sendKeys(vendorname);
	    //Thread.sleep(2000);
	    //v.clickvendorcode().clear();
	    //v.clickvendorcode().sendKeys(vendorcode);
	    Thread.sleep(2000);
	    v.ClickonContact().click();
	    Thread.sleep(2000);
	    v.Editsave().click();
	    Thread.sleep(2000);
    	UsersListPage au=new UsersListPage(driver);
		Thread.sleep(2000);
		v.searchUser1().clear();
		Thread.sleep(2000);
		au.searchUser().sendKeys(vendorname);
		Thread.sleep(2000);
	    String actualText = v.Actualvendorupdated(vendorname).getText(); //added parameters
	    Assert.assertEquals(actualText,vendorname);

	}
	
	@Test(priority=1,testName="F",enabled= true)
	public void searchUpdatedVendor() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("UpdateVendor",true);
		
		HomePage h=new HomePage(driver);
		VendorManagementPage v=new VendorManagementPage(driver);
		Thread.sleep(4000);
	    UsersListPage au=new UsersListPage(driver);
		VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
		
		Thread.sleep(4000);
		
		FileLib f=new FileLib();
		String validData = f.getExcelData("UpdateVendor",3, 4);
		String invalidData = f.getExcelData("UpdateVendor",1, 8);
		
		h.setVendorMenu();
		Thread.sleep(4000);
		
		au.searchUser().sendKeys(validData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.assertTrue(v.verifyUser(validData).isDisplayed());
		}else {
			Assert.fail();
		}
		au.searchUser().clear();
		Thread.sleep(2000);
		au.searchUser().sendKeys(invalidData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.fail();
		}else {
			Assert.assertTrue(vc.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully");
	}

}
