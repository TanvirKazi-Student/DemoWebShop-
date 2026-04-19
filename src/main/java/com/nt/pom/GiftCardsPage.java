package com.nt.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardsPage {

	@FindBy(xpath = "//input[@value='Add to cart']")
	private List<WebElement> allAddToCartGiftCartPage;

	public GiftCardsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getAllAddToCartGiftCartPage() {
		return allAddToCartGiftCartPage;
	}

}
