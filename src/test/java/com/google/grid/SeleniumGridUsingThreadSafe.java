package com.google.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGridUsingThreadSafe {

	
	//Thread local is used to make the Webdriver Thread safe
	protected ThreadLocal<WebDriver> wd = new ThreadLocal<WebDriver>();

	@BeforeMethod
	public void intialisation() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		// Setting the chrome option

		ChromeOptions options = new ChromeOptions();
		options.merge(cap);

		wd.set(new RemoteWebDriver(new URL("http://10.0.0.130:4444"), cap));

	}

	@Test
	public void test1() {
		wd.get().get("https://www.google.com/");

		System.out.println("Test1: " + wd.get().getTitle());

	}

	@Test
	public void test2() {
		wd.get().get("http://automationpractice.com/index.php");

		System.out.println("Test2: " + wd.get().getTitle());

	}

	@Test
	public void test3() {
		wd.get().get("https://demoqa.com/");

		System.out.println("Test3: " + wd.get().getTitle());

	}

	@Test
	public void test4() {
		wd.get().get("https://www.phptravels.net/");

		System.out.println("Test4: " + wd.get().getTitle());

	}

	@Test
	public void test5() {
		wd.get().get("https://twitter.com");

		System.out.println("Test5: " + wd.get().getTitle());
	}

	@Test
	public void test6() {
		wd.get().get("https://login.yahoo.com/?.intl=ca");

		System.out.println("Test6: " + wd.get().getTitle());

	}

	@Test
	public void test7() {
		wd.get().get("https://tokyotreat.com/");

		System.out.println("Test7: " + wd.get().getTitle());

	}

	@Test
	public void test8() {
		wd.get().get("https://www.youtube.com/");

		System.out.println("Test8: " + wd.get().getTitle());

	}

	@AfterMethod
	public void tearDown() {
		wd.get().close();
	}

}
