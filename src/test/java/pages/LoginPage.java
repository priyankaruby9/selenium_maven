package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.Baseclass;

public class LoginPage {
	
	WebDriver driver = Baseclass .driver;
	
	ExtentTest test = Baseclass.test; // add only for extent report
	/*********Web Elements**********/
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(name = "btn_login")
	WebElement LoginBtn;
	
	@FindBy(className = "rememberMe")
	WebElement Rememberme;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	/************function**************/
	public void LoginFunction ( String UserNameVal, String PasswordVal) {
		/*WebElement LoginLink = driver.findElement(By.linkText("Log in")); //Linktext is locator
		
		
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement Rememberme = driver.findElement(By.className("rememberMe"));*/
		//Explicit wait
		//WebDriverWait wait = new WebDriverWait(driver,50);
		//wait.until(ExpectedConditions.elementToBeClickable(LoginLink));
		
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Login link clicked successfully"); //used for extent report
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Click on username ", "username clicked successfully");
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Click on password", "password clicked successfully");
		Rememberme.click();
		test.log(LogStatus.PASS, "Click on rememberme", "rememberme clicked successfully");
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on loginbutton", "Loginbutton clicked successfully");
	}
	
	public void UICheck() {
		Assert.assertTrue(UserName.isDisplayed());
	}

}
