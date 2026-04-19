package script;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nt.baseclass.DwsBase;
import com.nt.pom.BulildYourOwnCheperComputer;
import com.nt.pom.DigitalDownloadsPage;
import com.nt.pom.GiftCardsPage;
import com.nt.pom.HomePage;
import com.nt.pom.LoginPage;
import com.nt.pom.Register;
import com.nt.pom.ShoppingCardPage;
import com.nt.pom.VirtualGiftCard;

public class AutomationScript extends DwsBase {

//Verify that user can launch DWS page
// 1)Open the browser
// 2)Maximize the browser
// 3)Enter into Demo Web Shop webSite
// 4)verify DWS home page should be open 
// 5)close the browser

	@Test(enabled = false)
	public void openWebPage() {
		String expectedUrl = "https://demowebshop.tricentis.com/";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "DWS home page dose not displayed");
	}

// Verify user is able to register successfully
// 1)Open the browser
// 2)Maximize the Browser after maximizing enter into dws(demowebshop) web site
// 3)After entering click on register
// 4)Verify Register page is displayed
// 5)After registering fill all the details from
// 6)Click the register button
// 7)Verify user is registered successfully (success message)
// 8)Close the Browser	

	@Test(enabled = false)
	public void register() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.getRegisterLink().click();
		String expectedUrl = "https://demowebshop.tricentis.com/register";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "register page dose not displayed");
		Register register = new Register(driver);
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

// Verify user is able to login successfully
// 1)Open the browser
// 2)Maximize the browser
// 3)Enter into Demo Web Shop website
// 4)Click on Login link
// 5)Verify Login page is displayed
// 6)after Login fill all the details
// 7)Click on Login button
// 8)Verify user is registered successfully (success message)
// 9)Close the browser

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

//	Verify user can select options in Community Poll
// 1)Open the browser
// 2)Maximize the browser
// 3)Enter into Demo Web Shop website
// 4)Scroll into community poll
// 5)Select all the redio button in community poll
// 6)Verify all the redio button in community poll is selected
// 6)Close the browser

	@Test(enabled = false)
	public void communityPoll() throws InterruptedException {
		WebElement communityPoll = driver.findElement(By.xpath("//strong[text()=\"Community poll\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", communityPoll);
		List<WebElement> redioButton = driver.findElements(By.xpath("//input[@type=\"radio\"]"));
		SoftAssert soft = new SoftAssert();
		for (WebElement option : redioButton) {
			option.click();
			soft.assertTrue(option.isSelected(), "dose not select all the redio button in community poll");
		}

	}

// Add & Remove Gift Card from Cart
//1) Open the browser
//2) Maximize the browser
//3) Enter into dws home page
//4) Verify the page by using url
//5) After enter add 25$ gift card product into shopping cart
//6) Fill all the details of text filed & chage the quality to 2
//7) Add the product to the shopping card
//8) Verify Product added successfully (success message)
//9) Remove the product to the shopping cart
//10) Close the browser

	@Test(enabled = false)
	public void addRemoveGiftCard() throws InterruptedException {
		String expectedUrl = "https://demowebshop.tricentis.com/";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "DWS home page dose not displayed");
		HomePage home = new HomePage(driver);
		home.getAddTocartHomePage().click();
		VirtualGiftCard virtual = new VirtualGiftCard(driver);
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
		shopping.getRemoveCheckBox().click();
		shopping.getUpdateShoppingCart().click();
		WebElement emptyCartMsg = shopping.getEmptyCardMsg();
		assertTrue(emptyCartMsg.getText().contains("Your Shopping Cart is empty"), "Cart is not empty");
	}

// digital downloads feach all the digit downloads product and display in the
// console
// 1)Open the browser maximize the browser
// 2)After enter into the DWS home page
// 3)Click digital downloads
// 4)After feach all the digit downloads product and display in the console
// 5)Close the browser

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

// Build Your Own Cheap Computer with high Configure
// 1)Open the browser
// 2)Maximize the browser
// 3)After maximize enter into dws home page
// 4)Add build cheap computer
// 5)Select high configration feature,quality is 2
// 6)Add the product to the shopping cart then click check out
// 7)Close the browser
// 8)Only use relative xpath

	@Test(enabled = false)
	public void buildCheapComputer() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.getBuildYourOwnCheapComputerlink().click();
		BulildYourOwnCheperComputer build = new BulildYourOwnCheperComputer(driver);
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

// Build Your Own Cheap Computer with Low Configure
// 1)Open the browser
// 2)Maximize the browser
// 3)After enter into the DWS home page
// 4)Verify the page by using Title do login
// 5)After verify add bulid your shopping card
// 6)Configr with low configration
// 7)Quntity should be 3
// 8)Add product into shopping card
// 9)After remove product into shopping card
// 10Verify wather the product is successfully remove shopping card page or not
// . do log out
// 11)Close the browser

	@Test(enabled = false, priority = 0)
	public void add$25GiftCard() throws InterruptedException {
		String expectedUrl = "https://demowebshop.tricentis.com/";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "DWS home page dose not displayed");
		login();
		HomePage home = new HomePage(driver);
		home.getBuildYourOwnCheapComputerlink().click();
		BulildYourOwnCheperComputer build = new BulildYourOwnCheperComputer(driver);
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
		digital.getRemoveCheckBox().click();
		digital.getUpdateShoppingCart().click();
		ShoppingCardPage shoping = new ShoppingCardPage(driver);
		WebElement emptyCartMsg = shoping.getEmptyCardMsg();
		assertTrue(emptyCartMsg.getText().contains("Your Shopping Cart is empty"), "Cart is not empty");
		Thread.sleep(3000);
		home.getLogoutLink().click();
	}

//	Verify user can navigate between Demo Web Shop and RedBus websites successfully
// 1) Open browser
// 2) Maximize browser
// 3) Enter into DWS webSite
// 4) Navigate to RedBus webSite
// 5) Go back to demo webSite
// 6) Once again go to RedBus webSite
// 7) Refresh the page
// 8) Close the browser

	@Test(enabled = false)
	public void navigation() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		driver.navigate().to("https://www.redbus.in/");
		driver.navigate().back();
		driver.navigate().to("https://www.redbus.in/");
		driver.navigate().refresh();
	}

//	Add All Digital download Products & Remove Highest Price Product
// 1) Open browser
// 2) Maximize browser
// 3) Enter into DWS webSite
// 4) Click digital download
// 5) Verify digital download page should be displayed	
// 5) Add all the product present in digital download to shopping cart
// 6) Once again go to cart webSite
// 7) Product should be add use findElements you want to see price
// 8) Remove product which is having highest price
// 9) Verify highest price product should be removed	
// 10) Close the browser

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
//Verify Add All Gift Card Products to Shopping Cart in DWS
//1) Open browser
//2) Maximize browser
//3) Enter into DWS webSite
//4) Click gift card product page
//5) After click add all the product into the shopping cart
//6) Use two for loop
//7) Close the browser

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
			VirtualGiftCard virtual = new VirtualGiftCard(driver);
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
			VirtualGiftCard virtual = new VirtualGiftCard(driver);
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

//Verify Login Link Display in DWS
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS home page
// 4) Verify the page using the title
// 5) Verify that the login link is display or not
// 7) Click the login link
// 8) Close the browser

	@Test(enabled = false)
	public void verifyLoginLinkDisplay() {
		String expectedResult = "Demo Web Shop";
		String actualResult = driver.getTitle();
		assertEquals(actualResult, expectedResult, "DWS home page dose not displayed");
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		assertTrue(loginLink.isDisplayed(), "login  link not desable test case is faile");
	}

//Verify Login Link is Enabled in DWS	
//1) Open the browser
//2) Maximize the browser
//3) Enter into DWS webSite
//4) Verify the page using the title
//5) Verify whether the login link is enable or not
//6) Click the login link
//7) Close the browser

	@Test(enabled = false)
	public void verifyLoginLinkEnable() {
		String expectedResult = "Demo Web Shop";
		String actualResult = driver.getTitle();
		assertEquals(actualResult, expectedResult, "DWS home page dose not displayed");
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		assertTrue(loginLink.isEnabled(), "login  link not enable test case is faile");
	}

//Verify Navigation to Login Page	
//1) Open the browser
//2) Maximize the browser
//3) Enter into DWS webSite
//4) Click the login link
//5) Verify the page whether i am successfully enter into login page or not
//6) Close the browser

	@Test(enabled = false)
	public void verifyNavigationLoginLink() {
		HomePage home = new HomePage(driver);
		WebElement loginLink = home.getloginLink();
		loginLink.click();
		assertTrue(driver.getCurrentUrl().contains("login"),
				"succesfully not enteraing into login page test case is failed");
	}

//	Verify Email Field Functionality on Login Page (positive case)
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS webSite
// 4) Click the login link
// 5) Verify the page whether I am successfully enter into login page by using title
// 6) Pass the current credential by the email text field
// 7) Verify the data is successfully added email text field or not
// 8) Close the browser

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

//	Verify Email Field Functionality on Login Page (negative case)
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS webSite
// 4) Click the login link
// 5) Verify the page whether I am successfully enter into login page by using title
// 6) Pass the current credential by the email text field
// 7) Verify the data is successfully not added email text field or not
// 8) Close the browser

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

//	Verify Password Field Functionality on Login Page (positive case)
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS webSite
// 4) Click the login link
// 5) Verify the page whether I am successfully enter into login page by using URL
// 6) Send the current credential to the password field
// 7) Check whether data is successfully added into password field or not
// 8) Close the browser

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

//	Verify Password Field Functionality on Login Page (negative case)
// 1) Open the browser
// 2) Maximize the browser window
// 3) Navigate to the Demo Web Shop (DWS) home page
// 4) Click on the "Login" link
// 5) Verify that the Login page is displayed using URL
// 6) Enter invalid password into the Password field
// 7) Click on the "Login" button
// 8) Verify that login is NOT successful
// 9) Verify that an error message is displayed
// 10) Close the browser

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

//	Verify Login Functionality with Valid Credentials
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS webSite
// 4) Click the login link
// 5) After clicking the login link fill email or password text filed with current credential after filling click login.
// 6) Verify the login is successfully or not
// 7) Close the browser

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

// Verify Register Link Display in DWS
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS home page
// 4) Verify the page using the title
// 5) Verify that the register link is display or not
// 7) Click the register link
// 8) Close the browser

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

// Verify Register Link is Enabled in DWS
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS webSite
// 4) Verify the page using the title
// 5) Verify whether the register link is enable or not
// 6) Click the register link
// 7) Close the browser

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

// Verify Navigation to Register Page
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS webSite
// 4) Click the register link
// 5) Verify the page whether i am successfully enter into register page or not
// 6) Close the browser

	@Test(enabled = false)
	public void verifyNavigationRegisterLink() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
	}

//	Verify Male Radio Button Selection (Positive Case)
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS webSite
// 4) Click the register link
// 5) Verify the page whether I am successfully enter into register page by using title
// 6) Pass the current credential by the  male radio button
// 7) Verify the male radio button is successfully selected 
// 8) Close the browser

	@Test(enabled = false)
	public void verifyMaleRadioButtonPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		Register register = new Register(driver);
		WebElement maleRadioButton = register.getMaleRedioButton();
		maleRadioButton.click();
		assertTrue(maleRadioButton.isSelected(), "Male radio button is not selected after click");
	}

// Verify Male Radio Button is NOT Selected by Default (Negative Case)
// 1) Launch the browser
// 2) Maximize the browser window
// 3) Navigate to the DWS home page
// 4) Click on the "Register" link
// 5) Verify that the Register page is displayed
// 6) Do NOT select the male radio button
// 7) Verify that the male radio button is NOT selected
// 8) Close the browser

	@Test(enabled = false)
	public void verifyMaleRadioButtonNegative() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		Register register = new Register(driver);
		WebElement maleRadioButton = register.getMaleRedioButton();
		assertFalse(maleRadioButton.isSelected(), "Male radio button is selected before click");
	}

// Verify Female Radio Button Selection (Positive Case)
// 1) Open the browser
// 2) Maximize the browser
// 3) Enter into DWS webSite
// 4) Click the register link
// 5) Verify the page whether I am successfully enter into register page by using title
// 6) Pass the current credential by the female radio button
// 7) Verify the female radio button is successfully selected 
// 8) Close the browser

	@Test(enabled = false)
	public void verifyFemaleRadioButtonPositive() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		Register register = new Register(driver);
		WebElement femaleRadioButton = register.getFemaleRedioButton();
		femaleRadioButton.click();
		assertTrue(femaleRadioButton.isSelected(), "Female radio button is not selected after click");
	}

// Verify Female Radio Button is NOT Selected by Default (Negative Case)
// 1) Launch the browser
// 2) Maximize the browser window
// 3) Navigate to the DWS home page
// 4) Click on the "Register" link
// 5) Verify that the Register page is displayed
// 6) Do NOT select the female radio button
// 7) Verify that the female radio button is NOT selected
// 8) Close the browser

	@Test(enabled = false)
	public void verifyFemaleRadioButtonNegative() {
		HomePage home = new HomePage(driver);
		WebElement registerLink = home.getRegisterLink();
		registerLink.click();
		assertTrue(driver.getCurrentUrl().contains("register"),
				"succesfully not enteraing into register page test case is failed");
		Register register = new Register(driver);
		WebElement femaleRadioButton = register.getFemaleRedioButton();
		assertFalse(femaleRadioButton.isSelected(), "Female radio button is selected before click");
	}
}
