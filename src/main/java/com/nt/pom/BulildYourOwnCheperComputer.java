package com.nt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BulildYourOwnCheperComputer {

	@FindBy(xpath = "//input[@value='65']")
	private WebElement processorFast;

	@FindBy(xpath = "//input[@value='91']")
	private WebElement ram8Gb;

	@FindBy(xpath = "//input[@value='58']")
	private WebElement hdd400Gb;

	@FindBy(xpath = "//input[@value='94']")
	private WebElement softwareOfficeSuite;

	@FindBy(xpath = "//input[@id='addtocart_72_EnteredQuantity']")
	private WebElement quntityChenge;

	@FindBy(xpath = "//input[contains(@value,'Add to cart')]")
	private WebElement addToCartInBuildComputerPage;

	@FindBy(xpath = "//input[@value='52']")
	private WebElement processorSlow;

	@FindBy(xpath = "//input[@value='54']")
	private WebElement ram2Gb;

	@FindBy(xpath = "//input[@value='57']")
	private WebElement hdd320Gb;

	@FindBy(xpath = "//input[@value='93']")
	private WebElement softwareImageViever;

	public BulildYourOwnCheperComputer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProcessorfast() {
		return processorFast;
	}

	public WebElement getRam8Gb() {
		return ram8Gb;
	}

	public WebElement gethdd400Gb() {
		return hdd400Gb;
	}

	public WebElement getSoftwareOfficeSuite() {
		return softwareOfficeSuite;
	}

	public WebElement getQuntityChenge() {
		return quntityChenge;
	}

	public WebElement getAddToCartInBuildComputerPage() {
		return addToCartInBuildComputerPage;
	}

	public WebElement getProcessorSlow() {
		return processorSlow;
	}

	public WebElement getRam2Gb() {
		return ram2Gb;
	}

	public WebElement getHdd320Gb() {
		return hdd320Gb;
	}

	public WebElement getSoftwareImageViever() {
		return softwareImageViever;
	}

}
