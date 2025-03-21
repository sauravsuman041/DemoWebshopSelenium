package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginStepDefinition {
	WebDriver driver;
	LoginPage page;
	
	@Given("User is on the Demo Webshop home page")
	public void user_is_on_the_demo_webshop_home_page() {
		driver = new EdgeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Log in')]")).click();
        page = new LoginPage(driver);
	  
	}

	@When("User logs in with valid credentials")
	public void user_logs_in_with_valid_credentials() {
	    page.setEmail("sauravsuman@gmail.com");
	    page.setPassword("saurav123");
	    page.clickLogin();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
	    Assert.assertEquals(driver.getCurrentUrl(), "https://demowebshop.tricentis.com/");
	    driver.quit();
	}
}
