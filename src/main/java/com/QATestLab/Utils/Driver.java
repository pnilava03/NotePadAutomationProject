package com.QATestLab.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class Driver {

	@SuppressWarnings("rawtypes")
	public static WindowsDriver driver = null;
	public static Properties prop= new Properties();
	static{
		try {
			prop.load(new FileInputStream("./resources/config/configFile.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void startApplication(String applicationPath) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", applicationPath);
		caps.setCapability("platform", prop.getProperty("Platform_Name"));
		caps.setCapability("deviceName", prop.getProperty("Device_Name"));
		driver = new WindowsDriver(new URL(prop.getProperty("WinDriver_URL")), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void closeTheApplication() {
		Driver.driver.quit();
	}
}

