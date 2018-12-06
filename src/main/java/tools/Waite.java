package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.Thread;

public class Waite {
	private WebDriver driver;
	private int timeout=10;
	
	public Waite(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElementPresent( String locator) {
		try {
			new WebDriverWait(driver, timeout,1).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		} catch (Exception e) {
			System.out.println("网络太慢啦");
			// TODO: handle exception
		}
	}
	
	public void waitForElementIsEnable(String locator) {
		try {
			new WebDriverWait(driver,20,1).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			System.out.println("网络太好啦");
		} catch (Exception e) {
			System.out.println("网络太慢啦");
			// TODO: handle exception
		}
	}
	
	public void waitFor(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
