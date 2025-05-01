package helloooooo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		//Invoking Browser

		//Chrome - ChromeDriver exten->Methods close get

		//Firefox- FirefoxDriver ->methods close get

		// WebDriver  close  get

		//WebDriver methods + class methods
		
		// chromedriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DatND\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//firefoxdriver
//		System.setProperty("webdriver.gecko.driver", "C:\\Users\\DatND\\Documents\\geckodriver.exe");
//		WebDriver driver1 = new FirefoxDriver();
		
		//Microsoft Edge
//		System.setProperty("webdriver.edge.drive", "C:\\Users\\DatND\\Documents\\msedgedriver.exe");
//		WebDriver driver2 = new EdgeDriver();
		
		driver.get("https://courses.rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
//		driver.quit();
	}

}
