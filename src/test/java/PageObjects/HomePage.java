package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends LoadableComponent<HomePage> {

	private String siteURL;
	private WebDriver driver;
	private boolean isPageLoaded;


	@FindBy (id="main-menu")
	WebElement mnuNavigation;


	public HomePage(WebDriver driver, String URL) {
		siteURL = URL;
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(finder, this);
	}

	public HomePage(WebDriver driver) {
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(finder, this);
	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get(siteURL);
		waitForPageLoad(driver);
		isPageLoaded = true;

	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub

		if(!isPageLoaded) {
			Assert.fail("Page does not load");
		}

		if(isPageLoaded && !(waitForElement(driver, mnuNavigation, 5))) {
			Assert.fail("Home Page does not load");
		}else {
			System.out.println("Home Page loaded successfully");
		}

	}


	public void waitForPageLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);

	}

	public static boolean waitForElement(WebDriver driver, WebElement element , int maxWait) {
		boolean status = false;
		WebDriverWait wait = new WebDriverWait(driver, maxWait);
		try {
			WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				status = true;
				System.out.println("Element displayed");
			}
		} catch (Exception e) {
			status = false;
			System.out.println("Element not found");
		}
		return status;
	}
}
