import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GroceryCRUDTest {
    @Test
    public void groceryCRUDTest() {
        WebDriver browser = new ChromeDriver();

        GroceryCRUDPage groceryCRUD = new GroceryCRUDPage(browser);
        // browser.manage().window().maximize();
        groceryCRUD.visit();
        groceryCRUD.enterCustomerName();
        groceryCRUD.enterContactFirstName();
        groceryCRUD.enterContactLastName();
        groceryCRUD.enterPhone();
        groceryCRUD.enterAddressLine1();
        groceryCRUD.enterAddressLine2();
        groceryCRUD.enterCity();
        groceryCRUD.enterState();
        groceryCRUD.enterPostalCode();
        groceryCRUD.enterCountry();
        groceryCRUD.submitButton();
        assertTrue(groceryCRUD.sucessfullRegister());
        groceryCRUD.quit();
    }

}
