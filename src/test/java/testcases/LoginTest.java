package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//import com.beust.jcommander.Parameter;

import pages.LoginPage;

public class LoginTest extends Baseclass {	
	
	@Test
	public void LoginFailureTest() {
		
		//test = report.startTest("LoginFailureTest"); //add line only for extent report
		
		LoginPage login = new LoginPage();
		
		login.LoginFunction("Xyz@abc.com", "Abc@12345" );
					
		WebElement ErrorMsg = driver.findElement(By.id("msg_box"));
		String ActualMsg = ErrorMsg.getText();//used to store the txt on screen
		String ExpMsg = "The email or password you have entered is invalid.";
		
		Assert.assertEquals(ActualMsg, ExpMsg);		
		//report.endTest(test);//add line only for extent report
	}

	/*@Test
	public void LoginSuccessTest() {
	
		LoginPage login = new LoginPage();		
		login.LoginFunction("Xyz@abc.com", "Abc@12345" );
		
	}*/

	/*@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String UserNameVal,String PasswordVal) {
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal, PasswordVal);
	}*/
	
	@Test
	public void ExternalDataTest() {
		
		String UserNameVal  = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal =  sheet.getRow(1).getCell(1).getStringCellValue();
		
		LoginPage login = new LoginPage();
		login.LoginFunction(UserNameVal,PasswordVal);
	}
}
