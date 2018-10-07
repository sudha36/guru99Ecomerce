package testBase;


	
	import java.io.File;

//import static testBase.TestBase.initialization;

import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
	import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


import util.BrowserAlertHelper;
import util.Util;
import util.WebEventListener;
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
	

	//import com.crm.qa.util.TestUtil;
	//import com.crm.qa.util.WebEventListener;

	public class TestBase {
		
		public static WebDriver driver;
		public static Properties prop;
		public  static EventFiringWebDriver e_driver;
		public static WebEventListener eventListener;
		public static ExtentTest extentTest;
		public static ExtentReports extentReports;
		
		public TestBase(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/config/config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@BeforeSuite
		public void setExtent() {
			extentReports = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
			extentReports.addSystemInfo("Host Name", "Murali ");
			extentReports.addSystemInfo("User Name", "Murali");
			extentReports.addSystemInfo("Environment", "QA");

		}

		@AfterMethod
		public void setResults(ITestResult result) throws IOException {

			if (result.getStatus() == ITestResult.FAILURE) {
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
				extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in
				                                                                                // extent report

				String screenshotPath = TestBase.getScreenshot(driver, result.getName());
				extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); // to add screenshot in extent
				                                                                             // report
				// extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath));
				// //to add screencast/video in extent report
			} else if (result.getStatus() == ITestResult.SKIP) {
				extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

			}

			extentReports.endTest(extentTest); // ending test and ends the current test and prepare to create html report
			driver.close();
		}

		@AfterSuite
		public void endReport() {
			extentReports.flush();
			extentReports.close();

		}

		
		public static void initialization(){
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:/seleniumProject/ecommerce/src/Browsers/chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "C:/seleniumProject/ecommerce/src/Browsers/geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}
			
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
			//driver.get(prop.getProperty("URL"));
		}
		
		public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
			String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			// after execution, you could see a folder "FailedTestsScreenshots"
			// under src folder
			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
			        + ".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			return destination;
		}
		
		
		public static void BackendURL(){
	
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:/seleniumProject/ecommerce/src/Browsers/chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "C:/seleniumProject/ecommerce/src/Browsers/geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}
			
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			//driver.get(prop.getProperty("url"));
			
			driver.get(prop.getProperty("BackendURL"));
		}
		
		
		
		public static void ReviewandProductURL(){
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:/seleniumProject/ecommerce/src/Browsers/chromedriver.exe");	
				driver = new ChromeDriver(); 
			}
			else if(browserName.equals("FF")){
				System.setProperty("webdriver.gecko.driver", "C:/seleniumProject/ecommerce/src/Browsers/geckodriver.exe");	
				driver = new FirefoxDriver(); 
			}
			
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			//driver.get(prop.getProperty("url"));
			
			driver.get(prop.getProperty("ReviewandProductURL"));
		}
		
		
		
		}
		

	


