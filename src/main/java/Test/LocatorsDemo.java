package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo {

	public static void main(String[] args) {

		
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.saucedemo.com/");
			
			driver.manage().window().maximize();
			//name
			driver.findElement(By.name("user-name")).sendKeys("standard_user");
			//id
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			
			//class
			
			driver.findElement(By.id("login-button")).click();
			
			driver.close();
	}

}
