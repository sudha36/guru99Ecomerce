package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class DetailsPage extends TestBase{
	
	 @FindBy(xpath=".//*[@id='product-price-1']/span")
	 WebElement SonyXperiaMobilePrice;

	 public DetailsPage(){
			PageFactory.initElements(driver, this);
		}
	 
	 public String SonyXperiaMobilePricetest() {
		  return driver.findElement(By.xpath(".//*[@id='product-price-1']/span")).getText();
		  
		  
	  }
}
