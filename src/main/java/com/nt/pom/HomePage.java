package com.nt.pom;

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
	
	@FindBy(xpath = "//input[@value=\\\"Add to cart\\\"]")
	private WebElement addTocartHomePage;

	@FindBy(className ="cart-label")
	private WebElement shoppingCartLink;
	
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
	
	public WebElement getAddTocart() {
		return addTocartHomePage;
	}
	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
		
	}
	

}
