import java.time.Duration;
import java.util.Locale;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class GroceryCRUDPage {
    //Faker....
    Faker faker = new Faker(new Locale("pt-BR"));
    String customerName = faker.name().fullName();
    String contactFirstName = faker.name().firstName();
    String contactLastName = faker.name().lastName();
    String phone = faker.name().firstName();
    String addressLine1 = faker.address().streetAddress();
    String addressLine2 = faker.address().secondaryAddress(); 
    String city = faker.address().city(); 
    String state = faker.address().state();
    String postalCode = faker.address().zipCode();
    String country = faker.address().country();
    

    //Find By...

    @FindBy (css = "#field-customerName")
    private WebElement customerNameField;
    @FindBy (css= "#field-contactLastName")
    private WebElement contactLastNameField; 
    @FindBy (css= "#field-contactFirstName")
    private WebElement contactFirstNameField; 
    @FindBy (css= "#field-phone")
    private WebElement phoneField; 
    @FindBy (css= "#field-addressLine1")
    private WebElement addressLine1Field; 
    @FindBy (css= "#field-addressLine2")
    private WebElement addressLine2Field; 
    @FindBy (css= "#field-city")
    private WebElement cityField; 
    @FindBy (css= "#field-state")
    private WebElement stateField; 
    @FindBy (css= "#field-postalCode")
    private WebElement postalCodeField; 
    @FindBy (css= "#field-country")
    private WebElement countryField; 
    @FindBy (id = "form-button-save")
    private WebElement saveButtonElement;
    @FindBy (css= "div[id='report-success'] p")
    private WebElement sucessAssert;



    // Constructor
    private WebDriver browser;
    public GroceryCRUDPage(WebDriver browser) {
        this.browser = browser;

        // Initialize Elements
        PageFactory.initElements(browser, this);

    }


    // Methods
    public void visit() {
        browser.get("https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap-v5/add");
    }

    public void enterCustomerName(){
        customerNameField.sendKeys(customerName);
    } 
    public void enterContactFirstName(){
        contactFirstNameField.sendKeys(contactFirstName);
    }
    public void enterContactLastName(){
        contactLastNameField.sendKeys(contactLastName);
    }
    public void enterPhone(){
        phoneField.sendKeys(phone);
    }
    public void enterAddressLine1(){
        addressLine1Field.sendKeys(addressLine1);
    }
    public void enterAddressLine2(){
        addressLine2Field.sendKeys(addressLine2);
    }
    public void enterCity(){
        cityField.sendKeys(city);
    }
    public void enterState(){
        stateField.sendKeys(state);
    }
    public void enterPostalCode(){
        postalCodeField.sendKeys(postalCode);
    }
    public void enterCountry(){
        countryField.sendKeys(country);
    }
    public void submitButton(){
        JavascriptExecutor executor = (JavascriptExecutor)browser;
        executor.executeScript("arguments[0].click();", saveButtonElement);
    }
    public boolean sucessfullRegister(){
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(sucessAssert));
        return sucessAssert.getText().toString().contains("Your data has been successfully stored into the database.");
    }
    public void quit(){
        browser.quit();
    }
}
