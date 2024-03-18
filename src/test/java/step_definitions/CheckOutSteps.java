package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.asn1.cms.OtherRecipientInfo;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObject.CheckoutPageSauce;
import pageObject.InventoryPage;
import pageObject.LoginPage;


public class CheckOutSteps {
    private final WebDriver driver = Hooks.driver;
    InventoryPage inventoryPage = new InventoryPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    CheckoutPageSauce checkOut = new CheckoutPageSauce(driver);
    private Object redirected;
    private Object checkout;
    private String user;
    private Object to;
    private Object list;

    @Then("User will redirected to page checkout list")
    public void userAlreadyOnCheckOutPage() {
        Assert.assertTrue(checkOut.verifyCheckOutPage());

    }

    @And("User click remove one item {string}")
    public void userClickRemoveOneItem(String productName) {
        checkOut.removeCart(productName);
    }

    @And("User click button checkout")
    public void userClickButtonCheckout() {
        checkOut.CheckOut();
    }

    @Then("User will redirected to information buyer page")
    public void userWillRedirectedToInformationBuyer() {
        Assert.assertTrue(checkOut.dataInformation());
            }

    @And("User input {string} as FirstName and {string} as LastName and {string} as zipCode")
    public void customerInformation(String Username, String Lastname, String Postal) {
        checkOut.infoBuyer(Username, Lastname, Postal);

    }

    @Then("User click button continue")
    public void userClickButtonContinue() {
        checkOut.ClickContinue();
    }

    @And("User will redirected to checkout overview page")
    public void userWillRedirectedToCheckoutOverviewPage() {
        Assert.assertTrue(checkOut.summary());

    }

    @Then("User click finish button")
    public void userClickFinishButton() {
        checkOut.ClickButtonFinish();
    }

    @And("User will redirected to checkout complete page")
    public void userWillRedirectedToCheckoutCompletePage() {
        Assert.assertTrue(checkOut.complete());
    }

    //@And("User calculate {float} as subtotal and {float} as tax and {float} as total")
    @Then("User Validate total value")
    public void userCalculateTaxAndSubtotal() {
        Assert.assertTrue(checkOut.calculate());
    }
}
