package ExaminationTasks;

import MyStoreTestLabCodersLabPL.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

    private WebDriver driver;
    private final String email = "utdppkyctjbtgaptiw@nthrw.com";
    private final String password = "password";

//    if TRUE checks values inserted in scenario
//    if FALSE checks values inserted into the address form
    private final boolean cucumberVariableCheck = true;
    private String isAlias;
    private String isAddress;
    private String isCity;
    private String isZipCode;
    private String isCountry;
    private String isPhone;

    @Given("an opened browser with {string}")
    public void openMyStore(String url) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("button 'Sign in' is clicked")
    public void clickSignIn() {
        HomePage onHomePage = new HomePage(driver);
        onHomePage.clickSignInOnHeaderNavigationBar();
    }

    @And("correct login data is entered")
    public void enterLoginData() {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.inputLoginData(email, password);
    }

    @And("light blue 'SIGN IN' button is clicked")
    public void submitLoginData() {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.clickSignInButton();
    }

    @And("'Addresses' button is pressed")
    public void pressAddressesButton() {
        MyAccountPage onMyAccountPage = new MyAccountPage(driver);
        onMyAccountPage.clickAddressesButton();
    }

    @And("'Create new address' is clicked")
    public void clickCreateNewAddresses() {
        AddressesPage onAddressesPage = new AddressesPage(driver);
        onAddressesPage.clickCreateNewAddressOnAddressesFooter();
    }

    @And("'New address' form is filled with correct {string}, {string}, {string}, {string}, {string} and {string}")
    public void fillAddressForm(String alias, String address, String city, String zip, String country, String phone) {
        NewAddressPage onNewAddressPage = new NewAddressPage(driver);
        onNewAddressPage.inputAddressData(alias, address, city, zip, country, phone);

//        getting cucumber(TRUE) or input(FALSE) variables for further check
        if(cucumberVariableCheck) {
            isAlias = alias;
            isAddress = address;
            isCity = city;
            isZipCode = zip;
            isCountry = country;
            isPhone = phone;
        } else {
            isAlias = onNewAddressPage.getEnteredAlias();
            isAddress = onNewAddressPage.getEnteredAddress();
            isCity = onNewAddressPage.getEnteredCity();
            isZipCode = onNewAddressPage.getEnteredZipCode();
            isCountry = onNewAddressPage.getEnteredCountry();
            isPhone = onNewAddressPage.getEnteredPhone();
        }
    }

    @And("'SAVE' button is pressed")
    public void submitNewAddress() {
        NewAddressPage onNewAddressPage = new NewAddressPage(driver);
        onNewAddressPage.clickSaveButton();
    }

    @Then("the entered address has been added")
    public void newAddressAdded() {
        AddressesPage onMyAddressesPage = new AddressesPage(driver);
        Assert.assertTrue("New address has not been added as defined.",
                onMyAddressesPage.checkIfAddressIsAdded(isAlias, isAddress, isCity, isZipCode, isCountry, isPhone));
    }


}
