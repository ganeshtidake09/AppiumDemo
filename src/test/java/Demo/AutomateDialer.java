package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateDialer {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		//This is code for starting the phone dialer application of your mobile phone by using appPackage and appActivity desired capabilities
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability("deviceName","samsung SM-J810G");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("platformversion", "10");
	//	 com.samsung.android.dialer/com.samsung.android.dialer.DialtactsActivity
		capabilities.setCapability("appPackage","com.samsung.android.dialer"); //this is real calcultor of my phone
		capabilities.setCapability("appActivity", "com.samsung.android.dialer.DialtactsActivity");
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL(); //url from appium server .toURL is used for typecast of that url
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		Thread.sleep(5000);
		System.out.println("Dialer Application starts");
		//8972067632
	//	com.samsung.android.dialer:id/zero
		//inspect all numbers
		//098100 12345
		driver.findElement(By.id("com.samsung.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/nine")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/eight")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/one")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/zero")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/one")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/two")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/three")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/four")).click();
		driver.findElement(By.id("com.samsung.android.dialer:id/five")).click();
		
		//click on call button
		driver.findElement(By.id("com.samsung.android.dialer:id/dialButtonImage1")).click();

		Thread.sleep(10000);
		
		driver.quit(); //close session
		

	}

}
