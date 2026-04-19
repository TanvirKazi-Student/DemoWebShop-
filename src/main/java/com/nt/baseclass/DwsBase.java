package com.nt.baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.nt.utilityfile.ReadFromProperties;

public class DwsBase {
	public static WebDriver driver;

	@BeforeClass
	public void preCondition() throws IOException {
		String browser = ReadFromProperties.readFromProperties("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("safary")) {
			driver = new SafariDriver();
		} else if (browser.equals("internetexplorer")) {
			driver = new InternetExplorerDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String url = ReadFromProperties.readFromProperties("url");
		driver.get(url);
	}

//	@BeforeMethod
//	public void login() throws IOException, InterruptedException {
//		String url = ReadFromProperties.readFromProperties("url");
//		System.out.println("URL = " + url);
//		driver.get(url);
//	}

	@AfterClass
	public void postCondition() {
		driver.quit();
	}
}
