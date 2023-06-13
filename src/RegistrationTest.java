
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.javafaker.Faker;

public class RegistrationTest {
    @Test
    public void createNewuser() {

        // Faker options
        Faker faker = new Faker(new Locale("pt-BR"));
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String password = faker.pokemon().name();
        String email = (firstName + lastName + "@gmail.com");
        String cellphone = ("+55" + faker.phoneNumber().cellPhone());

        // Chrome Options
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Coding....
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("#input-email"))
                .sendKeys(email.toLowerCase().replaceAll("[\\^\\`\\á\\í\\ó\\ú\\é\\ã\\ ]", ""));
        System.out.println(email);
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys(cellphone);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(password);
        System.out.println(password);
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys(password);

        // Assure that checkbox is selected before continue
        WebElement checkbox = driver.findElement(By.cssSelector("label[for='input-agree']"));
        boolean isSelected = checkbox.isSelected();
        if (isSelected == false) {
            checkbox.click();
        }
        driver.findElement(By.cssSelector("input[value='Continue']")).submit();

        // Asserts....
        Assert.assertTrue(driver.getCurrentUrl()
                .equals("https://ecommerce-playground.lambdatest.io/index.php?route=account/success"));
        Assert.assertTrue(driver.getPageSource().contains("Your Account Has Been Created!"));

        driver.quit();
    }

}