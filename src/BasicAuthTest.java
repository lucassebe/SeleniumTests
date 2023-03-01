import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;

/***
 * Tests login feature
 */

public class BasicAuthTest {
    @Test
    public void loginvalido2() {
        // Visitar o site, configurações iniciais.
        WebDriver browser = BrowserFactory.getBrowser("Chrome");
        browser.navigate().to("https://authenticationtest.com/complexAuth/");
        // Preencher os dados com as informações.
        browser.findElement(By.id("email")).sendKeys("complex@authenticationtest.com");
        browser.findElement(By.id("password")).sendKeys("pa$$w0rd");
        // Selecionar a opção desejada no dropdown.
        Select drpLoginform = new Select(browser.findElement(By.name("selectLogin")));
        drpLoginform.selectByValue("yes");
        // Marcar o checkbox
        browser.findElement(By.id("loveForm")).click();
        // Clicar no botão de fazer Login.
        browser.findElement(By.cssSelector("input[value='Log In']")).submit();

        // Verificar a existência do texto no Código Fonte.
        boolean sucessMessage = browser.getPageSource().contains(" You are now logged in!");
        assertTrue(sucessMessage);
        // Verificar foi para a página correta após envio das informações.

        Assert.assertTrue(browser.getCurrentUrl().equals("https://authenticationtest.com/loginSuccess/"));

        browser.quit();

    }

}
