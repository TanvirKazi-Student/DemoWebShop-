package com.nt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(linkText = "Register")
	private WebElement RegisterLink;
	@FindBy(css = ".result")
	private WebElement registerSuccess;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRegisterLink() {
		return RegisterLink;
	}

	public WebElement getRegisterSuccess() {
		return registerSuccess;
	}

}
