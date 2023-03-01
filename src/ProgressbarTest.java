
import java.time.Duration;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProgressbarTest {
    @Test
    public void progressbar() {
        WebDriver browser = BrowserFactory.getBrowser("Chrome");
        browser.navigate().to("https://demoqa.com/progress-bar");
        WebElement startStopButton = browser.findElement(By.cssSelector("#startStopButton"));
        WebElement progressBar = browser.findElement(By.cssSelector("div[role='progressbar']"));
        String progressBarStatus = progressBar.getAttribute("aria-valuenow");

        startStopButton.click();
        WebElement wait = new WebDriverWait(browser, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#resetButton")));
        wait.click();

        if (progressBarStatus.equals("0")) {
            Assert.assertTrue(progressBarStatus, true);
        }
        browser.quit();
    }

}
