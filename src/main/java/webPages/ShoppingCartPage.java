package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;
import util.Util;

public class ShoppingCartPage extends TestBase{
	
	@FindBy(xpath=".//*[@id='shopping-cart-table']/tbody/tr/td[4]/input")
	 WebElement SonyXperiaQuantity;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[4]/input[1]")
	 WebElement LGLCDQuantity;
	
	@FindBy(xpath="//strong[contains(text(),'Grand Total')]")
	 WebElement GrandTotal;
	
	@FindBy(xpath="//strong[contains(text(),'Grand Total')]")
	 WebElement TotalQuantityPrice;
	
	@FindBy(xpath=".//*[@id='shopping-cart-table']/tbody/tr/td[4]/button")
	 WebElement UpdateBtn;
	
	@FindBy(xpath=".//*[@id='shopping-cart-table']/tbody/tr/td[2]/p")
	 WebElement VerifyErrorMsg;
	
	/*@FindBy(xpath="//div[@class='page-title']")
	 WebElement VerifyErrorMsg;*/
	
	@FindBy(xpath=".//*[@id='empty_cart_button']")
	 WebElement EmptyCartBtn;
	
	@FindBy(xpath=".//*[@id='top']/body/div[1]/div/div[2]/div/div/div[2]/p[1]")
	 WebElement VerifyEmptyCartMessage;
	
	//@FindBy (xpath="//h1[contains(text(),'Shopping Cart is Empty')]")
	 //WebElement VerifyEmptyCartMessage;
	
	@FindBy (xpath="//select[@id='region_id']")
	WebElement EstimateShippingRegionId;
	
	@FindBy(xpath="//input[@id='postcode']")
	WebElement EstimateShippingZip;
	
	@FindBy(xpath="//button[@title='Estimate']")
	WebElement EstimateBtn;
	
	@FindBy(xpath="//label[@for='s_method_flatrate_flatrate']")
	WebElement FlatRateRadioBtn;
	
	
	@FindBy(xpath="//button[@title='Update Total']")
	WebElement UpdateTotalBtn;
	
	
	@FindBy(xpath="//td[contains(text(),'Shipping & Handling (Flat Rate - Fixed)')]")
	WebElement ShippingandHandling;
	
	@FindBy(xpath="//td[@class='a-right']//span[@class='price'][contains(text(),'$5.00')]")
	WebElement ShippingandHandlingPrice;
	
	@FindBy(xpath="//li[@class='method-checkout-cart-methods-onepage-bottom']//button[@title='Proceed to Checkout']")
	WebElement ProceedtoCheckoutBtn;
	
	@FindBy(xpath="//input[@id='coupon_code']")
	WebElement DiscountCoupon;
	
	@FindBy(xpath="//button[@title='Apply']")
	WebElement ApplyBtn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr")
	WebElement GrandTotalAmt;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tbody/tr[2]")
	WebElement DisCouponApplied;
	
	
		
	
	 public ShoppingCartPage(){
			PageFactory.initElements(driver, this);
		}
	 
	 //Changing the Quantity in SonyXperia
	 public void ChangeQuantity() {
		 SonyXperiaQuantity.sendKeys("1000");
		 }
	 
     //Clicking on UpdateBtn
	 public void ClickUpdateBtn() {
		 UpdateBtn.click();
	 }
	 
	 //Verifying ErrorMsg
	 public String SonyXperiaVerifyErrorMsg() {
		 return VerifyErrorMsg.getText();
		 
		 	 }
	 //Clicking on EmptyCartBtn
	 public void ClickEmptyCartBtn() {
		 EmptyCartBtn.click();
	 }
	 
	 //Verifying EmptyCartMsg
	 public String VerifyEmptyCartMsg() {
		return VerifyEmptyCartMessage.getText();
	 }
	 
	 //EnterDeatils in Estimate Shipping
	 public CheckOutPage EnterDetails_Estimate_Shipping() {
		 Select dropdown = new Select(EstimateShippingRegionId);
		 EstimateShippingRegionId.click();
		 dropdown.selectByVisibleText("New York");
		 EstimateShippingZip.sendKeys("53428");
		 EstimateBtn.click();
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 WebElement radio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='s_method_flatrate_flatrate']")));
		 radio.click();
		 UpdateTotalBtn.click();
		 Util.drawBorder(ShippingandHandling, driver);
		 Util.drawBorder(ShippingandHandlingPrice, driver);
		 ProceedtoCheckoutBtn.click();
		 return new CheckOutPage();
		 
	 }
	 
	 //Change Quantity in LGLCD and then UpdateBtn
	 public  CheckOutPage ChangeQuantity_Verify_GrandToal() {
		 //EmptyCartBtn.click();
		 LGLCDQuantity.clear();
		 LGLCDQuantity.sendKeys("10");
		 UpdateBtn.click();
		 GrandTotal.getText();	 
		 Util.drawBorder(GrandTotal, driver);
		 TotalQuantityPrice.getText();
		 Util.drawBorder(TotalQuantityPrice, driver);
		 ProceedtoCheckoutBtn.click();
		 return new CheckOutPage();
		 
		 }
	 
	 //Apply Discount Coupon
	 public void DisCount_Coupon_Apply() {
		 Util.drawBorder(GrandTotalAmt, driver);
		 DiscountCoupon.sendKeys("GURU50");
		 ApplyBtn.click();
		 Util.drawBorder(DisCouponApplied, driver);
		
		 
		 
		 
		 
		 
	 }

}
