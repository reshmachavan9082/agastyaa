package com.agastyaa.stepDefinitions;


import com.agastyaa.keyword.Keyword;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FirstDefStep {

	Keyword keyword = new Keyword();

	@Given("open chrome browser")
	public void m1() {

		keyword.openBrowser("Chrome");
		System.out.println("Hello cucumber");

	}

	@When("application url will open")
	public void launchAppUrl() {
		
		keyword.launchUrl("https://www.myntra.com/");
		System.out.println("");

	}
	
	@Given("chrome browser ope")
	public void m2() {
		// TODO Auto-generated method stub

	}

}
