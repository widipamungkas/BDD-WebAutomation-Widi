package step_definitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObject.InventoryPage;
import pageObject.LoginPage;

public class InventorySteps {
        private final WebDriver driver = Hooks.driver;
        InventoryPage inventoryPage = new InventoryPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        @When("User sort product by {string}")
        public void sortProduct(String text) {
            inventoryPage.selectSortProduct(text);

        }

        @And("User click add to cart item sauce labs fleece jacket")
        public void userClickAddToCartItemSauceLabsFleeceJacket() {
            inventoryPage.clickProductSauceJacket();
        }

    @And("User add to click button add to cart item {string}")
    public void userAddToClickButtonAddToCartItem(String item)  {
        inventoryPage.clickAddToCartItem(item);

    }

    @And("User click icon badge to cart for checkout")
    public void userClickIconBadgeToCartForCheckout() {
            inventoryPage.clickIconCartBadge();
    }
}

