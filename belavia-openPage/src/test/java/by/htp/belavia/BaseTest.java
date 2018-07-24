package by.htp.belavia;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class BaseTest {

	private static final String CHROME = "webdriver.chrome.driver";
	private static final String CHROME_PATH = "/Users/elenaskorodilo/Documents/chromedriver";
	
	protected WebDriver driver;
	
	@BeforeTest
	public void setUpTest() {
		System.setProperty(CHROME, CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void finish() {
		driver.close();	
	}
	

}
