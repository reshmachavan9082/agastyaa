package com.agastyaa.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import agastyaa.TestBase;

public class WatFor {
	private static FluentWait<WebDriver>wait;
	static {
		wait=new FluentWait<WebDriver>(TestBase.getDriver());
		wait.withTimeout(Duration.ofSeconds(60));
	}
	
	public static void staleElement(WebElement elemnt) {
		wait.until(ExpectedConditions.stalenessOf(elemnt));

	}

}
