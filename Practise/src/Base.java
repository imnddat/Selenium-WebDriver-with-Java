import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DatND\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Danh sách những món hàng bạn muốn mua
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };

		// Mở trang web
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		// Đợi trang load
		Thread.sleep(3000);

		// Gọi hàm để thêm sản phẩm vào giỏ hàng
		addItems(driver, itemsNeeded);
		
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0; // đếm số sản phẩm đã thêm

		// Lấy danh sách các sản phẩm hiển thị trên trang
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// Duyệt qua từng sản phẩm
		for (int i = 0; i < products.size(); i++) {

			// Lấy tên sản phẩm và cắt chuỗi theo dấu "-"
			// Ví dụ: "Cucumber - 1 Kg" -> ["Cucumber", " 1 Kg"]
			String[] name = products.get(i).getText().split("-");

			// Lấy phần tên và loại bỏ khoảng trắng thừa
			String formattedName = name[0].trim();

			// Chuyển mảng thành danh sách để dễ so sánh
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);

			// Kiểm tra xem sản phẩm đang duyệt có trong danh sách cần mua hay không
			if (itemsNeededList.contains(formattedName)) {
				j++; // tăng số sản phẩm đã thêm lên 1

				// Tìm và click vào nút "Add to cart" tương ứng với sản phẩm đó
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				// Nếu đã thêm đủ sản phẩm cần mua thì dừng lại
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}
}
