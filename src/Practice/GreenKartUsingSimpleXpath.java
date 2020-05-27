package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GreenKartUsingSimpleXpath {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		System.out.println(driver.getTitle());
		String[] productsToFind = { "Brocolli", "Cauliflower", "Cucumber", "Walnuts", "Cashews", "Carrot", "Brocolli",
				"Onion" };
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement> buttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));

		for (int i = 0; i < productsToFind.length; i++) {
			System.out.println(productsToFind[i]);
			int k = 0;
			while (k < products.size()) {
				System.out.println(products.get(k).getText());
				if (products.get(k).getText().contains(productsToFind[i])) 
				{
					System.out.println("You have found " + productsToFind[i] + " at " + k);
					Actions act = new Actions(driver);
					act.moveToElement(buttons.get(k)).perform();
					Thread.sleep(1000);
					buttons.get(k).click();
					break;
				}
				k++;
			}

		}

	}

}
