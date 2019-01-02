package testcase;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basePage_ehs.Open_chrome;
import tools.MouseOver;

public class Upload {
	@Test
	public static void main() throws InterruptedException {
//	public static void main(String[] args) throws InterruptedException {
		WebDriver drivers;
		Open_chrome chro=new Open_chrome();
		drivers=chro.setupchrome();
		drivers.get("http://hbtz.ahjdev.top/index/index/them.html");
		Thread.sleep(1000);
		MouseOver mouse=new MouseOver();
		mouse.over(drivers, "//h3[text()='环境管理台账']");
		drivers.findElement(By.xpath("//a[contains(@href,'book.html')]/span")).click();
		Thread.sleep(2000);
		drivers.findElement(By.xpath("//div[@class='v-text-field__slot']/input")).click();
		drivers.findElement(By.xpath("//div[@class='v-text-field__slot']/input")).sendKeys("15038216845");
		drivers.findElement(By.xpath("//div[@class='v-btn__content']")).click();
		Thread.sleep(1000);
		drivers.findElement(By.xpath("//div[@class='v-text-field__slot']/input")).click();
		drivers.findElement(By.xpath("//div[@class='v-text-field__slot']/input")).sendKeys("aaaaaa");
		Thread.sleep(1000);
		drivers.findElement(By.xpath("//*[@id=\"inspire\"]/div[2]/div/div[1]/div/div/div/div[2]/div/div[2]/div/button")).click();
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//a[contains(@href,'project.html')]")).click();
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//a[contains(@href,'/index/index/book_list/id/78')]")).click();
		Thread.sleep(3000);
		drivers.findElement(By.xpath("//a[@id='up']")).click();
		Thread.sleep(1500);
		
		File file=new File("C:\\Users\\Administrator\\Desktop\\表A.2 生产设施运行管理信息表 .xlsx");
		drivers.get(file.getAbsolutePath());
		WebElement ifr3=drivers.findElement(By.xpath("//div[@class='layui-layer-content']/iframe"));
		drivers.switchTo().frame(ifr3);
		drivers.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Administrator\\Desktop\\表A.2 生产设施运行管理信息表 .xlsx");
		Thread.sleep(500);
		drivers.switchTo().defaultContent();
		drivers.findElement(By.xpath("//a[@class='layui-layer-btn0']")).click();
		Thread.sleep(1500);
		
		
		
		
		
		
		
		chro.teardownBrowser();
	}
}
