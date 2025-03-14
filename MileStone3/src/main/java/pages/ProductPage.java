package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basepage.BasePage;

public class ProductPage extends BasePage {
	
	Actions action;

	public ProductPage(WebDriver webDriver) {
		super(webDriver);
		action = new Actions(webDriver);
		PageFactory.initElements(webDriver , this);
	}
	
	@FindBy(xpath = "//a[contains(text(),'Computers')]")
	WebElement computerMenu;
	
	@FindBy(xpath = "//a[contains(text(),'Desktops')]")
	WebElement desktopMenu;
	
	@FindBy(xpath = "(//div[@class='item-box'])[2]")
	WebElement secondProduct;
	
	@FindBy(id = "product_attribute_16_6_5")
	WebElement ramDropdown;
	
	@FindBy(id = "product_attribute_16_3_6_19")
	WebElement hddOptions;
	
	@FindBy(xpath = "//input[@value='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(className = "ico-cart")
	WebElement shoppingCartBtn;
	
	
	public void navigateToDesktopSection() {
		action.moveToElement(computerMenu).click(desktopMenu).perform();
		wait.until(ExpectedConditions.urlContains("desktops"));
    }
	
	public void selectSecondProduct() {
		wait.until(ExpectedConditions.elementToBeClickable(secondProduct));
        secondProduct.click();
        wait.until(ExpectedConditions.urlContains("build-your-own-computer"));
    }

    public void selectRAM(String ram) {
        ramDropdown.sendKeys(ram);
    }

    public void selectHDD(String hdd) {
        hddOptions.click();
    }

    public void clickAddToCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        addToCartBtn.click();
    }
    
    public void proceedToCart() {
    	wait.until(ExpectedConditions.elementToBeClickable(shoppingCartBtn));
        shoppingCartBtn.click();
    }

}
