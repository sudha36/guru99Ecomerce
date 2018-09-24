package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.TestBase;

public class CheckOutPage extends TestBase{

	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button")
	WebElement BillingInfoContinueBtn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button")
	WebElement ShippingMethodContinueBtn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/form/div/dl/dt[2]/label")
	WebElement CheckorMoneyOrderRadioBtn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button")
	WebElement PaymentContinueBtn;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button")
	WebElement PlaceOrderBtn;
	
	
	public CheckOutPage() {
		PageFactory.initElements(driver, this);
		
		}
	
	//Click on BillingInfo ContinueBtn
	
	public MagentoCommercePage ClickBillingInfoContinueBtn() {
		BillingInfoContinueBtn.click();
		ShippingMethodContinueBtn.click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		 WebElement radio = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/form/div/dl/dt[2]/label")));
		 radio.click();
		 PaymentContinueBtn.click();
		 PlaceOrderBtn.click();
		 return new MagentoCommercePage();
		 
}
}