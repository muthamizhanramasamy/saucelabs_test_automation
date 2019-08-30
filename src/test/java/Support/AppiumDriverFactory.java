package Support;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class AppiumDriverFactory {

	public static AppiumDriver<MobileElement> getDriver(String platform) throws MalformedURLException{
		String testName = null;
		AppiumDriver<MobileElement> driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();
		
		final String USERNAME = "muthu.ramasamy";
		final String ACCESS_KEY = "032174fd-9a11-4cd0-bcaf-581fb914b550";
		final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		
		if(platform.equalsIgnoreCase("ios")) {
			
			caps.setCapability("appiumVersion", "1.13.0");
			caps.setCapability("deviceName","iPhone XS Max Simulator");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("platformVersion","12.2");
			caps.setCapability("platformName", "iOS");
			caps.setCapability("app","sauce-storage:Belk-AdHocProd.zip");
			Throwable t = new Throwable();
			testName=t.getStackTrace()[1].getMethodName();
			caps.setCapability("name",testName);
			driver = new IOSDriver<MobileElement>(new URL(URL), caps);
			
		}else if (platform.equalsIgnoreCase("android")){
			
			caps.setCapability("appiumVersion", "1.9.1");
			caps.setCapability("deviceName","Samsung Galaxy S9 WQHD GoogleAPI Emulator");
			caps.setCapability("deviceOrientation", "portrait");
			caps.setCapability("platformVersion","9.0");
			caps.setCapability("platformName","Android");
			caps.setCapability("app","sauce-storage:app-belk-release.apk");
			Throwable t = new Throwable();
			testName=t.getStackTrace()[1].getMethodName();
			caps.setCapability("name",testName);
			driver = new AndroidDriver<MobileElement>(new URL(URL), caps);
		}else {
			Assert.fail("Invalid platform. Please check the platformName");
		}
		
		return driver;
		
	}
	
}
