import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TextBoxTest {
    @Test
    public void textBoxTest() {
        WebDriver browser = BrowserFactory.getBrowser("Chrome");
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
