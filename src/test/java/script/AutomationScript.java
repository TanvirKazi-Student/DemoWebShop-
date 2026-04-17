package script;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nt.baseclass.DwsBase;
import com.nt.pom.HomePage;
import com.nt.pom.LoginPage;
import com.nt.pom.Register;

public class AutomationScript extends DwsBase {
//	Verify that user can launch DWS page
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
// 1)open the browser
// 2)maximize the Browser after maximizing enter into dws(demowebshop) web site
// 3)after entering click on register
// 4)Verify Register page is displayed
// 5)after registering fill all the details from
// 6)click the register button
// 7)Verify user is registered successfully (success message)
// 8)close the Browser	
	@Test(enabled = false)
	public void register1() throws InterruptedException {
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
	@Test(enabled = false)
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
// 4)scroll into community poll
// 5)select all the redio button in community poll
// 6)verify all the redio button in community poll is selected
// 6)close the browser
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
// open the browser
// maximize the browser
// enter into dws home page
// after enter add 15$ gift card product into shopping cart
// fill all the details of text filed & chage the quality to 2
// add the product to the shopping card
// remove the product to the shopping cart
// close the browser
	@Test(enabled = true)
	public void addRemoveGiftCard() {
		// i am find all the webelemnt in pom page
		driver.findElement(By.xpath("//input[@value=\"Add to cart\"]")).click();
		driver.findElement(By.xpath("//input[@class='recipient-name']")).sendKeys("Rohan");
		driver.findElement(By.xpath("//input[@class='recipient-email']")).sendKeys("rohan@gmail.com");
		driver.findElement(By.xpath("//input[@class='sender-name']")).sendKeys("Sarthsk");
		driver.findElement(By.xpath("//input[@class='sender-email']")).sendKeys("sarthak@gmail.com");
		driver.findElement(By.xpath("//textarea[@class='message']")).sendKeys("this is the important for user");
		WebElement web = driver.findElement(By.xpath("//input[@class='qty-input']"));
		web.clear();
		web.sendKeys("2");
		driver.findElement(By.xpath("//input[@value='Add to cart']")).click();
		driver.findElement(By.className("cart-label")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@value='Update shopping cart']")).click();
		driver.close();
	}
}
