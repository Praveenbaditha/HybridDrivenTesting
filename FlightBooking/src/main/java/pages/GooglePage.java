package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    @FindBy(tagName = "textarea")
    public WebElement searchBox;

    @FindBy(xpath = "//h3[contains(text(),'Infrrd | Enterprise Document')]")
    public WebElement infrrdLink;

    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void search(String query) {
        searchBox.sendKeys(query, Keys.ENTER);
    }
    public void clickInfrrdResult() {
        infrrdLink.click();
    }
}

