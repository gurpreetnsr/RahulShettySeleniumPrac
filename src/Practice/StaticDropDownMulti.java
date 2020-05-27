package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDownMulti {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://output.jsbin.com/osebed/2");
		
		Select currencySelect = new Select(driver.findElement(By.id("fruits")));
		Thread.sleep(500);
		currencySelect.selectByVisibleText("Banana");
		Thread.sleep(500);
		currencySelect.selectByValue("apple");
		Thread.sleep(500);
		currencySelect.selectByIndex(3);
		List<WebElement> selectedItems = currencySelect.getAllSelectedOptions();
		System.out.println(selectedItems.size());
		int k =0;
		while(k<selectedItems.size()) {
			System.out.println("Selected items is " + selectedItems.get(k).getText());
			k++;
		}

	}

}
