package com.google.grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicSeleniumGrid {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		// 1 - Set the desired Caps
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);

		// 2 - Pass the capability to chrome options
		ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true);
		options.merge(cap);

		// Hub URL u want to connect
		String hubURL = "http://10.0.0.130:4444/wd/hub";
		
		//WebDriver driver=new ChromeDriver();
		
		WebDriver driver = new RemoteWebDriver(new URL(hubURL), options);

		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		
		Thread.sleep(15000);

		driver.quit();

	}

}
