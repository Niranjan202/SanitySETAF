package com.tptrac.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssessmentCalendarPage {
	
WebDriver driver;
	
	public AssessmentCalendarPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath="//a[normalize-space()='Assessment']")
	private WebElement ClickAssessment;
	
	public WebElement ClickAssessment()
	{
		return ClickAssessment;
	}
	
	@FindBy(xpath="//td[normalize-space()='Assessment Calendar']")
	private WebElement AssessmentCalendarMenu;
	
	public WebElement AssessmentCalendarMenu()
	{
		return AssessmentCalendarMenu;
	}
	
	@FindBy(xpath="//span[contains(text(),'Create New Assessment Calendar')]")
	private WebElement CreateNewAssessment;
	
	public WebElement CreateNewAssessment()
	{
		return CreateNewAssessment;
	}
	

}


