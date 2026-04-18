package com.nt.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCardPage {

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement removeCheckBox;

	@FindBy(xpath = "//input[@value='Update shopping cart']")
	private WebElement updateShoppingCart;

	@FindBy(xpath = "//input[@id='termsofservice']")
	private WebElement termsCheakBox;

	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement chekOut;

	@FindBy(css = ".order-summary-content")
	private WebElement emptyCardMsg;

	@FindBy(xpath = "//span[@class='product-unit-price']")
	private List<WebElement> allPriceShoppingCart;

	@FindBy(xpath = "//input[@name='removefromcart']")
	private List<WebElement> allremoveCheckBox;

	public ShoppingCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRemoveCheckBox() {
		return removeCheckBox;
	}

	public WebElement getUpdateShoppingCart() {
		return updateShoppingCart;
	}

	public WebElement getTermsCheckBox() {
		return termsCheakBox;
	}

	public WebElement getCheckOut() {
		return chekOut;
	}

	public WebElement getEmptyCardMsg() {
		return emptyCardMsg;

	}

	public List<WebElement> getAllPriceShoppingCart() {
		return allPriceShoppingCart;

	}

	public List<WebElement> getAllremoveCheckBox() {
		return allremoveCheckBox;
	}

}
