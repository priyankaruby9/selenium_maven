package grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridExample {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		DesiredCapabilities cap = new DesiredCapabilities(); //using this we define the platform
		cap.setPlatform(Platform.WINDOWS);
		cap.setBrowserName("chrome");
		
		URL url = new URL("http://localhost:4444/wd/hub");//client will connect to hub url
		WebDriver driver = new RemoteWebDriver(url,cap); //since we running on remote machine hub
		
		driver.get("https://www.simplilearn.com");
		driver.quit();
	}

}
