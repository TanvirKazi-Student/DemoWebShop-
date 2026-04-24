package com.nt.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigitalDownloadsPage {

	@FindBy(xpath = "//h1[text()='Digital downloads']")
	private WebElement digitalDowonloadText;

	@FindBy(xpath = "//span[@class='price actual-price']")
	private List<WebElement> allPrice;

	@FindBy(xpath = "//input[@value='Add to cart']")
	private List<WebElement> allAddToCarts;

	@FindBy(id = "products-orderby")
	private WebElement sortbyDropdown;

	@FindBy(id = "products-pagesize")
	private WebElement displayDropdown;

	@FindBy(xpath = "//select[@id='products-viewmode']")
	private WebElement viewAsDropdown;

	public DigitalDownloadsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getDigitalDowonloadText() {
		return digitalDowonloadText;
	}

	public List<WebElement> getAllPrice() {
		return allPrice;
	}

	public List<WebElement> getAllAddToCarts() {
		return allAddToCarts;
	}

	public WebElement getSortbyDropdown() {
		return sortbyDropdown;
	}

	public WebElement getDisplayDropdown() {
		return displayDropdown;
	}

	public WebElement getViewAsDropdown() {
		return viewAsDropdown;
	}
}
