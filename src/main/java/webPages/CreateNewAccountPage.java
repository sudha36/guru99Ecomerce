package webPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class CreateNewAccountPage extends TestBase{
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement FirstNameTextBox;
		
	@FindBy(xpath="//input[@id='middlename']")
	WebElement MiddleNameTextBox;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement LastNameTextBox;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement EmailAddressTextBox;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement PassWordTextBox;
	
	@FindBy(xpath="//input[@id='confirmation']")
	WebElement ConfirmPwdTextBox;
	
	@FindBy(xpath="//button[@title='Register']")
	WebElement CreateNewAccountRegisterBtn;
	
	public CreateNewAccountPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	//Creating a account 
	public MyAccountPage FillAcctDetails(String FirstName, String MiddleName, String LastName, String EmailAddress, String PassWord, String ConfirmPwd) {
		FirstNameTextBox.sendKeys(FirstName);
		FirstNameTextBox.sendKeys(Keys.ENTER);
		MiddleNameTextBox.sendKeys(MiddleName);
		MiddleNameTextBox.sendKeys(Keys.ENTER);
		LastNameTextBox.sendKeys(LastName);
		LastNameTextBox.sendKeys(Keys.ENTER);
		EmailAddressTextBox.sendKeys(EmailAddress);
		EmailAddressTextBox.sendKeys(Keys.ENTER);
		PassWordTextBox.sendKeys(PassWord);
		PassWordTextBox.sendKeys(Keys.ENTER);
		ConfirmPwdTextBox.sendKeys(ConfirmPwd);
		ConfirmPwdTextBox.sendKeys(Keys.ENTER);
		CreateNewAccountRegisterBtn.click();
		return new MyAccountPage();
	}
	
	//Click RegisterBtn in CreateNewAccountPage and it goes to HomePage
	
	/*public HomePage ClickCreateNewAccountRegisterBtn() {
		CreateNewAccountRegisterBtn.click();
		return new HomePage();
		
	}*/
	

}
