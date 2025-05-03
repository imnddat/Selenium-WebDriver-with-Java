package datnd.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import datnd.TestComponents.BaseTest;
import datnd.pageobjects.CartPage;
import datnd.pageobjects.CheckoutPage;
import datnd.pageobjects.ConfirmationPage;
import datnd.pageobjects.OrderPage;
import datnd.pageobjects.ProductCatalogue;

public class SubmitOderTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		ProductCatalogue productCatalogue = landingPage.LoginApplication("nguyenducdatgl@gmail.com", "Datnd2109@");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);

		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");

		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	}

	// To verify ZA COAT 3 is displaying in orders page
	@Test(dependsOnMethods = { "submitOrder" })
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingPage.LoginApplication("nguyenducdatgl@gmail.com", "Datnd2109@");
		OrderPage orderPage = productCatalogue.goToOrdersPage();

		Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));

	}

}
