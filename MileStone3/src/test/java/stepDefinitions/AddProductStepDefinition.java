package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductPage;

public class AddProductStepDefinition {
	
	WebDriver driver;
	LoginPage loginpage;
	ProductPage page;
	
	@Given("User is logged in")
	public void user_is_logged_in() {
		driver = new EdgeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
        loginpage = new LoginPage(driver);
        page = new ProductPage(driver);
        loginpage.setEmail("sauravsuman@gmail.com");
	    loginpage.setPassword("saurav123");
	    loginpage.clickLogin();
		
	}

	@When("User navigates to Computer and then Desktop section")
	public void user_navigates_to_computer_and_then_desktop_section() {
	   page.navigateToDesktopSection();
	}

	@When("User selects the second desktop")
	public void user_selects_the_second_desktop() {
	    page.selectSecondProduct();
	}

	@When("User selects RAM and HDD options and adds to cart")
	public void user_selects_ram_and_hdd_options_and_adds_to_cart() {
	    page.selectRAM("8 GB");
	    page.selectHDD("400 GB");
	    page.clickAddToCart();
	}

	@When("User proceeds to shopping cart and agrees to terms")
	public void user_proceeds_to_shopping_cart_and_agrees_to_terms() {
		page.proceedToCart();
	}

	@Then("User should be on the checkout page")
	public void user_should_be_on_the_checkout_page() {
		Assert.assertTrue((driver.getCurrentUrl()).contains("cart"));
		driver.quit();
	}



}
