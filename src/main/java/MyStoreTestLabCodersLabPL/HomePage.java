package MyStoreTestLabCodersLabPL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSignInOnHeaderNavigationBar() {
        WebElement signInHeaderButton = driver.findElement(By.cssSelector("#_desktop_user_info > div > a"));

        signInHeaderButton.click();
    }

    public void chooseProduct(String chosenProduct) {
        WebElement product = driver.findElement(By.xpath("//*[contains(text(), '" + chosenProduct + "')]"));
        product.click();
    }
}
