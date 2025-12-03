

package com.tptrac.generic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.tptrac.pom.HomePage;
import com.tptrac.pom.LoginPage;

public class BaseClass {
	static {        
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

	}
public static WebDriver driver;
public static Logger logger;

@SuppressWarnings("deprecation")

@BeforeSuite
public void deleteDataQueries() {
	JdbcSQLServerConnection jd=new JdbcSQLServerConnection();
	//jd.deleteData();
 }

@BeforeClass
public void openBrowser() throws IOException, InterruptedException {
	Reporter.log("openBrowser",true);
	try
	{
		//WebDriver driver = new ChromeDriver(options);
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        // Set specific Chrome options
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
        options.addArguments("--window-size=1400,600");
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-web-security");
		driver=new ChromeDriver(options);
		System.out.println("successfully opened browser");
		Reporter.log("openBrowser successful");
		
		 //driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	   // Load properties and login
        FileLib f = new FileLib();
        String url = f.getPropertyData("url");
        String un = f.getPropertyData("username");
        String pw = f.getPropertyData("password");
        // get the latest app url
        driver.get(url);

        logger = LogManager.getLogger("TPTrac");
        logger.info("URL opened");
        LoginPage l = new LoginPage(driver);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
        Thread.sleep(2000);
        l.setLogin(un, pw);
		
	}
	catch(Exception e)
	{
		System.out.println("not opened browser");
		Reporter.log("openBrowser failed");
		throw(e);
		}
   
	
	 
	  
	 /*  FileLib f=new FileLib(); 
	  String url = f.getPropertyData("url"); 
	  String un =
	  f.getPropertyData("username"); 
	  String pw = f.getPropertyData("password");
	  driver.get(url); 
	  LoginPage l=new LoginPage(driver); 
	  l.setLogin(un, pw); */
	 

	//for logging

			//logger = LogManager.getLogger("TPTrac");

			//open url

			//logger.info("url opened");
}
@AfterClass
public void teardown() throws InterruptedException {
        Reporter.log("logout and closeBrowser", true);

        // Logout
        HomePage h = new HomePage(driver);
        h.setLogout();

        // Close browser
        driver.close();
    }
	
	
//@BeforeMethod
//public void login() throws IOException, InterruptedException {
	//Reporter.log("login",true);
	//FileLib f=new FileLib();
	//String url = f.getPropertyData("url");
	//String un = f.getPropertyData("username");
	//String pw = f.getPropertyData("password");
	//driver.get(url);
	//LoginPage l=new LoginPage(driver);
	//Thread.sleep(2000);
	//driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
	//Thread.sleep(2000);
	//l.setLogin(un, pw);

	//for logging

			//logger = LogManager.getLogger("TPTrac");

			//open url

			//logger.info("url opened");

//}


//@AfterMethod
//public void logout() throws InterruptedException {
	//Reporter.log("logout",true);
	//HomePage h=new HomePage(driver);
	//h.setLogout();
//}

@AfterSuite
public void sendEmailPost() throws MalformedURLException, EmailException 
{
	sendEmail sm=new sendEmail();
	sm.emailfunction();
}	
	
	public WebDriver getDriver() {
	// TODO Auto-generated method stub
	return driver;
}

//public void waitUntilElementVisible(By webElement,int seconds) {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(webElement));
//}
}


