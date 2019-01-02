package tools;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseOver {
	
	public void over(WebDriver driver,String xpath) {
		Actions hover=new Actions(driver);
		WebElement FW=driver.findElement(By.xpath(xpath));
		hover.moveToElement(FW).build().perform();
	}
}
