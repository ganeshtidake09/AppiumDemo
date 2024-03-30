package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;




import io.appium.java_client.android.AndroidDriver;

public class SwipeOrScroll {

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
		
		//PointerInput class to create a sequence of actions 
				PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");//in kind what action you performing i.e touch
				
				//Sequence object, which is a list of actions that will be performed on the device
				Sequence sequence = new Sequence(finger1, 1) //input device(pointerinput),initial lengh
						.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))//move your finger on scrren(viewport) at center startX,startY this are center locations 
						.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))//createpointerdown it is used for touch the screen
						.addAction(new Pause(finger1, Duration.ofMillis(200))) //wait for some time
						.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))//move your curser kini der and kahatak end point
						.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); //Release your pointer (pointer up)

				//perform the Sequence of action
				driver.perform(Collections.singletonList(sequence)); //by using collection perform these all actions
				
				
				Thread.sleep(2000);
				driver.quit();
		
		
		
		
	}

}
