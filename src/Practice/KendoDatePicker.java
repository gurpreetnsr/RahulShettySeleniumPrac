package Practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KendoDatePicker {

	public static void main(String[] args) throws InterruptedException, ParseException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demos.telerik.com/kendo-ui/datetimepicker/index");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector(".k-icon.k-i-calendar")).click();
		String dateToSelectText = "05/01/2014";
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToSelect = sdf.parse(dateToSelectText);
		
		String dayToSelect = new SimpleDateFormat("d").format(dateToSelect);
		String monthToSelect = new SimpleDateFormat("MMM").format(dateToSelect);
		String yearToSelect = new SimpleDateFormat("yyyy").format(dateToSelect);
		//Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("div[data-role='calendar'] .k-header a:nth-child(2)")).getText());

		driver.findElement(By.cssSelector("div[data-role='calendar'] .k-header a:nth-child(2)")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		while(true) 
		{
			
			//Thread.sleep(1000);
			String monthYearDisplayed = driver.findElement(By.cssSelector("div[data-role='calendar'] .k-header a:nth-child(2)")).getText();
			System.out.println(monthYearDisplayed);
			
			if(monthYearDisplayed.equalsIgnoreCase(yearToSelect))
			{
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='k-content k-meta-view k-year']//a[text()='"+monthToSelect+"']")));
				driver.findElement(By.xpath("//table[@class='k-content k-meta-view k-year']//a[text()='"+monthToSelect+"']")).click();
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//table[@class='k-content k-month']//a[text()='"+dayToSelect+"']")));
				driver.findElement(By.xpath("//table[@class='k-content k-month']//a[text()='"+dayToSelect+"']")).click();
				break;
			}
			else
			{
				if(Integer.parseInt(yearToSelect.trim()) < Integer.parseInt(monthYearDisplayed.trim()) )
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-role='calendar'] .k-header a:nth-child(1) span")));
					driver.findElement(By.cssSelector("div[data-role='calendar'] .k-header a:nth-child(1) span")).click();
				}
				else if (Integer.parseInt(yearToSelect.trim()) > Integer.parseInt(monthYearDisplayed.trim()) )
				{
					wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[data-role='calendar'] .k-header a:nth-child(3) span")));
					driver.findElement(By.cssSelector("div[data-role='calendar'] .k-header a:nth-child(3) span")).click();
				}
					
			}
		
		
		}

	}

}
