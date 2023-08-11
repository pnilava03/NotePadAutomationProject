package com.QATestLab;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class NotePadTest {

	public static WindowsDriver driver = null;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", "C:\\Windows\\notepad.exe");
		caps.setCapability("platform", "Windows");
		caps.setCapability("deviceName", "WindowsPC");

		driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), caps);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void cleanUp() throws MalformedURLException {
		driver.quit();
		setUp();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void open_NewWindowFromFileMenu() {
		driver.findElement(By.name("File")).click();
		driver.findElement(By.name("Add New Tab")).click();

	}

	@Test(priority = 2)

	public void typeOnNotePad() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.name("Maximize")).click();
		Thread.sleep(2000);

//		  driver.findElement(By.className("RichEditD2DPT")).sendKeys("Hello");
//		  driver.findElement(By.name("File")).click();
//		  driver.findElement(By.name("Save")).click();
		
		driver.findElement(By.name("File")).click();
		driver.findElement(By.name("Page setup")).click();
		driver.findElement(By.name("Cancel")).click();

		driver.findElement(By.name("Edit")).click();
		driver.findElement(By.name("Time/Date")).click();
	
	}

}
