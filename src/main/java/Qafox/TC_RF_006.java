package Qafox;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_006 {

		@Test
		public void verifyRegisterAccountByProvidingMismatchPasswords() {
			

			ChromeDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			driver.manage().window().maximize();
			driver.get("https://tutorialsninja.com/demo/");
			
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.linkText("Register")).click();
			
			driver.findElement(By.id("input-firstname")).sendKeys("Ashutosh");
			driver.findElement(By.id("input-lastname")).sendKeys("kamble");
			driver.findElement(By.id("input-email")).sendKeys(generateNewEmail());
			driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
			driver.findElement(By.id("input-password")).sendKeys("Admin@123");
			driver.findElement(By.id("input-confirm")).sendKeys("xxxxxxx");
			driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
			driver.findElement(By.name("agree")).click();
			driver.findElement(By.xpath("//input[@value='Continue']")).click();
			
			String expectedWarningMessage= "Password confirmation does not match password!";
			
			Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(),expectedWarningMessage);
			
			
			driver.quit();
		}
		
		
		public String generateNewEmail() {
			 return new Date().toString().replaceAll("\\s", "").replaceAll("\\:", "")+"@gmail.com"; 
		}
}
