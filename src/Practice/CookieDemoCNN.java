package Practice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CookieDemoCNN {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Web Drivers\\For Chrome 83\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());

		Set<Cookie> cookies =  driver.manage().getCookies();
		
		Iterator<Cookie> it = cookies.iterator();
		
		while(it.hasNext())
		{
			Cookie c = it.next();
			System.out.println(c.getName() + " ***** " + c.getValue());
			if(c.getName().equalsIgnoreCase("i18n-prefs"))
			{
				driver.manage().deleteCookie(c);
			}
			
		}

	}

}
