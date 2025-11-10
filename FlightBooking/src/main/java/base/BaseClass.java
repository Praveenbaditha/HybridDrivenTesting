package base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utils.FileLib;


public class BaseClass {
	public static WebDriver driver=new ChromeDriver();
	
	@BeforeClass
	public void openBrowser() throws IOException
	{
		FileLib f=new FileLib();
		String url = f.readPropertyData("url");
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterClass
	public void closeBrowser()
	{
			driver.quit();
	}
}
