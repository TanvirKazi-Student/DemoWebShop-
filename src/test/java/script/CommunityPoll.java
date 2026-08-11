package script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.nt.baseclass.DwsBase;

public class CommunityPoll extends DwsBase {

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
}
