package Practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class KSRTCAutoSuggest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebBrowsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
		String keysChord = Keys.chord(Keys.SHIFT, "beng");
		driver.findElement(By.cssSelector("input#fromPlaceName")).sendKeys(keysChord);
		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#fromPlaceName")).sendKeys(Keys.DOWN);
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#fromPlaceName")).sendKeys(Keys.DOWN);
//		Thread.sleep(1000);
//		driver.findElement(By.cssSelector("input#fromPlaceName")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.cssSelector("input#fromPlaceName")).getText());
		System.out.println(driver.findElement(By.cssSelector("input#fromPlaceName")).getAttribute("value"));
		
		String script = "return document.getElementById(\"fromPlaceName\").value;";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String value = (String) js.executeScript(script);
		System.out.println("The value is " + value);
		int count =1;
		while(!value.equalsIgnoreCase("BENGALURU INTERNATION AIRPORT"))
		{
			driver.findElement(By.cssSelector("input#fromPlaceName")).sendKeys(Keys.DOWN);
			value = (String) js.executeScript(script);
			System.out.println(value);
			count++;
			if(count >10)
				break;
		}
		if(count>10)
			System.out.println("Element did not exist! Tried " + count + " times.");
		else
			System.out.println("Element found at " + count + " position");
		

	}

}
