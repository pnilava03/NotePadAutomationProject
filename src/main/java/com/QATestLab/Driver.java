package com.QATestLab;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.windows.WindowsDriver;

public class Driver {

	public static WindowsDriver driver = null;
	
	public static void startApplication(String applicationPath) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("app", applicationPath);
		caps.setCapability("platform", "Windows");
		caps.setCapability("deviceName", "WindowsPC");
		driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}

