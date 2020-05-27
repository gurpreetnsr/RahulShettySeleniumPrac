package Practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAssignment {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebBrowsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");

		int tableRows = driver.findElements(By.cssSelector("table#product tr")).size();
		System.out.println("Row count is " + tableRows);

		int tableCols = driver.findElements(By.cssSelector("table#product tr:nth-child(1) th")).size();
		System.out.println("Column count is " + tableCols);
		
		List<WebElement> secondRowElements = driver.findElements(By.cssSelector("table#product tr:nth-child(3) td"));
		int cell =0;
		while(cell < secondRowElements.size())
		{
			System.out.print (secondRowElements.get(cell).getText() +  " *** ");
			cell++;
		}
		

	}

}
