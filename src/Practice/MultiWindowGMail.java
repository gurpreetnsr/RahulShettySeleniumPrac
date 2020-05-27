package Practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MultiWindowGMail {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signup");
		System.out.println(driver.getTitle());
		driver.findElement(By.cssSelector("ul.Bgzgmd>li:nth-child(1)>a")).click();
		Set<String> handles = driver.getWindowHandles();

		Iterator<String> it = handles.iterator();
		String mainWindowHandle = it.next();
		String firstChildWindow = it.next();
		
		driver.switchTo().window(firstChildWindow);
		System.out.println(driver.getTitle());
		driver.switchTo().window(mainWindowHandle);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(firstChildWindow);
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(mainWindowHandle);
		System.out.println(driver.getTitle());
		}

	}
