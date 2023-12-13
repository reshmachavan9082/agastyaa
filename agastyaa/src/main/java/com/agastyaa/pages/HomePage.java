package com.agastyaa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.agastyaa.utilities.WatFor;

public class HomePage {

	@FindBy(css = "input#woocommerce-product-search-field-0")
	WebElement searchComponent;

	@FindBy(css = "div.storefront-sorting+ul.products>li:nth-child(1)>a.add_to_cart_button")
	WebElement addToCartBtn;
	
	@FindBy(css="h2[class*='title']")
	
	List<WebElement> productTitles;

	public void searchProduct(String productName) {

		searchComponent.sendKeys(productName);
		searchComponent.sendKeys(Keys.ENTER);
		System.out.println("Entered the product name " + productName + " to click");
	}

	public void clickOnAddToCartBtn() {
		addToCartBtn.click();

	}
	
	public List<String> getProductTitles() {
		List<String>titles=new ArrayList<>();
		for (WebElement productTitle:productTitles) {
			String text=null;
			try {
				text=productTitle.getText();
			}catch(StaleElementReferenceException e)
			{
				WatFor.staleElement(productTitle);
				text=productTitle.getText();
			}
			titles.add(text);
			
		}
		return titles;
	}
	
	

}
