import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.edge.drive", "C:\\Users\\DatND\\Documents\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com");
		
		Actions a = new Actions(driver);
		
		WebElement move = driver.findElement(By.xpath("//div[@id='nav-link-accountList']//a[1]"));
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
//		a.moveToElement(move).build().perform();
		a.moveToElement(move).contextClick().build().perform();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
