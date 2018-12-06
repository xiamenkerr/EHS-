package tools;

import org.openqa.selenium.WebDriver;

public class swichWin {
	public void swich(String currentWin,WebDriver driver ) {
		java.util.Set<String> handles=driver.getWindowHandles(); 
		for(String i : handles) {	
			if (i.equals(currentWin)==false){
				driver.switchTo().window(i);//切换到第二个窗口的句柄
				break;
				}	
			}
	}
}