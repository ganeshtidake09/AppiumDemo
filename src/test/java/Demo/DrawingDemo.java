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

public class DrawingDemo {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		//This is code for starting the Api Demos application of your mobile phone by using appPackage and appActivity desired capabilities
		DesiredCapabilities capabilities =new DesiredCapabilities();
		capabilities.setCapability("deviceName","samsung SM-J810G");
		capabilities.setCapability("platformName", "android");
		capabilities.setCapability("automationName", "uiautomator2");
		capabilities.setCapability("platformversion", "10");
		
	//	com.saucelabs.mydemoapp.rn/com.saucelabs.mydemoapp.rn.MainActivity
		capabilities.setCapability("appPackage","com.saucelabs.mydemoapp.rn"); //this is real calcultor of my phone
		capabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
		
		URL url = URI.create("http://127.0.0.1:4723/").toURL(); //url from appium server .toURL is used for typecast of that url
		
		AndroidDriver driver = new AndroidDriver(url, capabilities);
		System.out.println("Application starts");
		
		//Click on Menu which is located on top right then: show the all attributes
		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView")).click();
		Thread.sleep(1000);
		
		//click on Drawing element
		WebElement drawing =driver.findElement(By.xpath("//android.widget.TextView[@text=\"Drawing\"]"));
		drawing.click();
		
		//find drawing panel
		WebElement drawingpanel = driver.findElement(By.xpath("//android.webkit.WebView[@text=\"Signature Pad demo\"]/android.view.View/android.view.View/android.widget.Image[3]"));
		
		Point location = drawingpanel.getLocation();//point at top left corner 
		
		//height and width of drawing panel
		Dimension size = drawingpanel.getSize();
		
		//find the position where you need to touch
		int startX = (location.x + (size.getWidth()/2));
		int startY = location.y + 100;
		
		//position till you want to move your finger to swipe/drwa
		int endX = startX;
		int endY = (location.y + (size.getHeight()));
		
		//PointerInput class to create a sequence of actions
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,"finger1");
		
		//sequence object which is a list of actions that will be performed on the device
		Sequence sequence = new Sequence(finger1,1)
		             .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX,startY))
		             .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		             .addAction(new Pause(finger1,Duration.ofMillis(200)))//wait for some time
		             .addAction(finger1.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(),endX,endY))
		             .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	
		//perform sequence of Actions
		driver.perform(Arrays.asList(sequence));
		Thread.sleep(5000);
		
		
		
	}

}
