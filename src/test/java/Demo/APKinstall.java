package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class APKinstall {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		//This code is for installing the apk files in virtual device
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability("deviceName","samsung SM-J810G");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("app", "C:\\Users\\hp\\Desktop\\Appium\\ApkFiles\\calculator.apk");
		capabilities.setCapability("platformversion", "10");
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL(); //url from appium server .toURL is used for typecast of that url
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		Thread.sleep(5000);
		System.out.println("Application starts");
		driver.quit();

	}

}
