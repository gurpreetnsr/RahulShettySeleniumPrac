package rediffMoneyTestcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
			driver = new FirefoxDriver();
		} else
			System.out.println(browser + " could not be found.");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://in.rediff.com/");

		// Clicking on the Money link
		driver.findElement(By.cssSelector(".cell.topicons a:nth-child(2)")).click();
		driver.findElement(By.cssSelector("span#signin_info a")).click();
		driver.findElement(By.cssSelector("input#useremail")).sendKeys("gurpreetnsrsel@gmail.com");
		driver.findElement(By.cssSelector("input#userpass")).sendKeys("gurpreet@2550");
		driver.findElement(By.cssSelector("input#rememberflag")).click();
		driver.findElement(By.cssSelector("input#loginsubmit")).click();
		WebElement createPortfolioButton = driver.findElement(By.cssSelector("a#createPortfolio"));
		
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a#createPortfolio")).click();
		driver.findElement(By.cssSelector("input[name='create']")).clear();
		driver.findElement(By.cssSelector("input[name='create']")).sendKeys("MyFirstPortfolio7");
		driver.findElement(By.cssSelector("input#createPortfolioButton")).click();
	}
	
	public void clickAndWait(String cssExp, String cssTarget, int maxTime)
	{
		driver.findElement(By.cssSelector("createPortfolioButton")).click();
	}

}
