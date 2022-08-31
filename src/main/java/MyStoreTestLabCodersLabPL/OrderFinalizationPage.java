package MyStoreTestLabCodersLabPL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderFinalizationPage {

    private static WebDriver driver;

    @FindBy(name = "confirm-addresses")
    WebElement continueAddressesButton;
    @FindBy(id = "delivery_option_1")
    WebElement prestaShopRadio;
    @FindBy(id = "delivery_option_2")
    WebElement MyCarrierRadio;
    @FindBy(css = "#cart-subtotal-shipping > span.value")
    WebElement shippingValue;
    @FindBy(name = "confirmDeliveryOption")
    WebElement continueDeliveryMethodButton;
    @FindBy(id = "payment-option-1")
    WebElement payByCheckRadio;
    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsOfServiceCheckbox;
    @FindBy(css = ".btn.btn-primary.center-block")
    WebElement orderWithAnObligationToPayButton;

    public OrderFinalizationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickContinueAddressesSectionButton() {

        continueAddressesButton.click();
    }

    public void choosePickUpInStoreDeliveryOption() {
        String shippingFee = "Free";
        if (shippingFee.equals(shippingValue.getText())) {
//            DO NOTHING
        } else prestaShopRadio.click();
    }

    public void clickContinueDeliveryMethodButton() {
        continueDeliveryMethodButton.click();
    }

    public void selectPayByCheckPaymentOption() {
        if(!payByCheckRadio.isSelected())
            payByCheckRadio.click();
    }

    public void agreeTermsOfService() {
        if(!termsOfServiceCheckbox.isSelected())
            termsOfServiceCheckbox.click();
    }

    public void clickOrderWithAnObligationToPay() {
        if(orderWithAnObligationToPayButton.isEnabled()) {
            orderWithAnObligationToPayButton.click();
        } else throw new RuntimeException("OrderWithAnObligationToPay button is disabled."
                + "\nChoosing payment method and accepting Terms of Service are obligatory.");
    }
}
