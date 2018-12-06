package jubao_P;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import tools.Waite;
import tools.find;
import tools.getcsv;
import tools.swichWin;

public class jubao {
	public void run_jubao(WebDriver driver) throws InterruptedException {
		getcsv	d=new getcsv("E:\\eclipse-workspace\\EHS\\src\\main\\java\\Lib\\yinhuan_paicha.csv");
		find spy=new find(driver);
		swichWin ff=new swichWin();
		Waite waiting=new Waite(driver);
//		Actions action1 = new Actions(driver);
		 
//		获取当前页面的句柄
		String currentWin3= driver.getWindowHandle();
//		try{
//	        //定位窗口
//	        driver.switchTo().window(driver.getWindowHandles().iterator().next());
//	        return true;
//	    }catch(Exception e){
//	        System.out.println(e.getMessage());
//	        return false;
//	    }
//		action1.sendKeys(Keys.ESCAPE).perform();
//		driver.switchTo().alert().accept();
		//切换至EHS首页的iframe里面去
		WebElement ifr=spy.target_xpath(d.getCsvDate("xpath", "ifr"));
		driver.switchTo().frame(ifr);
		spy.target_xpath(d.getCsvDate("xpath", "yinhuan_a")).click();
		driver.switchTo().defaultContent();
		//sleep3秒防止页面未加载出来，导致下面脚本的元素无法被正常点击
		Thread.sleep(3000);
		driver.close();
		ff.swich(currentWin3, driver);
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		waiting.waitForElementIsEnable(d.getCsvDate("xpath", "sanwei_a"));
//		Thread.sleep(500);
		//JS脚本强制点击被隐藏的元素
//		JavascriptExecutor je =(JavascriptExecutor) driver;
		WebElement ele=spy.target_xpath(d.getCsvDate("xpath", "sanwei_a"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()", ele);
//		spy.target_xpath(d.getCsvDate("xpath", "sanwei_a")).click();
//		Thread.sleep(500);
		//1、切换至企业隐患排查治理系统iframe里面去，2、新建设置
		WebElement ifr2=spy.target_xpath(d.getCsvDate("xpath", "ifr2"));
		driver.switchTo().frame(ifr2);
		waiting.waitForElementIsEnable(d.getCsvDate("xpath", "add"));
		Thread.sleep(200);
		spy.target_xpath(d.getCsvDate("xpath", "add")).click();
		//点击完新建按钮切换出来
		driver.switchTo().defaultContent();
		waiting.waitForElementIsEnable(d.getCsvDate("xpath", "add_div"));
		//切换至三违设置弹框里面的iframe里面去
		Thread.sleep(500);
		WebElement addifr=spy.target_xpath(d.getCsvDate("xpath", "add_ifr"));
		driver.switchTo().frame(addifr);
		//三违行为
		spy.target_xpath(d.getCsvDate("xpath", "xingwei")).click();
		Thread.sleep(500);
		spy.target_xpath(d.getCsvDate("xpath", "xingwei_tr")).click();
		//三违描述
		spy.target_xpath(d.getCsvDate("xpath", "mioashu")).click();
		spy.target_xpath(d.getCsvDate("xpath", "mioashu")).sendKeys(d.getCsvDate("xpath", "ms_value"));
		Thread.sleep(500);
		//处理方式
		spy.target_xpath(d.getCsvDate("xpath", "fangshi")).click();
		Thread.sleep(500);
		spy.target_xpath(d.getCsvDate("xpath", "fangshi_tr")).click();
		//处理依据
		spy.target_xpath(d.getCsvDate("xpath", "yiju")).click();
		spy.target_xpath(d.getCsvDate("xpath", "yiju")).sendKeys(d.getCsvDate("xpath", "yj_value"));
		//确认提交
		driver.switchTo().defaultContent();
		spy.target_xpath(d.getCsvDate("xpath", "confirm_btn1")).click();
		Thread.sleep(500);
		spy.target_xpath(d.getCsvDate("xpath", "confirm_btn2")).click();
		Thread.sleep(500);
//		driver.switchTo().defaultContent();
		
		//3、删除新加的三违库设置
		//切换至企业隐患排查治理系统iframe里面去
		driver.switchTo().frame(ifr2);
		waiting.waitForElementPresent(d.getCsvDate("xpath", "keyword"));
		spy.target_xpath(d.getCsvDate("xpath", "keyword")).click();
		spy.target_xpath(d.getCsvDate("xpath", "keyword")).sendKeys(d.getCsvDate("xpath", "ms_value"));
		spy.target_xpath(d.getCsvDate("xpath", "sousuo1")).click();
		//等待加载完搜索的数据
		Thread.sleep(1000);
		spy.target_xpath(d.getCsvDate("xpath", "checkbox")).click();
		spy.target_xpath(d.getCsvDate("xpath", "dele")).click();
		driver.switchTo().defaultContent();
		waiting.waitForElementPresent(d.getCsvDate("xpath", "dele_btn"));
		spy.target_xpath(d.getCsvDate("xpath", "dele_btn")).click();		
		//4、新加三违举报
		spy.target_xpath(d.getCsvDate("xpath", "jubao")).click();
		driver.switchTo().frame(ifr2);
		waiting.waitForElementPresent(d.getCsvDate("xpath", "jubao_add"));
		spy.target_xpath(d.getCsvDate("xpath", "jubao_add")).click();
		Thread.sleep(1000);
		//点击完新建按钮切换出来
		driver.switchTo().defaultContent();
		waiting.waitForElementIsEnable(d.getCsvDate("xpath", "add_div"));
		//切换至新建三违举报里面的iframe里面去
		Thread.sleep(500);
		WebElement addifr2=spy.target_xpath(d.getCsvDate("xpath", "add_ifr2"));
		driver.switchTo().frame(addifr2);
		Actions action = new Actions(driver);
		//三违行为
		spy.target_xpath(d.getCsvDate("xpath", "xingwei")).click();
		Thread.sleep(500);
		spy.target_xpath(d.getCsvDate("xpath", "xingwei_tr2")).click();
		//三违描述
		spy.target_xpath(d.getCsvDate("xpath", "mioashu")).click();
		Thread.sleep(500);
		action.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
		Thread.sleep(200);
		//违规人部门
/*		WebElement webelement=driver.findElement(By.id("ViolateBranchID$text"));
	    String name = "河南恒硕实业集团";
	    webelement.click();
	    ((JavascriptExecutor)driver).executeScript("arguments[0].value=arguments[1]",webelement, name);   //js强制赋值
	    Thread.sleep(1000);
	    webelement.click();
	    Thread.sleep(2000);*/
		WebElement bu=spy.target_xpath(d.getCsvDate("xpath", "bumen"));
		bu.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[text()='河南恒硕实业集团']")).click();
//		WebElement bu_div=spy.target_xpath(d.getCsvDate("xpath", "bumen_div"));
//		action.moveToElement(bu_div,130,14).click().perform();
//		WebElement bu_ele=spy.target_xpath(d.getCsvDate("xpath", "bumen_tr6"));
//		System.out.println(bu_ele.getText());
//		System.out.println(bu_ele.isEnabled());
//		System.out.println(bu_ele.isDisplayed());
//		action.doubleClick(bu_ele).perform();
		
//		Thread.sleep(500);
//		bu_ele.click();
//		String js="var q=document.getElementsByClassName('mini-tree-nodetext').children[1].click()";
//		((JavascriptExecutor) driver).executeScript(js);
//		((JavascriptExecutor)driver).executeScript("arguments[0].click()", bu_ele);
//		action.sendKeys(Keys.ENTER).perform();
//		spy.target_xpath(d.getCsvDate("xpath", "bumen_tr2")).click();
		//违规人姓名
		spy.target_xpath(d.getCsvDate("xpath", "name")).click();
		Thread.sleep(500);
		spy.target_xpath(d.getCsvDate("xpath", "name")).sendKeys(d.getCsvDate("xpath", "name_value"));
		//违规发生地
		spy.target_xpath(d.getCsvDate("xpath", "Location")).click();
		Thread.sleep(500);
		spy.target_xpath(d.getCsvDate("xpath", "Location")).sendKeys(d.getCsvDate("xpath", "Lo_value"));
		//违规时间
		spy.target_xpath(d.getCsvDate("xpath", "time")).click();
		Thread.sleep(500);
		spy.target_xpath(d.getCsvDate("xpath", "today")).click();
		Thread.sleep(500);
		//确认提交
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		spy.target_xpath(d.getCsvDate("xpath", "confirm_btn3")).click();
		Thread.sleep(00);
		spy.target_xpath(d.getCsvDate("xpath", "confirm_btn4")).click();
		System.out.println("点击成功");
		
		
	}
}
