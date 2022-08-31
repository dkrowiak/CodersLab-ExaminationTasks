package MyStoreTestLabCodersLabPL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddressesPage {

    private final WebDriver driver;

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreateNewAddressOnAddressesFooter() {
        WebElement createNewAccountLink = driver.findElement(By.cssSelector("[data-link-action=add-address]"));
        createNewAccountLink.click();
    }

    public Boolean checkIfAddressIsAdded(String alias, String address, String city, String zip, String country, String phone) {
        boolean isAdded;
        WebElement isSuccess = driver.findElement(By.cssSelector("article[data-alert=success]"));
        WebElement sectionContent = driver.findElement(By.cssSelector("#content"));

//        if there is an address, there will be 0 alerts
//        List<WebElement> alerts = By.className("alert").findElements(driver);
        isAdded = /* alerts.isEmpty() && */ isSuccess.isDisplayed() &&
                sectionContent.getText().contains(alias) &&
                sectionContent.getText().contains(address) &&
                sectionContent.getText().contains(city) &&
                sectionContent.getText().contains(zip) &&
                sectionContent.getText().contains(country) &&
                sectionContent.getText().contains(phone);
        return isAdded;
    }
}
