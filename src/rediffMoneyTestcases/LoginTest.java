package rediffMoneyTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	static WebDriver driver = null;

	@Test
	public void loginTest() {
		String browser = "chrome";

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("mozilla")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\WebDrivers\\geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			FirefoxOptions fo = new FirefoxOptions();
			fo.setPageLoadStrategy(PageLoadStrategy.EAGER);
			driver = new FirefoxDriver(fo);

		} else
			System.out.println(browser + " could not be found.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://in.rediff.com/");

		// Clicking on the Money link
		driver.findElement(By.cssSelector(".cell.topicons a:nth-child(2)")).click();
		driver.findElement(By.cssSelector("span#signin_info a")).click();
		driver.findElement(By.cssSelector("input#useremail")).sendKeys("gurpreetnsrsel@gmail.com");
		driver.findElement(By.cssSelector("input#userpass")).sendKeys("gurpreet@2550");
		driver.findElement(By.cssSelector("input#rememberflag")).click();
		driver.findElement(By.cssSelector("input#loginsubmit")).click();

		boolean result = isElementPresent("span#username a");
		Assert.assertTrue(result, "Login is unsuccessful!");
	}

	public static boolean isElementPresent(String cssSelectorExp)
	{
		int size = driver.findElements(By.cssSelector(cssSelectorExp)).size();
		if(size ==0)
			return false;
		else
			return true ;
	}

}
