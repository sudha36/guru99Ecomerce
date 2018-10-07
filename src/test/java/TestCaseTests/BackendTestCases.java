package TestCaseTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import EmailUtil.ReadPdfFile;
import testBase.TestBase;
import util.BrowserAlertHelper;
import util.Util;
import webPages.AdvancedSearchPage;
import webPages.CheckOutPage;
import webPages.CreateNewAccountPage;
import webPages.CustomerDetailManageCustomersPage;
import webPages.CustomerLoginPage;
import webPages.DetailsPage;
import webPages.HomePage;
import webPages.InvoiceSalesPage;
import webPages.LogintoMagnetoAdminPage;
import webPages.MagentoCommercePage;
import webPages.ManageCustomerPage;
import webPages.MobilePage;
import webPages.MyAccountPage;
import webPages.MyOrdersPage;
import webPages.MyWishListPage;
import webPages.OrderNumberPage;
import webPages.OrdersSalesPage;
import webPages.ShoppingCartPage;
import webPages.TVPage;
import webPages.WishListSharingPage;

public class BackendTestCases extends TestBase{
	
	// Creating a variable for Pages
	
			AdvancedSearchPage advancedSearchPage;
			HomePage homePage;
			MobilePage mobilePage;
			DetailsPage detailsPage;
			ShoppingCartPage shoppingCartPage;
			CreateNewAccountPage createNewAccountPage;
			LogintoMagnetoAdminPage logintoMagnetoAdminPage;
			OrdersSalesPage ordersSalesPage;
			InvoiceSalesPage invoiceSalesPage;
			ManageCustomerPage manageCustomerPage;
			CustomerDetailManageCustomersPage customerDetailManageCustomersPage;
			MyAccountPage myAccountPage;
			MyWishListPage myWishListPage;
			MyOrdersPage myOrdersPage;
			OrderNumberPage orderNumberPage;
			TVPage tvPage;
			CustomerLoginPage customerLoginPage;
			WishListSharingPage wishListSharingPage;
			CheckOutPage checkOutPage;
			MagentoCommercePage magentoCommercePage;
			BrowserAlertHelper browserAlertHelper;
			Util util;
			
			// Calling the TestBase Constructor
			public BackendTestCases(){
				super();
				
			}
				
			
			// Calling TestBase Functions and Creating Page Objects
			@BeforeMethod
			public void setUp(){
				BackendURL();
				advancedSearchPage = new AdvancedSearchPage();
				homePage = new HomePage();
				mobilePage = new MobilePage();
				detailsPage = new DetailsPage();
				shoppingCartPage = new ShoppingCartPage();
				createNewAccountPage = new CreateNewAccountPage();
				logintoMagnetoAdminPage = new LogintoMagnetoAdminPage();
				manageCustomerPage = new ManageCustomerPage();
				ordersSalesPage = new OrdersSalesPage();
				invoiceSalesPage = new InvoiceSalesPage();
				customerDetailManageCustomersPage = new CustomerDetailManageCustomersPage();
				checkOutPage =new CheckOutPage();
				myAccountPage = new MyAccountPage();
				myWishListPage = new MyWishListPage();
				myOrdersPage = new MyOrdersPage();
				orderNumberPage = new OrderNumberPage();
				tvPage = new TVPage();
				customerLoginPage= new CustomerLoginPage();
				wishListSharingPage = new WishListSharingPage();
				magentoCommercePage =new MagentoCommercePage();
				browserAlertHelper = new BrowserAlertHelper();
				util = new Util();

}


//Email
@Test(priority=10)
public void Email_Report() {
	extentTest = extentReports.startTest("Email_Report");
	logintoMagnetoAdminPage.Login_Function();
	manageCustomerPage.Perform_Actions_Click_Sales_Orders();
	ordersSalesPage.Exporting_Email_File();
}

//Print-Invoice
@Test(priority=11)
public void Print_Invoices() throws AWTException {
	extentTest = extentReports.startTest("Print_Invoices");
	logintoMagnetoAdminPage.Login_Function();
	manageCustomerPage.Perform_Actions_Click_Sales_Orders();
	ordersSalesPage.Verify_Invoice();
	Assert.assertEquals(ordersSalesPage.Invoice_Err_Msg(), "There are no printable documents related to selected orders.");
	Robot robotObject = new Robot();
	robotObject.keyPress(KeyEvent.VK_TAB);
	robotObject.keyPress(KeyEvent.VK_ENTER);
	try {
		ReadPdfFile.ReadPdfFiles("100000005");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

//Sorting Fuctionality
@Test(priority=13)
public void Sort_Functionality() {
	extentTest = extentReports.startTest("Sort_Functionality");
	logintoMagnetoAdminPage.Login_Function();
	manageCustomerPage.Perform_Actions_Click_Sales_Invoice();
	invoiceSalesPage.Click_InvoiceDate();
	
}


@Test(priority=15)
public void Verify_DisabledFields() {
	extentTest = extentReports.startTest("Verify_DisabledFields");
	logintoMagnetoAdminPage.Login_Function();
	manageCustomerPage.Perform_Actions_Click_CustomersTab();
	customerDetailManageCustomersPage.Verify_DisabledFields();
	customerDetailManageCustomersPage.verifyNewPwdIsEmpty();
}


}


			