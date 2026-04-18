package com.nt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VirtualGiftCard {

	@FindBy(xpath = "//input[@class='recipient-name']")
	private WebElement recipName;

	@FindBy(xpath = "//input[@class='recipient-email']")
	private WebElement recipEmail;

	@FindBy(xpath = "//input[@class='sender-name']")
	private WebElement senderName;

	@FindBy(xpath = "//input[@class='sender-email']")
	private WebElement senderEmail;

	@FindBy(xpath = "//textarea[@class='message']")
	private WebElement textArea;

	@FindBy(xpath = "//input[@class='qty-input']")
	private WebElement quntityInput;

	@FindBy(xpath = "//input[@value='Add to cart']")
	private WebElement addToCardVirtualGiftCard;

	@FindBy(xpath = "//p[@class='content']")
	private WebElement addCardMsg;

	public VirtualGiftCard(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRecipName() {
		return recipName;
	}

	public WebElement getRecipEmail() {
		return recipEmail;

	}

	public WebElement getYourName() {
		return senderName;

	}

	public WebElement getYourEmail() {
		return senderEmail;

	}

	public WebElement getQuntityInput() {
		return quntityInput;

	}

	public WebElement gettextArea() {
		return textArea;

	}

	public WebElement getAddToCardVirtualGiftCard() {
		return addToCardVirtualGiftCard;
	}

	public WebElement getAddCardMsg() {
		return addCardMsg;
	}

}
