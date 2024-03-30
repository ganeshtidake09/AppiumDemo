package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateCalc {

	public static void main(String[] args) throws MalformedURLException, InterruptedException 
	{
		//This is code for starting the calculator application of your mobile phone by sing apppackage and appActivity desired capabilities
				DesiredCapabilities capabilities =new DesiredCapabilities();
				capabilities.setCapability("deviceName","samsung SM-J810G");
				capabilities.setCapability("platformName", "android");
				capabilities.setCapability("automationName", "uiautomator2");
				capabilities.setCapability("platformversion", "10");
				capabilities.setCapability("appPackage","com.sec.android.app.popupcalculator"); //this is real calcultor of my phone
				capabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
				
				URL url = URI.create("http://127.0.0.1:4723/").toURL(); //url from appium server .toURL is used for typecast of that url
				
				AndroidDriver driver = new AndroidDriver(url, capabilities);
				System.out.println("Calculator Application starts");
				
				//Click on number 8
				WebElement num8=driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_08")); //this is resource id of 8 
				num8.click(); //perform click action on number 8
				
				//click on + sign
				WebElement plussign =driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")); //this is resource id  of plus
				plussign.click(); //perform click action on plus sign
				
				//click on number 2
				WebElement num2 =driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_02"));//this is resource id of 2
				num2.click(); //perform click action on number 2
				
				//click 0n equal sign
				WebElement equalsign =driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));//this is resource id of equal sign
				equalsign.click(); //perform click action on plus sign
				
				//click on result section
				WebElement result = driver.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_edt_formula"));//this is resource id result location
				String resultString = result.getText();
				
				if(resultString.equals("10"))
				{
					System.out.println("Pass");
				}
				else
				{
					System.out.println("Fail");
				}
				Thread.sleep(10000);
				
				driver.quit(); //close session
	

	}

}
