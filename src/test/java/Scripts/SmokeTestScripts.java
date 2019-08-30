package Scripts;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import Support.WebDriverFactory;

public class SmokeTestScripts {

	@Test
	public void Test_Script_001() throws MalformedURLException {
	
		WebDriver driver = WebDriverFactory.getDriver("chrome_windows", "saucelabs");
		HomePage homePage = new HomePage(driver, "https://www.aspiresys.com").get();
		System.out.println("Home Page displays - Test-1	");
		driver.quit();
	}
	@Test
	public void Test_Script_002() throws MalformedURLException {
	
		WebDriver driver = WebDriverFactory.getDriver("chrome_windows", "saucelabs");
		HomePage homePage = new HomePage(driver, "https://www.belk.com").get();
		System.out.println("Home Page displays - Test-2");
		driver.quit();
	}
}
