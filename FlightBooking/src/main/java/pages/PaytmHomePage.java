package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.UtilityClass;

public class PaytmHomePage {
	UtilityClass wait=new UtilityClass();
	
	    @FindBy(id = "from")
	    public WebElement sourceInput;

	    @FindBy(id = "text-box")
	    public WebElement citySearchBox;

	    @FindBy(id = "popularCityName")
	    public WebElement firstSuggestedCity;

	    @FindBy(id = "destCode")
	    public WebElement destinationInput;

	    @FindBy(id = "departureDate")
	    public WebElement departureDate;

	    @FindBy(xpath = "(//table[@class='calendar'])[2]//tbody//td[1]")
	    public WebElement firstAvailableDate;

	    @FindBy(id = "flightSearch")
	    public WebElement flightSearchBtn;

	    public void enterSourceCity(String city) {
	    	
	    	wait.waitForElement(sourceInput);
	        sourceInput.click();
	        citySearchBox.sendKeys(city);
	        wait.waitForEle(firstSuggestedCity);
	        firstSuggestedCity.click();
	    }

	    public void enterDestinationCity(String city) {
	        destinationInput.click();
	        citySearchBox.sendKeys(city);
	        wait.waitForEle(firstAvailableDate);
	        firstSuggestedCity.click();
	    }
	    public PaytmHomePage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	    }

	    public void chooseFirstDepartureDate() {
	        departureDate.click();
	        firstAvailableDate.click();
	    }

	    public void clickSearchFlights() {
	        flightSearchBtn.click();
	    }
}
