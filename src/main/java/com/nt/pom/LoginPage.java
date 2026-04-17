package com.nt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(css = "#Email")
	private WebElement email;

	@FindBy(css = "#Password")
	private WebElement password;

	@FindBy(css = "input[value='Log in']")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
}
