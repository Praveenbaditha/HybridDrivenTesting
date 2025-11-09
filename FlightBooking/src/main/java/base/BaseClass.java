package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	public static WebDriver driver=new ChromeDriver();
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
			//driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
			//driver.quit();
	}
}
