package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.TestBase;
import util.Util;

public class HomePage extends TestBase{
	
	/* @FindBy(xpath="//*[@id='nav']/ol/li[1]/a")
	 WebElement MobileBtn;*/
	
	@FindBy(xpath = "//a[text()='Mobile']")
	WebElement MobileLink;
	 
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
	 
	 @FindBy(xpath="//a[@title='Advanced Search']")
	 WebElement AdvancedSearchBtn;
	 
	
	 public HomePage(){
			PageFactory.initElements(driver, this);
		}
	 //Validate HomePageTiltle
	 public String validateHomePageTitle(){
			return driver.getTitle();
		}
	 /*// Click on MobileBtn
	 public MobilePage clickMobileBtn() {
		 MobileBtn.click();
		 return new MobilePage();
	 }*/
	 
	// Click on MobileLink
		public MobilePage ClickOnMobile() {
			MobileLink.click();
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
			 /*WebElement element = driver.findElement(By.xpath("//span[contains(text(),'Quick Links')]"));	 
			 Actions action = new Actions(driver); 
		        action.moveToElement(element).build().perform(); 
		        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[3]/ul[1]/li[3]/a[1]")).click();*/
			 AdvancedSearchBtn.click();
			 return new AdvancedSearchPage();
		 }
	 
	 
	 
	 }
	  
		 
		 
		 
		 
		 
		 
		 
		 
	 
	 
