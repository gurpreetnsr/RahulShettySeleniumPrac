package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;


public class RemoveFirefoxLogs {

	public static void main(String[] args) {


		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rajdeep\\eclipse-workspace\\RahulShettySeleniumPrac\\WebDrivers\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
		
		
		ProfilesIni allProfile = new ProfilesIni();
		FirefoxProfile fp = allProfile.getProfile("Automation");
		fp.setPreference("dom.webnotifications.enabled",false);
		fp.setAcceptUntrustedCertificates(true);
		fp.setAssumeUntrustedCertificateIssuer(false);
		FirefoxOptions fo = new FirefoxOptions();
		fo.setProfile(fp);
	
		
		WebDriver driver = new FirefoxDriver(fo);
		driver.get("https://google.com");
		

	}

}
