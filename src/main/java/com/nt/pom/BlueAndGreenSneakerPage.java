package com.nt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueAndGreenSneakerPage {

	@FindBy(id = "product_attribute_28_7_10")
	private WebElement sizeDropDown;

	@FindBy(xpath = "(//span[contains(@class,'color-container')])[3]")
	private WebElement color;

	@FindBy(xpath = "//input[contains(@class,'button-1 add-to-cart-button')]")
	private WebElement addToCartBlueAndGreenSneakerPage;

	public BlueAndGreenSneakerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSizeDropDown() {
		return sizeDropDown;
	}

	public WebElement getColor() {
		return color;
	}

	public WebElement getAddToCartBlueAndGreenSneakerPage() {
		return addToCartBlueAndGreenSneakerPage;
	}

}
