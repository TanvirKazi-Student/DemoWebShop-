package com.nt.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparelShoesPage {

	@FindBy(xpath = "//input[contains(@value,'Add to cart')]")
	private List<WebElement> addToCartApparelShoesPage;

	public ApparelShoesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAddToCartApparelShoesPage() {
		return addToCartApparelShoesPage;
	}

}
