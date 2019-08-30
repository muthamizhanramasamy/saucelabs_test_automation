package Scripts;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Support.AppiumDriverFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileAppScripts {
	
	String platform = "iOS";

	@Test
	public void App_Test_001() throws MalformedURLException {
	
		AppiumDriver<MobileElement> driver = AppiumDriverFactory.getDriver(platform);
		System.out.println("App launched successfully - 1");
		driver.quit();
	}
	
	@Test
	public void App_Test_002() throws MalformedURLException {
	
		AppiumDriver<MobileElement> driver = AppiumDriverFactory.getDriver(platform);
		System.out.println("App launched successfully - 2");
		driver.quit();
	}
	
}
