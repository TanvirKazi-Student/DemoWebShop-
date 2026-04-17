package com.nt.pom;

import java.awt.print.PageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCardPage {

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBox;

	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement updateShoppingCart;

	public ShoppingCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCheckBox() {
		return checkBox;
	}
	public WebElement getUpdateShoppingCart() {
		return updateShoppingCart;
	}
}
