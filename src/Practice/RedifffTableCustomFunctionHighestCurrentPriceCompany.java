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

public class RedifffTableCustomFunctionHighestCurrentPriceCompany {
	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa?src=gain_lose");
		System.out.println(driver.getTitle());
		
		int rowNumber = getHighestPrice();
		System.out.println(rowNumber);
		String currentPrice = driver.findElement(By.cssSelector("#leftcontainer table.dataTable tbody tr:nth-child("+rowNumber+") td:nth-child(4)")).getText();
		String companyName = driver.findElement(By.cssSelector("#leftcontainer table.dataTable tbody tr:nth-child("+rowNumber+") td:nth-child(1)")).getText();
		
		System.out.println(companyName + " ***** " + currentPrice);
	}
	
	public static int getHighestPrice()
	{
		double highestPrice = Double.parseDouble(driver.findElement(By.cssSelector("#leftcontainer table.dataTable tbody tr:nth-child(1) td:nth-child(4)")).getText());
		List<WebElement> allPrices = driver.findElements(By.cssSelector("#leftcontainer table.dataTable tbody tr td:nth-child(4)"));
		int highestCurrentPriceRow =0;
		for(int rowNum = 0; rowNum < allPrices.size(); rowNum++)
		{
			Double currentPrice = Double.parseDouble(allPrices.get(rowNum).getText().replace(",",""));
			if(currentPrice > highestPrice)
			{
				highestPrice = currentPrice;
				highestCurrentPriceRow = rowNum +1;
			}
		}
		return highestCurrentPriceRow;
		
	}
}
