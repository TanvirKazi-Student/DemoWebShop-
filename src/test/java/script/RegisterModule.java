package script;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.nt.baseclass.DwsBase;
import com.nt.pom.HomePage;
import com.nt.pom.RegisterPage;

public class RegisterModule extends DwsBase {

	@Test(enabled = false)
	public void verifyNavigationRegisterLink() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
	}

	@Test(enabled = false)
	public void register() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.getRegisterLink().click();
		String expectedUrl = "https://demowebshop.tricentis.com/register";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "register page dose not displayed");
		RegisterPage register = new RegisterPage(driver);
		register.getMaleRedioButton().click();
		register.getFirstName().sendKeys("Tanvir");
		register.getlastName().sendKeys("Kazi");
		register.getEmail().sendKeys("tanvirkazi2786@gmail.com");
		register.getPassword().sendKeys("tanvir@123");
		register.getConfirmPassword().sendKeys("tanvir@123");
		register.getRegisterButton().click();
		String expectedMsg = "Your registration completed";
		String actualMsg = home.getRegisterSuccess().getText();
		assertEquals(actualMsg, expectedMsg, "registered dose not successfully");
	}

	@Test(enabled = false)
	public void verifyMaleRadioButtonPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		WebElement maleRadioButton = register.getMaleRedioButton();
		maleRadioButton.click();
		assertTrue(maleRadioButton.isSelected(), "Male radio button is not selected after click");
	}

	@Test(enabled = false)
	public void verifyMaleRadioButtonNegative() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		WebElement maleRadioButton = register.getMaleRedioButton();
		assertFalse(maleRadioButton.isSelected(), "Male radio button is selected before click");
	}

	@Test(enabled = false)
	public void verifyFemaleRadioButtonPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		WebElement femaleRadioButton = register.getFemaleRedioButton();
		femaleRadioButton.click();
		assertTrue(femaleRadioButton.isSelected(), "Female radio button is not selected after click");
	}

	@Test(enabled = false)
	public void verifyFemaleRadioButtonNegative() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		WebElement femaleRadioButton = register.getFemaleRedioButton();
		assertFalse(femaleRadioButton.isSelected(), "Female radio button is selected before click");
	}

	@Test(enabled = false)
	public void verifyFirstNameTextFiledPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		WebElement firstNameTextField = register.getFirstName();
		String expectedResult = "Tanvir";
		firstNameTextField.sendKeys(expectedResult);
		String actualResult = firstNameTextField.getAttribute("value");
		assertEquals(actualResult, expectedResult, "enter name is not correctly");
	}

	@Test(enabled = false)
	public void verifyLastNameTextFiledPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		WebElement lastNameTextField = register.getlastName();
		String expectedResult = "kazi";
		lastNameTextField.sendKeys(expectedResult);
		String actualResult = lastNameTextField.getAttribute("value");
		assertEquals(actualResult, expectedResult, "enter name is not correctly");
	}

	@Test(enabled = false)
	public void verifyEmailTextFiledPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		WebElement emailTextField = register.getEmail();
		String expectedResult = "tanvirkazi2786@gmail.com";
		emailTextField.sendKeys(expectedResult);
		String actualResult = emailTextField.getAttribute("value");
		assertEquals(actualResult, expectedResult, "enter email is not correctly");
	}

	@Test(enabled = false)
	public void verifyPasswordTextFiledPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		WebElement passwordTextField = register.getPassword();
		String expectedResult = "tanvirkazi278";
		passwordTextField.sendKeys(expectedResult);
		String actualResult = passwordTextField.getAttribute("value");
		assertEquals(actualResult, expectedResult, "enter password is not correctly");
	}

	@Test(enabled = false)
	public void verifyPasswordAndConfirmPasswordTextFiledPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		register.getMaleRedioButton().click();
		register.getFirstName().sendKeys("Tanvir");
		register.getlastName().sendKeys("kazi");
		register.getEmail().sendKeys("tanvirkazi2786@gmial.com");
		WebElement passwordTextField = register.getPassword();
		WebElement confirmpasswordTextField = register.getConfirmPassword();
		String password = "Test@123";
		passwordTextField.sendKeys(password);
		confirmpasswordTextField.sendKeys(password);
		register.getRegisterButton().click();
		assertTrue(driver.getCurrentUrl().contains("registerresult"), "Registration failed even when passwords match");
	}

	@Test(enabled = false)
	public void verifyPasswordAndConfirmPasswordTextFiledNegative() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		register.getMaleRedioButton().click();
		register.getFirstName().sendKeys("Tanvir");
		register.getlastName().sendKeys("kazi");
		register.getEmail().sendKeys("tanvirkazi278@gmial.com");
		WebElement passwordTextField = register.getPassword();
		WebElement confirmpasswordTextField = register.getConfirmPassword();
		String password = "Test@123";
		String confirmpassword = "Test@1234";
		passwordTextField.sendKeys(password);
		confirmpasswordTextField.sendKeys(confirmpassword);
		register.getRegisterButton().click();
		WebElement confirmMsg = register.getConfirmPasswordMsg();
		assertTrue(confirmMsg.getText().contains("The password and confirmation password do not match."),
				"error massage not displayed");
	}

	@Test(enabled = false)
	public void verifyRegistration() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		RegisterPage register = new RegisterPage(driver);
		register.getMaleRedioButton().click();
		register.getFirstName().sendKeys("Tanvir");
		register.getlastName().sendKeys("kazi");
		register.getEmail().sendKeys("tanvirkazi278@gmial.com");
		register.getPassword().sendKeys("tanvir@123");
		register.getConfirmPassword().sendKeys("tanvir@123");
		register.getRegisterButton().click();
		WebElement duplicateEmailMsg = register.getDuplicateEmailMsg();
		assertTrue(duplicateEmailMsg.getText().contains("The specified email already exists"),
				"error massage not displayed");
	}

}
