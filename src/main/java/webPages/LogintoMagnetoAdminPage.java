package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class LogintoMagnetoAdminPage extends TestBase {
	
	@FindBy(xpath="//input[@id='username']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement PassWord;
	
	@FindBy(xpath="//input[@title='Login']")
	WebElement LoginBtn;
	
	
	public LogintoMagnetoAdminPage() {
	 
		PageFactory.initElements(driver, this);
	}
	
	public ManageCustomerPage Login_Function() {
		UserName.sendKeys("user01");
		PassWord.sendKeys("guru99com");
		LoginBtn.click();
		return new ManageCustomerPage();
		
		
	}
		
	


}
