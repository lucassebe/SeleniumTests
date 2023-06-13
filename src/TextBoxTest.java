import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxTest {
    @Test
    public void textBoxTest() {
        WebDriver browser = new ChromeDriver();
        // browser.manage().window().maximize();
        TextBoxPO textBox = new TextBoxPO(browser);
        textBox.visit();
        textBox.enterUsername(null);
        textBox.enterEmail(null);
        textBox.enterCurrentAddress(null);
        textBox.enterPermanentAddressField(null);
        textBox.enterSubmitButton();
        assertTrue(textBox.assertionName());
        assertTrue(textBox.assertionEmail());

        textBox.quit();

    }

}
