package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class MyOrdersPage extends TestBase {
	
	 @FindBy(xpath = "//a[@href='http://live.guru99.com/index.php/sales/order/view/order_id/7926/']")
	 WebElement ViewOrderLink;
	 
	 public MyOrdersPage(){
			PageFactory.initElements(driver, this);
		}
	 
	 public OrderNumberPage Click_ViewOrder_Link(){
		 ViewOrderLink.click();
		 return new OrderNumberPage();
		 
	 }
	 
	 
	 

}
