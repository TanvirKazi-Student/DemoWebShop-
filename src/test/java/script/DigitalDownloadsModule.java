package script;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.nt.baseclass.DwsBase;
import com.nt.pom.ApparelShoesPage;
import com.nt.pom.BlueAndGreenSneakerPage;
import com.nt.pom.DigitalDownloadsPage;
import com.nt.pom.HomePage;
import com.nt.pom.LoginPage;
import com.nt.pom.RockabillyPage;
import com.nt.pom.ShoppingCardPage;

public class DigitalDownloadsModule extends DwsBase {

	

	@Test(enabled = false)
	public void digitalDownloads() {
		HomePage home = new HomePage(driver);
		home.getDigitalDownloads().click();
		DigitalDownloadsPage digital = new DigitalDownloadsPage(driver);
		WebElement digitalDowonloadText = digital.getDigitalDowonloadText();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", digitalDowonloadText);
		List<WebElement> allPrice = digital.getAllPrice();
		for (WebElement option : allPrice) {
			System.out.println(option.getText());
		}
	}



	@Test(enabled = false)
	public void verifySortByDropdown() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.getDigitalDownloads().click();
		DigitalDownloadsPage digital = new DigitalDownloadsPage(driver);
		WebElement singlSelect = digital.getSortbyDropdown();
		Select sel = new Select(singlSelect);
		int size = sel.getOptions().size();
		for (int i = 0; i < size; i++) {
			WebElement singElement = digital.getSortbyDropdown();
			sel = new Select(singElement);
			sel.selectByIndex(i);
			String expectedOption = sel.getOptions().get(i).getText();
			String actualOption = sel.getFirstSelectedOption().getText();
			assertEquals(actualOption, expectedOption, "sort by dropdown option selection failed at index: " + i);
		}

	}

	
	@Test(enabled = false)
	public void verifyDisplayDropdown() {
		HomePage home = new HomePage(driver);
		home.getDigitalDownloads().click();
		DigitalDownloadsPage digital = new DigitalDownloadsPage(driver);
		WebElement displayDropdown = digital.getDisplayDropdown();
		Select sel = new Select(displayDropdown);
		int size = sel.getOptions().size();
		for (int i = 0; i < size; i++) {
			displayDropdown = digital.getDisplayDropdown();
			sel = new Select(displayDropdown);
			String expectedOption = sel.getOptions().get(i).getText();
			sel.selectByIndex(i);
			String actualOption = sel.getFirstSelectedOption().getText();
			assertEquals(actualOption, expectedOption, "display dropdown option selection failed at index: " + i);
		}
	}

	
	@Test(enabled = false)
	public void verifyViewDropdown() {
		HomePage home = new HomePage(driver);
		home.getDigitalDownloads().click();
		DigitalDownloadsPage digital = new DigitalDownloadsPage(driver);
		WebElement viewAsDropdown = digital.getViewAsDropdown();
		Select sel = new Select(viewAsDropdown);
		int size = sel.getOptions().size();
		for (int i = 0; i < size; i++) {
			viewAsDropdown = digital.getViewAsDropdown();
			sel = new Select(viewAsDropdown);
			String expectedOption = sel.getOptions().get(i).getText();
			sel.selectByIndex(i);
			String actualOption = sel.getFirstSelectedOption().getText();
			assertEquals(actualOption, expectedOption, "view by dropdown option selection failed at index: " + i);
		}
	}
	


		@Test(enabled = false)
		public void addDigitalDownloadProduct() throws InterruptedException {
			HomePage home = new HomePage(driver);
			home.getDigitalDownloads().click();
			assertTrue(driver.getCurrentUrl().contains("digital-downloads"), "digital downloads page dose not open");
			DigitalDownloadsPage digital = new DigitalDownloadsPage(driver);
			List<WebElement> addCarts = digital.getAllAddToCarts();
			for (WebElement web : addCarts) {
				web.click();
				Thread.sleep(1000);
			}
			Thread.sleep(3000);
			home.getShoppingCartLink().click();
			ShoppingCardPage shopping = new ShoppingCardPage(driver);
			List<WebElement> allPrices = shopping.getAllPriceShoppingCart();
			double max = Double.MIN_VALUE;
			int index = -1;

			for (WebElement webs : allPrices) {
				double price = Double.parseDouble(webs.getText());
				if (max < price) {
					max = price;
					index++;
				}
			}
			int previousSize = allPrices.size();
			List<WebElement> allRemoveCheckBox = shopping.getAllremoveCheckBox();
			allRemoveCheckBox.get(index).click();
			shopping.getUpdateShoppingCart().click();
			Thread.sleep(2000);
			List<WebElement> updatedPrices = shopping.getAllPriceShoppingCart();
			assertTrue(updatedPrices.size() < previousSize, "highest price product should not be removed");
			shopping.getUpdateShoppingCart().click();
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


		@Test(enabled = false)
		public void add() throws InterruptedException {
			login();
			HomePage home = new HomePage(driver);
			home.getapparelShoesLink().click();
			ApparelShoesPage appare = new ApparelShoesPage(driver);
			List<WebElement> addToCartApparel = appare.getAddToCartApparelShoesPage();
			for (int i = 0; i < 1 && i < addToCartApparel.size(); i++) {
				WebElement web = addToCartApparel.get(i);
				web.click();
				Thread.sleep(4000);
				RockabillyPage rockabilly = new RockabillyPage(driver);
				WebElement singleSelect = rockabilly.getSizeDropDown();
				Select sel = new Select(singleSelect);
				sel.selectByIndex(0);
				rockabilly.getAddToCartRockabillyPage().click();
				Thread.sleep(1500);
				driver.navigate().back();
				Thread.sleep(1500);
			}
			for (int i = 1; i < 2 && i < addToCartApparel.size(); i++) {
				WebElement web = addToCartApparel.get(i);
				web.click();
				Thread.sleep(4000);
				BlueAndGreenSneakerPage blue = new BlueAndGreenSneakerPage(driver);
				WebElement singleSelect = blue.getSizeDropDown();
				Select sel = new Select(singleSelect);
				sel.selectByIndex(0);
				blue.getColor().click();
				blue.getAddToCartBlueAndGreenSneakerPage().click();
				Thread.sleep(1500);
				driver.navigate().back();
				Thread.sleep(1500);
			}

			for (int i = 2; i < 4 && i < addToCartApparel.size(); i++) {
				Thread.sleep(1500);
				WebElement web = addToCartApparel.get(i);
				web.click();
				Thread.sleep(1500);
			}
			Thread.sleep(5000);
			home.getShoppingCartLink().click();
			ShoppingCardPage shopping = new ShoppingCardPage(driver);
			List<WebElement> prices = shopping.getAllPriceShoppingCart();
			List<WebElement> removeCheck = shopping.getRemoveCheckBox();
			double max = Double.MIN_VALUE;
			int index = 0;
			for (WebElement webElement : prices) {
				double price = Double.parseDouble(webElement.getText());
				if (price > max) {
					max = price;
					index++;
				}
			}
			removeCheck.get(index).click();

			int index2 = 0;// 3
			for (int i = index; i < prices.size(); i++) {
				WebElement webele = prices.get(i);
				double prise = Double.parseDouble(webele.getText());
				if (prise == max) {
					index2 = i;
				}
			}
			removeCheck.get(index2).click();

			System.out.println("max price: " + max);
			System.out.println(index);// 1
			System.out.println(index2);// 0

			shopping.getUpdateShoppingCart().click();
		}
}
