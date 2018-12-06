package loginPage;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tools.Waite;
import tools.find;
import tools.getcsv;
import tools.swichWin;

	public class login {
		
	private  getcsv d;
//	public static void main(String[] args) throws Exception {
	//举报登录
	public void login_ehs(WebDriver driver) throws Exception {
		d=new getcsv("E:\\eclipse-workspace\\EHS\\src\\main\\java\\Lib\\loginPage.csv");
		find spy=new find(driver);
		swichWin ff=new swichWin();
		Waite waiting=new Waite(driver);
//		获取当前页面的句柄
		String currentWin1 = driver.getWindowHandle();
		
		spy.target_xpath(d.getCsvDate("xpath", "gj")).click();
		Thread.sleep(500);
		driver.close();
		ff.swich(currentWin1, driver);
//		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 500)"); //此方法火狐浏览器不起作用
//		操作滚动浏览器滚动条
		WebElement btn_ele=spy.target_xpath(d.getCsvDate("xpath", "ehs_btn"));
//		String script = "return arguments[0].scrollIntoView();";
		JavascriptExecutor je =(JavascriptExecutor) driver;
//		je.executeScript(script,btn_ele);
		je.executeScript("arguments[0].scrollIntoView();",btn_ele);
		waiting.waitForElementIsEnable(d.getCsvDate("xpath", "ehs_btn"));
		String currentWin2 = driver.getWindowHandle();
		btn_ele.click();
		Thread.sleep(500);
		driver.close();
		ff.swich(currentWin2, driver);
		try {
			//手机号
			waiting.waitForElementIsEnable(d.getCsvDate("xpath", "phone"));
			spy.target_xpath(d.getCsvDate("xpath", "phone")).clear();
			spy.target_xpath(d.getCsvDate("xpath", "phone")).sendKeys("15549061812");
			spy.target_xpath(d.getCsvDate("xpath", "next")).click();
			Thread.sleep(200);
			//密码		
			waiting.waitForElementIsEnable(d.getCsvDate("xpath", "password"));
			spy.target_xpath(d.getCsvDate("xpath", "password")).clear();
			spy.target_xpath(d.getCsvDate("xpath", "password")).sendKeys("aaaaaa");
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
