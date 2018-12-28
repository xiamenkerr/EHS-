package testcase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import basePage.Open_chrome;
import basePage.TurnOn_driver;
import jubao_P.jubao;
import loginPage.login;
import tools.Browser;
import tools.BrowserType;

public class EHStest {
	@Test
	public static void main() throws Exception {
//	public static void main(String args[]) throws Exception {
//		TurnOn_driver D=new TurnOn_driver();
//		Open_chrome D=new Open_chrome();		
		login login_page=new login();
		jubao jubao=new jubao();
		Browser driver=new Browser(BrowserType.chrome);
		WebDriver drivers=driver.driver;
//		WebDriver drivers=D.setupchrome();
		login_page.login_ehs(drivers);
		jubao.run_jubao(drivers);
		
		drivers.quit(); 
//		D.teardownBrowser();
	}
}
