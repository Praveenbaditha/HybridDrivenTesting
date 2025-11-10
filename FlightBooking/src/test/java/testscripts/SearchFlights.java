package testscripts;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.GooglePage;
import pages.PaytmFlightResultsPage;
import pages.PaytmHomePage;
import utils.FileLib;
import utils.ListenerImplementation;
import utils.UtilityClass;

@Listeners(utils.ListenerImplementation.class)
public class SearchFlights extends BaseClass{
	
	WebDriver driver = BaseClass.driver;
	PaytmFlightResultsPage results ;
	UtilityClass wait=new UtilityClass();
	FileLib f=new FileLib();
	 @Test()
	 public void searchFlight() throws IOException {
		 	String url = f.readPropertyData("url");
		 	String source = f.readPropertyData("source");
		 	String destination=f.readPropertyData("destination");
	        driver.get(url);
	        PaytmHomePage home = new PaytmHomePage(driver);
	        results = new PaytmFlightResultsPage(driver);
	        wait.waitForElement(home.sourceInput);
	        home.enterSourceCity(source);
	        home.enterDestinationCity(destination);
	        home.chooseFirstDepartureDate();
	        home.clickSearchFlights();
	    }

	  @Test(dependsOnMethods = "searchFlight")
	  public void leastPrice() throws InterruptedException {
	        wait.waitForTitle("Paytm");
	        wait.waitForElement(results.flight1Name);
	        System.out.println(
	            results.getFlight1Name() + " = " + results.getFlight1Price()
	        );
	        System.out.println(
	            results.getFlight2Name() + " = " + results.getFlight2Price()
	        );
	    }

	    @Test(dependsOnMethods = "leastPrice")
	    public void newWindow() {
	        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com')");
	        Set<String> all = driver.getWindowHandles();
	        for (String win : all) {
	            driver.switchTo().window(win);
	        }
	    }

	    @Test(dependsOnMethods = "newWindow")
	    public void navigateToInfrrd() throws InterruptedException {
	        GooglePage google = new GooglePage(driver);
	        google.search("infrrd.ai");
	        wait.waitForTitle("infrrd.ai");
	        wait.waitForElement(google.infrrdLink);
	        google.clickInfrrdResult();
	        String actualTitle="Infrrd";
	        String title = driver.getTitle();
	        Assert.assertTrue(actualTitle.contains(title));
	        System.out.println("Test cases all passed");
	    }

}
