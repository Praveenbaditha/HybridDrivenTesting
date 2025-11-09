package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaytmFlightResultsPage {

    @FindBy(xpath = "//section[@id='flightsList']/div[1]//img/following-sibling::div")
    public WebElement flight1Name;

    @FindBy(xpath = "//section[@id='flightsList']/div[1]//span[text()='₹']/..")
    public WebElement flight1Price;

    @FindBy(xpath = "//section[@id='flightsList']/div[2]//img/following-sibling::div")
    public WebElement flight2Name;

    @FindBy(xpath = "//section[@id='flightsList']/div[2]//span[text()='₹']/..")
    public WebElement flight2Price;
    
    public PaytmFlightResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getFlight1Name() 
    { 
    	
    	return flight1Name.getText(); 
    }
    public String getFlight1Price() 
    {
    	return flight1Price.getText(); 
    }
    public String getFlight2Name()
    { 
    	return flight2Name.getText(); 
    }
    public String getFlight2Price() 
    { 
    	return flight2Price.getText(); 
    }
}
