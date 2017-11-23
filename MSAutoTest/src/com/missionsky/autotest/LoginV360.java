package com.missionsky.autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginV360 {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver\\chromedriver.exe");
		WebDriver chromeDriver = new ChromeDriver();
		chromeDriver.get("https://qaenv930.dev.accela.com:5443");
		
		chromeDriver.switchTo().frame(0);

		WebElement agency = findElementByXpath(chromeDriver, "//*[@id=\"servProvCode\"]");
		agency.sendKeys("petaluma");
		agency.sendKeys(Keys.TAB);
		Thread.sleep(500);
		
		

		WebElement Uname = findElementByXpath(chromeDriver, "//*[@id=\"username\"]");
		Uname.sendKeys("admin");
		Uname.sendKeys(Keys.TAB);
		Thread.sleep(500);
		
		WebElement Pwd = findElementByXpath(chromeDriver, "//*[@id=\"login_form\"]/tbody/tr/td/table/tbody/tr[12]/td[2]/input");
		Pwd.sendKeys("admin");
		
		WebElement submitBttn = findElementByXpath(chromeDriver, "//*[@id=\"submit_\"]");
		submitBttn.click();

		Thread.sleep(500);
		boolean signout = findElementExist(chromeDriver, "//*[@id=\"header_system_links_sign_out\"]/a/nobr");
		

		
		if (signout == true)
				System.out.print("Login successfully");
		else
			System.out.print("Login failure");
		close(chromeDriver);
	}

	private WebElement findElementById(WebDriver webDriver, String id) {
		By by = By.id(id);
		return webDriver.findElement(by);
		}
	
   private WebElement findElementByName(WebDriver webDriver, String Name) {
			By by = By.name(Name);
			return webDriver.findElement(by);
	}
   
   private WebElement findElementByXpath(WebDriver webDriver, String Xpath) {
		By by = By.xpath(Xpath);
		return webDriver.findElement(by);
}
   private boolean findElementExist(WebDriver webDriver, String Xpath) {
			By by = By.xpath(Xpath);
			if(webDriver.findElement(by) != null)
				return true;
			else
				return false;
	}

	private void close(WebDriver chromeDriver) {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		chromeDriver.close();
	}

}
