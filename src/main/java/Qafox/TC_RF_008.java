package Qafox;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_008 {

	@Test
	public void verifyRegisteringInvalidEmail() throws InterruptedException, IOException {
		
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		
		driver.findElement(By.id("input-firstname")).sendKeys("Ashutosh");
		driver.findElement(By.id("input-lastname")).sendKeys("kamble");
		driver.findElement(By.id("input-email")).sendKeys("ashu");
		driver.findElement(By.id("input-telephone")).sendKeys("1234567890");
		driver.findElement(By.id("input-password")).sendKeys("Admin@123");
		driver.findElement(By.id("input-confirm")).sendKeys("xxxxxxx");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
		
		File srcScreenshot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcScreenshot1, new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		
		BufferedImage actualBimg=ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		BufferedImage expectedBimg=ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1expected.png"));
		
		ImageDiffer imgDiffer = new ImageDiffer();
		ImageDiff imgDifference = imgDiffer.makeDiff(expectedBimg, actualBimg); //makediff will return some diff
		
		
		boolean b=imgDifference.hasDiff();
		System.out.println(b);	
		//Assert.assertFalse(imgDifference.hasDiff());// returns boolean value
	
		
		driver.quit();
		
	} 
	
	
}
