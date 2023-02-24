import java.time.Duration;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FourthTest {
    @Test
    public void progressbar() {
        WebDriver browser = BrowserFactory.getBrowser("Chrome");
        browser.manage().window().maximize();
        browser.navigate().to("https://demoqa.com/progress-bar");
        WebElement startStopButton = browser.findElement(By.cssSelector("#startStopButton"));
        startStopButton.click();
        WebElement wait = new WebDriverWait(browser, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#resetButton")));
        wait.click();
        browser.close();

    }

}
