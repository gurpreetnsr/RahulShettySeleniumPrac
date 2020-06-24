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

public class RedifffTableDemo {

	public static void main(String[] args) throws InterruptedException {
		String companyToCheck = "Hathway Cable & Data";
		
		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		System.out.println(driver.getTitle());
		
		List<WebElement> companyNames = driver.findElements(By.cssSelector("#leftcontainer table.dataTable tbody tr td:nth-child(1)"));
		List<WebElement> currentPrices = driver.findElements(By.cssSelector("#leftcontainer table.dataTable tbody tr td:nth-child(4)"));
		
		System.out.println(companyNames.size());
		System.out.println(currentPrices.size());
		
		int i =0;
		while(i< companyNames.size()) {
			//System.out.println(companyNames.get(i).getText());
			if(companyNames.get(i).getText().contains(companyToCheck)) 
			{
				System.out.println(companyNames.get(i).getText() + " ***** " + currentPrices.get(i).getText());
				break;
			}
			i++;
		}

		

		
	}

}
