package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class MyOrdersPage extends TestBase {
	
	 @FindBy(xpath ="//a[text()='View Order']")
	 WebElement ViewOrderLink;
	 
	 public MyOrdersPage(){
			PageFactory.initElements(driver, this);
		}
	 
	 public OrderNumberPage Click_ViewOrder_Link(){
		 ViewOrderLink.click();
		 return new OrderNumberPage();
		 
	 }
	 
	 
	 

}
