package com.nt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RockabillyPage {

	@FindBy(id = "product_attribute_5_7_1")
	private WebElement sizeDropDown;

	@FindBy(xpath = "//input[contains(@class,'button-1 add-to-cart-button')]")
	private WebElement addToCartRockabillyPage;

	public RockabillyPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSizeDropDown() {
		return sizeDropDown;
	}

	public WebElement getAddToCartRockabillyPage() {
		return addToCartRockabillyPage;
	}

}
