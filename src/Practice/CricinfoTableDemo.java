package Practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricinfoTableDemo {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebBrowsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/22711/rsaixi-vs-eng-2-day-practice-match-england-tour-of-south-africa-2019-20");

		WebElement tableOne = driver
				.findElement(By.cssSelector("div[id='innings_1'] div.cb-col.cb-col-100.cb-ltst-wgt-hdr"));
		List<WebElement> runsScored = tableOne.findElements(By.cssSelector("div.cb-col.cb-col-8.text-right.text-bold"));
		int runsScoredSize = runsScored.size();
		int k = 1;
		int totalRunsScored = Integer.parseInt(runsScored.get(runsScoredSize - 1).getText());
		int runsToAdd = 0;
		while (k < runsScored.size() - 1) {
			runsToAdd = runsToAdd + Integer.parseInt(runsScored.get(k).getText());
			k++;
		}
		System.out.println("Total runs " + totalRunsScored);
		System.out.println("Total of all runs " + runsToAdd);
		if(totalRunsScored == runsToAdd) 
			System.out.println("Total is matching !");
		else
			System.out.println("Total is not matching");
	}

}
