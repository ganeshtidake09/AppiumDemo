package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class DropDownDemo {

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
		Thread.sleep(1000);
		System.out.println("ApiDemos.apk Application starts");
	
		//Click on view button
		driver.findElements(By.id("android:id/text1")).get(11).click(); //Here used findElements methods because of all attributes resource id is same
		Thread.sleep(1000);
		
		//Click on Controls
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Controls\"]")).click();
		
		//Click on Light Theme
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Light Theme\"]")).click();

		//1. Approch 
		//click on mercury dropdown
		WebElement dropdown = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"));
		dropdown.click();
		
		Thread.sleep(2000);
		//click on Earth
		WebElement earthoption = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Earth\"]"));
		earthoption.click();
	

		

		System.out.println("Dropdown completed");
		Thread.sleep(5000);
		


	}

}
