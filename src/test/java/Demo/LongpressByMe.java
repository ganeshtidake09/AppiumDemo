package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class LongpressByMe {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		//Gather all desired capabilities here and launch the application by ysing AndroidDriver

				DesiredCapabilities capabilities =new DesiredCapabilities();
				capabilities.setCapability("deviceName","samsung SM-J810G");
				capabilities.setCapability("platformName", "android");
				capabilities.setCapability("automationName", "uiautomator2");
				capabilities.setCapability("platformversion", "10");
				
			//	io.appium.android.apis/io.appium.android.apis.ApiDemos
				capabilities.setCapability("appPackage","io.appium.android.apis"); //this is real calcultor of my phone
				capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
				
				URL url = URI.create("http://127.0.0.1:4723/").toURL(); //url from appium server .toURL is used for typecast of that url
				
				AndroidDriver driver = new AndroidDriver(url, capabilities);
				Thread.sleep(2000);
				System.out.println("ApiDemos.apk Application starts");
			
				//Click on view button
				driver.findElements(By.id("android:id/text1")).get(11).click(); //Here used findElements methods because of all attributes resource id is same
				Thread.sleep(2000);
				
				//click on Expandable list
				driver.findElements(By.id("android:id/text1")).get(8).click(); //Here used findElements methods because of all attributes resource id is same

				//Click on 1.custom Adapter
				driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]")).click();
				
				//click on people Names and create webElement of that tab
				WebElement We1 = driver.findElement(By.xpath("//android.widget.TextView[@text=\"People Names\"]"));
				
				//This is the code you can use for long press
		
				//1st Approch
			//	driver.executeScript("mobile:longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)We1).getId(),"duration",2000)); //Here We1 is the WebElement of the which element you want to press long that is 

				//2nd  Approch
				((JavascriptExecutor)driver).executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId",((RemoteWebElement)We1).getId(),"duration",2000));
				System.out.println("Long press is done ");
	}

}
