package tools;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Browser {
	public WebDriver driver;
	public Browser(BrowserType type) {
		switch (type) {
		case firefox:
			//创建profilesIni对象
			ProfilesIni ini = new ProfilesIni();		
			//通过名字来获取到相应的配置文件
			FirefoxProfile profile = ini.getProfile("selenium");
//			profile.setPreference("dom.webnotifications.enabled", "false");
//			profile.setPreference("dom.push.enabled", "false");	
			//创建浏览器驱动，并将profile传入，此时启动时，就会读取default配置文件来调用firefox浏览器了
			FirefoxOptions Options = new FirefoxOptions();
			Options.setProfile(profile);
			driver =new FirefoxDriver(Options);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get("https://www.anhuanjia.com/");
			break;
		case chrome:
			System.setProperty("webdriver.chrome.bin", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.get("https://www.anhuanjia.com/");
			break;	
		}
	} 
}
