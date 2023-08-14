package com.QATestLab.Test.POM;

import org.openqa.selenium.By;

import com.QATestLab.Utils.Driver;
import com.QATestLab.Utils.ExcelSheet;

public class NotePadElements {

	private By clickOnFile = By.name("File");
	private By clickOnAdd_New_Tab = By.name("Add New Tab");
	private By clickOnMaximize = By.name("Maximize");
	private By clickOnPageSetUp = By.name("Page setup");
	private By clickOnCancel = By.name("Cancel");
	private By clickOnEdit = By.name("Edit");
	private By clickOnTimeAndDate=By.name("Time/Date");
	private By clickOnSettings=By.name("Settings");
	private By clickOnAppTheme=By.name("App theme");
	private By clickOnLightRadioButton=By.name("Light");
	private By clickOnDarkRadioButton=By.name("Dark");
	private By clickOnSystemSettings=By.name("Use system setting");
	private By clickOnExit=By.name("Exit");
	private By clickOnFont=By.name("Font");
	private By clcikOnDropdownValue=By.name("Candara");
	private By clickOnBack=By.name("Back");
		
	
	ExcelSheet excel=new ExcelSheet("excelSheet_Path");

	public void clickOnFileFromNotePadMenuBar() {
		if(excel.getDataFromExcelSheet("testData", 1, 2).equals("File"))
		Driver.driver.findElement(clickOnFile).click();
	}
	
	public void clickOnAdd_New_TabFromNotePadMenuBar() {
		Driver.driver.findElement(clickOnAdd_New_Tab).click();
	}
	
	public void clickOnMaximizeFromNotePad() {
		Driver.driver.findElement(clickOnMaximize).click();
	}
	
	public void clickOnPageSetupFromNotePadMenuBar() {
		Driver.driver.findElement(clickOnPageSetUp).click();
		
		}
	
	public void clickOnCancelButton() {
		Driver.driver.findElement(clickOnCancel).click();
	}
	
	public void clickOnEditFromNotePadMenuBar() {
		Driver.driver.findElement(clickOnEdit).click();
		
	}
	
	public void clickOnTimeAndDateFromNotePadMenuBar() {
		Driver.driver.findElement(clickOnTimeAndDate).click();
	}
	
	public void clickOnSettings() {
		Driver.driver.findElement(clickOnSettings).click();
	}
	
	public void clickOnAppTheme() {
		Driver.driver.findElement(clickOnAppTheme).click();
	}
	
	public void clickOnLight_RadioButton() {
		Driver.driver.findElement(clickOnLightRadioButton).click();
	}
	
	public void clickOnDark_RadioButton() {
		Driver.driver.findElement(clickOnDarkRadioButton).click();
	}
	
	
	
	
	public void changeThemeForNotePad() {
		if(Driver.driver.findElement(clickOnLightRadioButton).isEnabled()||Driver.driver.findElement(clickOnDarkRadioButton).isEnabled())
			Driver.driver.findElement(clickOnSystemSettings).click();
		
	}
	
	public void clikOnExitFromNotePadMenuBar() {
		Driver.driver.findElement(clickOnExit).click();
	}
	
	public void clickOnFontFromNotePad() {
		Driver.driver.findElement(clickOnFont).click();
		
	}
	
	public void clickOnFamilyDropdown() {
		Driver.driver.findElementByAccessibilityId("FontFamilyComboBox").click();
	}
	
	public void selectDropdownValue() {
		Driver.driver.findElement(clcikOnDropdownValue).click();
	}
	
	public void clickOn_Back() {
		Driver.driver.findElement(clickOnBack).click();
	}
		
}

