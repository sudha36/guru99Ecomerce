package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class TVPage extends TestBase{
	
	//Pagefactory
	@FindBy(xpath="//ul[@class='products-grid products-grid--max-4-col first last odd']//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")
    WebElement LGAddWishListBtn;
	
	public TVPage() {
		PageFactory.initElements(driver, this);
		
		}
	
	//Clicking on AddWishListButton under LGLCD
	public MyWishListPage ClickLGAddWishListBtn() {
		LGAddWishListBtn.click();
		return new MyWishListPage();
	}
	
	
}
