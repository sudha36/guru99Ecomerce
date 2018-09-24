package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import util.Util;

public class MyWishListPage extends TestBase {
	
	@FindBy(xpath="//button[@title='Share Wishlist']")
	WebElement MyWLPShareWishListBtn;
	
	@FindBy(xpath="//span[contains(text(),'Your Wishlist has been shared.')]")
	WebElement SharedMsg;
	
	@FindBy(xpath="//button[@title='Add to Cart']")
	WebElement AddtoCartBtn;
	
	 @FindBy(xpath="//a[contains(text(),'TV')]")
	 WebElement WishListTVBtn;
	 
	 
	 
	 
	
	
	
	public MyWishListPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Click ShareWishListBtn in MyWishListPage and then it goes to WishListSharingPage
	public WishListSharingPage ClickShareWishListBtn() {
		MyWLPShareWishListBtn.click();
		return new WishListSharingPage();
		
	}
	
	//Verify Shared Message
	public String VerifySharedMsg() {
		Util.drawBorder(SharedMsg, driver);
		return SharedMsg.getText();
		
	}
	
	//Clicking on AddtoCartBtn
	
	public ShoppingCartPage ClickAddtoCartBtn() {
		AddtoCartBtn.click();
		return new ShoppingCartPage();
		
	}
	
	public TVPage ClickWishListTVBtn() {
		WishListTVBtn.click();
		return new TVPage();
		
	}
	

}
