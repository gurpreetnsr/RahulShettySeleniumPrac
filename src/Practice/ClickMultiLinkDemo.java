package Practice;

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

public class ClickMultiLinkDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		
		WebElement footer = driver.findElement(By.cssSelector("div#gf-BIG table tbody tr td ul"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		List<WebElement> links = footer.findElements(By.tagName("a"));
		int linkSize = links.size();
		int k=1;
		WebDriverWait wait = new WebDriverWait(driver,30);
		while(k < linkSize)
		{
			footer = driver.findElement(By.cssSelector("div#gf-BIG table tbody tr td ul"));
			links = footer.findElements(By.tagName("a"));
			wait.until(ExpectedConditions.elementToBeClickable(links.get(k)));
			links.get(k).click();
			driver.navigate().back();
			k++;
		}


	}

}
