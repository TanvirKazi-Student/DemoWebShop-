package script;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nt.baseclass.DwsBase;
import com.nt.pom.HomePage;

public class HomePageModule extends DwsBase {

	@Test(enabled = true)
	public void openWebPage() {
		String expectedUrl = "https://demowebshop.tricentis.com/";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "DWS home page dose not displayed");
	}

	@Test(enabled = false)
	public void verifyRegisterLinkDisplay() {
		String expectedResult = "Demo Web Shop";
		String actualResult = driver.getTitle();
		assertEquals(actualResult, expectedResult, "DWS home page dose not displayed");
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		assertTrue(registerLink.isDisplayed(), "register link not desable test case is faile");
		registerLink.click();
	}

	@Test(enabled = false)
	public void verifyRegisterLinkEnable() {
		String expectedResult = "Demo Web Shop";
		String actualResult = driver.getTitle();
		assertEquals(actualResult, expectedResult, "DWS home page dose not displayed");
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		assertTrue(registerLink.isEnabled(), "register link not enable test case is faile");
		registerLink.click();
	}

	@Test(enabled = false)
	public void verifyLoginLinkDisplay() {
		String expectedResult = "Demo Web Shop";
		String actualResult = driver.getTitle();
		assertEquals(actualResult, expectedResult, "DWS home page dose not displayed");
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		assertTrue(loginLink.isDisplayed(), "login  link not desable test case is faile");
	}

	@Test(enabled = false)
	public void verifyLoginLinkEnable() {
		String expectedResult = "Demo Web Shop";
		String actualResult = driver.getTitle();
		assertEquals(actualResult, expectedResult, "DWS home page dose not displayed");
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		assertTrue(loginLink.isEnabled(), "login  link not enable test case is faile");
	}

}
