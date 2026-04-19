package com.nt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {

	@FindBy(id = "gender-male")
	private WebElement maleRedioButton;

	@FindBy(id = "gender-female")
	private WebElement femaleRedioButton;

	@FindBy(name = "FirstName")
	private WebElement firstName;

	@FindBy(name = "LastName")
	private WebElement lastName;

	@FindBy(name = "Email")
	private WebElement email;

	@FindBy(css = "#Password")
	private WebElement password;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPassword;

	@FindBy(css = "#register-button")
	private WebElement registerButton;

	public Register(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMaleRedioButton() {
		return maleRedioButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getlastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}

	public WebElement getFemaleRedioButton() {
		return femaleRedioButton;
	}

}
