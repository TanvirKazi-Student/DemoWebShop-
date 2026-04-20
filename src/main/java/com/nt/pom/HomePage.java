package com.nt.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Register")
	private WebElement registerLink;

	@FindBy(css = ".result")
	private WebElement registerSuccess;

	@FindBy(linkText = "Log in")
	private WebElement loginLink;

	@FindBy(linkText = "Log out")
	private WebElement logoutLink;

	@FindBy(xpath = "//input[@value=\"Add to cart\"]")
	private WebElement addTocartHomePage;

	@FindBy(xpath = "//a[@class='ico-cart']")
	private WebElement shoppingCartLink;

	@FindBy(xpath = "//a[contains(text(),'Digital downloads')]")
	private WebElement digitalDownloadLink;

	@FindBy(xpath = "//a[text()='Build your own cheap computer']")
	private WebElement buildYourOwnCheapComputerLink;

	@FindBy(linkText = "Gift Cards")
	private WebElement giftCardsLink;

	@FindBy(linkText = "Apparel & Shoes")
	private WebElement apparealShoesLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getRegisterSuccess() {
		return registerSuccess;
	}

	public WebElement getloginLink() {
		return loginLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getAddTocartHomePage() {
		return addTocartHomePage;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;

	}

	public WebElement getDigitalDownloads() {
		return digitalDownloadLink;
	}

	public WebElement getBuildYourOwnCheapComputerlink() {
		return buildYourOwnCheapComputerLink;
	}

	public WebElement getGiftCardsLink() {
		return giftCardsLink;
	}

	public WebElement getapparelShoesLink() {
		return apparealShoesLink;
	}

}
