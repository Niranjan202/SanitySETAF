package com.tptrac.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tptrac.generic.BaseClass1;
import com.tptrac.pom.AuditTrailPage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class AuditTrailModule extends BaseClass1{
	
	AuditTrailPage AT1;
	
	@Test(priority=1,testName="Q", enabled= true)
	public void ExportToExcel() throws InterruptedException
	{
		AT1=new AuditTrailPage(driver);
		Thread.sleep(3000);
		AT1.audittrail().click();
		Thread.sleep(3000);
		AT1.exporttoexcel().click();
		Thread.sleep(2000);
	}
	
	@Test(priority=2,testName="Q", enabled=true)
	public void successfailuer() throws InterruptedException
	{
		AT1=new AuditTrailPage(driver);
		Thread.sleep(3000);
		AT1.audittrail().click();
		Thread.sleep(3000);
		AT1.ClickSuccess().click();
		Thread.sleep(2000);
		AT1.exporttoexcel().click();
		Thread.sleep(2000);
		AT1.ClickFailure().click();
		Thread.sleep(2000);
		AT1.exporttoexcel().click();
		Thread.sleep(2000);
		AT1.ResetClick().click();
		Thread.sleep(2000);
		
	}

}
