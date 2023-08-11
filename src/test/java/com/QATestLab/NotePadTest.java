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

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() throws MalformedURLException {
		Driver.startApplication("C:\\\\Windows\\\\notepad.exe");
	}

	@AfterMethod
	public void cleanUp() throws MalformedURLException {
		Driver.driver.quit();
		setUp();
	}

	@AfterSuite
	public void tearDown() {
		Driver.driver.quit();
	}

	@Test(priority = 1)
	public void open_NewWindowFromFileMenu() {
		Driver.driver.findElement(By.name("File")).click();
		Driver.driver.findElement(By.name("Add New Tab")).click();

	}

	@Test(priority = 2)

	public void typeOnNotePad() throws InterruptedException {
		Thread.sleep(5000);
		Driver.driver.findElement(By.name("Maximize")).click();
		Thread.sleep(2000);

//		  driver.findElement(By.className("RichEditD2DPT")).sendKeys("Hello");
//		  driver.findElement(By.name("File")).click();
//		  driver.findElement(By.name("Save")).click();

		Driver.driver.findElement(By.name("File")).click();
		Driver.driver.findElement(By.name("Page setup")).click();
		Driver.driver.findElement(By.name("Cancel")).click();

		Driver.driver.findElement(By.name("Edit")).click();
		Driver.driver.findElement(By.name("Time/Date")).click();

	}

}
