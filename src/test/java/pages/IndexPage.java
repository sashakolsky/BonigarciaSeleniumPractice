package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

    private final WebDriver driver;

    @FindBy(xpath = "//a[@href='mouse-over.html']")
    private WebElement mouseOverPageButton;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MouseOverPage getMouseOverPage() {
        mouseOverPageButton.click();
        return new MouseOverPage(driver);
    }
}