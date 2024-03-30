package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserAutomation {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		//Gather all desired capabilities here and launch the application by ysing AndroidDriver
		
			DesiredCapabilities capabilities =new DesiredCapabilities();
			capabilities.setCapability("deviceName","samsung SM-J810G");
			capabilities.setCapability("platformName", "android");
			capabilities.setCapability("automationName", "uiautomator2");
			capabilities.setCapability("platformversion", "10");
			capabilities.setCapability("browserName", "Chrome");
			capabilities.setCapability("chromedriverExecutable", "C:\\Users\\hp\\Desktop\\Appium\\BrowserAutomation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");//Path of chrome driver which is instlled in your real device

			
			URL url = URI.create("http://127.0.0.1:4723/").toURL(); //url from appium server .toURL is used for typecast of that url
			
			AndroidDriver driver = new AndroidDriver(url, capabilities);
			driver.get("https://www.google.com/");
			//Find search box webElement
			/*Inspecting searchbox of mobile browser
			 * First prerequsite is open or focus your chrome on your mobile 
			 * After that go to desktop 
			 * and type on Url : chrome://inspect/#devices
			 * after that its shows the tabs which is opened in your device 
			 * and then this tabs are displayed bottom of that page 
			 * click on which tab you want to inspect 
			 * after in this inspecting tab is opened in new window session
			 * and find the element by using various locators
			 * and perform the actions
			 * 
			 * */
			WebElement searchBox = driver.findElement(By.name("q"));
			searchBox.sendKeys("Taj Mahal");
			searchBox.sendKeys(Keys.RETURN);
			Thread.sleep(1000);
			System.out.println("Chrome Application started");
		
	

	}

}
