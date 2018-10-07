package webPages;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import util.BrowserAlertHelper;
import util.Util;

public class OrderNumberPage extends TestBase{
	
	 
	 @FindBy(xpath = "//h1[contains(text(),'Order #10000')]")
	 WebElement PendingStatus;
	 
	 @FindBy(xpath = "//a[@class='link-print']")
	 WebElement PrintOrderLink;
	 
	 @FindBy(xpath ="//h1")
	 WebElement OrderNumber;
	 
	 public OrderNumberPage(){
			PageFactory.initElements(driver, this);
		}
	 
	 //Verifying the Pending Statement 
	 public String Verify_Pending_Status() {
		 System.out.println(PendingStatus.getText());
		 Util.drawBorder(PendingStatus, driver);
		 return PendingStatus.getText();
		 
	 }
	 
	 //GetTilte of the Page
	 public String GetTitle_OrderNumber_Page(){
	      System.out.println(driver.getTitle());
	      
		 return driver.getTitle();
	 }
	 
	 //Clicking on PrintOrder
	 public void Click_PrintOrder() {
		 	 PrintOrderLink.click();
		 	
				BrowserAlertHelper.SwitchWindow(driver);
			
			Util.drawBorder(OrderNumber, driver);
			try {
				Util.ScreenCapture();
			} catch (IOException e) {
				e.printStackTrace();
			}
	} 
		 	 
		 
	 }
	 
	
	


