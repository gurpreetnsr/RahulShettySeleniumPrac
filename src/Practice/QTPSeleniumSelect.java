package Practice;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class QTPSeleniumSelect {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.qtpselenium.com/contact-us");
		System.out.println(driver.getTitle());
		
		WebElement countryDropDown = driver.findElement(By.name("country_id"));
		
		Select countrySelect = new Select(countryDropDown);
		System.out.println(countryDropDown.findElements(By.tagName("option")).size());
		System.out.println(countrySelect.getOptions().size());
		countrySelect.selectByVisibleText("India");
		Date d = new Date();
		String date = d.toString().replace(" ", "_").replace(":", "_");		
		System.out.println(countrySelect.getFirstSelectedOption().getText());
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\rajdeep\\eclipse-workspace\\RahulShettySeleniumPrac\\Screenshots\\"+date+".png"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
