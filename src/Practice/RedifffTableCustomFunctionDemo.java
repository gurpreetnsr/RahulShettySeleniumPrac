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

public class RedifffTableCustomFunctionDemo {
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
		
		int rowNumber = getRowNumber("Star Cement");
		System.out.println(rowNumber);
		String currentPrice = driver.findElement(By.cssSelector("#leftcontainer table.dataTable tbody tr:nth-child("+rowNumber+") td:nth-child(4)")).getText();
		System.out.println(currentPrice);
	}
	
	public static int getRowNumber(String toSearch)
	{
		List<WebElement> allRows = driver.findElements(By.cssSelector("#leftcontainer table.dataTable tbody tr"));
		for(int rowNum = 0; rowNum < allRows.size(); rowNum++)
		{
			WebElement row = allRows.get(rowNum);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(int cellNum =0; cellNum <cells.size(); cellNum ++)
			{
				String cellValue = cells.get(cellNum).getText();
				if(cellValue.contains(toSearch))
				{
					return rowNum+1;
				}
			}
		}
		
		return -1;
		
	}
}
