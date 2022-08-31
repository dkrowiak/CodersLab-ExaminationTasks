package MyStoreTestLabCodersLabPL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private static WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".text-sm-center .btn.btn-primary")
    WebElement proceedToCheckoutButton;

    public void clickProceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}
