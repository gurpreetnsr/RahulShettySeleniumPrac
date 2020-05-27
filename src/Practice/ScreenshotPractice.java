package Practice;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotPractice {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\WebBrowsers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		
		Date d = new Date();
		System.out.println(d.toString());
		String fileName = d.toString().replace(" ", "_").replace(":", "_");
		System.out.println(fileName);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
		try {
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\" + fileName + ".png"));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

}
