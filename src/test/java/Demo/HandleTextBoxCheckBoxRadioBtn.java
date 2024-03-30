package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HandleTextBoxCheckBoxRadioBtn {

	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
		//This is code for starting the Api Demos application of your mobile phone by using appPackage and appActivity desired capabilities
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
				Thread.sleep(5000);
				System.out.println("ApiDemos.apk Application starts");
				
				//Click on view button
				driver.findElements(By.id("android:id/text1")).get(11).click(); //Here used findElements methods because of all attributes resource id is same
				
				//click on controls button
				driver.findElements(By.id("android:id/text1")).get(4).click(); //Again use elements methods and controls index is 4
		
				//click on light theme
				driver.findElements(By.id("android:id/text1")).get(0).click();
				
				//enter text in text box
				driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Ganesh");
				
				//Checkbox
				driver.findElement(By.id("io.appium.android.apis:id/check1")).click();

				//RadioButton
				driver.findElement(By.id("io.appium.android.apis:id/radio2")).click();

				System.out.println("All elements are Handled");
				Thread.sleep(5000);
				
				driver.quit();

	}

}
