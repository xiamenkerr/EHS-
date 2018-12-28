package tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class getCookie {
	WebDriver driver;
	@Test
	public void cookie() throws InterruptedException {
		System.setProperty("webdriver.chrome.bin", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("http://aq.ahjtest.top/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("xinanli");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("888888");
		driver.findElement(By.xpath("//input[@class='submit']")).click();
//		增加cookie
		Cookie c1=new Cookie("name", "key-aaaaaa");
		Cookie c2=new Cookie("value", "value-bbbbbb");
		driver.manage().addCookie(c1);
		driver.manage().addCookie(c2);
//		获得cookie
		java.util.Set<Cookie> coo=driver.manage().getCookies();
		System.out.println(coo);
		Thread.sleep(2000);
//		删除所有cookie
//		driver.manage().deleteAllCookies();
		driver.quit();
	}

}
