package MyStoreTestLabCodersLabPL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {

    private final WebDriver driver;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputAddressData(String alias, String address, String city, String zipPostalCode, String country, String phone) {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        WebElement addressInput = driver.findElement(By.name("address1"));
        WebElement cityInput = driver.findElement(By.name("city"));
        WebElement zipPostalCodeInput = driver.findElement(By.name("postcode"));
        WebElement countrySelect = driver.findElement(By.name("id_country"));
        Select select = new Select(countrySelect);
        WebElement phoneInput = driver.findElement(By.name("phone"));

        aliasInput.click();
        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.click();
        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);

        zipPostalCodeInput.click();
        zipPostalCodeInput.clear();
        zipPostalCodeInput.sendKeys(zipPostalCode);

        select.selectByVisibleText(country);

        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public  String getEnteredAlias() {
        WebElement aliasInput = driver.findElement(By.name("alias"));
        return aliasInput.getAttribute("value");
    }

    public  String getEnteredAddress() {
        WebElement addressInput = driver.findElement(By.name("address1"));
        return addressInput.getAttribute("value");
    }

    public  String getEnteredCity() {
        WebElement cityInput = driver.findElement(By.name("city"));
        return cityInput.getAttribute("value");
    }

    public  String getEnteredZipCode() {
        WebElement zipPostalCodeInput = driver.findElement(By.name("postcode"));
        return zipPostalCodeInput.getAttribute("value");
    }

    public  String getEnteredCountry() {
        WebElement countrySelect = driver.findElement(By.name("id_country"));
        Select select = new Select(countrySelect);
        return select.getFirstSelectedOption().getText();
    }

    public  String getEnteredPhone() {
        WebElement phoneInput = driver.findElement(By.name("phone"));
        return phoneInput.getAttribute("value");
    }

    public void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector(".btn.btn-primary.float-xs-right"));
        saveButton.click();
    }
}
