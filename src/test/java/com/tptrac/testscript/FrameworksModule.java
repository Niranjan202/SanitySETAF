package com.tptrac.testscript;

import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
import com.tptrac.pom.HomePage;
import com.tptrac.pom.UsersListPage;
import com.tptrac.pom.VendorCategoryManagementPage;
import com.tptrac.pom.VendorManagementPage;
import com.tptrac.pom.FrameworksPage;

@Listeners(com.tptrac.generic.ExtentListener.class)
public class FrameworksModule extends BaseClass1

{
	
	public static FluentWait<WebDriver> fWait;
	
	@Test(testName="A",priority=1,enabled= true)
	public void VerifyFrameworkTab() throws InterruptedException, EncryptedDocumentException, IOException {
		Reporter.log("VerifyFrameworkTab",true);
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
            WebElement tab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Frameworks']")));

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
		public void testAddFrameworkBlankField() throws InterruptedException, EncryptedDocumentException, IOException {
		    Reporter.log("testAddFrameworkBlankField", true);
		    fWait = new FluentWait<WebDriver>(driver)
		            .withTimeout(Duration.ofSeconds(10))
		            .pollingEvery(Duration.ofMillis(2000));

		    HomePage h = new HomePage(driver);
		    FrameworksPage fp=new FrameworksPage(driver);
		    FileLib f = new FileLib();
		    h.setFrameworkMenu();
			Thread.sleep(2000);
		    fp.ClickonNewFramework().click();
		    Thread.sleep(2000);
		    fp.Add().click();
		    Thread.sleep(2000);
		    String namefield = f.getExcelData("AssertMessage", 36, 3);
		    String namefield1 = fp.FrameworkNameField().getText();
		    Assert.assertEquals(namefield1, namefield);
		    Reporter.log("Framework Name Field assertion passed", true);
		    fp.clickancel().click();
			Thread.sleep(2000);
		
	}

	@Test(priority=3,testName="H",enabled= true)
	public void addFramework() throws EncryptedDocumentException, IOException, InterruptedException
	{
	Reporter.log("AddFramework",true);

	HomePage h=new HomePage(driver);
	FrameworksPage fp=new FrameworksPage(driver);
	FileLib f=new FileLib();
	
	String Frameworkname = f.getExcelData("AddFramework",2, 3);
	String Description=f.getExcelData("AddFramework", 1, 4);
	String Hierarchylevel=f.getExcelData("AddFramework", 1, 5);
	Thread.sleep(4000);
	h.setFrameworkMenu();
	Thread.sleep(2000);
    fp.ClickonNewFramework().click();
    Thread.sleep(2000);
    fp.EnteredFrameworkName().sendKeys(Frameworkname);
    Thread.sleep(2000);
	fp.EnteredDescription().sendKeys(Description);
	Thread.sleep(2000);
	fp.SelectHierarchy(Hierarchylevel);
	Thread.sleep(2000);
	fp.Add().click();
	Thread.sleep(3000);
	//UsersListPage au=new UsersListPage(driver);
	//au.searchUser().sendKeys(Frameworkname);
	fp.FrameworkSearch().sendKeys(Frameworkname);
	
	String actualText = fp.GetActualFrameworkCreated(Frameworkname).getText();
	Assert.assertEquals(actualText,Frameworkname);
	Reporter.log("assertTrue",true);
	
	String StatuscodeInitiated = fp.statusCodeInitiated(Frameworkname).getText();
	Assert.assertEquals(StatuscodeInitiated,"Initiated");
	Reporter.log("assertTrueInitiatedstatuscode",true);
	}
	
	@Test(priority=4,testName="H",enabled= true)
	public void UpdateFramework() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("UpdateFramework",true);

		HomePage h=new HomePage(driver);
		FrameworksPage fp=new FrameworksPage(driver);
		FileLib f=new FileLib();
		
		String vendorcategory = f.getExcelData("UpdateFramework",1, 3);
		String comment=f.getExcelData("UpdateFramework", 1, 4);	
		String Frameworkname = f.getExcelData("AddFramework",2, 3);
		Thread.sleep(4000);
		h.setFrameworkMenu();
		UsersListPage au=new UsersListPage(driver);
		au.searchUser().sendKeys(Frameworkname);
		
		boolean elementFound = false;
        while (!elementFound) {
	    try {
	    	fp.GetActualFrameworkCreated(Frameworkname).click(); // click on the element if found
	        elementFound = true; // set the flag to true if element is found
	        fp.GetActualFrameworkCreated(Frameworkname).click(); 
	        Thread.sleep(2000);
	        fp.VendorCategory(vendorcategory).click();
			fp.clickcomment().sendKeys(comment);
			Thread.sleep(2000);
			fp.updatesave().click();
	    }
	    catch (NoSuchElementException e) 
	    {
	    	 fp.ClickNext().click();
	    }
	   }  
        Thread.sleep(2000);
        String frameworkupdate = fp.actualCategoryupdate().getText().trim();
        //String frameworkupdate = fp.actualCategoryupdate().getText();
    	Assert.assertEquals(frameworkupdate,vendorcategory);
    	Reporter.log("assertTrueupdateFramework",true);
	}
	
	@Test(priority=5,testName="H",enabled= true)
	public void VeiwFrameworkList() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("ViewFrameworkList",true);

		HomePage h=new HomePage(driver);
		FrameworksPage fp=new FrameworksPage(driver);
		Thread.sleep(4000);
		h.setFrameworkMenu();
		
	    List<WebElement> list =fp.veiwframeworklist();
	    System.out.println(list.size());
	    for(int i=0;i<list.size();i++)
	    {
	      System.out.println(list.get(i).getText());
	      fp.ClickNext();
	      System.out.println(list.get(i).getText());
	    }
	}
	
	
        
        @Test(priority=6,testName="H",enabled= true)
    	public void AddNodeMeta() throws InterruptedException, EncryptedDocumentException, IOException
   	{ 

    		Reporter.log("AddNodeMeta",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
    		FileLib f=new FileLib();
    		
    		String nodemetacode = f.getExcelData("AddNodeMeta",1, 3);
    		String nodemetacaption=f.getExcelData("AddNodeMeta", 1, 4);
    		String nodemetadescription=f.getExcelData("AddNodeMeta", 1, 5);
    		String Frameworkname = f.getExcelData("AddFramework",2, 3);
    		Thread.sleep(4000);
    		h.setFrameworkMenu();  
    		Thread.sleep(3000);
    		UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
    		boolean elementFound = false;
            while (!elementFound) {
    	    try {
    	     
    	       fp.ClicknodeMeta(Frameworkname).click();// click on the element if found
    	        elementFound = true; // set the flag to true if element is found
    	        Thread.sleep(2000);
    	        fp.AddNodeMeta().click();
    	       
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
    	  } 
            Thread.sleep(2000);
            fp.AddnodeMetaCode().sendKeys(nodemetacode);
	        Thread.sleep(2000);
	        fp.AddnodeMetaCaption().sendKeys(nodemetacaption);
	         Thread.sleep(2000);
	        fp.AddnodeMetaDescription().sendKeys(nodemetadescription);
	      fp.AddnodeMetaSubmit().click();
	      
	      String actualnodemetacodeadd = fp.actualNodemetaadd().getText();
	  	  Assert.assertEquals(actualnodemetacodeadd,nodemetacode);
	  	  Reporter.log("assertTrueactualnodemetadomainadd",true);
	     }
        
        @Test(priority=7,testName="H",enabled= true)
    	public void AddNodeChild() throws InterruptedException, EncryptedDocumentException, IOException
    	{ 

    		Reporter.log("AddNodeChild",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
    		FileLib f=new FileLib();
    		
    		String nodechildcode = f.getExcelData("AddNodeChild",1, 3);
    		String nodechildcaption=f.getExcelData("AddNodeChild", 1, 4);
    		String nodechilddescription=f.getExcelData("AddNodeChild", 1, 5);
    		String Frameworkname = f.getExcelData("AddFramework",2, 3);
    		Thread.sleep(4000);
    		h.setFrameworkMenu();  
    		Thread.sleep(3000);
    		UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
    		boolean elementFound = false;
            while (!elementFound) {
    	    try {
    	     
    	       fp.ClicknodeMeta(Frameworkname).click();// click on the element if found
    	        elementFound = true; // set the flag to true if element is found
    	        fp.AddNodechild().click();
    	        
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
    	  }
            Thread.sleep(5000);

            fp.AddNodechildcode().sendKeys(nodechildcode);
            Thread.sleep(5000);
            fp.AddNodechildcaption().sendKeys(nodechildcaption);
            Thread.sleep(5000);
           
            fp.AddNodechilddescription().sendKeys(nodechilddescription);
            Thread.sleep(2000);
            fp.addChildsave().click();
            
            String actualnodemetacodeadd= fp.actualNodemetaadd1().getText();
  	  	  Assert.assertEquals(actualnodemetacodeadd,nodechildcode);
  	  	  Reporter.log("assertTrueactualnodemetacontroladd",true);
    	}    
        
        @Test(priority= 8,testName="H",enabled= true)
    	public void UpdateNodemeta() throws InterruptedException, EncryptedDocumentException, IOException
    	{ 

    		Reporter.log("UpdateNode",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
    		FileLib f=new FileLib();
    		
    		String domainupdatecode = f.getExcelData("UpdateNode",1, 3);
    		String domainupdatedescription=f.getExcelData("UpdateNode", 1, 4);
    		String domainupdatecaption=f.getExcelData("UpdateNode", 1, 5);
    		String controlupdatecode = f.getExcelData("UpdateNode",2, 3);
    		String controlupdatedescription=f.getExcelData("UpdateNode", 2, 4);
    		String controlupdatecaption=f.getExcelData("UpdateNode", 2, 5);
    		String Frameworkname = f.getExcelData("AddFramework",2, 3);
    		Thread.sleep(4000);
    		h.setFrameworkMenu();  
    		Thread.sleep(3000);
    		UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
    		boolean elementFound = false;
            while (!elementFound) {
    	    try {
    	     
    	       fp.ClicknodeMeta(Frameworkname).click();// click on the element if found
    	        elementFound = true; // set the flag to true if element is found
    	  
    	        
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
    	  }
            Thread.sleep(2000);
            fp.updateDomaincode().click();
            Thread.sleep(2000);
            fp.Updatecode().clear();
            Thread.sleep(2000);
            fp.Updatecode().sendKeys(domainupdatecode);
            Thread.sleep(2000);
            fp.Updatedescription().clear();
            Thread.sleep(2000);
            fp.Updatedescription().sendKeys(domainupdatedescription);
            Thread.sleep(2000);
            fp.UpdateCation().clear();
            Thread.sleep(2000);
            fp.UpdateCation().sendKeys(domainupdatecaption);
            Thread.sleep(2000);
            fp.updatesave().click();
            Thread.sleep(2000);
            String actualnodemetacodeadd= fp.actualNodemetaupdate().getText();
  	  	    Assert.assertEquals(actualnodemetacodeadd,domainupdatecode);
  	  	    Reporter.log("assertTrueactualnodemetadomainupdate",true);
            
 	  	    Thread.sleep(2000);
            fp.updateControlcode().click();
            Thread.sleep(2000);
            fp.Updatecode().clear();
            Thread.sleep(2000);
            fp.Updatecode().sendKeys(controlupdatecode);
            Thread.sleep(2000);
            fp.Updatedescription().clear();
            Thread.sleep(2000);
            fp.Updatedescription().sendKeys(controlupdatedescription);
            Thread.sleep(2000);
            fp.UpdateCation().clear();
            Thread.sleep(2000);
            fp.UpdateCation().sendKeys(controlupdatecaption);
            Thread.sleep(2000);
            fp.updatesave().click();
            Thread.sleep(2000);
            String actualnodemetacodeadd1= fp.actualNodemetaupdate1().getText();
  	  	    Assert.assertEquals(actualnodemetacodeadd1,controlupdatecode);
  	  	    Reporter.log("assertTrueactualnodemetacontrolupdate",true);
    	}
        
        
        @Test(priority= 9,testName="H",enabled= true)
    	public void AddNodeData() throws InterruptedException, EncryptedDocumentException, IOException
    	{ 

    		Reporter.log("AddNodeData",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
    		FileLib f=new FileLib();
        
    		String nodedatacaption = f.getExcelData("AddNodeData",1, 3);
    		String nodedatacode=f.getExcelData("AddNodeData", 1, 4);
    		String nodedataweightage=f.getExcelData("AddNodeData", 1, 5);
    		String nodedatadescription = f.getExcelData("AddNodeData",1, 6);
    		String Frameworkname = f.getExcelData("AddFramework",2, 3);  	
    		Thread.sleep(4000);
            h.setFrameworkMenu();  
            Thread.sleep(3000);
            UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
    		boolean elementFound = false;
           while (!elementFound) {
    	    try {
    	     
    	       fp.addNodedata(Frameworkname).click();// click on the element if found
    	        elementFound = true; // set the flag to true if element is found
    	  
    	        
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
    	  }
            fp.addNodedataDomain().click();
            Thread.sleep(3000);
            fp.nodeDatacaption().sendKeys(nodedatacaption);
          //  String code=nodedatacode.substring(1, 4);
           // fp.nodeDatacode().sendKeys(code);
            String weightage=nodedataweightage.substring(1, 3);
            Thread.sleep(3000);
            fp.nodeDataweightage().sendKeys(weightage);
            Thread.sleep(2000);
            fp.nodeDatadescription().sendKeys(nodedatadescription);
            Thread.sleep(2000);
            fp.nodeDatasave().click();
            String actualnodedatacaptionadd1= fp.actualNodedataadd1().getText();
  	  	    Assert.assertEquals(actualnodedatacaptionadd1,nodedatacaption);
  	  	    Reporter.log("assertTrueactualnodedatacreated1",true);
           
            String nodedatacaption1 = f.getExcelData("AddNodeData",2, 3);
    		//String nodedatacode1=f.getExcelData("AddNodeData", 2, 4);
    		String nodedataweightage1=f.getExcelData("AddNodeData", 2, 5);
    		String nodedatadescription1 = f.getExcelData("AddNodeData",2, 6);
    		
    		Thread.sleep(2000);
    		fp.addNodedataDomain().click();
            Thread.sleep(3000);
            fp.nodeDatacaption().sendKeys(nodedatacaption1);
          //  String code1=nodedatacode1.substring(1, 4);
           // fp.nodeDatacode().sendKeys(code1);
            Thread.sleep(3000);
            String weightage1=nodedataweightage1.substring(1, 3);
            fp.nodeDataweightage().sendKeys(weightage1);
            Thread.sleep(2000);
            fp.nodeDatadescription().sendKeys(nodedatadescription1);
            Thread.sleep(2000);
            fp.nodeDatasave().click();
            String actualnodedatacaptionadd2= fp.actualNodedataadd2().getText();
  	  	    Assert.assertEquals(actualnodedatacaptionadd2,nodedatacaption1);
  	  	    Reporter.log("assertTrueactualnodedatacreated2",true);
    	}
        
        @Test(priority=10,testName="H",enabled= true)
        public void UpdateNodeData() throws EncryptedDocumentException, IOException, InterruptedException
       {
        	Reporter.log("Add" + "NodeData",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
    		FileLib f=new FileLib();
   		
    		String nodedataweightageedit=f.getExcelData("AddNodeData", 3, 5);
    		String nodedataweightageedit2=f.getExcelData("AddNodeData", 5, 5);
    		  	
    		String nodedatacaption = f.getExcelData("AddNodeData",4, 3);
    		String nodedatacode=f.getExcelData("AddNodeData", 4, 4);
    		String nodedataweightage=f.getExcelData("AddNodeData", 4, 5);
    		String nodedatadescription = f.getExcelData("AddNodeData",4, 6);
    		String Frameworkname = f.getExcelData("AddFramework",2, 3);
    		Thread.sleep(4000);
            h.setFrameworkMenu();  
            Thread.sleep(3000);
            UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
    		boolean elementFound = false;
            while (!elementFound) {
    	    try {
    	     
    	       fp.addNodedata(Frameworkname).click();// click on the element if found
    	        elementFound = true; // set the flag to true if element is found
    	  
    	        
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
    	  }
            Thread.sleep(3000);
            fp.nodeDataedit().click();
            Thread.sleep(3000);
            String weightage=nodedataweightageedit.substring(1, 3);
            fp.updateWeightageNodedata().clear();
            Thread.sleep(2000);
            fp.updateWeightageNodedata().sendKeys(weightage);
            Thread.sleep(2000);
            fp.editSavenodedata().click();
            Thread.sleep(3000);
            
            fp.addNodedataDomain().click();
            Thread.sleep(3000);
            fp.nodeDatacaption().sendKeys(nodedatacaption);
            Thread.sleep(3000);
            String weightage1=nodedataweightage.substring(1, 3);
            fp.nodeDataweightage().sendKeys(weightage1);
            fp.nodeDatadescription().sendKeys(nodedatadescription);
            fp.nodeDatasave().click();
            
            Thread.sleep(2000);
            fp.deleteNodedata().click();
            Thread.sleep(3000);
            fp.deleteyesnodedata().click();
            
            Thread.sleep(3000);
            fp.nodeDataedit().click();
            Thread.sleep(3000);
            fp.updateWeightageNodedata().clear();
            String weightage2=nodedataweightageedit2.substring(1, 3);
            fp.updateWeightageNodedata().sendKeys(weightage2);
            fp.editSavenodedata().click();
            String updateweightage= fp.actualweightageupdated().getText();
  	  	    Assert.assertEquals(updateweightage,"50");
 	  	    Reporter.log("assertTrueactualupdated",true);
            
        }
      
        @Test(priority= 11,testName="H",enabled= true)
    	public void AddNodeDataControl() throws InterruptedException, EncryptedDocumentException, IOException
    	{ 

    		Reporter.log("AddNodeDataControl",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
    		
    		FileLib f=new FileLib();
    		String Frameworkname = f.getExcelData("AddFramework",2, 3);
    		Thread.sleep(4000);
            h.setFrameworkMenu(); 
            Thread.sleep(3000);
            UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
      
    		boolean elementFound = false;
            while (!elementFound) {
    	    try {
    	     
    	       fp.addNodedata(Frameworkname).click();// click on the element if found
    	        elementFound = true; // set the flag to true if element is found
    	  
    	        
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
    	  }
//            FileLib f=new FileLib();
            
            String nodedatacontrolcaption = f.getExcelData("AddNodeDataControl",1, 3);
    		String nodedatacontrolcode=f.getExcelData("AddNodeDataControl", 1, 4);
    		String nodedatacontrolweightage=f.getExcelData("AddNodeDataControl", 1, 5);
    		String nodedatacontroldescription = f.getExcelData("AddNodeDataControl",1, 6);
    		
    		
          //add control
            Thread.sleep(2000);

            fp.adddDomaincontrol().click();
            Thread.sleep(2000);
            fp.addControl1caption().sendKeys(nodedatacontrolcaption);
            String code1=nodedatacontrolcode.substring(1, 3);
            fp.addControl1Code().sendKeys(code1);
            String weightage1=nodedatacontrolweightage.substring(1, 3);
            Thread.sleep(3000);
            fp.addControl1Weightage().sendKeys(weightage1);
            Thread.sleep(2000);
            fp.addControl1Description().sendKeys(nodedatacontroldescription);
            Thread.sleep(2000);
            fp.addControl1Save().click();
            
            String nodedatacontrolcaption1 = f.getExcelData("AddNodeDataControl",2, 3);
    		String nodedatacontrolcode1=f.getExcelData("AddNodeDataControl", 2, 4);
    		String nodedatacontrolweightage1=f.getExcelData("AddNodeDataControl", 2, 5);
     		String nodedatacontroldescription1 = f.getExcelData("AddNodeDataControl",2, 6);
            
          //add control2
            Thread.sleep(2000);
            fp.adddDomaincontrol().click();
            Thread.sleep(2000);
            fp.addControl1caption().sendKeys(nodedatacontrolcaption1);
            Thread.sleep(2000);
            String code2=nodedatacontrolcode1.substring(1, 3);
            fp.addControl1Code().sendKeys(code2);
            Thread.sleep(3000);
            String weightage2=nodedatacontrolweightage1.substring(1, 3);
            fp.addControl1Weightage().sendKeys(weightage2);
            fp.addControl1Description().sendKeys(nodedatacontroldescription1);
            fp.addControl1Save().click();
            
	
     		
     		String nodedatacontrolcaption2 = f.getExcelData("AddNodeDataControl",3, 3);
    		String nodedatacontrolcode2=f.getExcelData("AddNodeDataControl", 3, 4);
    		String nodedatacontrolweightage2=f.getExcelData("AddNodeDataControl", 3, 5);
     		String nodedatacontroldescription2 = f.getExcelData("AddNodeDataControl",3, 6);
            
           // add control 1 for domain2
            Thread.sleep(2000);
            fp.addDomaincontrol1().click();
            fp.addControl1caption().sendKeys(nodedatacontrolcaption2);
            String code3=nodedatacontrolcode2.substring(1, 3);
            fp.addControl1Code().sendKeys(code3);
            Thread.sleep(3000);
            String weightage3=nodedatacontrolweightage2.substring(1, 3);
            fp.addControl1Weightage().sendKeys(weightage3);
            Thread.sleep(2000);
            fp.addControl1Description().sendKeys(nodedatacontroldescription2);
            Thread.sleep(2000);
            fp.addControl1Save().click();
            
	
     		
     		String nodedatacontrolcaption3 = f.getExcelData("AddNodeDataControl",4, 3);
    		String nodedatacontrolcode3=f.getExcelData("AddNodeDataControl", 4, 4);
    		String nodedatacontrolweightage3=f.getExcelData("AddNodeDataControl", 4, 5);
     		String nodedatacontroldescription3 = f.getExcelData("AddNodeDataControl",4, 6);
            
            //add control 2 for domain2
            Thread.sleep(2000);
            fp.addDomaincontrol1().click();
            fp.addControl1caption().sendKeys(nodedatacontrolcaption3);
            String code4=nodedatacontrolcode3.substring(1, 3);
            fp.addControl1Code().sendKeys(code4);
            Thread.sleep(3000);
            String weightage4=nodedatacontrolweightage3.substring(1, 3);
            fp.addControl1Weightage().sendKeys(weightage4);
            fp.addControl1Description().sendKeys(nodedatacontroldescription3);
            Thread.sleep(2000);
            fp.addControl1Save().click();
            
            //submit
            Thread.sleep(2000);
            fp.NodeDatasubmit().click();
    		 Thread.sleep(2000);
             fp.nodeDataclickback().click();
            Thread.sleep(2000);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
            String StatuscodeSubmitted = fp.statusCodeSubmitted(Frameworkname).getText();
        	Assert.assertEquals(StatuscodeSubmitted,"Submitted");
        	Reporter.log("assertTrueSumittedstatuscode",true);
    	}
        
        
        
        
        @Test(priority= 12,testName="H",enabled= false)
    	public void SendbackFramework() throws InterruptedException, EncryptedDocumentException, IOException
    	{ 

    		Reporter.log("AddNodeDataControl",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
    		
    		FileLib f=new FileLib();
    		String Frameworkname = f.getExcelData("AddFramework",2, 3);
    		Thread.sleep(4000);		
            h.setFrameworkMenu();  
            Thread.sleep(3000);
            UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
    		boolean elementFound = false;
            while (!elementFound) {
    	    try {
    	     
    	       fp.approveNotification(Frameworkname).click();// click on the element if found
    	        elementFound = true; // set the flag to true if element is found
    	  
    	        
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
    	
          }
            Thread.sleep(4000);
            fp.NodeDatasendback().click();
            Thread.sleep(2000);
            fp.sendBackcomment().sendKeys("comment");
            Thread.sleep(2000);
            fp.clickSendBack().click();
            Thread.sleep(4000);
            fp.notificationClickback().click();
            Thread.sleep(4000);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
            String StatuscodeModification = fp.statusCodeModification(Frameworkname).getText();
        	Assert.assertEquals(StatuscodeModification,"Modification");
        	Reporter.log("assertTrueModificationstatuscode",true);
            }
        
        @Test(priority=13,testName="H",enabled= false)
    	public void verificationofweightage() throws InterruptedException, EncryptedDocumentException, IOException
    	{ 

    		Reporter.log("AddNodeDataControl",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
    		
    		FileLib f=new FileLib();
    		String Frameworkname = f.getExcelData("AddFramework",2, 3);
    		Thread.sleep(3000);
            h.setFrameworkMenu();  
            Thread.sleep(3000);
            UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
    		boolean elementFound = false;
            while (!elementFound) {
    	    try {
    	     
    	       fp.addNodedata(Frameworkname).click();// click on the element if found
    	        elementFound = true; // set the flag to true if element is found
    	  
    	        
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
    	  }
 //           FileLib f=new FileLib();
            
            String nodedatacontrolcaption = f.getExcelData("AddNodeDataControl",5, 3);
    		String nodedatacontrolcode=f.getExcelData("AddNodeDataControl", 5, 4);
    		String nodedatacontrolweightage=f.getExcelData("AddNodeDataControl", 5, 5);
    		String nodedatacontroldescription = f.getExcelData("AddNodeDataControl",5, 6);
    		
    		
          //add control
            Thread.sleep(2000);

            fp.adddDomaincontrol().click();
            Thread.sleep(2000);
            fp.addControl1caption().sendKeys(nodedatacontrolcaption);
            String code1=nodedatacontrolcode.substring(1, 3);
            Thread.sleep(2000);
            fp.addControl1Code().sendKeys(code1);
            String weightage1=nodedatacontrolweightage.substring(1, 3);
            Thread.sleep(3000);
            fp.addControl1Weightage().sendKeys(weightage1);
            Thread.sleep(2000);
            fp.addControl1Description().sendKeys(nodedatacontroldescription);
            fp.addControl1Save().click();
            Assert.assertTrue(fp.warningMessage().isDisplayed());
            fp.closeAddCaptionPopup().click();
            Thread.sleep(2000);
            fp.nodeDataclickback().click();
           // fp.notificationClickback().click();
            Thread.sleep(2000);
    	}
        
        
        @Test(priority=14,testName="H",enabled= false)
    	public void ModificationNodeData() throws InterruptedException, EncryptedDocumentException, IOException
    	{ 

    		Reporter.log("ModificationNodeData",true);

    		HomePage h=new HomePage(driver);
    		FrameworksPage fp=new FrameworksPage(driver);
            FileLib f=new FileLib();
            String Frameworkname = f.getExcelData("AddFramework",2, 3);
            String nodedatacaption = f.getExcelData("AddNodeData",1, 3);
            String nodedatacaption1 = f.getExcelData("AddNodeData",2, 3);
            String nodedatacontrolcaption1 = f.getExcelData("AddNodeDataControl",1, 3);
            String nodedatacontrolcaption2 = f.getExcelData("AddNodeDataControl",2, 3);
            String nodedatacontrolcaption3 = f.getExcelData("AddNodeDataControl",3, 3);
            String nodedatacontrolcaption4 = f.getExcelData("AddNodeDataControl",4, 3);
            Thread.sleep(3000);
            h.setFrameworkMenu();  
            Thread.sleep(3000);
            UsersListPage au=new UsersListPage(driver);
    		au.searchUser().sendKeys(Frameworkname);
    		Thread.sleep(3000);
    		boolean elementFound = false;
            while (!elementFound) {
    	    try {
    	    
 //   	    fp.approveNotification(Frameworkname).click();// click on the element if found
    	    	fp.addNodedata(Frameworkname).click();
    	        elementFound = true; // set the flag to true if element is found
    	  
    	        
    	    }
    	    catch (NoSuchElementException e) 
    	    {
    	    	 fp.ClickNext().click();
    	    }
            }
            
          String editdomaincode1 = f.getExcelData("ModificationNodeData",1, 3);
    	  String editdomainweightage1=f.getExcelData("ModificationNodeData", 1, 4);
    	  String editdomaindescription1=f.getExcelData("ModificationNodeData", 1, 5);
    	  
    	  Thread.sleep(2000);
          fp.clickNodedatadomainedit().click();
          Thread.sleep(2000);
          String code1=editdomaincode1.substring(1, 4);
          fp.editnodedatacodeedit().clear();
          fp.editnodedatacodeedit().sendKeys(code1);
          Thread.sleep(2000);
          String weightage1=editdomainweightage1.substring(1, 3);
          fp.editnodedataweightageedit().clear();
          fp.editnodedataweightageedit().sendKeys(weightage1);;
          Thread.sleep(2000);
          fp.editNodedatadescriptionedit().clear();
          fp.editNodedatadescriptionedit().sendKeys(editdomaindescription1);
//          fp.editNodedatacaptionedit().sendKeys();
//          fp.editnodedataquestionedit().sendKeys();
          Thread.sleep(2000);
          fp.clickNodeDatasaveedit().click();
          
          
          String editcontrolcode2 = f.getExcelData("ModificationNodeData",2, 3);
    	  String editcontrolweightage2=f.getExcelData("ModificationNodeData", 2, 4);
    	  String editcontroldescription2=f.getExcelData("ModificationNodeData", 2, 5);
          
          Thread.sleep(4000);
//          fp.clickPlusbutton1(nodedatacaption).click();
          JavascriptExecutor executor = (JavascriptExecutor) driver;
		   executor.executeScript("arguments[0].click();", fp.clickPlusbutton1(nodedatacaption));
          Thread.sleep(2000);
          fp.clickNodedatacontrol1edit(nodedatacontrolcaption1).click();
          Thread.sleep(2000);
          String code2=editcontrolcode2.substring(1, 6);
          fp.editnodedatacodeedit().clear();
          fp.editnodedatacodeedit().sendKeys(code2);
          Thread.sleep(2000);
          String weightage2=editcontrolweightage2.substring(1, 3);
          fp.editnodedataweightageedit().clear();
          fp.editnodedataweightageedit().sendKeys(weightage2);
          Thread.sleep(2000);
          fp.editNodedatadescriptionedit().clear();
          fp.editNodedatadescriptionedit().sendKeys(editcontroldescription2);
//          fp.editNodedatacaptionedit().sendKeys();
//          fp.editnodedataquestionedit().sendKeys();
          Thread.sleep(2000);
          fp.clickNodeDatasaveedit().click();
          
          String editcontrolcode3 = f.getExcelData("ModificationNodeData",3, 3);
    	  String editcontrolweightage3=f.getExcelData("ModificationNodeData", 3, 4);
    	  String editcontroldescription3=f.getExcelData("ModificationNodeData", 3, 5);
          
          Thread.sleep(4000);
//          fp.clickPlusbutton1(nodedatacaption1).click();
          executor.executeScript("arguments[0].click();", fp.clickPlusbutton1(nodedatacaption));
          Thread.sleep(2000);
          fp.clickNodedatacontrol2edit(nodedatacontrolcaption2).click();
          Thread.sleep(2000);
          String code3=editcontrolcode3.substring(1, 6);
          fp.editnodedatacodeedit().clear();
          fp.editnodedatacodeedit().sendKeys(code3);
          Thread.sleep(2000);
          String weightage3=editcontrolweightage3.substring(1, 3);
          fp.editnodedataweightageedit().clear();
          fp.editnodedataweightageedit().sendKeys(weightage3);
          Thread.sleep(2000);
          fp.editNodedatadescriptionedit().clear();
          fp.editNodedatadescriptionedit().sendKeys(editcontroldescription3);
//          fp.editNodedatacaptionedit().sendKeys();
//          fp.editnodedataquestionedit().sendKeys();
          Thread.sleep(2000);
          fp.clickNodeDatasaveedit().click();
          
          String editdomaincode4 = f.getExcelData("ModificationNodeData",4, 3);
    	  String editdomainweightage4=f.getExcelData("ModificationNodeData", 4, 4);
    	  String editdomaindescription4=f.getExcelData("ModificationNodeData", 4, 5);
          
    	  Thread.sleep(4000);
          fp.clickNodedatadomain2edit().click();
          Thread.sleep(2000);
          String code4=editdomaincode4.substring(1, 4);
          fp.editnodedatacodeedit().clear();
          fp.editnodedatacodeedit().sendKeys(code4);
          Thread.sleep(2000);
          String weightage4=editdomainweightage4.substring(1, 3);
          fp.editnodedataweightageedit().clear();
          fp.editnodedataweightageedit().sendKeys(weightage4);
          Thread.sleep(2000);
          fp.editNodedatadescriptionedit().clear();
          fp.editNodedatadescriptionedit().sendKeys(editdomaindescription4);
//          fp.editNodedatacaptionedit().sendKeys();
//          fp.editnodedataquestionedit().sendKeys();
          Thread.sleep(2000);
          fp.clickNodeDatasaveedit().click();
          
          String editcontrolcode5 = f.getExcelData("ModificationNodeData",5, 3);
    	  String editcontrolweightage5=f.getExcelData("ModificationNodeData", 5, 4);
    	  String editcontroldescription5=f.getExcelData("ModificationNodeData", 5, 5);
          
    	  Thread.sleep(4000);
 //         fp.clickPlusbutton2().click();
          executor.executeScript("arguments[0].click();", fp.clickPlusbutton1(nodedatacaption1));
          Thread.sleep(4000);
          fp.clickNodedatacontrol3edit(nodedatacontrolcaption3).click();
          String code5=editcontrolcode5.substring(1, 6);
          Thread.sleep(2000);
          fp.editnodedatacodeedit().clear();
          Thread.sleep(2000);
          fp.editnodedatacodeedit().sendKeys(code5);
          Thread.sleep(4000);
          String weightage5=editcontrolweightage5.substring(1, 3);
          fp.editnodedataweightageedit().clear();
          fp.editnodedataweightageedit().sendKeys(weightage5);
          Thread.sleep(2000);
          fp.editNodedatadescriptionedit().clear();
          fp.editNodedatadescriptionedit().sendKeys(editcontroldescription5);
//          fp.editNodedatacaptionedit().sendKeys();
//          fp.editnodedataquestionedit().sendKeys();
          Thread.sleep(2000);
          fp.clickNodeDatasaveedit().click();
          
          String editcontrolcode6 = f.getExcelData("ModificationNodeData",6, 3);
    	  String editcontrolweightage6=f.getExcelData("ModificationNodeData", 6, 4);
    	  String editcontroldescription6=f.getExcelData("ModificationNodeData", 6, 5);
          
    	  Thread.sleep(4000);
 //         fp.clickPlusbutton2().click();
          executor.executeScript("arguments[0].click();", fp.clickPlusbutton1(nodedatacaption1));
          Thread.sleep(2000);
          fp.clickNodedatacontrol3edit(nodedatacontrolcaption4).click();
          Thread.sleep(2000);
          String code6=editcontrolcode6.substring(1, 6);
          fp.editnodedatacodeedit().clear();
          fp.editnodedatacodeedit().sendKeys(code6);
          Thread.sleep(2000);
          String weightage6=editcontrolweightage6.substring(1, 3);
          fp.editnodedataweightageedit().clear();
          fp.editnodedataweightageedit().sendKeys(weightage6);
          Thread.sleep(2000);
          fp.editNodedatadescriptionedit().clear();
          fp.editNodedatadescriptionedit().sendKeys(editcontroldescription6);
//          fp.editNodedatacaptionedit().sendKeys();
//          fp.editnodedataquestionedit().sendKeys();
          fp.clickNodeDatasaveedit().click();
          
          Thread.sleep(2000);
          fp.nodeDataclickback().click();
          //fp.notificationClickback().click();
          Thread.sleep(2000);
          au.searchUser().sendKeys(Frameworkname);
  			Thread.sleep(3000);
          fp.addNodedata(Frameworkname).click();
          Thread.sleep(3000);
          fp.NodeDatasubmit().click();
          
          Thread.sleep(2000);
          fp.nodeDataclickback().click();
          Thread.sleep(2000);
  		au.searchUser().sendKeys(Frameworkname);
  		Thread.sleep(3000);
          //fp.nodeDataclickback().click();
          Thread.sleep(2000);
          fp.approveNotification(Frameworkname).click();
          Thread.sleep(2000);
          fp.NodeDataApprove().click();
          Thread.sleep(2000);
          fp.approveComment().sendKeys("approve");
          Thread.sleep(2000);
          fp.approveSend().click();
            Thread.sleep(2000);
          fp.notificationClickback().click();
          Thread.sleep(2000);	
          au.searchUser().sendKeys(Frameworkname);
  			Thread.sleep(3000);
          String StatuscodeApproved = fp.statusCodeApproved(Frameworkname).getText();
      	  Assert.assertEquals(StatuscodeApproved,"Approved");
      	  Reporter.log("assertTrueApprovestatuscode",true);
       
       }
         
        
        
        @Test(priority=15,testName="H",enabled= false)
      	public void AddandDeleteFramework() throws InterruptedException, EncryptedDocumentException, IOException
      	{ 

          	Reporter.log("DeleteFramework",true);

       		HomePage h=new HomePage(driver);
       		FrameworksPage fp=new FrameworksPage(driver);
       		FileLib f=new FileLib();
       		
       		String Frameworkname1 = f.getExcelData("AddFramework",3, 3);
       		String Description1=f.getExcelData("AddFramework", 2, 4);
       		String Hierarchylevel1=f.getExcelData("AddFramework", 2, 5);
       		Thread.sleep(3000);
       		h.setFrameworkMenu();
       		Thread.sleep(3000);
       	
       		fp.ClickonNewFramework().click();
       		 Thread.sleep(2000);
       	    fp.EnteredFrameworkName().sendKeys(Frameworkname1);
       	    Thread.sleep(2000);
       		fp.EnteredDescription().sendKeys(Description1);
       		 Thread.sleep(2000);
       		fp.SelectHierarchy(Hierarchylevel1);
       		 Thread.sleep(2000);
       		fp.Add().click();
       	    Thread.sleep(2000);
       	    UsersListPage au=new UsersListPage(driver);
       	    au.searchUser().sendKeys(Frameworkname1);
       	    Thread.sleep(3000);
       		String actualText = fp.GetActualFrameworkCreated1(Frameworkname1).getText();
       		Assert.assertEquals(actualText,Frameworkname1);
       		Reporter.log("assertTrue",true);
       		Thread.sleep(4000);
       		fp.clickDelete(Frameworkname1).click();
       		Thread.sleep(4000);
       		fp.YesDelete1().click();
 //   		Assert.assertTrue(fp.verifyDeleteMsg().isDisplayed(),"Framework deleted successfully");	
       		Thread.sleep(2000);
       		fp.verifyframework(Frameworkname1);
       		Reporter.log("assertTrueInitiatedstatuscode",true);
      	
    }
        
        @Test(priority=16,testName="H",enabled= false)
    	public void searchFramework() throws EncryptedDocumentException, IOException, InterruptedException
    	{
    	Reporter.log("searchFramework",true);

    	HomePage h=new HomePage(driver);
    	FrameworksPage fp=new FrameworksPage(driver);
    	VendorManagementPage v=new VendorManagementPage(driver);
	    UsersListPage au=new UsersListPage(driver);
		VendorCategoryManagementPage vc=new VendorCategoryManagementPage(driver);
		Thread.sleep(4000);
		
    	FileLib f=new FileLib();
    	
    	String validData = f.getExcelData("AddFramework",2, 3);
		String invalidData = f.getExcelData("AddFramework",1, 0);
		Thread.sleep(3000);
    	h.setFrameworkMenu();
    	Thread.sleep(2000);
    	au.searchUser().sendKeys(validData);
		Thread.sleep(2000);
		if(au.verify_Data().size()>0) {
			Assert.assertTrue(fp.verifyFramework(validData).isDisplayed());
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
			Assert.assertTrue(au.verify_NoDataText().isDisplayed());
		}
		logger.info("Verfied successfully");
    	}
           
}
