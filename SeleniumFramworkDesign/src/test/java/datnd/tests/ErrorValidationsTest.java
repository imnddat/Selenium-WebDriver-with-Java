package datnd.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import datnd.TestComponents.BaseTest;
import datnd.TestComponents.Retry;
import datnd.pageobjects.CartPage;
import datnd.pageobjects.ProductCatalogue;

public class ErrorValidationsTest extends BaseTest {

	@Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		String productName = "ZARA COAT 3";
		landingPage.LoginApplication("nguyenducdatgl@gmail.com", "Datnd2109");
//		AssertJUnit.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");

	}

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException {
		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.LoginApplication("datndhe161899@fpt.edu.vn", "Datnd2109@");

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33333");
		Assert.assertFalse(match);

	}

}
