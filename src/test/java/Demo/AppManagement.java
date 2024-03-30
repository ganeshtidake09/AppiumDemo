package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppManagement {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		
		//Gather all desired capabilities here and launch the application by ysing AndroidDriver
		
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability("deviceName","samsung SM-J810G");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("platformversion", "10");

		
		URL url = URI.create("http://127.0.0.1:4723/").toURL(); //url from appium server .toURL is used for typecast of that url
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		Thread.sleep(1000);
		
	
		//	io.appium.android.apis/io.appium.android.apis.ApiDemos (Apppackeage/AppActivity) finds by using cmd
		String packageName = "io.appium.android.apis";
		
		//Terminate  the app
		driver.terminateApp(packageName); //only for termination following code is disabled.
/*		
		driver.removeApp(packageName);
		System.out.println("App successfully removed");
		Thread.sleep(2000);
		if(!driver.isAppInstalled(packageName))
		{
		//installApp by using 
		driver.installApp("C:\\Users\\hp\\Desktop\\Appium\\ApkFiles\\ApiDemos-debug.apk");
		System.out.println("Application installed successful");
		}
		else
		{
			System.out.println("App already installed");
		}
		//activate the application
		driver.activateApp(packageName);
		System.out.println("Application Activated successful");
*/
		
		
		Thread.sleep(2000);
		driver.quit();

	}

}
