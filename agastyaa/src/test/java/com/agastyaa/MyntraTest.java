package com.agastyaa;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.agastyaa.keyword.Keyword;
import com.agastyaa.locators.On;
import com.agastyaa.utilities.FileUtil;

import agastyaa.TestBase;

public class MyntraTest extends TestBase {
	@Test
	public void verifySearchResultForSneakersWithoutFramework() {
		getDriver().get("https://www.myntra.com");
		getDriver().findElement(By.xpath("//input[@class=\"desktop-searchBar\"]")).sendKeys("sneakers");
		getDriver().findElement(By.xpath("//a[@class=\"desktop-submit\"]")).click();
		// getDriver().findElement(By.xpath("//span[@class=\"myntraweb-sprite
		// desktop-iconSearch sprites-search\"]")).click();
		
		
		List<WebElement> productList = getDriver()
				.findElements(By.xpath("//div[@class=\"product-productMetaInfo\"]/h4[@class=\"product-product\"]"));
		Iterator<WebElement> itr = productList.iterator();
		while (itr.hasNext()) {
			String productTitle = itr.next().getText();
			System.out.println("Ttitle is: " + productTitle);
			Assert.assertTrue(productTitle.contains("Sneakers"));
		}
		// div[@class="product-productMetaInfo"]/h4[@class="product-product"]
	}
	@Test
	public void verifySearchResultForSneakersUsingFrameWork() throws InterruptedException {
		Keyword keyword = new Keyword();
		keyword.launchUrl("https://www.myntra.com");
		keyword.enterText("xpath", "//input[@class=\"desktop-searchBar\"]", "sneakers"); // locatorType=xpath,locator
		Thread.sleep(2000); // value=xpathvalue
		// textToEnter
		keyword.click("xpath", "//span[@class=\"myntraweb-sprite desktop-iconSearch sprites-search\"]");
		// "//div[@class=\"product-productMetaInfo\"]/h4[@class=\"product-product\"]");
		List<String> productList = keyword.getTexts("xpath",
				"//div[@class=\"product-productMetaInfo\"]/h4[@class=\"product-product\"]");
		Iterator<String> itr = productList.iterator();// change webelemnt to String
		while (itr.hasNext()) {
			String productTitle = itr.next();// no need to getText()
			System.out.println("Ttitle is: " + productTitle);
			Assert.assertTrue(productTitle.contains("Sneakers"));

		}
	}

	// By using interface store locators in interface and send thier variable name
	// in locator value me

	@Test
	public void verifySearchResultForSneakersUsingFrameWorkInterface() {

		Keyword keyword = new Keyword();
		keyword.launchUrl("https://www.myntra.com");
		// keyword.enterText("xpath", On.SEARCHCOMPONENT, "sneakers");//locator
		// type&locator value
		keyword.enterText(On.SEARCHCOMPONENT, "sneakers");// locator &texttoenter
		// keyword.click("xpath",On.MAGNIFIER);// magnifier
		keyword.click(On.MAGNIFIER);// magnifier

		// List<String> productList = keyword.getTexts("xpath", On.PRODUCTTITLE);

		List<String> productList = keyword.getTexts(On.PRODUCTTITLE);
		Iterator<String> itr = productList.iterator();// change webelemnt to String
		while (itr.hasNext()) {
			String productTitle = itr.next();// no need to getText()
			System.out.println("Ttitle is: " + productTitle);
			Assert.assertTrue(productTitle.contains("Sneakers"));

		}
	}

	@Test
	public void verifySearchResultForSneakersUsingFrameWorkInterfaceAndPropertiesFile() throws FileNotFoundException {

		Keyword keyword = new Keyword();
		FileUtil file = new FileUtil();
		//keyword.launchUrl("https://demos.bellatrix.solutions/");
		//keyword.launchUrl("https://www.myntra.com");
		// keyword.enterText("xpath", On.SEARCHCOMPONENT, "sneakers");
		keyword.enterText(file.getLocator("HomePage.SEARCHCOMPONENT"), "sneakers");// locatorType=xpath,locator
																					// value=xpathvalue
		// textToEnter
		// keyword.click("xpath",On.MAGNIFIER);// magnifier
		keyword.click(file.getLocator("HomePage.MAGNIFIER"));
		// file chi getlocator method ani tya method key pass hotey ji ke locator.prop
		// file madhle :HomePage.MAGNIFIER

		// List<String> productList = keyword.getTexts("xpath", On.PRODUCTTITLE);

		List<String> productList = keyword.getTexts(file.getLocator("HomePage.PRODUCTTITLE"));
		Iterator<String> itr = productList.iterator();// change webelemnt to String
		while (itr.hasNext()) {
			String productTitle = itr.next();// no need to getText()
			System.out.println("Ttitle is: " + productTitle);
			Assert.assertTrue(productTitle.contains("Sneakers"));

		}
	}
}
