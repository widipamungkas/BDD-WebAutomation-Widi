package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPageSauce {

    public static WebDriver webDriver;

    public CheckoutPageSauce(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }


    @FindBy(xpath = "//div[@id='header_container']//div[@class='header_secondary_container']//span[@class='title']")
    private WebElement CheckOutPage;

    @FindBy(xpath = "//div[@class=\"item_pricebar\"]//button[@id=\"remove-sauce-labs-bike-light\"]")
    private WebElement removeCart;

    @FindBy(xpath = "//div[@class=\"cart_footer\"]//button[@id=\"checkout\"]")
    private WebElement clickCheckout;

    @FindBy(xpath = "//div[@id=\"header_container\"]//div[@class=\"header_secondary_container\"]//span[@class=\"title\"]")
    private WebElement information;

    @FindBy(xpath = "//div[@class=\"checkout_info\"]//div[@class=\"form_group\"]//input[@id=\"first-name\"]")
    private WebElement inputFirstName;

    @FindBy(xpath = "//div[@class=\"checkout_info\"]//div[@class=\"form_group\"]//input[@id=\"last-name\"]")
    private WebElement inputLastName;

    @FindBy(xpath = "//div[@class=\"checkout_info\"]//div[@class=\"form_group\"]//input[@id=\"postal-code\"]")
    private WebElement inputPostalCode;

    @FindBy(xpath = "//div[@class=\"checkout_buttons\"]//input[@id=\"continue\"]")
    private WebElement Continue;

    @FindBy(xpath = "//div[@class=\"summary_info_label summary_total_label\"]")
    private WebElement verifySummary;

    @FindBy(xpath = "//div[@class=\"cart_footer\"]//button[@id=\"finish\"]")
    private WebElement buttonFinish;

    @FindBy(xpath = "//div//div[@id=\"header_container\"]//div[@class=\"header_secondary_container\"]//span[@class=\"title\"]")
    private WebElement verifyComplete;

    //test calculate
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement subTotalFromUI;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxFromUI;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalFromUI;

    public boolean verifyCheckOutPage() {
        return CheckOutPage.isDisplayed();
    }

    public void removeCart(String productName) {
        removeCart.click();
    }

    public void CheckOut() {
        clickCheckout.click();
    }

    public boolean dataInformation() {
        return information.isDisplayed();
    }

    public void infoBuyer(String Username, String Lastname, String Postal) {
        System.out.println(Username);
        System.out.println(Lastname);

        inputFirstName.sendKeys(Username);
        inputLastName.sendKeys(Lastname);
        inputPostalCode.sendKeys(Postal);
    }

    public void ClickContinue() {
        Continue.click();
    }

    public boolean summary() {
        return verifySummary.isDisplayed();
    }

    public void ClickButtonFinish() {
        buttonFinish.click();
    }

    public boolean complete() {

        return verifyComplete.isDisplayed();
    }

    public boolean calculate() {
        // melakukan konversi nilai dari nilai web xpath menjadi text atau string
        String tax = taxFromUI.getText();
        String subTotal = subTotalFromUI.getText();
        String total = totalFromUI.getText();

        // mengganti nilai text tadi dengan mengeceualikan nilai yang berupa angka desimal, titik dan koma untuk nantinya dilakukan penjumlahan
        String taxCleanedString = tax.replaceAll("[^\\d,.]","");
        String subTotalCleanedString = subTotal.replaceAll("[^\\d,.]","");
        String totalCleanedString = total.replaceAll("[^\\d,.]","");

        //melakukan convert dari nilai hasil replacement untuk dilakukan penjumlahan menjadi tipe data double
        Double taxDouble = Double.parseDouble(taxCleanedString);
        Double subtotalDouble = Double.parseDouble(subTotalCleanedString);
        Double totalDouble = Double.parseDouble(totalCleanedString);
/*        System.out.println(taxDouble);
        System.out.println(subtotalDouble);
        System.out.println(totalDouble);*/

        // fungsi penjumlahan
        Double subtotaltax = taxDouble + subtotalDouble;
        //  membandingkan nilai subtotal tax dengan total double
        // jika hasil subtotal dengan nilai total sama maka
        if (subtotaltax.equals(totalDouble)) {
            System.out.println("hasil validasi harga true");
            return true;
        } else {
            System.out.println("hasil validasi harga false");
            return false;
        }
    }
}