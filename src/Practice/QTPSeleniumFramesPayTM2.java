package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QTPSeleniumFramesPayTM2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://paytm.com/");
		System.out.println(driver.getTitle());
		// Thread.sleep(2000);
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div._3ac-")));
		driver.findElement(By.cssSelector("div._3ac-")).click();
		
		int frameSize = driver.findElements(By.tagName("iframe")).size();
		
		for(int i =0; i <frameSize; i++)
		{
		//	driver.w
			
		}
		
		
		driver.switchTo().frame(0);
		List<WebElement> frameElements = driver.findElements(By.cssSelector("div.content.ng-scope li span"));
		int k = 0;
		while (k < frameElements.size())
		{
			System.out.println(frameElements.get(k).getText());
			k++;
		}
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("a[title=Close")).click();
		driver.findElement(By.cssSelector("button._3y9b._1wLi._2vdF")).click();
		
	//	driver.close();
			
	}

}
