package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass {
		public static WebDriver driver;
	
	 XSSFWorkbook wbook;
	 XSSFSheet sheet;
	 
	 public static ExtentReports report;
	 public static ExtentTest test;
	 
	 
	 @BeforeTest
		public void DataSetUP() throws IOException {
			
			FileInputStream fis = new FileInputStream("exceldata.xlsx"); //used for getting data from excel
			wbook = new XSSFWorkbook(fis); //used for getting data from excel
			sheet = wbook.getSheet("Sheet1");//used for getting data from excel
			
			report = new ExtentReports("ExtentReport.html");  // used only for creating the extent report
		}

	 
	 @AfterTest
		public void DataTearDown() throws IOException {
			
			wbook.close();
			report.flush();
			report.close();
		}

	
	@BeforeMethod
	public void setup(Method method) {
		test = report.startTest(method.getName());//add line only for extent report
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);		
	}
	
	@AfterMethod
	public void TearDown() {
		report.endTest(test);//add line only for extent report
		driver.quit();
		
	}

}
