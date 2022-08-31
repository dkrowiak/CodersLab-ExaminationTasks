package MyStoreTestLabCodersLabPL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {

    private static WebDriver driver;

    @FindBy(css = ".logo.img-responsive")
    WebElement myStoreHeaderTopLogo;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAddressesButton() {
        WebElement addressesButton = driver.findElement(By.id("addresses-link"));
        addressesButton.click();
    }
    public void clickMyStoreHeaderTopLogo() {
        myStoreHeaderTopLogo.click();
    }
}
