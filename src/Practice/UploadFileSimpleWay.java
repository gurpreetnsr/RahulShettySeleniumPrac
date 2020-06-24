package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadFileSimpleWay {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/upload/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("input#uploadfile_0")).sendKeys("C:\\Users\\rajdeep\\Desktop\\Upload.txt");
		
		driver.findElement(By.cssSelector("input#terms")).click();
		driver.findElement(By.cssSelector("button#submitbutton")).click();
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("h3#res center"))));
		System.out.println(driver.findElement(By.cssSelector("h3#res center")).getText());
		
		

	}

}
