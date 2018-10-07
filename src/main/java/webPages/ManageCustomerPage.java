package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class ManageCustomerPage extends TestBase{
	
	@FindBy(xpath="//a[@title='close']")
	WebElement PopUPCloseBtn;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/ul/li[1]/a/span")
	WebElement Sales;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/ul/li[1]/ul/li[1]/a/span")
	WebElement Orders;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[2]/a[1]/span[1]")
	WebElement Invoices;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/ul/li[3]/a/span")
	WebElement Customers;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/ul/li[3]/ul/li/a/span")
	WebElement ManageCustomers;
	
	@FindBy(xpath="/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/tbody/tr[1]/td[4]")
	WebElement Click_NameontheCustomers;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/ul/li[2]/a/span")
	WebElement Catalog;
	
	@FindBy(xpath="//span[contains(text(),'Reviews and Ratings')]")
	WebElement ReviewandRatings;
	
	@FindBy(xpath="//span[contains(text(),'Customer Reviews')]")
	WebElement CustomerReviews;
	
	@FindBy(xpath="//span[contains(text(),'Pending Reviews')]")
	WebElement PendingReviews;
	
	
	public ManageCustomerPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//Close PopUPWindow and then Click on Sales btn and OrdersBtn 
	public OrdersSalesPage Perform_Actions_Click_Sales_Orders() {
		PopUPCloseBtn.click();
		
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/a/span"));	 
        Actions action = new Actions(driver); 
        action.moveToElement(element).build().perform(); 
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/ul/li[1]/a/span")).click();
		
		return new OrdersSalesPage();
		
	}
	
	//Clicking on Sales and Invoice Btn
	public InvoiceSalesPage Perform_Actions_Click_Sales_Invoice() {
		PopUPCloseBtn.click();
		
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/a/span"));	 
        Actions action = new Actions(driver); 
        action.moveToElement(element).build().perform(); 
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[2]/a[1]/span[1]")).click();
		
		return new InvoiceSalesPage();
	}
	
	public CustomerDetailManageCustomersPage Perform_Actions_Click_CustomersTab() {
		PopUPCloseBtn.click();
		
		WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[3]/a/span"));	 
        Actions action = new Actions(driver); 
        action.moveToElement(element).build().perform(); 
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[3]/ul/li/a/span")).click();
        Click_NameontheCustomers.click();
		return new CustomerDetailManageCustomersPage();
	}
		
   
}
