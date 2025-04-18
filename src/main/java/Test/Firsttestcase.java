package Test;

import org.openqa.selenium.chrome.ChromeDriver;

public class Firsttestcase {

	public static void main(String[] args) {

		ChromeDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		String act_title=driver.getTitle();
		if(act_title.equals("Swag Labs"))
		{
			System.out.println("Test Passed");
		}
		else {
			
			System.out.println("Test Failed");
		}
		
		driver.close();
	}
	

}
