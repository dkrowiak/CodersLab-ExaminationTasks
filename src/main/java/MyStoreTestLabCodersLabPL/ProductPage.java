package MyStoreTestLabCodersLabPL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProductPage {

    private static WebDriver driver;

    public ProductPage(WebDriver driver) { this.driver = driver; }

    public void selectSize(String size) {
        WebElement sizeSelect = driver.findElement(By.xpath("//*[text()='" + size + "']"));
        sizeSelect.click();

    }
    public void setQuantity(int quantity) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement quantityInput = driver.findElement(By.cssSelector("#quantity_wanted"));
        WebElement quantityTouchSpinUpButton = driver.findElement(By.cssSelector(".btn.btn-touchspin.js-touchspin.bootstrap-touchspin-up"));
        wait.until(ExpectedConditions.elementToBeClickable(quantityInput));

        String compareString = "1";
        String onSiteQuantityInitialValue = quantityInput.getAttribute("value");
        if(onSiteQuantityInitialValue.equals(compareString)) {
            while (quantity > 1) {
                Thread.sleep(200);
                quantityTouchSpinUpButton.click();
                quantity--;
            }
        } else {
            quantityInput.click();
            Thread.sleep(200);
            quantityInput.clear();
            quantityInput.sendKeys(String.valueOf(quantity));
        }
    }

    public void clickAddProductToCart() {
        WebElement addProductToCartButton = driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart"));
        addProductToCartButton.click();
    }

    public void clickProceedToCheckout() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-content-btn .btn.btn-primary")));
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector(".cart-content-btn .btn.btn-primary"));
        proceedToCheckoutButton.click();
    }
}