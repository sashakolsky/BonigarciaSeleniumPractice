package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class MouseOverPage {

    private static final String PAGE_URL = "mouse-over.html";

    private final String xpathForBadges = "//img[contains(@src, '%s')]";
    private final String xpathForHint = "//img[contains(@src, '%s')]/following-sibling::div";
    private final WebDriver driver;

    public MouseOverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MouseOverPage hoverOverElement(MouseOverType type) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.xpath(String.format(xpathForBadges, type.imageSrc)));
        actions.moveToElement(element).perform();
        return this;
    }

    public MouseOverPage verifyHintShown(MouseOverType type) {
        driver.findElement(By.xpath(String.format(xpathForHint, type.imageSrc))).isDisplayed();
        return this;
    }

    public WebElement getHint(MouseOverType type) {
        return driver.findElement(By.xpath(String.format(xpathForHint, type.imageSrc)));
    }

    public enum MouseOverType {
        COMPASS("compass.png"),
        CALENDAR("calendar.png"),
        AWARD("award.png"),
        LANDSCAPE("landscape.png");

        final String imageSrc;

        MouseOverType(String imageSrc) {
            this.imageSrc = imageSrc;
        }
    }

}
