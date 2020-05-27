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

public class CalendarPractice {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebBrowsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.path2usa.com/travel-companions");
		System.out.println(driver.getTitle());

		driver.findElement(By.cssSelector("#travel_date")).click();
		String dateToSelect = "5-Feb-2021";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		Date d = null;
		try {
			d = sdf.parse(dateToSelect);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(d);
		String month = new SimpleDateFormat("MMMM").format(d);
		System.out.println(month);

		String year = new SimpleDateFormat("yyyy").format(d);
		System.out.println(year);

		String monthYearToSelect = month + " " + year;
		System.out.println(monthYearToSelect);

		while (!driver.findElement(By.cssSelector(".table-condensed .datepicker-switch")).getText()
				.equalsIgnoreCase(monthYearToSelect)) {
			// System.out.println(driver.findElement(By.cssSelector(".table-condensed
			// .datepicker-switch")).getText());
			driver.findElement(By.cssSelector(".table-condensed .next")).click();
		}

		String day = new SimpleDateFormat("d").format(d);
		List<WebElement> days = driver.findElements(By.cssSelector(".table-condensed .day"));
		int k = 0;
		while (k < days.size()) 
		{
			if (days.get(k).getText().equalsIgnoreCase(day)) 
			{
				days.get(k).click();
				break;
			}

			k++;
		}

	}

}
