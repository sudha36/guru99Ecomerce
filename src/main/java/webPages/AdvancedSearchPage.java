package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class AdvancedSearchPage extends TestBase{
	
	@FindBy(xpath="//*[@id=\"price\"]")
	 WebElement Price1;
	
	@FindBy(xpath="//*[@id=\"price_to\"]")
	 WebElement Price2;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[2]/form/div[2]/button")
	 WebElement SearchBtn;
	
	
	public AdvancedSearchPage(){
		PageFactory.initElements(driver, this);
	}
	
	//giving Price Ranges 0 to 150
	public MagentoCommercePage Price_Range(String PriceFrom, String PriceTo) {
		Price1.sendKeys(PriceFrom);
		Price2.sendKeys(PriceTo);
		SearchBtn.click();
		return new MagentoCommercePage();
	}

}
