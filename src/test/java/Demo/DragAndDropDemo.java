package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class DragAndDropDemo 
{

	public static void main(String[] args) throws MalformedURLException, InterruptedException
	{
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
		
		//Click on Drag and Drop 
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();

		WebElement source = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]")); //Source 
		
		WebElement destination  = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]")); //Target
		
		//By using touch action class
	       TouchAction action = new TouchAction(driver);

	   		action.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
	
			 Thread.sleep(2000);
	        driver.quit();//CLOSE SESSION
	}
		
}


