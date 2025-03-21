package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import basepage.BasePage;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver , this);
	}
	
	@FindBy(id = "termsofservice")
	WebElement termsCheckBox;
	
	@FindBy(id = "checkout")
	WebElement checkOutBtn;
	
	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	WebElement billingBtn;
	
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	WebElement shippingBtn;
	
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
	WebElement shippingMethodBtn;
	
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
	WebElement paymentMethodBtn;
	
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
	WebElement paymentInfoBtn;
	
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
	WebElement confirmOrderBtn;
	
	@FindBy(id = "paymentmethod_0")
	WebElement paymentMethod;
	
	@FindBy(id = "confirm-order")
	WebElement confirmBtn;
	
	@FindBy(xpath = "//div[contains(@class,'order-completed')]//strong")
	WebElement confirmationMessage;
	
	@FindBy(xpath = "//a[contains(text(),'Log out')]")
	WebElement logoutBtn;

	public void agreeToTerms() {
		termsCheckBox.click();
    }

    public void clickCheckoutButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn));
        checkOutBtn.click();
    }

    public void selectPaymentMethod(String method) {
    	wait.until(ExpectedConditions.elementToBeClickable(paymentMethod));
        paymentMethod.click();
    }

    public void confirmOrder() {
    	wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirmBtn.click();
    }

    public String getConfirmationMessage() {
    	wait.until(ExpectedConditions.urlContains("completed"));
        return confirmationMessage.getText();
    }

    public void logout() {
    	wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutBtn.click();
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));
    }
    
    public void fillInDetails() {
    	wait.until(ExpectedConditions.elementToBeClickable(billingBtn));
    	billingBtn.click();
    	wait.until(ExpectedConditions.elementToBeClickable(shippingBtn));
    	shippingBtn.click();
    	wait.until(ExpectedConditions.elementToBeClickable(shippingMethodBtn));
    	shippingMethodBtn.click();
    	wait.until(ExpectedConditions.elementToBeClickable(paymentMethodBtn));
    	paymentMethod.click();
    	paymentMethodBtn.click();
    	wait.until(ExpectedConditions.elementToBeClickable(paymentInfoBtn));
    	paymentInfoBtn.click();
    	wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));
    	confirmOrderBtn.click();
    }
}
