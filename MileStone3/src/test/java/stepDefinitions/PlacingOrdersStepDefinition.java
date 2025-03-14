package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;

public class PlacingOrdersStepDefinition {
	
	WebDriver driver;
	LoginPage loginpage;
	ProductPage ppage;
	CheckoutPage page;
	
	@Given("User is on the checkout page")
	public void user_is_on_the_checkout_page() {
		driver = new EdgeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
        loginpage = new LoginPage(driver);
        ppage = new ProductPage(driver);
        page = new CheckoutPage(driver);
        loginpage.setEmail("sauravsuman@gmail.com");
	    loginpage.setPassword("saurav123");
	    loginpage.clickLogin();
	}

	@When("User completes checkout with Cash on Delivery")
	public void user_completes_checkout_with_cash_on_delivery() {
	    ppage.proceedToCart();
	    page.agreeToTerms();
	    page.clickCheckoutButton();
	    page.fillInDetails();
	}

	@Then("Order confirmation should display {string}")
	public void order_confirmation_should_display(String string) {
	    Assert.assertEquals(page.getConfirmationMessage(), "Your order has been successfully processed!");
	}

	@Then("User logs out successfully")
	public void user_logs_out_successfully() {
		page.logout();
		driver.quit();
	}


}
