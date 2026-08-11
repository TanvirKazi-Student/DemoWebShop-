package script;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nt.baseclass.DwsBase;
import com.nt.pom.HomePage;
import com.nt.pom.LoginPage;

public class LoginModule extends DwsBase {

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
	public void verifyNavigationLoginLink() {
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		loginLink.click();
		assertTrue(driver.getCurrentUrl().contains("login"),
				"succesfully not enteraing into login page test case is failed");
	}

	@Test(enabled = false)
	public void verifyEmailFieldPositive() {
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		loginLink.click();
		assertTrue(driver.getCurrentUrl().contains("login"),
				"succesfully not enteraing into login page test case is failed");
		LoginPage login = new LoginPage(driver);
		WebElement searchFiledEmail = login.getEmail();
		String expectedEmail = "tanvirkazi2786@gmail.com";
		searchFiledEmail.sendKeys(expectedEmail);
		String actualEmail = searchFiledEmail.getAttribute("value");
		assertEquals(actualEmail, expectedEmail, "email is not correctly pass");
	}

	@Test(enabled = false)
	public void verifyEmailFieldNegative() {
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		loginLink.click();
		assertTrue(driver.getCurrentUrl().contains("login"),
				"succesfully not enteraing into login page test case is failed");
		LoginPage login = new LoginPage(driver);
		WebElement searchFiledEmail = login.getEmail();
		String expectedEmail = "tanvirkazi2786";
		searchFiledEmail.sendKeys(expectedEmail);
		String actualEmail = searchFiledEmail.getAttribute("value");
		assertNotEquals(actualEmail, expectedEmail, "Invalid email should not match valid email");
		login.getLoginButton().click();
	}

	@Test(enabled = false)
	public void verifyPasswordFieldPositive() {
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		loginLink.click();
		assertTrue(driver.getCurrentUrl().contains("login"),
				"succesfully not enteraing into login page test case is failed");
		LoginPage login = new LoginPage(driver);
		WebElement searchFiledPassword = login.getPassword();
		String expectedPassword = "tanvir@123";
		searchFiledPassword.sendKeys(expectedPassword);
		String actualPassword = searchFiledPassword.getAttribute("value");
		assertEquals(actualPassword, expectedPassword, "password is not correctly pass");
		String fieldType = searchFiledPassword.getAttribute("type");
		assertEquals(fieldType, "password", "Password field is not masked");
	}

	@Test(enabled = false)
	public void verifyPasswordField() {
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		loginLink.click();
		assertTrue(driver.getCurrentUrl().contains("login"),
				"succesfully not enteraing into login page test case is failed");
		LoginPage login = new LoginPage(driver);
		WebElement searchFiledPassword = login.getPassword();
		String expectedPassword = "tanvir";
		searchFiledPassword.sendKeys(expectedPassword);
		String actualPassword = searchFiledPassword.getAttribute("value");
		assertEquals(actualPassword, expectedPassword, "password is not correctly pass");
		String fieldType = searchFiledPassword.getAttribute("type");
		assertEquals(fieldType, "password", "Password field is not masked");
		login.getLoginButton().click();
	}

	@Test(enabled = false)
	public void verifyLoginFunctionality() {
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		loginLink.click();
		assertTrue(driver.getCurrentUrl().contains("login"),
				"succesfully not enteraing into login page test case is failed");
		LoginPage login = new LoginPage(driver);
		WebElement searchFiledEmail = login.getEmail();
		String expectedEmail = "tanvirkazi2786@gmail.com";
		searchFiledEmail.sendKeys(expectedEmail);
		String actualEmail = searchFiledEmail.getAttribute("value");
		assertEquals(actualEmail, expectedEmail, "email is not correctly pass");
		WebElement searchFiledPassword = login.getPassword();
		String expectedPassword = "tanvir@123";
		searchFiledPassword.sendKeys(expectedPassword);
		String actualPassword = searchFiledPassword.getAttribute("value");
		assertEquals(actualPassword, expectedPassword, "password is not correctly pass");
		login.getLoginButton().click();
		WebElement logOut = home.getLogoutLink();
		assertTrue(logOut.getText().contains("Log out"), "login is not success test case is faile");

	}

}
