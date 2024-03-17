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
    public void userAlreadyOnCheckOutPage() throws InterruptedException{
        Assert.assertTrue(checkOut.verifyCheckOutPage());
        Thread.sleep(3000);
    }

    @And("User click remove one item {string}")
    public void userClickRemoveOneItem(String productName) throws InterruptedException{
        checkOut.removeCart(productName);
        Thread.sleep(5000);
    }

    @And("User click button checkout")
    public void userClickButtonCheckout() {
        checkOut.CheckOut();
    }

    @Then("User will redirected to Information Buyer")
    public void userWillRedirectedToInformationBuyer() {
        Assert.assertTrue(checkOut.dataInformation());
            }

    @And("User input {string} as FirstName and {string} as LastName and {string} as zipCode")
    public void customerInformation(String Username, String Lastname, String Postal) throws InterruptedException{
        checkOut.infoBuyer(Username, Lastname, Postal);
        Thread.sleep(3000);
    }

    @Then("User click button continue")
    public void userClickButtonContinue() {
        checkOut.ClickContinue();
    }

    @And("User will redirected to Checkout Overview Page")
    public void userWillRedirectedToCheckoutOverviewPage() throws InterruptedException{
        Assert.assertTrue(checkOut.summary());
        Thread.sleep(4000);
    }

    @Then("User click finish button")
    public void userClickFinishButton() {
        checkOut.ClickButtonFinish();
    }

    @And("User will redirected to Checkout Complete page")
    public void userWillRedirectedToCheckoutCompletePage() throws InterruptedException{
        Assert.assertTrue(checkOut.complete());
        Thread.sleep(4000);
    }

    //@And("User calculate {float} as subtotal and {float} as tax and {float} as total")
    @Then("User Validate total value")
    public void userCalculateTaxAndSubtotal() {
        Assert.assertTrue(checkOut.calculate());
    }
}
