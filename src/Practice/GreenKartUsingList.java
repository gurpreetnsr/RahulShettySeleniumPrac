package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GreenKartUsingList {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		System.out.println(driver.getTitle());
		String itemMainXPath = "//h4[contains(text(),'Brocolli')]/parent::div";
		int k =1;
		while(k <3)
		{
			driver.findElement(By.xpath(itemMainXPath +"/div[2]/a[2]")).click();
			k++;
		}
		driver.findElement(By.xpath(itemMainXPath+"/div[3]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		Thread.sleep(2000);
		Select country = new Select(driver.findElement(By.cssSelector("select[style='width: 200px;']")));
		country.selectByVisibleText("India");
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}

}
