package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private WebDriver driver;
    private final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java";

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
