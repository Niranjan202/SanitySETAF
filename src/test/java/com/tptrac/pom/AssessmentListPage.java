package com.tptrac.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AssessmentListPage {



	@FindBy(xpath="//span[contains(text(),' Create New Assessment Calendar')]")
	private WebElement CreateNewSchedule;

	@FindBy(xpath="(//img[@class='d-inline-block align-middle cursor-pointer'])[1]")
	private WebElement PlayButton;

	@FindBy(xpath="//Select[@id='staticEmail']")
	private WebElement statusDropdown;

	@FindBy(xpath="//textarea[@id='comments']")
	private WebElement textComments;

	@FindBy(xpath="//button[contains(text(),'Ok')]")
	private WebElement btnOk;

	@FindBy(xpath="(//div[@class='pl-2 align-self-center'])[3]")
	private WebElement scheduleCount;

	//@FindBy(xpath="//span[contains(text(),'Scheduled')]")
	//List<WebElement> scheduledrecords;

	public AssessmentListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}

		public WebElement getAddNewCalendar() {
			return CreateNewSchedule;
			}
		public WebElement getPlayButton() {
			return PlayButton;
			}
		public WebElement getstatusDropdown() {
			return statusDropdown;
			}
		public void getstatusApprove() {
			// Create object of the Select class
			Select se = new Select(statusDropdown);
			// Select the option by index
			se.selectByIndex(1);
			}
		public WebElement setText() {
			return textComments;
			}
		public void clickOk() {
			btnOk.click();
			}
		public WebElement getScheduleCount() {
			return scheduleCount;
			}
		/*public int getCountScheduled() {
			return scheduledrecords.size();
		}*/
				}