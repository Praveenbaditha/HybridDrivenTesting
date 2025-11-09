package utils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;

public class ListenerImplementation implements ITestListener {
	WebDriver driver=BaseClass.driver;
	@Override
	public void onTestFailure(ITestResult result) {
		String name=result.getName();
		String timeStamp = LocalDateTime.now().toString().replace(":","-");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des=new File("./screenshots/"+name+timeStamp+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
		}
	}
}
