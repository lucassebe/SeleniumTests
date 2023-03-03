import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class TextBoxPO {
    private WebDriver browser;
    Faker faker = new Faker(new Locale("pt-BR"));
    String fullname = faker.name().fullName();
    String email = fullname.toLowerCase().replaceAll("[\\^\\`\\á\\í\\ó\\ú\\é\\ã\\ \\ç]", "") + "@gmail.com";
    String address1 = faker.address().fullAddress();
    String address2 = faker.address().fullAddress();

    @FindBy(css = "#userName")
    private WebElement fullNameField;
    @FindBy(css = "#userEmail")
    private WebElement emailField;
    @FindBy(css = "#currentAddress")
    private WebElement currentAddressField;
    @FindBy(css = "#permanentAddress")
    private WebElement PermanentAddressField;
    @FindBy(id  = "submit")
    private WebElement submitButton;
    @FindBy(css = "#name")
    private WebElement assertionNameField;
    @FindBy(css = "#email")
    private WebElement assertionEmailField;

    // Constructor
    public TextBoxPO(WebDriver browser) {
        this.browser = browser;

        // Initialize Elements
        PageFactory.initElements(browser, this);

    }

    // Methods
    public void visit() {
        browser.get("https://demoqa.com/text-box");
    }

    public void enterUsername(String username) {
        fullNameField.sendKeys(fullname);
    }

    public void enterEmail(String mail) {
        emailField.sendKeys(email);
    }

    public void enterCurrentAddress(String addresscurrent) {
        currentAddressField.sendKeys(address1);
    }

    public void enterPermanentAddressField(String addresspermanent) {
        PermanentAddressField.sendKeys(address2);
    }

    public void enterSubmitButton() {
       WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        
    }

    public void quit() {
        browser.quit();
    }

    // Assertions
    public boolean assertionName() {
        return assertionNameField.getText().toString().contains(fullname);
    }

    public boolean assertionEmail() {
        return assertionEmailField.getText().toString().contains(email);
    }

}
