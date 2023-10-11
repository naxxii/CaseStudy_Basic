package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
		public static WebDriver driver;
		
		public String baseURLFlipkart="https://www.flipkart.com/";
		
		@BeforeSuite		
		public void BaseCls() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(opt);
		
	}
		@AfterSuite
		public void tearDown() {
			driver.quit();
		}
}

