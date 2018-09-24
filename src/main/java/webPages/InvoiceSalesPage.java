package webPages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import util.Util;

public class InvoiceSalesPage extends TestBase{
	
	@FindBy(xpath="/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[1]/th[3]/span/a/span")
	WebElement InvoiceDate;
	
	@FindBy(xpath="/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/tbody/tr[2]/td[3]")
	WebElement InvoiceDate1;
	
	
	public InvoiceSalesPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//checking the Asceding and desending 
	public void Click_InvoiceDate()   {
		Util.drawBorder(InvoiceDate1, driver);
		try {
			Util.ScreenCapture();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		InvoiceDate.click();
		try {
			Util.ScreenCapture();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
