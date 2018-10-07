package webPages;

import java.awt.Desktop.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import util.Util;

public class AdvancedSearchPage extends TestBase{
	
	@FindBy(xpath="//input[@name='price[from]']")
	 WebElement Price1;
	
	@FindBy(xpath="//input[@name='price[to]']")
	 WebElement Price2;
	
	@FindBy(xpath="//div[@class='buttons-set']//following::span[text()='Search']")
	 WebElement SearchBtn;
	
	
	
	public AdvancedSearchPage(){
		PageFactory.initElements(driver, this);
	}
	
	//giving Price Ranges 0 to 150
	public MagentoCommercePage Price_Range(String PriceFrom, String PriceTo) {
		Util.scrollPageDown(driver);
		//Price1.click();
		Price1.sendKeys(PriceFrom);
		//Price2.click();
		Price2.sendKeys(PriceTo);
		SearchBtn.click();
		return new MagentoCommercePage();
	}

}
