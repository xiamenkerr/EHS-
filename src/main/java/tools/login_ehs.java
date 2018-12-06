package tools;

import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class login_ehs {
	private WebDriver driver;
	public login_ehs(WebDriver driver ) {
		this.driver=driver;
	}
	public void sign_in(String account,String pass) {
		getcsv	d=new getcsv("E:\\eclipse-workspace\\EHS\\src\\main\\java\\Lib\\yinhuan_paicha.csv");
		find spy=new find(driver);
		Waite waiting=new Waite(driver);
		try {
			//手机号
			waiting.waitForElementIsEnable(d.getCsvDate("xpath", "phone"));
			spy.target_xpath(d.getCsvDate("xpath", "phone")).clear();
			spy.target_xpath(d.getCsvDate("xpath", "phone")).sendKeys(account);
			spy.target_xpath(d.getCsvDate("xpath", "next")).click();
			Thread.sleep(200);
			//密码		
			waiting.waitForElementIsEnable(d.getCsvDate("xpath", "password"));
			spy.target_xpath(d.getCsvDate("xpath", "password")).clear();
			spy.target_xpath(d.getCsvDate("xpath", "password")).sendKeys(pass);
			spy.target_xpath(d.getCsvDate("xpath", "next")).click();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			WebElement obj=spy.target_xpath(d.getCsvDate("xpath", "ehs_page"));
			assertEquals(obj.getText(), "智慧EHS管理平台");
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("登录失败");
		}	
}
}

