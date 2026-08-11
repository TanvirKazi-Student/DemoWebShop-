package script;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nt.baseclass.DwsBase;
import com.nt.pom.BulildYourOwnCheperComputerPage;
import com.nt.pom.GiftCardsPage;
import com.nt.pom.HomePage;
import com.nt.pom.LoginPage;
import com.nt.pom.ShoppingCardPage;
import com.nt.pom.VirtualGiftCardPage;

public class ShoppingCart extends DwsBase {

	@Test(enabled = false)
	public void addRemoveGiftCard() throws InterruptedException {
		String expectedUrl = "https://demowebshop.tricentis.com/";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "DWS home page dose not displayed");
		HomePage home = new HomePage(driver);
		home.getAddTocartHomePage().click();
		VirtualGiftCardPage virtual = new VirtualGiftCardPage(driver);
		virtual.getRecipName().sendKeys("Rohan");
		virtual.getRecipEmail().sendKeys("rohan@gmail.com");
		virtual.getYourName().sendKeys("Tanvir");
		virtual.getYourEmail().sendKeys("tanvirkazi2786@gmail.com");
		virtual.gettextArea().sendKeys("this is the important for user");
		WebElement quntityInput = virtual.getQuntityInput();
		quntityInput.clear();
		quntityInput.sendKeys("2");
		virtual.getAddToCardVirtualGiftCard().click();
		WebElement addCardMsg = virtual.getAddCardMsg();
		assertTrue(addCardMsg.getText().contains("The product has been added to your "),
				"Product dose not added successfully");
		Thread.sleep(3000);
		home.getShoppingCartLink().click();
		ShoppingCardPage shopping = new ShoppingCardPage(driver);
		List<WebElement> removeCheckBox = shopping.getRemoveCheckBox();
		removeCheckBox.get(0).click();
		shopping.getUpdateShoppingCart().click();
		WebElement emptyCartMsg = shopping.getEmptyCardMsg();
		assertTrue(emptyCartMsg.getText().contains("Your Shopping Cart is empty"), "Cart is not empty");
	}

	@Test(enabled = false)
	public void addGiftCardProduct() throws InterruptedException {
		HomePage home = new HomePage(driver);
		Thread.sleep(2000);
		WebElement giftCardsLink = home.getGiftCardsLink();
		giftCardsLink.click();
		GiftCardsPage giftCart = new GiftCardsPage(driver);
		List<WebElement> allAddToCartGiftCartPage = giftCart.getAllAddToCartGiftCartPage();
		for (int i = 0; i < 2 && i < allAddToCartGiftCartPage.size(); i++) {
			WebElement web = allAddToCartGiftCartPage.get(i);
			web.click();
			VirtualGiftCardPage virtual = new VirtualGiftCardPage(driver);
			virtual.getRecipName().sendKeys("Rohan");
			virtual.getRecipEmail().sendKeys("rohan@gmail.com");
			virtual.getYourName().sendKeys("Tanvir");
			virtual.getYourEmail().sendKeys("tanvirkazi2786@gmail.com");
			virtual.gettextArea().sendKeys("this is the important for user");
			WebElement quntityInput = virtual.getQuntityInput();
			quntityInput.clear();
			quntityInput.sendKeys("2");
			virtual.getAddToCardVirtualGiftCard().click();
			driver.navigate().back();
		}
		for (int i = 2; i < 4 && i < allAddToCartGiftCartPage.size(); i++) {
			WebElement web = allAddToCartGiftCartPage.get(i);
			web.click();
			VirtualGiftCardPage virtual = new VirtualGiftCardPage(driver);
			virtual.getRecipName().sendKeys("Rohan");
			virtual.getYourName().sendKeys("Tanvir");
			virtual.gettextArea().sendKeys("this is the important for user");
			WebElement quntityInput = virtual.getQuntityInput();
			quntityInput.clear();
			quntityInput.sendKeys("2");
			virtual.getAddToCardVirtualGiftCard().click();
			driver.navigate().back();
		}
	}

	@Test(enabled = false)
	public void buildCheapComputer() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.getBuildYourOwnCheapComputerlink().click();
		BulildYourOwnCheperComputerPage build = new BulildYourOwnCheperComputerPage(driver);
		build.getProcessorfast().click();
		build.getRam8Gb().click();
		build.gethdd400Gb().click();
		build.getSoftwareOfficeSuite().click();
		WebElement quntityChange = build.getQuntityChenge();
		quntityChange.clear();
		quntityChange.sendKeys("2");
		build.getAddToCartInBuildComputerPage().click();
		Thread.sleep(4000);
		home.getShoppingCartLink().click();
		ShoppingCardPage digital = new ShoppingCardPage(driver);
		digital.getTermsCheckBox().click();
		digital.getCheckOut().click();
	}

	@Test(enabled = false, priority = 1)
	public void login() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.getloginLink().click();
		String expectedUrl = "https://demowebshop.tricentis.com/login";
		String actualUrl = driver.getCurrentUrl();
		assertEquals(actualUrl, expectedUrl, "login page dose not displayed");
		LoginPage login = new LoginPage(driver);
		login.getEmail().sendKeys("tanvirkazi2786@gmail.com");
		login.getPassword().sendKeys("tanvir@123");
		login.getLoginButton().click();
		String expectedMsg = "Log out";
		String actualMsg = home.getLogoutLink().getText();
		assertEquals(actualMsg, expectedMsg, "login dose not successfully");
	}

	@Test(enabled = false, priority = 0)
	public void add$25GiftCard() throws InterruptedException {
		String expectedUrl = "https://demowebshop.tricentis.com/";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "DWS home page dose not displayed");
		login();
		HomePage home = new HomePage(driver);
		home.getBuildYourOwnCheapComputerlink().click();
		BulildYourOwnCheperComputerPage build = new BulildYourOwnCheperComputerPage(driver);
		build.getProcessorSlow().click();
		build.getRam2Gb().click();
		build.getHdd320Gb().click();
		build.getSoftwareImageViever().click();
		WebElement quntityChange = build.getQuntityChenge();
		quntityChange.clear();
		quntityChange.sendKeys("3");
		build.getAddToCartInBuildComputerPage().click();
		Thread.sleep(4000);
		home.getShoppingCartLink().click();
		ShoppingCardPage digital = new ShoppingCardPage(driver);
		List<WebElement> removeCheckBox = digital.getRemoveCheckBox();
		removeCheckBox.get(0).click();
		digital.getUpdateShoppingCart().click();
		ShoppingCardPage shoping = new ShoppingCardPage(driver);
		WebElement emptyCartMsg = shoping.getEmptyCardMsg();
		assertTrue(emptyCartMsg.getText().contains("Your Shopping Cart is empty"), "Cart is not empty");
		Thread.sleep(3000);
		home.getLogoutLink().click();
	}

}
