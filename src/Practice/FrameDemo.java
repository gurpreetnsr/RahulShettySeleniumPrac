package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FrameDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/droppable/");
		System.out.println(driver.getTitle());


		driver.switchTo().frame(0);
	//	driver.switchTo().fra
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame"));
		WebElement draggable= driver.findElement(By.cssSelector("div#draggable"));
		WebElement droppable = driver.findElement(By.cssSelector("div#droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(draggable, droppable).build().perform();
	

	}

}
