package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class UtilityClass {
	WebDriver driver=BaseClass.driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	public void waitForTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));		
	}
	public void waitForElement(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));		
	}
	public void waitForEle(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));		
	}
}
