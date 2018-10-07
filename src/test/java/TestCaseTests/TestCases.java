package TestCaseTests;

	
	

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

	public class TestCases extends TestBase {
		
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
		public TestCases(){
			super();
			
		}
			/*advancedSearchPage = new AdvancedSearchPage();
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
			util = new Util();*/
		
		// Calling TestBase Functions and Creating Page Objects
		@BeforeMethod
		public void setUp(){
			initialization();
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
			//homePage.ClickOnMobile();
			//homePage.clickMobileBtn();
		}
		
		@Test(priority=1)
		public void homePageTitleTest(){
			//homePage.clickMobileBtn();
			extentTest = extentReports.startTest("homePageTitleTest");
			String title = homePage.validateHomePageTitle();
			Assert.assertEquals(title, "Home page");
			System.out.println(title);
			homePage.ClickOnMobile();
			String title1 = mobilePage.validateMobilePageTitle();
			Assert.assertEquals(title1, "Mobile");
			System.out.println(title1);
			mobilePage.ClickNameField();
			
		}
		
		@Test(priority=2)
		public void VerifyCostinTwoPages(){
			extentTest = extentReports.startTest("VerifyCostinTwoPages");
			homePage.ClickOnMobile();
			mobilePage.ValueofSonyxperia();
			mobilePage.ClickSonyXperia();
			String title=detailsPage.SonyXperiaMobilePricetest();
			Assert.assertEquals(title, "$100.00");
		}
		
		//Error verification Test 
		@Test(priority=3)
		
		public void ErrorVerificationTest() {
			extentTest = extentReports.startTest("ErrorVerificationTest");
			homePage.ClickOnMobile();
			
			mobilePage.ClickSonyXperiaAddtoCartBtn();
			shoppingCartPage.ChangeQuantity();
			shoppingCartPage.ClickUpdateBtn();
			String title =shoppingCartPage.SonyXperiaVerifyErrorMsg();
			Assert.assertEquals(title, "* The maximum quantity allowed for purchase is 500.");
			shoppingCartPage.ClickEmptyCartBtn();
			String Title = shoppingCartPage.VerifyEmptyCartMsg();
			System.out.println(Title);
			Assert.assertEquals(Title, "You have no items in your shopping cart.");
		}
		
		//Comparing two products and verifing the messege
		@Test(priority=4)
		public void VerifycompareProducts()  {
			extentTest = extentReports.startTest("VerifycompareProducts");
			//homePage.clickMobileBtn();
			homePage.ClickOnMobile();
			
            mobilePage.VerifyCompareProduct();
		    
		 
		   
		}
		@DataProvider
		public Object[][] GetData() {
			Object data[][] = Util.getTestData("Sheet1");
			return data;
	}  
		
		// Account Creation
		@Test(priority =5, dataProvider="GetData")
		
		public void AccountCreationTest(String FirstName, String MiddleName, String LastName, String EmailAddress, String PassWord, String ConfirmPwd) {
			extentTest = extentReports.startTest("AccountCreationTest");
			homePage.ClickOnMobile();
			homePage.clickHomeRegisterBtn();
			createNewAccountPage.FillAcctDetails(FirstName, MiddleName, LastName, EmailAddress,PassWord, ConfirmPwd);
			//String RegistraionMsg = myAccountPage.RegistrationMessge();
			//System.out.println(RegistraionMsg);
			//Assert.assertEquals(RegistraionMsg, "Thank you for registering with Main Website Store.");
			myAccountPage.clickTVBtn();
			tvPage.ClickLGAddWishListBtn();
			myWishListPage.ClickShareWishListBtn();
			wishListSharingPage.ShareWishListDetails();
			Assert.assertEquals(myWishListPage.VerifySharedMsg(), "Your Wishlist has been shared.");
			
			
		}
		
		//PurchaseProduct
		@Test(priority = 6)
		
		public void PurchaseProduct() {
			extentTest = extentReports.startTest("PurchaseProduct");
			homePage.clickAccountBtn();
			customerLoginPage.LoginCredentials();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myAccountPage.ClickMyWishListLink();
			myWishListPage.ClickWishListTVBtn();
			tvPage.ClickLGAddWishListBtn();
			myWishListPage.ClickAddtoCartBtn();
			shoppingCartPage.EnterDetails_Estimate_Shipping();
			checkOutPage.ClickBillingInfoContinueBtn();
			magentoCommercePage.Draw_Border_Number();
			
			
		}
		
		//View PDF File
		@Test(priority=7)
		
		public void PDFFile() {
			extentTest = extentReports.startTest("PDFFile");
			homePage.clickAccountBtn();
			customerLoginPage.LoginCredentials();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myAccountPage.Click_MyOrders_Link();
			myOrdersPage.Click_ViewOrder_Link();
			orderNumberPage.GetTitle_OrderNumber_Page();
			orderNumberPage.Verify_Pending_Status();
			//Assert.assertEquals(orderNumberPage.Verify_Pending_Status(), "orderNumberPage.GetTitle_OrderNumber_Page()");
			orderNumberPage.Click_PrintOrder();
			
			}
		
		//RE_Order TestCase
		@Test(priority=8)
		public void ReOrder() {
			extentTest = extentReports.startTest("ReOrder");
			homePage.clickAccountBtn();
			customerLoginPage.LoginCredentials();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			myAccountPage.Click_ReOrder_Link();
			shoppingCartPage.ChangeQuantity_Verify_GrandToal();
			checkOutPage.ClickBillingInfoContinueBtn();
			magentoCommercePage.Generated_OrderNumber_8();
			
		}
		
		//Discount Coupon and Verify the GrandTotal
		@Test(priority = 9)
		public void VerifyGrandTotalDiscountCoupon() {
			extentTest = extentReports.startTest("VerifyGrandTotalDiscountCoupon");
			homePage.ClickOnMobile();
			mobilePage.ClickIphoneAddtoCart();
			shoppingCartPage.DisCount_Coupon_Apply();
		}
		
		
		
		
		@Test(priority=14)
		public void Verify_Search_Functionality() {
			extentTest = extentReports.startTest("Verify_Search_Functionality");
			homePage.click_AdvancedSearchBtn();
			advancedSearchPage.Price_Range("0","150");
			magentoCommercePage.Verify_Sony_Functionality();
			magentoCommercePage.Verify_Samusung_Functionality();
		}
		
		
		
}

	
