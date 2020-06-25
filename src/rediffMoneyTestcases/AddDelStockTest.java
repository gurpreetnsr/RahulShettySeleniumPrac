package rediffMoneyTestcases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddDelStockTest {
	WebDriver driver = null;

	@Test(priority = 1)
	public void addStockTest() {
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
		// waitForPageToLoad();
		Select portFoliosList = new Select(driver.findElement(By.cssSelector("#portfolioid")));
		portFoliosList.selectByVisibleText("MyFirstPortfolio3");
		driver.findElement(By.cssSelector("input#addStock")).click();
		driver.findElement(By.cssSelector("input#addstockname")).sendKeys("Tata");
		selectStock("Tata Steel Ltd.");

		selectDate("25/06/2020");

	}

	public void selectDate(String string) {
		Date currentDate = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToSelect = null;
		try {
			dateToSelect = sd.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String dayToSelect = new SimpleDateFormat("d").format(dateToSelect);
		String monthToSelect = new SimpleDateFormat("MMMM").format(dateToSelect);
		String yearToSelect = new SimpleDateFormat("yyyy").format(dateToSelect);
		String monthYearToSelect = monthToSelect + " " + yearToSelect;
		System.out.println(dayToSelect + " " + monthToSelect + " " + yearToSelect);
		driver.findElement(By.cssSelector("div.stockCtnt div.floatL a")).click();
		// System.out.println(actualYear);
		while (true) {
			String actualMonthYear = driver.findElement(By.cssSelector("table.dpTable div")).getText();
			String actualYear = actualMonthYear.split(" ")[1];
			if (actualMonthYear.equalsIgnoreCase(monthYearToSelect)) {
				driver.findElement(
						By.xpath("//table[@class='dpTable']//td/div[text()='" + dayToSelect + "']"))
						.click();
				break;
			} else {
				if(Integer.parseInt(yearToSelect) < Integer.parseInt(actualYear))
				{
					driver.findElement(By.cssSelector(".dpTitleTR td:nth-child(2) button")).click();
				}
				else if (Integer.parseInt(yearToSelect) < Integer.parseInt(actualYear))
				{
					driver.findElement(By.cssSelector(".dpTitleTR td:nth-child(4) button")).click();
				}

			}
		}

	}

	public void selectStock(String stockName) {
		List<WebElement> stocks = driver.findElements(By.cssSelector("div#ajax_listOfOptions div"));
		for (WebElement stock : stocks) {
			if (stock.getText().equalsIgnoreCase(stockName))
				stock.click();

		}
	}

	public void waitForPageToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int i = 1;
		while (true) {
			i++;
			long jQueryStatus = (long) js.executeScript("return jQuery.active");
			System.out.println(jQueryStatus);
			if (jQueryStatus == 0)
				break;
			else if (i == 10)
				break;
			else
				wait(1);
		}
		// String docState = "return document.readyState";
		// String docState = js.executeScript("return document.readyState").toString();
		// System.out.println(docState);
	}

	public void waitForItemInDropDown(String expected) {
		for (int i = 1; i <= 10; i++) {
			Select portFoliosList = new Select(driver.findElement(By.cssSelector("#portfolioid")));
			System.out.println(portFoliosList.getFirstSelectedOption().getText());
			if (portFoliosList.getFirstSelectedOption().getText().equalsIgnoreCase(expected)) {
				return;
			} else {
				wait(1);
			}
		}
		// System.out.println("Out of for loop");
	}

	public void wait(int waitTime) {
		try {
			Thread.sleep(waitTime * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2, dependsOnMethods = { "addStockTest" })
	public void deleteStockTest() {

	}
}
