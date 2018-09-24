package webPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.TestBase;
import util.Util;

public class MagentoCommercePage extends TestBase{
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div/p[1]/a")
	WebElement OrderNumber;
	
	//@FindBy(xpath="//div[@class='col-main']//p[1]")
	//WebElement GeneratedOrderNumber;
	
	@FindBy(xpath="//h1[contains(text(),'Your order has been received.')]")
		WebElement GeneratedOrderNumber;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[2]/div[3]/ul/li[1]/div/h2/a")
	WebElement SonyXperiaName;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[2]/div[3]/ul/li[1]/div/div[1]/span/span")
	WebElement SonyXperiaPrice;
	
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[2]/div[3]/ul/li[2]/div/h2/a")
	WebElement SamsungName;
	
	@FindBy(xpath="//span[@id='product-price-3']")
	WebElement SamsungPrice;
	
	public MagentoCommercePage() {
		PageFactory.initElements(driver, this);
		
		}
	
	public void Draw_Border_Number() {
		Util.drawBorder(OrderNumber, driver);
	}
	
	//Verify The Order is generated
	public void  Generated_OrderNumber_8() {
		String text = GeneratedOrderNumber.getText();
		System.out.println(text);
		Util.drawBorder(GeneratedOrderNumber, driver);
		//return GeneratedOrderNumber.getText();
		
	}
	
	//verifing Product name and Price and print in the console
	
	public void Verify_Sony_Functionality() {
		
		String Text = SonyXperiaName.getText();
		System.out.println(Text);
		Assert.assertEquals(Text, "SONY XPERIA");
		
		String Text1 = SonyXperiaPrice.getText();
		System.out.println(Text1);
		Assert.assertEquals(Text1, "$100.00");
	}	
	public void Verify_Samusung_Functionality() {
		
		String Text2 = SamsungName.getText();
		System.out.println(Text2);
		Assert.assertEquals(Text2, "SAMSUNG GALAXY");
		
		String Text3 = SamsungPrice.getText();
		System.out.println(Text3);
		Assert.assertEquals(Text3, "$130.00");
	}

}
