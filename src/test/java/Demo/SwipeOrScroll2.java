package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeOrScroll2 {

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
				
				//Get Scrren size
				Dimension size = driver.manage().window().getSize();
				System.out.println("Dimesions of your device" +size);
				//find the position where you need to touch
				int startX = size.getWidth()/2;
				int startY = size.getHeight()/2;
				System.out.println(startX);

				//position till you want to move your finger to swipe
				int endX = startX; //same rahega bhai 
				int endY = (int) (size.getHeight() * 0.25); //onefourth of total screen size
				TouchAction touchAction = new TouchAction(driver);
				touchAction.press(PointOption.point(startX, startY))
				         //  .waitAction(waitOptions.withDuration(Duration.ofMillis(1000)))
				           .moveTo(PointOption.point(endX, endY))
				           .release()
				           .perform();
				//Code is not working 

	}

}
