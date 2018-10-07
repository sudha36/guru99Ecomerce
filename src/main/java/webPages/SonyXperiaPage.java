package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SonyXperiaPage extends TestBase {
	
	 @FindBy(xpath="//textarea[@id='review_field']")
	 WebElement ReviewField;
	 
	 @FindBy(xpath="//input[@id='summary_field']")
	 WebElement SummaryField;
	 
	 @FindBy(xpath="//input[@id='nickname_field']")
	 WebElement NickNameField;
	 
	 @FindBy(xpath="//button[@title='Submit Review']")
	 WebElement SubmitReviewBtn;
	 
	 public SonyXperiaPage(){
			PageFactory.initElements(driver, this);
		}
	 
	 //Fill the required review fileds and then click the submit btn
	 public void Fill_Required_Fields(String ReFields, String SumFields, String NickFields) {
		 ReviewField.sendKeys("ReField");
		 SummaryField.sendKeys("SumFields");
		 NickNameField.sendKeys("NickFields");
		 SubmitReviewBtn.click();
		 
		 
	 }
	 

}
