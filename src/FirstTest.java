import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


/***
 * Tests login feature
 */
public class FirstTest {
@Test
    public void loginvalido() {
        // Visitar o site, configurações iniciais.
        WebDriver browser = BrowserFactory.getBrowser("Chrome");
        browser.navigate().to("https://authenticationtest.com/");
        // Clicar no botão de Login
        browser.findElement(By.cssSelector(
                "body > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(3)"))
                .click();
        // Preencher os dados com as informações.
        browser.findElement(By.cssSelector("#email")).sendKeys("simpleForm@authenticationtest.com");
        browser.findElement(By.cssSelector("#password")).sendKeys("pa$$w0rd");
        // Clicar no botão de fazer Login.
        browser.findElement(By.cssSelector("input[value='Log In']")).submit();

        // Verificar foi para a página correta após envio das informações.
        Assert.assertTrue(browser.getCurrentUrl().equals("https://authenticationtest.com/loginSuccess/"));

        browser.quit();

    }
}
