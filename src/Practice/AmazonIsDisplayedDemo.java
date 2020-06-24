package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonIsDisplayedDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());

		WebElement signIn = driver.findElement(By.cssSelector("a#nav-link-accountList"));
		WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
		
		System.out.println(driver.findElement(By.xpath("//span[text()='Your Seller Account']")).isDisplayed());
		Actions act = new Actions(driver);
		act.moveToElement(signIn).build().perform();
		System.out.println(driver.findElement(By.xpath("//span[text()='Your Seller Account']")).isDisplayed());
		

	}

}
