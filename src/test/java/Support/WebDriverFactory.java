package Support;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverFactory {
	static URL hubURL;
	static DesiredCapabilities caps = new DesiredCapabilities();
	private static String testName = null;
	public static WebDriver getDriver(String browserAndPlatform, String... environment) throws MalformedURLException {
		WebDriver driver = null;
		String platform = null;
		String browser = null;
		String host = null;
		String port = null;


		final String USERNAME = "muthu.ramasamy";
		final String ACCESS_KEY = "032174fd-9a11-4cd0-bcaf-581fb914b550";
		final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";


		host = "localhost";
		port = "4444";

		browser = browserAndPlatform.split("_")[0].trim();
		platform = browserAndPlatform.split("_")[1].trim();
		
		if(environment.length>0)
			if(environment[0].contains("saucelabs")) {
				hubURL = new URL(URL);	
			}else {
				hubURL = new URL("http://"+host+":"+port+"/wd/hub");
			}


		if("chrome".equalsIgnoreCase(browser)) {
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.fromString(platform));
			Throwable t = new Throwable();
			testName=t.getStackTrace()[1].getMethodName();
			caps.setCapability("name",testName);
			driver = new RemoteWebDriver(hubURL, caps);

		}else {
			System.out.println("Browser name is incorrect");
		}

		return driver;

	}
}
