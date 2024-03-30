package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DragAndDropW3CActions {

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
		Thread.sleep(5000);
		System.out.println("ApiDemos.apk Application starts");
	
		//Click on view button
		driver.findElements(By.id("android:id/text1")).get(11).click(); //Here used findElements methods because of all attributes resource id is same
		Thread.sleep(2000);
		
		//Click on Drag and Drop 
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]")).click();

		WebElement source = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]")); //Source 
		
		WebElement destination  = driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]")); //Target
		//find center of source and target web element
	       Point sourceElementCenter = getCenter(source);
			Point targetElementCenter = getCenter(destination);
			
			//PointerInput class to create a sequence of actions 
			//that move the pointer to the center of the element, 
			//press down on the element, and then release the element.

			
			PointerInput finger1 = new PointerInput (PointerInput.Kind.TOUCH,"finger1");
			
			//Sequence object, which is a list of actions that will be performed on the device

			Sequence sequence = new Sequence (finger1, 1)
					
					//move finger to the starting position
					.addAction (finger1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
					
					
					//finger coming down to contact with screen
					.addAction (finger1.createPointerDown(PointerInput.MouseButton. LEFT.asArg()))
					
					.addAction(new Pause(finger1, Duration.ofMillis(588)))
					
					//move finger to the end position
					.addAction(finger1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), targetElementCenter))
					
					//move the finger up
					.addAction (finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			//perform sequence of actions
			//driver.perform(Collections.singletonList(sequence));
		//
			driver.perform(Arrays.asList(sequence));
			Thread.sleep(2000);
			
			driver.quit(); //close session
		
		

	}
	//Create a method for center point of source or destination 
	private static Point getCenter(WebElement element)
	{
		//get location of the element
		Point location = element.getLocation();
		
		//get dimension (height & width of the element)
		Dimension size = element.getSize();
		
		//center point
		Point center = new Point (location.x + size.width/2, location.y + size.height/2);
		
		return center;
		
	}

}
