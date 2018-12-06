package basePage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class TurnOn_driver {
	public WebDriver driver;
	//启动火狐浏览器
	public WebDriver setupFirfox() throws InterruptedException{		
//		FirefoxOptions options = new FirefoxOptions();
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("dom.webnotifications.enabled", "false");
//		profile.setPreference("dom.push.enabled", "false");	    
//		System.setProperty("webdriver.firefox.bin", "D:/Program Files/Mozilla Firefox/firefox.exe");	
		
		//创建profilesIni对象
		ProfilesIni ini = new ProfilesIni();		
		//通过名字来获取到相应的配置文件
		FirefoxProfile profile = ini.getProfile("selenium");		
		//创建浏览器驱动，并将profile传入，此时启动时，就会读取default配置文件来调用firefox浏览器了
		FirefoxOptions Options = new FirefoxOptions();
		Options.setProfile(profile);
		driver =new FirefoxDriver(Options);
//		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.anhuanjia.com/");
		//设置浏览器分辨率
//		driver.manage().window().setSize(new Dimension(1920, 1980));
//		Thread.sleep(1000);
		return driver;
	}
	//代理配置
//	private static FirefoxProfile getProfile(String profileName) {
//	    if (profileName == null || profileName.trim().isEmpty()) {
//	        return new FirefoxProfile();
//	    }
//	    return new ProfilesIni().getProfile(profileName);
//	}
	//关闭浏览器
	public void teardownBrowser() throws Exception{
//		driver.close(); 
		driver.quit();
	} 
}
