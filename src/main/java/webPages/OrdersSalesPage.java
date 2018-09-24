package webPages;



import javax.mail.MessagingException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import EmailUtil.EmailUtil;
import EmailUtil.ReadFile;
import EmailUtil.ReadPdfFile;
import testBase.TestBase;
import util.Util;

public class OrdersSalesPage extends TestBase{
	
	@FindBy(xpath="//select[@id='sales_order_grid_export']")
	WebElement ExportDropDown;
	
	@FindBy(xpath="//option[@value='http://live.guru99.com/index.php/backendlogin/sales_order/exportCsv/key/422ee90613311141d7c6ba5e3484a3d9/']")
	WebElement SelectCSV;
	
	@FindBy(xpath="//button[@title='Export']")
	WebElement ExportBtn;
	
	@FindBy(xpath="//select[@id='sales_order_grid_filter_status']")
	WebElement StatusDropDown;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[4]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/button[2]")
	WebElement SearchBtn;
	
	@FindBy(xpath="//input[@value='8000']")
	WebElement FirstOrderChkBox;
	
	@FindBy(xpath="//select[@id='sales_order_grid_massaction-select']")
	WebElement ActionDropDown;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[4]/div[1]/div[3]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/div[1]/form[1]/fieldset[1]/span[4]/button[1]")
	WebElement SubmitBtn;
	
	@FindBy(xpath="//li[@class='error-msg']//ul//li")
	WebElement VerifyErrMsg;
	
	
	
	
	
	public OrdersSalesPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Exporting file
	
	public void Exporting_Email_File() {
		
		Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"sales_order_grid_export\"]")));
		dropdown.selectByVisibleText("CSV");
		ExportBtn.click();
		ReadFile.ReadTheFile();
		try {
			EmailUtil.emailUtil("C:\\seleniumProject\\ecommerce\\src\\Downloads\\orders(1).csv");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//In Status DropDown Select Canceled and Click Search
	//Select the check box next to the FirstOrder
	//In Actions DropDown Select PrintInvoices and Click Submit
	//Verify Err Message
	//In Status DropDown Select Complete and Click Search
	//Select the Check box next to the FirstOrder
	//In Actions DropDown Select PrintInvoices and Click Submit
	//Verify Invoice is downloaded
	
	public void Verify_Invoice() {
		
		Select Statusdropdown = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_filter_status']")));
		Statusdropdown.selectByVisibleText("Canceled");
		SearchBtn.click();
		WebElement ChkBoxBtn = driver.findElement(By.xpath("//input[@value='8000']"));
		ChkBoxBtn.click();
		Select Actiondropdown = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_massaction-select']")));
		Actiondropdown.selectByVisibleText("Print Invoices");
		SubmitBtn.click();
		//System.out.println(VerifyErrMsg.getText());
		 //Util.drawBorder(VerifyErrMsg, driver);
		// return VerifyErrMsg.getText();
		 Select Statusdropdown1 = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_filter_status']")));
		 Statusdropdown1.selectByVisibleText("Complete");
		 SearchBtn.click();
		 WebElement ChkBoxBtn1 = driver.findElement(By.xpath("//input[@value='5']"));
		 ChkBoxBtn1.click();
		 Select Actiondropdown1 = new Select(driver.findElement(By.xpath("//select[@id='sales_order_grid_massaction-select']")));
		 Actiondropdown1.selectByVisibleText("Print Invoices"); 
		 SubmitBtn.click();
		 
		
	}
	
	public String Invoice_Err_Msg() {
		
		System.out.println(VerifyErrMsg.getText());
		 Util.drawBorder(VerifyErrMsg, driver);
		return VerifyErrMsg.getText();
	}

}
