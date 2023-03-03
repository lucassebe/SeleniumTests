
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class LoginPagePOTest {

    @Test
    public void testLogin() {
        WebDriver driver = BrowserFactory.getBrowser("Chrome");
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
        LoginPagePO loginPage = new LoginPagePO(driver);
        loginPage.enterUsername("AlineBrum@gmail.com");
        loginPage.enterPassword("Clefable");
        loginPage.clickLoginButton();
        assertTrue(loginPage.isLoginSuccessful());
        System.out.println(loginPage.isLoginSuccessful());
        assertTrue(loginPage.loginConfirmation());
        loginPage.close();

    }

}
