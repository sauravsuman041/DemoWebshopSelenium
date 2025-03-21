package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basepage.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver , this);
	}
	
	
	@FindBy(id="Email")
	WebElement emailWebElement;
	
	@FindBy(id="Password")
	WebElement passwordWebElement;
	
	@FindBy(xpath = "//input[@value='Log in']")
	WebElement submitWebElement;
	
	
	public void setEmail(String username) {
		wait.until(ExpectedConditions.urlContains("login"));
		enterText(emailWebElement, username);
	}
	public void setPassword(String password) {
		enterText(passwordWebElement, password);
	}
	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(submitWebElement));
		onClick(submitWebElement);
		wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
	}
}
