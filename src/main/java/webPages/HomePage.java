package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.TestBase;

public class HomePage extends TestBase{
	
	 @FindBy(xpath="//*[@id='nav']/ol/li[1]/a")
	 WebElement MobileBtn;
	 
	 @FindBy(xpath="//span[@class='label'][contains(text(),'Account')]")
	 WebElement AccountBtn;
	 
	 @FindBy(xpath="//div[@id='header-account']//a[@title='My Account'][contains(text(),'My Account')]")
	 WebElement MyAccountBtn;
	 
	 
	 @FindBy(xpath="//a[@title='Register']")
	 WebElement HomeRegisterBtn;
	 
	 @FindBy(xpath="//span[contains(text(),'Thank you for registering with Main Website Store.')]")
	 WebElement RegistrationMessge;
	 
	 @FindBy(xpath="//a[contains(text(),'TV')]")
	 WebElement TVBtn;
	 
	 @FindBy(xpath="/html/body/div/div/div[3]/div/div[3]/ul/li[3]/a")
	 WebElement AdvancedSearchBtn;
	 
	
	 public HomePage(){
			PageFactory.initElements(driver, this);
		}
	 //Validate HomePageTiltle
	 public String validateHomePageTitle(){
			return driver.getTitle();
		}
	 // Click on MobileBtn
	 public MobilePage clickMobileBtn() {
		 MobileBtn.click();
		 return new MobilePage();
	 }
	 
	/* public String RegistrationMessge() {
		 return RegistrationMessge.getText();
		 
		 	 }*/
	 
	 //Click AccountBtn in HomePage
	 public void clickAccountBtn() {
		 AccountBtn.click();
		 MyAccountBtn.click();
		 
	 }
	 
	 //Click RegistrationBtn in HomePage and then it goes to CreateNewAccountPage
	 public CreateNewAccountPage clickHomeRegisterBtn() {
		 AccountBtn.click();
		 HomeRegisterBtn.click();
		 return new CreateNewAccountPage();
	 }
	 
	 //Click TVBtn and then it goes to TVPage	 
	 public TVPage clickTVBtn() {
		 TVBtn.click();
		 return new TVPage();
	 }
	 
	 
	//Click AdvancedSearch link on the home page and then it goes to Advanced SearchPage	 
		 public AdvancedSearchPage click_AdvancedSearchBtn() {
			 AdvancedSearchBtn.click();
			 return new AdvancedSearchPage();
		 }
	 
	 
	 
	 }
	  
		 
		 
		 
		 
		 
		 
		 
		 
	 
	 
