package webPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class CustomerLoginPage extends TestBase{
	
	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement Pwd;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/button[1]")
	WebElement LoginBtn;
	
	public CustomerLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//entering Login credentials
	
	public MyAccountPage LoginCredentials() {
		Email.sendKeys("harish.kakumanu@yahoo.com");
		Email.sendKeys(Keys.ENTER);
		Pwd.sendKeys("murlee75");
		Pwd.sendKeys(Keys.ENTER);
		LoginBtn.click();
		return new MyAccountPage();
	}
	
	
	
	

}
