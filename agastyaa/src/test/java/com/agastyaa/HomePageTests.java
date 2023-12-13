package com.agastyaa;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.agastyaa.pages.HomePage;

import agastyaa.TestBase;

public class HomePageTests extends TestBase {
	
	@Test 
	
	public void verifySearchResultOnSearchingFalcon() {
		HomePage homepage=PageFactory.initElements(getDriver(), HomePage.class);//getdriver and jo class ka object banana hai uska name
		homepage.searchProduct("falcon");//initelemnt method set proxy for each webelement
		List<String>productTtitles=homepage.getProductTitles();
		
		for (String productTtitle: productTtitles) {
			Assert.assertTrue(productTtitle.contains("falcon"));
			
		}

	}

}
