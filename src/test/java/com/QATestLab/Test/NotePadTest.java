package com.QATestLab.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.QATestLab.Test.POM.NotePadElements;
import com.QATestLab.Utils.CommonMethods;
import com.QATestLab.Utils.Driver;
import com.QATestLab.Utils.ExcelSheet;

import io.appium.java_client.windows.WindowsDriver;

public class NotePadTest {

	NotePadElements notepadElements = new NotePadElements();
	CommonMethods commonMethod = new CommonMethods();
	Properties prop = new Properties();
	ExcelSheet excel= new ExcelSheet("excelSheet_Path");
	{
		try {
			prop.load(new FileInputStream("./resources/config/test.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() throws MalformedURLException {
		Driver.startApplication(prop.getProperty("application_Path"));
	}

	@AfterMethod
	public void cleanUp() throws MalformedURLException {
		Driver.closeTheApplication();
		setUp();
	}

	@AfterSuite
	public void tearDown() {
		Driver.closeTheApplication();
	}

	@Test(priority = 1)
	public void open_NewWindowFromFileMenu() throws InterruptedException {
		Thread.sleep(1000);
		notepadElements.clickOnFileFromNotePadMenuBar();
		Thread.sleep(1000);
		notepadElements.clickOnAdd_New_TabFromNotePadMenuBar();

	}

	@Test(priority = 2)

	public void randomClickOnNotePad() throws InterruptedException {
		Thread.sleep(5000);
		notepadElements.clickOnMaximizeFromNotePad();
		Thread.sleep(2000);

//		  driver.findElement(By.className("RichEditD2DPT")).sendKeys("Hello");
//		  driver.findElement(By.name("File")).click();
//		  driver.findElement(By.name("Save")).click();

		notepadElements.clickOnFileFromNotePadMenuBar();
		Thread.sleep(1000);
		notepadElements.clickOnPageSetupFromNotePadMenuBar();
		Thread.sleep(1000);
		notepadElements.clickOnCancelButton();
		Thread.sleep(1000);
		notepadElements.clickOnEditFromNotePadMenuBar();
		Thread.sleep(1000);
		notepadElements.clickOnTimeAndDateFromNotePadMenuBar();
		Thread.sleep(1000);
		notepadElements.clickOnFileFromNotePadMenuBar();
		Thread.sleep(1000);
		notepadElements.clikOnExitFromNotePadMenuBar();
		Thread.sleep(1000);
		notepadElements.clickOnCancelButton();
		Thread.sleep(1000);
		
	}

	@Test(priority = 3)
	public void changeNotePadTheme() throws InterruptedException {
		Thread.sleep(2000);
		notepadElements.clickOnSettings();
		Thread.sleep(1000);
		notepadElements.clickOnAppTheme();
		Thread.sleep(1000);
		notepadElements.clickOnDark_RadioButton();
		Thread.sleep(1000);
		notepadElements.changeThemeForNotePad();

	}
	
	@Test(priority = 4)
	public void changeNotePadFont() throws InterruptedException {
		Thread.sleep(2000);
		notepadElements.clickOnSettings();
		Thread.sleep(1500);
		notepadElements.clickOnFontFromNotePad();
		Thread.sleep(1500);
		notepadElements.clickOnFamilyDropdown();
		Thread.sleep(1500);
		notepadElements.selectDropdownValue();
		Thread.sleep(1500);
		notepadElements.clickOn_Back();
	}
	
	

}
