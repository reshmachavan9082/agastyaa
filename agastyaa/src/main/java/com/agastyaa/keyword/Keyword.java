package com.agastyaa.keyword;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import agastyaa.TestBase;

public class Keyword extends TestBase {

	public void enterText(WebElement e, String textToEnter) {

		e.sendKeys(textToEnter);//e.sendKeys("sneakers")

	}

	public WebElement getWebElement(String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("id")) {

			return driver.findElement(By.id(locatorValue));

		} else if (locatorType.equalsIgnoreCase("xpath")) {

			return driver.findElement(By.xpath(locatorValue));

		} else if (locatorType.equalsIgnoreCase("css")) {

			return driver.findElement(By.cssSelector(locatorValue));

		} else

			return null;

	}

	public void enterText(String locatorType, String locatorValue, String textToEnter) {

		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);

	}

	public void click(String locatorType, String locatorValue) {

		getWebElement(locatorType, locatorValue).click();

	}

	public String getText(String locatorType, String locatorValue) {

		return getWebElement(locatorType, locatorValue).getText();

	}

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {

		if (locatorType.equalsIgnoreCase("id")) {

			return driver.findElements(By.id(locatorValue));

		} else if (locatorType.equalsIgnoreCase("xpath")) {

			return driver.findElements(By.xpath(locatorValue));

		} else if (locatorType.equalsIgnoreCase("css")) {

			return driver.findElements(By.cssSelector(locatorValue));

		} else

			return null;

	}

	public List<String> getTexts(String locatorType, String locatorValue) {

		List<WebElement> data = getWebElements(locatorType, locatorValue);

		List<String> stringdata = new ArrayList();

		for (WebElement element : data) {

			stringdata.add(element.getText());

		}

		return stringdata;//list of string titles

	}

	public void enterText(String locator, String textToEnter) {

		String parts[] = locator.split("##");

		enterText(parts[0], parts[1], textToEnter);

	}

	public void click(String locator) {

		String parts[] = locator.split("##");

		click(parts[0], parts[1]);

	}

	public List<String> getTexts(String locator) {

		String parts[] = locator.split("##");

		return getTexts(parts[0], parts[1]);

	}
	public void launchUrl(String url) {
		TestBase.driver.get(url);

	}

	public void openBrowser(String browserName) {
		// TODO Auto-generated method stub
		
	}
	

}
