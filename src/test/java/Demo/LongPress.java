package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;

public class LongPress {
	static AndroidDriver driver;
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
				
                driver= new AndroidDriver(url, capabilities);
				Thread.sleep(5000);
				System.out.println("Dialer Application starts");
				
				driver.findElement(By.id("com.samsung.android.dialer:id/zero")).click();
				driver.findElement(By.id("com.samsung.android.dialer:id/nine")).click();
				driver.findElement(By.id("com.samsung.android.dialer:id/eight")).click();
				driver.findElement(By.id("com.samsung.android.dialer:id/one")).click();
				driver.findElement(By.id("com.samsung.android.dialer:id/zero")).click();
				driver.findElement(By.id("com.samsung.android.dialer:id/zero")).click();
				driver.findElement(By.id("com.samsung.android.dialer:id/one")).click();
	            driver.findElement(By.id("com.samsung.android.dialer:id/two")).click();
	            
	/*			
				WebElement backbtn = driver.findElement(By.id("com.samsung.android.dialer:id/delete_button_image"));
				// Approch 1: longpress on backspace button
				driver.executeScript("mobile:longClickGesture",ImmutableMap.of("elementId",((RemoteWebElement)backbtn).getId(),"duration",2000)); //Here We1 is the WebElement of the which element you want to press long that is 
    */
	            
	            //Approch2 by using longpress method 
	            WebElement backspacebtn = driver.findElement(By.id("com.samsung.android.dialer:id/delete_button_image"));
	            backspacebtn.click();
				Thread.sleep(2000);
				longPress(backspacebtn);
				Thread.sleep(2000);

				driver.close();
				
	}
	//by using W3C Method
	static void longPress(WebElement e1) {
		//Find the location of webElement
	    Point location = e1.getLocation();
	    PointerInput finger =new PointerInput(PointerInput.Kind.TOUCH,"finger");
	    
	    Sequence longpress  = new Sequence(finger,1);
	    longpress.addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),location.x,location.y));
	    longpress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));//for press 
	    longpress.addAction(finger.createPointerMove(Duration.ofMillis(1000),PointerInput.Origin.viewport(),location.x,location.y));//For longpress i.e 1000 ms
	    longpress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	  //perform the Sequence of action
		driver.perform(Collections.singletonList(longpress)); //by using collection perform these all actions
	    
	    
	}
	

}
