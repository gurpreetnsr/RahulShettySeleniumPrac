package Practice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class GreenKartCheckSorting {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		System.out.println(driver.getTitle());

		List<WebElement> originalItemsList = driver
				.findElements(By.cssSelector("table#sortableTable tbody tr td:nth-child(2)"));
		ArrayList<String> orignalList = new ArrayList<String>();
		for (int i = 0; i < originalItemsList.size(); i++) {
			orignalList.add(originalItemsList.get(i).getText());
		}
		ArrayList<String> listToSort = new ArrayList<String>();
		for (int i = 0; i < orignalList.size(); i++) {
			listToSort.add(orignalList.get(i));
		}

		Collections.sort(listToSort);
		if (orignalList.equals(listToSort))
			System.out.println("Items are sorted");
		else
			System.out.println("Items are not sorted");
		System.out.println("***** Original List ***********");
		for( String s : orignalList )
		{
			System.out.println(s);
		}
		
		System.out.println("***** Sorted List ***********");
		for( String s : listToSort )
		{
			System.out.println(s);
		}
	}

}
