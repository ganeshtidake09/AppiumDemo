package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Switchhandling {

	public static void main(String[] args) throws InterruptedException, MalformedURLException
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
		Thread.sleep(2000);

		//scroll on web page
				String MobElementToScroll = "Switches";
			
				WebElement SwitchElement = driver.findElement(AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))" +
								".scrollIntoView(new UiSelector().text(\"" + MobElementToScroll + "\"))"));
				
				SwitchElement.click();
		
		//click on Monitored switch button
		 WebElement monitorSwitch =  driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
		 if(monitorSwitch.isSelected()==true)
		 {
			 System.out.println("Monitored switch is on ");
		 }
		 else
		 {
			 System.out.println("Monitored switch is Off,Doing switch On");
			 monitorSwitch.click();
			 System.out.println("Right now ON");

		 }


	Thread.sleep(5000);
	driver.quit();

	}

}
