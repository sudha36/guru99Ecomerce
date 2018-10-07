package webPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import util.BrowserAlertHelper;
import util.Util;

public class MobilePage extends TestBase{
	
	 @FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")
	 WebElement SortBytDropnDown;
	 
	 @FindBy(xpath=".//*[@id='top']/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select/option[2]")
	 WebElement SelectName;
	 
	 @FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/h2/a")
	 WebElement SonyXperia;
	 
	 @FindBy(xpath=".//*[@id='product-price-1']/span")
	 WebElement SonyXperiaValue;
	 
	 @FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")
	 WebElement SonyXperiaAddtoCartBtn;
	 
	 @FindBy(xpath="//span[contains(text(), '$100')]//following::a[3]")
	 WebElement SonyXperiaAddtoCompareBtn;
	 
	 @FindBy(xpath="//span[contains(text(), '$500')]//following::a[3]")
	 WebElement IphoneAddtoCompareBtn;
	 
	 @FindBy(xpath="/html/body/div[1]/div/div[2]/div/div[3]/div[1]/div[2]/div/button")
	 WebElement CompareBtn;
	 
	 @FindBy(xpath="//span[contains(text(), '$100.00')]")
	 WebElement SonyXperiaPrice;
	 
	 @FindBy(xpath="//span[contains(text(), '$500.00')]")
     WebElement IphonePrice;	
	 
	 @FindBy(xpath="//ul[@class='products-grid products-grid--max-4-col first last odd']//li[2]//div[1]//div[3]//button[1]")
     WebElement IphoneAddtoCart;
	 
	// @FindBy(xpath="//ul[@class='products-grid products-grid--max-4-col first last odd']//li[1]//div[1]//div[3]//button[1]")
	// WebElement CloseBtn;
	 
	 
	 
	 public MobilePage(){
			PageFactory.initElements(driver, this);
		}
	 
	 
	 public String validateMobilePageTitle(){
			return driver.getTitle();
		}
	 
	 public void ClickSortByDropdownBtn() {
		 SortBytDropnDown.click();
	 }
	 
  public void ClickNameField() {
	  Actions action = new Actions(driver);
	  action.moveToElement(SortBytDropnDown).build().perform();
	  SelectName.click();
		 
  }
  
  public String ValueofSonyxperia() {
	  return driver.findElement(By.xpath(".//*[@id='product-price-1']/span")).getText();
	  
	  
  }
  
  public DetailsPage ClickSonyXperia() {
	  SonyXperia.click();
	  return new DetailsPage();
	  
	  
  }
  
  public ShoppingCartPage ClickSonyXperiaAddtoCartBtn() {
	  SonyXperiaAddtoCartBtn.click();
	  return new ShoppingCartPage();
	 }

  public void VerifyCompareProduct()  {
	  Util.scrollPageDown(driver);
	  SonyXperiaAddtoCompareBtn.click();
	  IphoneAddtoCompareBtn.click();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 CompareBtn.click();	 
		BrowserAlertHelper.SwitchWindow(driver);
		Util.drawBorder(SonyXperiaPrice, driver);
		  Util.drawBorder(IphonePrice, driver);
	
	  try {
		Util.ScreenCapture();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  } 
	  
	 	
  
  
  
  public ShoppingCartPage ClickIphoneAddtoCart() {
	  IphoneAddtoCart.click();
	  return new ShoppingCartPage();
	 }


	 }
  
  
  

