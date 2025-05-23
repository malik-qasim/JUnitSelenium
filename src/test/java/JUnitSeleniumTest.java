import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.UUID;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class JUnitSeleniumTest {

	@Test
	void test_login_with_incorrect_credentials() {
		//System.setProperty("webdriver.chrome.driver", "usr/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
        	options.addArguments("--headless");               // Run in headless mode
        	options.addArguments("--no-sandbox");             // For Ubuntu
        	options.addArguments("--disable-dev-shm-usage");  // Overcome limited resource problems
        	options.addArguments("--disable-gpu");            // GPU issues
		//String userDataDir = "/tmp/chrome-profile-" + UUID.randomUUID();
        	//options.addArguments("--user-data-dir=" + userDataDir);
		WebDriver driver = new ChromeDriver(options);
		driver.navigate().to("https://myrealtordash.clareityiam.net/idp/login");
		driver.findElement(By.name("username")).sendKeys("1234567");
		driver.findElement(By.name("password")).sendKeys("abcdefg");
		driver.findElement(By.id("loginbtn")).click();
		//*[@id="form_login"]/div[5]/div
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		assert(driver.findElement(By.id("error")).isDisplayed()==true);
		//	System.out.println("Login with Incorrect Credentials: Passed");
		//else
		//	System.out.println("Login with Incorrect Credentials: Failed");
		driver.quit();
	}
}
