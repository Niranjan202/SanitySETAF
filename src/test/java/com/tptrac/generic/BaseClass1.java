package com.tptrac.generic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.tptrac.pom.HomePage;
import com.tptrac.pom.LoginPage;

public class BaseClass1 {

    static {
        System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
    }

   // public static WebDriver driver;
    public WebDriver driver;
    public static Logger logger;

    @BeforeSuite
    public void deleteDataQueries() {
        JdbcSQLServerConnection jd = new JdbcSQLServerConnection();
         jd.deleteData();
         System.out.println("Existing Record deletion started"); 
    }

    @BeforeClass
    public void setup() throws IOException, InterruptedException {
        Reporter.log("openBrowser and login", true);
        System.out.println("Login Beforeclass");
        // Initialize WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Load properties and login
        FileLib f = new FileLib();
        String url = f.getPropertyData("url");
        String un = f.getPropertyData("username");
        String pw = f.getPropertyData("password");

        driver.get(url);

        logger = LogManager.getLogger("TPTrac");
        logger.info("URL opened");

        LoginPage l = new LoginPage(driver);
        Thread.sleep(2000);
       // driver.findElement(By.xpath("//input[@placeholder='CRN Code']")).sendKeys("CAB03");
        //Thread.sleep(2000);
        l.setLogin(un, pw);
        System.out.println("Login Successful");
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        Reporter.log("logout and closeBrowser", true);

        // Logout
        HomePage h = new HomePage(driver);
        h.setLogout();
        System.out.println("Logout Successful");

        // Close browser
        driver.close();
    }

    @AfterSuite
    public void sendEmailPost() throws MalformedURLException, EmailException {
        sendEmail sm = new sendEmail();
        sm.emailfunction();
    }
    
    public WebDriver getDriver() {
    	// TODO Auto-generated method stub
    	return driver;
    }
}
