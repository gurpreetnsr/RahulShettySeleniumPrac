package rediffMoneyTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreatePortFolioTest {

	static WebDriver driver = null;

	@Test
	public void createPortFolioTest() throws InterruptedException {
		String browser = "mozilla";

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://in.rediff.com/");

		// Clicking on the Money link
		driver.findElement(By.cssSelector(".cell.topicons a:nth-child(2)")).click();
		driver.findElement(By.cssSelector("span#signin_info a")).click();
		driver.findElement(By.cssSelector("input#useremail")).sendKeys("gurpreetnsrsel@gmail.com");
		driver.findElement(By.cssSelector("input#userpass")).sendKeys("gurpreet@2550");
		driver.findElement(By.cssSelector("input#rememberflag")).click();
		driver.findElement(By.cssSelector("input#loginsubmit")).click();
		// WebElement createPortfolioButton =
		// driver.findElement(By.cssSelector("a#createPortfolio"));

		// Thread.sleep(1000);

		clickAndWait("a#createPortfolio", "input[name='create']", 10);
		// driver.findElement(By.cssSelector("a#createPortfolio")).click();
		driver.findElement(By.cssSelector("input[name='create']")).clear();
		driver.findElement(By.cssSelector("input[name='create']")).sendKeys("MyFirstPortfolio14");
		driver.findElement(By.cssSelector("input#createPortfolioButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#portfolioid")));
		// wait(1);
		waitForPageToLoad();
		Select portFoliosList = new Select(driver.findElement(By.cssSelector("#portfolioid")));
		System.out.println(portFoliosList.getFirstSelectedOption().getText());
	}

	public void clickAndWait(String cssExp, String cssTarget, int maxTime) {
		for (int i = 1; i <= maxTime; i++) {
			System.out.println(i);
			driver.findElement(By.cssSelector(cssExp)).click();
			if (isElementPresent(cssTarget) && driver.findElement(By.cssSelector(cssTarget)).isDisplayed())
				return;
			else {
				wait(1);
			}
		}
		System.out.println("The Web Element having CSS Selectot " + cssTarget + " is not present.");
	}

	public boolean isElementPresent(String cssSelectorExp) {
		int size = driver.findElements(By.cssSelector(cssSelectorExp)).size();
		if (size == 0)
			return false;
		else
			return true;
	}

	public void wait(int waitTime) {
		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i =1;
		while (true) {
			i++;
			long jQueryStatus = (long) js.executeScript("return jQuery.active");
			System.out.println(jQueryStatus);
			if (jQueryStatus == 0)
				break;
			else if(i==10)
				break;
			else
				wait(1);
		}
		// String docState = "return document.readyState";
		// String docState = js.executeScript("return document.readyState").toString();
		// System.out.println(docState);
	}

}
