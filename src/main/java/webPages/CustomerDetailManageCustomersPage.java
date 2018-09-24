package webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import testBase.TestBase;
import util.Util;

public class CustomerDetailManageCustomersPage extends TestBase {
	
	@FindBy(xpath="/html/body/div[1]/div[4]/div/div/div[1]/ul/li[2]/a/span")
	WebElement AccountInfo;
	
	@FindBy(xpath="//*[@id=\"_accountwebsite_id\"]")
	WebElement AssociateWebsite;
	
	@FindBy(xpath="//*[@id=\"_accountcreated_in\"]")
	WebElement CreateForm;
	
	@FindBy(xpath="//input[@id=\"_accountnew_password\"]")
	WebElement NewPassWord;
	
	public CustomerDetailManageCustomersPage() {
		PageFactory.initElements(driver, this);
	}
	
	//verify disabled fields and fields should be blank
	public void Verify_DisabledFields() {
		AccountInfo.click();
		Util.drawBorder(AssociateWebsite, driver);
		
		if(AssociateWebsite.isEnabled())
		  {
		   System.out.print("\nText box AssociateWebsite is enabled. Take your action.");
		  }
		  else
		  {
		   System.out.print("\nText box AssociateWebsite is disabled. Take your action.");
		  }
		
		Util.drawBorder(CreateForm, driver);
		
		if(CreateForm.isEnabled())
		  {
		   System.out.print("\nText box CreateForm is enabled. Take your action.");
		  }
		  else
		  {
		   System.out.print("\nText box CreateForm is disabled. Take your action.");
		  }
	}
		public void verifyNewPwdIsEmpty() {
			String NewPwdFieldText = NewPassWord.getText();
			System.out.println("NewPassWord is empty" + NewPwdFieldText);
			Assert.assertEquals(NewPwdFieldText, "");
		}
		
		/*WebElement myInput = driver.findElement(By.xpath("//*[@id=\\\"_accountnew_password\\\"]"));
		Assert.assertThat(myInput.getAttribute("value"), isEmptyString());
		
		Util.drawBorder(NewPassWord, driver);
		WebElement A = driver.findElement(By.xpath("//*[@id=\"_accountnew_password\"]")); 
		String text = A.getAttribute("value"); 
		if(text.isEmpty()) { System.out.println("input box is empty"); }*/
		/*WebDriverWait wait5 = new WebDriverWait(driver, 5);
		WebElement charge = wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"_accountnew_password\"]")));
        boolean noChargeIdPresent = charge.getText().isEmpty();
		System.out.println("Element to be clickable");*/
		/*if(((WebElement) wait5).findElement(By.name("chargeId")).getText().length() == 0) {
		      //=========== DO WHAT YOU WANT IF EMPTY============
		}
		else {
		     //======== DO WHEN NOT EMPTY==================
		}*/
		//
		
		/*if(boolean noChargeIdPresent = charge.getText().isEmpty();
		System.out.println("Element to be clickable");*/
	}

	


