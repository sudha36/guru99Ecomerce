package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class WishListSharingPage extends TestBase {
	
	@FindBy(xpath="//textarea[@id='email_address']")
	WebElement EmailAddressTextArea;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement MessageBoxTextArea;
	
	@FindBy(xpath="//button[@title='Share Wishlist']")
	WebElement WishLSPShareWishListBtn;
	
	public WishListSharingPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Click ShareWishListBtn in WishListSharingPage and then it goes to MyWishListPage
	public MyWishListPage ShareWishListDetails() {
		EmailAddressTextArea.sendKeys("sudhach80@yahoo.com");
		MessageBoxTextArea.sendKeys("Hi");
		WishLSPShareWishListBtn.click();
		 return new MyWishListPage();
	 }
	
	

}
