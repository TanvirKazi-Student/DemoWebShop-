package script;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.nt.baseclass.DwsBase;
import com.nt.pom.HomePage;
import com.nt.pom.Register;

//Verify user is able to register successfully
//1)open the browser 
//2)maximize the Browser after maximizing enter into dws(demowebshop) web site
//3)after entering click on register
//4)Verify Register page is displayed
//5)after registering fill all the details from 
//6)click the register button
//7)Verify user is registered successfully (success message)
//8)close the Browser
public class AutomationScript extends DwsBase {
	@Test
	public static void register() {
		HomePage home = new HomePage(driver);
		home.getRegisterLink().click();
		String expectedUrl = "https://demowebshop.tricentis.com/register";
		String actualurl = driver.getCurrentUrl();
		assertEquals(actualurl, expectedUrl, "Register page dose not displayed");
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
}
