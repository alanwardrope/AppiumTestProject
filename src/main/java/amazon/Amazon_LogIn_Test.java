package amazon;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * Created by Alan_Wardrope on 23/12/2016.
 */
public class Amazon_LogIn_Test {

    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "4.4.2");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", "C:\\Apps\\Amazon\\Amazon_App.apk");
        capabilities.setCapability("appPackage", "uk.amazon.mShop.android");
        capabilities.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
        //capabilities.setCapability("avd", "emulator-5554");

        String amazonUserName = "awardrope@hotmail.com";
        String amazonPassword = "57Falkirk";

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        Thread.sleep(5000);

        // Click on Home Menu to display Menu
        driver.findElementById("uk.amazon.mShop.android:id/action_bar_burger_icon").click();
        // Click on Department Menu to invoke the sub-menu of departments
        driver.findElement(By.name("Shop by Department")).click();
        // Click on Home Menu to display Main Menu
        driver.findElementById("uk.amazon.mShop.android:id/action_bar_burger_icon").click();
        // Click on Hello, Sign In
        driver.findElement(By.name("Hello. Sign In")).click();


        /**
        // Click on Shop by Deparment link
        driver.findElementById("uk.amazon.mShop.android:id/web_home_shop_by_department_label").click();
        // Click on Main menu
        driver.findElementByClassName("android.widget.ImageView").click();
        // Click on Home link under Main menu
        driver.findElement(By.name("Home")).click();
        // Click on Sign In link on the Home Screen
        driver.findElementByName("Sign inHello. Link").click();
        **/

        // Entering UserName using Parent node strategy
        WebElement parentElement = driver.findElement(By.name("Amazon Sign In"));
        List<WebElement> childElements = parentElement.findElements(By.className("android.view.View"));
        WebElement mainElement = childElements.get(5);
        mainElement.findElement(By.className("android.widget.EditText")).sendKeys(amazonUserName);
        // Entering Password using Xpath & Sibling strategy
        driver.findElementByXPath("//android.view.View[@content-desc='Amazon password']/following-sibling::android.view.View/android.widget.EditText").sendKeys(amazonPassword);
        // Click on Sign In button
        driver.findElement(By.name("Submit")).click();


        // This is to kill the Android driver
        driver.quit();


    }

}