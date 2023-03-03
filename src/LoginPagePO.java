import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePO {
    private WebDriver driver;

    @FindBy(css = "#input-email")
    private WebElement usernameField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(css = "input[value='Login']")
    private WebElement loginButton;

    @FindBy(css = "div[id='content'] div:nth-child(1) h2:nth-child(1)")
    private WebElement myAccount;

    // Constructor
    public LoginPagePO(WebDriver driver) {
        this.driver = driver;

        // Initialise Elements
        PageFactory.initElements(driver, this);

    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void close() {
        driver.close();
    }

    

    // Assertions
    public boolean isLoginSuccessful() {
        if (driver.getCurrentUrl()
                .equals("https://ecommerce-playground.lambdatest.io/index.php?route=account/account")) {

        }
        return true;
    }
    public boolean loginConfirmation(){
        return myAccount.getText().toString().contains("My Account");

    }

}
