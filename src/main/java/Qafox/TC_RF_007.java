package Qafox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_007 {

		@Test
		public void verifyRegisteringUsingExistingEmail() throws Throwable {
					

			ChromeDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			driver.findElement(By.id("input-email")).sendKeys("test123xyz@gmail.com");
			driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
			driver.findElement(By.id("input-password")).sendKeys("Admin@123");
			driver.findElement(By.id("input-confirm")).sendKeys("Admin@123");
			driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
			driver.findElement(By.name("agree")).click();
			
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			driver.findElement(By.linkText("Continue")).click();
			driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
				
			String expectedWarningMessage="Warning: E-Mail Address is already registered!";
			
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),expectedWarningMessage);
			
			Thread.sleep(3000);
			
			
			driver.quit();
				}
			
}
