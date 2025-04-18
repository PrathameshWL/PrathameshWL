package Qafox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Pass {
	
			@Test
	    	public void copypassandpastetootherpage()
			{
				

				ChromeDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.manage().window().maximize();

	        try {
	        	
	        	driver.get("https://dev.1024.info/en-default/studio/rapid-index.html");
	        	
	        	driver.findElement(By.xpath("//input[@name='login']")).sendKeys("prathamesh.kamble");
	        	driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("BQBSmflthX");
	        	
	        	driver.findElement(By.xpath("//input[@value='Enter']")).click();
	            // 1. Open the source page (where the password is stored)
	    

	            // Let the page load
	            Thread.sleep(2000);

	            // 2. Locate the password field (or div/span containing password)
	            WebElement passwordField = driver.findElement(By.xpath("//a[@class='js-password-trigger']")); // Change this ID

	            // 3. Get the password text
	            String password = passwordField.getAttribute("value"); // or use .getText() for spans/divs
	            System.out.println("Password copied: " + password);

	            // 4. Open the destination page
	            driver.get("https://ds.wellnessliving.com/");
	            Thread.sleep(2000);

	            // 5. Locate the username and password input fields
	            WebElement usernameInput = driver.findElement(By.xpath("//input[@class='css-input-type-text']")); // Change to actual ID
	            WebElement passwordInput = driver.findElement(By.xpath("//input[@class='css-input-type-text js-field-password']")); // Change to actual ID

	            // 6. Enter credentials
	            usernameInput.sendKeys("prathamesh.kamble"); // Replace with actual username
	            passwordInput.sendKeys(password); // Paste copied password

	            // 7. Optionally, click login
	            WebElement loginButton = driver.findElement(By.xpath("//input[@value='Sign in']")); // Replace ID
	            loginButton.click();

	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close browser after a pause
	            try {
	                Thread.sleep(5000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            driver.quit();
	        }
	    }
	}



