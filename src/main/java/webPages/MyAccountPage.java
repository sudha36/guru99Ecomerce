package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class MyAccountPage extends TestBase {
	
	 @FindBy(xpath="//span[contains(text(),'Thank you for registering with Main Website Store.')]")
	 WebElement RegistrationMessge;
	 
	 @FindBy(xpath="//a[contains(text(),'TV')]")
	 WebElement TVBtn;
	 
	/* @FindBy(xpath="//strong[contains(text(),'My Wishlist')]")
	 WebElement MyWishListLink;*/
	 
	 @FindBy(xpath = "/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")
	 WebElement MyWishListLink;
	 
	 @FindBy(xpath = "//a[text()='My Orders']")
	 WebElement MyOrdersLink;
	 
	 @FindBy(xpath = "//tr[@class='first odd']//a[@class='link-reorder'][contains(text(),'Reorder')]")
	 WebElement ReOrderLink;
	 
	 public MyAccountPage(){
			PageFactory.initElements(driver, this);
		}
	 
	 
	 public String RegistrationMessge() {
		 return RegistrationMessge.getText();
		 
		 	 }
	 
	 //Click TVBtn and then it goes to TVPage	 
	 public TVPage clickTVBtn() {
		 TVBtn.click();
		 return new TVPage();
	 }
	 
	 //Clicking on MyWishListLink
	 
	 public MyWishListPage ClickMyWishListLink() {
		 MyWishListLink.click();
		 return new MyWishListPage();
			 
	 }
	 
	 //clicking on MyOrdersLink
	 public MyOrdersPage Click_MyOrders_Link() {
		 MyOrdersLink.click();
		 return new MyOrdersPage();
			 
	 }
	 
	//clicking on ReOrdersLink
		 public ShoppingCartPage Click_ReOrder_Link() {
			 ReOrderLink.click();
			 return new ShoppingCartPage();
				 
		 }
	 

}
