package ExaminationTasks;

import MyStoreTestLabCodersLabPL.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class Task2 {

    private final String email = "utdppkyctjbtgaptiw@nthrw.com";
    private final String password = "password";
    WebDriver driver;


    @Given("User opened browser with {string}")
    public void openMyStore(String url) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
    }
    @When("User clicks a button 'Sign in'")
    public void clickSignIn() {
        HomePage onHomePage = new HomePage(driver);
        onHomePage.clickSignInOnHeaderNavigationBar();
    }

    @And("User enters correct login data")
    public void enterLoginData() {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.inputLoginData(email, password);
    }

    @And("User clicks a light blue 'SIGN IN' button")
    public void submitLoginData() {
        LoginPage onLoginPage = new LoginPage(driver);
        onLoginPage.clickSignInButton();
    }

    @And("User goes to HomePage by clicking 'My Store' logo")
    public void clickMyStoreLogo() {
        MyAccountPage onMyAccountPage = new MyAccountPage(driver);
        onMyAccountPage.clickMyStoreHeaderTopLogo();
    }

    @And("User chooses product {string}")
    public void choseProduct(String chosenProduct) {
        HomePage onHomePage = new HomePage(driver);
        onHomePage.chooseProduct(chosenProduct);
    }

    @And("User selects size {string}")
    public void selectSize(String size) {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.selectSize(size);

    }

    @And("User sets quantity to {int}")
    public void setQuantity(int quantity) throws InterruptedException {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.setQuantity(quantity);
    }
    @And("User adds products to cart")
    public void addProductToCart() {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.clickAddProductToCart();

    }
    @And("User clicks 'Proceed to checkout'")
    public void clickProceedToCheckout() throws InterruptedException {
        ProductPage onProductPage = new ProductPage(driver);
        onProductPage.clickProceedToCheckout();
    }

    @And("User presses another 'Proceed to checkout' button")
    public void clickAnotherProceedToCheckoutButton() {
        ShoppingCartPage onShoppingCartPage = new ShoppingCartPage(driver);
        onShoppingCartPage.clickProceedToCheckout();
    }

    @And("User confirms address")
    public void confirmAddress() {
        OrderFinalizationPage onOrderFinalizationPage = new OrderFinalizationPage(driver);
        onOrderFinalizationPage.clickContinueAddressesSectionButton();
    }

    @And("User chooses product delivery option 'PrestaShop - pick up in store'")
    public void choosePickUpInStoreDeliveryOption() {
        OrderFinalizationPage onOrderFinalizationPage = new OrderFinalizationPage(driver);
        onOrderFinalizationPage.choosePickUpInStoreDeliveryOption();
    }

    @And("User confirms delivery method")
    public void confirmDeliveryMethod() {
        OrderFinalizationPage onOrderFinalizationPage = new OrderFinalizationPage(driver);
        onOrderFinalizationPage.clickContinueDeliveryMethodButton();
    }

    @And("User selects 'Pay by Check' payment option")
    public void selectPayByCheckPaymentOption() {
        OrderFinalizationPage onOrderFinalizationPage = new OrderFinalizationPage(driver);
        onOrderFinalizationPage.selectPayByCheckPaymentOption();
    }

    @And("User agrees terms of service and clicks 'Order with an obligation to pay'")
    public void acceptTermsOfServiceAndClickOrderWithObligationToPay() {
        OrderFinalizationPage onOrderFinalizationPage = new OrderFinalizationPage(driver);
        onOrderFinalizationPage.agreeTermsOfService();
        onOrderFinalizationPage.clickOrderWithAnObligationToPay();
    }

    @And("User takes screenshot of order confirmation")
    public void takeOrderConfirmationScreenshot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot)driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(source, new File("./SeleniumScreenshots/Screen.png"));
            System.out.println("Screenshot is captured");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

}
